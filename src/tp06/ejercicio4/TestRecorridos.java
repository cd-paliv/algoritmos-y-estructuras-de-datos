package tp06.ejercicio4;

import tp02.ejercicio2.*;
import tp06.ejercicio3.*;

public class TestRecorridos {

	public static void main(String[] args) {
		
		System.out.println("GRAFO:");
		GrafoImplListAdy<String> grafo = new GrafoImplListAdy<String>();
		
		VerticeImplListAdy<String> vA = new VerticeImplListAdy<String>("A"); grafo.agregarVertice(vA);
		VerticeImplListAdy<String> vB = new VerticeImplListAdy<String>("B"); grafo.agregarVertice(vB);
		VerticeImplListAdy<String> vC = new VerticeImplListAdy<String>("C"); grafo.agregarVertice(vC);
		VerticeImplListAdy<String> vD = new VerticeImplListAdy<String>("D"); grafo.agregarVertice(vD);
		VerticeImplListAdy<String> vE = new VerticeImplListAdy<String>("E"); grafo.agregarVertice(vE);
		
		grafo.conectar(vA, vB); grafo.conectar(vA, vC); grafo.conectar(vA, vD);
		grafo.conectar(vB, vD); grafo.conectar(vB, vE);
		grafo.conectar(vC, vE);
		grafo.conectar(vD, vA); grafo.conectar(vD, vE);
		grafo.conectar(vE, vB); grafo.conectar(vE, vD);
		
		/*
		 * A -----> C
		 *||  \     |
		 *||    B   |
		 *||  /  \\ |
		 * D <----> E
		 */
		
		
		ListaGenerica<String> lisDFS = new Recorridos<String>().DFS(grafo);
		System.out.println("DFS: " + lisDFS); //A -> B -> D -> E -> C
		ListaGenerica<String> lisBFS = new Recorridos<String>().BFS(grafo);
		System.out.println("BFS: " + lisBFS); //A -> B -> C -> D -> E
	}

}
