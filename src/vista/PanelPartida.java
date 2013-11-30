package vista;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PanelPartida extends JPanel {
	
	private JButton botonGuardar = new JButton("Guardar");
	private JLabel nombreUsuario;
	private JLabel dificultad;
	private JLabel vehiculoActual;
	private JPanel zonaDelJuego = new JPanel();
	
	public PanelPartida(String nombre, String dificultad, String vehiculo) {
		this.setLayout(null);

		this.nombreUsuario = new JLabel("Jugador: "+nombre);
		this.dificultad = new JLabel("Dificultad: "+dificultad);
		this.vehiculoActual = new JLabel("Vehiculo: "+vehiculo);
		
		this.nombreUsuario.setBounds(10, 10, 100, 20);
		this.dificultad.setBounds(10, 30, 100, 20);
		this.vehiculoActual.setBounds(10, 50, 100, 20);
		this.botonGuardar.setBounds(10, 300, 100, 30);
		
		this.add(this.nombreUsuario);
		this.add(this.dificultad);
		this.add(this.vehiculoActual);
		this.add(botonGuardar);
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
	
	public void mostrarMensajePartidaGuardada() {
		JOptionPane.showMessageDialog(this, "Su partida es guardada exitosamente.", "Partida guardada", JOptionPane.INFORMATION_MESSAGE);
	}

	public void mostrarMensajeError() {
		JOptionPane.showMessageDialog(this, "Se ocurrio error!", "Error", JOptionPane.ERROR_MESSAGE);
	}
	
}