package modeloTests;

import static org.junit.Assert.*;
import modelo.Partida;
import modelo.Jugador;
import org.junit.Test;

public class PartidaTest {
	
	@Test
	public void testNuevaPartidaNoDeberiaSerNull(){
		Partida unaPartida = new Partida("Pirulo");
		assertNotNull(unaPartida);		
	}
	
	@Test
	public void testPartidaNuevaDeberiaCrearseConCeroCantidadDeMovimientos(){
		Partida unaPartida = new Partida("Pitulo");
		assertEquals(unaPartida.getCantidadDeMovimientosTotales(),0);
	}
	
	@Test
	public void testJugadorQueSumaMovimientosDeberianSumarseEnSuPartida(){
		Partida unaPartida = new Partida("Pirulo");
		Jugador unJugador = unaPartida.getJugador();
		unJugador.sumarMovimientos(5);
		unJugador.sumarMovimientos(3);
		unaPartida.actualizarMovimientosTotales();
		assertEquals(unaPartida.getCantidadDeMovimientosTotales(),8);		
	}
	

}
