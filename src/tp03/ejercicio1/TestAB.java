package tp03.ejercicio1;

public class TestAB {
	
	public static void main(String[] args) {
		System.out.println("ARBOL BINARIO: ");
		ArbolBinario<Integer> ab = new ArbolBinario<Integer>(40);
		
		ArbolBinario<Integer> izq = new ArbolBinario<Integer>(25);
		izq.agregarHijoIzquierdo(new ArbolBinario<Integer>(10));
		izq.agregarHijoDerecho(new ArbolBinario<Integer>(32));
		
		ArbolBinario<Integer> der = new ArbolBinario<Integer>(78);
		der.agregarHijoIzquierdo(new ArbolBinario<Integer>(62));
		der.agregarHijoDerecho(new ArbolBinario<Integer>(90));
		
		ab.agregarHijoIzquierdo(izq);
		ab.agregarHijoDerecho(der);
		
		System.out.print("PREORDEN: "); ab.printPreorden();
		System.out.println();
		System.out.print("POSTORDEN: "); ab.printPostorden();
		System.out.println();
		System.out.print("INORDEN: "); ab.printInorden();
		System.out.println();
		System.out.println("POR NIVELES:"); ab.recorridoPorNiveles();
		System.out.println();
		System.out.println("ENTRE NIVELES 0 Y 1:"); ab.entreNiveles(0, 1);
		System.out.println();
		System.out.println("\n¿Es lleno?: "+ (ab.esLleno() ? "Si" : "No")); //Si
		System.out.print("Nodos: "); System.out.println(ab.contarNodos()); //7
		System.out.println("Valor máx del árbol: " + ab.getMaximo()); //90
		System.out.println("Valor mín del árbol: " + ab.getMinimo()); //10
		
		//ARBOL FRECUENCIA NATURAL
		System.out.println("------------------------------------------------");
		System.out.println("ARBOL DE FRECUENCIA NATURAL: \n");
		
		ArbolBinario<Frecuencia> arbolFN = new ArbolBinario<Frecuencia>(new Frecuencia("Mujeres", 10000));
		
		ArbolBinario<Frecuencia> izqFN = new ArbolBinario<Frecuencia>(new Frecuencia("Cancer de mama", 100));
		izqFN.agregarHijoIzquierdo(new ArbolBinario<Frecuencia>(new Frecuencia("Mamografía positiva", 80)));
		izqFN.agregarHijoDerecho(new ArbolBinario<Frecuencia>(new Frecuencia("Mamografía negativa", 20)));
		
		ArbolBinario<Frecuencia> derFN = new ArbolBinario<Frecuencia>(new Frecuencia("Sin cancer de mama", 9900));
		derFN.agregarHijoIzquierdo(new ArbolBinario<Frecuencia>(new Frecuencia("Mamografía positiva", 950)));
		derFN.agregarHijoDerecho(new ArbolBinario<Frecuencia>(new Frecuencia("Mamografía negativa", 8950)));
		
		arbolFN.agregarHijoIzquierdo(izqFN);
		arbolFN.agregarHijoDerecho(derFN);
		
		System.out.println("POR NIVELES:"); arbolFN.recorridoPorNiveles();
		System.out.println("\n\n¿Es AFN?: " + (ArbolBinario.esAFN(arbolFN) ? "Si" : "No"));
		
		//ARBOL BINARIO DE EXPRESION
		System.out.println("------------------------------------------------");
		System.out.println("ARBOL DE EXPRESION: \n");
		
		ArbolBinario<Character> arbolBE = new ArbolBinario<Character>();
		arbolBE = arbolBE.convertirInfija("((2+1)*9)/(2+1)");
		System.out.println("RES INFIJA: " + ArbolBinario.evaluarExpresion(arbolBE)); //9
		
		arbolBE = arbolBE.convertirPostfija("21+9*21+/");
		System.out.println("RES POSTFIJA: " + ArbolBinarioExpresion.evaluarExpresion(arbolBE));
		
		StringBuffer st = new StringBuffer("+-8*23/4-97"); ///*+219+21
		arbolBE = arbolBE.convertirPrefija(st);
		System.out.println("RES PREFIJA: " + ArbolBinarioExpresion.evaluarExpresion(arbolBE));
		
		System.out.print("EXPRESION: "); //exp = ( (2+1) * 9) / (2+1) = 9
		ArbolBinarioExpresion.imprimirInfijo(arbolBE);
		System.out.print("\n");
		arbolBE.recorridoPorNiveles();
	}
	
}
