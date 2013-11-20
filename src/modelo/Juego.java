package modelo;

import java.io.File;
import java.util.ArrayList;

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
	
	private Puntajes puntajes;
	
    public Juego(Tablero tablero, Vehiculo vehiculo, Posicion posicionGanadora) {
        this.tablero = tablero;
        this.vehiculo = vehiculo;
        this.posicionGanadora = posicionGanadora;
        this.juegoGanado = false;
        this.puntajes = new Puntajes ();
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