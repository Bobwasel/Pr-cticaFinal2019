import java.awt.BorderLayout;
import java.awt.Font;
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

	public static void inicio() {
		JLabel mensaje = new JLabel("¿Qué desea realizar?");
		mensaje.setFont(new Font("Arial", Font.BOLD, 84));
		Panel panel = Panel.PanelDeInicio();
		Ventana ventana = new Ventana();
		ventana.add(mensaje, BorderLayout.NORTH);
		ventana.add(panel);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		Lector lector = new Lector();

		List<Usuario> usuariosRegistrados = Usuario.listaCompleta();
		lector.bloquea();
		String leido = lector.getLectura();
		lector.dispose();
		boolean existe = false;
		for (int i = 0; i < usuariosRegistrados.size(); i++) {
			Usuario usuario = usuariosRegistrados.get(i);
			if (leido.equals(usuario.getCodigoUsuario())) {
				existe = true;
				break;
			}
		}

		String codigo = leido;
		if (existe) {
			inicio();
		} else {
			Ventana ventana = new Ventana();
			JLabel etiqueta = new JLabel();
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
					ventana.dispose();
					inicio();
				}
			});
			ventana.add(panel);
			ventana.add(boton, BorderLayout.PAGE_END);
			ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}

	}
}