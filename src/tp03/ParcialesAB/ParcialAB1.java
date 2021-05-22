package tp03.ParcialesAB;

import tp03.ejercicio1.ArbolBinario;

public class ParcialAB1 {
	
	/*
	 * Implemente el método cantidadHijosPares(): int que devuelve cuántos subárboles del
	 * 	árbol tienen un número par de hijos. Los nros 0 y 2 son pares. Realice un recorrido
	 * 	en inorden.
	 */

	public static void main(String[] args) {
		System.out.println("ARBOL BINARIO: ");
		ArbolBinario<Integer> ab = new ArbolBinario<Integer>(40);
		
		ArbolBinario<Integer> izq = new ArbolBinario<Integer>(25);
		izq.agregarHijoIzquierdo(new ArbolBinario<Integer>(10));
		//izq.agregarHijoDerecho(new ArbolBinario<Integer>(32));
		
		ArbolBinario<Integer> der = new ArbolBinario<Integer>(78);
		der.agregarHijoIzquierdo(new ArbolBinario<Integer>(62));
		der.agregarHijoDerecho(new ArbolBinario<Integer>(90));
		
		ab.agregarHijoIzquierdo(izq);
		ab.agregarHijoDerecho(der);
		
		ab.recorridoPorNiveles();
		
		System.out.println("\nCANT DE HIJOS PARES: " + cantidadHijosPares(ab));
	}
	
	public static int cantidadHijosPares(ArbolBinario<Integer> a) {
		int cant = 0;
		if(a.tieneHijoIzquierdo())
			if(! a.getHijoIzquierdo().esVacio())
				cant += cantidadHijosPares(a.getHijoIzquierdo());
		if(a.esHoja())
			cant++;
		if(a.tieneHijoIzquierdo() && a.tieneHijoDerecho())
			cant++;
		if(a.tieneHijoDerecho())
			if(! a.getHijoDerecho().esVacio())
				cant += cantidadHijosPares(a.getHijoDerecho());
		return cant;
	}

}
