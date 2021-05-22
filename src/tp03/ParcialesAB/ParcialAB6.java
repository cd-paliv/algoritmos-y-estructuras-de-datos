package tp03.ParcialesAB;

import tp02.ejercicio3.ColaGenerica;
import tp03.ejercicio1.ArbolBinario;

public class ParcialAB6 {
	/*
	Dada una clase Java denominada BuscadorDeArbol, que tiene como variable de instancia un
		ArbolBinario<Integer>denominado arbolimplemente en dicha clase el método public Integer
		buscar(). Al encontrar el primer primo debe cortar la ejecución.
		Considere que existe dentro de la definición de la clase el método esPrimo(Integer num)
		que retorna true si el número pasado como parámetro es primo o false en caso contrario.
		Realizar un recorrido por niveles para retornar el primer elemento primo del árbol.
	 */

	private ArbolBinario<Integer> arbol;
	
	public ParcialAB6(ArbolBinario<Integer> arbol) {
		this.arbol = arbol;
	}
	
	public Integer buscar() {
		if(! this.arbol.esVacio())
			return buscar(this.arbol);
		return -1;
	}
	private Integer buscar(ArbolBinario<Integer> ab) {
		ArbolBinario<Integer> arbol = null;
		ColaGenerica<ArbolBinario<Integer>> cola = new ColaGenerica<ArbolBinario<Integer>>();
		cola.encolar(ab);
		cola.encolar(null);
		while (! cola.esVacia()) {
			arbol = cola.desencolar();
			if (arbol != null) {
				if(esPrimo(arbol.getDato()))
					return arbol.getDato();
				if (arbol.tieneHijoIzquierdo())
					cola.encolar(arbol.getHijoIzquierdo());
				if (arbol.tieneHijoDerecho())
					cola.encolar(arbol.getHijoDerecho());
			} else if (! cola.esVacia()) {
				cola.encolar(null);
			}
		}
		return -1;
	}
	
	private boolean esPrimo(Integer numero) {
		if (numero == 0 || numero == 1 || numero == 2 || numero == 4) {
			return false;
		}
		for (int x = 2; x < numero / 2; x++) {
			if (numero % x == 0)
				return false;
		}
		return true;
	}
	

}
