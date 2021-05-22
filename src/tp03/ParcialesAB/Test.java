package tp03.ParcialesAB;

import tp03.ejercicio1.ArbolBinario;

public class Test {

	public static void main(String[] args) {
		System.out.println("ARBOL BINARIO: ");
		ArbolBinario<Integer> ab = new ArbolBinario<Integer>(2);
		
		ArbolBinario<Integer> izq = new ArbolBinario<Integer>(7);
		izq.agregarHijoIzquierdo(new ArbolBinario<Integer>(3));
		ArbolBinario<Integer> a4 = new ArbolBinario<Integer>(6);
		a4.agregarHijoIzquierdo(new ArbolBinario<Integer>(5)); a4.agregarHijoDerecho(new ArbolBinario<Integer>(11));
		izq.agregarHijoDerecho(a4);
		
		ArbolBinario<Integer> der = new ArbolBinario<Integer>(5);
		ArbolBinario<Integer> a1 = new ArbolBinario<Integer>(9);
		a1.agregarHijoIzquierdo(new ArbolBinario<Integer>(4));
		der.agregarHijoDerecho(a1);
		
		ab.agregarHijoIzquierdo(izq);
		ab.agregarHijoDerecho(der);
		
		ab.recorridoPorNiveles();
		
		//System.out.println("\n¿Es monodistante? " + (new ParcialAB2(ab).esMonodistante(8) ? "Si" : "No"));
		//System.out.println("\nCantidad de ocurrencias de 2: " + new ParcialAB3(ab).contadorOcurrencias(2));
		//System.out.println("\nNro min del arbol: " + new ParcialAB4(ab).buscar());
		//System.out.println("\nPrimer elem del ultimo nivel: " + new ParcialAB5(ab).buscarPrimerElementoUltimoNivel());
		//System.out.println("\nPrimer nro primo: " + new ParcialAB6(ab).buscar());
		//System.out.println("\nElem en mayor profundidad: " + new ParcialAB7(ab).buscar());
		
	}
	

}
