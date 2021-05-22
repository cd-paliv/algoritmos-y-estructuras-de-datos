package tp03.ejercicio2;

import tp03.ejercicio1.ArbolBinario;

public class C {

	public static void main(String[] args) {
		ArbolBinario<Integer> ab = new ArbolBinario<Integer>(1);
		
		ArbolBinario<Integer> izq2 = new ArbolBinario<Integer>(4);
		izq2.agregarHijoIzquierdo(new ArbolBinario<Integer>(7));

		ArbolBinario<Integer> izq = new ArbolBinario<Integer>(2);
		izq.agregarHijoIzquierdo(izq2);
		izq.agregarHijoDerecho(new ArbolBinario<Integer>(5));

		ArbolBinario<Integer> der = new ArbolBinario<Integer>(3);
		der.agregarHijoIzquierdo(new ArbolBinario<Integer>(6));

		ab.agregarHijoIzquierdo(izq);
		ab.agregarHijoDerecho(der);
		
		System.out.println("ARBOL: "); ab.recorridoPorNiveles();
		System.out.println("\nENTRE NIVELES 1 Y 2: "); ab.entreNiveles(1, 2);
	}

}
