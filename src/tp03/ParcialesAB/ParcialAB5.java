package tp03.ParcialesAB;

import tp02.ejercicio3.ColaGenerica;
import tp03.ejercicio1.ArbolBinario;

public class ParcialAB5 {
	/*
	Sea un arbol Arbol Binario de enteros, realizar un recorrido por niveles para retornar el
		primer elemento del ultimo nivel.
		Dada una clase Java denominada BuscadorDeArbol, que tiene como variable de
		instancia un ArbolBinario<Integer> denominado arbol implemente en dicha clase el
		método public Integer buscarPrimerElementoUltimoNivel().

	 */
	
	private ArbolBinario<Integer> arbol;
	
	public ParcialAB5(ArbolBinario<Integer> arbol) {
		this.arbol = arbol;
	}
	
	public Integer buscarPrimerElementoUltimoNivel() {
		if(! this.arbol.esVacio())
			return buscarPrimerElementoUltimoNivel(this.arbol);
		return -1;
	}
	private Integer buscarPrimerElementoUltimoNivel(ArbolBinario<Integer> ab) {
		ArbolBinario<Integer> arbol = null;
		ColaGenerica<ArbolBinario<Integer>> cola = new ColaGenerica<ArbolBinario<Integer>>();
		int nivelAct = 0;
		cola.encolar(ab);
		cola.encolar(null);
		while (! cola.esVacia()) {
			arbol = cola.desencolar();
			if (arbol != null) {
				if (arbol.tieneHijoIzquierdo())
					cola.encolar(arbol.getHijoIzquierdo());
				if (arbol.tieneHijoDerecho())
					cola.encolar(arbol.getHijoDerecho());
			} else if (! cola.esVacia()) {
				nivelAct++;
				if(nivelAct == ab.altura())
					return cola.desencolar().getDato();
				cola.encolar(null);
			}
		}
		return -1;
	}

}
