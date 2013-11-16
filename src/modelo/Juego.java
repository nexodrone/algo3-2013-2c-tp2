package modelo;

import modelo.excepciones.MovimientoInvalidoExcepcion;
import modelo.excepciones.PasajeBloqueadoPorPiqueteExcepcion;

public class Juego {

    private Tablero tablero;
    private Vehiculo vehiculo;
    private Posicion posicionGanadora;
    private boolean victoria;

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
        // System.out.print("cambio de vehiculo");
        vehiculo = nuevoVehiculo;
    }

    public void realizarJugadaEnDireccion(Direccion direccion) throws PasajeBloqueadoPorPiqueteExcepcion, MovimientoInvalidoExcepcion {
        if (this.verificarEstadoDeVictoria() == true) {
            // cortar el el funcion
        }
        boolean posicionEsValida = false;
        boolean posicionGanadora = verificarEsPosicionGanadoraEnDireccion(direccion);
        if (!posicionGanadora) {
            Posicion nuevaPosicion = vehiculo.calcularSiguientePosicion(direccion);
            posicionEsValida = verificarPosicionEnTablero(nuevaPosicion);
        } else
            posicionEsValida = true;
        if (posicionEsValida) {
            Bocacalle bocacalleActual = tablero.getBocacalleEnPosicion(vehiculo.getPosicion());
            Calle calleATransitar = bocacalleActual.getCalleEnDireccion(direccion);
            try {
                vehiculo.moverEnDireccion(direccion, calleATransitar);
                if (vehiculo.getPosicion().equals(posicionGanadora)) {
                    System.out.print("Jugador gano el nivel");
                    victoria = true;
                }
            } catch (PasajeBloqueadoPorPiqueteExcepcion e) {
                System.out.print("Imposible mover en esa direccion.");
            }
        } else
            throw new MovimientoInvalidoExcepcion();
    }

    public boolean verificarEsPosicionGanadoraEnDireccion(Direccion direccion) {
        boolean valor;
        Posicion nuevaPosicion = vehiculo.calcularSiguientePosicion(direccion);
        valor = nuevaPosicion.equals(posicionGanadora);
        return valor;

    }

    public boolean verificarPosicionEnTablero(Posicion posicion) {
        return this.tablero.posicionValida(posicion);
    }

    public boolean verificarEstadoDeVictoria() {
        return (victoria == true);
    }
}