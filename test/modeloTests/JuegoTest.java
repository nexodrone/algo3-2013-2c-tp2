package modeloTests;

import static org.junit.Assert.*;
import modelo.Juego;
import modelo.Tablero;
import modelo.Vector;
import modelo.Vehiculo;

import org.junit.Test;

import excepciones.MovimientoInvalidoExcepcion;

public class JuegoTest {

	@Test
	public void testDeberiaCrearJuego() {
		Tablero tablero = new Tablero(10,10);
		Vehiculo vehiculo = new Vehiculo(new Vector(0,0), 0);
		Vector posicionGanadora = new Vector(6,10);
		Juego unJuego = new Juego(tablero, vehiculo, posicionGanadora);
		assertNotNull(unJuego);
	}
    @Test
    public void testVehiculoDeberiaMoversePorLimitesDelTablero() throws MovimientoInvalidoExcepcion {
		Tablero tablero = new Tablero(6,3);
		Vehiculo vehiculo = new Vehiculo(new Vector(4,0), 0);
		Juego unJuego = new Juego(tablero, vehiculo, new Vector(0,0));
    	Vector norte = new Vector(0,1);
    	Vector este = new Vector(1,0);
    	Vector oeste = new Vector(-1,0);
		unJuego.realizarJugadaEnDireccion(este);
		unJuego.realizarJugadaEnDireccion(norte);
		unJuego.realizarJugadaEnDireccion(norte);
		unJuego.realizarJugadaEnDireccion(oeste);
        assertEquals(unJuego.getVehiculo().getPosicion().asString(), "4,2");
    }

    @Test
    public void testDeberiaTirarExcepcionAlMoverseFueraDelTablero() throws MovimientoInvalidoExcepcion {
		Tablero tablero = new Tablero(6,3);
		Vehiculo vehiculo = new Vehiculo(new Vector(4,0), 1);
		Juego unJuego = new Juego(tablero, vehiculo, new Vector(0,0));
    	Vector sur = new Vector(0,-1);
    	try {	unJuego.realizarJugadaEnDireccion(sur);
    			fail("Excepcion esperada");		} catch (MovimientoInvalidoExcepcion esperada) {};
        assertEquals(unJuego.getVehiculo().getCantidadDeMovimientos(), 1);
/* se comprueba que al intentar a mover en direccion invalida NO SE SUMAN MOVIMIENTOS */
    }

}
