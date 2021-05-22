package CodigosCualquiera.Heap;

import tp02.ejercicio2.ListaGenerica;
// ESTÁ MAL IMPLEMENTADO, CHQUEAR
public class MinHeap<T extends Comparable<T>> implements ColaPrioridades<T> {
	@SuppressWarnings("unchecked")
	private T[] datos = (T[])new Comparable[100];
	private int cant_elem = 0;
	
	public MinHeap() {}
	
	public MinHeap(ListaGenerica<T> lista) { //O(N logN)
		lista.comenzar();
		while(! lista.fin())
			this.agregar(lista.proximo());
	}
	
	public MinHeap(T[] elementos) { //O(n)
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
			int hijoMin = 2 * posicion;
			if(hijoMin != this.cant_elem) {
				if(datos[hijoMin + 1].compareTo(datos[hijoMin]) < 0)
					hijoMin++;
			}
			if(candidato.compareTo(datos[hijoMin]) > 0) {
				datos[posicion] = datos[hijoMin];
				posicion = hijoMin;
			}else {
				detener_percolate = true;
			}
		}
		this.datos[posicion] = candidato;
	}
	
	public boolean agregar(T dato) {
		this.cant_elem++;
		this.datos[this.cant_elem] = dato;
		this.percolate_up(cant_elem);
		return true;
	}
	
	private void percolate_up(int indice) {
		T temporal = datos[indice];
		while ( (indice / 2 > 0) && (datos[indice/2].compareTo(temporal) > 0) ){
			datos[indice] = datos[indice/2];
			indice = indice/2;
		}
		datos[indice] = temporal;
	}
	
	public T tope() {
		return datos[1];
	}
	
	public boolean esVacia() {
		return cant_elem == 0;
	}
	
	public T eliminar() { //devuelve el elem eliminado
		if (this.cant_elem > 0) {
			T elemento = this.datos[1];
			this.datos[1] = this.datos[this.cant_elem];
			this.cant_elem--;
			this.percolate_down(1);
			return elemento;
		}
		return null;
	}
	
	public void imprimir() {
		for(int i = 1; i <= cant_elem; i++)
			System.out.print(datos[i] + " ");
	}
}
