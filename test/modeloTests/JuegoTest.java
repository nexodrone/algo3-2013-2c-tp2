package modeloTests;

import static org.junit.Assert.*;
import modelo.Calle;
import modelo.Direccion;
import modelo.Juego;
import modelo.ObstaculoPozo;
import modelo.SorpresaCambioDeVehiculo;
import modelo.SorpresaDesfavorable;
import modelo.Tablero;
import modelo.Vector;
import modelo.Vehiculo;
import modelo.VehiculoAuto;
import modelo.excepciones.MovimientoInvalidoExcepcion;
import modelo.excepciones.PasajeBloqueadoPorPiqueteExcepcion;

import org.junit.Test;

public class JuegoTest {


	@Test
	public void testDeberiaCrearJuego() {
		Tablero tablero = new Tablero(10,10);
		Vehiculo vehiculo = new VehiculoAuto(new Vector(0,0));
		Vector posicionGanadora = new Vector(6,10);
		Juego unJuego = new Juego(tablero, vehiculo, posicionGanadora);
		assertNotNull(unJuego);
	}
    @Test
    public void testVehiculoDeberiaMoversePorLimitesDelTablero() throws MovimientoInvalidoExcepcion, PasajeBloqueadoPorPiqueteExcepcion{
		Tablero tablero = new Tablero(6,3);
		Vehiculo vehiculo = new VehiculoAuto(new Vector(4,0));
		Juego unJuego = new Juego(tablero, vehiculo, new Vector(0,0));
        Direccion norte = new Direccion(0, 1);
        Direccion este = new Direccion(1, 0);
        Direccion oeste = new Direccion(-1, 0);
		try{unJuego.realizarJugadaEnDireccion(este);
		unJuego.realizarJugadaEnDireccion(norte);
		unJuego.realizarJugadaEnDireccion(norte);
		unJuego.realizarJugadaEnDireccion(oeste);
		} catch (MovimientoInvalidoExcepcion e){};
        assertEquals(unJuego.getVehiculo().getPosicion().asString(), "4,2");
    }

    @Test
    public void testDeberiaTirarExcepcionAlMoverseFueraDelTablero() throws MovimientoInvalidoExcepcion, PasajeBloqueadoPorPiqueteExcepcion {
		Tablero tablero = new Tablero(6,3);
		Vehiculo vehiculo = new VehiculoAuto(new Vector(4,0));
		vehiculo.setCantidadDeMovimientos(1);
		Juego unJuego = new Juego(tablero, vehiculo, new Vector(0,0));
        Direccion sur = new Direccion(0, -1);
    	try {	unJuego.realizarJugadaEnDireccion(sur);
    			fail("Excepcion esperada");		
    		} catch (MovimientoInvalidoExcepcion esperada) {};
        assertEquals(unJuego.getVehiculo().getCantidadDeMovimientos(), 1);
    }
 
    
    //ESTE VA A SER UN TEST INTEGRADOR
    @Test
    public void testIntegradorValoresDePuntajeDeberianSerChorentesConLosEsperados() throws MovimientoInvalidoExcepcion, PasajeBloqueadoPorPiqueteExcepcion{
    	Tablero tablero = new Tablero(3,3);
    	Vehiculo vehiculo = new VehiculoAuto(new Vector(0,0));
    	vehiculo.setCantidadDeMovimientos(0);
    	Vector posicionGanadora = new Vector(2,2);
    	
        Direccion norte = new Direccion(0, 1);
        Direccion sur = new Direccion(0, -1);
        Direccion este = new Direccion(1, 0);
        Direccion oeste = new Direccion(-1, 0);
    	    	
    	Calle calleSurDePosicionUnoCero = tablero.getBocacalleEnPosicion(new Vector(1,0)).obtenerCalleEnDireccion(sur);
    	calleSurDePosicionUnoCero.setSorpresa(new SorpresaCambioDeVehiculo());
    	Calle calleOesteDePosicionUnoUno = tablero.getBocacalleEnPosicion(new Vector(1,0)).obtenerCalleEnDireccion(oeste);
    	calleOesteDePosicionUnoUno.setObstaculo(new ObstaculoPozo());
    	Calle calleEsteDePosicionUnoUno = tablero.getBocacalleEnPosicion(new Vector(1,0)).obtenerCalleEnDireccion(este);
    	calleEsteDePosicionUnoUno.setSorpresa(new SorpresaDesfavorable());
    	
    	Juego nuevoJuego = new Juego(tablero,vehiculo,posicionGanadora);
    	nuevoJuego.realizarJugadaEnDireccion(norte);
    	nuevoJuego.realizarJugadaEnDireccion(este);
    	nuevoJuego.realizarJugadaEnDireccion(este);
    	nuevoJuego.realizarJugadaEnDireccion(norte);
    	assertEquals(nuevoJuego.getVehiculo().getCantidadDeMovimientos(),4);
    	assertEquals(nuevoJuego.getVehiculo().getPosicion().asString(),"2,2");
    	
    }
    
}
