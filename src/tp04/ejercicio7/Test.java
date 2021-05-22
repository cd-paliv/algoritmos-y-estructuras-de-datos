package tp04.ejercicio7;

import tp04.ejercicio1.ArbolGeneral;

public class Test {

	public static void main(String[] args) {
		
		ArbolGeneral<Double> a = new ArbolGeneral<Double>(0.0);
		
		ArbolGeneral<Double> a50 = new ArbolGeneral<Double>(0.0);
		ArbolGeneral<Double> a50CH = new ArbolGeneral<Double>(0.0);
		ArbolGeneral<Double> a25 = new ArbolGeneral<Double>(0.0);
		ArbolGeneral<Double> a25HD = new ArbolGeneral<Double>(0.0);
		a50CH.agregarHijo(a25);
		a50CH.agregarHijo(a25HD); //50/2 = 25
		
		ArbolGeneral<Double> a250 = new ArbolGeneral<Double>(0.0);
		ArbolGeneral<Double> a250CH = new ArbolGeneral<Double>(0.0);
		a250.agregarHijo(a50);
		a250.agregarHijo(a50);
		a250.agregarHijo(a50);
		a250.agregarHijo(a50);
		a250.agregarHijo(a50);
		a250CH.agregarHijo(a50CH); //250/5 = 50
		a250CH.agregarHijo(a50); a250CH.agregarHijo(a50); a250CH.agregarHijo(a50); a250CH.agregarHijo(a50);
		
		a.agregarHijo(a250);
		a.agregarHijo(a250);
		a.agregarHijo(a250);
		a.agregarHijo(a250CH); //1000/4 = 250
		
		//a.recorridoPorNivelesImprimir();
		
		double min = new RedAguaPotable(a).minimoCaudal(1000);
		System.out.println(min);
	}

}
