package tp03.ejercicio1;

public class Frecuencia {
	private String detalle;
	private int valor;
	
	public Frecuencia(String detalle, int valor) {
		super();
		this.detalle = detalle;
		this.valor = valor;
	}
	
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	public String toString() {
		return this.getDetalle()+"("+this.getValor()+")";
	}
}

