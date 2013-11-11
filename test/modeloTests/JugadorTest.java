package modeloTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import modelo.Jugador;
import modelo.Posicion;
import modelo.Tablero;
import modelo.Vector;
import modelo.Vehiculo;
import modelo.excepciones.MovimientoInvalidoExcepcion;

import org.junit.Test;

public class JugadorTest {

    @Test
    public void testVehiculoNuevoNoDeberiaSerNulo() {
        Jugador unJugador = new Jugador("Juansito", new Vehiculo(new Tablero(5, 5), new Posicion(0, 0)));
        assertNotNull(unJugador);
    }

    @Test
    public void testJugadorDeberiaCrearseConNombreIndicado() {
        Jugador unJugador = new Jugador("Juansito", new Vehiculo(new Tablero(5, 5), new Posicion(0, 0)));
        assertEquals(unJugador.getNickName(), "Juansito");
    }

    @Test
    public void testJugadorNuevoDeberiaCrearseConNingunMovimiento() {
        Jugador unJugador = new Jugador("Juansito", new Vehiculo(new Tablero(5, 5), new Posicion(0, 0)));
        assertEquals(unJugador.getCantidadDeMovimientos(), 0);
    }

    @Test
    public void testSumarMovimientosAUnJugadorDeberiaAumentarCantidadDeMovimientos() {
        Jugador unJugador = new Jugador("Juansito", new Vehiculo(new Tablero(5, 5), new Posicion(0, 0)));
        unJugador.sumarMovimientos(5);
        unJugador.sumarMovimientos(3);
        assertEquals(unJugador.getCantidadDeMovimientos(), 8);
    }

    @Test
    public void testFuncionamientoDeMovimientos() throws MovimientoInvalidoExcepcion {
        Vector este = new Vector(1, 0);
        Vector norte = new Vector(0, 1);
        Vector sur = new Vector(0, -1);
        Tablero tablero = new Tablero(5, 5);
        Vehiculo vehiculo = new Vehiculo(tablero, new Posicion(3, 0));
        Jugador unJugador = new Jugador("Juansito", vehiculo);
        unJugador.realizarJugadaEnDireccion(este);
        unJugador.realizarJugadaEnDireccion(norte);
        unJugador.realizarJugadaEnDireccion(este);
        unJugador.realizarJugadaEnDireccion(sur);
        assertEquals(vehiculo.getPosicion().asString(), "3,2"); // Para que?
        assertEquals(unJugador.getCantidadDeMovimientos(), 4);
    }

    @Test
    public void testFuncionamientoDeExcepcion() throws MovimientoInvalidoExcepcion {
        Vector oeste = new Vector(-1, 0);
        Vector norte = new Vector(0, 1);
        Tablero tablero = new Tablero(5, 5);
        Vehiculo vehiculo = new Vehiculo(tablero, new Posicion(1, 2));
        Jugador unJugador = new Jugador("Juansito", vehiculo);
        unJugador.realizarJugadaEnDireccion(oeste);
        unJugador.realizarJugadaEnDireccion(norte);
        try {
            unJugador.realizarJugadaEnDireccion(norte);
            fail("Excepcion esperada");
        } catch (MovimientoInvalidoExcepcion expect) {
        };
        assertEquals(unJugador.getCantidadDeMovimientos(), 2);
    }
    // esta mal esta prueba, no tendria que haber un try, los test negativos se hacen de otra forma
}
