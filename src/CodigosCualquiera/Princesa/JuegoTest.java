package CodigosCualquiera.Princesa;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class JuegoTest {

	public static void main(String[] args) {
			Personaje p0 = new Personaje("Scooby", "Animal");
			ArbolGeneral<Personaje> a1 = new ArbolGeneral<Personaje>(p0); //Scooby
			
			ListaGenerica<ArbolGeneral<Personaje>> hijosa2 = new ListaEnlazadaGenerica<ArbolGeneral<Personaje>>();
			ArbolGeneral<Personaje> a21 = new ArbolGeneral<Personaje>(new Personaje("Cenicienta", "Princesa"));
			hijosa2.agregarFinal(a21);
			ArbolGeneral<Personaje> a22 = new ArbolGeneral<Personaje>(new Personaje("Rojo", "Dragon"));
			hijosa2.agregarFinal(a22);
			ArbolGeneral<Personaje> a23 = new ArbolGeneral<Personaje>(new Personaje("Pluto", "Animal"));
			hijosa2.agregarFinal(a23);
			Personaje p4 = new Personaje("Negro", "Dragon");
			ArbolGeneral<Personaje> a2 = new ArbolGeneral<Personaje>(p4, hijosa2);
			
			ListaGenerica<ArbolGeneral<Personaje>> hijosa3 = new ListaEnlazadaGenerica<ArbolGeneral<Personaje>>();
			Personaje p5 = new Personaje("La Bella", "Princesa");
			ArbolGeneral<Personaje> a31 = new ArbolGeneral<Personaje>(p5);
			hijosa3.agregarFinal(a31);
			Personaje p6 = new Personaje("Tweety", "Animal");
			ArbolGeneral<Personaje> a32 = new ArbolGeneral<Personaje>(p6);
			hijosa3.agregarFinal(a32);
			Personaje p7 = new Personaje("Cid", "Animal");
			ArbolGeneral<Personaje> a3 = new ArbolGeneral<Personaje>(p7, hijosa3);
			
			//AB
			ListaGenerica<ArbolGeneral<Personaje>> hijos = new ListaEnlazadaGenerica<ArbolGeneral<Personaje>>();
			hijos.agregarFinal(a1); //Scooby
			hijos.agregarFinal(a2); //Dragón Negro
			hijos.agregarFinal(a3); //Animal Cid
			Personaje p8 = new Personaje("Coyote", "Animal");
			ArbolGeneral<Personaje> a = new ArbolGeneral<Personaje>(p8, hijos);
			
			
			ListaGenerica<Personaje> arbol = a.recorridoPorNiveles();
			for(int i = 0; i < arbol.tamanio(); i++) {
				System.out.print(arbol.proximo().getNombre() + " - ");
			}
			
			System.out.println();
			Juego juego = new Juego();
			juego.encontrarPrincesa(a);
		}


}
