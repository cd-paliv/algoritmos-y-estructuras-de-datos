package tp03.ejercicio2;
import tp03.ejercicio1.ArbolBinario;

public class A {

	public static void main(String[] args) {
		ArbolBinario<Integer> ab = new ArbolBinario<Integer>(1);

		ArbolBinario<Integer> izq = new ArbolBinario<Integer>(2);
		izq.agregarHijoIzquierdo(new ArbolBinario<Integer>(4));
		izq.agregarHijoDerecho(new ArbolBinario<Integer>(5));

		ArbolBinario<Integer> der = new ArbolBinario<Integer>(3);
		der.agregarHijoIzquierdo(new ArbolBinario<Integer>(6));

		ab.agregarHijoIzquierdo(izq);
		ab.agregarHijoDerecho(der);
		
		System.out.println("CANTIDAD DE HOJAS: " + ab.contarHojas());
	}

}
