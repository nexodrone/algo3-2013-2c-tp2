package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.ConstructorDePartida;
import modelo.Juego;
import modelo.Jugador;
import modelo.Nivel;
import modelo.Partida;
import modelo.Posicion;
import modelo.Tablero;
import modelo.Vehiculo;
import modelo.Vehiculo4x4;
import modelo.VehiculoAuto;
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
		this.panelComenzarPartida.agregarEscuchaAceptar(new EscuchaComenzarPartida());
		ventana.add(panelComenzarPartida);
	}

	public class EscuchaVolver implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			ventana.remove(panelComenzarPartida);
			ControladorMenuPrincipal contolador = new ControladorMenuPrincipal(juego, ventana);
		}
	}
	
	public class EscuchaComenzarPartida implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e){
			juego.setJugador(new Jugador(nombre));
			String nivelSeleccionado = panelComenzarPartida.obtenerNivelSeleccionado();
			String vehiculoSeleccionado = panelComenzarPartida.obtenerVehiculoSeleccionado();
			Nivel nivel = obtenerNivelSeleccionado(nivelSeleccionado);
			Partida partida = construirPartidaSeleccionada(vehiculoSeleccionado,nivel);
			partida.getVehiculo().setJuegoActual(juego);
			juego.setPartida(partida);			
		
			ventana.remove(panelComenzarPartida);
			ControladorPartida controlador = new ControladorPartida(juego,ventana,nivelSeleccionado,vehiculoSeleccionado);
		}
	}

	
	public Nivel obtenerNivelSeleccionado(String nivelSeleccionado){
		//deberia crear el nivel según los parametros del .xml
		return new Nivel();
	}
	
	public Partida construirPartidaSeleccionada(String vehiculoSeleccionado,Nivel nivel){
		if( vehiculoSeleccionado == "Moto"){
			ConstructorDePartida constructorMoto = new ConstructorDePartida();
			return constructorMoto.construirPartidaConMoto(nivel);
		}else if (vehiculoSeleccionado == "Auto"){
			ConstructorDePartida constructorAuto = new ConstructorDePartida();
			return constructorAuto.construirPartidaConAuto(nivel);
		}else{
			ConstructorDePartida constructor4x4 = new ConstructorDePartida();
			return constructor4x4.construirPartidaCon4x4(nivel);
		}	
	}
	

}
