package CodigosCualquiera.Heap;

import tp02.ejercicio2.ListaGenerica;

public class MaxHeap<T extends Comparable<T>> implements ColaPrioridades<T>{
	@SuppressWarnings("unchecked")
	private T[] datos = (T[])new Comparable[100];
	private int cant_elem = 0;
	
	public MaxHeap() {}
	
	public MaxHeap(ListaGenerica<T> lista) { //armar la heap de a uno tiene orden N*logN
		lista.comenzar();
		while(! lista.fin())
			this.agregar(lista.proximo());
	}
	
	public MaxHeap(T[] elementos) { //así es de orden lineal BUILDHEAP
		for (int i = 0; i < elementos.length; i++) {
			cant_elem++;
			datos[cant_elem] = elementos[i];
		}
		for (int i = cant_elem / 2; i > 0; i--) {
			this.percolate_down(i);
		}
	}
	
	public void percolate_down(int posicion) {
		T candidato = datos[posicion];
		boolean detener_percolate = false;
		while((2 * posicion <= cant_elem) && (! detener_percolate)) {
			int hijoMax = 2 * posicion;
			if(hijoMax != this.cant_elem) {
				if(datos[hijoMax + 1].compareTo(datos[hijoMax]) > 0)
					hijoMax++;
			}
			if(candidato.compareTo(datos[hijoMax]) < 0) {
				datos[posicion] = datos[hijoMax];
				posicion = hijoMax;
			}else {
				detener_percolate = true;
			}
		}
		this.datos[posicion] = candidato;
	}
	
	public boolean agregar(T dato) {
		/*
		cant_elem++;
		if(cant_elem <= datos.length) {
			datos[cant_elem] = dato;
			return true;
		}else {
			cant_elem--;
			return false;
		}
	}*/
		this.cant_elem++;
		this.datos[this.cant_elem] = dato;
		this.percolate_up(cant_elem);
		return true;
	}
	
	private void percolate_up(int indice) {
		T temporal = datos[indice];
		while ((indice / 2 > 0) && (datos[indice/2].compareTo(temporal) < 0)){
			datos[indice] = datos[indice/2];
			indice = indice/2;
		}
		datos[indice] = temporal;
	}
	
	public T tope() {
		return datos[cant_elem];
	}
	
	public T eliminar() {
		T e = null;
		if(cant_elem > 0) {
			e = datos[1];
			datos[1] = datos[cant_elem];
			cant_elem--;
			percolate_down(1);
		}
		return e;
	}
	
	public boolean esVacia() {
		return cant_elem == 0;
	}
	
	public void imprimir() {
		for(int i = 1; i <= cant_elem; i++)
			System.out.print(datos[i] + " ");
	}
}
