package tp03.ejercicio3;
import tp02.ejercicio3.ColaGenerica;
import tp03.ejercicio1.ArbolBinario;

public class ContadorArbol {
	public static ColaGenerica<Integer> cola = new ColaGenerica<Integer>();

	//3.A
	public static void numerosParesInOrden(ArbolBinario<Integer> ab) {
		if (ab.tieneHijoIzquierdo())
			ContadorArbol.numerosParesInOrden(ab.getHijoIzquierdo());
		if (ab.getDato() % 2 == 0)
			cola.encolar(ab.getDato());
		if (ab.tieneHijoDerecho())
			ContadorArbol.numerosParesInOrden(ab.getHijoDerecho());
	}

	//3.B
	public static void numerosParesPostOrden(ArbolBinario<Integer> ab) {
		if (ab.tieneHijoIzquierdo())
			ContadorArbol.numerosParesInOrden(ab.getHijoIzquierdo());
		if (ab.tieneHijoDerecho())
			ContadorArbol.numerosParesInOrden(ab.getHijoDerecho());
		if (ab.getDato() % 2 == 0)
			cola.encolar(ab.getDato());
	}
	
	public static void numerosParesPreOrden(ArbolBinario<Integer> ab) {
		if (ab.getDato() % 2 == 0)
			cola.encolar(ab.getDato());
		if (ab.tieneHijoIzquierdo())
			ContadorArbol.numerosParesPreOrden(ab.getHijoIzquierdo());
		if (ab.tieneHijoDerecho())
			ContadorArbol.numerosParesPreOrden(ab.getHijoDerecho());
	}

	public static ColaGenerica<Integer> getPares() {
		return ContadorArbol.cola;
	}
}
