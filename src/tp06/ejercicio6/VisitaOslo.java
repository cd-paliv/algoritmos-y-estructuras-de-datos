package tp06.ejercicio6;

import tp02.ejercicio2.*;
import tp06.ejercicio3.*;

public class VisitaOslo {

	public ListaGenerica<String> paseoEnBici(Grafo<String> lugares, String destino, int maxTiempo, ListaGenerica<String> lugaresRestringidos){
		ListaGenerica<String> camino = new ListaEnlazadaGenerica<String>();
		
		Vertice<String> vAyuntamiento = buscarAyuntamiento(lugares);
		if(vAyuntamiento != null) {
			ListaGenerica<String> caminoTemporal = new ListaEnlazadaGenerica<String>();
			boolean[] visitados = new boolean[lugares.listaDeVertices().tamanio() + 1];
			paseoEnBici(vAyuntamiento, lugares, caminoTemporal, camino, visitados, destino, lugaresRestringidos, maxTiempo, 0);
		}
		
		return camino;
	}
	
	private boolean paseoEnBici(Vertice<String> vAct, Grafo<String> grafo, ListaGenerica<String> caminoAct, ListaGenerica<String> caminoMin,
											boolean[] visitados, String destino, ListaGenerica<String> lugaresRestringidos,
											int maxTiempo, int tiempoAct) {
		
		caminoAct.agregarFinal(vAct.dato());
		visitados[vAct.getPosicion()] = true;
		
		if(vAct.dato().equals(destino)) {
			if((caminoMin.esVacia()) || (caminoMin.tamanio() > caminoAct.tamanio())) {
				caminoMin.eliminarTodos();
				caminoAct.comenzar();
				while(! caminoAct.fin())
					caminoMin.agregarFinal(caminoAct.proximo());
				return true;
			}
		}
		boolean encontre = false;
		ListaGenerica<Arista<String>> listaAdy = grafo.listaDeAdyacentes(vAct);
		listaAdy.comenzar();
		while(! listaAdy.fin()) {
			Arista<String> ari = listaAdy.proximo();
			Vertice<String> vSig = ari.verticeDestino();
			if( (! visitados[vSig.getPosicion()]) && (tiempoAct + ari.peso() <= maxTiempo)
					&& (! lugaresRestringidos.incluye(vSig.dato())) && (! encontre)) {
				
				encontre = paseoEnBici(vSig, grafo, caminoAct, caminoMin, visitados, destino, lugaresRestringidos, maxTiempo, tiempoAct + ari.peso());
			}
		}
		
		caminoAct.eliminarEn(caminoAct.tamanio());
		visitados[vAct.getPosicion()] = false;
		
		return encontre;
	}
	
	
	
	private Vertice<String> buscarAyuntamiento(Grafo<String> grafo){
		boolean encontre = false;
		Vertice<String> v = null;
		ListaGenerica<Vertice<String>> lisV = grafo.listaDeVertices();
		lisV.comenzar();
		while(! lisV.fin() && (! encontre)) { //busco en todos los vertices
			v = lisV.proximo();
			if(v.dato() == "Ayuntamiento") {
				encontre = true;
			}
		}
		if(encontre)
			return v;
		else return null;
	}
}
