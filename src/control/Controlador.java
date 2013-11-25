package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Juego;
import vista.VentanaBienvenido;
import vista.VentanaUsuarioNuevo;

public class Controlador {
	
	private Juego juego;
	private VentanaBienvenido ventanaBienvenido;
	private VentanaUsuarioNuevo ventanaUsuarioNuevo;
	
	public Controlador(Juego juego) {
		this.juego = juego;
		this.inicializarVentanaPrincipal();
		this.inicializarVentanaUsuarioNuevo();
	}
	
	
	private void inicializarVentanaPrincipal() {
		this.ventanaBienvenido = new VentanaBienvenido();
		this.ventanaBienvenido.agregarEscuchaNuevoUsuario(new EscuchaNuevoUsuario());
		this.ventanaBienvenido.agregarEscuchaUsuarioRegistrado(new EscuchaUsuarioRegistrado());
		ventanaBienvenido.setVisible(true);
	}
	
	private void inicializarVentanaUsuarioNuevo() {
		ventanaUsuarioNuevo = new VentanaUsuarioNuevo();
		ventanaUsuarioNuevo.agregarEscuchaVolver(new EscuchaVolver());
		ventanaUsuarioNuevo.setVisible(false);
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
	
}
