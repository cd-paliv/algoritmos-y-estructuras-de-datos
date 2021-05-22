package tp04.ejercicio5;
import tp02.ejercicio2.ListaGenerica;
import tp02.ejercicio3.ColaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class MaximoPromedio {
	
	public Integer devolverMaximoPromedio(ArbolGeneral<AreaEmpresa> arbol) {
		ArbolGeneral<AreaEmpresa> arbolAux;
		ColaGenerica<ArbolGeneral<AreaEmpresa>> cola = new ColaGenerica<ArbolGeneral<AreaEmpresa>>();
		int totTiempo = 0, cant_nodos = 0, max = -1;
		cola.encolar(arbol);
		cola.encolar(null);
		while(! cola.esVacia()){
			arbolAux = cola.desencolar();
			if(arbolAux != null) {
				totTiempo += arbolAux.getDato().getTardanza();
				cant_nodos++;
				if(arbolAux.tieneHijos()) {
					ListaGenerica<ArbolGeneral<AreaEmpresa>> hijos = arbolAux.getHijos();
					hijos.comenzar();
					while(! hijos.fin()){
						cola.encolar(hijos.proximo());
					}
				}
			}else if (! cola.esVacia()) {
				int prom = totTiempo / cant_nodos;
				if(max < prom)
					max = prom;
				totTiempo = 0; cant_nodos = 0;
				cola.encolar(null);
			}
		}
		return max;
	}

}
