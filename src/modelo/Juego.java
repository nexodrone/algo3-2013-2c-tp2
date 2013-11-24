package modelo;

import java.io.File;
import java.util.ArrayList;

import modelo.excepciones.MovimientoInvalidoExcepcion;
import modelo.excepciones.PasajeBloqueadoPorPiqueteExcepcion;

import org.simpleframework.xml.*;
import org.simpleframework.xml.core.Persister;

public class Juego {

	private Partida partidaActual;
	private Jugador jugadorActual;
	private Puntajes puntajes;

    public Juego() {};

    public void setJugador(Jugador jugador) {
    	this.jugadorActual = jugador;
    }
	
    public void setPartida(Partida partida) {
    	this.partidaActual = partida;
    }

    public Partida getPartida() {
    	return this.partidaActual;
    }
    
    public void cambiarVehiculo(Vehiculo nuevoVehiculo) {
        // System.out.print("cambio de vehiculo");
        partidaActual.setVehiculo(nuevoVehiculo);
    }
    
    public void verificarEstadoDelJugador() {
    	if (partidaActual.esGanada())
    		System.out.print("Jugador gano el nivel. \n");
    	if (partidaActual.esPerdida())
    		System.out.print("Jugador pierde el nivel. \n");
    	}

    public void realizarJugadaEnDireccion(Direccion direccion) throws MovimientoInvalidoExcepcion {
    	if (this.partidaActual.esGanada() || this.partidaActual.esPerdida())
    				System.out.print("Se termino la partida. \n");
    	else jugarEnDireccion(direccion);
    }

    private void jugarEnDireccion(Direccion direccion) throws MovimientoInvalidoExcepcion {
   		Posicion nuevaPosicion = partidaActual.getVehiculo().calcularSiguientePosicion(direccion);
   		if (partidaActual.getTablero().posicionValida(nuevaPosicion)) {
			Bocacalle bocacalleActual = partidaActual.getTablero().getBocacalleEnPosicion(partidaActual.getVehiculo().getPosicion());
			Calle calleATransitar = bocacalleActual.getCalleEnDireccion(direccion);
			try {	partidaActual.getVehiculo().moverEnDireccion(direccion, calleATransitar);
					verificarEstadoDelJugador();
				}	catch (PasajeBloqueadoPorPiqueteExcepcion e) {
							System.out.print("Imposible mover en esa direccion. \n");
						}
		}	else throw new MovimientoInvalidoExcepcion();
    }
    
    public void guardarPuntaje(String nombre, Integer puntaje) {
    	this.puntajes.agregarPuntaje(nombre, puntaje);
    }
    
    public void guardarPuntajes(String path) throws Exception{
    	puntajes.guardar(path);
    }
    
    public void cargarPuntajes(String path) throws Exception {
    	this.puntajes = Puntajes.recuperar(path);
    }
    
    public ArrayList<Puntaje> getPuntajesOrdenados() throws Exception{
    	return puntajes.getPuntajesOrdenados();
    }
    
    public void guardar(String path) throws Exception {
    	Serializer serializador = new Persister();
    	File resultado = new File(path);
    	serializador.write(this,  resultado);
    }
    
    public static Juego recuperar(String path) throws Exception {
    	Serializer deserializador = new Persister();
    	File src = new File(path);
    	return deserializador.read(Juego.class, src);
    }

}