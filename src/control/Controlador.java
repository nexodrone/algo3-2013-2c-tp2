package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Juego;
import vista.VentanaBienvenido;
import vista.VentanaComenzarPartida;
import vista.VentanaUsuarioNuevo;

public class Controlador {
	
	private Juego juego;
	private VentanaBienvenido ventanaBienvenido;
	private VentanaUsuarioNuevo ventanaUsuarioNuevo;
	private VentanaComenzarPartida ventanaComenzarPartida;
	
	public Controlador(Juego juego) {
		this.juego = juego;
		this.inicializarVentanaPrincipal();
		this.inicializarVentanaUsuarioNuevo();
		this.inicializarVentanaComenzarPartida();
	}
	
	
	private void inicializarVentanaPrincipal() {
		this.ventanaBienvenido = new VentanaBienvenido();
		this.ventanaBienvenido.agregarEscuchaNuevoUsuario(new EscuchaNuevoUsuario());
		this.ventanaBienvenido.agregarEscuchaUsuarioRegistrado(new EscuchaUsuarioRegistrado());
		ventanaBienvenido.setVisible(true);
	}
	
	private void inicializarVentanaUsuarioNuevo() {
		ventanaUsuarioNuevo = new VentanaUsuarioNuevo();
		ventanaUsuarioNuevo.agregarEscuchaGuardar(new EscuchaAceptar());
		ventanaUsuarioNuevo.agregarEscuchaVolver(new EscuchaVolver());
		ventanaUsuarioNuevo.setVisible(false);
	}
	
	private void inicializarVentanaComenzarPartida(){
		ventanaComenzarPartida = new VentanaComenzarPartida("Jorge");
		ventanaComenzarPartida.agregarEscucharComenzarPartida(new EscuchaComenzarPartida());
		ventanaComenzarPartida.agregarEscucharRetomarPartida(new EscuchaRetomarPartida());
		ventanaComenzarPartida.agregarEscucharVerPuntajes(new EscuchaVerPuntaje());
		ventanaComenzarPartida.agregarEscucharSalir(new EscuchaSalir());
		ventanaComenzarPartida.setVisible(false);	
	}
	
	public class EscuchaNuevoUsuario implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			ventanaBienvenido.setVisible(false);
			ventanaUsuarioNuevo.setVisible(true);
		}
	}
	
	public class EscuchaUsuarioRegistrado implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
		}
	}
	
	public class EscuchaVolver implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			ventanaBienvenido.setVisible(true);
			ventanaUsuarioNuevo.setVisible(false);
		}
	}
	
	public class EscuchaAceptar implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e){
			ventanaComenzarPartida.setVisible(true);
			ventanaUsuarioNuevo.setVisible(false);
			ventanaBienvenido.setVisible(false);
		}
	}
	
	public class EscuchaComenzarPartida implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e){
			// TODO Auto-generated method stub
		}
	}
	
	public class EscuchaRetomarPartida implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e){
			// TODO Auto-generated method stub
		}
	}
	
	public class EscuchaVerPuntaje implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e){
			// TODO Auto-generated method stub
		}
	}
	
	public class EscuchaSalir implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e){
			// TODO Auto-generated method stub
		}
	}
	
}
