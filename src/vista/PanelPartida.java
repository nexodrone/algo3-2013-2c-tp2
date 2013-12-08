package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

import modelo.Juego;
import modelo.Posicion;
import modelo.Tablero;


public class PanelPartida extends JPanel {
	
	private JButton botonGuardar = new JButton("Guardar");
	private JButton botonVolver = new JButton("Volver");
	private JLabel nota = new JLabel("Nota: al cerrar el programa o volver, todo progreso no guardado sera perdido.");
	private JLabel nombreUsuario;
	private JLabel dificultad;
	private JLabel vehiculoActual;
	private PanelZonaDeJuego panelZonaDelJuego;
	private int anchoZonaDelJuego = 870;
	private int largoZonaDelJuego = 610;
	String nivelSeleccionado;

	
	public PanelPartida(String nombre, String dificultad, String vehiculo,Tablero tablero,Posicion posicion) {
		this.setLayout(null);
		this.nivelSeleccionado=dificultad;
		this.panelZonaDelJuego = new PanelZonaDeJuego(tablero,vehiculo,posicion);
		
		this.setPreferredSize(new Dimension(1180,680));
		this.setBackground(new Color(0,0,0,25));
		
		this.nombreUsuario = new JLabel("Jugador: "+nombre);
		this.dificultad = new JLabel("Dificultad: "+dificultad);
		this.vehiculoActual = new JLabel("Vehiculo: "+vehiculo);
		this.nombreUsuario.setBounds(10, 10, 200, 20);
		this.dificultad.setBounds(10, 30, 200, 20);
		this.vehiculoActual.setBounds(10, 50, 200, 20);
		this.botonGuardar.setBounds(10, 550, 200, 30);
		this.botonVolver.setBounds(10, 600, 200, 30);
		this.nota.setBounds(10, 750, 500, 20);
		
		this.add(nota);
		this.add(this.nombreUsuario);
		this.add(this.dificultad);
		this.add(this.vehiculoActual);
		this.add(botonGuardar);
		this.add(botonVolver);
		this.add(panelZonaDelJuego);
	}
	
	public void inicializarZonaDelJuego() {
		this.panelZonaDelJuego.setLayout(null);
		this.panelZonaDelJuego.setBounds(300, 50,anchoZonaDelJuego,largoZonaDelJuego);
		this.panelZonaDelJuego.setBackground(Color.black);
	}

	public void agregarEscuchaGuardar(ActionListener escuchaGuardar) {
		this.botonGuardar.addActionListener(escuchaGuardar);
	}

	public void agregarEscuchaVolver(ActionListener escuchaVolver) {
		this.botonVolver.addActionListener(escuchaVolver);
	}
	
	public PanelZonaDeJuego getPanelZonaDeJuego(){
		return this.panelZonaDelJuego;
	}
	
	public void agregarEscuchaFlechas(KeyListener escuchaFlechas) {
		InputMap mapaDeEntrada = this.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW);
		ActionMap mapaDeAcciones = this.getActionMap();
		
		mapaDeEntrada.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), "FlechaArriba");
		mapaDeEntrada.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), "FlechaAbajo");
		mapaDeEntrada.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "FlechaIzquierda");
		mapaDeEntrada.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "FlechaDerecha");
		
		this.addKeyListener(escuchaFlechas);
	}
	
	public void mostrarMensajePartidaGuardada() {
		JOptionPane.showMessageDialog(this, "Su partida es guardada exitosamente.", "Partida guardada", JOptionPane.INFORMATION_MESSAGE);
	}

	public void mostrarMensajeError() {
		JOptionPane.showMessageDialog(this, "Se ocurrio error!", "Error", JOptionPane.ERROR_MESSAGE);
	}
	
	public void mostrarMensajeMovimientoInvalido() {
		JOptionPane.showMessageDialog(this, "Imposible escapar de la ciudad.", "A donde van?", JOptionPane.ERROR_MESSAGE);
	}
	
	public void mostrarMensajePartidaGanada() {
		String nombre = Juego.getInstance().getJugadorActual().getNickName(); 
		JOptionPane.showMessageDialog(this, "¡Felicitaciones "+ nombre +", has ganado el nivel. Eres el puto amo!", "¡Bien ahi Papote!", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void mostrarMensajePartidaPerdida() {
		String nombre = Juego.getInstance().getJugadorActual().getNickName(); 
		JOptionPane.showMessageDialog(this, nombre +", te has quedado sin movimientos. Volve a intertarlo muerto!", "¡JA fracasado!", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void mostrarMensajeUsuarioInexistente() {
		String nombre = Juego.getInstance().getJugadorActual().getNickName(); 
		JOptionPane.showMessageDialog(this,"El usuario '"+ nombre +"' no existe. No se guardara el puntaje.", "Error", JOptionPane.ERROR_MESSAGE);
	}
	
}