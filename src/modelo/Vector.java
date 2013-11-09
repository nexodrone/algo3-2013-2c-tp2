package modelo;

public class Vector {
    private int dirX; // representa la longitud en X del vector
    private int dirY; // representa la longitud en Y del vector

    public Vector(int direccionX, int direccionY) {
        dirX = direccionX;
        dirY = direccionY;
    }

    public void setX(int direccionX) {
        dirX = direccionX;
    }

    public void setY(int direccionY) {
        dirY = direccionY;
    }

    public int X() {
        return dirX;
    }

    public int Y() {
        return dirY;
    }
}
