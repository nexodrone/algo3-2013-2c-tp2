package modeloTests;

import static org.junit.Assert.*;
import modelo.Partida;

import org.junit.Test;

public class PartidaTest {

	@Test
	public void testDeberiaCrearPartida() {
		Partida unaPartida = new Partida();
		assertNotNull(unaPartida);
	}

	@Test
	public void testDeberiaDevolverMovimientosTotales() {
		Partida unaPartida = new Partida();
		assertEquals(unaPartida.getCantidadaDeMovimientosTotales(),0);
	}
}
