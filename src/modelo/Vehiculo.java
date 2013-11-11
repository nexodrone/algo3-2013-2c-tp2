package modelo;

import modelo.excepciones.MovimientoInvalidoExcepcion;

public class Vehiculo {

    private Posicion posicion;
    private Tablero tablero;

    public Vehiculo(Tablero tablero, Posicion posicion) {
        this.posicion = posicion;
        this.tablero = tablero;
    }

    public Posicion getPosicion() {
        return this.posicion;
    }

    public int moverEnDireccion(Vector direccion) throws MovimientoInvalidoExcepcion {
        if (jugadaValida(direccion)) {
            Posicion nuevaPosicion = calcularSiguientePosicion(direccion);
            Bocacalle bocacalleActual = this.tablero.getBocacalleEnPosicion(posicion);
            procesarCalle(bocacalleActual.obtenerCalleEnDireccion(direccion));
            posicion = nuevaPosicion;
            return 1;

        } else {
            throw new MovimientoInvalidoExcepcion();
        }
    }

    private boolean jugadaValida(Vector direccion) {
        Posicion nuevaPosicion = this.calcularSiguientePosicion(direccion);
        return tablero.posicionValida(nuevaPosicion);
        // -----tablero tiene que validar que la posicion sea valida o no, no el vehiculo
    }

    private Posicion calcularSiguientePosicion(Vector direccion) {
        Posicion nuevaPosicion = posicion.copy();
        nuevaPosicion.sumarFila(direccion.y());
        nuevaPosicion.sumarColumna(direccion.x());
        return nuevaPosicion;
    }

    private void procesarCalle(Calle calle) {

    }

}
