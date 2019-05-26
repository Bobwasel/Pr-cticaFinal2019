import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Lector extends JDialog {
	String leido = null;

	public Lector() {
		super(new JFrame());
		this.leido = "";
		setTitle("LOGIN");
		setModal(true);
		setBounds(0, 0, 1100, 800);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		JPanel panel = new JPanel(new BorderLayout());
		JLabel mensaje = new JLabel("Si quieres pasar, pasa la tarjeta mangurrían!");
		mensaje.setForeground(Color.PINK);
		mensaje.setFont(new Font("Arial", Font.BOLD, 42));
		panel.add(mensaje);
		add(panel);
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				super.keyTyped(e);
				pulsacion(e);
			}
		});
	}

	private void pulsacion(KeyEvent e) {
		char noValido = e.getKeyChar();
		if (noValido >= 48 && noValido <= 57) {
			this.leido += e.getKeyChar();
			if (this.leido.length() == 10) {
				this.setVisible(false);
			}
		}
	}

	public void bloquea() {
		this.setVisible(true);
	}

	public String getLectura() {
		String salida = leido;
		leido = "";
		return salida;
	}
}
