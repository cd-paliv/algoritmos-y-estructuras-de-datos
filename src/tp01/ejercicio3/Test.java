package tp01.ejercicio3;

public class Test {

	public static void main(String[] args) {
		
		Profesor[] p = new Profesor[3];
		p[0] = new Profesor("Paula", "Vaccaro", "paliv@gmail.com", "2A", "Informatica");
		p[1] = new Profesor("Ivo", "Diaz", "ivod@gmail.com", "2B", "Psicologia");
		p[2] = new Profesor("Blanca", "Estela", "blancae@gmail.com", "4E", "Matematica");
		
		System.out.println("PROFESORES:");
		for(int i = 0; i < p.length; i++)
			System.out.println(p[i].tusDatos());
		
		Estudiante[] e = new Estudiante[2];
		e[0] = new Estudiante("Jorge", "Lopez", "2B", "jorgel@gmail.com", "55");
		e[1] = new Estudiante("Maria", "Lopez", "4E", "marial@gmail.com", "467");
		
		System.out.println();
		System.out.println("ESTUDIANTES:");
		for(int i = 0; i < e.length; i++)
			System.out.println(e[i].tusDatos());
		
	}

}
