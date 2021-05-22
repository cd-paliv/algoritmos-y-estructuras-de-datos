package CodigosCualquiera.Princesa;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class Juego {

	public void encontrarPrincesa(ArbolGeneral<Personaje> a) {
		ListaGenerica<Personaje> lista = new ListaEnlazadaGenerica<Personaje>();
		lista.agregarInicio(a.getDato());
		ListaGenerica<Personaje> camino = new ListaEnlazadaGenerica<Personaje>();
		encontrarPrincesa(a, lista, camino);
		if(! camino.esVacia()) {
			System.out.print("Se encontró a la princesa en el camino: ");
			for(int i = 0; i < camino.tamanio(); i++) {
				System.out.print(camino.proximo().getNombre() + " - ");
			}
		}else
			System.out.println("No existe un camino a una princesa");
	}
	
	private void encontrarPrincesa(ArbolGeneral<Personaje> a, ListaGenerica<Personaje> lista,
														ListaGenerica<Personaje> camino) {
		Personaje p = a.getDato();
		if(p.esPrincesa()) {
			lista.comenzar();
			while(! lista.fin()) {
				camino.agregarFinal(lista.proximo());
			}
		}
		if(camino.esVacia()) {
			ListaGenerica<ArbolGeneral<Personaje>> hijos = a.getHijos();
			hijos.comenzar();
			while(! hijos.fin() && camino.esVacia()) {
				ArbolGeneral<Personaje> arbolAux = hijos.proximo();
				if(! arbolAux.getDato().esDragon()) {
					lista.agregarFinal(arbolAux.getDato());
					encontrarPrincesa(arbolAux, lista, camino);
					lista.eliminarEn(lista.tamanio());
				}
			}
		}
	}
	/*
	private void clonar(ListaGenerica<Personaje> origen, ListaGenerica<Personaje> destino) {
		origen.comenzar();
		while(! origen.fin())
			destino.agregarFinal(origen.proximo());
	}*/
}
