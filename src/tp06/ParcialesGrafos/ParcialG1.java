package tp06.ParcialesGrafos;

import tp02.ejercicio2.*;
import tp06.ejercicio3.*;

public class ParcialG1 {
	
	/*
	 * Implemente en la clase Parcial , el siguiente método:
			"??? resolver (Grafo<???> grafo, String origen, String destino)"
		Se quiere calcular el mínimo tiempo en tránsito desde una ciudad origen a una ciudad destino, teniendo en cuenta que
			debido a la pandemia no todas las rutas exitentes se encuentran habilitadas. PAra cada ciudad se conoce el nombre
			y la cantidad de días que una persona en tránsito debe permanecer allí a fin de que le otorguen los permisos de
			circulación.
	 */
	
	public ListaGenerica<String> resolver(Grafo<ParcialG1Obj> grafo, String origen, String destino) {
		ListaGenerica<String> camino = new ListaEnlazadaGenerica<String>();
		if(! grafo.esVacio()) {
			int[] diasMin = { 15 };
			ListaGenerica<ParcialG1Obj> caminoAct = new ListaEnlazadaGenerica<ParcialG1Obj>();
			ListaGenerica<Vertice<ParcialG1Obj>> listaVertices = grafo.listaDeVertices();
			boolean[] visitados = new boolean[listaVertices.tamanio() + 1];
			listaVertices.comenzar();
			while(! listaVertices.fin()) {
				Vertice<ParcialG1Obj> vIni = listaVertices.proximo();
				if(vIni.dato().getNombre().equals(origen)) {
					resolver(vIni, grafo, caminoAct, camino, visitados, destino, vIni.dato().getCantDias(), diasMin);
				}
			}
		}
		
		return camino;
	}
	
	private void resolver(Vertice<ParcialG1Obj> vAct, Grafo<ParcialG1Obj> grafo,  ListaGenerica<ParcialG1Obj> caminoAct, ListaGenerica<String> caminoMin,
											boolean[] visitados, String destino, int diasAct, int[] diasMin) {
		
		caminoAct.agregarFinal(vAct.dato());
		visitados[vAct.getPosicion()] = true;
		
		if(vAct.dato().getNombre().equals(destino)) {
			if((caminoMin.esVacia()) || (diasMin[0] > diasAct)) { //si encontre un nuevo min
				diasMin[0] = diasAct;
				caminoMin.eliminarTodos();
				caminoAct.comenzar();
				while(! caminoAct.fin()) {
					caminoMin.agregarFinal(caminoAct.proximo().getNombre()); //lo reemplazo
				}
			}
		}
		
		ListaGenerica<Arista<ParcialG1Obj>> listaAdy = grafo.listaDeAdyacentes(vAct);
		listaAdy.comenzar();
		while(! listaAdy.fin()) {
			Arista<ParcialG1Obj> ari = listaAdy.proximo();
			if(ari.peso() == 1) { //0 = NH | 1 = H
				Vertice<ParcialG1Obj> vSig = ari.verticeDestino();
				if(! visitados[vSig.getPosicion()]) {
					resolver(vSig, grafo, caminoAct, caminoMin, visitados, destino, diasAct + vAct.dato().getCantDias(), diasMin);
				}
			}
		}
		
		caminoAct.eliminarEn(caminoAct.tamanio());
		visitados[vAct.getPosicion()] = false;
	}
	
	
	
	//main
	public static void main(String[] args) {

		GrafoImplListAdy<ParcialG1Obj> grafo = new GrafoImplListAdy<ParcialG1Obj>();
		
		VerticeImplListAdy<ParcialG1Obj> vLaPlata = new VerticeImplListAdy<ParcialG1Obj>(new ParcialG1Obj("La Plata", 1)); grafo.agregarVertice(vLaPlata);
		VerticeImplListAdy<ParcialG1Obj> vPinamar = new VerticeImplListAdy<ParcialG1Obj>(new ParcialG1Obj("Pinamar", 0)); grafo.agregarVertice(vPinamar);
		VerticeImplListAdy<ParcialG1Obj> vQuilmes = new VerticeImplListAdy<ParcialG1Obj>(new ParcialG1Obj("Quilmes", 1)); grafo.agregarVertice(vQuilmes);
		VerticeImplListAdy<ParcialG1Obj> vMoreno = new VerticeImplListAdy<ParcialG1Obj>(new ParcialG1Obj("Moreno", 2)); grafo.agregarVertice(vMoreno);
		VerticeImplListAdy<ParcialG1Obj> vCarlosKeen = new VerticeImplListAdy<ParcialG1Obj>(new ParcialG1Obj("Carlos Keen", 2)); grafo.agregarVertice(vCarlosKeen);
		VerticeImplListAdy<ParcialG1Obj> vSaladillo = new VerticeImplListAdy<ParcialG1Obj>(new ParcialG1Obj("Saladillo", 2)); grafo.agregarVertice(vSaladillo);
		VerticeImplListAdy<ParcialG1Obj> vLobos = new VerticeImplListAdy<ParcialG1Obj>(new ParcialG1Obj("Lobos", 1)); grafo.agregarVertice(vLobos);
		VerticeImplListAdy<ParcialG1Obj> vAbasto = new VerticeImplListAdy<ParcialG1Obj>(new ParcialG1Obj("Abasto", 2)); grafo.agregarVertice(vAbasto);
		VerticeImplListAdy<ParcialG1Obj> vCanuelas = new VerticeImplListAdy<ParcialG1Obj>(new ParcialG1Obj("Cañuelas", 1)); grafo.agregarVertice(vCanuelas);
		VerticeImplListAdy<ParcialG1Obj> vNavarro = new VerticeImplListAdy<ParcialG1Obj>(new ParcialG1Obj("Navarro", 2)); grafo.agregarVertice(vNavarro);
		VerticeImplListAdy<ParcialG1Obj> vSuipacha = new VerticeImplListAdy<ParcialG1Obj>(new ParcialG1Obj("Suipacha", 3)); grafo.agregarVertice(vSuipacha);
		
		grafo.conectar(vPinamar, vLaPlata, 1); grafo.conectar(vLaPlata, vPinamar, 1);
		grafo.conectar(vLaPlata, vQuilmes, 1); grafo.conectar(vQuilmes, vLaPlata, 1);
		grafo.conectar(vLaPlata, vAbasto, 1); grafo.conectar(vAbasto, vLaPlata, 1);
		grafo.conectar(vQuilmes, vMoreno, 0); grafo.conectar(vMoreno, vQuilmes, 0);
		grafo.conectar(vMoreno, vAbasto, 1); grafo.conectar(vAbasto, vMoreno, 1);
		grafo.conectar(vMoreno, vCarlosKeen, 1); grafo.conectar(vCarlosKeen, vMoreno, 1);
		grafo.conectar(vCarlosKeen, vSuipacha, 1); grafo.conectar(vSuipacha, vCarlosKeen, 1);
		grafo.conectar(vSuipacha, vNavarro, 1); grafo.conectar(vNavarro, vSuipacha, 1);
		grafo.conectar(vAbasto, vCanuelas, 1); grafo.conectar(vCanuelas, vAbasto, 1);
		grafo.conectar(vCanuelas, vNavarro, 1); grafo.conectar(vNavarro, vCanuelas, 1);
		grafo.conectar(vNavarro, vSaladillo, 1); grafo.conectar(vSaladillo, vNavarro, 1);
		grafo.conectar(vNavarro, vLobos, 0); grafo.conectar(vLobos, vNavarro, 0);
		
		
		System.out.println(new ParcialG1().resolver(grafo, "La Plata", "Suipacha"));
	}
		
}
