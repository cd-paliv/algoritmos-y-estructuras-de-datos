package tp03.ejercicio5;

import tp03.ejercicio1.ArbolBinario;

public class Test {

	public static void main(String[] args) {
		ArbolBinario<Integer> ab = new ArbolBinario<Integer>(30);

		ArbolBinario<Integer> izq = new ArbolBinario<Integer>(25);
		izq.agregarHijoIzquierdo(new ArbolBinario<Integer>(110));
		izq.agregarHijoDerecho(new ArbolBinario<Integer>(90));

		ArbolBinario<Integer> der = new ArbolBinario<Integer>(70);
		der.agregarHijoIzquierdo(new ArbolBinario<Integer>(45));
		der.agregarHijoDerecho(new ArbolBinario<Integer>(65));

		ab.agregarHijoIzquierdo(izq);
		ab.agregarHijoDerecho(der);
		
		System.out.println("ARBOL: "); ab.recorridoPorNiveles();
		
		ProfundidadDeArbolBinario p = new ProfundidadDeArbolBinario(ab);
		System.out.println();
		System.out.println("\nSuma del nivel: " + Integer.toString(p.sumaElementosProfundidad(1)));
	}

}
