
public class Banda extends Guitarrista {
	
	private String nombreBanda;
	
	public Banda(String nombre, int edad, String estiloMusical, String nombreBanda) {
		super(nombre, edad, estiloMusical);
		this.nombreBanda = nombreBanda;
	}

	public String getNombreBanda() {
		return nombreBanda;
	}

	public void setNombreBanda(String nombreBanda) {
		this.nombreBanda = nombreBanda;
	}
	
	

}
