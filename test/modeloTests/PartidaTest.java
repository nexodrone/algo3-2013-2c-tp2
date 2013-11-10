package modeloTests;

import static org.junit.Assert.*;
import modelo.Partida;
import modelo.Jugador;

import org.junit.Test;

public class PartidaTest {
	
	@Test
	public void testNuevaPartidaNoDeberiaSerNull() {
		Partida unaPartida = new Partida("Pirulo",10,10);
		assertNotNull(unaPartida);
	}

	@Test
	public void testPartidaNuevaDeberiaCrearseSinMovimientosRealizados(){
		Partida unaPartida = new Partida("Pirulo",10,10);
		assertEquals(unaPartida.movimientosRealizadosEnTotal(),0);
	}

	@Test
	public void testJugadorQueSumaMovimientosDeberianSumarseEnSuPartida(){
		Partida unaPartida = new Partida("Pirulo",10,10);
		Jugador unJugador = unaPartida.getJugador();
		unJugador.sumarMovimientos(5);
		unJugador.sumarMovimientos(3);
		unaPartida.actualizarMovimientosTotales();
		assertEquals(unaPartida.movimientosRealizadosEnTotal(),8);		
	}

	@Test
	public void testDeberiaPonerVehiculoEnPosicionInicial() {
		Partida unaPartida = new Partida("Pirulo",10,10);
		assertEquals(unaPartida.posicionDelVehiculo(),"0,0");
	}

}
