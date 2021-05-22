package tp03.ejercicio5;
import tp02.ejercicio3.ColaGenerica;
import tp03.ejercicio1.ArbolBinario;

public class ProfundidadDeArbolBinario {
	ArbolBinario<Integer> ab;
	
	public ProfundidadDeArbolBinario(ArbolBinario<Integer> ab) {
		this.ab = ab;
	}

	public int sumaElementosProfundidad(int p) {
		ArbolBinario<Integer> arbol = null;
		ColaGenerica<ArbolBinario<Integer>> cola = new ColaGenerica<ArbolBinario<Integer>>();
		int suma = 0, nivel = 0;
		cola.encolar(this.ab);
		cola.encolar(null);
		System.out.print("Nivel " + Integer.toString(p) + ": ");
		while (! cola.esVacia()) {
			arbol = cola.desencolar();
			if (arbol != null) {
				if (nivel == p) {
					suma += arbol.getDato();
					System.out.print(arbol.getDato() + " ");
				}
				if (arbol.tieneHijoIzquierdo())
					cola.encolar(arbol.getHijoIzquierdo());
				if (arbol.tieneHijoDerecho())
					cola.encolar(arbol.getHijoDerecho());
			} else if (!cola.esVacia()) {
				nivel++;
				cola.encolar(null);
			}
		}
		return suma;
	}
}
