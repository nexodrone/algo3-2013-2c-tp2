package modeloTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import modelo.Direccion;
import modelo.ObstaculoPiquete;
import modelo.ObstaculoPozo;
import modelo.Partida;
import modelo.Posicion;
import modelo.SorpresaDesfavorable;
import modelo.SorpresaFavorable;
import modelo.Tablero;
import modelo.Vehiculo;
import modelo.VehiculoAuto;
import modelo.excepciones.PartidaInexistente;

import java.io.*;

import org.junit.Test;

public class PartidaTest {

	@Test
	public void testDeberiaCrearPartida() {
		Partida unaPartida = new Partida();
		assertNotNull(unaPartida);
	}
	
	@Test
	public void testDeberiaDevolverCorrectamenteLaPosicionDelVehiculo () {
        Tablero tablero = new Tablero(4, 6);
        Vehiculo vehiculo = new VehiculoAuto(new Posicion(2, 1));
        vehiculo.setCantidadDeMovimientos(0);
        Posicion posicionGanadora = new Posicion(3, 4);
        int movimientosDisponibles = 100;
        
        Partida unaPartida = new Partida(tablero, vehiculo, posicionGanadora, movimientosDisponibles);
        
        assertEquals(unaPartida.posicionDelVehiculo().asString(), "2,1");
	}
	
	@Test
	public void testDeberiaDevolverCorrectamenteLosMovimientosDisponibles() {
		Tablero tablero = new Tablero(4, 6);
        Vehiculo vehiculo = new VehiculoAuto(new Posicion(2, 1));
        vehiculo.setCantidadDeMovimientos(0);
        Posicion posicionGanadora = new Posicion(3, 4);
        int movimientosDisponibles = 100;
        
        Partida unaPartida = new Partida(tablero, vehiculo, posicionGanadora, movimientosDisponibles);
        
        assertEquals(unaPartida.getCantidadDeMovimientosDisponibles(), 100);
	}
	
	@Test
	public void testDeberiaGuardarYCargarPartida() throws Exception {
        Tablero tablero = new Tablero(4, 6);
        Vehiculo vehiculo = new VehiculoAuto(new Posicion(0, 0));
        vehiculo.setCantidadDeMovimientos(0);
        Posicion posicionGanadora = new Posicion(3, 4);
        int movimientosDisponibles = 100;

        Partida unaPartida = new Partida(tablero, vehiculo, posicionGanadora, movimientosDisponibles);
        
        Direccion norte = new Direccion(0, 1);
        Direccion sur = new Direccion(0, -1);
        Direccion este = new Direccion(1, 0);
        Direccion oeste = new Direccion(-1, 0);
        
        tablero.getBocacalleEnPosicion(new Posicion(1, 0)).getCalleEnDireccion(norte).setObstaculo(new ObstaculoPiquete());
        tablero.getBocacalleEnPosicion(new Posicion(2, 3)).getCalleEnDireccion(sur).setObstaculo(new ObstaculoPozo());
        tablero.getBocacalleEnPosicion(new Posicion(1, 4)).getCalleEnDireccion(este).setSorpresa(new SorpresaDesfavorable());
        tablero.getBocacalleEnPosicion(new Posicion(3, 4)).getCalleEnDireccion(oeste).setSorpresa(new SorpresaFavorable());
        
        unaPartida.guardarPartida("test/partidaTest.xml");
        
        Partida otraPartida = Partida.recuperar("test/partidaTest.xml");
        
        assertEquals(otraPartida.getVehiculo().getCantidadDeMovimientos(), vehiculo.getCantidadDeMovimientos());
        assertEquals(otraPartida.getPosicionGanadora().asString(), posicionGanadora.asString());
	}
	
	@Test (expected = PartidaInexistente.class )
	public void testDeberiaTirarmeExcepcionAlNoHaberPartidaGuardad() throws Exception{
		Partida unaPartida = Partida.recuperar("partidaInexistenteTest.xml");
	}
}
