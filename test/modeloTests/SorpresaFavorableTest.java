package modeloTests;

import static org.junit.Assert.assertEquals;
import modelo.SorpresaFavorable;
import modelo.Posicion;
import modelo.Vehiculo4x4;
import modelo.VehiculoAuto;
import modelo.VehiculoMoto;

import org.junit.Test;

public class SorpresaFavorableTest {

    @Test
    public void testDeberiaRestarCorrectamentePuntajeAlAuto() {
        VehiculoAuto auto = new VehiculoAuto(new Posicion(0,0));
        auto.setCantidadDeMovimientos(76);
        SorpresaFavorable sorpresaFavorable = new SorpresaFavorable();
        sorpresaFavorable.interactuarCon(auto);
        assertEquals(auto.getCantidadDeMovimientos(), 61);
    }

    @Test
    public void testDeberiaRestarCorrectamentePuntajeAl4x4() {
		Vehiculo4x4 todoterreno = new Vehiculo4x4(new Posicion(0,0));
		todoterreno.setCantidadDeMovimientos(76);
        SorpresaFavorable sorpresaFavorable = new SorpresaFavorable();
        sorpresaFavorable.interactuarCon(todoterreno);
        assertEquals(todoterreno.getCantidadDeMovimientos(), 61);
    }
    
    @Test
    public void testDeberiaRestarCorrectamentePuntajeALaMoto() {
		VehiculoMoto moto = new VehiculoMoto(new Posicion(0,0));
		moto.setCantidadDeMovimientos(76);
        SorpresaFavorable sorpresaFavorable = new SorpresaFavorable();
        sorpresaFavorable.interactuarCon(moto);
        assertEquals(moto.getCantidadDeMovimientos(), 61);
    }
    
}
