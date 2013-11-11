package modelo;

public class Movimiento {
    private Vector direccion;

    public Movimiento(Vector vector) {
        this.direccion = vector;
    }

    public int x() {
        return direccion.x();
    }

    public int y() {
        return direccion.y();
    }

    public Vector moverseEnDireccion(Vector vectorDireccion) {
        // La idea es que le pasan la direccion que manda el jugador, y que devuelva un vector con
        // la direccion que se va a mover
        // Pro:El vector es unitario con un solo componente

    }
}
