package modeloTests;

import static org.junit.Assert.*;
import modelo.Direccion;
import modelo.Juego;
import modelo.Jugador;
import modelo.ObstaculoPiquete;
import modelo.ObstaculoPozo;
import modelo.SorpresaDesfavorable;
import modelo.SorpresaFavorable;
import modelo.Tablero;
import modelo.Posicion;
import modelo.Vehiculo;
import modelo.VehiculoAuto;
import modelo.excepciones.MovimientoInvalidoExcepcion;
import modelo.excepciones.PasajeBloqueadoPorPiqueteExcepcion;

import org.junit.Test;

public class JugadorTest {

	@Test
	public void testJugadorNuevoNoDebeSerNulo() {
		Jugador unJugador = new Jugador("Pepe");
		assertNotNull(unJugador);
	}
	
    @Test
    public void testDeberiaDevolverNombre() {
        Jugador unJugador = new Jugador("Juansito");
        assertEquals(unJugador.getNickName(),"Juansito");
    }

    @Test
    public void testJugadorDebePoderEntrarEnJuego() {
        Jugador unJugador = new Jugador("Juansito");
        unJugador.asignarJuego(new Juego(new Tablero(5,5), new VehiculoAuto(new Posicion(0,0)), new Posicion(3,5)));
        assertNotNull(unJugador.getJuegoActual());
    }
    
    @Test
    public void testJugadorDebePoderJugar() throws MovimientoInvalidoExcepcion, PasajeBloqueadoPorPiqueteExcepcion {
        Jugador unJugador = new Jugador("Juansito");
        Direccion norte = new Direccion(0,1);
        Vehiculo vehiculo = new VehiculoAuto(new Posicion(0,1));
        unJugador.asignarJuego(new Juego(new Tablero(5,5), vehiculo, new Posicion(3,5)));
        unJugador.jugar(norte);
        assertEquals(vehiculo.getPosicion().asString(),"0,2");
    }
    
   
    @Test
    public void testJugadorNoDeberiaPoderMoverseFueraDelRangoDelVehiculo() throws PasajeBloqueadoPorPiqueteExcepcion, MovimientoInvalidoExcepcion{
    	Jugador unJugador = new Jugador("Juansito");
        Vehiculo vehiculo = new VehiculoAuto(new Posicion(0,0));
        unJugador.asignarJuego(new Juego(new Tablero(5,5), vehiculo, new Posicion(3,5)));
        Direccion oeste = new Direccion(-1, 0);
        unJugador.jugar(oeste);
        assertEquals(vehiculo.getPosicion().asString(),"0,0");
    }
     
    
    
    /* Test de integracion */
    @Test
    public void testJugadaCompleta() throws MovimientoInvalidoExcepcion, PasajeBloqueadoPorPiqueteExcepcion {
		Jugador Pepe = new Jugador("Pepe");
		Tablero tablero = new Tablero(4,6);
		Vehiculo vehiculo = new VehiculoAuto(new Posicion(0,0));
		vehiculo.setCantidadDeMovimientos(0);
		Juego unJuego = new Juego(tablero, vehiculo, new Posicion(0,0));
		vehiculo.setJuegoActual(unJuego);
		unJuego.setPosicionGanadora(new Posicion(4,4));
		
        Direccion norte = new Direccion(0, 1);
        Direccion sur = new Direccion(0, -1);
        Direccion este = new Direccion(1, 0);
        Direccion oeste = new Direccion(-1, 0);
		
		tablero.getBocacalleEnPosicion(new Posicion(1,0)).getCalleEnDireccion(norte).setObstaculo(new ObstaculoPiquete());
		tablero.getBocacalleEnPosicion(new Posicion(2,3)).getCalleEnDireccion(sur).setObstaculo(new ObstaculoPozo());
		tablero.getBocacalleEnPosicion(new Posicion(1,4)).getCalleEnDireccion(este).setSorpresa(new SorpresaDesfavorable());
		tablero.getBocacalleEnPosicion(new Posicion(3,4)).getCalleEnDireccion(oeste).setSorpresa(new SorpresaFavorable());
		
		Pepe.asignarJuego(unJuego);
		Pepe.jugar(este);
		Pepe.jugar(norte);
		assertEquals(vehiculo.getCantidadDeMovimientos(),1);
		
		Pepe.jugar(este);
		Pepe.jugar(este);
		Pepe.jugar(norte);
		assertTrue(vehiculo.getPosicion().equals(new Posicion(3,1)));
		assertEquals(vehiculo.getCantidadDeMovimientos(),4);
		Pepe.jugar(norte);
		Pepe.jugar(oeste);
		Pepe.jugar(norte);
		assertEquals(vehiculo.getCantidadDeMovimientos(),10);
		Pepe.jugar(norte);
		Pepe.jugar(oeste);
		Pepe.jugar(este);
		assertEquals(vehiculo.getCantidadDeMovimientos(),16);
		assertTrue(vehiculo.getPosicion().equals(new Posicion(2,4)));
		Pepe.jugar(este);
		Pepe.jugar(este);
		assertTrue(vehiculo.getPosicion().equals(new Posicion(4,4)));
		assertEquals(vehiculo.getCantidadDeMovimientos(),15);
    }
    
}
