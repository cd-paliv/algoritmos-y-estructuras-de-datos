package tp06.ejercicio4;
import tp02.ejercicio2.*;
import tp02.ejercicio3.ColaGenerica;
import tp06.ejercicio3.*;

public class Recorridos<T> {

	/*
	 * Retorna una lista de vértices con el recorrido en profundidad del grafo
	 * 		recibido como parámetro
	 */
	public ListaGenerica<T> DFS(Grafo<T> grafo){ //O(|V| + |E|) -> lineal
		 ListaGenerica<T> resultado = new ListaEnlazadaGenerica<T>();
		 if (! grafo.esVacio()) {
			 ListaGenerica<Vertice<T>> listaVertices = grafo.listaDeVertices();
			 boolean[] visitados = new boolean[listaVertices.tamanio() + 1]; //+1 para que el vector coincida con el nro de vertices
			 listaVertices.comenzar();
			 while(! listaVertices.fin()) { //recorro TODOS los vertices
				 Vertice<T> vIni = listaVertices.proximo(); //vertice inicial
				 if(! visitados[vIni.getPosicion()]) { //si el vertice no está visitado
					 DFS(vIni, grafo, visitados, resultado); //mando dfs
				 }
			 }
		 }
		 return resultado;
	}
	private void DFS(Vertice<T> vAct, Grafo<T> g, boolean[] visitados, ListaGenerica<T> listaVertices) {
		visitados[vAct.getPosicion()] = true; //marco el vertice como visitado
		listaVertices.agregarFinal(vAct.dato());
		ListaGenerica<Arista<T>> listaAdyacentes = g.listaDeAdyacentes(vAct); //pido los adyacentes del vertice actual
		listaAdyacentes.comenzar();
		while(! listaAdyacentes.fin()) { //recorro adyacentes
			Vertice<T> vSig = listaAdyacentes.proximo().verticeDestino();
			if(! visitados[vSig.getPosicion()]) { //si NO fue visitado, tiro DFS recursivo
				DFS(vSig, g, visitados, listaVertices);
			}
		}
	}
	
	//dfs según cátedra
	public void DFSImprimir(Grafo<T> grafo) {
		boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];
		for(int i = 0; i <= grafo.listaDeVertices().tamanio()-1; i++) {
			if(marca[i])
				DFSImprimir(i, grafo, marca);
		}
	}
	private void DFSImprimir(int i, Grafo<T> grafo, boolean[] marca) {
		marca[i] = true;
		Vertice<T> v = grafo.listaDeVertices().elemento(i);
		System.out.print(v.dato());
		ListaGenerica<Arista<T>> Ady = grafo.listaDeAdyacentes(v);
		Ady.comenzar();
		while(! Ady.fin()) {
			int j = Ady.proximo().verticeDestino().getPosicion();
			if(! marca[j]) {
				DFSImprimir(j, grafo, marca);
			}
		}
	}
	
	
	
	/*
	 * Retorna una lista de vértices con el recorrido en amplitud del grafo
	 * 		recibido como parámetro.
	 */
	public ListaGenerica<T> BFS(Grafo<T> grafo){ //O(|V| + |E|) -> lineal
		ListaGenerica<T> resultado = new ListaEnlazadaGenerica<T>();
		if (! grafo.esVacio()) {
			 ListaGenerica<Vertice<T>> listaVertices = grafo.listaDeVertices();
			 boolean[] visitados = new boolean[listaVertices.tamanio() + 1];
			 listaVertices.comenzar();
			 while(! listaVertices.fin()) {
				 Vertice<T> vAct = listaVertices.proximo();
				 if(! visitados[vAct.getPosicion()]) {
					 BFS(vAct, grafo, visitados, resultado);
				 }
			 }
		 }
		 return resultado;
	}
	private void BFS(Vertice<T> vIni, Grafo<T> g, boolean[] visitados, ListaGenerica<T> listaVertices) {
		ColaGenerica<Vertice<T>> cola = new ColaGenerica<Vertice<T>>();
		visitados[vIni.getPosicion()] = true;
		cola.encolar(vIni);
		while(! cola.esVacia()) {
			Vertice<T> v = cola.desencolar();
			listaVertices.agregarFinal(v.dato()); //lo guardo
			ListaGenerica<Arista<T>> adyacentes =  g.listaDeAdyacentes(v); //pido sus adyacentes para recorrerlos
			adyacentes.comenzar();
			while(! adyacentes.fin()) {
				Vertice<T> w = adyacentes.proximo().verticeDestino();
				if(! visitados[w.getPosicion()]) { //si no fue visitado
					visitados[w.getPosicion()] = true; //lo marco como visitado
					cola.encolar(w); //y lo encolo
				} //si fue visitado no me interesa
			}
		}
	}
	
	/*
	 * Retorna la lista de ciudades que se deben atravesar para ir de ciudad1 a ciudad2 en caso que se pueda 
			llegar, si no retorna la lista vacía. (Sin tener en cuenta el combustible).
	 
	public ListaGenerica<String> devolverCamino(String ciudad1, String ciudad2){
		
	}*/
}
