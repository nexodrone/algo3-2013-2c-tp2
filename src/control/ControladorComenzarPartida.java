package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Juego;
import modelo.Jugador;
import modelo.Partida;
import modelo.Posicion;
import modelo.Tablero;
import modelo.VehiculoMoto;
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
		this.panelComenzarPartida.agregarEscucharAceptar(new EscuchaComenzarPartida());
		ventana.add(panelComenzarPartida);
	}

	public class EscuchaVolver implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			ventana.remove(panelComenzarPartida);
			ControladorMenuPrincipal contolador = new ControladorMenuPrincipal(juego, ventana,nombre);
		}
	}
	
	public class EscuchaComenzarPartida implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e){
			Juego juego = new Juego();
			juego.setJugador(new Jugador(nombre));
			String nivelSeleccionado = new String();
			nivelSeleccionado = panelComenzarPartida.obtenerNivelSeleccionado();
			String vehiculoSeleccionado = new String();
			vehiculoSeleccionado = panelComenzarPartida.obtenerVehiculoSeleccionado();
			Tablero tablero = new Tablero(20,5);
			VehiculoMoto moto = new VehiculoMoto(new Posicion(0,0));
			moto.setJuegoActual(juego);
			Partida partida = new Partida(tablero, moto, new Posicion (6,6), 50);
			juego.setPartida(partida);			
		
			ventana.remove(panelComenzarPartida);
			ControladorPartida controlador = new ControladorPartida(juego,ventana,nivelSeleccionado,vehiculoSeleccionado);
		}
	}
	
	
}
