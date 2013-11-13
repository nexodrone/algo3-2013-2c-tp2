package modelo;

import modelo.excepciones.MovimientoInvalidoExcepcion;

public class Jugador {

    private String nickName;
    private Vehiculo vehiculo;
    private int cantidadDeMovimientos;
    //private Juego juegoActual;

    public Jugador(String nombre, Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
        nickName = nombre;
        cantidadDeMovimientos = 0;
    }

    public String getNickName() {
        return this.nickName;
    }

    public Vehiculo getVehiculo() {
        return this.vehiculo;
    }

    public int getCantidadDeMovimientos() {
        return this.cantidadDeMovimientos;
    }

   
    public void realizarJugadaEnDireccion(Vector direccion) throws MovimientoInvalidoExcepcion {
    	//juegoActual.moverEncireccion(direccion);
     	cantidadDeMovimientos += this.vehiculo.moverEnDireccion(direccion);
    }

}
