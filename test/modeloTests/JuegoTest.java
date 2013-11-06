package modeloTests;

import static org.junit.Assert.*;
import modelo.Juego;
import org.junit.Test;

public class JuegoTest {

	@Test
	public void testDeberiaCrearJuego() {
		Juego unJuego = new Juego(10,10,'M');
		assertNotNull(unJuego);
	}
	
	@Test
	public void testDeberiaPonerVehiculoEnPosicionInicial() {
		Juego unJuego = new Juego(10,10,'A');
		assertEquals(unJuego.posicionDelVehiculo(),"0,0");
		assertEquals(unJuego.movimientos(),0);
	}

	@Test
	public void testDeberiaMverElVehiculoEnDireccionIndicada() {
		Juego unJuego = new Juego(10,10,'A');
		unJuego.realizarJugadaEnDireccion('S');
		unJuego.realizarJugadaEnDireccion('S');
		unJuego.realizarJugadaEnDireccion('E');
		assertEquals(unJuego.posicionDelVehiculo(),"2,1");
		assertEquals(unJuego.movimientos(),3);
	}
}
