package tp01.ejercicio2;

public class N {

	public static void main(String[] args) {
		int[] vector = N.obtenerMultiplos(5);
		System.out.print("[");
		for(int i = 0; i < vector.length; i++) {
			System.out.print(vector[i]+ "; ");
		}
		System.out.println("]");
	}
	
	public static int[] obtenerMultiplos(int n) {
		int[] v = new int[n];
		for(int i = 0; i < n; i++) {
			v[i] = n * i;
		}
		return v;
	}

}
