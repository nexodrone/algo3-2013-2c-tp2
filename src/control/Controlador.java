package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Juego;
import vista.VentanaPrincipal;
import vista.VentanaUsuarioNuevo;

public class Controlador {
	
	private Juego juego;
	private VentanaPrincipal ventanaPrincipal;
	private VentanaUsuarioNuevo ventanaUsuarioNuevo;
	
	public Controlador(Juego juego) {
		this.juego = juego;
		this.inicializarVentanaPrincipal();
		this.inicializarVentanaUsuarioNuevo();
	}
	
	
	private void inicializarVentanaPrincipal() {
		this.ventanaPrincipal = new VentanaPrincipal();
		this.ventanaPrincipal.agregarEscuchaNuevoUsuario(new EscuchaNuevoUsuario());
		this.ventanaPrincipal.agregarEscuchaUsuarioRegistrado(new EscuchaUsuarioRegistrado());
		ventanaPrincipal.setVisible(true);
	}
	
	private void inicializarVentanaUsuarioNuevo() {
		ventanaUsuarioNuevo = new VentanaUsuarioNuevo();
		ventanaUsuarioNuevo.agregarEscuchaVolver(new EscuchaVolver());
		ventanaUsuarioNuevo.setVisible(false);
	}
	
	public class EscuchaNuevoUsuario implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			ventanaPrincipal.setVisible(false);
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
			ventanaPrincipal.setVisible(true);
			ventanaUsuarioNuevo.setVisible(false);
		}
	}
	
}
