package CodigosCualquiera;

public class MergeSort {

	public static void main(String[] args) {
		
		int[] vector = {8, 0, 3, -1, 5, 7, 2};
		for(int i = 0; i < vector.length; i++)
			System.out.print(vector[i] + " ");
		
		System.out.println();
		
		mergesort(vector, 0, 6);
		for(int i = 0; i < vector.length; i++)
			System.out.print(vector[i] + " ");
	}
	
	
	
	public static void mergesort (int a[],int izq, int der) {
		if(izq < der) {
			int m = (izq + der) / 2;
			mergesort(a, izq, m); //parte izquierda del vector
			mergesort(a, m+1, der); //parte derecha del vector
			merge(a, izq, m, der);
		}
	}
	
	public static void merge (int a[], int izq, int m, int der) {
		int i, j, k;
		int [] b = new int [a.length]; //array auxiliar
		for(i = izq; i <= der; i++) { //copia ambas mitades en el array auxiliar
			b[i] = a[i];
		}
		i = izq; j = m+1; k = izq;
		while(i <= m && j <= der) { //copia el siguiente elemento más grande
			if(b[i] <= b[j])
				a[k++]=b[i++];
			else
				a[k++]=b[j++];
		}
		while(i <= m) //copia los elementos que quedan en la 1era mitad si los hay
			a[k++]=b[i++];
	}
	
}
