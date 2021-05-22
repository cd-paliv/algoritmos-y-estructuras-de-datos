package tp04.ejercicio7;
import tp02.ejercicio2.ListaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class RedAguaPotable {
	private ArbolGeneral<Double> red = new ArbolGeneral<Double>();
	
	public RedAguaPotable(ArbolGeneral<Double> a) {
		this.red = a;
	}
	
	
	//que calcule el caudal de cada nodo y determine cuál es el mínimo caudal que recibe una casa
	public double minimoCaudal(double caudal) {
		if(red.esHoja())
			return caudal;
		else
			return minimoCaudal_priv(this.red, caudal);
	}
	
	private double minimoCaudal_priv(ArbolGeneral<Double> a, double c) {
		if (a.esHoja()) return c;
		else {
			ListaGenerica<ArbolGeneral<Double>> hijos = a.getHijos();
			hijos.comenzar();
			double min = c;
			while(! hijos.fin()) {
				double actual = minimoCaudal_priv(hijos.proximo(), c/hijos.tamanio());
				if(actual <= min)
					min = actual;
			}
			return min;
		}
	}

}