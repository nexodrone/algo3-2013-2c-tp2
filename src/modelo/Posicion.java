package modelo;

import org.simpleframework.xml.*;

@Root
public class Posicion {
	
	@Element(name = "coordenadas")
	private Vector vector;
	
	public	Posicion (int posX, int posY) {
		this.vector = new Vector(posX,posY);
    }
	
	public Posicion() {}
	
    public int x() {
        return vector.x();
    }

    public int y() {
        return vector.y();
    }

    public boolean equals(Posicion posicion) {
        return this.vector.equals(new Vector(posicion.x(), posicion.y()));
    }

    public Posicion copy() {
        Posicion nuevaPosicion = new Posicion(this.x(), this.y());
        return nuevaPosicion;
    }

    public void incrementarX(int incremento) {
        this.vector.incrementarX(incremento);
    }

    public void incrementarY(int incremento) {
        this.vector.incrementarY(incremento);
    }

    public String asString() {
    	return this.vector.asString();
    }
}
