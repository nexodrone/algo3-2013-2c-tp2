package modeloTests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import modelo.Calle;
import modelo.Direccion;
import modelo.Juego;
import modelo.ObstaculoPiquete;
import modelo.ObstaculoPozo;
import modelo.Partida;
import modelo.Posicion;
import modelo.Puntaje;
import modelo.SorpresaCambioDeVehiculo;
import modelo.SorpresaDesfavorable;
import modelo.SorpresaFavorable;
import modelo.Tablero;
import modelo.Vehiculo;
import modelo.Vehiculo4x4;
import modelo.VehiculoAuto;
import modelo.VehiculoMoto;
import modelo.excepciones.MovimientoInvalidoExcepcion;
import modelo.excepciones.PasajeBloqueadoPorPiqueteExcepcion;

import org.junit.Test;

public class JuegoTest {
//
//    @Test
//    public void testDeberiaCrearJuego() {
//        Tablero tablero = new Tablero(10, 10);
//        Vehiculo vehiculo = new VehiculoAuto(new Posicion(0, 0));
//        Posicion posicionGanadora = new Posicion(6, 10);
//        int cantidadDeMovimientos = 10;
//        Juego unJuego = new Juego(tablero, vehiculo, posicionGanadora,cantidadDeMovimientos);
//        assertNotNull(unJuego);
//    }
	
    @Test // ACTUALIZADO 23/11
    public void testDeberiaCrearJuego() {
        Tablero tablero = new Tablero(10, 10);
        Vehiculo vehiculo = new VehiculoAuto(new Posicion(0, 0));
        Posicion posicionGanadora = new Posicion(6, 10);
        int cantidadDeMovimientos = 10;
        Partida unaPartida = new Partida(tablero, vehiculo, posicionGanadora,cantidadDeMovimientos);
        Juego unJuego = new Juego(unaPartida, cantidadDeMovimientos, "unJugador");
        assertNotNull(unJuego);
    }

//    @Test
//    public void testVehiculoDeberiaMoversePorLimitesDelTablero() throws MovimientoInvalidoExcepcion, PasajeBloqueadoPorPiqueteExcepcion {
//        Tablero tablero = new Tablero(6, 3);
//        Vehiculo vehiculo = new VehiculoAuto(new Posicion(4, 0));
//        int cantidadDeMovimientos = 10;
//        Juego unJuego = new Juego(tablero, vehiculo, new Posicion(0, 0),cantidadDeMovimientos);
//        Direccion norte = new Direccion(0, 1);
//        Direccion este = new Direccion(1, 0);
//        Direccion oeste = new Direccion(-1, 0);
//        try {
//            unJuego.realizarJugadaEnDireccion(este);
//            unJuego.realizarJugadaEnDireccion(norte);
//            unJuego.realizarJugadaEnDireccion(norte);
//            unJuego.realizarJugadaEnDireccion(oeste);
//        } catch (MovimientoInvalidoExcepcion e) {
//        };
//        assertEquals(unJuego.getVehiculo().getPosicion().asString(), "4,2");
//    }

    @Test // ACTUALIZADO 23/11
    public void testVehiculoDeberiaMoversePorLimitesDelTablero() throws MovimientoInvalidoExcepcion, PasajeBloqueadoPorPiqueteExcepcion {
        Tablero tablero = new Tablero(6, 3);
        Vehiculo vehiculo = new VehiculoAuto(new Posicion(4, 0));
        int cantidadDeMovimientos = 10;
        Partida unaPartida = new Partida(tablero, vehiculo, new Posicion(0, 0),cantidadDeMovimientos);
        
        Juego unJuego = new Juego(unaPartida,cantidadDeMovimientos, "unJugador");
        Direccion norte = new Direccion(0, 1);
        Direccion este = new Direccion(1, 0);
        Direccion oeste = new Direccion(-1, 0);
        try {
            unJuego.realizarJugadaEnDireccion__NUEVO(este);
            unJuego.realizarJugadaEnDireccion__NUEVO(norte);
            unJuego.realizarJugadaEnDireccion__NUEVO(norte);
            unJuego.realizarJugadaEnDireccion__NUEVO(oeste);
        } catch (MovimientoInvalidoExcepcion e) {};
        
        assertEquals(unJuego.getPartida().getVehiculo().getPosicion().asString(), "4,2");
    }
    
//    @Test
//    public void testDeberiaTirarExcepcionAlMoverseFueraDelTablero() throws MovimientoInvalidoExcepcion, PasajeBloqueadoPorPiqueteExcepcion {
//        Tablero tablero = new Tablero(6, 3);
//        Vehiculo vehiculo = new VehiculoAuto(new Posicion(4, 0));
//        vehiculo.setCantidadDeMovimientos(1);
//        int cantidadDeMovimientos = 10;
//        Juego unJuego = new Juego(tablero, vehiculo, new Posicion(0, 0),cantidadDeMovimientos);
//        Direccion sur = new Direccion(0, -1);
//        try {
//            unJuego.realizarJugadaEnDireccion(sur);
//            fail("Excepcion esperada");
//        } catch (MovimientoInvalidoExcepcion esperada) {
//        };
//        assertEquals(unJuego.getVehiculo().getCantidadDeMovimientos(), 1);
//        /* Se comprueba que la cantidad de movimientos no se cambio */
//    }
    
    @Test // ACTUALIZADO 23/11
    public void testDeberiaTirarExcepcionAlMoverseFueraDelTablero() throws MovimientoInvalidoExcepcion, PasajeBloqueadoPorPiqueteExcepcion {
        Tablero tablero = new Tablero(6, 3);
        Vehiculo vehiculo = new VehiculoAuto(new Posicion(4, 0));
        vehiculo.setCantidadDeMovimientos(1);
        int cantidadDeMovimientos = 10;
        Partida unaPartida = new Partida(tablero, vehiculo, new Posicion(0,0), cantidadDeMovimientos);
        
        Juego unJuego = new Juego(unaPartida, cantidadDeMovimientos, "Rober");
        Direccion sur = new Direccion(0, -1);
        try {
            unJuego.realizarJugadaEnDireccion__NUEVO(sur);
            fail("Excepcion esperada");
        } catch (MovimientoInvalidoExcepcion esperada) {
        };
        assertEquals(unJuego.getPartida().getVehiculo().getCantidadDeMovimientos(), 1);
        /* Se comprueba que la cantidad de movimientos no se cambio */
    }

    // ESTE VA A SER UN TEST INTEGRADOR
    @Test
    public void testIntegradorValoresDePuntajeDeberianSerCoherentesConLosEsperados() throws MovimientoInvalidoExcepcion, PasajeBloqueadoPorPiqueteExcepcion {
        Tablero tablero = new Tablero(3, 3);
        Vehiculo vehiculo = new VehiculoAuto(new Posicion(0, 0));
        vehiculo.setCantidadDeMovimientos(0);
        Posicion posicionGanadora = new Posicion(2, 2);
        int cantidadDeMovimientos = 100;

        Direccion norte = new Direccion(0, 1);
        Direccion sur = new Direccion(0, -1);
        Direccion este = new Direccion(1, 0);
        Direccion oeste = new Direccion(-1, 0);

        Calle calleSurDePosicionUnoCero = tablero.getBocacalleEnPosicion(new Posicion(1, 0)).getCalleEnDireccion(sur);
        calleSurDePosicionUnoCero.setSorpresa(new SorpresaCambioDeVehiculo());
        Calle calleOesteDePosicionUnoUno = tablero.getBocacalleEnPosicion(new Posicion(1, 0)).getCalleEnDireccion(oeste);
        calleOesteDePosicionUnoUno.setObstaculo(new ObstaculoPozo());
        Calle calleEsteDePosicionUnoUno = tablero.getBocacalleEnPosicion(new Posicion(1, 0)).getCalleEnDireccion(este);
        calleEsteDePosicionUnoUno.setSorpresa(new SorpresaDesfavorable());

        Juego nuevoJuego = new Juego(tablero, vehiculo, posicionGanadora,cantidadDeMovimientos);
        nuevoJuego.realizarJugadaEnDireccion(norte);
        nuevoJuego.realizarJugadaEnDireccion(este);
        nuevoJuego.realizarJugadaEnDireccion(este);
        nuevoJuego.realizarJugadaEnDireccion(norte);
        assertEquals(nuevoJuego.getVehiculo().getCantidadDeMovimientos(), 4);
        assertEquals(nuevoJuego.getVehiculo().getPosicion().asString(), "2,2");

    }

    // SEGUNDO TESTS DE INTEGRACION, LA IDEA GRAFICA DEL MOVIMIENTO ESTA ADJUNTADA EN .docs COMO
    // SEGUNDA PRUEBA DE INTEGRACION
    @Test
    public void testObstaculosYSorpresasDebenSerAplicadosDeFormaCoherente() throws PasajeBloqueadoPorPiqueteExcepcion, MovimientoInvalidoExcepcion {
        Tablero tablero = new Tablero(5, 4);
        Vehiculo vehiculo = new VehiculoMoto(new Posicion(1, 1));
        vehiculo.setCantidadDeMovimientos(0);
        Posicion posicionGanadora = new Posicion(0, 3);
        int cantidadDeMovimientos = 100;

        Direccion norte = new Direccion(0, 1);
        Direccion sur = new Direccion(0, -1);
        Direccion este = new Direccion(1, 0);
        Direccion oeste = new Direccion(-1, 0);

        Calle calleEsteDePosicionUnoUno = tablero.getBocacalleEnPosicion(new Posicion(1, 1)).getCalleEnDireccion(este);
        calleEsteDePosicionUnoUno.setObstaculo(new ObstaculoPiquete());
        Calle calleEsteDePosicionUnoDos = tablero.getBocacalleEnPosicion(new Posicion(1, 2)).getCalleEnDireccion(este);
        calleEsteDePosicionUnoDos.setSorpresa(new SorpresaFavorable());
        Calle calleNorteDePosicionUnoTres = tablero.getBocacalleEnPosicion(new Posicion(1, 3)).getCalleEnDireccion(norte);
        calleNorteDePosicionUnoTres.setSorpresa(new SorpresaCambioDeVehiculo());
        Calle calleOesteDePosicionTresTres = tablero.getBocacalleEnPosicion(new Posicion(3, 3)).getCalleEnDireccion(oeste);
        calleOesteDePosicionTresTres.setSorpresa(new SorpresaDesfavorable());

        Juego nuevoJuego = new Juego(tablero, vehiculo, posicionGanadora,cantidadDeMovimientos);

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
        assertEquals(nuevoJuego.getVehiculo().getCantidadDeMovimientos(), 13);
    }

    /* Test de integracion
    @Test
    public void testJegoCompleto() throws MovimientoInvalidoExcepcion, PasajeBloqueadoPorPiqueteExcepcion {
		Jugador Pepe = new Jugador("Pepe");
		Tablero tablero = new Tablero(4,6);
		Vehiculo vehiculo = new VehiculoAuto(new Posicion(0,0));
		vehiculo.setCantidadDeMovimientos(0);
		int cantidadDeMovimientos = 100;
		Juego unJuego = new Juego(tablero, vehiculo, new Posicion(0,0),cantidadDeMovimientos);
		vehiculo.setJuegoActual(unJuego);
		unJuego.setPosicionGanadora(new Posicion(3,4));
		
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
		assertTrue(vehiculo.getPosicion().equals(new Posicion(3,4)));
		assertEquals(vehiculo.getCantidadDeMovimientos(),14);
    }  */
    
    // Se puede hacer mas corto esta prueba?
    // Es muy largo y muy poco entendible

    // TESTS DE METODOS

    @Test
    public void testParaComprobarQueCambiaCorrectamenteElVehiculo() {
        int cantidadFilas = 6;
        int cantidadColumnas = 7;
        Tablero tablero = new Tablero(cantidadColumnas, cantidadFilas);

        Vehiculo vehiculo = new Vehiculo4x4(null); // Es irrelevante la posicion para esta prueba

        Posicion posicionGanadora = new Posicion(0, 0);
        
        int cantidadDeMovimientos = 10;

        Juego juego = new Juego(tablero, vehiculo, posicionGanadora,cantidadDeMovimientos);

        Vehiculo nuevoVehiculo = new VehiculoAuto(null);

        juego.cambiarVehiculo(nuevoVehiculo);

        assertEquals(juego.getVehiculo(), nuevoVehiculo);
    }

    @Test
    public void testParaComprobarQueDevuelveCorrectamenteElVehiculo() {
        Vehiculo vehiculo = new Vehiculo4x4(null);
        int cantidadDeMovimientos = 10;
        Juego juego = new Juego(null, vehiculo, null,cantidadDeMovimientos);

        assertEquals(juego.getVehiculo(), vehiculo);
    }

    @Test
    public void testGuardarYCargarCorrectamenteJuego () throws Exception {
    	Tablero unTablero = new Tablero(4, 4);
    	VehiculoMoto unVehiculo = new VehiculoMoto(new Posicion(2,3));
    	unVehiculo.setCantidadDeMovimientos(34);
    	
    	Posicion posicionGanadora = new Posicion(1,2);
    	int cantidadDeMovimientos = 10;
    	Juego unJuego = new Juego(unTablero, unVehiculo, posicionGanadora,cantidadDeMovimientos);
    	
    	unJuego.guardar("test/juegoTest.xml");
    	
    	Juego otroJuego = Juego.recuperar("test/juegoTest.xml");
    	
    	assertEquals(otroJuego.getVehiculo().getCantidadDeMovimientos(), unVehiculo.getCantidadDeMovimientos());
    	assertEquals(otroJuego.getPosicionGanadora().asString(), posicionGanadora.asString());
    }
    
    @Test
    public void testGuardarPuntajes() throws Exception {
    	int cantidadDeMovimientos = 10;
    	Juego unJuego = new Juego(null, null, null,cantidadDeMovimientos);
    	unJuego.guardarPuntaje("Chango" , 45);
    	unJuego.guardarPuntaje("Matori", 32);
    	unJuego.guardarPuntaje("Jedi", 77);
    	unJuego.guardarPuntaje("Ciriaso", 10);
    	unJuego.guardarPuntaje("Carolo", 10);
    	
    	unJuego.guardarPuntajes("test/puntajesTest.xml");
    	
    	Juego otroJuego = new Juego(null, null, null,cantidadDeMovimientos);
    	otroJuego.cargarPuntajes("test/puntajesTest.xml");
    	
    	ArrayList<Puntaje> puntajesOrdenados =
    			( otroJuego.getPuntajesOrdenados() );
    	
    	assertEquals(puntajesOrdenados.get(0).getPuntaje(), 77);
    	assertEquals(puntajesOrdenados.get(1).getPuntaje(), 45);
    	assertEquals(puntajesOrdenados.get(2).getPuntaje(), 32);
    	assertEquals(puntajesOrdenados.get(3).getPuntaje(), 10);
    	assertEquals(puntajesOrdenados.get(4).getPuntaje(), 10);		
    }
}
