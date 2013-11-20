package modeloTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import java.util.ArrayList;
import java.util.Map.Entry;
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
import modelo.Vehiculo4x4;
import modelo.VehiculoAuto;
import modelo.VehiculoMoto;
import modelo.excepciones.MovimientoInvalidoExcepcion;
import modelo.excepciones.PasajeBloqueadoPorPiqueteExcepcion;
import org.junit.Test;

public class JuegoTest {

    @Test
    public void testDeberiaCrearJuego() {
        Tablero tablero = new Tablero(10, 10);
        Vehiculo vehiculo = new VehiculoAuto(new Posicion(0, 0));
        Posicion posicionGanadora = new Posicion(6, 10);
        Juego unJuego = new Juego(tablero, vehiculo, posicionGanadora);
        assertNotNull(unJuego);
    }

    @Test
    public void testVehiculoDeberiaMoversePorLimitesDelTablero() throws MovimientoInvalidoExcepcion, PasajeBloqueadoPorPiqueteExcepcion {
        Tablero tablero = new Tablero(6, 3);
        Vehiculo vehiculo = new VehiculoAuto(new Posicion(4, 0));
        Juego unJuego = new Juego(tablero, vehiculo, new Posicion(0, 0));
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
        assertEquals(unJuego.getVehiculo().getPosicion().asString(), "4,2");
    }

    @Test
    public void testDeberiaTirarExcepcionAlMoverseFueraDelTablero() throws MovimientoInvalidoExcepcion, PasajeBloqueadoPorPiqueteExcepcion {
        Tablero tablero = new Tablero(6, 3);
        Vehiculo vehiculo = new VehiculoAuto(new Posicion(4, 0));
        vehiculo.setCantidadDeMovimientos(1);
        Juego unJuego = new Juego(tablero, vehiculo, new Posicion(0, 0));
        Direccion sur = new Direccion(0, -1);
        try {
            unJuego.realizarJugadaEnDireccion(sur);
            fail("Excepcion esperada");
        } catch (MovimientoInvalidoExcepcion esperada) {
        };
        assertEquals(unJuego.getVehiculo().getCantidadDeMovimientos(), 1);
        /* Se comprueba que la cantidad de movimientos no se cambio */
    }

    // ESTE VA A SER UN TEST INTEGRADOR
    @Test
    public void testIntegradorValoresDePuntajeDeberianSerCoherentesConLosEsperados() throws MovimientoInvalidoExcepcion, PasajeBloqueadoPorPiqueteExcepcion {
        Tablero tablero = new Tablero(3, 3);
        Vehiculo vehiculo = new VehiculoAuto(new Posicion(0, 0));
        vehiculo.setCantidadDeMovimientos(0);
        Posicion posicionGanadora = new Posicion(2, 2);

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

        Juego nuevoJuego = new Juego(tablero, vehiculo, posicionGanadora);
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

        Juego nuevoJuego = new Juego(tablero, vehiculo, posicionGanadora);

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

        Juego juego = new Juego(tablero, vehiculo, posicionGanadora);

        Vehiculo nuevoVehiculo = new VehiculoAuto(null);

        juego.cambiarVehiculo(nuevoVehiculo);

        assertEquals(juego.getVehiculo(), nuevoVehiculo);
    }

    @Test
    public void testParaComprobarQueDevuelveCorrectamenteElVehiculo() {
        Vehiculo vehiculo = new Vehiculo4x4(null);
        Juego juego = new Juego(null, vehiculo, null);

        assertEquals(juego.getVehiculo(), vehiculo);
    }

    @Test
    public void testGuardarYCargarCorrectamenteJuego () throws Exception {
    	Tablero unTablero = new Tablero(4, 4);
    	VehiculoMoto unVehiculo = new VehiculoMoto(new Posicion(2,3));
    	unVehiculo.setCantidadDeMovimientos(34);
    	
    	Posicion posicionGanadora = new Posicion(1,2);
    	Juego unJuego = new Juego(unTablero, unVehiculo, posicionGanadora);
    	
    	unJuego.guardar("test/juegoTest.xml");
    	
    	Juego otroJuego = Juego.recuperar("test/juegoTest.xml");
    	
    	assertEquals(otroJuego.getVehiculo().getCantidadDeMovimientos(), unVehiculo.getCantidadDeMovimientos());
    	assertEquals(otroJuego.getPosicionGanadora().asString(), posicionGanadora.asString());
    }
    
    @Test
    public void testGuardarYRecuperarPuntajes() {
    	Juego unJuego = new Juego(null, null, null);
    	unJuego.guardarPuntaje("Chango" , 45);
    	unJuego.guardarPuntaje("Matori", 32);
    	unJuego.guardarPuntaje("Jedi", 77);
    	unJuego.guardarPuntaje("Ciriaso", 10);
    	unJuego.guardarPuntaje("Carolo", 10);
    	
    	ArrayList<Entry<String, Integer>> puntajesOrdenados =
    			( unJuego.recuperarPuntajesOrdenados() );

    	System.out.print("Puntajes: " + puntajesOrdenados);
    	/*assertEquals(puntajesOrdenados.get(0), );
    	assertEquals(puntajes.get(1).intValue(), 45);
    	assertEquals(puntajes.get(2).intValue(), 32);
    	assertEquals(puntajes.get(3).intValue(), 10);*/
    }
}
