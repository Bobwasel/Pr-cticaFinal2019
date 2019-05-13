import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class Usuario {
	private String codigoUsuario;
	private String nombre;
	private String apellidos;
	private String email;
	private String fechaNacimiento;
	private String dni;

	public Usuario(String codigoUsuario, String nombre, String apellidos, String email, String fechaNacimiento,
			String dni) {
		this.codigoUsuario = codigoUsuario;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.fechaNacimiento = fechaNacimiento;
		this.dni = dni;
	}

	public String getCodigoUsuario() {
		return codigoUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public String getEmail() {
		return email;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public String getDni() {
		return dni;
	}

	static File file = new File("./Usuarios.txt");

	public static List<String> leeDeFichero(File fichero) {
		List<String> usuario = new ArrayList<>();
		try {
			usuario = Files.readAllLines(fichero.toPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return usuario;
	}
	public static List<Usuario> listaCompleta(){
		List<String> lista = new ArrayList<>();
		lista = Usuario.leeDeFichero(file);
		
		return null;
	}
}
