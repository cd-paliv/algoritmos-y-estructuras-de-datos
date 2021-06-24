package CodigosCualquiera.XGrafos;

import tp02.ejercicio2.*;
import tp06.ejercicio3.*;

public class CiudadMafiosa {

	/*
	 * "El Paso City", años 20. Las mafias controlan varios sitios y calles de la ciudad. El intendente que debe
	 * 		desplazarse diaramente en su auto desde su residencia hasta la municipalidad, está seriamente amenazado
	 * 		
	 * 		Ud. debe ayudar al intendente encontrando la ruta más segura para realizar su traslado diario
	 * 			implementando un método que retorne la ruta que pase por el menor número de calles y sitios
	 * 			controlados por la mafia (en caso de existir más de una, con retornar alguna de ellas alcanza)
	 * 		
	 * 		La ciudad se describe como un conjunto de n sitios y varias calles bidireccionales que unen esos sitios.
	 * 			Cada sitio tiene la info si está controlado por la mafia o no. Lo mismo sucede con cada una de las
	 * 			calles de la ciudad.
	 */
	
	public static Grafo<Sitio> ciudadG;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
	}
	
	public ListaGenerica<Sitio> getRutaMinMafia(){
		ListaGenerica<Sitio> caminoMin = new ListaEnlazadaGenerica<Sitio>();
		
		Vertice<Sitio> vIni = null;
		Vertice<Sitio> vFin = null;
		
		int[] mafiasMin = { Integer.MAX_VALUE };
		
		ListaGenerica<Vertice<Sitio>> listaV = ciudadG.listaDeVertices();
		boolean[] visitados = new boolean[listaV.tamanio() + 1];
		listaV.comenzar();
		while(! listaV.fin() && (vIni == null || vFin == null)) {
			Vertice<Sitio> vAct = listaV.proximo();
			if(vAct.dato().getNombre().equals("Casa del intendente"))
				vIni = vAct;
			if(vAct.dato().getNombre().equals("Municipalidad"))
				vFin = vAct;
		}
		if(vIni != null && vFin != null)
			dfs(vIni, vFin, visitados, new ListaEnlazadaGenerica<Sitio>(), caminoMin, 0, mafiasMin);
		
		return caminoMin;
	}
	
	private void dfs(Vertice<Sitio> entrada, Vertice<Sitio> salida, boolean[] marca,
							ListaGenerica<Sitio> caminoAct, ListaGenerica<Sitio> caminoMin,
							int mafias, int[] mafiasMin) {
		
		marca[entrada.getPosicion()] = true;
		caminoAct.agregarFinal(entrada.dato());
		if(entrada.dato().getTieneMafia())
			mafias++; //si el vertice marca que tiene mafia, lo sumo para saber el total del caminoAct
		
		if(entrada.equals(salida)) {
			if(mafias < mafiasMin[0]) {
				mafiasMin[0] = mafias;
				caminoMin.eliminarTodos();
				caminoAct.comenzar();
				while(! caminoAct.fin()) {
					caminoMin.agregarFinal(caminoAct.proximo());
				}
			}
		} else {
			ListaGenerica<Arista<Sitio>> ady = ciudadG.listaDeAdyacentes(entrada);
			ady.comenzar();
			while(! ady.fin()) {
				Arista<Sitio> ari = ady.proximo();
				if(! marca[ari.verticeDestino().getPosicion()]) {
					dfs(ari.verticeDestino(), salida, marca, caminoAct, caminoMin,
							mafias + ari.peso(), mafiasMin);
				}
			}
		}
		
		marca[entrada.getPosicion()] = false;
		caminoAct.eliminarEn(caminoAct.tamanio());
	}

}
