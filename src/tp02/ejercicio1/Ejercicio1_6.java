package tp02.ejercicio1;

public class Ejercicio1_6 {
	
	public static ListaDeEnterosEnlazada calcularSucesion(int n) {
		ListaDeEnterosEnlazada lista = new ListaDeEnterosEnlazada();
		calcularRecursivo(n, lista);
		return lista;
	}
	
	private static void calcularRecursivo(int n, ListaDeEnteros l) {
		int res = 0;
		if(n == 1) l.agregarFinal(n); //si recibe 1 lo agrego a la lista
		else { //sino, lo agrego y hago las operaciones para ir al siguiente elemento
			l.agregarFinal(n);
			if(n%2 == 0) res = n / 2;
			else res = 3* n + 1;
			calcularRecursivo(res, l);
		}
	}
	
	
	//PP
	public static void main(String[] args) {
		
		ListaDeEnterosEnlazada l = calcularSucesion(6);
		
		if (!l.esVacia()) {
			for (int i=1; i <= l.tamanio(); i++) {
				System.out.print(l.elemento(i) + " ");
			}
		}
	}

}
