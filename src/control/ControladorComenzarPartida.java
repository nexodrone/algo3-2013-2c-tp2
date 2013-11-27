package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Juego;
import vista.PanelComenzarPartida;
import vista.Ventana;

public class ControladorComenzarPartida extends Controlador{
	
	private PanelComenzarPartida panelComenzarPartida;
	private String nombre;
	
	public ControladorComenzarPartida(Juego juego, Ventana ventana,String nombreJugador){
		this.juego = juego;
		this.ventana = ventana;
		this.nombre = nombreJugador;
		this.agregarPanelLocal();
		this.ventana.setVisible(true);
	
	}

	private void agregarPanelLocal() {
		this.panelComenzarPartida = new PanelComenzarPartida();
		this.panelComenzarPartida.agregarEscuchaVolver(new EscuchaVolver());
		ventana.add(panelComenzarPartida);
	}

	public class EscuchaVolver implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			ventana.remove(panelComenzarPartida);
			ControladorMenuPrincipal contolador = new ControladorMenuPrincipal(juego, ventana,nombre);
		}
	}
	
	
}
