package modelo;

public class Observador {
    Juego juego;

    public Observador(Juego unJuego) {
        juego = unJuego;
    }

    public Observador() {

    }

    public void cambiarVehiculo(Vehiculo nuevoVehiculo) {
        juego.setVehiculo(nuevoVehiculo);

    }

    public void setJuego(Juego unJuego) {
        juego = unJuego;
    }
}
