package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import control.ControladorBienvenido.EscuchaNuevoUsuario;
import modelo.Juego;
import vista.PanelUsuarioNuevo;
import vista.Ventana;

public class ControladorUsuarioNuevo extends Controlador {
	
	private PanelUsuarioNuevo panelUsuarioNuevo;
	
	public ControladorUsuarioNuevo(Juego juego, Ventana ventana) {
		this.juego = juego;
		this.ventana = ventana;
		this.agregarPanelLocal();
		this.ventana.setVisible(true);
	}
	
	private void agregarPanelLocal() {
		this.panelUsuarioNuevo = new PanelUsuarioNuevo();
		this.panelUsuarioNuevo.agregarEscuchaVolver(new EscuchaVolver());
		this.panelUsuarioNuevo.agregarEscuchaGuardar(new EscuchaGuardar());
		ventana.add(panelUsuarioNuevo);
	}
	
	public class EscuchaVolver implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			ventana.remove(panelUsuarioNuevo);
			ControladorBienvenido contolador = new ControladorBienvenido(juego, ventana);
		}
	}
	
	public class EscuchaGuardar implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			ventana.remove(panelUsuarioNuevo);
			ControladorMenuPrincipal contolador = new ControladorMenuPrincipal(juego, ventana, panelUsuarioNuevo.getNombreDelCampo());
		}			 
	}
	
}
