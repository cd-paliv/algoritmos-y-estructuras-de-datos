package tp04.ejercicio1;

import tp02.ejercicio2.ListaGenerica;

public class Test {

	public static void main(String[] args) {
		
		ArbolGeneral<Integer> aRaiz = new ArbolGeneral<Integer>(4);
		ArbolGeneral<Integer> aizq = new ArbolGeneral<Integer>(2);
		ArbolGeneral<Integer> aizqH1 = new ArbolGeneral<Integer>(1);
		ArbolGeneral<Integer> aizqH2 = new ArbolGeneral<Integer>(3);
		ArbolGeneral<Integer> amedio = new ArbolGeneral<Integer>(5);
		ArbolGeneral<Integer> ader = new ArbolGeneral<Integer>(8);
		ArbolGeneral<Integer> aderH1 = new ArbolGeneral<Integer>(7);
		ArbolGeneral<Integer> a7H = new ArbolGeneral<Integer>(6);
		ArbolGeneral<Integer> aderH2 = new ArbolGeneral<Integer>(9);
		ArbolGeneral<Integer> aderH3 = new ArbolGeneral<Integer>(10);
		
		/*
				4
			/   |   \
		  2     5    8
		 / \	   / | \
		1   3     7  9  10
				  |
				  6
		
		 */
		
		aizq.agregarHijo(aizqH1);
		aizq.agregarHijo(aizqH2);
		aRaiz.agregarHijo(aizq);  //4 -> 2 -> 1 y 3
		
		aRaiz.agregarHijo(amedio); //5 -> 5
		
		ader.agregarHijo(aderH1);
		aderH1.agregarHijo(a7H); //7 -> 6
		ader.agregarHijo(aderH2);
		ader.agregarHijo(aderH3);
		aRaiz.agregarHijo(ader); //4 -> 8 -> 7,9,10
		
		System.out.print("POR NIVELES: ");
		System.out.println(aRaiz.recorridoPorNiveles());
		aRaiz.recorridoPorNivelesImprimir();
		System.out.println("\nNiveles en forma de lista: " + aRaiz.recorrido());
		
		
		System.out.println("\nPREORDEN: " + aRaiz.preOrden());
		System.out.println("INORDEN: " + aRaiz.inOrden());
		System.out.println("POSTORDEN: " + aRaiz.postOrden());
		System.out.println();
		
		System.out.println("Altura del árbol: " + aRaiz.altura());
		System.out.println("Anchura del árbol: " + aRaiz.ancho());
		System.out.println("El dato 6 está en el nivel: " + aRaiz.nivel(6));
		System.out.println("¿Es 8 ancestro de 10? " + (aRaiz.esAncestro(8, 10) ? "Si" : "No"));
		
		
		
		System.out.println("------------------------------------------------------------");
		System.out.println("ÁRBOL DE STRING");
		
		ArbolGeneral<String> arbol = new ArbolGeneral<String>("A");
		ArbolGeneral<String> aP = new ArbolGeneral<String>("P");
		ArbolGeneral<String> aB = new ArbolGeneral<String>("B");
		ArbolGeneral<String> aT = new ArbolGeneral<String>("T");
		ArbolGeneral<String> aS1 = new ArbolGeneral<String>("S");
		ArbolGeneral<String> aL = new ArbolGeneral<String>("L");
		ArbolGeneral<String> aX = new ArbolGeneral<String>("X");
		ArbolGeneral<String> aS2 = new ArbolGeneral<String>("S");
		ArbolGeneral<String> aM = new ArbolGeneral<String>("M");
		ArbolGeneral<String> aO = new ArbolGeneral<String>("O");
		
		/*
			   A
		    /     \
		   P        X
		 / | \    / | \
		 B T L   S  M  O
		   |
		   S
		
		*/
		
		arbol.agregarHijo(aP);
		arbol.agregarHijo(aB);
		arbol.agregarHijo(aT);
		arbol.agregarHijo(aS1);
		arbol.agregarHijo(aL);
		arbol.agregarHijo(aX);
		arbol.agregarHijo(aS2);
		arbol.agregarHijo(aM);
		arbol.agregarHijo(aO);
		
		
		System.out.println(arbol.preOrden());
		
		System.out.println("Veces que aparece S en el árbol: " + contarSt(arbol, "S"));
		
		
	}
	
	
	//un contador de ocurrencias del dato String pasado por parámetro
	public static Integer contarSt(ArbolGeneral<String> ab, String dato) {
		Integer cant = 0;
		if(! ab.esVacio()) {
			ListaGenerica<ArbolGeneral<String>> hijos = ab.getHijos();
			
			if(! hijos.esVacia()) {
				hijos.comenzar();
				cant += contarSt(hijos.proximo(), dato);
			}
			if(ab.getDato().equalsIgnoreCase(dato))
				cant++;
			while(! hijos.fin())
				cant += contarSt(hijos.proximo(), dato);
		}
		return cant;
	}

}
