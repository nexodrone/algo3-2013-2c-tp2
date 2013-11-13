package modeloTests;

import static org.junit.Assert.*;
import modelo.Bocacalle;
import modelo.Tablero;
import modelo.Vector;

import org.junit.Test;

public class TableroTest {

    @Test
    public void testDeberiaCrearTableroNoVacio() {
        Tablero unTablero = new Tablero(10, 10);
        assertNotNull(unTablero);
    }

    @Test
    public void testDeberiaDevolverCantidadDeColumnas() {
        Tablero unTablero = new Tablero(4,6);
        assertEquals(unTablero.getCantidadDeColumnas(),4);
    }

    @Test
    public void testDeberiaDevolverCantidadDeFilas() {
        Tablero unTablero = new Tablero(4,6);
        assertEquals(unTablero.getCantidadDeFilas(),6);
    }    
    
    @Test
    public void testObtenerBocacalleATransitarDeUnaPosicionValidaNoDeberiaSerNula() {
        Tablero unTablero = new Tablero(10, 10);
        Bocacalle unaBocacalle = unTablero.getBocacalleEnPosicion(new Vector(3, 4));
        assertNotNull(unaBocacalle);
    }

    @Test
    public void testCalleEntreDosBocacallesAdyacentesDeberiaSerMismoObjeto() {
    	Vector norte = new Vector(0,1);
    	Vector sur = new Vector(0,-1);
    	Vector este = new Vector(1,0);
    	Vector oeste = new Vector(-1,0);
        Tablero unTablero = new Tablero(5, 5);
        assertEquals(unTablero.getBocacalleEnPosicion(new Vector(0,0)).obtenerCalleEnDireccion(norte),
        				unTablero.getBocacalleEnPosicion(new Vector(0,1)).obtenerCalleEnDireccion(sur));
        assertEquals(unTablero.getBocacalleEnPosicion(new Vector(3,1)).obtenerCalleEnDireccion(este),
				unTablero.getBocacalleEnPosicion(new Vector(4,1)).obtenerCalleEnDireccion(oeste));
    }

    @Test
    public void testDePosicionConFilaFueraDeRangoDeberiaSerInavildaSinImportarLaColumna() {
        Tablero tablero = new Tablero(10,10);
        for (int i=0; i<10; i++) {
            Vector unaPosicion = new Vector(-1,i);
            assertFalse(tablero.posicionValida(unaPosicion));
        }
    }

    @Test
    public void testPosicionDelVerticeDelTableroDeberiaSerValida() {
        Tablero tablero = new Tablero(10,10);
        Vector unaPosicion = new Vector(9,9);
        assertTrue(tablero.posicionValida(unaPosicion));
        }

    @Test
    public void testDePosicionConColumnaFueraDeRangoDeberiaSerInavildaSinImportarLaFila() {
        Tablero tablero = new Tablero(10,10);
        for (int i=0; i<10; i++) {
            Vector unaPosicion = new Vector(i,10);
            assertFalse(tablero.posicionValida(unaPosicion));
        }
}
  
    @Test
    public void testTodasLasPosicionesContenidasEnElTableroDeberianSerValidas() {
        Tablero tablero = new Tablero(10,10);
        for (int i=0; i<10; i++) {
        	for (int j=0; j<10; j++){
            Vector unaPosicion = new Vector(i,j);
            assertEquals(tablero.posicionValida(unaPosicion),true);
        	}
        }
    }

}
