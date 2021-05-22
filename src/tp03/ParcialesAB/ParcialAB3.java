package tp03.ParcialesAB;

import tp03.ejercicio1.ArbolBinario;

public class ParcialAB3 {

	/*
	Dada una clase ContadorArbol cuya función principal es proveer métodos de conteo
		sobre AB de nros enteros y que tiene como variable de instancia un
		ArbolBinario<Integer> denominado arbol implemente en dicha clase el método
		"public int contadorOcurrencias(int elem)" que retorne la cant de ocurrencias
		del elemento pasado por parámetro.
		Implemente un recorrido postorden.
	 */
	
	private ArbolBinario<Integer> arbol;
	
	public ParcialAB3(ArbolBinario<Integer> arbol) {
		this.arbol = arbol;
	}
	
	
	public int contadorOcurrencias(int elem) {
		if(this.arbol.esVacio()) return 0;
		else return contadorOcurrencias(this.arbol, elem);
	}
	
	private int contadorOcurrencias(ArbolBinario<Integer> ab, int elem) {
		int cont = 0;
		if(ab.tieneHijoIzquierdo()) {
			cont += contadorOcurrencias(ab.getHijoIzquierdo(), elem);
		}
		if(ab.tieneHijoDerecho()) {
			cont += contadorOcurrencias(ab.getHijoDerecho(), elem);
		}
		if(ab.getDato() == elem)
			cont++;
		return cont;
	}

}
