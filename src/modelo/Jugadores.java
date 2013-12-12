package modelo;

import java.io.File;
import java.util.*;

import org.simpleframework.xml.*;
import org.simpleframework.xml.core.Persister;

import modelo.Jugador;
import modelo.excepciones.NoHayUsuariosCreadosException;
import modelo.excepciones.UsuarioExistenteException;
import modelo.excepciones.UsuarioInexistenteException;

	@Root( name = "ListaDeJugadores")
	public class Jugadores {
	@ElementList(name = "jugadores")
	private ArrayList<Jugador> jugadores;
	
	public Jugadores() {
		jugadores = new ArrayList<Jugador>();
	}
	
	public void crearUsuario(String nombre) throws UsuarioExistenteException {
		if ( existe(nombre) ) 
			throw new UsuarioExistenteException();
		jugadores.add(new Jugador(nombre, 0));
	}
	
	private boolean existe(String nombre) {
		Iterator<Jugador> it = jugadores.iterator();
		while ( it.hasNext() ){
			if( it.next().getNombre().compareTo(nombre) == 0 )
				return true;
		}
		return false;
	}

	public void agregarJugador(Jugador jugadorNuevo) {
		jugadores.add(jugadorNuevo);
	}
	
	public ArrayList<Jugador> getPuntajesOrdenados() {
		Collections.sort( jugadores, new ComparadorPorPuntaje() );
		return jugadores;
	}
	
	public void sumarPuntaje(String nombre, Integer puntaje)
			throws UsuarioInexistenteException
	{
		Jugador jugador = buscar(nombre);
		if( jugador.getNombre() == null )
			throw new UsuarioInexistenteException();
		
		jugador.sumarPuntaje(puntaje);
	}
	
	private Jugador buscar(String nombre) {
		Iterator<Jugador> it = jugadores.iterator();
		Jugador jugadorAux = new Jugador();
		while ( it.hasNext() ){
			jugadorAux = it.next();
			if( jugadorAux.getNombre().compareTo(nombre) == 0 )
				return jugadorAux;
		}
		return new Jugador();
	}
	
	public void guardar(String path) throws Exception {
		Serializer ser = new Persister();
		ser.write(this, new File(path));
	}
	
	public static Jugadores recuperar (String path) throws NoHayUsuariosCreadosException {
		Serializer ser = new Persister();
		try{
			return ser.read(Jugadores.class, new File(path));
		}catch(Exception e){
			throw new NoHayUsuariosCreadosException();
		}
	}
	
	private class ComparadorPorPuntaje implements Comparator<Jugador>{
		
		public int compare(Jugador e1, Jugador e2) {
			return e2.getPuntaje() - e1.getPuntaje();
		}
	}
	
	
}
