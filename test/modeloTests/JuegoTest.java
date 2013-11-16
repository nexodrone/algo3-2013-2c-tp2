package modeloTests;

import static org.junit.Assert.*;
import modelo.Calle;
import modelo.Direccion;
import modelo.Juego;
import modelo.ObstaculoPiquete;
import modelo.ObstaculoPozo;
import modelo.Posicion;
import modelo.SorpresaCambioDeVehiculo;
import modelo.SorpresaDesfavorable;
import modelo.SorpresaFavorable;
import modelo.Tablero;
import modelo.Vehiculo;
import modelo.VehiculoAuto;
import modelo.VehiculoMoto;
import modelo.excepciones.MovimientoInvalidoExcepcion;
import modelo.excepciones.PasajeBloqueadoPorPiqueteExcepcion;

import org.junit.Test;

public class JuegoTest {


	@Test
	public void testDeberiaCrearJuego() {
		Tablero tablero = new Tablero(10,10);
		Vehiculo vehiculo = new VehiculoAuto(new Posicion(0,0));
		Posicion posicionGanadora = new Posicion(6,10);
		Juego unJuego = new Juego(tablero, vehiculo, posicionGanadora);
		assertNotNull(unJuego);
	}
    @Test
    public void testVehiculoDeberiaMoversePorLimitesDelTablero() throws MovimientoInvalidoExcepcion, PasajeBloqueadoPorPiqueteExcepcion{
		Tablero tablero = new Tablero(6,3);
		Vehiculo vehiculo = new VehiculoAuto(new Posicion(4,0));
		Juego unJuego = new Juego(tablero, vehiculo, new Posicion(0,0));
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
		Vehiculo vehiculo = new VehiculoAuto(new Posicion(4,0));
		vehiculo.setCantidadDeMovimientos(1);
		Juego unJuego = new Juego(tablero, vehiculo, new Posicion(0,0));
        Direccion sur = new Direccion(0, -1);
    	try {	unJuego.realizarJugadaEnDireccion(sur);
    			fail("Excepcion esperada");		
    		} catch (MovimientoInvalidoExcepcion esperada) {};
        assertEquals(unJuego.getVehiculo().getCantidadDeMovimientos(), 1);
        /* Se comprueba que la cantidad de movimientos no se cambio */
    }
 
    
    //ESTE VA A SER UN TEST INTEGRADOR
    @Test
    public void testIntegradorValoresDePuntajeDeberianSerCoherentesConLosEsperados() throws MovimientoInvalidoExcepcion, PasajeBloqueadoPorPiqueteExcepcion{
    	Tablero tablero = new Tablero(3,3);
    	Vehiculo vehiculo = new VehiculoAuto(new Posicion(0,0));
    	vehiculo.setCantidadDeMovimientos(0);
    	Posicion posicionGanadora = new Posicion(2,2);
    	
        Direccion norte = new Direccion(0, 1);
        Direccion sur = new Direccion(0, -1);
        Direccion este = new Direccion(1, 0);
        Direccion oeste = new Direccion(-1, 0);
    	    	
    	Calle calleSurDePosicionUnoCero = tablero.getBocacalleEnPosicion(new Posicion(1,0)).getCalleEnDireccion(sur);
    	calleSurDePosicionUnoCero.setSorpresa(new SorpresaCambioDeVehiculo());
    	Calle calleOesteDePosicionUnoUno = tablero.getBocacalleEnPosicion(new Posicion(1,0)).getCalleEnDireccion(oeste);
    	calleOesteDePosicionUnoUno.setObstaculo(new ObstaculoPozo());
    	Calle calleEsteDePosicionUnoUno = tablero.getBocacalleEnPosicion(new Posicion(1,0)).getCalleEnDireccion(este);
    	calleEsteDePosicionUnoUno.setSorpresa(new SorpresaDesfavorable());
    	
    	Juego nuevoJuego = new Juego(tablero,vehiculo,posicionGanadora);
    	nuevoJuego.realizarJugadaEnDireccion(norte);
    	nuevoJuego.realizarJugadaEnDireccion(este);
    	nuevoJuego.realizarJugadaEnDireccion(este);
    	nuevoJuego.realizarJugadaEnDireccion(norte);
    	assertEquals(nuevoJuego.getVehiculo().getCantidadDeMovimientos(),4);
    	assertEquals(nuevoJuego.getVehiculo().getPosicion().asString(),"2,2");
    	
    }
    
    @Test
    public void testObstaculosYSorpresasDebenSerAplicadosDeFormaCoherente() throws PasajeBloqueadoPorPiqueteExcepcion, MovimientoInvalidoExcepcion{
    	Tablero tablero = new Tablero(5,4);
    	Vehiculo vehiculo = new VehiculoMoto(new Posicion(1,1));
    	vehiculo.setCantidadDeMovimientos(0);
    	Posicion posicionGanadora = new Posicion(0,3);
    	
    	Direccion norte = new Direccion(0, 1);
    	Direccion sur = new Direccion(0, -1);
        Direccion este = new Direccion(1, 0);
        Direccion oeste = new Direccion(-1, 0);
    
        Calle calleEsteDePosicionUnoUno = tablero.getBocacalleEnPosicion(new Posicion(1,1)).getCalleEnDireccion(este);
        calleEsteDePosicionUnoUno.setObstaculo(new ObstaculoPiquete());
        Calle calleEsteDePosicionUnoDos = tablero.getBocacalleEnPosicion(new Posicion(1,2)).getCalleEnDireccion(este);
        calleEsteDePosicionUnoDos.setSorpresa(new SorpresaFavorable());
        Calle calleNorteDePosicionUnoTres = tablero.getBocacalleEnPosicion(new Posicion(1,3)).getCalleEnDireccion(norte);
        calleNorteDePosicionUnoTres.setSorpresa(new SorpresaCambioDeVehiculo());
        Calle calleOesteDePosicionTresTres = tablero.getBocacalleEnPosicion(new Posicion(3,3)).getCalleEnDireccion(oeste);
        calleOesteDePosicionTresTres.setSorpresa(new SorpresaDesfavorable());
        
        Juego nuevoJuego = new Juego(tablero,vehiculo,posicionGanadora);
        
        nuevoJuego.realizarJugadaEnDireccion(este);
        nuevoJuego.realizarJugadaEnDireccion(este);
        nuevoJuego.realizarJugadaEnDireccion(norte);
        nuevoJuego.realizarJugadaEnDireccion(norte);
        nuevoJuego.realizarJugadaEnDireccion(oeste);
        nuevoJuego.realizarJugadaEnDireccion(este);
        nuevoJuego.realizarJugadaEnDireccion(sur);
        nuevoJuego.realizarJugadaEnDireccion(oeste);
        nuevoJuego.realizarJugadaEnDireccion(oeste);
        nuevoJuego.realizarJugadaEnDireccion(norte);
        nuevoJuego.realizarJugadaEnDireccion(oeste);
        assertEquals(nuevoJuego.getVehiculo().getCantidadDeMovimientos(),13);
    }
    
    
    
    
}
