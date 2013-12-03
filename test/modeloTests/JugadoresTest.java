package modeloTests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import modelo.Jugador;
import modelo.Jugadores;

import org.junit.Test;

public class JugadoresTest {
	
	@Test
	public void testAgregarPuntajesYObtenerlosOrdenadosCorrectamente() {
		Jugadores jugadores = new Jugadores();
		jugadores.agregarJugador(new Jugador("Charito", 22));
		jugadores.agregarJugador(new Jugador("Cirito", 48));
		jugadores.agregarJugador(new Jugador("Checho", 5));
		jugadores.agregarJugador(new Jugador("Carolito", 125));
		
		ArrayList<Jugador> otrosJugadores = jugadores.getPuntajesOrdenados();
		
		assertEquals(otrosJugadores.get(0).getPuntaje(), 125);
		assertEquals(otrosJugadores.get(1).getPuntaje(), 48);
		assertEquals(otrosJugadores.get(2).getPuntaje(), 22);
		assertEquals(otrosJugadores.get(3).getPuntaje(), 5);		
	}
	
	@Test
	public void testGuardarPuntajeCorrectamente() throws Exception {
		Jugadores jugadores = new Jugadores();
		
		jugadores.agregarJugador(new Jugador("Carloncho", 30));
		jugadores.agregarJugador(new Jugador("Roberto", 40));
		
		jugadores.guardar("test/jugadoresTest.xml");
		
		Jugadores otrosJugadores= Jugadores.recuperar("test/jugadoresTest.xml");
		
		ArrayList<Jugador> ordenados = otrosJugadores.getPuntajesOrdenados();
		assertEquals(ordenados.get(0).getPuntaje(), 40);
		assertEquals(ordenados.get(0).getNombre(), "Roberto");
				
		assertEquals(ordenados.get(1).getPuntaje(), 30);
		assertEquals(ordenados.get(1).getNombre(), "Carloncho");
	}
	
}
