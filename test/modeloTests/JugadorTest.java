package modeloTests;

import static org.junit.Assert.*;
import modelo.Jugador;
import modelo.Tablero;
import modelo.Vehiculo;
import modelo.Posicion;
import modelo.excepciones.MovimientoInvalidoExcepcion;

import org.junit.Test;

public class JugadorTest {

	@Test
	public void testVehiculoNuevoNoDeberiaSerNulo() {
		Jugador unJugador = new Jugador("Juansito", new Vehiculo(new Tablero(5,5),new Posicion(0,0)));
		assertNotNull(unJugador);
	}

	@Test
	public void testJugadorDeberiaCrearseConNombreIndicado() {
		Jugador unJugador = new Jugador("Juansito", new Vehiculo(new Tablero(5,5),new Posicion(0,0)));
		assertEquals(unJugador.getNickName(),"Juansito");
	}

	@Test
	public void testJugadorNuevoDeberiaCrearseConNingunMovimiento() {
		Jugador unJugador = new Jugador("Juansito", new Vehiculo(new Tablero(5,5),new Posicion(0,0)));
		assertEquals(unJugador.getCantidadDeMovimientos(),0);
	}

	@Test
	public void testSumarMovimientosAUnJugadorDeberiaAumentarCantidadDeMovimientos() {
		Jugador unJugador = new Jugador("Juansito", new Vehiculo(new Tablero(5,5),new Posicion(0,0)));
		unJugador.sumarMovimientos(5);
		unJugador.sumarMovimientos(3);
		assertEquals(unJugador.getCantidadDeMovimientos(),8);
	}

	@Test
	public void testFuncionamientoDeMovimientos() throws MovimientoInvalidoExcepcion {
		Tablero tablero = new Tablero(5,5);
		Vehiculo vehiculo = new Vehiculo(tablero,new Posicion(3,0));
		Jugador unJugador = new Jugador("Juansito", vehiculo);
		unJugador.realizarJugadaEnDireccion('E');
		unJugador.realizarJugadaEnDireccion('N');
		unJugador.realizarJugadaEnDireccion('E');
		unJugador.realizarJugadaEnDireccion('S');
		assertEquals(vehiculo.getPosicion().asString(),"3,2");
		assertEquals(unJugador.getCantidadDeMovimientos(),4);
	}

	@Test
	public void testFuncionamientoDeExcepcion() throws MovimientoInvalidoExcepcion {
		Tablero tablero = new Tablero(5,5);
		Vehiculo vehiculo = new Vehiculo(tablero,new Posicion(1,2));
		Jugador unJugador = new Jugador("Juansito", vehiculo);
		unJugador.realizarJugadaEnDireccion('O');
		unJugador.realizarJugadaEnDireccion('N');
		try {	unJugador.realizarJugadaEnDireccion('N');
				fail ("Excepcion esperada");
			} catch (MovimientoInvalidoExcepcion expect) {};
		assertEquals(unJugador.getCantidadDeMovimientos(),2);
	}
}
