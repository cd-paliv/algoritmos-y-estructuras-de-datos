package CodigosCualquiera.XGrafos;

import tp02.ejercicio2.*;
import tp06.ejercicio3.*;
//import tp06.ejercicio4.Recorridos;

public class BuscadorCaminoMasCortoCaperucitaTest {

	public static void main(String[] args) {
		
		Grafo<String> grafo = new GrafoImplListAdy<String>();
		
		Vertice<String> vCasaC = new VerticeImplListAdy<String>("Casa de Caperucita"); grafo.agregarVertice(vCasaC);
		Vertice<String> vClaro1 = new VerticeImplListAdy<String>("Claro 1"); grafo.agregarVertice(vClaro1);
		Vertice<String> vClaro2 = new VerticeImplListAdy<String>("Claro 2"); grafo.agregarVertice(vClaro2);
		Vertice<String> vClaro3 = new VerticeImplListAdy<String>("Claro 3"); grafo.agregarVertice(vClaro3);
		Vertice<String> vClaro4 = new VerticeImplListAdy<String>("Claro 4"); grafo.agregarVertice(vClaro4);
		Vertice<String> vClaro5 = new VerticeImplListAdy<String>("Claro 5"); grafo.agregarVertice(vClaro5);
		Vertice<String> vCasaA = new VerticeImplListAdy<String>("Casa Abuelita"); grafo.agregarVertice(vCasaA);
		
		//grafo.conectar(vCasaC, vClaro1, 3);
		grafo.conectar(vClaro1, vClaro2, 4); grafo.conectar(vClaro1, vClaro5, 3);
		grafo.conectar(vCasaC, vClaro2, 4); grafo.conectar(vClaro2, vClaro4, 10);grafo.conectar(vClaro2, vClaro5);
		grafo.conectar(vCasaC, vClaro3, 4); grafo.conectar(vClaro3, vClaro5, 15);
		grafo.conectar(vClaro4, vCasaA, 9); grafo.conectar(vClaro5, vCasaA, 4);
		
		//System.out.println("DFS: " + new Recorridos<String>().DFS(grafo));
		
		/*
		 * 			C3
		 * 	  /     		\
		 * CC	-	C1	-	C5	-	CA
		 * 	  \		|	 /  		/
		 * 			C2    - 	C4
		 */
		
		ListaGenerica<String> lisAct = new BuscadorCaminoMasCortoCaperucita(grafo).recorridoMasCortoYSeguro();
		System.out.println("El camino más corto y seguro para caperucita es: " +
								(lisAct.esVacia() ? "No se encontró un camino" : lisAct));
	}

}
