package CodigosCualquiera;
import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp02.ejercicio3.ColaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class ContadorArbol {
	
	public static void main (String[] args) {
		
		/*Implemente en la clase ContadorArbol el método caminoAHojaMasLejana que recibe un árbol
		   general de Integer y retorna el camino a la hoja más lejana desde la raíz.
		   Si hubiese más de un camino con la misma longitud, debe devolver el 1ero que encuentre.
		   Debe recorrer el árbol MÁXIMO una vez. */
		
		ArbolGeneral<Integer> aR = new ArbolGeneral<Integer>(8);
		ArbolGeneral<Integer> a3 = new ArbolGeneral<Integer>(3);
		ArbolGeneral<Integer> a4 = new ArbolGeneral<Integer>(4);
		ArbolGeneral<Integer> a7 = new ArbolGeneral<Integer>(7);
		ArbolGeneral<Integer> a2 = new ArbolGeneral<Integer>(2);
		ArbolGeneral<Integer> a6 = new ArbolGeneral<Integer>(6);
		ArbolGeneral<Integer> a5 = new ArbolGeneral<Integer>(5);
		ArbolGeneral<Integer> a1 = new ArbolGeneral<Integer>(1);
		ArbolGeneral<Integer> a9 = new ArbolGeneral<Integer>(9);
		ArbolGeneral<Integer> a10 = new ArbolGeneral<Integer>(10);
		
		/*
				 8
			  /     \
		    3        5
		  / | \    / | \
		  4 7 6   1  9  10
		    |
		    2
		
		*/
		
		aR.agregarHijo(a3);
		aR.agregarHijo(a5);
		a3.agregarHijo(a4);
		a3.agregarHijo(a7);
		a7.agregarHijo(a2);
		a3.agregarHijo(a6);
		a5.agregarHijo(a1);
		a5.agregarHijo(a9);
		a5.agregarHijo(a10);
		
		ListaGenerica<Integer> camino = caminoAHojaMasLejana(aR);
		System.out.print("Camino más largo: ");
		while(! camino.fin())
			System.out.print(camino.proximo() + " ");
		
		//otro ej, más abajo
		System.out.println("Los elem no repetidos del nivel 1 son: " + elementosNoRepetidos(aR, 1));
	}
	
	
	public static ListaGenerica<Integer> caminoAHojaMasLejana(ArbolGeneral<Integer> a) {
		ListaGenerica<Integer> camino = new ListaEnlazadaGenerica<Integer>();
		ListaGenerica<Integer> camMasLargo = new ListaEnlazadaGenerica<Integer>();
		if(! a.esVacio())
			caminoAHojaMasLejanaRec(a, camino, camMasLargo);
		return camMasLargo;
	}
	private static void caminoAHojaMasLejanaRec(ArbolGeneral<Integer> a, ListaGenerica<Integer> camAct, ListaGenerica<Integer> camMaximo) {
		camAct.agregarFinal(a.getDato()); //agrego el elemento
		
		if(a.esHoja()) {
			if(camAct.tamanio() > camMaximo.tamanio()) {
				camMaximo.eliminarTodos();
				camAct.comenzar(); //voy al inicio del camino actual (nuevo mayor) - NO uso clonar() xq cada vez crea una nueva lista
				while(! camAct.fin())
					camMaximo.agregarFinal(camAct.proximo());
			}
		
		}else {
			ListaGenerica<ArbolGeneral<Integer>> hijos = a.getHijos();
			hijos.comenzar();
			while(! hijos.fin()) {
				caminoAHojaMasLejanaRec(hijos.proximo(), camAct, camMaximo);
				camAct.eliminarEn(camAct.tamanio());
			}
		}
		//return camMaximo; -> lista es dinamica se vuelve solite
	}
	
	
	/*
	 * OTRO ejercicio
	Implemente en la clase ContadorArbol el método:
		"public static ListaEnlazadaGenerica<Integer> elementosNoRepetidos(ArbolGeneral<Integer> a, Integer n)"
		El cual retorna una lista con todos los elementos que se encuentran en el nivel
		n del árbol. No devuelve repetidos.
	 */
	
	
	public static ListaEnlazadaGenerica<Integer> elementosNoRepetidos(ArbolGeneral<Integer> a, Integer n){
		ListaEnlazadaGenerica<Integer> lista = new ListaEnlazadaGenerica<Integer>();
		ColaGenerica<ArbolGeneral<Integer>> c = new ColaGenerica<ArbolGeneral<Integer>>();
		Integer nivelAct = 0;
		c.encolar(a);
		c.encolar(null);
		while( (! c.esVacia()) && (nivelAct <= n)) {
			ArbolGeneral<Integer> arbolAux = c.desencolar();
			if(a != null) {
				if( (nivelAct == n) && (! lista.incluye(arbolAux.getDato())) ) {
					lista.agregarFinal(arbolAux.getDato());
				}
				ListaGenerica<ArbolGeneral<Integer>> hijos = a.getHijos();
				hijos.comenzar();
				while(! hijos.fin()) {
					c.encolar(hijos.proximo());
				}
			}else {
				if(! c.esVacia()) {
					nivelAct++;
					c.encolar(null);
				}
			}
		}
		return lista;
	}

}
