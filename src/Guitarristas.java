
public class Guitarristas {
	
	private String nombre;
	private int edad;
	private String estiloMusical;
	
	public Guitarristas(String nombre, int edad, String estiloMusical) {
		this.nombre = nombre;
		this.edad = edad;
		this.estiloMusical = estiloMusical;
		
	}
	
	private enum modeloGuitarra{
		CLASICA("Clásica"),
		ACUSTICA("Acústica"),
		ELECTRICA("Eléctrica");
		
		private final String nombre;
		
		modeloGuitarra(String nombre) {
			this.nombre = nombre;
		}
		
		public String getNombreModelo() {
			return nombre;
		}
	}

	
	

}
