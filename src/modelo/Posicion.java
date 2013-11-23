package modelo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.simpleframework.xml.*;
import org.simpleframework.xml.core.Persister;

@Root
public class Posicion {
	
	@Element(name = "vectorPosicion")
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
    
//    public void guardar(String path) throws Exception {
//    	Serializer serializador = new Persister();
//    	OutputStream resultado = new FileOutputStream(path);
//    	serializador.write(this, resultado);
//    }
//
//    public static Posicion recuperar(String path) throws Exception {
//    	Serializer deserializador = new Persister();
//    	InputStream src = new FileInputStream(path);
//    	Posicion r = deserializador.read(new Posicion(1,0), src);
//    	return r;
//    }
}
