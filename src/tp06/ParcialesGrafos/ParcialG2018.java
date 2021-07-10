package tp06.ParcialesGrafos;

import tp02.ejercicio2.*;
import tp02.ejercicio3.ColaGenerica;
import tp06.ejercicio3.*;

public class ParcialG2018 {

	/*
	 * Sea un grado en donde cada nodo tiene un color (blanco o gris), usted debe devolver el camino
	 * 		que comienza en un origen, llega a un destino y pasa alternadamente por nodos de distinto
	 * 		color (NO puede repetir nodos).
	 * 		Implemente el metodo ListaGenerica<???> devolverRecorrido(Grafo<???> grafo)
	 */
	
	public ListaGenerica<String> devolverRecorrido(Grafo<String> grafo){
		ListaGenerica<String> resultado = new ListaEnlazadaGenerica<String>();
		if(! grafo.esVacio()) {
			ListaGenerica<Vertice<String>> listaVertices = grafo.listaDeVertices();
			boolean[] visitados = new boolean[listaVertices.tamanio() + 1];
			ColaGenerica<Vertice<String>> cola = new ColaGenerica<Vertice<String>>();
			Vertice<String> vIni = listaVertices.proximo();
			visitados[vIni.getPosicion()] = true;
			cola.encolar(vIni);
			while(! cola.esVacia()) {
				Vertice<String> v = cola.desencolar();
				String colorAct = v.dato();
				resultado.agregarFinal(colorAct);
				boolean sigo = false;
				ListaGenerica<Arista<String>> adyacentes =  grafo.listaDeAdyacentes(v); //pido sus adyacentes para recorrerlos
				adyacentes.comenzar();
				while((! adyacentes.fin()) && (! sigo)) {
					Vertice<String> w = adyacentes.proximo().verticeDestino();
					if((! visitados[w.getPosicion()])) { 
						visitados[w.getPosicion()] = true;
						if(! w.dato().equals(colorAct)) {
							cola.encolar(w);
							sigo = true;
						}
					}
				}
			}
		}
		return resultado;
	}
	
	
	//main
	public static void main(String[] args) {
		
		GrafoImplListAdy<String> grafo = new GrafoImplListAdy<String>();
		
		VerticeImplListAdy<String> vA = new VerticeImplListAdy<String>("Blanco"); grafo.agregarVertice(vA);
		VerticeImplListAdy<String> vB = new VerticeImplListAdy<String>("Blanco"); grafo.agregarVertice(vB);
		VerticeImplListAdy<String> vC = new VerticeImplListAdy<String>("Blanco"); grafo.agregarVertice(vC);
		VerticeImplListAdy<String> vD = new VerticeImplListAdy<String>("Gris"); grafo.agregarVertice(vD);
		VerticeImplListAdy<String> vE = new VerticeImplListAdy<String>("Gris"); grafo.agregarVertice(vE);
		VerticeImplListAdy<String> vF = new VerticeImplListAdy<String>("Blanco"); grafo.agregarVertice(vF);
		VerticeImplListAdy<String> vG = new VerticeImplListAdy<String>("Gris"); grafo.agregarVertice(vG);
		
		grafo.conectar(vA, vB); grafo.conectar(vB, vA);
		grafo.conectar(vA, vG); grafo.conectar(vG, vA);
		grafo.conectar(vA, vF); grafo.conectar(vF, vA);
		grafo.conectar(vB, vC); grafo.conectar(vC, vB);
		grafo.conectar(vB, vG); grafo.conectar(vG, vB);
		grafo.conectar(vG, vC); grafo.conectar(vC, vG);
		grafo.conectar(vC, vD); grafo.conectar(vD, vC);
		grafo.conectar(vG, vD); grafo.conectar(vD, vG);
		grafo.conectar(vD, vE); grafo.conectar(vE, vD);
		grafo.conectar(vG, vE); grafo.conectar(vE, vG);
		grafo.conectar(vG, vF); grafo.conectar(vF, vG);
		grafo.conectar(vF, vE); grafo.conectar(vE, vF);
		
		System.out.println(new ParcialG2018().devolverRecorrido(grafo));
	}
}
