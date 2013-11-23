package modelo;

import java.io.File;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

public class Jugador {

    private String nombre;

    public Jugador() {}

    public Jugador(String nombre) {
        this.nombre = nombre;
    }

    public String getNickName() {
        return this.nombre;
    }

    public void guardar(String path) throws Exception {
    	Serializer serializador = new Persister();
    	File resultado = new File(path);
    	serializador.write(this, resultado);
    }
    
    public static Jugador recuperar(String path) throws Exception{
    	Serializer deserializador = new Persister();
    	File src = new File(path);
    	return deserializador.read(Jugador.class, src);
    }

}
