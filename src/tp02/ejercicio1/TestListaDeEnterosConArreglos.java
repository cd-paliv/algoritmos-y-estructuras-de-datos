package tp02.ejercicio1;

public class TestListaDeEnterosConArreglos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListaDeEnterosConArreglos o = new ListaDeEnterosConArreglos();
		for (int i=0; i < args.length; i++) {
			o.agregarEn(Integer.parseInt(args[i]), (i+1));
		}
		
		//forma 1
		if (!o.esVacia()) {
			for (int i=1; i <= o.tamanio(); i++) {
				System.out.print(o.elemento(i) + " ");
			}
		}
		System.out.println();
		System.out.println("-------------------------");
		//forma 2
		o.comenzar();
		while(!o.fin())
			System.out.print(o.proximo() + " ");
	}

}
