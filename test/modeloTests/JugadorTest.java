package modeloTests;

import static org.junit.Assert.*;
import modelo.Jugador;
import modelo.Vehiculo;
import org.junit.Test;

public class JugadorTest {

		@Test
		public void testVehiculoNuevoNoDeberiaSerNulo() {
			Jugador unJugador = new Jugador("Juansito", new Vehiculo());
			assertNotNull(unJugador);
		}

		@Test
		public void testJugadorDeberiaCrearseConNombreIndicado() {
			Jugador unJugador = new Jugador("Juansito", new Vehiculo());
			assertEquals(unJugador.getNickName(),"Juansito");
		}

		@Test
		public void testJugadorNuevoDeberiaCrearseConNingunMovimiento() {
			Jugador unJugador = new Jugador("Juansito", new Vehiculo());
			assertEquals(unJugador.getCantidadDeMovimientos(),0);
		}

		@Test
		public void testSumarMovimientosAUnJugadorDeberiaAumentarCantidadDeMovimientos() {
			Jugador unJugador = new Jugador("Juansito", new Vehiculo());
			unJugador.sumarMovimientos(5);
			unJugador.sumarMovimientos(3);
			assertEquals(unJugador.getCantidadDeMovimientos(),8);
		}

}
