package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Juego;
import vista.PanelMenuPrincipal;
import vista.Ventana;

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
		this.panelMenuPrincipal.agregarEscucharComenzarPartida(new EscuchaComenzarPartida());
		ventana.add(panelMenuPrincipal);
	}

	public class EscuchaComenzarPartida implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e){
			String nombreJugador = panelMenuPrincipal.getNombreUsuario();
			ventana.remove(panelMenuPrincipal);
			ControladorComenzarPartida controlador = new ControladorComenzarPartida(juego,ventana,nombreJugador);
		}	
	}
	

}
