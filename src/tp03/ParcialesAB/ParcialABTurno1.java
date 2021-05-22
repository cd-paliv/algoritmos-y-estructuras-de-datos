package tp03.ParcialesAB;

import tp02.ejercicio3.ColaGenerica;
import tp03.ejercicio1.ArbolBinario;

public class ParcialABTurno1 {

	/*
	Implemente en la clase Parcial, el siguiente método:

		colorearArbol (ArbolBinario<String> arbol, Integer maxColor )
		
		El método recibe un árbol incoloro y lo colorea según el siguiente criterio: 
		
		La raiz se colorea en “Negro” y luego en los siguientes niveles se van intercalando entre el color “Rojo” y “Negro”, con la salvedad de que no puede haber un nivel con mas de maxColor nodos “Rojo” o “Negro”, con lo cual si un nivel supera ese valor se deberá colorear en “Verde” 
		
		 
		
		El color será representado por un String. 
	 */
	
	public static void main(String[] args) {
		System.out.println("ARBOL BINARIO: ");
		ArbolBinario<String> ab = new ArbolBinario<String>(" ");
		
		ArbolBinario<String> izq = new ArbolBinario<String>(" ");
		ArbolBinario<String> izqN = new ArbolBinario<String>(" ");
		izqN.agregarHijoIzquierdo(new ArbolBinario<String>(" "));
		izq.agregarHijoIzquierdo(new ArbolBinario<String>(" "));
		izq.agregarHijoDerecho(izqN);
		
		ArbolBinario<String> der = new ArbolBinario<String>(" ");
		ArbolBinario<String> derN = new ArbolBinario<String>(" ");
		derN.agregarHijoIzquierdo(new ArbolBinario<String>(" "));
		ArbolBinario<String> derV = new ArbolBinario<String>(" ");
		derV.agregarHijoIzquierdo(new ArbolBinario<String>(" ")); derV.agregarHijoDerecho(new ArbolBinario<String>(" "));
		der.agregarHijoIzquierdo(derN); der.agregarHijoDerecho(derV);
		
		ab.agregarHijoIzquierdo(izq);
		ab.agregarHijoDerecho(der);
		
		//ab.recorridoPorNiveles();
		
		System.out.println("-----------------------------");
		ParcialABTurno1.colorearArbol(ab, 3);
		ab.recorridoPorNiveles();
	}
	
	public static void colorearArbol (ArbolBinario<String> arbol, Integer maxColor ) {
		ArbolBinario<String> abAux = null;
		ColaGenerica<ArbolBinario<String>> cola = new ColaGenerica<ArbolBinario<String>>();
		int nivel = 0, cantNodos = 0;
		cola.encolar(arbol);
		cola.encolar(null);
		while (! cola.esVacia()) {
			abAux = cola.desencolar();
			if (abAux != null) {
				cantNodos++;
				if(cantNodos <= maxColor) {
					if(nivel % 2 == 0) {
						abAux.setDato("Negro");
					}else abAux.setDato("Rojo");
				} else abAux.setDato("Verde");
				if (abAux.tieneHijoIzquierdo())
					cola.encolar(abAux.getHijoIzquierdo());
				if (abAux.tieneHijoDerecho())
					cola.encolar(abAux.getHijoDerecho());
			} else if (! cola.esVacia()) {
				nivel++;
				cantNodos = 0;
				cola.encolar(null);
			}
		}
		arbol = abAux;
		
	}
}
