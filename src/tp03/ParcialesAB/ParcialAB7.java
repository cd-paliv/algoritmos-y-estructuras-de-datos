package tp03.ParcialesAB;

import tp03.ejercicio1.ArbolBinario;

public class ParcialAB7 {
	/*
	Sea un árbol binario de enteros positivos, realizar un recorrido pos orden para retornar el
		elemento que se encuentra a mayor profundidad. Dada una clase Java denominada
		BuscadorDeArbol, que tiene como variable de instancia un ArbolBinario<Integer> denominado
		arbol implemente en dicha clase el método public Integer buscar()
	 */
	
	private ArbolBinario<Integer> arbol;
	private int dato;
	
	public ParcialAB7(ArbolBinario<Integer> arbol) {
        this.arbol = arbol;
	}
	
	public Integer buscar() {
		buscar(this.arbol, this.arbol.altura());
		return dato;
	}
	private boolean buscar(ArbolBinario<Integer> ab, int prof) {
		if(prof == 0) {
			this.dato = ab.getDato();
			return true;
		}else {
			boolean encontre = false;
			if(ab.tieneHijoIzquierdo())
				encontre = buscar(ab.getHijoIzquierdo(), prof - 1);
			if(! encontre && ab.tieneHijoDerecho())
				encontre = buscar(ab.getHijoDerecho(), prof - 1);
			return encontre;
		}
	}
	
}
