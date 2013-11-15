package modeloTests;

import static org.junit.Assert.assertEquals;
import modelo.ObstaculoPozo;
import modelo.Posicion;
import modelo.Vehiculo4x4;
import modelo.VehiculoAuto;
import modelo.VehiculoMoto;
import org.junit.Test;

public class ObstaculoPozoTest {
	
	//ESTE METODO COMPRUEBA QUE PARA CAMIONETA SIEMPRE VA A AUMENTAR DE A UNO LA CANTIDAD DE MOVIMIENTOS
	//SI PASAMOS POR CALLE CON POZO NO NOS AFECTA
	@Test
	public void testDeberiaSumar1MovimientoA4x4() {
		Vehiculo4x4 todoterreno = new Vehiculo4x4(new Posicion(0,0));
		todoterreno.setCantidadDeMovimientos(5);
		ObstaculoPozo pozo = new ObstaculoPozo();
		pozo.interactuarCon(todoterreno);
		assertEquals(todoterreno.getCantidadDeMovimientos(),6);
	}

	//ESTE TEST VERIFICA EL SUPUESTO DOS PARA AUTOS CON OBSTACULO POZO
	@Test
	public void testDeberiaSumar4MovimientosAAuto() {
		VehiculoAuto auto = new VehiculoAuto(new Posicion(0,0));
		auto.setCantidadDeMovimientos(5);
		ObstaculoPozo pozo = new ObstaculoPozo();
		pozo.interactuarCon(auto);
		assertEquals(auto.getCantidadDeMovimientos(),9);
	}

	@Test
	public void testDeberiaSumar4MovimientoAMoto() {
		VehiculoMoto moto = new VehiculoMoto(new Posicion(0,0));
		moto.setCantidadDeMovimientos(5);
		ObstaculoPozo pozo = new ObstaculoPozo();
		pozo.interactuarCon(moto);
		assertEquals(moto.getCantidadDeMovimientos(),9);
	}
}
