package vista;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class VentanaNuevoUsuario extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public VentanaNuevoUsuario() {
		String respuesta = JOptionPane.showInputDialog(null,"Por favor elija su nombre","Escriba su nombre");
	}

	public static void main(String[] arguments){
		VentanaNuevoUsuario dialog = new VentanaNuevoUsuario(); 
		
	}
	
}
