package modeloTests;

import static org.junit.Assert.assertNotNull;
import modelo.Bocacalle;
import modelo.Calle;
import modelo.Direccion;
import org.junit.Test;

public class BocacalleTest {

    @Test
    public void testDeberiaCrearBocacalleNoVacia() {
        Bocacalle unaBocacalle = new Bocacalle();
        assertNotNull(unaBocacalle);
    }

    @Test
    public void testParaComprobarQuelaCalleNorteNoEsNula() {
        Direccion norte = new Direccion(0, 1);
        Bocacalle unaBocaCalle = new Bocacalle();
        Calle calleNorte = unaBocaCalle.obtenerCalleEnDireccion(norte);
        assertNotNull(calleNorte);
    }

    @Test
    public void testParaComprobarQuelaCalleSurNoEsNula() {
        Direccion sur = new Direccion(0, -1);
        Bocacalle unaBocaCalle = new Bocacalle();
        Calle calleSur = unaBocaCalle.obtenerCalleEnDireccion(sur);
        assertNotNull(calleSur);
    }

    @Test
    public void testParaComprobarQueLaCalleEsteNoEsNula() {
        Direccion este = new Direccion(1, 0);
        Bocacalle unaBocaCalle = new Bocacalle();
        Calle calleEste = unaBocaCalle.obtenerCalleEnDireccion(este);
        assertNotNull(calleEste);

    }

    @Test
    public void testParaComprobarQueLaCalleOesteNoEsNula() {
        Direccion oeste = new Direccion(-1, 0);
        Bocacalle unaBocaCalle = new Bocacalle();
        Calle calleOeste = unaBocaCalle.obtenerCalleEnDireccion(oeste);
        assertNotNull(calleOeste);
    }

/*
    @Test
    public void testParaComprobarQueDevuelveCorrectamenteLaCalleNorte() {
        Vector norte = new Vector(0, 1);
        Bocacalle unaBocaCalle = new Bocacalle();
        Calle calleNorte = unaBocaCalle.getCalleEnDireccion(norte);
        assertEquals(calleNorte, unaBocaCalle.obtenerCalleEnDireccion(norte));
    }

    @Test
    public void testParaComprobarQueDevuelveCorrectamenteLaCalleSur() {
        Vector sur = new Vector(0,1);
        Bocacalle unaBocaCalle = new Bocacalle();
        Calle calleSur = unaBocaCalle.getCalleEnDireccion(sur);
        assertEquals(calleSur, unaBocaCalle.getCalleEnDireccion(sur));
    }

    @Test
    public void testParaComprobarQueDevuelveCorrectamenteLaCalleEste() {
        Vector este = new Vector(1, 0);
        Bocacalle unaBocaCalle = new Bocacalle();
        Calle calleEste = unaBocaCalle.getCalleEnDireccion(este);
        assertEquals(calleEste, unaBocaCalle.getCalleEnDireccion(este));
    }

    @Test
    public void testParaComprobarQueDevuelveCorrectamenteLaCalleOeste() {
        Vector oeste = new Vector(-1, 0);
        Bocacalle unaBocaCalle = new Bocacalle();
        Calle calleOeste = unaBocaCalle.getCalleEnDireccion(oeste);
        assertEquals(calleOeste, unaBocaCalle.getCalleEnDireccion(oeste));
    }
*/
}
