package CodigosCualquiera.XGrafos;
import tp02.ejercicio2.*;
import tp02.ejercicio3.ColaGenerica;
import tp06.ejercicio3.*;

public class Recorridos<T> {
	
	
	/* Dado un grafo orientado y valorado positivamente, implemente un método que retorne una lista con todos los caminos cuyo costo
	 * 	total sea igual a 10. Se considera costo total del camino a la suma de los costos de las aristas que forman parte del camino,
	 * 	desde un vértice origen a un vértice destino.
	 
	public ListaGenerica<ListaGenerica<Vertice<T>>> dfsConCosto(Grafo<T> grafo){
		boolean[] marca = new boolean[grafo.listaDeVertices().tamanio() + 1]; //+1 para que el vector coincida con el nro de vertices
		ListaGenerica<Vertice<T>> lis = null;
		ListaGenerica<ListaGenerica<Vertice<T>>> recorridos = new ListaEnlazadaGenerica<ListaEnlazadaGenerica<Vertice<T>>>();
		int costo = 0;
		for (int i = 1; i <= grafo.listaDeVertices().tamanio(); i++) {
			lis = new ListaEnlazadaGenerica<Vertice<T>>();
			lis.agregarInicio(grafo.listaDeVertices().elemento(i));
			marca[i] = true;
			this.dfsConCosto(i, grafo, lis, marca, costo, recorridos);
			marca[i] = false;
		}
		return recorridos;
	}
	
	//la lista es el recorrido actual que va evaluando si el camino es igual a 10 o no
	//recorridos es la lista de listas que guarda la lista actual si es igual a 10
	private void dfsConCosto(int i, Grafo<T> grafo, ListaGenerica<Vertice<T>> lista, boolean[] marca, int costo, ListaGenerica<ListaGenerica<Vertice<T>>> recorridos) {
		Vertice<T> vDestino = null;
		int p = 0, j = 0;
		Vertice<T> v = grafo.listaDeVertices().elemento(i);
		ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(v);
		ady.comenzar();
		while(! ady.fin()) {
			Arista<T> arista = ady.proximo();
			j = arista.verticeDestino().getPosicion();
			if(! marca[j]) {
				p = arista.peso();
				if((costo+p) <= 10) {
					vDestino = arista.verticeDestino();
					lista.agregarFinal(vDestino);
					marca[j] = true;
					if((costo+p) == 10)
						recorridos.agregarFinal(lista.clonar()); //si es lo que busco guardo el camino encontrado en la lista de caminos que me interesan
					else
						this.dfsConCosto(j, grafo, lista, marca, costo+p, recorridos); //si no es igual a 10 tiro dfs otra vez
					lista.eliminar(vDestino);
					marca[j] = false;
				}
			}
		}
	}*/
	
	//---------------------------------------------------------------------------------------------------
	
	/* Un poderoso virus de computadora infecta a cualquier computadora en 1 minuto, logrando infectas toda la red de una empresa con
	 * 	cientos de computadoras. Dado un grafo que representa las conexiones entre las computadoras de la empresa, y una computadora ya
	 * 	infectada, escriba un programa que permita determinar el tiempo que demora el virus en infectar el resto de computadoras.
	 * 	Asuma que todas las computadoras pueden ser infectada, no todas las computadoras tienen conexión directa entre sí, y un mismo
	 * 	virus puede infectar un grupo de computadoras al mismo tiempo, sin importar la cantidad.
	 */
	public static int calcularTiempoInfeccion(Grafo<String> g, VerticeImplListAdy<String> inicial) {
		int tiempo = 0;
		boolean visitados[] = new boolean[g.listaDeVertices().tamanio()+1];
		ColaGenerica<VerticeImplListAdy<String>> cola = new ColaGenerica<VerticeImplListAdy<String>>();
		visitados[inicial.getPosicion()] = true;
		cola.encolar(inicial);
		cola.encolar(null);
		while(! cola.esVacia()) {
			VerticeImplListAdy<String> v = cola.desencolar();
			if(v != null) {
				ListaGenerica<Arista<String>> adyacentes =  v.obtenerAdyacentes();
				adyacentes.comenzar();
				while(! adyacentes.fin()) {
					Arista<String> a = adyacentes.proximo();
					Vertice<String> w = a.verticeDestino();
					if(! visitados[w.getPosicion()]) {
						visitados[w.getPosicion()] = true;
						//cola.encolar(w); chequear esto?
					}
				}
			}else if(! cola.esVacia()) {
				tiempo++;
				cola.encolar(null);
			}
		}
		return tiempo;
	} //también podría ser dfs y calcular un máximo
}
