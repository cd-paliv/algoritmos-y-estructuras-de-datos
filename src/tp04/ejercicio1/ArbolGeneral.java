package tp04.ejercicio1;
import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp02.ejercicio3.ColaGenerica;

public class ArbolGeneral<T> {
	private T dato;
	private ListaGenerica<ArbolGeneral<T>> hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();

	public T getDato() {
		return dato;
	}
	public void setDato(T dato) {
		this.dato = dato;
	}
	
	public void setHijos(ListaGenerica<ArbolGeneral<T>> hijos) {
		if (hijos==null)
			this.hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();
		else
			this.hijos = hijos;
	}

	public ArbolGeneral() {
		this.dato = null;
		this.hijos = null;
	}
	
	public ArbolGeneral(T dato) {
		this.dato = dato;
	}

	public ArbolGeneral(T dato, ListaGenerica<ArbolGeneral<T>> hijos) {
		this(dato);
		if (hijos==null)
			this.hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();
		else
			this.hijos = hijos;
	}

	public ListaGenerica<ArbolGeneral<T>> getHijos() {
		return this.hijos;
	}

	public void agregarHijo(ArbolGeneral<T> unHijo) {
		this.getHijos().agregarFinal(unHijo);
	}

	public boolean esHoja() {
		return !this.tieneHijos();
	}
	
	public boolean tieneHijos() {
		return !this.hijos.esVacia();
	}
	
	public boolean esVacio() {
		return this.dato == null && !this.tieneHijos();
	}

	

	public void eliminarHijo(ArbolGeneral<T> hijo) {
		if (this.tieneHijos()) {
			ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
			if (hijos.incluye(hijo)) 
				hijos.eliminar(hijo);
		}
	}
	
	public int contarHojas() {
		if (this.esHoja()) return 1;
		else {
			int cont = 0;
			ListaGenerica<ArbolGeneral<T>> lista = this.getHijos();
			lista.comenzar();
			while (! lista.fin()) {
				ArbolGeneral<T> arbol = lista.proximo();
				cont = cont + arbol.contarHojas();
			}
			return cont;
		}
	}

	
	//devuelve una lista con los elementos del árbol por niveles (A -> BC -> DEF)
	public ListaGenerica<String> recorrido() {
		ListaEnlazadaGenerica<String> resultado = new ListaEnlazadaGenerica<String>();
		ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<ArbolGeneral<T>>();
		String aux = "";

		cola.encolar(this);
		cola.encolar(null);
		while (!cola.esVacia()) {
			ArbolGeneral<T> a = cola.desencolar();
			if (a != null) {
				aux = aux + a.getDato();
				ListaGenerica<ArbolGeneral<T>> hijos = a.getHijos();
				hijos.comenzar();
				while (!hijos.fin()) {
					cola.encolar(hijos.proximo());
				}
			} else {
				resultado.agregarFinal(aux);
				if (!cola.esVacia()) {
					aux = "";
					cola.encolar(null);
				}
			}
		}
		return resultado;
	}
	
	//Ej3
	public ListaEnlazadaGenerica<T> preOrden() {
		ListaEnlazadaGenerica<T> order = new ListaEnlazadaGenerica<T>();
		if(! this.esVacio())
			preOrden(order);
		return order;
	}
	private void preOrden(ListaEnlazadaGenerica<T> lista) {
		lista.agregarFinal(this.getDato()); //1ero raiz
		ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
		hijos.comenzar();
		while (! hijos.fin()) //izq y der
			hijos.proximo().preOrden(lista);
	}
	
	public ListaEnlazadaGenerica<T> postOrden() {
		ListaEnlazadaGenerica<T> posto = new ListaEnlazadaGenerica<T>();
		if(! this.esVacio())
			postOrden(posto);
		return posto;
	}
	private void postOrden(ListaEnlazadaGenerica<T> lista) {
		ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
		hijos.comenzar();
		if(! this.esHoja()) { //si es hoja, la var "hijos" es null
			//ArbolGeneral<T> HI = hijos.proximo();
			hijos.proximo().postOrden(lista); //1ero izq
		}
		while(! hijos.fin()) {
			//ArbolGeneral<T> HSig = hijos.proximo();
			hijos.proximo().postOrden(lista); //der
		}
		lista.agregarFinal(this.getDato()); //raiz
	}
	
	public ListaEnlazadaGenerica<T> inOrden() {
		ListaEnlazadaGenerica<T> inor = new ListaEnlazadaGenerica<T>();
		if(! this.esVacio())
			inOrden(inor);
		return inor;
	}
	private void inOrden(ListaEnlazadaGenerica<T> lista) {
		ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
		hijos.comenzar();
		if(! this.esHoja()) {
			hijos.proximo().inOrden(lista); //el 1er hijo
		}
		lista.agregarFinal(this.getDato()); //raiz
		while(! hijos.fin()) {
			hijos.proximo().inOrden(lista); //el resto de hijos
		}
		
	}
	
	public ListaEnlazadaGenerica<T> recorridoPorNiveles() {
		ListaEnlazadaGenerica<T> recorrido = new ListaEnlazadaGenerica<T>();
		ArbolGeneral<T> arbol;
		ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<ArbolGeneral<T>>();
		recorrido.agregarFinal(this.dato); //raiz
		cola.encolar(this);
		cola.encolar(null);
		while(! cola.esVacia()){
			arbol = cola.desencolar();
			if(arbol != null) {
				ListaGenerica<ArbolGeneral<T>> hijos = arbol.getHijos();
				hijos.comenzar();
				while(! hijos.fin()){
					arbol = hijos.proximo();
					cola.encolar(arbol);
					recorrido.agregarFinal(arbol.dato);
				}
			}else {
				if (! cola.esVacia())
					cola.encolar(null);
			}
		}
		
		return recorrido;
	}
	
	public void recorridoPorNivelesImprimir() {
		ArbolGeneral<T> arbol;
		ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<ArbolGeneral<T>>();
		cola.encolar(this);
		cola.encolar(null);
		while(! cola.esVacia()){
			arbol = cola.desencolar();
			if(arbol != null) {
				System.out.print(arbol.dato + " ");
				ListaGenerica<ArbolGeneral<T>> hijos = arbol.getHijos();
				hijos.comenzar();
				while(! hijos.fin()){
					cola.encolar(hijos.proximo());
				}
			}else if (! cola.esVacia()) {
				System.out.println();
				cola.encolar(null);
			}
		}
	}
	
	
	//Ej4
	
	/*a. devuelve la altura del árbol, es decir, la longitud del camino más
			largo desde el nodo raíz hasta una hoja.*/
	public Integer altura() {
		if(this.esHoja()) return 0; //"Las hojas tienen altura cero"
		else{
			int altura;
			int max = -1;
			ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
			hijos.comenzar();
			while(! hijos.fin()){
				altura = 1;
				altura += hijos.proximo().altura(); //calculo la alt de CADA hijo (y sus hijos, etc)
				if(altura > max){
					max = altura;
				}
			}
			return max;
		}
	}
	
	/*b. devuelve la profundidad o nivel del dato en el árbol. El nivel de
			un nodo es la longitud del único camino de la raíz al nodo */
	public Integer nivel(T dato) {
		if(this.dato == dato) return 0; //si el dato está en la raíz su nivel es 0
		else {
			ArbolGeneral<T> arbol = new ArbolGeneral<T>();
			ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<ArbolGeneral<T>>();
			boolean encontre = false;
			int nivel = 0;
			cola.encolar(this);
			cola.encolar(null);
			while( (! cola.esVacia()) && (! encontre) ) {
				arbol = cola.desencolar();
				if(arbol != null) {
					if(arbol.dato == dato)
						encontre = true;
					else {
						ListaGenerica<ArbolGeneral<T>> hijos = arbol.getHijos();
						hijos.comenzar();
						while(! hijos.fin()){
							cola.encolar(hijos.proximo());
						}
					}
				}else {
					if( (! cola.esVacia()) && (! encontre) ) {
						nivel++;
						cola.encolar(null);
					}
				}
			}
			if(! encontre) nivel = -1;
			return nivel;
		}
	}
	/* NIVEL EN FORMA RECURSIVA: (me lo pasaron)
	public int nivelRec(T dato){
		int altura = 0;
		boolean encontre = this.getDato().equals(dato);
		if(encontre)
			return 0;
		else{
			ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
			hijos.comenzar();
			while(! hijos.fin()){
				altura = hijos.proximo().nivelRec(dato);
				if(altura >= -1)
					return altura + 1;
			}
			return -1;
		}
	}*/

	/*c. la amplitud (ancho) de un árbol se define como la cantidad de
			nodos que se encuentran en el nivel que posee la mayor cantidad de nodos */
	public Integer ancho() {
		ArbolGeneral<T> arbol;
		ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<ArbolGeneral<T>>();
		int cant_nodos = 0, max = -1;
		cola.encolar(this);
		cola.encolar(null);
		while(! cola.esVacia()){
			arbol = cola.desencolar();
			if(arbol != null) {
				ListaGenerica<ArbolGeneral<T>> hijos = arbol.getHijos();
				hijos.comenzar();
				while(! hijos.fin()){
					cola.encolar(hijos.proximo());
					cant_nodos++; //voy sumando cada nodo para obtener el total del nivel
				}
			}else {
				if(cant_nodos > max)
					max = cant_nodos;
				cant_nodos = 0; //reinicio el contador para el próximo nivel
				if (! cola.esVacia())
					cola.encolar(null);
			}
		}
		return max;
	}
	
	//Ej6
	public boolean esAncestro(T a, T b){
		boolean es = false;
		if(this.getDato() == a) {
			es = esAncestroAux(this, b); //si encuentro a, busco b entre sus hijos
		}else {
			if(! this.esHoja()) {
				ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
				hijos.comenzar();
				while( (! hijos.fin()) && (! es) ) {
					es = hijos.proximo().esAncestro(a, b);
				}
			}else return false;
		}
		return es;
	}
	private boolean esAncestroAux(ArbolGeneral<T> arbol, T b) {
		boolean encontre = false;
		if(arbol.getDato() == b) {
			return true;
		}
		ListaGenerica<ArbolGeneral<T>> hijos = arbol.getHijos();
		hijos.comenzar();
		while( (! hijos.fin()) && (! encontre) ) {
			encontre = esAncestroAux(hijos.proximo(), b);
		}
		return encontre;
	}

}