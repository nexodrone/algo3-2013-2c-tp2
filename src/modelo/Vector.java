package modelo;

import org.simpleframework.xml.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

@Root
public class Vector {
	
	@Attribute(name = "X")
    private int x;
	@Attribute(name = "Y")
	private int y;

    public Vector(@Attribute(name = "X") int enX,
    			  @Attribute(name = "Y") int enY)
    {
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

    /* ese metodo era creado para comprobar mas facilmente las posiciones de vehiculos */
    public String asString() {
        String stringY, stringX;
        stringX = String.valueOf(this.x);
        stringY = String.valueOf(this.y);
        return stringX + "," + stringY;
    }
    
    public void guardar(String path) throws Exception {
    	Serializer serializador = new Persister();
    	OutputStream resultado = new FileOutputStream(path);
    	serializador.write(this, resultado);
    }

    public static Vector recuperar(String path) throws Exception {
    	Serializer deserializador = new Persister();
    	InputStream src = new FileInputStream(path);
    	return deserializador.read(Vector.class, src);
    }
}
