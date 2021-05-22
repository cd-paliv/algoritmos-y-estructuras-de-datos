package CodigosCualquiera.Heap;

public class ArbolBinarioDeBusqueda<T extends Comparable<T>> {
	private T dato;
	private ArbolBinarioDeBusqueda<T> hijoIzquierdo;
	private ArbolBinarioDeBusqueda<T> hijoDerecho;
	
	public ArbolBinarioDeBusqueda() { }

	public ArbolBinarioDeBusqueda(T dato) {
		this.dato = dato;
	}
	
	public T getDato() {
		return dato;
	}
	
	public void setDato(T dato) {
		this.dato = dato;
	}
	
	public ArbolBinarioDeBusqueda<T> getHijoIzquierdo() {
		return hijoIzquierdo;
	}
	
	public void setHijoIzquierdo(ArbolBinarioDeBusqueda<T> hijoIzquierdo) {
		this.hijoIzquierdo = hijoIzquierdo;
	}
	
	public ArbolBinarioDeBusqueda<T> getHijoDerecho() {
		return hijoDerecho;
	}
	
	public void setHijoDerecho(ArbolBinarioDeBusqueda<T> hijoDerecho) {
		this.hijoDerecho = hijoDerecho;
	}
	
	public boolean tieneHijoIzquierdo() {
		return this.hijoIzquierdo!=null;
	}

	public boolean tieneHijoDerecho() {
		return this.hijoDerecho!=null;
	}
	
	public void agregar(T x) {
		if (dato == null)
			dato = x;
		else
			this.agregar(x, this);
	}
	private void agregar(T x, ArbolBinarioDeBusqueda<T> t) {
		if (x.compareTo(t.getDato()) < 0)
			if (t.getHijoIzquierdo() == null)
				t.setHijoIzquierdo(new ArbolBinarioDeBusqueda<T>(x));
			else
				this.agregar(x, t.getHijoIzquierdo());
		else if (x.compareTo(t.getDato()) > 0)
			if (t.getHijoDerecho() == null)
				t.setHijoDerecho(new ArbolBinarioDeBusqueda<T>(x));
			else
				this.agregar(x, t.getHijoDerecho());
	}
	
	// imprime el Ã¡rbol en preorden  
	public void printPreorden() {
		System.out.print(this.getDato() + " ");
		if (this.tieneHijoIzquierdo()) {
			this.getHijoIzquierdo().printPreorden();
		}
		if (this.tieneHijoDerecho()) {
		this.getHijoDerecho().printPreorden();
		}
	}
		// imprime el ï¿½rbol en postorden
	public void printPostorden() {
		if (this.tieneHijoIzquierdo()) {
			this.getHijoIzquierdo().printPostorden();
	}
		if (this.tieneHijoDerecho()) {
			this.getHijoDerecho().printPostorden();
		}
		System.out.print(this.getDato() + " ");
	}
	
	//imprime el árbol en postorden
	public void printInorden() {
		if (this.tieneHijoIzquierdo()) {
			this.getHijoIzquierdo().printInorden();
		}
	System.out.print(this.getDato() + " ");
		if (this.tieneHijoDerecho()) {
			this.getHijoDerecho().printInorden();
		}
	}



}
