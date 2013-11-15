package modelo;


import modelo.excepciones.MovimientoInvalidoExcepcion;
import modelo.excepciones.PasajeBloqueadoPorPiqueteExcepcion;

public class Juego {

    private Tablero tablero;
    private Vehiculo vehiculo;
    private Posicion posicionGanadora;

    public Juego(Tablero tablero, Vehiculo vehiculo, Posicion posicionGanadora) {
        this.tablero = tablero;
        this.vehiculo = vehiculo;
        this.posicionGanadora = posicionGanadora;
    }

    public void setPosicionGanadora(Posicion posicionGanadora) {
        this.posicionGanadora = posicionGanadora;
    }

    public Vehiculo getVehiculo() {
        return this.vehiculo;
    }


    public void cambiarVehiculo(Vehiculo nuevoVehiculo) {
        System.out.print("cambio de vehiculo");
        vehiculo = nuevoVehiculo;
    }
    
    public void realizarJugadaEnDireccion(Direccion direccion) throws PasajeBloqueadoPorPiqueteExcepcion, MovimientoInvalidoExcepcion {
        Posicion nuevaPosicion = vehiculo.calcularSiguientePosicion(direccion);
        if (tablero.posicionValida(nuevaPosicion)){
        	Bocacalle bocacalleActual = tablero.getBocacalleEnPosicion(vehiculo.getPosicion());
        	Calle calleATransitar = bocacalleActual.obtenerCalleEnDireccion(direccion);
        	try {
                  vehiculo.moverEnDireccion(direccion, calleATransitar);
                  if(vehiculo.getPosicion().equals(posicionGanadora))
                	  System.out.print("Jugador gano el nivel");
        	} catch (PasajeBloqueadoPorPiqueteExcepcion e) {
                  	System.out.print("Imposible mover en esa direccion.");
             }  	
        } else throw new MovimientoInvalidoExcepcion(); 
    }

}