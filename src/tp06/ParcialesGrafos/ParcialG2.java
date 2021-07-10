package tp06.ParcialesGrafos;

import tp02.ejercicio2.*;
import tp06.ejercicio3.*;

public class ParcialG2 {

	/*
	 * Implemente en la clase Parcial , el siguiente método:
			"??? resolver (Grafo<???> grafo, String origen, String destino)"
		Se cuenta con un mapa de ciudades y rutas que las conectan. Debido a la pandemia, hay ciudades que 
			se encuentran en fase 1 debido a la cantidad de casos positivos de covid. Además del nombre, la
			ciudad tiene un dato informativo que indica en qué nro de fase está cada ciudad actualmente.
			Debe devolver el listado de ciuades desde una ciudad origen hasta una ciudad destino que permita
			desarrollar la actividad comercial, evitando pasar por aquellas ciudades que están en fase 1.
	 */
	
	public ListaGenerica<String> resolver(Grafo<ParcialG1Obj> grafo, String origen, String destino) {
		ListaGenerica<String> caminoFinal = new ListaEnlazadaGenerica<String>();
		if(! grafo.esVacio()) {
			ListaGenerica<Vertice<ParcialG1Obj>> listaVertices = grafo.listaDeVertices();
			boolean[] marca = new boolean[listaVertices.tamanio() + 1];
			listaVertices.comenzar();
			while(! listaVertices.fin()) {
				Vertice<ParcialG1Obj> vIni = listaVertices.proximo();
				if(vIni.dato().getNombre().equals(origen)) {
					resolver(vIni, grafo, caminoFinal, marca, destino);
					break;
				}
			}
		}
		
		return caminoFinal;
	}
	
	private boolean resolver(Vertice<ParcialG1Obj> vAct, Grafo<ParcialG1Obj> grafo, ListaGenerica<String> camino, boolean[] marca, String destino) {
		
		camino.agregarFinal(vAct.dato().getNombre());
		marca[vAct.getPosicion()] = true;
		if(vAct.dato().getNombre().equals(destino)) 
			return true;
		
		boolean encontre = false;
		ListaGenerica<Arista<ParcialG1Obj>> listaAdy = grafo.listaDeAdyacentes(vAct);
		listaAdy.comenzar();
		while( (! listaAdy.fin()) && (! encontre) ) {
			Vertice<ParcialG1Obj> vSig = listaAdy.proximo().verticeDestino();
			if((! marca[vSig.getPosicion()]) && (vSig.dato().getCantDias() != 1)) { //cant dias sería la fase, pero el objeto lo uso para ParcialG1 también
				encontre = resolver(vSig, grafo, camino, marca, destino);
			}
		}
		
		if(! encontre) {
			camino.eliminarEn(camino.tamanio());
			marca[vAct.getPosicion()] = false;
		}
		
		return encontre;
	}
	
	
	
	//main
	public static void main(String[] args) {

		GrafoImplListAdy<ParcialG1Obj> grafo = new GrafoImplListAdy<ParcialG1Obj>();
		
		VerticeImplListAdy<ParcialG1Obj> vLaPlata = new VerticeImplListAdy<ParcialG1Obj>(new ParcialG1Obj("La Plata", 2)); grafo.agregarVertice(vLaPlata);
		VerticeImplListAdy<ParcialG1Obj> vPinamar = new VerticeImplListAdy<ParcialG1Obj>(new ParcialG1Obj("Pinamar", 3)); grafo.agregarVertice(vPinamar);
		VerticeImplListAdy<ParcialG1Obj> vQuilmes = new VerticeImplListAdy<ParcialG1Obj>(new ParcialG1Obj("Quilmes", 1)); grafo.agregarVertice(vQuilmes);
		VerticeImplListAdy<ParcialG1Obj> vMoreno = new VerticeImplListAdy<ParcialG1Obj>(new ParcialG1Obj("Moreno", 1)); grafo.agregarVertice(vMoreno);
		VerticeImplListAdy<ParcialG1Obj> vCarlosKeen = new VerticeImplListAdy<ParcialG1Obj>(new ParcialG1Obj("Carlos Keen", 3)); grafo.agregarVertice(vCarlosKeen);
		VerticeImplListAdy<ParcialG1Obj> vSaladillo = new VerticeImplListAdy<ParcialG1Obj>(new ParcialG1Obj("Saladillo", 4)); grafo.agregarVertice(vSaladillo);
		VerticeImplListAdy<ParcialG1Obj> vLobos = new VerticeImplListAdy<ParcialG1Obj>(new ParcialG1Obj("Lobos", 3)); grafo.agregarVertice(vLobos);
		VerticeImplListAdy<ParcialG1Obj> vAbasto = new VerticeImplListAdy<ParcialG1Obj>(new ParcialG1Obj("Abasto", 2)); grafo.agregarVertice(vAbasto);
		VerticeImplListAdy<ParcialG1Obj> vCanuelas = new VerticeImplListAdy<ParcialG1Obj>(new ParcialG1Obj("Cañuelas", 3)); grafo.agregarVertice(vCanuelas);
		VerticeImplListAdy<ParcialG1Obj> vNavarro = new VerticeImplListAdy<ParcialG1Obj>(new ParcialG1Obj("Navarro", 4)); grafo.agregarVertice(vNavarro);
		VerticeImplListAdy<ParcialG1Obj> vSuipacha = new VerticeImplListAdy<ParcialG1Obj>(new ParcialG1Obj("Suipacha", 5)); grafo.agregarVertice(vSuipacha);
		
		grafo.conectar(vPinamar, vLaPlata); grafo.conectar(vLaPlata, vPinamar);
		grafo.conectar(vLaPlata, vQuilmes); grafo.conectar(vQuilmes, vLaPlata);
		grafo.conectar(vLaPlata, vAbasto); grafo.conectar(vAbasto, vLaPlata);
		grafo.conectar(vQuilmes, vMoreno); grafo.conectar(vMoreno, vQuilmes);
		grafo.conectar(vMoreno, vAbasto); grafo.conectar(vAbasto, vMoreno);
		grafo.conectar(vMoreno, vCarlosKeen); grafo.conectar(vCarlosKeen, vMoreno);
		grafo.conectar(vCarlosKeen, vSuipacha); grafo.conectar(vSuipacha, vCarlosKeen);
		grafo.conectar(vSuipacha, vNavarro); grafo.conectar(vNavarro, vSuipacha);
		grafo.conectar(vAbasto, vCanuelas); grafo.conectar(vCanuelas, vAbasto);
		grafo.conectar(vCanuelas, vNavarro); grafo.conectar(vNavarro, vCanuelas);
		grafo.conectar(vNavarro, vSaladillo); grafo.conectar(vSaladillo, vNavarro);
		grafo.conectar(vNavarro, vLobos); grafo.conectar(vLobos, vNavarro);
		
		System.out.println(new ParcialG2().resolver(grafo, "Carlos Keen", "Lobos"));
	}
}
