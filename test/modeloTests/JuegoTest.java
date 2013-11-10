package modeloTests;

import static org.junit.Assert.*;
import modelo.Juego;
import org.junit.Test;

public class JuegoTest {

	@Test
	public void testJuegoDebePoderCrearPartida() {
		Juego unJuego = new Juego();
		unJuego.crearPartidaConJugador("Pepe");
		assertNotNull(unJuego);
	}
	
}
