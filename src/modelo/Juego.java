package modelo;

import java.io.File;
import java.util.List;

import modelo.excepciones.MovimientoInvalidoExcepcion;
import modelo.excepciones.PasajeBloqueadoPorPiqueteExcepcion;

import org.simpleframework.xml.*;
import org.simpleframework.xml.core.Persister;

@Root(name = "JUEGO")
public class Juego {

	@Element(name = "Tablero")
    private Tablero tablero;
	@Element(name = "VehiculoJugador")
    private Vehiculo vehiculo;
	@Element(name = "PosicionGanadora")
    private Posicion posicionGanadora;
	@Attribute
    private boolean juegoGanado;
	//@ElementList
	//private List<Jugador> jugadores;// guardara los jugadores y sus puntajes

    public Juego(Tablero tablero, Vehiculo vehiculo, Posicion posicionGanadora) {
        this.tablero = tablero;
        this.vehiculo = vehiculo;
        this.posicionGanadora = posicionGanadora;
        this.juegoGanado = false;
    }

    public Juego() {};
    
    public void setPosicionGanadora(Posicion posicionGanadora) {
        this.posicionGanadora = posicionGanadora;
    }

    public Vehiculo getVehiculo() {
        return this.vehiculo;
    }
    
    public Posicion getPosicionGanadora() {
        return this.posicionGanadora;
    }

    public void cambiarVehiculo(Vehiculo nuevoVehiculo) {
        // System.out.print("cambio de vehiculo");
        vehiculo = nuevoVehiculo;
    }

    public void realizarJugadaEnDireccion(Direccion direccion) throws PasajeBloqueadoPorPiqueteExcepcion, MovimientoInvalidoExcepcion {
    	if (!juegoGanado) {
    		
    		Posicion nuevaPosicion = vehiculo.calcularSiguientePosicion(direccion);
    		boolean posicionEsValida = nuevaPosicion.equals(posicionGanadora);
    		if (!posicionEsValida) 
    			posicionEsValida = this.tablero.posicionValida(nuevaPosicion);
    		if (posicionEsValida) {
    			Bocacalle bocacalleActual = tablero.getBocacalleEnPosicion(vehiculo.getPosicion());
    			Calle calleATransitar = bocacalleActual.getCalleEnDireccion(direccion);
    			try {	vehiculo.moverEnDireccion(direccion, calleATransitar);
    					if (vehiculo.getPosicion().equals(posicionGanadora)){	
    						System.out.print("Jugador gano el nivel \n");
            				this.juegoGanado = true;
            				}
    			} catch (PasajeBloqueadoPorPiqueteExcepcion e) {
    					System.out.print("Imposible mover en esa direccion. \n");
    					}
    		}else throw new MovimientoInvalidoExcepcion();

    	}else System.out.print("Juego ganado ya!\n");
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