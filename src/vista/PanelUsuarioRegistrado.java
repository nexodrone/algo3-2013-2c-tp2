package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class PanelUsuarioRegistrado extends JPanel {
	
	private JLabel seleNom = new JLabel("Por favor seleccione usuario");
	private ButtonGroup checks_grupo = new ButtonGroup();
	private Boton botonAceptar = new Boton("Aceptar");
	private Boton botonVolver = new Boton("Volver");
	
	public PanelUsuarioRegistrado() {
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.setPreferredSize(new Dimension(300,500));
		this.setBackground(new Color(255,255,255,150));

		this.seleNom.setAlignmentX(CENTER_ALIGNMENT);
		this.botonAceptar.setAlignmentX(CENTER_ALIGNMENT);
		this.botonVolver.setAlignmentX(CENTER_ALIGNMENT);

		this.add(Box.createVerticalStrut(15));
		this.add(seleNom);
		this.add(Box.createVerticalStrut(20));
		this.add(botonAceptar);
		this.add(Box.createVerticalStrut(20));
		this.add(botonVolver);
		this.add(Box.createVerticalStrut(20));
	}

	public void agregarJugador(int index, String nombre) {
		JRadioButton check = new JRadioButton(nombre);
		check.setAlignmentX(CENTER_ALIGNMENT);
		check.setActionCommand(nombre);
		this.add(check);
		this.add(Box.createVerticalStrut(5));
		this.checks_grupo.add(check);
	}
	
	public String getSeleccion() {
		return checks_grupo.getSelection().getActionCommand();
	}
	
	public boolean hayUnSeleccionado() {
		return ( checks_grupo.getSelection() != null );
	}
	
	public void agregarEscuchadorAceptar(ActionListener escuchaAceptar) {
		this.botonAceptar.addActionListener(escuchaAceptar);
	}
	
	public void agregarEscuchadorVolver(ActionListener escuchaVolver) {
		this.botonVolver.addActionListener(escuchaVolver);
	}	
	
	public void mostrarMensajeNoHaySeleccionado() {
		JOptionPane.showMessageDialog(this, "Por favor seleccione un usuario.", "Usuario no seleccionado", JOptionPane.WARNING_MESSAGE);
	}
}
