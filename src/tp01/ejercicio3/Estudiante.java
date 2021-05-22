package tp01.ejercicio3;

public class Estudiante {
	private String nom;
	private String ape;
	private String comision;
	private String email;
	private String dire;
	
	public Estudiante(String nom, String ape, String comision, String email, String dire) {
		this.nom = nom;
		this.ape = ape;
		this.comision = comision;
		this.email = email;
		this.dire = dire;
	}
	
	public String tusDatos() {
		return this.getApe()+", "+ this.getNom()+" ("+this.getEmail()+") <"+this.getComision()+"> "+this.getDire();
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getApe() {
		return ape;
	}
	public void setApe(String ape) {
		this.ape = ape;
	}
	public String getComision() {
		return comision;
	}
	public void setComision(String comision) {
		this.comision = comision;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDire() {
		return dire;
	}
	public void setDire(String dire) {
		this.dire = dire;
	}
	
	
}
