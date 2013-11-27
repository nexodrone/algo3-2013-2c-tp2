package control;

import modelo.Juego;
import vista.PanelComenzarPartida;
import vista.Ventana;

public class ControladorComenzarPartida extends Controlador{
	
	private PanelComenzarPartida panelComenzarPartida;
	
	public ControladorComenzarPartida(Juego juego, Ventana ventana){
		this.juego = juego;
		this.ventana = ventana;
		this.agregarPanelLocal();
		this.ventana.setVisible(true);	
	}

	private void agregarPanelLocal() {
		this.panelComenzarPartida = new PanelComenzarPartida();
		ventana.add(panelComenzarPartida);
	}

}
