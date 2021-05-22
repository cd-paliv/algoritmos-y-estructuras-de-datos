package tp02.ejercicio3;
//import tp02.ejercicio2.*;

public class TestPilaGenerica {

	public static void main(String[] args) {
		PilaGenerica<Integer> pila = new PilaGenerica<Integer>();
		pila.apilar(1);
		pila.apilar(2);
		pila.apilar(3);
		System.out.println("Tope: " + pila.tope());
		for(int i = 1; i < 4; i++) {
			System.out.println(i + ": " + pila.desapilar());
		}

	}

}
