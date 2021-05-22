package tp03.ejercicio4;
import tp03.ejercicio1.ArbolBinario;

public class RedBinariaLlena {

	public static int retardoEnvio(ArbolBinario<Integer> ab) {
		if(ab.esHoja()) return ab.getDato();
		else {
			int HI = retardoEnvio(ab.getHijoIzquierdo());
			int HD = retardoEnvio(ab.getHijoDerecho());
			int max = Math.max(HI, HD);
			return max + ab.getDato();
		}
	}
	
	/*
	public static int retardoReenvio(ArbolBinario<Integer> ab) {
		int cont = 0, izq = 0, der = 0;
		if(ab.tieneHijoIzquierdo()) {
		     izq = retardoReenvio(ab.getHijoIzquierdo());
		}
		if(ab.tieneHijoDerecho()) {
		     der = retardoReenvio(ab.getHijoDerecho());
		}
		cont = ab.getDato();
		//SI QUIERO SABER EL RETARDO DE CADA NODO
		if(izq!=0 || der!=0) {
			System.out.println("Del nodo con "+Integer.toString(cont)+ "ms el hijo mas lento ->  "+ Integer.toString((izq>der)?izq:der)+"ms");			
		}
		return cont = (izq>der)?cont+izq:cont+der;
	}*/

}
