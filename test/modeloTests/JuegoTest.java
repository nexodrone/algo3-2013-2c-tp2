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
	public void testDeberiaPoderCalcularseLaSiguientePosicionAlMover(){
		Juego unJuego = new Juego(5,5,'A');
		assertEquals(unJuego.calcularSiguientePosicion('S').asString(),"1,0");
		
	}
	
	@Test
	public void testDeberiaMoverElVehiculoEnDireccionIndicada() {
		Juego unJuego = new Juego(10,10,'A');
		unJuego.realizarJugadaEnDireccion('S');
		unJuego.realizarJugadaEnDireccion('S');
		unJuego.realizarJugadaEnDireccion('E');
		assertEquals(unJuego.posicionDelVehiculo(),"2,1");
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
		assertEquals(unJuego.posicionDelVehiculo(),"1,1");
	}
	

	@Test
	public void testDeberiaIndicarseSiSeQuiereJugarEnPosicionInvalida(){
		Juego unJuego = new Juego(10,10,'A');
		assertFalse(unJuego.jugadaValida('N'));
		
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
	
}
