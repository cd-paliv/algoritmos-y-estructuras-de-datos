package CodigosCualquiera.Heap;

import tp02.ejercicio2.ListaEnlazadaGenerica;

public class TestHeap {

	public static void main(String[] args) {
		System.out.print("ÁRBOL INORDEN: ");
		ArbolBinarioDeBusqueda<Integer> abb = new ArbolBinarioDeBusqueda<Integer>(11);
		abb.agregar(12);
		abb.agregar(16);
		abb.agregar(17);
		abb.agregar(32);
		abb.agregar(30);
		abb.agregar(42);
		
		/*
					 11
				   /    \
				  12     32
				 /  \   /  \
				16  17 30  42
		 */
		
		abb.printInorden();
		
		Integer[] colaPIn = {11, 12, 16, 17, 30, 32, 42}; //árbol inorden
		
		System.out.print("\nMAX HEAP: ");
		MaxHeap<Integer> Mh = new MaxHeap<Integer>(colaPIn);
		Mh.imprimir();
		
		/* Así quedaría después de hacer MaxHeap
					 42
				   /    \
				  17     32
				 /  \   /  \
				16  12 30  11
			
			Mh = 42 32 30 17 12 11 16
		*/
		
		Integer[] colaPPost = {2, 3, 11, 6, 15, 14, 25, 19, 7};
		
		System.out.print("\nMIN HEAP: ");
		MinHeap<Integer> minh = new MinHeap<Integer>(colaPPost);
		minh.imprimir();
		
		
		
		
		System.out.print("\n");
		System.out.print("\n");
		System.out.print("\n");
		System.out.print("\nEXAMEN:\n");
		
		//para usar en examen
		System.out.print("\nMAX HEAP: ");
		Integer[] cola2 = {13,21,87,30,25,22,18};
		MaxHeap<Integer> Mh3 = new MaxHeap<Integer>(cola2);
		Mh3.imprimir();
		
		System.out.print("\nMAX HEAP DE A 1: ");
		ListaEnlazadaGenerica<Integer> listax = new ListaEnlazadaGenerica<Integer>();
		listax.agregarFinal(13);
		listax.agregarFinal(21);
		listax.agregarFinal(87);
		listax.agregarFinal(30);
		listax.agregarFinal(25);
		listax.agregarFinal(22);
		listax.agregarFinal(18);
		MaxHeap<Integer> Mhex = new MaxHeap<Integer>(listax);
		Mhex.imprimir();
		
		minh.eliminar();System.out.println();
		minh.imprimir();
	}

}
