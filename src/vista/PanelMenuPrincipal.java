package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PanelMenuPrincipal extends JPanel {
	
	private Boton botonComenzarPartida= new Boton("Comenzar partida");
	private Boton botonRetomarPartida = new Boton("Retomar partida guardada");
	private Boton botonVerPuntajes = new Boton("Ver puntajes");
	private Boton botonSalir = new Boton("Salir");
	private JLabel nombreUsuario;
	
	public PanelMenuPrincipal(String nombre) {
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.setPreferredSize(new Dimension(300,400));
		this.setBackground(new Color(255,255,255,200));
		
		this.nombreUsuario = new JLabel("Hola "+nombre); 
		this.nombreUsuario.setAlignmentX(CENTER_ALIGNMENT);
		this.botonComenzarPartida.setAlignmentX(CENTER_ALIGNMENT);
		this.botonRetomarPartida.setAlignmentX(CENTER_ALIGNMENT);
		this.botonVerPuntajes.setAlignmentX(CENTER_ALIGNMENT);
		this.botonSalir.setAlignmentX(CENTER_ALIGNMENT);

		this.add(Box.createVerticalStrut(15));
		this.add(nombreUsuario);
		this.add(Box.createVerticalStrut(70));
		this.add(botonComenzarPartida);
		this.add(Box.createVerticalStrut(20));
		this.add(botonRetomarPartida);
		this.add(Box.createVerticalStrut(20));
		this.add(botonVerPuntajes);
		this.add(Box.createVerticalStrut(20));
		this.add(botonSalir);
	}
	
	public void agregarEscuchaComenzarPartida(ActionListener escuchaComenzarPartida) {
		this.botonComenzarPartida.addActionListener(escuchaComenzarPartida);
	}

	public void agregarEscuchaRetomarPartida(ActionListener escuchaRetomarPartida) {
		this.botonRetomarPartida.addActionListener(escuchaRetomarPartida);
	}
	
	public void agregarEscuchaVerPuntajes(ActionListener escuchaVerPuntajes) {
		this.botonVerPuntajes.addActionListener(escuchaVerPuntajes);
	}
	
	public void agregarEscuchaSalir(ActionListener escuchaSalir) {
		this.botonSalir.addActionListener(escuchaSalir);
	}
	
	public void mostrarMensajeNoHayPartida() {
		JOptionPane.showMessageDialog(this, "Ud no tiene partida guardada.", "No hay partida", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void mostrarMensajePuntajesInexistentes() {
		JOptionPane.showMessageDialog(this, "No hay puntajes creados. Juegue para crear puntajes.", "Lista de puntajes vacia", JOptionPane.INFORMATION_MESSAGE);
	}
	
}
