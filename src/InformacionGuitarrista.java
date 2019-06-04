import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class InformacionGuitarrista {
	static List<Guitarrista> lista = new ArrayList<>();

	public static void anyadeGuitarrista(File fichero) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichero.getPath()))) {
			oos.writeObject(lista);
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void listaGuitarristas(File fichero) {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero.getPath()))) {
			lista = (List<Guitarrista>) ois.readObject();
			ois.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static String listadoHTML() {
		String cadena = "<html><body>";
		for(Guitarrista g : lista){
			cadena += "<h1>" + g.getNombre() + "</h1>";
			cadena += "<h2>" + g.getEdad() + " ---------- " + "<strong>" + g.getEstiloMusical() + "</strong></h2>";
			cadena += "***********************************";
		}
		if(lista.size() == 0) {
			cadena += "<h1><strong>No hay ningún guitarrista</strong></h1>";
		}
		cadena += "</body></html>";
		System.out.println(cadena);
		return cadena;
	}

	public static void anyadirNuevoGuitarrista(Guitarrista guitarrista) {
		lista.add(guitarrista);
	}
	
	public static void modificarGuitarrista(Guitarrista guitarrista) {
		anyadirNuevoGuitarrista(guitarrista);
	}
}
