package vista;

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
		
		this.nombre = nombre;
		this.nombreUsuario = new JLabel("Hola "+nombre); 
		this.nombreUsuario.setBounds(570, 60, 200, 20);
		this.botonComenzarPartida.setBounds(500, 100, 200,30);
		this.botonRetomarPartida.setBounds(500, 150, 200,30);
		this.botonVerPuntajes.setBounds(500, 200, 200, 30);
		this.botonSalir.setBounds(500, 250, 200, 30);
		
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
	
}
