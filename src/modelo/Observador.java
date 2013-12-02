package modelo;

public class Observador {
    private static Observador INSTANCE = null;
    private Juego juego;

    // Private constructor suppresses
    private Observador() {
        juego = Juego.getInstance();
    }

    private synchronized static void createInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Observador();
        }
    }

    public static Observador getInstance() {
        createInstance();
        return INSTANCE;
    }

    public void cambiarVehiculo(Vehiculo nuevoVehiculo) {
        juego.setVehiculo(nuevoVehiculo);

    }

}
