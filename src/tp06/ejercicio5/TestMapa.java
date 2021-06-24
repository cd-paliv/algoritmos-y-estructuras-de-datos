package tp06.ejercicio5;

import tp02.ejercicio2.*;
import tp06.ejercicio3.*;
import tp06.ejercicio4.Recorridos;

public class TestMapa {

	public static void main(String[] args) {
		// devolverCamino
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
		
		System.out.println("DFS: " + new Recorridos<String>().DFS(grafo));
		
		//---------------------------------x------------------------------------
		Mapa mTest = new Mapa(grafo);
		
		System.out.println("devolverCamino de E a C: " + mTest.devolverCamino("E", "C"));
		
		ListaGenerica<String> lis = new ListaEnlazadaGenerica<String>(); lis.agregarInicio("B");
		System.out.println("devolverCamino de E a C exceptuando \"B\": " + mTest.devolverCaminoExceptuando("E", "C", lis));
		
		System.out.println("caminoMasCorto de E a C: " + mTest.caminoMasCorto("E", "C"));
		
		lis = mTest.caminoSinCargarCombustible("E", "C", 5); //5 alcanza, 2 no
		System.out.println("caminoSinCargarCombustible de E a C: " + (lis.esVacia() ? "No alcanza la nafta en tanque para terminar el camino" : lis));
		
		
	}

}
