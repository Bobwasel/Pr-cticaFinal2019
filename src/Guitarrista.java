
public class Guitarrista {

	private String nombre;
	private int edad;
	private String estiloMusical;
	
	public Guitarrista(String nombre, int edad, String estiloMusical) {
		this.nombre = nombre;
		this.edad = edad;
		this.estiloMusical = estiloMusical;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getEstiloMusical() {
		return estiloMusical;
	}

	public void setEstiloMusical(String estiloMusical) {
		this.estiloMusical = estiloMusical;
	}

}
