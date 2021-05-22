package tp02.ejercicio1;

public class TestListaDeEnterosEnlazada {
	public static void main(String[] args) {
		ListaDeEnterosEnlazada o = new ListaDeEnterosEnlazada();
		o.comenzar();
		for (int i=0; i < args.length; i++) {
			o.agregarFinal(Integer.parseInt(args[i]));
		}
		//imprimo en orden
		if (!o.esVacia()) {
			for (int i=1; i <= o.tamanio(); i++) {
				System.out.print(o.elemento(i) + " ");
			}
		}
		
		System.out.println();
		System.out.println("-------------------------");
		
		
		//1.5 RECURSIVO
		recursivo(o);
		
		System.out.println();
		System.out.println("-------------------------");
		
		o.comenzar();
		recursivoAdelante(o);
	}
	
	//de atrás para adelante
	public static void recursivo(ListaDeEnteros l) {
		int pos = l.tamanio(); //voy al ultimo elemento
		impresionRecursiva(l, pos);
	}
	private static void impresionRecursiva(ListaDeEnteros l, int p) {
		if (p >= 1) {
			System.out.print(l.elemento(p) + " ");
			impresionRecursiva(l, p-1); //imprimo recursivamente del ultimo al primero
		}
	}
	
	//de adelante para atrás
	public static void recursivoAdelante(ListaDeEnteros l) {
		if (! l.fin()) {
			int dato = l.proximo();
			recursivoAdelante(l);
			System.out.print(dato + " ");
		}
	}
}
