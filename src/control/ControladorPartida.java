package control;

import modelo.Juego;
import modelo.Jugador;
import modelo.Partida;
import modelo.Posicion;
import modelo.Tablero;
import modelo.VehiculoMoto;
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
		ventana.add(panelPartida);
	}
	
/*	public static void main(String args[]) {
		
		Juego juego = new Juego();
		juego.setJugador(new Jugador("Pepe"));
		Tablero tablero = new Tablero(20,5);
		VehiculoMoto moto = new VehiculoMoto(new Posicion(0,0));
		moto.setJuegoActual(juego);
		Partida partida = new Partida(tablero, moto, new Posicion (6,6), 50);
		juego.setPartida(partida);
		
		Ventana ventana = new Ventana();
		ControladorPartida control = new ControladorPartida(juego, ventana, "Dificil", "Auto");
	}*/

}
