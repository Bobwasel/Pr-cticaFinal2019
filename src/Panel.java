import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Panel extends JPanel {
	private JLabel nombre = new JLabel("  Nombre");
	private JTextField introduceNombre = new JTextField(15);
	private JLabel apellido = new JLabel("  Apellido");
	private JTextField introduceApellido = new JTextField(15);
	private JLabel email = new JLabel("  Email");
	private JTextField introduceEmail = new JTextField(15);
	private JLabel fechaNacimiento = new JLabel("  Fecha nacimiento");
	private JTextField introduceFecha = new JTextField(15);
	private JLabel DNI = new JLabel("  DNI");
	private JTextField introduceDNI = new JTextField(15);
	private JLabel edad = new JLabel("  Edad");
	private JTextField introduceEdad = new JTextField(15);
	private JLabel estiloMusical = new JLabel("  Estilo Musical");
	private JTextField introduceEstiloMusical = new JTextField(15);

	public Panel() {

	}

	public JTextField getNombre() {
		return introduceNombre;
	}

	public JTextField getApellido() {
		return introduceApellido;
	}

	public JTextField getEmail() {
		return introduceEmail;
	}

	public JTextField getFecha() {
		return introduceFecha;
	}

	public JTextField getDNI() {
		return introduceDNI;
	}

	private void CargarFormularioRegistro() {
		setLayout(new GridLayout(5, 0, 20, 20));
		add(nombre);
		add(introduceNombre);
		add(apellido);
		add(introduceApellido);
		add(email);
		add(introduceEmail);
		add(fechaNacimiento);
		add(introduceFecha);
		add(DNI);
		add(introduceDNI);
	}

	public static Panel formularioRegistro() {
		Panel panel = new Panel();
		panel.CargarFormularioRegistro();
		return panel;
	}
	private void anaydirAlFichero() {
		 JFileChooser pedirFichero=new JFileChooser();
	     pedirFichero.showOpenDialog(null);
	     InformacionGuitarrista.anyadeGuitarrista(pedirFichero.getSelectedFile());
	}
	private void listarFichero() {
		 JFileChooser pedirFichero=new JFileChooser();
	     pedirFichero.showOpenDialog(null);
	     InformacionGuitarrista.listaGuitarristas(pedirFichero.getSelectedFile());
	     listaHTML();
	}
	
	private void panelAnayeGuitarrista() {
		setLayout(new GridLayout(3, 0, 20, 20));
		add(nombre);
		add(introduceNombre);
		add(edad);
		add(introduceEdad);
		add(estiloMusical);
		add(introduceEstiloMusical);
	}
	private void anyadirGuitarrista() {
		Ventana ventana = new Ventana();
		Panel panel = new Panel();
		panel.panelAnayeGuitarrista();
		Boton boton = new Boton("AÑADIR");
		boton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String nombre = panel.introduceNombre.getText();
				int edad = Integer.parseInt(panel.introduceEdad.getText());
				String estiloMusical = panel.introduceEstiloMusical.getText();
				Guitarrista guitarrista = new Guitarrista(nombre, edad, estiloMusical);
				InformacionGuitarrista.anyadirNuevoGuitarrista(guitarrista);
				anaydirAlFichero();
				ventana.dispose();
			}
		});
		ventana.add(panel);
		ventana.add(boton, BorderLayout.PAGE_END);
		ventana.setExtendedState(Frame.MAXIMIZED_BOTH);
	}
	
	private void PanelInicio() {
		setLayout(new GridLayout(2, 0));
		Map<JButton, ActionListener> botones=new HashMap<>();
        botones.put(new JButton("Añadir"), e-> anyadirGuitarrista());
        botones.put(new JButton("Listar"), e-> listarFichero());
        for(Map.Entry<JButton,ActionListener> boton:
            botones.entrySet()){
            boton.getKey().setMargin(new Insets(20, 20, 20, 20));
            boton.getKey().addActionListener(boton.getValue());
            add(boton.getKey());
        }
	}

	public static Panel PanelDeInicio() {
		Panel panel = new Panel();
		panel.PanelInicio();
		return panel;
	}
	
	private void listaHTML() {
		JLabel mensaje = new JLabel(InformacionGuitarrista.listadoHTML());
		Ventana ventana = new Ventana();
		ventana.add(mensaje);
	}

}
