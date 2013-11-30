package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Juego;
import vista.PanelPartida;
import vista.Ventana;

public class ControladorPartida extends Controlador {
	
	private PanelPartida panelPartida;
	
	public ControladorPartida(Juego juego, Ventana ventana, String dificultad, String vehiculo) {
		this.juego = juego;
		this.ventana = ventana;
		this.agregarPanelLocal(juego.getJugadorActual().getNickName(), vehiculo, dificultad);
		this.ventana.setVisible(true);
	}
	
	private void agregarPanelLocal(String nombre, String dificultad, String vehiculo) {
		this.panelPartida = new PanelPartida(nombre, vehiculo, dificultad);
		this.panelPartida.inicializarZonaDelJuego(juego.getPartida().getTablero().getCantidadDeColumnas(), juego.getPartida().getTablero().getCantidadDeFilas());
		this.panelPartida.agregarEscuchaGuardar(new EscuchaGuardar());
		ventana.add(panelPartida);
	}
	
	public class EscuchaGuardar implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {	juego.getPartida().guardarPartida("src/jugadores/partida"+nombreJugadorActual+".xml");
					panelPartida.mostrarMensajePartidaGuardada();
				} catch (Exception e1) { panelPartida.mostrarMensajeError(); };
		}
	}
	
}
