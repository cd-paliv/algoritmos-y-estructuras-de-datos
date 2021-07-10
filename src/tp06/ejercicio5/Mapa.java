package tp06.ejercicio5;

import tp02.ejercicio2.*;
import tp06.ejercicio3.*;

public class Mapa {
	private Grafo<String> mapaCiudades;
	
	public Mapa(Grafo<String> grafo) {
		super();
		mapaCiudades = grafo;
	}
	
	/* **Retorna la lista de ciudades que se deben atravesar para ir de ciudad1 a ciudad2 en caso que se pueda 
			llegar, si no retorna la lista vacía. (Sin tener en cuenta el combustible)
	 ***/
	public ListaGenerica<String> devolverCamino(String ciudad1, String ciudad2){
		ListaGenerica<String> caminoFinal = new ListaEnlazadaGenerica<String>();
		if(! mapaCiudades.esVacio()) {
			ListaGenerica<Vertice<String>> listaVertices = mapaCiudades.listaDeVertices();
			boolean[] marca = new boolean[listaVertices.tamanio() + 1];
			listaVertices.comenzar();
			while(! listaVertices.fin()) {
				Vertice<String> vIni = listaVertices.proximo();
				if(vIni.dato().equals(ciudad1)) { //si no es el dato con el que quiero empezar, no tiro dfs
					devolverCamino(vIni, mapaCiudades, caminoFinal, marca, ciudad2);
					break;
				}
			}
		}
		return caminoFinal;
	}
	private boolean devolverCamino(Vertice<String> vAct, Grafo<String> grafo, ListaGenerica<String> camino, boolean[] visitados, String destino) {
		camino.agregarFinal(vAct.dato());
		visitados[vAct.getPosicion()] = true;
		if(vAct.dato().equals(destino)) //si lo encontré, lo marco como visitado, lo agrego al camino y corto la recursión
			return true;
		boolean encontre = false;
		ListaGenerica<Arista<String>> listaAdy = grafo.listaDeAdyacentes(vAct);
		listaAdy.comenzar();
		while( (! listaAdy.fin()) && (! encontre) ) { //si no recorro los adyacentes de ese vertice
			Vertice<String> vSig = listaAdy.proximo().verticeDestino();
			if(! visitados[vSig.getPosicion()]) {
				encontre = devolverCamino(vSig, grafo, camino, visitados, destino);
			}
		}
		if(! encontre) {
			camino.eliminarEn(camino.tamanio()); //si no lo encontré, elimino el último dato procesado (en cada recursión)
			visitados[vAct.getPosicion()] = false;
		}
		return encontre;
	}
	
	/* **Retorna la lista de ciudades que forman un camino desde ciudad1 a ciudad2, sin pasar por las ciudades que están
	 * 		contenidas en la lista ciudades pasada por parámetro, si no existe camino retorna la lista vacía. (Sin tener en
	 * 		cuenta el combustible)
	 ***/
	public ListaGenerica<String> devolverCaminoExceptuando(String ciudad1, String ciudad2, ListaGenerica<String> ciudades){
		ListaGenerica<String> caminoFinal = new ListaEnlazadaGenerica<String>();
		if(! mapaCiudades.esVacio()) {
			ListaGenerica<Vertice<String>> listaVertices = mapaCiudades.listaDeVertices();
			boolean[] marca = new boolean[listaVertices.tamanio() + 1];
			listaVertices.comenzar();
			while(! listaVertices.fin()) {
				Vertice<String> vIni = listaVertices.proximo();
				if(vIni.dato().equals(ciudad1)) {
					devolverCaminoExceptuando(vIni, mapaCiudades, caminoFinal, marca, ciudad2, ciudades);
					break;
				}
			}
		}
		return caminoFinal;
	}
	private boolean devolverCaminoExceptuando(Vertice<String> vAct, Grafo<String> grafo, ListaGenerica<String> camino, boolean[] visitados,
														String destino, ListaGenerica<String> ciudadesProhibidas) {
		camino.agregarFinal(vAct.dato());
		visitados[vAct.getPosicion()] = true;
		if(vAct.dato().equals(destino))
			return true;
		
		boolean encontre = false;
		ListaGenerica<Arista<String>> listaAdy = grafo.listaDeAdyacentes(vAct);
		listaAdy.comenzar();
		while( (! listaAdy.fin()) && (! encontre) ) {
			Vertice<String> vSig = listaAdy.proximo().verticeDestino();
			if( (! ciudadesProhibidas.incluye(vSig.dato())) && (! visitados[vSig.getPosicion()]) ) //si el dato no está en la lista de ciudades a no visitar y no fue visitado aun
				encontre = devolverCaminoExceptuando(vSig, grafo, camino, visitados, destino, ciudadesProhibidas);
		}
		
		if(! encontre) {
			camino.eliminarEn(camino.tamanio());
			visitados[vAct.getPosicion()] = false;
		}
		
		return encontre;
	}
	
	/*	Retorna la lista de ciudades que forman el camino más corto para llegar de ciudad1 a ciudad2, si no 
			existe camino retorna la lista vacía. (Las rutas poseen la distancia). (Sin tener en cuenta el 
			combustible)
	 */
	public ListaGenerica<String> caminoMasCorto(String ciudad1, String ciudad2){
		ListaGenerica<String> caminoMin = new ListaEnlazadaGenerica<String>();
		if(! mapaCiudades.esVacio()) {
			ListaGenerica<Vertice<String>> listaVertices = mapaCiudades.listaDeVertices();
			boolean[] visitados = new boolean[listaVertices.tamanio() + 1];
			listaVertices.comenzar();
			while(! listaVertices.fin()) {
				Vertice<String> vIni = listaVertices.proximo();
				if(vIni.dato().equals(ciudad1)) {
					caminoMasCorto(vIni, mapaCiudades, new ListaEnlazadaGenerica<String>(), caminoMin, visitados, ciudad2);
					break;
				}
			}
		}
		return caminoMin;
	}
	private void caminoMasCorto(Vertice<String> vAct, Grafo<String> grafo, ListaGenerica<String> caminoAct, ListaGenerica<String> caminoMin,
										boolean[] visitados, String destino) {
		caminoAct.agregarFinal(vAct.dato());
		visitados[vAct.getPosicion()] = true;
		
		if(vAct.dato().equals(destino)) {
			if((caminoMin.esVacia()) || (caminoMin.tamanio() > caminoAct.tamanio())) { //si encontre un nuevo min
				caminoMin.eliminarTodos();
				caminoAct.comenzar();
				while(! caminoAct.fin()) {
					caminoMin.agregarFinal(caminoAct.proximo()); //lo reemplazo
				}
			}
		}
		
		ListaGenerica<Arista<String>> listaAdy = grafo.listaDeAdyacentes(vAct);
		listaAdy.comenzar();
		while(! listaAdy.fin()) {
			Vertice<String> vSig = listaAdy.proximo().verticeDestino();
			if(! visitados[vSig.getPosicion()]) {
				caminoMasCorto(vSig, grafo, caminoAct, caminoMin, visitados, destino);
			}
		}
		
		caminoAct.eliminarEn(caminoAct.tamanio());
		visitados[vAct.getPosicion()] = false;
	}
	
	/*	Retorna la lista de ciudades que forman un camino para llegar de ciudad1 a ciudad2. El auto no debe quedarse
	 * 		sin combustible y no puede cargar. Si no existe camino retorna la lista vacía.
	 * */
	public ListaGenerica<String> caminoSinCargarCombustible(String ciudad1, String ciudad2, int tanqueAuto) {
		ListaGenerica<String> caminoSinGastar = new ListaEnlazadaGenerica<String>();
		if(! mapaCiudades.esVacio()) {
			ListaGenerica<Vertice<String>> listaVertices = mapaCiudades.listaDeVertices();
			boolean[] visitados = new boolean[listaVertices.tamanio() + 1];
			listaVertices.comenzar();
			while(! listaVertices.fin()) {
				Vertice<String> vIni = listaVertices.proximo();
				if(vIni.dato().equals(ciudad1)) {
					caminoSinCargarCombustible(vIni, mapaCiudades, caminoSinGastar, visitados, ciudad2, tanqueAuto);
					break;
				}
			}
		}
		return caminoSinGastar;
	}
	private boolean caminoSinCargarCombustible(Vertice<String> vAct, Grafo<String> grafo, ListaGenerica<String> camino,
														boolean[] visitados, String destino, int tanque) {
		camino.agregarFinal(vAct.dato());
		visitados[vAct.getPosicion()] = true;
		if(vAct.dato().equals(destino)) 
			return true;
		
		boolean encontre = false;
		ListaGenerica<Arista<String>> listaAdy = grafo.listaDeAdyacentes(vAct);
		listaAdy.comenzar();
		while( (! listaAdy.fin()) && (! encontre) ) {
			Arista<String> ariSig = listaAdy.proximo();
			Vertice<String> vSig = ariSig.verticeDestino();
			if(! visitados[vSig.getPosicion()]) {
				if(ariSig.peso() < tanque) { //si no me alcanza la nafta no hago el viaje
					encontre = caminoSinCargarCombustible(vSig, grafo, camino, visitados, destino, (tanque - ariSig.peso()));
				}
			}
		}
		
		if(! encontre) {
			camino.eliminarEn(camino.tamanio());
			visitados[vAct.getPosicion()] = false;
		}
		return encontre;
	}
	
	/*	Retorna la lista de ciudades que forman un camino para llegar de ciudad1 a ciudad2 teniendo en cuenta que el auto
	 * 		debe cargar la menor cantidad de veces. El auto no se debe quedar sin combustible en medio de una ruta, además
	 * 		puede completar su tanque al llegar a cualquier ciudad. Si no existe camino retorna la lista vacía.
	 * */
	public ListaGenerica<String> caminoConMenorCargaDeCombustible(String ciudad1, String ciudad2, int tanqueAuto){
		ListaGenerica<String> caminoMenosCombustible = new ListaEnlazadaGenerica<String>();
		if(! mapaCiudades.esVacio()) {
			int[] menorCarga = { 15 };
			ListaGenerica<Vertice<String>> listaVertices = mapaCiudades.listaDeVertices();
			boolean[] visitados = new boolean[listaVertices.tamanio() + 1];
			listaVertices.comenzar();
			while(! listaVertices.fin()) {
				Vertice<String> vIni = listaVertices.proximo();
				if(vIni.dato().equals(ciudad1)) {
					caminoConMenorCargaDeCombustible(vIni, mapaCiudades, new ListaEnlazadaGenerica<String>(), caminoMenosCombustible, visitados, ciudad2, tanqueAuto, tanqueAuto, 1, menorCarga);
					break;
				}
			}
		}
		return caminoMenosCombustible;
	}
	private void caminoConMenorCargaDeCombustible(Vertice<String> vAct, Grafo<String> grafo, ListaGenerica<String> caminoAct,
														ListaGenerica<String> caminoGastoMin, boolean[] visitados, String destino,
														int tanqueLleno, int tanqueAct, int cargas, int[] menorCarga) { //paso menorcarga en array para que sea dinamico
		caminoAct.agregarFinal(vAct.dato());
		visitados[vAct.getPosicion()] = true;
		if(vAct.dato().equals(destino)) {
			if(cargas < menorCarga[0]) { //si encontre un nuevo min
				menorCarga[0] = cargas; //actualizo
				caminoGastoMin.eliminarTodos();
				caminoAct.comenzar();
				while(! caminoAct.fin()) {
					caminoGastoMin.agregarFinal(caminoAct.proximo()); //lo reemplazo
				}
			}
		} else {
			//visitados[vAct.getPosicion()] = true;
			ListaGenerica<Arista<String>> listaAdy = grafo.listaDeAdyacentes(vAct);
			listaAdy.comenzar();
			while(! listaAdy.fin()) {
				Arista<String> ari = listaAdy.proximo();
				Vertice<String> vSig = ari.verticeDestino();
				if((! visitados[vSig.getPosicion()]) && (ari.peso() < tanqueLleno)) { 
					if(tanqueAct < ari.peso()) { //si la cant de nafta que tengo es menor que la que tengo que gastar
						caminoConMenorCargaDeCombustible(vSig, grafo, caminoAct, caminoGastoMin, visitados, destino, tanqueLleno, tanqueAct - ari.peso(), cargas + 1, menorCarga); //cargo nafta
					} else {
						caminoConMenorCargaDeCombustible(vSig, grafo, caminoAct, caminoGastoMin, visitados, destino, tanqueLleno, tanqueAct - ari.peso(), cargas, menorCarga);
					}
				}
			}
			
			visitados[vAct.getPosicion()] = false;
		}
		
		caminoAct.eliminarEn(caminoAct.tamanio());
	}
}
