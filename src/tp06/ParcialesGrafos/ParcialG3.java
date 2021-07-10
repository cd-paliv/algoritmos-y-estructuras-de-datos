package tp06.ParcialesGrafos;

import tp02.ejercicio2.*;
import tp06.ejercicio3.*;

public class ParcialG3 {

	/*
	 * Implemente en la clase Parcial , el siguiente método:
			"??? resolver (Grafo<???> grafo, String origen, String destino, ListaGenerica<???> pasandoPor)"
		Se quiere encontrar un camino desde una ciudad origen hasta una ciudad destino, teniendo en cuenta que
			debido a la pandemia queremos pasar sí o sí por ciudades específicas pasadas en una lista como parámetro.
			Para cada ciudad se conoce el nombre.
	 */
	
	public ListaGenerica<String> resolver(Grafo<String> grafo, String origen, String destino, ListaGenerica<String> pasandoPor){
		ListaGenerica<String> caminoFinal = new ListaEnlazadaGenerica<String>();
		if(! grafo.esVacio()) {
			ListaGenerica<String> caminoTemporal = new ListaEnlazadaGenerica<String>();
			ListaGenerica<Vertice<String>> listaV = grafo.listaDeVertices();
			boolean[] marca = new boolean[listaV.tamanio() + 1];
			listaV.comenzar();
			while(! listaV.fin()) {
				Vertice<String> vIni = listaV.proximo();
				if(vIni.dato().equals(origen)) {
					resolver(vIni, grafo, caminoFinal, caminoTemporal, marca, destino, pasandoPor);
					break;
				}
			}
		}
		
		return caminoFinal;
	}
	
	private void resolver(Vertice<String> vAct, Grafo<String> grafo, ListaGenerica<String> camino, ListaGenerica<String> caminoAct, boolean[] visitados,
											String destino, ListaGenerica<String> pasandoPor) {
		
		caminoAct.agregarFinal(vAct.dato());
		visitados[vAct.getPosicion()] = true;
		
		if(vAct.dato().equals(destino)) {
			boolean estanTodos = true;
			pasandoPor.comenzar();
			while( (! pasandoPor.fin()) && (estanTodos) ) {
				estanTodos = caminoAct.incluye(pasandoPor.proximo());
			}
			if(estanTodos) {
				camino.eliminarTodos();
				caminoAct.comenzar();
				while(! caminoAct.fin()) {
					camino.agregarFinal(caminoAct.proximo());
				}
			}
		} else {
			ListaGenerica<Arista<String>> listaAdy = grafo.listaDeAdyacentes(vAct);
			listaAdy.comenzar();
			while(! listaAdy.fin()) {
				Vertice<String> vSig = listaAdy.proximo().verticeDestino();
				if((! visitados[vSig.getPosicion()])) {
					resolver(vSig, grafo, camino, caminoAct, visitados, destino, pasandoPor);
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
		
		
		//System.out.println("DFS: " + new Recorridos<String>().DFS(grafo));
		
		ListaGenerica<String> pasandoPor = new ListaEnlazadaGenerica<String>();
		pasandoPor.agregarFinal("Quilmes"); pasandoPor.agregarFinal("Carlos Keen");
		
		System.out.println(new ParcialG3().resolver(grafo, "La Plata", "Suipacha", pasandoPor));
	}
}
