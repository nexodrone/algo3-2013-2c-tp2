package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class PanelUsuarioRegistrado extends JPanel {
	
	ButtonGroup checks_grupo;
	JButton aceptar;
	JButton volver;
	
	public PanelUsuarioRegistrado() {
		setLayout(null);
		this.setPreferredSize(new Dimension(400,400));
		checks_grupo = new ButtonGroup();
		
		aceptar = new JButton("Aceptar");
		aceptar.setBounds(this.WIDTH + 50, 50, 100, 25);
		this.add(aceptar);
		
		volver = new JButton("Volver");
		volver.setBounds(this.WIDTH + 50, 80, 100, 25);
		this.setBackground(new Color(255,255,255,150));
		this.add(volver);
	}

	public void agregarJugador(int index, String nombre) {
		JRadioButton check = new JRadioButton(nombre);
		check.setBounds(200, index*25, 150, 20);
		check.setActionCommand(nombre);
		this.add(check);
		checks_grupo.add(check);
	}
	
	public String getSeleccion() {
		return checks_grupo.getSelection().getActionCommand();
	}
	
	public boolean hayUnSeleccionado() {
		return ( checks_grupo.getSelection() != null );
	}
	
	public void agregarEscuchadorAceptar(ActionListener escuchaAceptar) {
		aceptar.addActionListener(escuchaAceptar);
	}
	
	public void agregarEscuchadorVolver(ActionListener escuchaVolver) {
		volver.addActionListener(escuchaVolver);
	}	
	
	public void mostrarMensajeNoHaySeleccionado() {
		JOptionPane.showMessageDialog(this, "Por favor seleccione un usuario.", "Usuario no seleccionado", JOptionPane.WARNING_MESSAGE);
	}
}
