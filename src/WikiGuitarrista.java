import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

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
		JLabel etiqueta = new JLabel();

		String codigo = codeUser;
		if (existe) {
			System.out.println("blabla");
		} else {
			Panel panel = Panel.formularioRegistro();
			Boton boton = new Boton("Registrarse");
			ventana.add(etiqueta, BorderLayout.SOUTH);
			ventana.add(panel, BorderLayout.CENTER);
			boton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					String nombre = panel.getNombre().getText();
					String apellido = panel.getApellido().getText();
					String email = panel.getEmail().getText();
					String fechaNacimiento = panel.getFecha().getText();
					String DNI = panel.getDNI().getText();
					Usuario usuario = new Usuario(codigo, nombre, apellido, email, fechaNacimiento, DNI,
							sdf.format(new Date()));
					usuariosRegistrados.add(usuario);
					Usuario.escribirFichero(usuario);
					JOptionPane.showMessageDialog(null,
							"Se ha registrado correctamente, recuerde que su usuario es " + codigo);
					ventana.removeAll();
					//ventana.add();
				}
			});
			ventana.add(panel);
			ventana.add(boton, BorderLayout.PAGE_END);
		}
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}