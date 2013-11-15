package modelo;

public class Direccion {

	private Vector vector;
	
	public	Direccion (int dirX, int dirY) {
		this.vector = new Vector(dirX,dirY);
    }

    public int x() {
        return vector.x();
    }

    public int y() {
        return vector.y();
    }

}
