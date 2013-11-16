package modeloTests;

import static org.junit.Assert.*;
import modelo.Bocacalle;
import modelo.Calle;
import modelo.Direccion;
import modelo.ObstaculoControlPolicial;
import modelo.ObstaculoPiquete;
import modelo.SorpresaFavorable;
import modelo.Tablero;
import modelo.Posicion;

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
        Bocacalle unaBocacalle = unTablero.getBocacalleEnPosicion(new Posicion(3, 4));
        assertNotNull(unaBocacalle);
    }

    @Test
    public void testCalleEntreDosBocacallesAdyacentesDeberiaSerMismoObjeto() {
        Direccion norte = new Direccion(0,1);
        Direccion sur = new Direccion(0,-1);
        Direccion este = new Direccion(1,0);
        Direccion oeste = new Direccion(-1,0);
        Tablero unTablero = new Tablero(5, 5);
        assertEquals(unTablero.getBocacalleEnPosicion(new Posicion(0,0)).getCalleEnDireccion(norte),
        				unTablero.getBocacalleEnPosicion(new Posicion(0,1)).getCalleEnDireccion(sur));
        assertEquals(unTablero.getBocacalleEnPosicion(new Posicion(3,1)).getCalleEnDireccion(este),
				unTablero.getBocacalleEnPosicion(new Posicion(4,1)).getCalleEnDireccion(oeste));
    }

    @Test
    public void testDePosicionConFilaFueraDeRangoDeberiaSerInavildaSinImportarLaColumna() {
        Tablero tablero = new Tablero(10,10);
        for (int i=0; i<10; i++) {
            Posicion unaPosicion = new Posicion(-1,i);
            assertFalse(tablero.posicionValida(unaPosicion));
        }
    }

    @Test
    public void testPosicionDelVerticeDelTableroDeberiaSerValida() {
        Tablero tablero = new Tablero(10,10);
        Posicion unaPosicion = new Posicion(9,9);
        assertTrue(tablero.posicionValida(unaPosicion));
        }

    @Test
    public void testDePosicionConColumnaFueraDeRangoDeberiaSerInavildaSinImportarLaFila() {
        Tablero tablero = new Tablero(10,10);
        for (int i=0; i<10; i++) {
            Posicion unaPosicion = new Posicion(i,10);
            assertFalse(tablero.posicionValida(unaPosicion));
        }
}
  
    @Test
    public void testTodasLasPosicionesContenidasEnElTableroDeberianSerValidas() {
        Tablero tablero = new Tablero(10,10);
        for (int i=0; i<10; i++) {
        	for (int j=0; j<10; j++){
            Posicion unaPosicion = new Posicion(i,j);
            assertEquals(tablero.posicionValida(unaPosicion),true);
        	}
        }
    }
    
    
    @Test
    public void testTableroConSorpresasYObstaculosDebenSerCompartidaPorBocacallesVecinas(){
    	
    	Direccion norte = new Direccion(0, 1);
    	Direccion sur = new Direccion(0, -1);
        Direccion este = new Direccion(1, 0);
        Direccion oeste = new Direccion(-1, 0);
    	Tablero tablero = new Tablero(6,4);

    	Calle calleNortePosicionUnoUno = tablero.getBocacalleEnPosicion(new Posicion(1,1)).getCalleEnDireccion(norte);
    	calleNortePosicionUnoUno.setObstaculo(new ObstaculoControlPolicial());
    	Calle calleEstePosicionDosDos = tablero.getBocacalleEnPosicion(new Posicion(2,2)).getCalleEnDireccion(este);
    	calleEstePosicionDosDos.setSorpresa(new SorpresaFavorable());
    	Calle calleSurPosicionUnoTres = tablero.getBocacalleEnPosicion(new Posicion(1,3)).getCalleEnDireccion(sur);
    	calleSurPosicionUnoTres.setObstaculo(new ObstaculoPiquete());
    	Calle calleSurPosicionDosTres = tablero.getBocacalleEnPosicion(new Posicion(2,3)).getCalleEnDireccion(sur);
    	calleSurPosicionDosTres.setSorpresa(new SorpresaFavorable());
    	
    	assertNotNull(tablero.getBocacalleEnPosicion(new Posicion(2,1)).getCalleEnDireccion(sur));
    	assertNotNull(tablero.getBocacalleEnPosicion(new Posicion(2,3)).getCalleEnDireccion(oeste));
    	assertNotNull(tablero.getBocacalleEnPosicion(new Posicion(0,3)).getCalleEnDireccion(norte));
    	assertNotNull(tablero.getBocacalleEnPosicion(new Posicion(2,0)).getCalleEnDireccion(norte));
    	
    	assertEquals(tablero.getBocacalleEnPosicion(new Posicion(1,2)).getCalleEnDireccion(sur).getObstaculo(),
    			tablero.getBocacalleEnPosicion(new Posicion(1,1)).getCalleEnDireccion(norte).getObstaculo());
    	assertEquals(tablero.getBocacalleEnPosicion(new Posicion(2,2)).getCalleEnDireccion(este).getSorpresa(),
    			tablero.getBocacalleEnPosicion(new Posicion(3,2)).getCalleEnDireccion(oeste).getSorpresa());
    	assertEquals(tablero.getBocacalleEnPosicion(new Posicion(1,3)).getCalleEnDireccion(sur).getObstaculo(),
    			tablero.getBocacalleEnPosicion(new Posicion(1,2)).getCalleEnDireccion(norte).getObstaculo());
    	assertEquals(tablero.getBocacalleEnPosicion(new Posicion(2,3)).getCalleEnDireccion(sur).getSorpresa(),
    			tablero.getBocacalleEnPosicion(new Posicion(2,2)).getCalleEnDireccion(norte).getSorpresa());
    	
    }

}
