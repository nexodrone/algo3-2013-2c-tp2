package vista;

import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.*;

public class PanelPartida extends JPanel {
	
	private JButton botonGuardar = new JButton("Guardar");
	private JButton botonVolver = new JButton("Volver");
	private JLabel nota = new JLabel("Nota: al cerrar el programa o volver, todo progreso no guardado sera perdido.");
	private JLabel nombreUsuario;
	private JLabel dificultad;
	private JLabel vehiculoActual;
	private JPanel zonaDelJuego = new JPanel();
	
	public PanelPartida(String nombre, String dificultad, String vehiculo) {
		this.setLayout(null);

		this.nombreUsuario = new JLabel("Jugador: "+nombre);
		this.dificultad = new JLabel("Dificultad: "+dificultad);
		this.vehiculoActual = new JLabel("Vehiculo: "+vehiculo);
		
		this.nombreUsuario.setBounds(10, 10, 200, 20);
		this.dificultad.setBounds(10, 30, 200, 20);
		this.vehiculoActual.setBounds(10, 50, 200, 20);
		this.botonGuardar.setBounds(10, 650, 200, 30);
		this.botonVolver.setBounds(10, 700, 200, 30);
		this.nota.setBounds(10, 750, 500, 20);
		
		this.add(nota);
		this.add(this.nombreUsuario);
		this.add(this.dificultad);
		this.add(this.vehiculoActual);
		this.add(botonGuardar);
		this.add(botonVolver);
		this.add(zonaDelJuego);
	}
	
	public void inicializarZonaDelJuego(int tamanioX, int tamanioY) {
		this.zonaDelJuego.setLayout(null);
		this.zonaDelJuego.setBounds(150, 10, tamanioX*20, tamanioY*20);
		this.zonaDelJuego.setBackground(Color.black);
	}
	
	public void agregarEscuchaGuardar(ActionListener escuchaGuardar){
		this.botonGuardar.addActionListener(escuchaGuardar);
	}

	public void agregarEscuchaVolver(ActionListener escuchaVolver){
		this.botonVolver.addActionListener(escuchaVolver);		  
	}
	
	public void mostrarMensajePartidaGuardada() {
		JOptionPane.showMessageDialog(this, "Su partida es guardada exitosamente.", "Partida guardada", JOptionPane.INFORMATION_MESSAGE);
	}

	public void mostrarMensajeError() {
		JOptionPane.showMessageDialog(this, "Se ocurrio error!", "Error", JOptionPane.ERROR_MESSAGE);
	}
	
}