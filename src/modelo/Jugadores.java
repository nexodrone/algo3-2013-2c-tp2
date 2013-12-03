package modelo;

import java.io.File;
import java.util.*;

import org.simpleframework.xml.*;
import org.simpleframework.xml.core.Persister;

import modelo.Jugador;
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
			if( it.next().getNickName().compareTo(nombre) == 0 )
				return true;
		}
		return false;
	}

	public void agregarJugador(Jugador jugadorNuevo) {
		jugadores.add(jugadorNuevo);
	}
	
	public ArrayList<Jugador> getPuntajesOrdenados() {
		Collections.sort( jugadores, new PorPuntaje2() );
		return jugadores;
	}
	
	public void sumarPuntaje(String nombre, Integer puntaje)
			throws UsuarioInexistenteException
	{
		Jugador jugador = buscar(nombre);
		if( jugador.getNickName() == null )
			throw new UsuarioInexistenteException();
		
		jugador.sumarPuntaje(puntaje);
	}
	
	private Jugador buscar(String nombre) {
		Iterator<Jugador> it = jugadores.iterator();
		Jugador jugadorAux = new Jugador();
		while ( it.hasNext() ){
			jugadorAux = it.next();
			if( jugadorAux.getNickName().compareTo(nombre) == 0 )
				return jugadorAux;
		}
		return jugadorAux;
	}
	
	public void guardar(String path) throws Exception {
		Serializer ser = new Persister();
		ser.write(this, new File(path));
	}
	public static Jugadores recuperar (String path) throws Exception {
		Serializer ser = new Persister();
		return ser.read(Jugadores.class, new File(path));
	}
}
