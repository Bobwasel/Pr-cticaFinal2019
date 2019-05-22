import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class WikiGuitarrista {
	private static final DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	public static void main(String[] args) {

		String codeUser;
		boolean isOk;
		do {
			isOk = true;
			codeUser = JOptionPane.showInputDialog("Introduzca el código de usuario(10 dígitos)");
			for (int i = 0; i < codeUser.length(); i++) {
				if (codeUser.charAt(i) < '0' || codeUser.charAt(i) > '9') {
					isOk = false;
				}
			}
		} while (codeUser.length() != 10 || !isOk);

		Usuario usuario1 = new Usuario("1", "pepe", "gomez", "pg@..", "1/1/90", "44775566l", sdf.format(new Date()));
		Usuario usuario2 = new Usuario("2", "pupu", "perico", "albertito@..", "3/3/30", "44575566l",
				sdf.format(new Date()));
		Usuario usuario3 = new Usuario("3", "bolo", "ginuri", "lulalu@..", "4/2/54", "44775466l",
				sdf.format(new Date()));
		
//		Usuario.escribirFichero(usuario1);
//		Usuario.escribirFichero(usuario2);
//		Usuario.escribirFichero(usuario3);
		
		List<Usuario> usuariosRegistrados = Usuario.listaCompleta();
		boolean existe = false;
		for (int i = 0; i < usuariosRegistrados.size(); i++) {
			Usuario usuario = usuariosRegistrados.get(i);
			if (codeUser.equals(usuario.getCodigoUsuario())) {
				existe = true;
				break;
			} 
		}
		Ventana ventana = new Ventana();
		JPanel panel = new JPanel();
		if(existe) {
		panel.add(new JLabel("hola"));
		} else {
			panel.add(new JLabel("registrate"));
		}
		ventana.add(panel);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}