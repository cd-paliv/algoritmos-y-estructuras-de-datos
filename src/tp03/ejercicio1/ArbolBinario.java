package tp03.ejercicio1;
import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp02.ejercicio3.ColaGenerica;
import tp02.ejercicio3.PilaGenerica;

public class ArbolBinario<T> {
	private T dato;
	private ArbolBinario<T> hijoIzquierdo;   
	private ArbolBinario<T> hijoDerecho; 

	
	public ArbolBinario() {
		super();
	}

	public ArbolBinario(T dato) {
		this.dato = dato;
	}

	/*
	 * getters y setters
	 * 
	 */
	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}
	
	/**
	 * Preguntar antes de invocar si tieneHijoIzquierdo()
	 * @return
	 */
	public ArbolBinario<T> getHijoIzquierdo() {
		return this.hijoIzquierdo;
	}

	public ArbolBinario<T> getHijoDerecho() {
		return this.hijoDerecho;

	}

	public void agregarHijoIzquierdo(ArbolBinario<T> hijo) {
		this.hijoIzquierdo = hijo;
	}

	public void agregarHijoDerecho(ArbolBinario<T> hijo) {
		this.hijoDerecho = hijo;
	}

	public void eliminarHijoIzquierdo() {
		this.hijoIzquierdo = null;
	}

	public void eliminarHijoDerecho() {
		this.hijoDerecho = null;
	}

	public boolean esVacio() {
		return this.getDato() == null && !this.tieneHijoIzquierdo() && !this.tieneHijoDerecho();
	}

	public boolean esHoja() {
		return (!this.tieneHijoIzquierdo() && !this.tieneHijoDerecho());

	}

	@Override
	public String toString() {
		return this.getDato().toString();
	}

	 
	public boolean tieneHijoIzquierdo() {
		return this.hijoIzquierdo!=null;
	}

	 
	public boolean tieneHijoDerecho() {
		return this.hijoDerecho!=null;
	}

	

	public boolean esLleno() {
		boolean lleno = true;
		ArbolBinario<T> arbol = null;
		ColaGenerica<ArbolBinario<T>> cola = new ColaGenerica<ArbolBinario<T>>();
		cola.encolar(this); //encolo todo el arbol
		int cant_nodos = 0;
		cola.encolar(null);
		int nivel = 0;
		while (!cola.esVacia() && lleno) {
			arbol = cola.desencolar();
			if (arbol != null) {
				if (arbol.tieneHijoIzquierdo()) {
					cola.encolar(arbol.getHijoIzquierdo());
					cant_nodos++;
				}
				if (arbol.tieneHijoDerecho()) {
					cola.encolar(arbol.getHijoDerecho());
					cant_nodos++;
				}
			} else if (!cola.esVacia()) {
				if (cant_nodos == Math.pow(2, ++nivel)) {
					cola.encolar(null);
					cant_nodos = 0;
				} else lleno = false;
			}
		}
		return lleno;
	}

	public boolean esCompleto() {/*
		boolean completo = true;
		int h = this.altura();
		if(h > 0) {
			boolean lleno = true;
			ArbolBinario<T> arbol = null;
			ColaGenerica<ArbolBinario<T>> cola = new ColaGenerica<ArbolBinario<T>>();
			cola.encolar(this);
			int cant_nodos = 0;
			cola.encolar(null);
			int nivel = 0;
			while (!cola.esVacia() && lleno && nivel < h-1) { //es lleno en h-1
				arbol = cola.desencolar();
				if (arbol != null) {
					if (arbol.tieneHijoIzquierdo()) {
						cola.encolar(arbol.getHijoIzquierdo());
						cant_nodos++;
					}
					if (arbol.tieneHijoDerecho()) {
						cola.encolar(arbol.getHijoDerecho());
						cant_nodos++;
					}
				} else if (!cola.esVacia()) {
					if (cant_nodos == Math.pow(2, ++nivel)) {
						cola.encolar(null);
						cant_nodos = 0;
					} else lleno = false;
				}
			}
			if(lleno) { //si es lleno en h-2, proceso h-1 para verificar que sea completo
				boolean esPrimerElemento = true, encontreHoja = false;
				while(! cola.esVacia() && completo) {
					arbol = cola.desencolar();
					if(arbol.esHoja()) encontreHoja = true; //si el dato que tengo es hoja, todos los hermanos a su derecha tienen que ser hojas, sino no están completos
					if(arbol != null) {
						if(arbol.tieneHijoDerecho() && ! arbol.tieneHijoIzquierdo())
							return false;
						if(esPrimerElemento) {
							if(arbol.esHoja()) return false; //si el 1er elem en h-1 es hoja significa que el último nivel está en otro nodo, por lo cual no es completo
							esPrimerElemento = false;
						}
						if(encontreHoja)
							if(! arbol.esHoja()) return false; //si el dato que tengo es hoja, todos los hermanos a su derecha tienen que ser hojas, sino no está completos
						
					}else if(! cola.esVacia()) {
						cola.encolar(null);
						esPrimerElemento = true;
						
					}else completo = false;
				}
			}*/
		//}
		return false;

	}
	 
	public ArbolBinario<T> clonar() {
		if(this.esVacio()) {
			return null;
		}else {
			ArbolBinario<T> clon = clonar_priv(this);
			return clon;
		}
	}
	private ArbolBinario<T> clonar_priv(ArbolBinario<T> a) {
		ArbolBinario<T> clon;

		ArbolBinario<T> clonIzq = null, clonDer = null;
		if(a.tieneHijoIzquierdo())
			clonIzq = clonar_priv(a.getHijoIzquierdo());
		if(a.tieneHijoDerecho())
			clonDer = clonar_priv(a.getHijoDerecho());
		
		clon = new ArbolBinario<T>(a.getDato());
		clon.agregarHijoIzquierdo(clonIzq);
		clon.agregarHijoDerecho(clonDer);
		return clon;
	}

	
	// imprime el Ã¡rbol en preorden  
	public void printPreorden() {
		System.out.print(this.getDato() + " ");
		if (this.tieneHijoIzquierdo()) {
			this.getHijoIzquierdo().printPreorden();
		}
		if (this.tieneHijoDerecho()) {
			this.getHijoDerecho().printPreorden();
		}
	}

	// imprime el ï¿½rbol en postorden
	public void printPostorden() {
		if (this.tieneHijoIzquierdo()) {
			this.getHijoIzquierdo().printPostorden();
		}
		if (this.tieneHijoDerecho()) {
			this.getHijoDerecho().printPostorden();
		}
		System.out.print(this.getDato() + " ");
	}
	
	//imprime el árbol en inorden
	public void printInorden() {
		if (this.tieneHijoIzquierdo()) {
			this.getHijoIzquierdo().printInorden();
		}
		System.out.print(this.getDato() + " ");
		if (this.tieneHijoDerecho()) {
			this.getHijoDerecho().printInorden();
		}
	}


	public void recorridoPorNiveles() {
		ArbolBinario<T> arbol = null;
		ColaGenerica<ArbolBinario<T>> cola = new ColaGenerica<ArbolBinario<T>>();
		cola.encolar(this);
		cola.encolar(null);
		while (! cola.esVacia()) {
			arbol = cola.desencolar();
			if (arbol != null) {
				System.out.print(arbol.getDato() + " ");
				if (arbol.tieneHijoIzquierdo())
					cola.encolar(arbol.getHijoIzquierdo());
				if (arbol.tieneHijoDerecho())
					cola.encolar(arbol.getHijoDerecho());
			} else if (! cola.esVacia()) {
				System.out.println();
				cola.encolar(null);
			}
		}
	}
	
	public void entreNiveles(int n, int m) {
		ArbolBinario<T> arbol = null;
		ColaGenerica<ArbolBinario<T>> cola = new ColaGenerica<ArbolBinario<T>>();
		int nivel = 0;
		cola.encolar(this);
		cola.encolar(null);
		while (! cola.esVacia() && nivel <= m) {
			arbol = cola.desencolar();
			if (arbol != null) {
				if (nivel >= n)
					System.out.print(arbol.getDato() + " ");
				if (arbol.tieneHijoIzquierdo())
					cola.encolar(arbol.getHijoIzquierdo());
				if (arbol.tieneHijoDerecho())
					cola.encolar(arbol.getHijoDerecho());
			} else if (!cola.esVacia()) {
				System.out.println();
				nivel++;
				cola.encolar(null);
			}
		}
	}
	
	public boolean esArbolPar() {
		ArbolBinario<T> arbol = null;
		ColaGenerica<ArbolBinario<T>> cola = new ColaGenerica<ArbolBinario<T>>();
		int sumaNivel = 0; boolean esPar = true;
		cola.encolar(this);
		cola.encolar(null);
		while (! cola.esVacia() && esPar) {
			arbol = cola.desencolar();
			if (arbol != null) {
				sumaNivel += (Integer) arbol.getDato();
				if (arbol.tieneHijoIzquierdo())
					cola.encolar(arbol.getHijoIzquierdo());
				if (arbol.tieneHijoDerecho())
					cola.encolar(arbol.getHijoDerecho());
			} else if (sumaNivel % 2 != 0) {
				esPar = false; //NO es par, corto while
				}else if (! cola.esVacia()) {
					cola.encolar(null);
					sumaNivel = 0;
			}
		}
		return esPar;
	}
	
	public ArbolBinario<T> espejo() {
		if (!this.tieneHijoDerecho() && !this.tieneHijoIzquierdo())
			return this;
		ArbolBinario<T> aux = this.hijoIzquierdo;
		this.agregarHijoIzquierdo(this.hijoDerecho);
		this.agregarHijoDerecho(aux);
		if (this.tieneHijoIzquierdo())
			this.getHijoIzquierdo().espejo();
		if (this.tieneHijoDerecho())
			this.getHijoDerecho().espejo();
		return this;
	}

	
	public ListaGenerica<T> frontera() {
		ListaGenerica<T> l = new ListaEnlazadaGenerica<T>();

		return l;
	}

	
	public int contarHojas() {
		int cont = 0;
		if (!this.tieneHijoDerecho() && !this.tieneHijoIzquierdo())
			return 1;
		if (this.tieneHijoIzquierdo())
			cont += this.getHijoIzquierdo().contarHojas();
		if (this.tieneHijoDerecho())
			cont += this.getHijoDerecho().contarHojas();

		return cont;
	}

	public int contarNodos() {
		int cont = 1;
		if (this.tieneHijoIzquierdo())
			cont += this.getHijoIzquierdo().contarNodos();
		if (this.tieneHijoDerecho())
			cont += this.getHijoDerecho().contarNodos();

		return cont;
	}
	
	public int altura() {
		int izq = 0, der = 0;
		if(this.tieneHijoIzquierdo())
			izq = 1 + this.getHijoIzquierdo().altura();
		if(this.tieneHijoDerecho()) {
			der = 1 + this.getHijoDerecho().altura();
		}
		if(izq < der) return der;
		else return izq;
	}
	
	public Integer getMaximo() {
		return calcularMaxAB(this);
	}
	private Integer calcularMaxAB(ArbolBinario<T> ab) {
		if(ab.esVacio()) return 0;
		else if(ab.esHoja()) return (Integer)ab.getDato();
		else {
			int aux = (Integer)ab.getDato();
			int izq = 0, der = 0;
			if(ab.tieneHijoIzquierdo())
				izq = calcularMaxAB(ab.getHijoIzquierdo());
			if(ab.tieneHijoDerecho())
				der = calcularMaxAB(ab.getHijoDerecho());
			return Math.max(aux, Math.max(izq, der));
		}
	}
	
	public Integer getMinimo() {
		return calcularMinAB(this);
	}
	private Integer calcularMinAB(ArbolBinario<T> ab) {
		if(ab.esVacio()) return 0;
		else if(ab.esHoja()) return (Integer)ab.getDato();
		else {
			int aux = (Integer)ab.getDato();
			int izq = 0, der = 0;
			if(ab.tieneHijoIzquierdo())
				izq = calcularMinAB(ab.getHijoIzquierdo());
			if(ab.tieneHijoDerecho())
				der = calcularMinAB(ab.getHijoDerecho());
			return Math.min(aux, Math.min(izq, der));
		}
	}
	
	public static boolean esAFN(ArbolBinario<Frecuencia> ab) {
		if (!ab.esHoja()) {
			int valor = 0;
			if (ab.tieneHijoIzquierdo()) {
				valor = (ab.getHijoIzquierdo().getDato().getValor());
			}
			if (ab.tieneHijoDerecho()) {
				valor = valor + (ab.getHijoDerecho().getDato().getValor());
			}
			if (ab.getDato().getValor() == valor) {
				if (ab.tieneHijoIzquierdo()) {
					if (!esAFN(ab.getHijoIzquierdo())) return false;
				}
				if (ab.tieneHijoDerecho()) {
					if (!esAFN(ab.getHijoDerecho())) return false;
				}
			} else return false;
		}
		return true;
	}
	
	public static boolean esAFNIterativo(ArbolBinario<Frecuencia> a) {
		ArbolBinario<Frecuencia> arbol = null;
		ColaGenerica<ArbolBinario<Frecuencia>> cola = new ColaGenerica<ArbolBinario<Frecuencia>>();
		boolean sigue = true;
		cola.encolar(a);
		while (! cola.esVacia() && sigue) {
			arbol = cola.desencolar();
			int val_padre = 0;
			int val_hijos = 0;
			if (arbol != null) {
				val_padre = arbol.getDato().getValor();
				val_hijos = 0;
				if (arbol.tieneHijoIzquierdo()) {
					cola.encolar(arbol.getHijoIzquierdo());
					val_hijos = arbol.getHijoIzquierdo().getDato().getValor();
				}
				if (arbol.tieneHijoDerecho()) {
					cola.encolar(arbol.getHijoDerecho());
					val_hijos = val_hijos + arbol.getHijoDerecho().getDato().getValor();
				}
				if (! arbol.esHoja() && val_padre != val_hijos)
					sigue = false;
			}
		}
		return sigue;
	}


	
	
	//-------------------------------------------------------------------------------------------------------------------------------------
	//ARBOL BINARIO DE EXPRESION
	//-------------------------------------------------------------------------------------------------------------------------------------

	public ArbolBinario<Character> convertirPostfija(String exp) {
		Character c = null;
		ArbolBinario<Character> result;
		PilaGenerica<ArbolBinario<Character>> p = new PilaGenerica<ArbolBinario<Character>>();
		for (int i = 0; i < exp.length(); i++) {
			c = exp.charAt(i);
			result = new ArbolBinario<Character>(c);
			if ((c == '+') || (c == '-') || (c == '/') || (c == '*')) {
				// Es operador
				result.agregarHijoDerecho(p.desapilar());
				result.agregarHijoIzquierdo(p.desapilar ());
			}
			p.apilar(result);
		}
		return p.desapilar();
	}
	
	public ArbolBinario<Character> convertirPrefija(StringBuffer exp) {
		char c = exp.charAt(0);
		ArbolBinario<Character> result = new ArbolBinario<Character>(c);
		if ((c == '+') || (c == '-') || (c == '/') || (c == '*')) {
			// es operador
			result.agregarHijoIzquierdo(this.convertirPrefija(exp.delete(0,1)));
			result.agregarHijoDerecho(this.convertirPrefija(exp.delete(0,1)));
		}
		return result; // es operando
	}
	
	public ArbolBinario<Character> convertirInfija(String exp) {
		String postfija = "";
		PilaGenerica<Character> p = new PilaGenerica<Character>();
		for (int i = 0; i < exp.length(); i++) {
			char c = exp.charAt(i);
			if(c >= '0' && c <= '9')
				postfija += c;
			if((c == '+') || (c == '-') || (c == '/') || (c == '*'))
				p.apilar(c);
			if(c == ')')
				postfija += p.desapilar();
		}
		while(! p.esVacia()) postfija += p.desapilar();
		ArbolBinario<Character> ab = new ArbolBinario<Character>();
		return ab.convertirPostfija(postfija);
	}
	
	public static Integer evaluarExpresion(ArbolBinario<Character> arbol) {
		Character c = arbol.getDato();
		// es operador
		if ((c == '+') || (c == '-') || (c == '/') || c == '*') {
			int operador_1 = evaluarExpresion(arbol.getHijoIzquierdo());
			int operador_2 = evaluarExpresion(arbol.getHijoDerecho());
			switch (c) {
				case '+':
					return operador_1 + operador_2;
				case '-':
					return operador_1 - operador_2;
				case '*':
					return operador_1 * operador_2;
				case '/':
					return operador_1 / operador_2;
			}
		}
		// es operando
		return Integer.parseInt(c.toString());
	}
	
	public static void imprimirInfijo(ArbolBinario<Character> ab) {
		if(! ab.esVacio()) {
			Character c = ab.getDato();
			if((c == '+') || (c == '-') || (c == '/') || (c == '*'))
				System.out.print("( ");
			if(ab.tieneHijoIzquierdo())
				imprimirInfijo(ab.getHijoIzquierdo());
			System.out.print(ab.getDato() + " ");
			if(ab.tieneHijoIzquierdo())
				imprimirInfijo(ab.getHijoDerecho());
			if((c == '+') || (c == '-') || (c == '/') || (c == '*'))
				System.out.print(") ");
		}
	}


	//-------------------------------------------------------------------------------------------------------------------------------------
	//COLA DE PRIORIDADES
	//-------------------------------------------------------------------------------------------------------------------------------------

}
