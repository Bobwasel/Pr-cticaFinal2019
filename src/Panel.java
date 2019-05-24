import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Panel extends JPanel {
	private JLabel nombre = new JLabel("Nombre");
	private JTextField introduceNombre = new JTextField(15);
	private JLabel apellido = new JLabel("apellido");
	private JTextField introduceApellido = new JTextField(15);
	private JLabel email = new JLabel("Email");
	private JTextField introduceEmail = new JTextField(15);
	private JLabel fechaNacimiento = new JLabel("Fecha nacimiento");
	private JTextField introduceFecha = new JTextField(15);
	private JLabel DNI = new JLabel("DNI");
	private JTextField introduceDNI = new JTextField(15);
	
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
	
	private void CargarFormularioRegistro()
	{
	    setLayout(new GridLayout(5, 0));
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
	
	private void PanelInicio() {
		setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
		
	}

}
