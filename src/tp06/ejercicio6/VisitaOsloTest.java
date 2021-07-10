package tp06.ejercicio6;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp06.ejercicio3.GrafoImplListAdy;
import tp06.ejercicio3.VerticeImplListAdy;

public class VisitaOsloTest {

	public static void main(String[] args) {

		GrafoImplListAdy<String> grafo = new GrafoImplListAdy<String>();
		
		VerticeImplListAdy<String> vAyuntamiento = new VerticeImplListAdy<String>("Ayuntamiento"); grafo.agregarVertice(vAyuntamiento);
		VerticeImplListAdy<String> vPalacio = new VerticeImplListAdy<String>("Palacio Real"); grafo.agregarVertice(vPalacio);
		VerticeImplListAdy<String> vTigre = new VerticeImplListAdy<String>("El Tigre"); grafo.agregarVertice(vTigre);
		VerticeImplListAdy<String> vBotanico = new VerticeImplListAdy<String>("Parque Botanico"); grafo.agregarVertice(vBotanico);
		VerticeImplListAdy<String> vMunch = new VerticeImplListAdy<String>("Museo Munch"); grafo.agregarVertice(vMunch);
		VerticeImplListAdy<String> vGaleria = new VerticeImplListAdy<String>("Galeria Nacional"); grafo.agregarVertice(vGaleria);
		VerticeImplListAdy<String> vVigeland = new VerticeImplListAdy<String>("Parque Vigeland"); grafo.agregarVertice(vVigeland);
		VerticeImplListAdy<String> vBrigge = new VerticeImplListAdy<String>("Akker Brigge"); grafo.agregarVertice(vBrigge);
		VerticeImplListAdy<String> vFolkMuseum = new VerticeImplListAdy<String>("FolkMuseum"); grafo.agregarVertice(vFolkMuseum);
		VerticeImplListAdy<String> vFram = new VerticeImplListAdy<String>("Museo Fram"); grafo.agregarVertice(vFram);
		VerticeImplListAdy<String> vVikingo = new VerticeImplListAdy<String>("Museo Vikingo"); grafo.agregarVertice(vVikingo);
		VerticeImplListAdy<String> vPolar = new VerticeImplListAdy<String>("Museo del Barco Polar"); grafo.agregarVertice(vPolar);
		
		
		grafo.conectar(vAyuntamiento, vTigre, 15); grafo.conectar(vTigre, vAyuntamiento, 15);
		grafo.conectar(vAyuntamiento, vPalacio, 5); grafo.conectar(vPalacio, vAyuntamiento, 5);
		grafo.conectar(vAyuntamiento, vBrigge, 20); grafo.conectar(vBrigge, vAyuntamiento, 20); 
		grafo.conectar(vAyuntamiento, vBotanico, 10); grafo.conectar(vBotanico, vAyuntamiento, 10);
		grafo.conectar(vTigre, vMunch, 15); grafo.conectar(vMunch, vTigre, 15);
		grafo.conectar(vMunch, vBotanico, 1); grafo.conectar(vBotanico, vMunch, 1);
		grafo.conectar(vBotanico, vGaleria, 15); grafo.conectar(vGaleria, vBotanico, 15);
		grafo.conectar(vGaleria, vVigeland, 10); grafo.conectar(vVigeland, vGaleria, 10);
		grafo.conectar(vVigeland, vFolkMuseum, 20); grafo.conectar(vFolkMuseum, vVigeland, 20);
		grafo.conectar(vFolkMuseum, vFram, 5); grafo.conectar(vFram, vFolkMuseum, 5);
		grafo.conectar(vFram, vPolar, 5); grafo.conectar(vPolar, vFram, 5);
		grafo.conectar(vPolar, vVikingo, 5); grafo.conectar(vVikingo, vPolar, 5);
		grafo.conectar(vVikingo, vBrigge, 30); grafo.conectar(vBrigge, vVikingo, 30);
		grafo.conectar(vBrigge, vFolkMuseum, 30); grafo.conectar(vFolkMuseum, vBrigge, 30);
		grafo.conectar(vFolkMuseum, vPalacio, 5); grafo.conectar(vPalacio, vFolkMuseum, 5);
		
		
		ListaGenerica<String> restringidos = new ListaEnlazadaGenerica<String>();
		restringidos.agregarFinal("Akker Brigge"); restringidos.agregarFinal("Palacio Real");
		
		System.out.println(new VisitaOslo().paseoEnBici(grafo, "Museo Vikingo", 120, restringidos));
	} 

}
