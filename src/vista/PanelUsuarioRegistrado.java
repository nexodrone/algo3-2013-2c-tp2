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
	
	private ButtonGroup checks_grupo = new ButtonGroup();
	private Boton botonAceptar = new Boton("Aceptar");
	private Boton botonVolver = new Boton("Volver");
	private JPanel panelJugadores = new JPanel();
	
	public PanelUsuarioRegistrado() {
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.setPreferredSize(new Dimension(300,600));
		this.setBackground(new Color(255,255,255,200));

		JLabel seleNom = new JLabel("Por favor seleccione usuario");
		seleNom.setAlignmentX(CENTER_ALIGNMENT);

		this.panelJugadores.setLayout(new BoxLayout(panelJugadores, BoxLayout.PAGE_AXIS));
		this.panelJugadores.setAlignmentX(CENTER_ALIGNMENT);
		this.panelJugadores.setBackground(Color.WHITE);
		this.panelJugadores.setMaximumSize(new Dimension(250,400));

		this.add(Box.createVerticalStrut(15));
		this.add(seleNom);
		this.add(Box.createVerticalStrut(20));
		this.add(botonAceptar);
		this.add(Box.createVerticalStrut(20));
		this.add(botonVolver);
		this.add(Box.createVerticalStrut(20));
		this.add(panelJugadores);
	}

	public void agregarJugador(int index, String nombre) {
		JRadioButton check = new JRadioButton(nombre);
		check.setAlignmentX(CENTER_ALIGNMENT);
		check.setActionCommand(nombre);
		check.setBackground(Color.WHITE);
		this.panelJugadores.add(check);
		this.panelJugadores.add(Box.createVerticalStrut(5));
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
