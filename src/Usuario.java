import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Usuario {
	private String codigoUsuario;
	private String nombre;
	private String apellidos;
	private String email;
	private String fechaNacimiento;
	private String dni;
	private String fechaAlta;

	public Usuario(String codigoUsuario, String nombre, String apellidos, String email, String fechaNacimiento,
			String dni, String fechaAlta) {
		this.codigoUsuario = codigoUsuario;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.fechaNacimiento = fechaNacimiento;
		this.dni = dni;
		this.fechaAlta = fechaAlta;
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

	public static void escribirFichero(Usuario usuario) {
		List<String> lista = new ArrayList<>();
		lista.add(usuario.codigoUsuario);
		lista.add(usuario.nombre);
		lista.add(usuario.apellidos);
		lista.add(usuario.email);
		lista.add(usuario.fechaNacimiento);
		lista.add(usuario.dni);
		lista.add(usuario.fechaAlta + "\n");
		try (PrintWriter out = new PrintWriter(new FileOutputStream(file, true))) {
			out.print(lista.stream().map(Objects::toString).collect(Collectors.joining("\n")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static List<String> leeDeFichero(File fichero) {
		List<String> usuario = new ArrayList<>();
		try {
			usuario = Files.readAllLines(fichero.toPath());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return usuario;
	}

	public static List<Usuario> listaCompleta() {
		List<String> lista = new ArrayList<>();
		lista = Usuario.leeDeFichero(file);
		List<Usuario> usuario = new ArrayList<>();
		for (int i = 0; i < lista.size(); i += 7) {

			String codigoUsuario = lista.get(i);
			String nombre = lista.get(i + 1);
			String apellidos = lista.get(i + 2);
			String email = lista.get(i + 3);
			String fechaNacimiento = lista.get(i + 4);
			String dni = lista.get(i + 5);
			String fechaAlta = lista.get(i + 6);

			Usuario completo = new Usuario(codigoUsuario, nombre, apellidos, email, fechaNacimiento, dni, fechaAlta);
			usuario.add(completo);
		}
		return usuario;
	}


}
