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

    public void moverEnDireccionNorte(int cantidad){
    	direccion.setY(-cantidad);
    	direccion.setX(0);
    }
    
    // public Vector moverseEnDireccion(Vector vectorDireccion) {
    // }
}
