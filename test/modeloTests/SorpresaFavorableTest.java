package modeloTests;

import static org.junit.Assert.assertEquals;
import modelo.SorpresaFavorable;
import modelo.Vector;
import modelo.VehiculoAuto;

import org.junit.Test;

public class SorpresaFavorableTest {

    @Test
    public void testDeberiaRestarCorrectamentePuntaje() {
        VehiculoAuto auto = new VehiculoAuto(new Vector(0,0));
        auto.setCantidadDeMovimientos(76);
        SorpresaFavorable sorpresaFavorable = new SorpresaFavorable();
        sorpresaFavorable.interactuarCon(auto);
        assertEquals(auto.getCantidadDeMovimientos(), 61);
    }
    // Aca faltaria agregar que se comporte de la misma manera con los demas vehiculos
}
