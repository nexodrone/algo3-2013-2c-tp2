package modelo;

public class Vector {
    private int x, y;

    public Vector(Vector vector) {
        this.asignar(vector);
    }

    public Vector(int enX, int enY) {
        x = enX;
        y = enY;
    }

    public int x() {
        return x;
    }

    public int y() {
        return y;
    }

    public void setX(int a) {
        x = a;
    }

    public void setY(int a) {
        y = a;
    }

    public boolean equals(Vector vector) {
        boolean igualX = ((this.x()) == (vector.x()));
        boolean igualY = ((this.y()) == (vector.y()));
        return (igualX && igualY);
    }

    public void asignar(Vector vector) {
        x = vector.x();
        y = vector.y();
    }

    public Vector copy() {
        Vector nuevoVector = new Vector(x, y);
        return nuevoVector;
    }

    public void incrementarX(int incremento) {
        x = x + incremento;
    }

    public void incrementarY(int incremento) {
        y = y + incremento;
    }

    public Vector sumar(Vector vector) {
        return new Vector(vector.x() + x, vector.y() + y);
    }

    public Vector porEscalar(int escalar) {
        return new Vector(x * escalar, y * escalar);
    }

    public String asString() {
        String stringY, stringX;
        stringX = String.valueOf(this.x);
        stringY = String.valueOf(this.y);
        return stringX + "," + stringY;
    }

}
