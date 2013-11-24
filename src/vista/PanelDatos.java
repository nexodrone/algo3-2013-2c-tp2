package vista;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelDatos extends JPanel {
	
	public PanelDatos(){
		setLayout(new GridLayout(3,2));
		JLabel etiquetaNombre = new JLabel("Por favor elija un nombre:");
		JTextField campoNombre = new JTextField();
		add(etiquetaNombre);
		add(campoNombre);
	
	}

}
