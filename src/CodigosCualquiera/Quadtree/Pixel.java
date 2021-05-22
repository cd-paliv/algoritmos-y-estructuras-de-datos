package CodigosCualquiera.Quadtree;

public class Pixel {
	private String color; // Blanco, Negro, Mixto.
	
	public Pixel(String color) {
		this.color = color;
	}
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public boolean esNegro() {
		return this.color.equals("Negro");
	}
	
	public boolean esBlanco() {
		return this.color.equals("Blanco");
	}

}
