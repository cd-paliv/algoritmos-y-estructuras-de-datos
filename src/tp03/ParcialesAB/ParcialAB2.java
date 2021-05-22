package tp03.ParcialesAB;

import tp03.ejercicio1.ArbolBinario;

public class ParcialAB2 {
	/*
	Implemente el método esMonodistante(int k):boolean que devuelve true si el
		árbol es monodistante de mandato k y false en caso contrario.
		Un AB de enteros es monodistante de mandato si la suma de los valores de
		los nodos, de cada camino que va desde la raíz a una hoja, es igual a k.
		Realice un recorrido preorden.
	 */
	
	private ArbolBinario<Integer> arbol;
	
	public ParcialAB2(ArbolBinario<Integer> arbol) {
		this.arbol = arbol;
	}
	
	public boolean esMonodistante(int k) {
		if(this.arbol.esVacio()) return false;
		else return esMono_priv(this.arbol, k);
	}
	private boolean esMono_priv(ArbolBinario<Integer> ab, int k) {
		boolean ok = false;
		if(ab.esHoja()) return ab.getDato() - k == 0;
		else {
			if(ab.tieneHijoIzquierdo() && k > 0)
				ok = esMono_priv(ab.getHijoIzquierdo(), k-ab.getDato());
			if(ab.tieneHijoDerecho() && k > 0)
				ok = esMono_priv(ab.getHijoDerecho(), k-ab.getDato());
		}
		return ok;
	}

}
