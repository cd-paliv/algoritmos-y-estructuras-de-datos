package tp04.ejercicio6;

import tp04.ejercicio1.ArbolGeneral;

public class Test {
	
	public static void main (String[] args) {
		
		ArbolGeneral<Integer> aR = new ArbolGeneral<Integer>(8);
		ArbolGeneral<Integer> a3 = new ArbolGeneral<Integer>(3);
		ArbolGeneral<Integer> a4 = new ArbolGeneral<Integer>(4);
		ArbolGeneral<Integer> a7 = new ArbolGeneral<Integer>(7);
		ArbolGeneral<Integer> a2 = new ArbolGeneral<Integer>(2);
		ArbolGeneral<Integer> a6 = new ArbolGeneral<Integer>(6);
		ArbolGeneral<Integer> a5 = new ArbolGeneral<Integer>(5);
		ArbolGeneral<Integer> a1 = new ArbolGeneral<Integer>(1);
		ArbolGeneral<Integer> a9 = new ArbolGeneral<Integer>(9);
		ArbolGeneral<Integer> a10 = new ArbolGeneral<Integer>(10);
		
		/*
				 8
			  /     \
		    3        5
		  / | \    / | \
		  4 7 6   1  9  10
		    |
		    2
		
		*/
		
		aR.agregarHijo(a3);
		aR.agregarHijo(a5);
		a3.agregarHijo(a4);
		a3.agregarHijo(a7);
		a7.agregarHijo(a2);
		a3.agregarHijo(a6);
		a5.agregarHijo(a1);
		a5.agregarHijo(a9);
		a5.agregarHijo(a10);
		
		System.out.println("¿Es 8 ancestro de 2? " + (aR.esAncestro(8, 2) ? "Si" : "No"));
		
	}
}
