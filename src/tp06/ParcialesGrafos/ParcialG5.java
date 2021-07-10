package tp06.ParcialesGrafos;

import tp02.ejercicio2.*;
import tp06.ejercicio3.*;

public class ParcialG5 {

	/*
	 * Implemente la clase Parcial y el método
	 * 		"ListaGenerica<String> resolver(Grafo<ParcialG1Obj> grafo, String origen, String destino, int distanciaEvitar)
	 * Se quiere obtener el camino que permite llegar desde un origen a un destino, visitando la mayor cantidad de lugares pero
	 * 		teniendo en cuenta que no se quiere viajar más de x kms.
	 * 		
	 */
	
	public ListaGenerica<String> resolver(Grafo<String> grafo, String origen, String destino, int distanciaEvitar){
		ListaGenerica<String> caminoFinal = new ListaEnlazadaGenerica<String>();
		if(! grafo.esVacio()) {
			Vertice<String> vIni = null;
			Vertice<String> vFin = null;
			
			ListaGenerica<String> caminoTemporal = new ListaEnlazadaGenerica<String>();
			ListaGenerica<Vertice<String>> listaV = grafo.listaDeVertices();
			boolean[] marca = new boolean[listaV.tamanio() + 1];
			listaV.comenzar();
			
			while( ! listaV.fin() ) {
				Vertice<String> vAct = listaV.proximo();
				if(vAct.dato().equals(origen))
					vIni = vAct;
				if(vAct.dato().equals(destino))
					vFin = vAct;
				if( (vIni != null) && (vFin != null) ) {
					resolver(vIni, grafo, caminoFinal, caminoTemporal, marca, destino, 0, distanciaEvitar);
					break;
				}
			}
		}
		
		return caminoFinal;
	}
	
	private void resolver(Vertice<String> vAct, Grafo<String> grafo, ListaGenerica<String> camino, ListaGenerica<String> caminoAct, boolean[] visitados,
													String destino, int kmAct, int kmLimite) {
		
		caminoAct.agregarFinal(vAct.dato());
		visitados[vAct.getPosicion()] = true;
		
		if(vAct.dato().equals(destino)) {
			if( (camino.esVacia()) || (camino.tamanio() < caminoAct.tamanio()) ) {
				camino.eliminarTodos();
				caminoAct.comenzar();
				while(! caminoAct.fin()) {
					camino.agregarFinal(caminoAct.proximo()); //lo reemplazo
				}
			}
		} else {
			ListaGenerica<Arista<String>> listaAdy = grafo.listaDeAdyacentes(vAct);
			listaAdy.comenzar();
			while(! listaAdy.fin()) {
				Arista<String> ari = listaAdy.proximo();
				Vertice<String> vSig = ari.verticeDestino();
				if( (! visitados[vSig.getPosicion()]) && (kmAct + ari.peso() <= kmLimite) ) {
					resolver(vSig, grafo, camino, caminoAct, visitados, destino, kmAct + ari.peso(), kmLimite);
				}
			}
		}
		
		caminoAct.eliminarEn(caminoAct.tamanio());
		visitados[vAct.getPosicion()] = false;
	}
	
	
	
	//main
	public static void main(String[] args) {
		GrafoImplListAdy<String> grafo = new GrafoImplListAdy<String>();
		
		VerticeImplListAdy<String> vLaPlata = new VerticeImplListAdy<String>("La Plata"); grafo.agregarVertice(vLaPlata);
		VerticeImplListAdy<String> vQuilmes = new VerticeImplListAdy<String>("Quilmes"); grafo.agregarVertice(vQuilmes);
		VerticeImplListAdy<String> vLosHornos = new VerticeImplListAdy<String>("Los Hornos"); grafo.agregarVertice(vLosHornos);
		VerticeImplListAdy<String> vArana = new VerticeImplListAdy<String>("Arana"); grafo.agregarVertice(vArana);
		VerticeImplListAdy<String> vAbasto = new VerticeImplListAdy<String>("Abasto"); grafo.agregarVertice(vAbasto);
		VerticeImplListAdy<String> vVillaE = new VerticeImplListAdy<String>("Villa Elisa"); grafo.agregarVertice(vVillaE);
		VerticeImplListAdy<String> vDomselaar = new VerticeImplListAdy<String>("Domselaar"); grafo.agregarVertice(vDomselaar);
		
		grafo.conectar(vLaPlata, vQuilmes, 55); grafo.conectar(vQuilmes, vLaPlata, 55);
		grafo.conectar(vQuilmes, vVillaE, 32); grafo.conectar(vVillaE, vQuilmes, 32);
		grafo.conectar(vLaPlata, vLosHornos, 10); grafo.conectar(vLosHornos, vLaPlata, 10);
		grafo.conectar(vLosHornos, vAbasto, 25); grafo.conectar(vAbasto, vLosHornos, 25);
		grafo.conectar(vLosHornos, vVillaE, 15); grafo.conectar(vVillaE, vLosHornos, 15);
		grafo.conectar(vLaPlata, vArana, 25); grafo.conectar(vArana, vLaPlata, 25);
		grafo.conectar(vArana, vAbasto, 5); grafo.conectar(vAbasto, vArana, 5);
		grafo.conectar(vAbasto, vDomselaar, 40); grafo.conectar(vDomselaar, vAbasto, 40);
		grafo.conectar(vVillaE, vDomselaar, 25); grafo.conectar(vDomselaar, vVillaE, 25);
		
		System.out.println(new ParcialG5().resolver(grafo, "La Plata", "Domselaar", 100));
		
	}
}
