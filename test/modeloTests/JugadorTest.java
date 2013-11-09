package modeloTests;

import static org.junit.Assert.*;
import modelo.Jugador;
import org.junit.Test;

public class JugadorTest {

		@Test
		public void testVehiculoNuevoNoDeberiaSerNulo(){
			Jugador unJugador = new Jugador("Pirulo");
			assertNotNull(unJugador);
		}
		
		@Test
		public void testJugadorDeberiaCrearseConNombreIndicado(){
			Jugador unJugador = new Jugador("Pirulo");
			assertEquals(unJugador.getNickName(),"Pirulo");
		}
		
		@Test
		public void testJugadorNuevoDeberiaCrearseConNingunMovimiento(){
			Jugador unJugador = new Jugador("Juansito");
			assertEquals(unJugador.getCantidadDeMovimientos(),0);
		}
		
		@Test
		public void testSumarMovimientosAUnJugadorDeberiaAumentarCantidadDeMovimientos(){
			Jugador unJugador= new Jugador("Jorge");
			unJugador.sumarMovimientos(5);
			unJugador.sumarMovimientos(3);
			assertEquals(unJugador.getCantidadDeMovimientos(),8);
		}
		
				
}
