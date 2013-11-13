package modeloTests;

import static org.junit.Assert.*;
import modelo.Partida;

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
	public void testDeberiaPonerVehiculoEnPosicionInicial() {
		Partida unaPartida = new Partida("Pirulo",10,10);
		assertEquals(unaPartida.posicionDelVehiculo(),"0,0");
	}

}
