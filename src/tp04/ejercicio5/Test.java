package tp04.ejercicio5;

import tp02.ejercicio2.ListaGenerica;
import tp02.ejercicio3.ColaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class Test {
	public static void main(String[] args) {
		ArbolGeneral<AreaEmpresa> a = new ArbolGeneral<AreaEmpresa>(new AreaEmpresa("M", 20));
		
		ArbolGeneral<AreaEmpresa> izq = new ArbolGeneral<AreaEmpresa>(new AreaEmpresa("J", 13));
		ArbolGeneral<AreaEmpresa> izqIzq = new ArbolGeneral<AreaEmpresa>(new AreaEmpresa("A", 4));
		ArbolGeneral<AreaEmpresa> izqMed = new ArbolGeneral<AreaEmpresa>(new AreaEmpresa("B", 7));
		ArbolGeneral<AreaEmpresa> izqDer = new ArbolGeneral<AreaEmpresa>(new AreaEmpresa("C", 5));
		izq.agregarHijo(izqIzq);
		izq.agregarHijo(izqMed);
		izq.agregarHijo(izqDer);
		
		ArbolGeneral<AreaEmpresa> med = new ArbolGeneral<AreaEmpresa>(new AreaEmpresa("K", 25));
		ArbolGeneral<AreaEmpresa> medIzq = new ArbolGeneral<AreaEmpresa>(new AreaEmpresa("D", 6));
		ArbolGeneral<AreaEmpresa> medMed = new ArbolGeneral<AreaEmpresa>(new AreaEmpresa("E", 10));
		ArbolGeneral<AreaEmpresa> medDer = new ArbolGeneral<AreaEmpresa>(new AreaEmpresa("F", 18));
		med.agregarHijo(medIzq);
		med.agregarHijo(medMed);
		med.agregarHijo(medDer);
		
		ArbolGeneral<AreaEmpresa> der = new ArbolGeneral<AreaEmpresa>(new AreaEmpresa("L", 10));
		ArbolGeneral<AreaEmpresa> derIzq = new ArbolGeneral<AreaEmpresa>(new AreaEmpresa("G", 9));
		ArbolGeneral<AreaEmpresa> derMed = new ArbolGeneral<AreaEmpresa>(new AreaEmpresa("H", 12));
		ArbolGeneral<AreaEmpresa> derDer = new ArbolGeneral<AreaEmpresa>(new AreaEmpresa("I", 19));
		der.agregarHijo(derIzq);
		der.agregarHijo(derMed);
		der.agregarHijo(derDer);
		
		a.agregarHijo(izq);
		a.agregarHijo(med);
		a.agregarHijo(der);
		
		/*
						     M(20)
				
				 /            |             \
			   J(13)         K(25)           L(10)
			 /  |  \        /   |   \       /  |  \
		   A(4)B(7)C(5)   D(6)E(10)F(18)  G(9)H(12)I(19)
		   
		   Nivel 0: 20/1 = 20 - Nivel 1: 48/3 = 16 - Nivel 2: 90/9 = 10
		 */
		
		recorridoPorNiveles(a);
		
		System.out.println();
		System.out.println("Mayor promedio por nivel: " + new MaximoPromedio().devolverMaximoPromedio(a)); //Nivel 0 = 20
	}
	
	//para ver los valores del árbol
	public static void recorridoPorNiveles(ArbolGeneral<AreaEmpresa> a) {
		ArbolGeneral<AreaEmpresa> arbol;
		ColaGenerica<ArbolGeneral<AreaEmpresa>> cola = new ColaGenerica<ArbolGeneral<AreaEmpresa>>();
		cola.encolar(a);
		cola.encolar(null);
		while(! cola.esVacia()){
			arbol = cola.desencolar();
			if(arbol != null) {
				System.out.print(arbol.getDato().getId() + "(" + arbol.getDato().getTardanza() + ")  ");
				ListaGenerica<ArbolGeneral<AreaEmpresa>> hijos = arbol.getHijos();
				hijos.comenzar();
				while(! hijos.fin()){
					cola.encolar(hijos.proximo());
				}
			}else if (! cola.esVacia()) {
				System.out.println();
				cola.encolar(null);
			}
		}
	}
	
}
