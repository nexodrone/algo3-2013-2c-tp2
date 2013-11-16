package modelo;

public class Vector {
    private int x, y;

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

    public boolean equals(Vector vector) {
        boolean igualX = ((this.x()) == (vector.x()));
        boolean igualY = ((this.y()) == (vector.y()));
        return (igualX && igualY);
    }

    public void incrementarX(int incremento) {
        x = x + incremento;
    }

    public void incrementarY(int incremento) {
        y = y + incremento;
    }

    public String asString() {
        String stringY, stringX;
        stringX = String.valueOf(this.x);
        stringY = String.valueOf(this.y);
        return stringX + "," + stringY;
    }

}
