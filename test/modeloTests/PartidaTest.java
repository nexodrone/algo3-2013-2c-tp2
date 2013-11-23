package modeloTests;

import static org.junit.Assert.*;
import modelo.Direccion;
import modelo.Partida;
import modelo.Tablero;
import modelo.VehiculoAuto;
import modelo.Posicion;



import org.junit.Test;

public class PartidaTest {

	@Test
	public void testDeberiaCrearPartida() {
		Partida unaPartida = new Partida();
		assertNotNull(unaPartida);
	}
	
	@Test
	public void testDeberiaRealizarJugadas() throws Exception {
		Tablero unTablero = new Tablero(3,3);
		VehiculoAuto unAuto = new VehiculoAuto(new Posicion(1,1));
		Posicion posGanadora = new Posicion(2,1);
		
		Partida unaPartida = new Partida(unTablero, unAuto, posGanadora, 10);
		
		Direccion Norte = new Direccion(0,1);
		Direccion Este = new Direccion(1,0);
		Direccion Oeste = new Direccion(-1,0);
		
		System.out.print(unaPartida.posicionPieza().asString());
		unaPartida.moverPiezaEnDireccion(Este);
		System.out.print(unaPartida.posicionPieza().asString());
		unaPartida.moverPiezaEnDireccion(Norte);
		System.out.print(unaPartida.posicionPieza().asString());
		unaPartida.moverPiezaEnDireccion(Oeste);
		System.out.print(unaPartida.posicionPieza().asString());
		
		assertEquals(unaPartida.posicionPieza().asString(), "1,2");
		assertEquals(unaPartida.getCantidadDeMovimientosDisponibles(), 7);		
	}
	
}
