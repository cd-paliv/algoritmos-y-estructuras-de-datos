package tp01.ejercicio5;

public class Ej5 {
	private static int min5;
	private static int max5;
	private static float prom5;
	
	//Devuelva lo pedido por el mecanismo de retorno de un método en Java ("return")
	public Datos calcular(int[] datos) {
		int max = 0, min = 9999, cont = 0;
		float tot = 0;
		for(int i = 0; i < datos.length; i++) {
			if(datos[i] < min)
				min = datos[i];
			if (datos[i] > max)
				max = datos[i];
			cont++;
			tot += datos[i];
		}
		Datos o = new Datos();
		float prom = tot/cont;
		o.setMax(max);
		o.setMin(min);
		o.setProm(prom);
		return o;
	}
	
	//Devuelva lo pedido interactuando con algún parámetro (el parámetro no puede ser de tipo arreglo)
	public void calcularReferencia(int[] nums, Datos datos) {
		int max = 0, min = 9999, cont = 0;
		float total = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > max)
				max = nums[i];
			if (nums[i] < min)
				min = nums[i];
			cont++;
			total += nums[i];
		}
		float prom = total/cont;
		datos.setMax(max);
		datos.setMin(min);
		datos.setProm(prom);
	}
	
	//Devuelva lo pedido sin usar parámetros ni la sentencia "return"
	public static void calcularSinRetorno(int[] nums) {
		int max = 0, min = 9999, cont = 0;
		float total = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > max)
				max = nums[i];
			if (nums[i] < min)
				min = nums[i];
			cont++;
			total+=nums[i];
		}
		float prom = total/cont;
		Ej5.max5 = max;
		Ej5.min5 = min;
		Ej5.prom5 = prom;
	}
	
	

	public static int getMin5() {
		return min5;
	}

	public static void setMin5(int min5) {
		Ej5.min5 = min5;
	}

	public static int getMax5() {
		return max5;
	}

	public static void setMax5(int max5) {
		Ej5.max5 = max5;
	}

	public static float getProm5() {
		return prom5;
	}

	public static void setProm5(float prom5) {
		Ej5.prom5 = prom5;
	}
	
	
	
}
