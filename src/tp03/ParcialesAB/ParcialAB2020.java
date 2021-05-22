package tp03.ParcialesAB;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp03.ejercicio1.ArbolBinario;

public class ParcialAB2020 {

	/*
	 * Implemente el método "resolver (ArbolBinario<Integer> arbol)"
	 * 	que devuelva una lista con los valores de los nodos que tengan el mismo
	 *  número de descendientes tanto por su subárbol izquierdo como por el derecho.
	 *  Para el árbol
	 *  	   2
	 *  	 /   \
	 *  	1      5
	 *     /  \     \
	 *    16  6      8
	 *    		   /
	 *    		  22
	 *    Debería devolver una lista con 2, 1, 16, 6, 22
	 *    2 tiene 3 descendientes tanto del lado izq como el der
	 *    1 tiene 1 descendiente tanto del lado izq como el der
	 *    16, 6 y 22 tienen 0 descendientes tanto del lado izq como el der
	 */
	
	public static void main(String[] args) {
		System.out.println("ARBOL BINARIO: ");
		ArbolBinario<Integer> ab = new ArbolBinario<Integer>(2);
		
		ArbolBinario<Integer> izq = new ArbolBinario<Integer>(1);
		izq.agregarHijoIzquierdo(new ArbolBinario<Integer>(16));
		izq.agregarHijoDerecho(new ArbolBinario<Integer>(6));
		
		ArbolBinario<Integer> a8 = new ArbolBinario<Integer>(8);
		a8.agregarHijoIzquierdo(new ArbolBinario<Integer>(22));
		
		ArbolBinario<Integer> der = new ArbolBinario<Integer>(5);
		der.agregarHijoDerecho(a8);
		
		ab.agregarHijoIzquierdo(izq);
		ab.agregarHijoDerecho(der);
		
		ab.recorridoPorNiveles();
		
		System.out.println("\nLISTA: " + resolver(ab));
	}
	
	
	public static ListaGenerica<Integer> resolver(ArbolBinario<Integer> arbol){
		ListaGenerica<Integer> valores = new ListaEnlazadaGenerica<Integer>();
		if(! arbol.esVacio())
			resolver(arbol, valores);
		return valores;
	}
	private static int resolver(ArbolBinario<Integer> a, ListaGenerica<Integer> lista){
		if(a.esVacio()) return 0;
		if(a.esHoja()) {
			lista.agregarInicio(a.getDato());
			return 1;
		}else {
			int HI = 0, HD = 0;
			if(a.tieneHijoDerecho())
				HD = resolver(a.getHijoDerecho(), lista);
			if(a.tieneHijoIzquierdo())
				HI = resolver(a.getHijoIzquierdo(), lista);
			if(HI == HD) {
				lista.agregarInicio(a.getDato());
			}
			return HI + HD + 1;
		}
	}
}
