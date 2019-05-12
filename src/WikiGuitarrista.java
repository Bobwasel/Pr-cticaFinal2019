import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class WikiGuitarrista {

    public static void main (String[] args){
    	
    	String usuario = JOptionPane.showInputDialog(null, "Usuario (10 dígitos)");
    	while (usuario.length()!=10) {
    		JOptionPane.showMessageDialog(null, "Tiene que tener 10 dígitos");
    		usuario = JOptionPane.showInputDialog(null, "Usuario");
    	}
    	
    	Ventana ventana = new Ventana();
    	JPanel panel = new JPanel();
    	ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
    	
    }
}