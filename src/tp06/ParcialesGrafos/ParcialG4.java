package tp06.ParcialesGrafos;

import tp02.ejercicio2.*;
import tp06.ejercicio3.*;

public class ParcialG4 {

	/*
	 * Implemente en la clase Parcial , el siguiente método:
			"??? resolver (Grafo<???> grafo, String origen, String destino)"
		Se quiere encontrar todos los caminos desde una ciudad origen a una ciudad destino pasando por una ciudad determinada,
			teniendo en cuenta que debido a la pandemia no todas las rutas existentes están habilitadas.
	 */
	
	public ListaGenerica<ListaGenerica<String>> resolver(Grafo<String> grafo, String origen, String destino, String pasandoPor){
		ListaGenerica<ListaGenerica<String>> caminoFinal = new ListaEnlazadaGenerica<ListaGenerica<String>>();
		if(! grafo.esVacio()) {
			ListaGenerica<String> caminoTemporal = new ListaEnlazadaGenerica<String>();
			ListaGenerica<Vertice<String>> listaVertices = grafo.listaDeVertices();
			boolean[] visitados = new boolean[listaVertices.tamanio() + 1];
			listaVertices.comenzar();
			while(! listaVertices.fin()) {
				Vertice<String> vIni = listaVertices.proximo();
				if(vIni.dato().equals(origen)) {
					resolver(vIni, grafo, caminoTemporal, caminoFinal, visitados, destino, pasandoPor);
					break;
				}
			}
		}
		return caminoFinal;
	}
	
	private void resolver(Vertice<String> vAct, Grafo<String> grafo, ListaGenerica<String> caminoAct, ListaGenerica<ListaGenerica<String>> caminos,
										boolean[] visitados, String destino, String pasandoPor) {
		caminoAct.agregarFinal(vAct.dato());
		visitados[vAct.getPosicion()] = true;
		
		if(vAct.dato().equals(destino)) {
			if(caminoAct.incluye(pasandoPor)) {
				caminos.agregarFinal(caminoAct.clonar());
			}
		} else {
			ListaGenerica<Arista<String>> listaAdy = grafo.listaDeAdyacentes(vAct);
			listaAdy.comenzar();
			while(! listaAdy.fin()) {
				Arista<String> ari = listaAdy.proximo();
				if(ari.peso() == 1) { //0 = NH | 1 = H
					Vertice<String> vSig = ari.verticeDestino();
					if(! visitados[vSig.getPosicion()]) {
						resolver(vSig, grafo, caminoAct, caminos, visitados, destino, pasandoPor);
					}				
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
			VerticeImplListAdy<String> vPinamar = new VerticeImplListAdy<String>("Pinamar"); grafo.agregarVertice(vPinamar);
			VerticeImplListAdy<String> vQuilmes = new VerticeImplListAdy<String>("Quilmes"); grafo.agregarVertice(vQuilmes);
			VerticeImplListAdy<String> vMoreno = new VerticeImplListAdy<String>("Moreno"); grafo.agregarVertice(vMoreno);
			VerticeImplListAdy<String> vCarlosKeen = new VerticeImplListAdy<String>("Carlos Keen"); grafo.agregarVertice(vCarlosKeen);
			VerticeImplListAdy<String> vSaladillo = new VerticeImplListAdy<String>("Saladillo"); grafo.agregarVertice(vSaladillo);
			VerticeImplListAdy<String> vLobos = new VerticeImplListAdy<String>("Lobos"); grafo.agregarVertice(vLobos);
			VerticeImplListAdy<String> vAbasto = new VerticeImplListAdy<String>("Abasto"); grafo.agregarVertice(vAbasto);
			VerticeImplListAdy<String> vCanuelas = new VerticeImplListAdy<String>("Cañuelas"); grafo.agregarVertice(vCanuelas);
			VerticeImplListAdy<String> vNavarro = new VerticeImplListAdy<String>("Navarro"); grafo.agregarVertice(vNavarro);
			VerticeImplListAdy<String> vSuipacha = new VerticeImplListAdy<String>("Suipacha"); grafo.agregarVertice(vSuipacha);
			
			grafo.conectar(vPinamar, vLaPlata, 1); grafo.conectar(vLaPlata, vPinamar, 1);
			grafo.conectar(vLaPlata, vQuilmes, 1); grafo.conectar(vQuilmes, vLaPlata, 1);
			grafo.conectar(vLaPlata, vAbasto, 1); grafo.conectar(vAbasto, vLaPlata, 1);
			grafo.conectar(vQuilmes, vMoreno, 0); grafo.conectar(vMoreno, vQuilmes, 0);
			grafo.conectar(vMoreno, vAbasto, 0); grafo.conectar(vAbasto, vMoreno, 0);
			grafo.conectar(vAbasto, vCarlosKeen, 1); grafo.conectar(vCarlosKeen, vAbasto, 1);
			grafo.conectar(vMoreno, vCarlosKeen, 1); grafo.conectar(vCarlosKeen, vMoreno, 1);
			grafo.conectar(vCarlosKeen, vSuipacha, 1); grafo.conectar(vSuipacha, vCarlosKeen, 1);
			grafo.conectar(vSuipacha, vNavarro, 1); grafo.conectar(vNavarro, vSuipacha, 1);
			grafo.conectar(vAbasto, vCanuelas, 1); grafo.conectar(vCanuelas, vAbasto, 1);
			grafo.conectar(vCanuelas, vNavarro, 1); grafo.conectar(vNavarro, vCanuelas, 1);
			grafo.conectar(vNavarro, vSaladillo, 1); grafo.conectar(vSaladillo, vNavarro, 1);
			grafo.conectar(vNavarro, vLobos, 0); grafo.conectar(vLobos, vNavarro, 0);
			
			System.out.println(new ParcialG4().resolver(grafo, "La Plata", "Suipacha", "Abasto"));
		}
}
