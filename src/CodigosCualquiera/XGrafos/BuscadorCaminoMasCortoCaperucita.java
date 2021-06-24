package CodigosCualquiera.XGrafos;

import tp02.ejercicio2.*;
import tp06.ejercicio3.*;

public class BuscadorCaminoMasCortoCaperucita {

	/*
	 * Un día, Caperucita Roja decide ir desde su casa hasta la de su abuelita, recolectando frutos del bosque del camino
	 * 		y tratando de hacer el paseo de la manera más segura posible. La casa de Caperucita está en un claro del extremo
	 * 		oeste del bosque, la casa de su abuelita en un claro del extremo este, y dentro del bosque entre ambas hay algunos
	 * 		otros claros. El bosque está representado por un grafo, donde los vértices representan los claros (identificados
	 * 		por un String) y las aristas los senderos que los unen. Cada arista informa la cantidad de árboles frutales que
	 * 		hay en el sendero. Caperucita sabe que el lobo es muy goloso y le gustan mucho las frutas, entonces para no ser
	 * 		capturada por el lobo, desea encontrar todos los caminos que no pasen por los senderos con cantidad de frutales >= 5 y
	 * 		lleguen a la casa de la abuelita. Su tarea es definir una clase llamada BuscadorDeCaminos, con una variable de instancia
	 * 		llamada “bosque” de tipo Grafo, que representa el bosque descripto e implementar un método de instancia con la siguiente firma:
						public ListaGenerica < String > recorridoMasCortoYSeguro() 
				que devuelva un listado con el camino que cumple con las condiciones mencionadas anteriormente pero es el más corto.

		!Nota: La casa de caperucita debe ser buscada antes de comenzar a buscar el recorrido.
	 */
	
	private Grafo<String> bosque;
	
	public BuscadorCaminoMasCortoCaperucita(Grafo<String> bosque) {
		this.bosque = bosque;
	}
	
	public ListaGenerica<String> recorridoMasCortoYSeguro(){
		ListaGenerica<String> resultado = new ListaEnlazadaGenerica<String>();
		
		Vertice<String> v = buscarVSalida(); //busco casa caperucita
		if(v != null) {
			ListaGenerica<String> caminoAct = new ListaEnlazadaGenerica<String>();
			boolean[] marca = new boolean[bosque.listaDeVertices().tamanio() + 1];
			caminoAct.agregarFinal(v.dato());
			marca[v.getPosicion()] = true;
			dfs(v, caminoAct, marca, resultado);
		}
		return resultado;
	}
	
	private Vertice<String> buscarVSalida(){
		boolean encontre = false;
		Vertice<String> v = null;
		ListaGenerica<Vertice<String>> lisV = bosque.listaDeVertices();
		lisV.comenzar();
		while(! lisV.fin() && (! encontre)) {
			v = lisV.proximo();
			if(v.dato() == "Casa de Caperucita") {
				encontre = true;
			}
		}
		if(encontre)
			return v;
		else return null;
	}
	
	private void dfs(Vertice<String> vIni, ListaGenerica<String> cAct, boolean[] marca,
							ListaGenerica<String> res) {
		ListaGenerica<Arista<String>> ady = bosque.listaDeAdyacentes(vIni);
		ady.comenzar();
		while(! ady.fin()) {
			Arista<String> ari = ady.proximo(); //me guardo la arista para poder saber el peso y no atravesarla si es > 5
			Vertice<String> vSig = ari.verticeDestino();
			int posDest = vSig.getPosicion();
			if((! marca[posDest]) && (ari.peso() <= 5)) {
				marca[posDest] = true;
				cAct.agregarFinal(vSig.dato());
				if((vSig.dato().equals("Casa Abuelita")) && (res.esVacia() || res.tamanio() > cAct.tamanio())) {
					res.eliminarTodos();
					cAct.comenzar();
					while(! cAct.fin()) {
						res.agregarFinal(cAct.proximo());
					}
				}else {
					dfs(vSig, cAct, marca, res);
				}
				marca[posDest] = false;
				cAct.eliminarEn(cAct.tamanio());
			}
		}
	}

}
