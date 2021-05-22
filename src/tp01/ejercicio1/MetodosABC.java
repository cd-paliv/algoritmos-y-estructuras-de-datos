package tp01.ejercicio1;

public class MetodosABC {
	public static void entreNumerosFor(int a, int b){		
		for(int i = a; i<=b; i++) {
			System.out.println(i);
		}		
	}
	
	public static void entreNumerosWhile(int a, int b){		
		while(a<=b) {
			System.out.println(a);
			a++;
		}
	}
	
	public static void entreNumerosIf(int a, int b){		
		System.out.println(a);
		if(a<b) {
			MetodosABC.entreNumerosIf(a+1, b);
		}
	}
}
