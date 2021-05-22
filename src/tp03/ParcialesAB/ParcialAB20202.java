package tp03.ParcialesAB;

import tp03.ejercicio1.ArbolBinario;

public class ParcialAB20202 {

	/*
	 * Implemente un método que reciba un ab de enteros y recorra un camino desde
	 * 	la raíz hasta una hoja multiplicando el valor del nodo involucrado en el
	 *  camino por potencias de 10 según el nivel del nodo y retorne la suma. El
	 *  camino debe respetar el sig criterio:
	 *  	1. Si el valor del nodo es par, debe seguir por el hijo izq
	 *  	2. Si el valor del nodo es impar, debe seguir por el hijo derecho.
	 *  El método debe tener la sig firma: "resolver(Arbolbinario<Integer>):Integer"
	 */
	
	public static void main(String[] args) {
		System.out.println("ARBOL BINARIO: ");
		ArbolBinario<Integer> ab = new ArbolBinario<Integer>(2);
		
		ArbolBinario<Integer> izq = new ArbolBinario<Integer>(1);
		izq.agregarHijoIzquierdo(new ArbolBinario<Integer>(16));
		izq.agregarHijoDerecho(new ArbolBinario<Integer>(6));
		
		ArbolBinario<Integer> der = new ArbolBinario<Integer>(5);
		der.agregarHijoDerecho(new ArbolBinario<Integer>(8));
		
		ab.agregarHijoIzquierdo(izq);
		ab.agregarHijoDerecho(der);
		
		ab.recorridoPorNiveles();
		
		System.out.println("\nSUMA PEDIDA: " + resolver(ab));
	}
	
	public static Integer resolver(ArbolBinario<Integer> a) { //necesito el nivel y la suma
		if(! a.esVacio())
			return resolver(a, 0);
		else return 0;
	}
	private static Integer resolver(ArbolBinario<Integer> ab, int nivel) {
		if(ab.getDato() % 2 == 0) { //si es par
			if(ab.tieneHijoIzquierdo()) {
				int HI = resolver(ab.getHijoIzquierdo(), nivel + 1);
				return (int) (ab.getDato() * Math.pow(10, nivel)) + HI;
			}
		}else {
			if(ab.tieneHijoDerecho()) {
				int HD = resolver(ab.getHijoDerecho(), nivel + 1);
				return (int) (ab.getDato() * Math.pow(10, nivel)) + HD;
			}
		}
		return (int) (ab.getDato() * Math.pow(10, nivel));
		
	}

}
