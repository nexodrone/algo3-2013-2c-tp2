package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PanelMenuPrincipal extends JPanel {
	
	private JButton botonComenzarPartida= new JButton("Comenzar partida");
	private JButton botonRetomarPartida = new JButton("Retomar partida guardada");
	private JButton botonVerPuntajes = new JButton("Ver puntajes");
	private JButton botonSalir = new JButton("Salir");
	private JLabel nombreUsuario;
	private String nombre;
	
	public PanelMenuPrincipal(String nombre) {
		this.setLayout(null);
		this.setPreferredSize(new Dimension(300,400));
		this.nombre = nombre;
		this.nombreUsuario = new JLabel("Hola "+nombre); 
		this.nombreUsuario.setBounds(50, 60, 200, 20);
		this.botonComenzarPartida.setBounds(50, 100, 200, 30);
		this.botonRetomarPartida.setBounds(50, 150, 200, 30);
		this.botonVerPuntajes.setBounds(50, 200, 200, 30);
		this.botonSalir.setBounds(50, 250, 200, 30);
		this.setBackground(new Color(255,255,255,150));
		this.add(nombreUsuario);
		this.add(botonComenzarPartida);
		this.add(botonRetomarPartida);
		this.add(botonVerPuntajes);
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

	public String getNombreUsuario(){
		return nombre;
	}
	
	public void mostrarMensajeNoHayPartida() {
		JOptionPane.showMessageDialog(this, "Ud no tiene partida guardada.", "No hay partida", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void mostrarMensajePuntajesInexistentes() {
		JOptionPane.showMessageDialog(this, "No hay puntajes creados. Juegue para crear puntajes.", "Lista de puntajes vacia", JOptionPane.INFORMATION_MESSAGE);
	}
	
}
