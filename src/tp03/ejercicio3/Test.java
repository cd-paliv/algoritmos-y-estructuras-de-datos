package tp03.ejercicio3;
import tp02.ejercicio3.ColaGenerica;
import tp03.ejercicio1.ArbolBinario;

public class Test {

	public static void main(String[] args) {
		ArbolBinario<Integer> ab = new ArbolBinario<Integer>(5);

		ArbolBinario<Integer> izq = new ArbolBinario<Integer>(3);
		izq.agregarHijoIzquierdo(new ArbolBinario<Integer>(2));
		izq.agregarHijoDerecho(new ArbolBinario<Integer>(4));

		ArbolBinario<Integer> der = new ArbolBinario<Integer>(8);
		der.agregarHijoIzquierdo(new ArbolBinario<Integer>(7));
		der.agregarHijoDerecho(new ArbolBinario<Integer>(10));

		ab.agregarHijoIzquierdo(izq);
		ab.agregarHijoDerecho(der);
		
		ContadorArbol.numerosParesPostOrden(ab);
		ColaGenerica<Integer> cola = ContadorArbol.getPares();
		while(!cola.esVacia()) {
			System.out.print(cola.desencolar() + " ");
		}
	}

}
