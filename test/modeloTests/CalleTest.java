package modeloTests;

import static org.junit.Assert.*;
import modelo.Calle;
import modelo.Posicion;
import modelo.SorpresaFavorable;
import modelo.VehiculoAuto;
import modelo.excepciones.CalleBloqueadaPorPiqueteExcepcion;

import org.junit.Test;

public class CalleTest {

	@Test
	public void testDeberiaCrearCalleNoVacia(){
		Calle unaCalle = new Calle();
		assertNotNull(unaCalle);
	}

	@Test
	public void testPasarPorCalleConSorpresaDeberiaUsarlaUnicaVez() throws CalleBloqueadaPorPiqueteExcepcion {
		Calle calle = new Calle();
		calle.setSorpresa(new SorpresaFavorable());
		VehiculoAuto auto = new VehiculoAuto(new Posicion(5,5));
		auto.setCantidadDeMovimientos(80);
		auto.pasarPorCalle(calle);
		auto.pasarPorCalle(calle);
		auto.pasarPorCalle(calle);
		assertEquals(auto.getCantidadDeMovimientos(),67);
	}
	/*
    @Test
    public void testGuardarYCargarCorrectamente () throws Exception{
    	Calle unaCalle = new Calle();
    	unaCalle.setSorpresa(new SorpresaFavorable());
    	unaCalle.setObstaculo(new ObstaculoControlPolicial());
    	unaCalle.guardar("test/calleTest.xml");
        
        Calle otraCalle = new Calle();
        try {
        	otraCalle = Calle.recuperar("test/calleTest.xml");
        }catch(Exception ex) {
        	System.out.print("No se pudo deserializar el objeto.\n");
        }

        assertEquals(otraCalle.getNickName(), "Chango");  
    }*/
}
