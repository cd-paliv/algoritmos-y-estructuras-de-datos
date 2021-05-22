package CodigosCualquiera.Quadtree;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class CuentaPixels {

	public static void main(String[] args) {
		/*Un quadtree es una representación usada para cubrir un espacio cuadrado en dos
			dimensiones y posteriormente utilizado para determinar ciertas condiciones entre
			objetos en el mismo.
			Un artista moderno trabaja con imágenes codificadas en quadtree’s. El quadtree es
			un árbol 4-ario que codifica a una imagen con el siguiente criterio:
			
			-Si toda la imagen tiene un mismo color, la misma es representada por un único
			nodo que almacene un dato que represente a ese color.
			
			-En caso contrario, se divide la imagen en cuatro cuadrantes que se representan en
			el árbol como un nodo con 4 hijos, y cada hijo es la conversión de cada una de las
			partes de la imagen.
			
			El artista desea saber cuántos pixeles de color negro posee una imagen dada. Usted
			debe implementar un método, que dado un quadtree y una cantidad total de pixeles,
			cuente cuantos pixeles de color negro contiene la imagen codificada en él. */
		
		Pixel p0 = new Pixel("Blanco");
		Pixel p1 = new Pixel("Blanco");
		Pixel p2 = new Pixel("Blanco");
		Pixel p3 = new Pixel("Negro");
		Pixel p4 = new Pixel("Negro");
		Pixel p5 = new Pixel("Negro");
		Pixel p6 = new Pixel("Blanco");
		Pixel p7 = new Pixel("Blanco");
		Pixel p8 = new Pixel("Negro");
		Pixel p9 = new Pixel("Blanco");
		ArbolGeneral<Pixel> h1 = new ArbolGeneral<Pixel>(p0);
		ArbolGeneral<Pixel> h2 = new ArbolGeneral<Pixel>(p1);
		ArbolGeneral<Pixel> h3 = new ArbolGeneral<Pixel>(p2);
		ArbolGeneral<Pixel> h4 = new ArbolGeneral<Pixel>(p3);
		ArbolGeneral<Pixel> h5 = new ArbolGeneral<Pixel>(p4);
		ArbolGeneral<Pixel> h6 = new ArbolGeneral<Pixel>(p5);
		ArbolGeneral<Pixel> h7 = new ArbolGeneral<Pixel>(p6);
		ArbolGeneral<Pixel> h8 = new ArbolGeneral<Pixel>(p7);
		ArbolGeneral<Pixel> h9 = new ArbolGeneral<Pixel>(p8);
		ArbolGeneral<Pixel> h10 = new ArbolGeneral<Pixel>(p9);
		
		Pixel p10 = new Pixel("Mixto");
		ListaGenerica<ArbolGeneral<Pixel>> hijosII = new ListaEnlazadaGenerica<ArbolGeneral<Pixel>>();
		hijosII.agregarFinal(h1);
		hijosII.agregarFinal(h2);
		hijosII.agregarFinal(h3);
		hijosII.agregarFinal(h4);
		ArbolGeneral<Pixel> hizqizq = new ArbolGeneral<Pixel>(p10, hijosII);
		
		Pixel p11 = new Pixel("Mixto");
		ListaGenerica<ArbolGeneral<Pixel>> hijosCI = new ListaEnlazadaGenerica<ArbolGeneral<Pixel>>();
		hijosCI.agregarFinal(h5);
		hijosCI.agregarFinal(h6);
		hijosCI.agregarFinal(h7);
		hijosCI.agregarFinal(h8);
		ArbolGeneral<Pixel> hcentroizq = new ArbolGeneral<Pixel>(p11, hijosCI);
		
		ListaGenerica<ArbolGeneral<Pixel>> hijos = new ListaEnlazadaGenerica<ArbolGeneral<Pixel>>();
		hijos.agregarFinal(hizqizq);
		hijos.agregarFinal(hcentroizq);
		hijos.agregarFinal(h9);
		hijos.agregarFinal(h10);
		
		Pixel p12 = new Pixel("Mixto");
		ArbolGeneral<Pixel> raiz = new ArbolGeneral<Pixel>(p12, hijos);
		
		/*
					    M
				/      /  \   \
			  M       M    N   B
		   / /|\    /|\ \
		  B B B N  N N B B
		  
		 */
		
		System.out.println("Los pixeles de color negro que posee la imagen es " + contar(raiz, 1024));


	}
	
	public static int contar(ArbolGeneral<Pixel> arbol, int cantidadTotal) {
		int cantidad = 0;
		if (arbol.esHoja() && arbol.getDato().esNegro()) {
			return cantidadTotal;
		} else if (! arbol.esHoja()) {
			int cantidadHijos = cantidadTotal / 4;
			for (int i = 1; i <= 4; i++) {
				cantidad += contar(arbol.getHijos().elemento(i), cantidadHijos);
			}
		}
			return cantidad;
	}


}
