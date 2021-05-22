package tp02.ejercicio3;

public class TestColaGenerica {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ColaGenerica<Integer> cola = new ColaGenerica<Integer>();
		cola.encolar(1);
		cola.encolar(2);
		cola.encolar(3);
		System.out.println("Tope: " + cola.tope());
		for (int i = 1; i < 4; i++) {
			System.out.println(i + ": " + cola.desencolar());
		}
	}

}
