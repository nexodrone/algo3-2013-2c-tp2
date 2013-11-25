package vista;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VentanaComenzarPartida extends Ventana {

	private JButton botonComenzarPartida= new JButton("Comenzar partida");
	private JButton botonRetomarPartida = new JButton("Retomar partido guardada");
	private JButton botonVerPuntajes = new JButton("Ver puntajes");
	private JButton botonSalir = new JButton("Salir");
	private JLabel nombreUsuario;
	
	public  VentanaComenzarPartida(String nombre){
		super("GPS CHALLENGE");
		JPanel panelUsuario = new JPanel();
		panelUsuario.setLayout(null);
		
		
		nombreUsuario = new JLabel("Hola"+" "+nombre); 
		nombreUsuario.setBounds(270, 10, 100, 100);
		botonComenzarPartida.setBounds(200,100,200,30);
		botonRetomarPartida.setBounds(200,150,200,30);
		botonVerPuntajes.setBounds(200,200,200,30);
		botonSalir.setBounds(200,250,200,30);
		
		panelUsuario.add(nombreUsuario);
		panelUsuario.add(botonComenzarPartida);
		panelUsuario.add(botonRetomarPartida);
		panelUsuario.add(botonVerPuntajes);
		panelUsuario.add(botonSalir);
		
		this.add(panelUsuario);
	}

	public void agregarEscucharComenzarPartida(ActionListener escuchaComenzarPartida) {
		botonComenzarPartida.addActionListener(escuchaComenzarPartida);
	}

	public void agregarEscucharRetomarPartida(ActionListener escuchaRetomarPartida) {
		botonRetomarPartida.addActionListener(escuchaRetomarPartida);
	}
	
	public void agregarEscucharVerPuntajes(ActionListener escuchaVerPuntajes) {
		botonVerPuntajes.addActionListener(escuchaVerPuntajes);
	}
	
	public void agregarEscucharSalir(ActionListener escuchaSalir) {
		botonSalir.addActionListener(escuchaSalir);
	}
}
