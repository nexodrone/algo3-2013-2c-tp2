package modelo;

import java.io.File;
import java.util.*;

import org.simpleframework.xml.*;
import org.simpleframework.xml.core.Persister;

import modelo.Puntaje;
import persistencia.PorPuntaje;


@Root(name = "nombres")
public class Puntajes {
	@ElementList( name = "lista")
	private ArrayList<Puntaje> puntajes;
	
	public Puntajes(){
		puntajes = new ArrayList<Puntaje>();
	}
	
	public void agregarPuntaje(String nombre, Integer puntaje) {
		puntajes.add(new Puntaje(nombre, puntaje));
	}
	
	public ArrayList<Puntaje> getPuntajesOrdenados() {
		Collections.sort( puntajes, new PorPuntaje() );
		return puntajes;
	}
	
	public void guardar(String path) throws Exception {
		Serializer ser = new Persister();
		ser.write(this, new File(path));
	}
	public static Puntajes recuperar (String path) throws Exception {
		Serializer ser = new Persister();
		return ser.read(Puntajes.class, new File(path));
	}	
}
