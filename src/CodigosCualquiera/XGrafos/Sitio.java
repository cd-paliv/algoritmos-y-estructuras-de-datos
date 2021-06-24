package CodigosCualquiera.XGrafos;

public class Sitio {

	private String nombre;
	private boolean tieneMafia;
	
	public Sitio(String nombre, boolean tieneMafia) {
		//super();
		this.nombre = nombre;
		this.tieneMafia = tieneMafia;
	}

	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public boolean getTieneMafia() {
		return tieneMafia;
	}
	
	public void setTieneMafia(boolean tieneMafia) {
		this.tieneMafia = tieneMafia;
	}
	
	public boolean equals(Object arg0) {
		if(arg0 instanceof Sitio)
			return this.getNombre().equals(((Sitio) arg0).getNombre());
		return false;
	}
	
	
}
