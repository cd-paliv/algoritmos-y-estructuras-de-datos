package tp04.ejercicio3;
import tp04.ejercicio1.ArbolGeneral;

public class TestPrePostIn {

	public static void main(String[] args) {
		
		System.out.println("ÁRBOL DE INTEGER");
		
		ArbolGeneral<Integer> aR = new ArbolGeneral<Integer>(8);
		ArbolGeneral<Integer> a3 = new ArbolGeneral<Integer>(2);
		ArbolGeneral<Integer> a4 = new ArbolGeneral<Integer>(1);
		ArbolGeneral<Integer> a7 = new ArbolGeneral<Integer>(5);
		ArbolGeneral<Integer> a2 = new ArbolGeneral<Integer>(3);
		ArbolGeneral<Integer> a6 = new ArbolGeneral<Integer>(6);
		ArbolGeneral<Integer> a5 = new ArbolGeneral<Integer>(10);
		ArbolGeneral<Integer> a1 = new ArbolGeneral<Integer>(9);
		
		/*
				 8
			  /     \
		    2        9
		  / | \      |
		  1 5 6      10
		    |
		    3
		
		*/
		
		aR.agregarHijo(a3);
		aR.agregarHijo(a5);
		a3.agregarHijo(a4);
		a3.agregarHijo(a7);
		a7.agregarHijo(a2);
		a3.agregarHijo(a6);
		a5.agregarHijo(a1);
		
		System.out.println("PREORDEN: " + aR.preOrden());
		
		System.out.println("INORDEN: " + aR.inOrden());
		
		System.out.println("POSTORDEN: " + aR.postOrden());
		
	}

}
