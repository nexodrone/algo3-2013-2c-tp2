package modeloTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import modelo.Calle;
import modelo.Direccion;
import modelo.Juego;
import modelo.Jugador;
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
import modelo.excepciones.CalleBloqueadaPorPiqueteExcepcion;

import org.junit.Test;

public class JuegoTest {

    @Test
    public void testDeberiaCrearJuego() {
        Juego unJuego = new Juego();
        assertNotNull(unJuego);
    }

    // TEST DE METODOS

    @Test
    public void testParaComprobarQueElVehiculoEsElMismoQueElDeLaPartida() {
        Juego juego = new Juego();
        Vehiculo vehiculo = new VehiculoMoto();
        Partida partida = new Partida();
        partida.setVehiculo(vehiculo);
        juego.setPartida(partida);

        assertEquals(juego.getVehiculo(), partida.getVehiculo());

    }

    public void testParaComprobarQueCambiaCorrectamenteElJugador() {
        Jugador jugador = new Jugador();
        Juego juego = new Juego();
        juego.setJugador(jugador);

        assertEquals(juego.getJugadorActual(), jugador);

    }

    @Test
    public void testVehiculoDeberiaMoversePorLimitesDelTablero() throws MovimientoInvalidoExcepcion {
        Tablero tablero = new Tablero(6, 3);
        Vehiculo vehiculo = new VehiculoAuto(new Posicion(4, 0));
        int cantidadDeMovimientos = 10;
        Partida unaPartida = new Partida(tablero, vehiculo, new Posicion(0, 0), cantidadDeMovimientos);

        Juego unJuego = new Juego();
        unJuego.setPartida(unaPartida);

        Direccion norte = new Direccion(0, 1);
        Direccion este = new Direccion(1, 0);
        Direccion oeste = new Direccion(-1, 0);

        try {
            unJuego.realizarJugadaEnDireccion(este);
            unJuego.realizarJugadaEnDireccion(norte);
            unJuego.realizarJugadaEnDireccion(norte);
            unJuego.realizarJugadaEnDireccion(oeste);
        } catch (MovimientoInvalidoExcepcion e) {
        };

        assertEquals(unJuego.getPartida().getVehiculo().getPosicion().asString(), "4,2");
    }

    @Test
    public void testDeberiaTirarExcepcionAlMoverseFueraDelTablero() throws MovimientoInvalidoExcepcion {
        Tablero tablero = new Tablero(6, 3);
        Vehiculo vehiculo = new VehiculoAuto(new Posicion(4, 0));
        vehiculo.setCantidadDeMovimientos(6);
        Partida unaPartida = new Partida(tablero, vehiculo, new Posicion(0, 0), 10);
        Juego unJuego = new Juego();
        unJuego.setPartida(unaPartida);

        Direccion sur = new Direccion(0, -1);
        try {
            unJuego.realizarJugadaEnDireccion(sur);
            fail("Excepcion esperada");
        } catch (MovimientoInvalidoExcepcion esperada) {
        };

        assertEquals(vehiculo.getCantidadDeMovimientos(), 6);
        /* Se comprueba que la cantidad de movimientos no se cambio */
    }

    /* Test integrador */
    @Test
    public void testIntegradorValoresDePuntajeDeberianSerCoherentesConLosEsperados() throws MovimientoInvalidoExcepcion, CalleBloqueadaPorPiqueteExcepcion {
        Tablero tablero = new Tablero(3, 3);
        Vehiculo vehiculo = new VehiculoAuto(new Posicion(0, 0));
        vehiculo.setCantidadDeMovimientos(0);
        Posicion posicionGanadora = new Posicion(2, 2);
        int movimientosDisponibles = 100;

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

        Partida unaPartida = new Partida(tablero, vehiculo, posicionGanadora, movimientosDisponibles);
        Juego unJuego = new Juego();
        unJuego.setPartida(unaPartida);

        unJuego.realizarJugadaEnDireccion(norte);
        unJuego.realizarJugadaEnDireccion(este);
        unJuego.realizarJugadaEnDireccion(este);
        unJuego.realizarJugadaEnDireccion(norte);
        assertEquals(unJuego.getPartida().getVehiculo().getCantidadDeMovimientos(), 4);
        assertEquals(unJuego.getPartida().getVehiculo().getPosicion().asString(), "2,2");

    }

    /* Test integrador */
    @Test
    public void testObstaculosYSorpresasDebenSerAplicadosDeFormaCoherente() throws MovimientoInvalidoExcepcion {
        Tablero tablero = new Tablero(5, 4);
        Vehiculo moto = new VehiculoMoto(new Posicion(1, 1));
        moto.setCantidadDeMovimientos(0);
        Posicion posicionGanadora = new Posicion(0, 3);
        int movimientosDisponibles = 100;

        Direccion norte = new Direccion(0, 1);
        Direccion sur = new Direccion(0, -1);
        Direccion este = new Direccion(1, 0);
        Direccion oeste = new Direccion(-1, 0);

		tablero.getBocacalleEnPosicion(new Posicion(1,1)).getCalleEnDireccion(este).setObstaculo(new ObstaculoPiquete());
		tablero.getBocacalleEnPosicion(new Posicion(2,1)).getCalleEnDireccion(este).setSorpresa(new SorpresaFavorable());
		tablero.getBocacalleEnPosicion(new Posicion(3,1)).getCalleEnDireccion(norte).setSorpresa(new SorpresaCambioDeVehiculo());
		tablero.getBocacalleEnPosicion(new Posicion(3,3)).getCalleEnDireccion(oeste).setSorpresa(new SorpresaDesfavorable());
        
        Juego unJuego = new Juego();
        moto.setJuegoActual(unJuego);
        Partida unaPartida = new Partida(tablero, moto, posicionGanadora, movimientosDisponibles);
        unJuego.setPartida(unaPartida);

        unJuego.realizarJugadaEnDireccion(este);
        unJuego.realizarJugadaEnDireccion(este);
        unJuego.realizarJugadaEnDireccion(norte);
        unJuego.realizarJugadaEnDireccion(norte);
        unJuego.realizarJugadaEnDireccion(oeste);
        unJuego.realizarJugadaEnDireccion(este);
        unJuego.realizarJugadaEnDireccion(sur);
        unJuego.realizarJugadaEnDireccion(oeste);
        unJuego.realizarJugadaEnDireccion(oeste);
        unJuego.realizarJugadaEnDireccion(norte);
        unJuego.realizarJugadaEnDireccion(oeste);
        assertEquals(unJuego.getPartida().getVehiculo().getCantidadDeMovimientos(), 13);
		assertTrue(unJuego.getPartida().getVehiculo().getPosicion().equals(new Posicion(0,3)));
		assertEquals(unJuego.getPartida().getVehiculo().getClass(), (new VehiculoAuto()).getClass());
    }

    /* Test integrador */
    @Test
    public void testJegoCompletoGanancia() throws MovimientoInvalidoExcepcion {
		Tablero tablero = new Tablero(4,6);
		Vehiculo vehiculo = new VehiculoAuto(new Posicion(0,0));
		vehiculo.setCantidadDeMovimientos(0);
		Posicion posicionGanadora = new Posicion(3,4);
		int movimientosDisponibles = 100;
		
		Partida unaPartida = new Partida(tablero, vehiculo, posicionGanadora, movimientosDisponibles);
		
		Juego unJuego = new Juego();
		unJuego.setPartida(unaPartida);
		vehiculo.setJuegoActual(unJuego);
		
        Direccion norte = new Direccion(0, 1);
        Direccion sur = new Direccion(0, -1);
        Direccion este = new Direccion(1, 0);
        Direccion oeste = new Direccion(-1, 0);
		
		tablero.getBocacalleEnPosicion(new Posicion(1,0)).getCalleEnDireccion(norte).setObstaculo(new ObstaculoPiquete());
		tablero.getBocacalleEnPosicion(new Posicion(2,3)).getCalleEnDireccion(sur).setObstaculo(new ObstaculoPozo());
		tablero.getBocacalleEnPosicion(new Posicion(1,4)).getCalleEnDireccion(este).setSorpresa(new SorpresaDesfavorable());
		tablero.getBocacalleEnPosicion(new Posicion(3,4)).getCalleEnDireccion(oeste).setSorpresa(new SorpresaFavorable());

		unJuego.realizarJugadaEnDireccion(este);
		unJuego.realizarJugadaEnDireccion(norte);
		assertEquals(vehiculo.getCantidadDeMovimientos(),1);
		
		unJuego.realizarJugadaEnDireccion(este);
		unJuego.realizarJugadaEnDireccion(este);
		unJuego.realizarJugadaEnDireccion(norte);
		assertTrue(vehiculo.getPosicion().equals(new Posicion(3,1)));
		assertEquals(vehiculo.getCantidadDeMovimientos(),4);
		unJuego.realizarJugadaEnDireccion(norte);
		unJuego.realizarJugadaEnDireccion(oeste);
		unJuego.realizarJugadaEnDireccion(norte);
		assertEquals(vehiculo.getCantidadDeMovimientos(),10);
		unJuego.realizarJugadaEnDireccion(norte);
		unJuego.realizarJugadaEnDireccion(oeste);
		unJuego.realizarJugadaEnDireccion(este);
		assertEquals(vehiculo.getCantidadDeMovimientos(),16);
		assertTrue(vehiculo.getPosicion().equals(new Posicion(2,4)));
		unJuego.realizarJugadaEnDireccion(este);
		assertTrue(vehiculo.getPosicion().equals(new Posicion(3,4)));
		assertEquals(vehiculo.getCantidadDeMovimientos(),14);
    }
    
    /* Test integrador */
    @Test
    public void testJegoCompletoPerdida() throws MovimientoInvalidoExcepcion {
		Tablero tablero = new Tablero(5,3);
		Vehiculo4x4 vehiculo = new Vehiculo4x4(new Posicion(4,2));
		vehiculo.setCantidadDeMovimientos(0);
		Posicion posicionGanadora = new Posicion(0,0);
		int movimientosDisponibles = 10;
		
		Partida unaPartida = new Partida(tablero, vehiculo, posicionGanadora, movimientosDisponibles);
		
		Juego unJuego = new Juego();
		unJuego.setPartida(unaPartida);
		vehiculo.setJuegoActual(unJuego);
		
        Direccion norte = new Direccion(0, 1);
        Direccion sur = new Direccion(0, -1);
        Direccion oeste = new Direccion(-1, 0);
		
		tablero.getBocacalleEnPosicion(new Posicion(3,0)).getCalleEnDireccion(norte).setObstaculo(new ObstaculoPiquete());
		tablero.getBocacalleEnPosicion(new Posicion(2,0)).getCalleEnDireccion(norte).setObstaculo(new ObstaculoPiquete());
		tablero.getBocacalleEnPosicion(new Posicion(4,1)).getCalleEnDireccion(norte).setObstaculo(new ObstaculoPozo());
		tablero.getBocacalleEnPosicion(new Posicion(1,0)).getCalleEnDireccion(norte).setSorpresa(new SorpresaDesfavorable());
		tablero.getBocacalleEnPosicion(new Posicion(3,0)).getCalleEnDireccion(oeste).setSorpresa(new SorpresaFavorable());
		tablero.getBocacalleEnPosicion(new Posicion(3,0)).getCalleEnDireccion(norte).setSorpresa(new SorpresaFavorable());
		tablero.getBocacalleEnPosicion(new Posicion(3,1)).getCalleEnDireccion(oeste).setSorpresa(new SorpresaCambioDeVehiculo());

		unJuego.realizarJugadaEnDireccion(sur);
		unJuego.realizarJugadaEnDireccion(oeste);
		assertEquals(unJuego.getPartida().getVehiculo().getCantidadDeMovimientos(),2);
		assertEquals(unJuego.getPartida().getVehiculo().getPosicion().asString(), "3,1");
		
		unJuego.realizarJugadaEnDireccion(sur);
		assertEquals(unJuego.getPartida().getVehiculo().getCantidadDeMovimientos(),2);
		assertEquals(unJuego.getPartida().getVehiculo().getPosicion().asString(), "3,1");
		
		unJuego.realizarJugadaEnDireccion(oeste);
		assertEquals(unJuego.getPartida().getVehiculo().getClass(), (new VehiculoMoto()).getClass());
		assertTrue(unJuego.getPartida().getVehiculo().getPosicion().equals(new Posicion(2,1)));
		
		unJuego.realizarJugadaEnDireccion(sur);
		assertTrue(unJuego.getPartida().getVehiculo().getPosicion().equals(new Posicion(2,0)));
		assertEquals(unJuego.getPartida().getVehiculo().getCantidadDeMovimientos(),6);

		unJuego.realizarJugadaEnDireccion(oeste);
		unJuego.realizarJugadaEnDireccion(norte);
		assertEquals(unJuego.getPartida().getVehiculo().getCantidadDeMovimientos(),10);
		assertTrue(unJuego.getPartida().getVehiculo().getPosicion().equals(new Posicion(1,1)));

		unJuego.realizarJugadaEnDireccion(sur);
		unJuego.realizarJugadaEnDireccion(oeste);
		assertEquals(unJuego.getPartida().getVehiculo().getCantidadDeMovimientos(),10);
		assertTrue(unJuego.getPartida().getVehiculo().getPosicion().equals(new Posicion(1,1)));
		/* se comprueba que una vez perdida la partida no se mueva el vehiculo */
    }

    /* Tests de metodos */
    @Test
    public void testParaComprobarQueCambiaCorrectamenteElVehiculo() {
        int cantidadFilas = 6;
        int cantidadColumnas = 7;
        Tablero tablero = new Tablero(cantidadColumnas, cantidadFilas);
        Vehiculo vehiculo = new Vehiculo4x4(null); /* Es irrelevante la posicion para esta prueba */
        Posicion posicionGanadora = new Posicion(0, 0);
        int movimientosDisponibles = 10;

        Partida unaPartida = new Partida(tablero, vehiculo, posicionGanadora, movimientosDisponibles);

        Juego unJuego = new Juego();
        unJuego.setPartida(unaPartida);
        vehiculo.setJuegoActual(unJuego);

        Vehiculo nuevoVehiculo = new VehiculoAuto(null);
        unJuego.setVehiculo(nuevoVehiculo);

        assertEquals(unJuego.getPartida().getVehiculo(), nuevoVehiculo);
    }

    @Test
    public void testAlMoverPorCalleConSorpresaCambioDeVehiculo4x4SeTransformaEnMoto() throws CalleBloqueadaPorPiqueteExcepcion {
        Vehiculo4x4 todoterreno = new Vehiculo4x4(null);
        Juego unJuego = new Juego();
        Partida unaPartida = new Partida(null, todoterreno, null, 100);
        unJuego.setPartida(unaPartida);
        todoterreno.setJuegoActual(unJuego);

        Calle calle = new Calle();
        calle.setSorpresa(new SorpresaCambioDeVehiculo());
        todoterreno.pasarPorCalle(calle);
        assertEquals(unJuego.getPartida().getVehiculo().getClass(), (new VehiculoMoto()).getClass());
    }

    @Test
    public void testAlMoverPorCalleConSorpresaCambioDeVehiculoMotoSeTransformaEnAuto() throws CalleBloqueadaPorPiqueteExcepcion {
        VehiculoMoto moto = new VehiculoMoto(null);
        Juego unJuego = new Juego();
        Partida unaPartida = new Partida(null, moto, null, 100);
        unJuego.setPartida(unaPartida);
        moto.setJuegoActual(unJuego);

        Calle calle = new Calle();
        calle.setSorpresa(new SorpresaCambioDeVehiculo());
        moto.pasarPorCalle(calle);
        assertEquals(unJuego.getPartida().getVehiculo().getClass(), (new VehiculoAuto()).getClass());
    }

    @Test
    public void testAlMoverPorCalleConSorpresaCambioDeVehiculoAutoSeTransformaEn4x4() throws CalleBloqueadaPorPiqueteExcepcion {
        VehiculoAuto auto = new VehiculoAuto(null);
        Juego unJuego = new Juego();
        Partida unaPartida = new Partida(null, auto, null, 100);
        unJuego.setPartida(unaPartida);
        auto.setJuegoActual(unJuego);

        Calle calle = new Calle();
        calle.setSorpresa(new SorpresaCambioDeVehiculo());
        auto.pasarPorCalle(calle);
        assertEquals(unJuego.getPartida().getVehiculo().getClass(), (new Vehiculo4x4()).getClass());
    }

    @Test
    public void testGuardarYCargarCorrectamenteUnaPartida() throws Exception {
        Tablero tablero = new Tablero(4, 6);
        Vehiculo vehiculo = new VehiculoAuto(new Posicion(0, 0));
        vehiculo.setCantidadDeMovimientos(0);
        Posicion posicionGanadora = new Posicion(3, 4);
        int movimientosDisponibles = 100;

        Partida unaPartida = new Partida(tablero, vehiculo, posicionGanadora, movimientosDisponibles);
        Jugador unJugador = new Jugador("Rober");

        Juego unJuego = new Juego();
        unJuego.setPartida(unaPartida);
        unJuego.setJugador(unJugador);
        vehiculo.setJuegoActual(unJuego);

        Direccion norte = new Direccion(0, 1);
        Direccion sur = new Direccion(0, -1);
        Direccion este = new Direccion(1, 0);
        Direccion oeste = new Direccion(-1, 0);

        tablero.getBocacalleEnPosicion(new Posicion(1, 0)).getCalleEnDireccion(norte).setObstaculo(new ObstaculoPiquete());
        tablero.getBocacalleEnPosicion(new Posicion(2, 3)).getCalleEnDireccion(sur).setObstaculo(new ObstaculoPozo());
        tablero.getBocacalleEnPosicion(new Posicion(1, 4)).getCalleEnDireccion(este).setSorpresa(new SorpresaDesfavorable());
        tablero.getBocacalleEnPosicion(new Posicion(3, 4)).getCalleEnDireccion(oeste).setSorpresa(new SorpresaFavorable());

        unJuego.guardarPartida();

        Juego otroJuego = new Juego();
        otroJuego.setJugador(unJugador);

        otroJuego.cargarPartida();

        assertEquals(otroJuego.getPartida().getVehiculo().getCantidadDeMovimientos(), vehiculo.getCantidadDeMovimientos());
        assertEquals(otroJuego.getPartida().getPosicionGanadora().asString(), posicionGanadora.asString());
    }

    @Test
    public void testGuardarPuntajes() throws Exception {
        Juego unJuego = new Juego();
        unJuego.guardarPuntaje("Chango", 45);
        unJuego.guardarPuntaje("Matori", 32);
        unJuego.guardarPuntaje("Jedi", 77);
        unJuego.guardarPuntaje("Ciriaso", 10);
        unJuego.guardarPuntaje("Carolo", 10);

        unJuego.guardarPuntajes("test/puntajesTest.xml");

        Juego otroJuego = new Juego();
        otroJuego.cargarPuntajes("test/puntajesTest.xml");

        ArrayList<Puntaje> puntajesOrdenados = (otroJuego.getPuntajesOrdenados());

        assertEquals(puntajesOrdenados.get(0).getPuntaje(), 77);
        assertEquals(puntajesOrdenados.get(1).getPuntaje(), 45);
        assertEquals(puntajesOrdenados.get(2).getPuntaje(), 32);
        assertEquals(puntajesOrdenados.get(3).getPuntaje(), 10);
        assertEquals(puntajesOrdenados.get(4).getPuntaje(), 10);
    }
}
