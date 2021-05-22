package tp03.ParcialesAB;

import tp03.ejercicio1.ArbolBinario;

public class ParcialAB4 {
	/*
	Sea un AB de enteros, realizar un recorrido inorden para retornar el menor de
		los elementos. Dada una clase BuscadorDeArbol que tiene como vi un AB<Integer>
		denominado arbol, implemente el método "public Integer buscar()".
	 */
	
	private ArbolBinario<Integer> arbol;
	
	public ParcialAB4(ArbolBinario<Integer> arbol) {
		this.arbol = arbol;
	}
	
	public Integer buscar() {
		if(! this.arbol.esVacio()) {
			return buscar(this.arbol);
		}else return Integer.MAX_VALUE;
	}
	private Integer buscar(ArbolBinario<Integer> a) {
		int min = Integer.MAX_VALUE;
		if(a.tieneHijoIzquierdo()) {
			min = Math.min(buscar(a.getHijoIzquierdo()), min);
		}
		min = Math.min(a.getDato(), min); //raíz
		if(a.tieneHijoDerecho()) {
			min = Math.min(buscar(a.getHijoDerecho()), min);
		}
		return min;
	}

}
