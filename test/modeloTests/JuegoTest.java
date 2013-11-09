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
	public void testDeberiaMoverElVehiculoEnDireccionIndicada() {
		Juego unJuego = new Juego(10,10,'A');
		unJuego.realizarJugadaEnDireccion('S');
		unJuego.realizarJugadaEnDireccion('S');
		unJuego.realizarJugadaEnDireccion('E');
		assertEquals(unJuego.posicionDelVehiculo(),"2,1");
		assertEquals(unJuego.movimientos(),3);
	}
	
	@Test
	public void testRealizarJugadaEnTodasDireccionesPosibles() {
		Juego unJuego = new Juego(5,5,'M');
		unJuego.realizarJugadaEnDireccion('S');
		unJuego.realizarJugadaEnDireccion('S');
		unJuego.realizarJugadaEnDireccion('E');
		unJuego.realizarJugadaEnDireccion('E');
		unJuego.realizarJugadaEnDireccion('N');
		unJuego.realizarJugadaEnDireccion('O');
		assertEquals(unJuego.movimientos(),6);
		assertEquals(unJuego.posicionDelVehiculo(),"1,1");
	}
	
	@Test
	public void testDeberiaMoversePorLimites() {
		Juego unJuego = new Juego(5,5,'M');
		unJuego.realizarJugadaEnDireccion('E');
		unJuego.realizarJugadaEnDireccion('E');
		unJuego.realizarJugadaEnDireccion('E');
		unJuego.realizarJugadaEnDireccion('E');
		unJuego.realizarJugadaEnDireccion('S');
		unJuego.realizarJugadaEnDireccion('S');
		unJuego.realizarJugadaEnDireccion('S');
		unJuego.realizarJugadaEnDireccion('S');
		assertEquals(unJuego.posicionDelVehiculo(),"4,4");
	}
	
	/*@Test
	public void testDireccionInvalidaDeberiaIndicarCuandoLaDireccionIndicadaEsInvalida(){
		Juego unJuego = new Juego(5,5,'M');
		boolean direccionInvalida = true;
		assertEquals(unJuego.direccionInvalida('N'),direccionInvalida);		
	}*/
}
