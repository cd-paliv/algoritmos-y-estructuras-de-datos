package tp03.ejercicio1;

import tp02.ejercicio3.PilaGenerica;

//NO TERMINADO NO BIEN HECHO CUIDAO!!!!!!!!!!!!

public class ArbolBinarioExpresion extends ArbolBinario<Character>{
	private Character dato;
	private ArbolBinarioExpresion hijoIzquierdo;   
	private ArbolBinarioExpresion hijoDerecho; 
	
	public ArbolBinarioExpresion() {
		super();
	}
	public ArbolBinarioExpresion(Character dato) {
		super();
		this.hijoIzquierdo = (ArbolBinarioExpresion)super.getHijoIzquierdo();
		this.hijoDerecho = (ArbolBinarioExpresion)super.getHijoDerecho();
		this.dato = dato;
	}/*
	public ArbolBinarioExpresion(ArbolBinarioExpresion ab) {
		super();
		this.hijoDerecho = ab.hijoDerecho;
		this.hijoIzquierdo = ab.hijoIzquierdo;
		this.dato = ab.getDato();
	}*/
	
	public Character getDato() {
		return dato;
	}
	public void setDato(Character dato) {
		this.dato = dato;
	}
	public ArbolBinarioExpresion getHijoIzquierdo() {
		return hijoIzquierdo;
	}
	public void setHijoIzquierdo(ArbolBinarioExpresion hijoIzquierdo) {
		this.hijoIzquierdo = hijoIzquierdo;
	}
	public ArbolBinarioExpresion getHijoDerecho() {
		return hijoDerecho;
	}
	public void setHijoDerecho(ArbolBinarioExpresion hijoDerecho) {
		this.hijoDerecho = hijoDerecho;
	}
	
	public ArbolBinarioExpresion convertirPostfija(String exp) {
		Character c = null;
		ArbolBinarioExpresion result;
		PilaGenerica<ArbolBinarioExpresion> p = new PilaGenerica<ArbolBinarioExpresion>();
		for (int i = 0; i < exp.length(); i++) {
			c = exp.charAt(i);
			result = new ArbolBinarioExpresion(c);
			if ((c == '+') || (c == '-') || (c == '/') || (c == '*')) {
				// Es operador
				result.agregarHijoDerecho(p.desapilar());
				result.agregarHijoIzquierdo(p.desapilar ());
			}
			p.apilar(result);
		}
		return p.desapilar();
	}
	
	public ArbolBinarioExpresion convertirPrefija(StringBuffer exp) {
		char c = exp.charAt(0);
		ArbolBinarioExpresion result = new ArbolBinarioExpresion(c);
		if ((c == '+') || (c == '-') || (c == '/') || (c == '*')) {
			// es operador
			result.agregarHijoIzquierdo(this.convertirPrefija(exp.delete(0,1)));
			result.agregarHijoDerecho(this.convertirPrefija(exp.delete(0,1)));
		}
		return result; // es operando
	}
	
	public ArbolBinarioExpresion convertirInfija(String exp) {
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
		ArbolBinarioExpresion ab = new ArbolBinarioExpresion();
		ab = ab.convertirPostfija(postfija);
		return ab;
	}
	
	public static Integer evaluar(ArbolBinarioExpresion arbol) {
		ArbolBinarioExpresion a = new ArbolBinarioExpresion();
		a = arbol;
		return evaluar_private(a);
	}
	private static Integer evaluar_private(ArbolBinarioExpresion arbol) {
		Character c = arbol.getDato();
		// es operador
		if ((c == '+') || (c == '-') || (c == '/') || c == '*') {
			int operador_1 = evaluar_private(arbol.getHijoIzquierdo());
			int operador_2 = evaluar_private(arbol.getHijoDerecho());
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
	
	public static void imprimirInfijo(ArbolBinarioExpresion ab) {
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

}
