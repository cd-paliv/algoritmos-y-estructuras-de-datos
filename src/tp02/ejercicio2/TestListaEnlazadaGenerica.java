package tp02.ejercicio2;
import tp01.ejercicio3.Estudiante;
//import tp02.ejercicio2.*;

public class TestListaEnlazadaGenerica {

	public static void main(String[] args) {
		Estudiante[] vector = new Estudiante[4];
		vector[0] = new Estudiante("Paula", "Vaccaro", "1A", "paliv@gmail.com", "467");
		vector[1] = new Estudiante("Ivo", "Diaz", "1A", "ivod@gmail.com", "40");
		vector[2] = new Estudiante("Jorge", "Lopez", "2E", "jorgel@gmail.com", "55");
		vector[3] = new Estudiante("Blanca", "Perez", "4B", "blancap@gmail.com", "19");
		
		ListaGenerica<Estudiante> l = new ListaEnlazadaGenerica<Estudiante>();
		for(int i = 0; i < 4; i++) {
			l.agregarFinal(vector[i]);
		}
		
		if (!l.esVacia()) {
			for(int i = 0; i < l.tamanio(); i++) {
				System.out.println(l.elemento(i+1).tusDatos() + " ");
			}
		}

	}

}
