package vista;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelMenuPrincipal extends JPanel {
	
	private JButton botonComenzarPartida= new JButton("Comenzar partida");
	private JButton botonRetomarPartida = new JButton("Retomar partido guardada");
	private JButton botonVerPuntajes = new JButton("Ver puntajes");
	private JButton botonSalir = new JButton("Salir");
	private JLabel nombreUsuario;
	
	public PanelMenuPrincipal(String nombre) {
		this.setLayout(null);
		
		this.nombreUsuario = new JLabel("Hola"+" "+nombre); 
		this.nombreUsuario.setBounds(270, 10, 100, 100);
		this.botonComenzarPartida.setBounds(200,100,200,30);
		this.botonRetomarPartida.setBounds(200,150,200,30);
		this.botonVerPuntajes.setBounds(200,200,200,30);
		this.botonSalir.setBounds(200,250,200,30);
		
		this.add(nombreUsuario);
		this.add(botonComenzarPartida);
		this.add(botonRetomarPartida);
		this.add(botonVerPuntajes);
		this.add(botonSalir);
	}
	
	public void agregarEscucharComenzarPartida(ActionListener escuchaComenzarPartida) {
		this.botonComenzarPartida.addActionListener(escuchaComenzarPartida);
	}

	public void agregarEscucharRetomarPartida(ActionListener escuchaRetomarPartida) {
		this.botonRetomarPartida.addActionListener(escuchaRetomarPartida);
	}
	
	public void agregarEscucharVerPuntajes(ActionListener escuchaVerPuntajes) {
		this.botonVerPuntajes.addActionListener(escuchaVerPuntajes);
	}
	
	public void agregarEscucharSalir(ActionListener escuchaSalir) {
		this.botonSalir.addActionListener(escuchaSalir);
	}
	
}
