package modelo;

import java.io.File;
import java.util.*;

import org.simpleframework.xml.*;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

@Root
public class Jugador {

	@Attribute
    private String nombre;
	@Element
    private int puntaje;

    public Jugador() {}

    public Jugador(String nombre) {
        this.nombre = nombre;
    }

    public Jugador(String nombre, int puntaje) {
        this.nombre = nombre;
        this.puntaje = puntaje;
    }
    
    public String getNickName() {
        return this.nombre;
    }
    
	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}
	
	public void sumarPuntaje(int puntaje) {
		this.puntaje += puntaje;
	}

	public String getNombre(){
		return this.nombre;
	}
	
	public int getPuntaje(){
		return this.puntaje;
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
