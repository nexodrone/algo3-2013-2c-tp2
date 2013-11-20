package modeloTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import modelo.Bocacalle;
import modelo.Calle;
import modelo.Direccion;
import modelo.ObstaculoPozo;
import modelo.Posicion;
import modelo.SorpresaDesfavorable;
import modelo.VehiculoMoto;

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
        Calle calleNorte = unaBocaCalle.getCalleEnDireccion(norte);
        assertNotNull(calleNorte);
    }

    @Test
    public void testParaComprobarQuelaCalleSurNoEsNula() {
        Direccion sur = new Direccion(0, -1);
        Bocacalle unaBocaCalle = new Bocacalle();
        Calle calleSur = unaBocaCalle.getCalleEnDireccion(sur);
        assertNotNull(calleSur);
    }

    @Test
    public void testParaComprobarQueLaCalleEsteNoEsNula() {
        Direccion este = new Direccion(1, 0);
        Bocacalle unaBocaCalle = new Bocacalle();
        Calle calleEste = unaBocaCalle.getCalleEnDireccion(este);
        assertNotNull(calleEste);

    }

    @Test
    public void testParaComprobarQueLaCalleOesteNoEsNula() {
        Direccion oeste = new Direccion(-1, 0);
        Bocacalle unaBocaCalle = new Bocacalle();
        Calle calleOeste = unaBocaCalle.getCalleEnDireccion(oeste);
        assertNotNull(calleOeste);
    }
    
    @Test
    public void testGuardarYRecuperarCorrectamente() {
        Bocacalle unaBocacalle = new Bocacalle();
        Calle calle = new Calle();
        calle.setObstaculo(new ObstaculoPozo());
        calle.setSorpresa(new SorpresaDesfavorable());
        unaBocacalle.setCalleOeste(calle);
        
        
    }
}