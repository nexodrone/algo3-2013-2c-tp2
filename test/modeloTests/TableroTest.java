package modeloTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import modelo.Bocacalle;
import modelo.Posicion;
import modelo.Tablero;

import org.junit.Test;

public class TableroTest {

    @Test
    public void testDeberiaCrearTableroNoVacio() {
        Tablero unTablero = new Tablero(10, 10);
        assertNotNull(unTablero);
    }

    @Test
    public void testObtenerBocacalleATransitarDeUnaPosicionValidaNoDeberiaSerNula() {
        Tablero unTablero = new Tablero(10, 10);
        Bocacalle unaBocacalle = unTablero.getBocacalleEnPosicion(new Posicion(0, 0));
        assertNotNull(unaBocacalle);
    }

    @Test
    public void testCalleEntreDosBocacallesAdyacentesDeberiaSerMismoObjeto() {
        Tablero unTablero = new Tablero(5, 5);
        assertEquals(unTablero.getBocacalleEnPosicion(new Posicion(0, 0)).obtenerCalleEste(), unTablero.getBocacalleEnPosicion(new Posicion(0, 1)).obtenerCalleOeste());
        assertEquals(unTablero.getBocacalleEnPosicion(new Posicion(4, 4)).obtenerCalleNorte(), unTablero.getBocacalleEnPosicion(new Posicion(3, 4)).obtenerCalleSur());
        assertEquals(unTablero.getBocacalleEnPosicion(new Posicion(2, 2)).obtenerCalleSur(), unTablero.getBocacalleEnPosicion(new Posicion(3, 2)).obtenerCalleNorte());
    }

    @Test
    public void testParaComprobarQueValidaCorrectamenteLasFilasMenoresACero() {
        Tablero tablero = new Tablero(10, 10);
        int filaInvalida = -1;
        for (int i = 0; i < 10; i++) {
            Posicion unaPosicion = new Posicion(i, filaInvalida);
            assertFalse(tablero.posicionValida(unaPosicion));
        }
    }

    @Test
    public void testParaComprobarQueValidaCorrectamenteLasPosicionConFilaMayorACantidadDeFilas() {
        int cantidadDeFilas = 10;
        Tablero tablero = new Tablero(cantidadDeFilas, 10);
        int filaInvalida = cantidadDeFilas;
        for (int i = 1; i < 10; i++) {
            Posicion unaPosicion = new Posicion(i, filaInvalida);
            assertFalse(tablero.posicionValida(unaPosicion));
        }
    }

    @Test
    public void testParaComprobarQueValidaCorrectamenteLasColumnasMenoresACero() {
        Tablero tablero = new Tablero(10, 10);
        int columnaInvalida = -1;
        for (int i = 0; i < 10; i++) {
            Posicion unaPosicion = new Posicion(columnaInvalida, i);
            assertFalse(tablero.posicionValida(unaPosicion));
        }
    }

    @Test
    public void testParaComprobarQueValidaCorrectamenteLasColumnasMayorACantidadDeFilas() {
        int cantidadDeColumnas = 10;
        Tablero tablero = new Tablero(10, cantidadDeColumnas);
        int columnaInvalida = cantidadDeColumnas;
        for (int i = 0; i < cantidadDeColumnas; i++) {
            Posicion unaPosicion = new Posicion(columnaInvalida, i);
            assertFalse(tablero.posicionValida(unaPosicion));
        }
    }
}
