
public class Solista extends Guitarrista {

	public Solista(String nombre, int edad, String estiloMusical) {
		super(nombre, edad, estiloMusical);
	}

	private enum modeloGuitarra{
		CLASICA("Clásica"),
		ACUSTICA("Acústica"),
		ELECTRICA("Eléctrica");
		
		private String nombreModelo;
		
		modeloGuitarra(String nombreModelo) {
			this.nombreModelo = nombreModelo;
		}
		
		public String getNombreModelo() {
			return nombreModelo;
		}
		
	}
}
