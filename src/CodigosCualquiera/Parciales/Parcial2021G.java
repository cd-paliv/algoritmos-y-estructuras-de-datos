package CodigosCualquiera.Parciales;

import tp02.ejercicio2.*;
import tp06.ejercicio3.*;

public class Parcial2021G {

	/*
	 * Parcial 3/7/2021. Módulo 3 primera instancia.
	 * 
	 * Implemente en la clase Parcial , el siguiente método:
			"??? resolver (Grafo<???> grafo, String origen, String destino)"
			Dado un grafo de ciudades, se quiere encontrar todos los caminos desde una ciudad origen a una
			ciudad destino. Para cada ciudad se conoce el nombre. Debe verificar la existencia de la ciudad
			origen y la ciudad destino.
	 */
	
	public ListaGenerica<String> resolver(Grafo<String> grafo, String origen, String destino) {
		ListaGenerica<String> caminoFinal = new ListaEnlazadaGenerica<String>();
		if(! grafo.esVacio()) {
			Vertice<String> vIni = null;
			Vertice<String> vFin = null;
			
			ListaGenerica<String> caminoTemporal = new ListaEnlazadaGenerica<String>();
			ListaGenerica<Vertice<String>> listaV = grafo.listaDeVertices();
			boolean[] marca = new boolean[listaV.tamanio() + 1];
			listaV.comenzar();
			while(! listaV.fin()) {
				Vertice<String> vAct = listaV.proximo();
				if(vAct.dato().equals(origen))
					vIni = vAct;
				if(vAct.dato().equals(destino))
					vFin = vAct;
			}
			if( (vIni != null) && (vFin != null) ) {
				resolver(vIni, vIni.getPosicion(), grafo, caminoFinal, caminoTemporal, marca, origen, destino);
			}
		}
		
		return caminoFinal;
	}
	
	private void resolver(Vertice<String> vIni, int posV, Grafo<String> grafo, ListaGenerica<String> caminos, ListaGenerica<String> caminoAct,
											boolean[] marca, String origen, String destino) {
		
		Vertice<String> vAct = grafo.vetice(posV);
		caminoAct.agregarFinal(vAct.dato());
		marca[posV] = true;
		
		if(vAct.dato().equals(destino)) {
			caminoAct.comenzar();
			while(! caminoAct.fin()) {
				caminos.agregarFinal(caminoAct.proximo());
			}
		} else {
		ListaGenerica<Arista<String>> listaAdy = grafo.listaDeAdyacentes(vAct);
		listaAdy.comenzar();
			while(! listaAdy.fin()) {
				Vertice<String> vSig = listaAdy.proximo().verticeDestino();
				int posvSig = vSig.getPosicion();
				if((! marca[posvSig])) {
					resolver(vAct, posvSig, grafo, caminos, caminoAct, marca, origen, destino);
				}
			}
			
		}
		
		caminoAct.eliminarEn(caminoAct.tamanio());
		if(! vIni.dato().equals(origen))
			marca[posV] = false;
	}
	
	
	//main
	public static void main(String[] args) {

		GrafoImplListAdy<String> grafo = new GrafoImplListAdy<String>();
		
		VerticeImplListAdy<String> vLaPlata = new VerticeImplListAdy<String>("La Plata"); grafo.agregarVertice(vLaPlata);
		VerticeImplListAdy<String> vPinamar = new VerticeImplListAdy<String>("Pinamar"); grafo.agregarVertice(vPinamar);
		VerticeImplListAdy<String> vChascomus = new VerticeImplListAdy<String>("Chascomus"); grafo.agregarVertice(vChascomus);
		VerticeImplListAdy<String> vDolores = new VerticeImplListAdy<String>("Dolores"); grafo.agregarVertice(vDolores);
		VerticeImplListAdy<String> vPila = new VerticeImplListAdy<String>("Pila"); grafo.agregarVertice(vPila);
		VerticeImplListAdy<String> vMardelPlata = new VerticeImplListAdy<String>("Mar del Plata"); grafo.agregarVertice(vMardelPlata);
		VerticeImplListAdy<String> vMarAzul = new VerticeImplListAdy<String>("Mar Azul"); grafo.agregarVertice(vMarAzul);
		VerticeImplListAdy<String> vGaviotas = new VerticeImplListAdy<String>("Las Gaviotas"); grafo.agregarVertice(vGaviotas);
		VerticeImplListAdy<String> vMadariaga = new VerticeImplListAdy<String>("Madariaga"); grafo.agregarVertice(vMadariaga);
		VerticeImplListAdy<String> vHudson = new VerticeImplListAdy<String>("Hudson"); grafo.agregarVertice(vHudson);
		VerticeImplListAdy<String> vQuerandi = new VerticeImplListAdy<String>("Querandi"); grafo.agregarVertice(vQuerandi);
		
		grafo.conectar(vHudson, vLaPlata); grafo.conectar(vLaPlata, vHudson);
		grafo.conectar(vLaPlata, vMadariaga); grafo.conectar(vMadariaga, vLaPlata);
		grafo.conectar(vLaPlata, vChascomus); grafo.conectar(vChascomus, vLaPlata);
		grafo.conectar(vChascomus, vDolores); grafo.conectar(vDolores, vChascomus);
		grafo.conectar(vDolores, vMadariaga); grafo.conectar(vMadariaga, vDolores);
		grafo.conectar(vMadariaga, vPinamar); grafo.conectar(vPinamar, vMadariaga);
		grafo.conectar(vPinamar, vMarAzul); grafo.conectar(vMarAzul, vPinamar);
		grafo.conectar(vMarAzul, vGaviotas); grafo.conectar(vGaviotas, vMarAzul);
		grafo.conectar(vMarAzul, vQuerandi); grafo.conectar(vQuerandi, vMarAzul);
		grafo.conectar(vMarAzul, vMardelPlata); grafo.conectar(vMardelPlata, vMarAzul);
		grafo.conectar(vDolores, vPila); grafo.conectar(vPila, vDolores);
		grafo.conectar(vPila, vMardelPlata); grafo.conectar(vMardelPlata, vPila);
		
		System.out.println(new Parcial2021G().resolver(grafo, "La Plata", "Mar del Plata"));
		
		//La Plata -> Madariaga -> Dolores -> Pila -> Mar del Plata
		//La Plata -> Madariaga -> Pinamar -> Mar Azul -> Mar del Plata
		//La Plata -> Chascomus -> Dolores -> Pila -> Mar del Plata
	}
}
