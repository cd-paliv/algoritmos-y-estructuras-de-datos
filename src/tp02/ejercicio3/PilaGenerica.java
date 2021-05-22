package tp02.ejercicio3;
import tp02.ejercicio2.*;

public class PilaGenerica<T>{
	private ListaGenerica<T> pila;
	
	public PilaGenerica(){
		this.pila = new ListaEnlazadaGenerica<T>();
	}
	
	public void apilar(T elem){
		this.pila.agregarInicio(elem);
	}
	
	public T desapilar(){
		T aux = this.pila.elemento(1);
		this.pila.eliminarEn(1);
		return aux;
	}
	
	public T tope(){
		return this.pila.elemento(1);
	}
	
	public boolean esVacia(){
		return this.pila.esVacia();
	}
}
