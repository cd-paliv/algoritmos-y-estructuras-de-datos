package CodigosCualquiera.Princesa;

public class Personaje {
	private String nombre;
	private String tipo;
	
	public Personaje(String nombre, String tipo) {
		//super();
		setNombre(nombre);
		setTipo(tipo);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public boolean esDragon() {
		return this.tipo == "Dragon";
	}
	
	public boolean esPrincesa() {
		return this.tipo == "Princesa";
	}

}
