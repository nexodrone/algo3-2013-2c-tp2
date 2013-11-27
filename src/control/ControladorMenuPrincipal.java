package control;

import modelo.Juego;
import vista.PanelBienvenido;
import vista.PanelMenuPrincipal;
import vista.Ventana;
import control.ControladorBienvenido.EscuchaNuevoUsuario;

public class ControladorMenuPrincipal extends Controlador {
	
	private PanelMenuPrincipal panelMenuPrincipal;
	
	public ControladorMenuPrincipal(Juego juego, Ventana ventana, String nombre) {
		this.juego = juego;
		this.ventana = ventana;
		this.agregarPanelLocal(nombre);
		this.ventana.setVisible(true);
	}

	private void agregarPanelLocal(String nombre) {
		this.panelMenuPrincipal = new PanelMenuPrincipal(nombre);
		ventana.add(panelMenuPrincipal);
	}
}
