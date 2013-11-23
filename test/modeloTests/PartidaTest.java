package modeloTests;

import static org.junit.Assert.*;
import modelo.Direccion;
import modelo.Juego;
import modelo.Partida;
import modelo.Tablero;
import modelo.Vehiculo;
import modelo.VehiculoAuto;
import modelo.Posicion;



import modelo.excepciones.MovimientoInvalidoExcepcion;
import modelo.excepciones.PasajeBloqueadoPorPiqueteExcepcion;

import org.junit.Test;

public class PartidaTest {

	@Test
	public void testDeberiaCrearPartida() {
		Partida unaPartida = new Partida();
		assertNotNull(unaPartida);
	}
	
	@Test
	public void testDeberiaRealizarJugadas() throws Exception {
		Tablero unTablero = new Tablero(3,3);
		VehiculoAuto unAuto = new VehiculoAuto(new Posicion(1,1));
		Posicion posGanadora = new Posicion(2,1);
		
		Partida unaPartida = new Partida(unTablero, unAuto, posGanadora, 10);
		
		Direccion Norte = new Direccion(0,1);
		Direccion Este = new Direccion(1,0);
		Direccion Oeste = new Direccion(-1,0);
		
		System.out.print(unaPartida.posicionPieza().asString());
		unaPartida.moverPiezaEnDireccion(Este);
		System.out.print(unaPartida.posicionPieza().asString());
		unaPartida.moverPiezaEnDireccion(Norte);
		System.out.print(unaPartida.posicionPieza().asString());
		unaPartida.moverPiezaEnDireccion(Oeste);
		System.out.print(unaPartida.posicionPieza().asString());
		
		assertEquals(unaPartida.posicionPieza().asString(), "1,2");
		assertEquals(unaPartida.getCantidadDeMovimientosDisponibles(), 7);		
	}
	
    @Test
    public void testDeberiaTirarExcepcionAlMoverseFueraDelTablero() throws MovimientoInvalidoExcepcion, PasajeBloqueadoPorPiqueteExcepcion {
        Tablero tablero = new Tablero(6, 3);
        Vehiculo vehiculo = new VehiculoAuto(new Posicion(4, 0));
        vehiculo.setCantidadDeMovimientos(1);
        int cantidadDeMovimientos = 10;
        Partida unaPartida = new Partida(tablero, vehiculo, new Posicion (0,0),cantidadDeMovimientos);
        
        Direccion sur = new Direccion(0, -1);
        try {
            unaPartida.moverPiezaEnDireccion(sur);
            fail("Excepcion esperada");
        } catch (MovimientoInvalidoExcepcion esperada) {
        };
        assertEquals(unaPartida.getVehiculo().getCantidadDeMovimientos(), 1);
        /* Se comprueba que la cantidad de movimientos no se cambio */
    }
    
    
}
