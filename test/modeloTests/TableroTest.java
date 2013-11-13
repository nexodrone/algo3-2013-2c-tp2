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
    public void testDePosicionConFilaFueraDeRangoDeberiaSerInavildaSinImportarLaColumna() {
        Tablero tablero = new Tablero(10, 10);
        for (int i = 0; i < 10; i++) {
            Posicion unaPosicion = new Posicion(-1,i);
            assertFalse(tablero.posicionValida(unaPosicion));
        }
    }

    @Test
    public void testPosicionDelVerticeDelTableroDeberiaSerValida() {
        Tablero tablero = new Tablero(10, 10);
        Posicion unaPosicion = new Posicion(10, 10);
        assertEquals(tablero.posicionValida(unaPosicion),true);
        }

    @Test
    public void testPosicionConColumnaMayorACantidadDeColumnasDelTableroNoDeberiaSerValida() {
        Tablero tablero = new Tablero(10, 10);
        Posicion unaPosicion = new Posicion(0, 11);
        assertFalse(tablero.posicionValida(unaPosicion));
        }
  
    @Test
    public void testTodasLasPosicionesContenidasEnElTableroDeberianSerValidas() {
        Tablero tablero = new Tablero(10,10);
        for (int i = 0; i < 10; i++) {
        	for (int j=0; j <10;j++){
            Posicion unaPosicion = new Posicion(i,j);
            assertEquals(tablero.posicionValida(unaPosicion),true);
        	}
        }
    }
}
