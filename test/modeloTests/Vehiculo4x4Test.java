package modeloTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import modelo.Calle;
import modelo.Direccion;
import modelo.Juego;
import modelo.ObstaculoPiquete;
import modelo.Partida;
import modelo.Posicion;
import modelo.Sorpresa;
import modelo.SorpresaCambioDeVehiculo;
import modelo.SorpresaDesfavorable;
import modelo.SorpresaFavorable;
import modelo.Vehiculo;
import modelo.Vehiculo4x4;
import modelo.VehiculoAuto;
import modelo.VehiculoMoto;
import modelo.excepciones.CalleBloqueadaPorPiqueteExcepcion;

import org.junit.Test;

public class Vehiculo4x4Test {

    @Test
    public void testDeberiaCrearseCon0Movimientos() {
        Vehiculo4x4 todoterreno = new Vehiculo4x4(new Posicion(2, 2));
        assertEquals(todoterreno.getCantidadDeMovimientos(), 0);
    }

    @Test(expected = CalleBloqueadaPorPiqueteExcepcion.class)
    public void testAtraparExcepcionPorPiquete() throws CalleBloqueadaPorPiqueteExcepcion {
        Vehiculo4x4 todoterreno = new Vehiculo4x4(new Posicion(2, 2));
        Calle calleATransitar = new Calle(new ObstaculoPiquete(), null);
        todoterreno.pasarPorCalle(calleATransitar);
    }

    @Test(expected = CalleBloqueadaPorPiqueteExcepcion.class)
    public void testAtraparExcepcionYQuedarseEnElLugarYSinSumarUnMovimiento() throws CalleBloqueadaPorPiqueteExcepcion {
        Posicion PosicionInicial = new Posicion(2, 3);
        Vehiculo4x4 unVehiculo = new Vehiculo4x4(PosicionInicial);
        Calle calleSur = new Calle(new ObstaculoPiquete(), null);
        Direccion sur = new Direccion(0, -1);
        try {
            unVehiculo.moverEnDireccion(sur, calleSur);
        } catch (CalleBloqueadaPorPiqueteExcepcion e) {
            Posicion PosicionFinal = unVehiculo.getPosicion();
            assertEquals(0, unVehiculo.getCantidadDeMovimientos());
            assertEquals(PosicionInicial.asString(), PosicionFinal.asString());
            throw new CalleBloqueadaPorPiqueteExcepcion();
        }
    }

    // TEST DE METODOS

    @Test
    public void testParaComprobarQuePorDefectoLaCantidadDeMovimientosEsCero() {
        Vehiculo vehiculo = new Vehiculo4x4();
        assertEquals(vehiculo.getCantidadDeMovimientos(), 0);
    }

    @Test
    public void testParaComprobarQueGuardarCorrectamenteElJuego() {
        Vehiculo4x4 vehiculo = new Vehiculo4x4();
        Juego juego = new Juego();

        vehiculo.setJuegoActual(juego);

        assertEquals(vehiculo.getJuego(), juego);
    }

    @Test
    public void testParaComprobarQueSeaCreaConLaPosicionIndicada() {
        Posicion posicion = new Posicion(1, 1);
        Vehiculo4x4 vehiculo = new Vehiculo4x4(posicion);

        assertEquals(vehiculo.getPosicion(), posicion);
    }

    @Test
    public void testParaComprobarQueCambiarCorrectamenteLaPosicion() {
        Posicion posicion = new Posicion(2, 1);
        Posicion nuevaPosicion = new Posicion(3, 1);
        Vehiculo4x4 vehiculo = new Vehiculo4x4(posicion);

        vehiculo.setPosicion(nuevaPosicion);

        assertEquals(vehiculo.getPosicion(), nuevaPosicion);
    }

    @Test
    public void testParaComprobarQueSiLaDireccionEsNullDevuelveLaPosicionActual() {
        Posicion posicion = new Posicion(2, 3);
        Vehiculo4x4 vehiculo = new Vehiculo4x4(posicion);

        assertEquals(vehiculo.calcularSiguientePosicion(), posicion);
    }

    @Test
    public void testParaComprobarQueLaPosicionEsNullSinoSeLePasaUna() {
        Vehiculo4x4 vehiculo = new Vehiculo4x4();
        assertEquals(vehiculo.getJuego(), null);
    }

    @Test
    public void testParaComprobarJuegoCambiaDeVehiculoPorMedioDelVehiculoActual() {
        Juego juego = new Juego();
        Vehiculo otroVehiculo = new Vehiculo4x4();
        Vehiculo vehiculo = new Vehiculo4x4();
        Partida partida = new Partida();
        partida.setVehiculo(vehiculo);
        juego.setPartida(partida);

        vehiculo.setJuegoActual(juego);
        vehiculo.cambiarA(otroVehiculo);

        assertEquals(juego.getVehiculo(), otroVehiculo);
    }

    @Test
    public void testParaComprobarQueSumaCorrectamenteLaCantidadDeMovimientos() {
        int cantidad = 9;
        int cantidadASumar = 1;

        Vehiculo vehiculo = new Vehiculo4x4();
        vehiculo.setCantidadDeMovimientos(cantidad);

        vehiculo.sumarMovimientos(cantidadASumar);

        assertEquals(vehiculo.getCantidadDeMovimientos(), cantidadASumar + cantidad);
    }

    @Test
    public void testParaComprobarQueCambiarCorrectamenteLaCantidadDeMovimientos() {
        int cantidad = 9;
        Vehiculo vehiculo = new VehiculoAuto();
        vehiculo.setCantidadDeMovimientos(cantidad);

        assertEquals(vehiculo.getCantidadDeMovimientos(), cantidad);

    }

    @Test
    public void testParaComprobarQueCalcularCorrectamenteLaNuevaPosicion() {
        Posicion posicion = new Posicion(1, 0);
        Direccion direccion = new Direccion(2, 0);
        Posicion posicionCorrecta = new Posicion(3, 0);

        Vehiculo vehiculo = new Vehiculo4x4(posicion);

        Posicion nuevaPosicion = vehiculo.calcularSiguientePosicion(direccion);

        assertTrue(nuevaPosicion.equals(posicionCorrecta));
    }

    @Test
    public void testParaComprobarQueSiLaDireccionEsNullELVehiculoSeQuedaQuieto() {
        Calle calle = new Calle();
        Posicion posicion = new Posicion(1, 0);
        Vehiculo vehiculo = new Vehiculo4x4(posicion);

        // la calle esta vacia
        vehiculo.moverEnDireccion(null, calle);
        assertEquals(vehiculo.getPosicion(), posicion);
    }

    @Test
    public void testParaComprobarQueDosVehiculosTieneElMismoEstadoFuncionaCorrectamente() {
        Posicion posicion = new Posicion(1, 2);
        int cantidad = 100;
        Vehiculo4x4 unVehiculo = new Vehiculo4x4(posicion);
        unVehiculo.setCantidadDeMovimientos(cantidad);
        Vehiculo4x4 otroVehiculo = new Vehiculo4x4(posicion);
        otroVehiculo.setCantidadDeMovimientos(cantidad);
        assertTrue(unVehiculo.tienenElMismoEstado(otroVehiculo));
    }

    @Test
    public void testParaComprobarQueElMismoVehiculoTieneElMismoEstado() {
        Posicion posicion = new Posicion(1, 2);
        int cantidad = 100;
        Vehiculo4x4 unVehiculo = new Vehiculo4x4(posicion);
        unVehiculo.setCantidadDeMovimientos(cantidad);
        assertTrue(unVehiculo.tienenElMismoEstado(unVehiculo));
    }

    @Test
    public void testParaComprobarQueCuandoTieneDistintosEstados() {
        /* Si tienen distintas cantidad de movimientos, son distintos estados */
        Posicion posicion = new Posicion(1, 2);
        int cantidad = 100;
        int otraCantidad = 120;
        Vehiculo4x4 unVehiculo = new Vehiculo4x4(posicion);
        unVehiculo.setCantidadDeMovimientos(cantidad);
        Vehiculo4x4 otroVehiculo = new Vehiculo4x4(posicion);
        otroVehiculo.setCantidadDeMovimientos(otraCantidad);
        assertFalse(unVehiculo.tienenElMismoEstado(otroVehiculo));

    }

    @Test
    public void testParaComprobarQueDevuelveUnaInstanciaConElMismoEstadoDeLaMoto() {
        Posicion posicion = new Posicion(1, 2);
        int cantidad = 100;
        Vehiculo unVehiculo = new VehiculoMoto(posicion);
        unVehiculo.setCantidadDeMovimientos(cantidad);
        Vehiculo otroVehiculo = Vehiculo4x4.nuevoVehiculo(unVehiculo);

        assertTrue(unVehiculo.tienenElMismoEstado(otroVehiculo));
    }

    @Test
    public void testParaComprobarQueDevuelveUnaInstanciaConElMismoEstadoDelAuto() {
        Posicion posicion = new Posicion(1, 2);
        int cantidad = 100;
        Vehiculo unVehiculo = new VehiculoAuto(posicion);
        unVehiculo.setCantidadDeMovimientos(cantidad);
        Vehiculo otroVehiculo = Vehiculo4x4.nuevoVehiculo(unVehiculo);

        assertTrue(unVehiculo.tienenElMismoEstado(otroVehiculo));
    }

    @Test
    public void testParaComprobarQueDevuelveUnaInstanciaConElMismoEstadoDel4x4() {
        Posicion posicion = new Posicion(1, 2);
        int cantidad = 100;
        Vehiculo unVehiculo = new Vehiculo4x4(posicion);
        unVehiculo.setCantidadDeMovimientos(cantidad);
        Vehiculo otroVehiculo = Vehiculo4x4.nuevoVehiculo(unVehiculo);

        assertTrue(unVehiculo.tienenElMismoEstado(otroVehiculo));
    }

    /* Tests de comportamiento Sorpresa-Vehiculo4x4 */
    @Test
    public void testParaComprobarQueCuandoSeLePasaUnaSorpresaFavorableTieneMenosMovimientos() {
        int cantidadDeMovimientos = 100;
        Vehiculo4x4 vehiculo = new Vehiculo4x4(null);
        vehiculo.setCantidadDeMovimientos(cantidadDeMovimientos);
        Sorpresa sorpresa = new SorpresaFavorable();

        vehiculo.aplicarEvento(sorpresa);
        /* se restan 20% */
        int nuevaCantidad = (int) (cantidadDeMovimientos - ((0.2) * cantidadDeMovimientos));

        assertEquals(vehiculo.getCantidadDeMovimientos(), nuevaCantidad);
    }

    @Test
    public void testParaComprobarQueCuandoSeLePasaUnaSorpresaDesfavorableTieneMasMovimientos() {
        int cantidadDeMovimientos = 100;
        Vehiculo4x4 vehiculo = new Vehiculo4x4(null);
        vehiculo.setCantidadDeMovimientos(cantidadDeMovimientos);
        Sorpresa sorpresa = new SorpresaDesfavorable();

        vehiculo.aplicarEvento(sorpresa);
        /* se suman 25% */
        int nuevaCantidad = (int) (cantidadDeMovimientos + (0.25) * cantidadDeMovimientos);

        assertEquals(vehiculo.getCantidadDeMovimientos(), nuevaCantidad);
    }

    @Test
    public void testParaComprobarQueCuandoCambiaDeVehiculoNoEsElMismoObjeto() {
        int cantidadDeMovimientos = 0;
        Vehiculo4x4 vehiculo = new Vehiculo4x4(null);
        vehiculo.setCantidadDeMovimientos(cantidadDeMovimientos);
        Sorpresa sorpresa = new SorpresaCambioDeVehiculo();

        Partida unaPartida = new Partida(null, vehiculo, null, 100);
        Juego juego = new Juego();
        juego.setPartida(unaPartida);

        vehiculo.setJuegoActual(juego);
        vehiculo.aplicarEvento(sorpresa);
        Vehiculo nuevoVehiculo = juego.getPartida().getVehiculo();

        assertFalse(nuevoVehiculo == vehiculo);
    }

    @Test
    public void testParaComprobarQueCuandoCambiaDeVehiculoElMismoTieneElMismoEstadoQueElOtroVehiculo() {
        int cantidadDeMovimientos = 0;
        Posicion posicion = new Posicion(1, 2);
        Direccion unaDireccion = new Direccion(1, 0);
        Calle calle = new Calle();

        Vehiculo4x4 vehiculo = new Vehiculo4x4(posicion);
        vehiculo.setCantidadDeMovimientos(cantidadDeMovimientos);
        Sorpresa sorpresa = new SorpresaCambioDeVehiculo();
        calle.setSorpresa(sorpresa);

        Partida unaPartida = new Partida(null, vehiculo, null, 100);

        Juego juego = new Juego();
        juego.setPartida(unaPartida);
        vehiculo.setJuegoActual(juego);
        vehiculo.moverEnDireccion(unaDireccion, calle);

        Vehiculo nuevoVehiculo = juego.getPartida().getVehiculo();

        assertTrue(vehiculo.tienenElMismoEstado(nuevoVehiculo));
    }

    @Test
    public void testParaComprobarQueElNuevoVehiculoEsUnaMoto() {
        int cantidadDeMovimientos = 0;
        Vehiculo4x4 vehiculo = new Vehiculo4x4(null);
        vehiculo.setCantidadDeMovimientos(cantidadDeMovimientos);
        Sorpresa sorpresa = new SorpresaCambioDeVehiculo();

        Partida unaPartida = new Partida(null, vehiculo, null, 100);
        Juego juego = new Juego();
        juego.setPartida(unaPartida);

        vehiculo.setJuegoActual(juego);
        vehiculo.aplicarEvento(sorpresa);
        Vehiculo nuevoVehiculo = juego.getPartida().getVehiculo();
        Vehiculo otroVehiculo = new VehiculoMoto(null);

        assertEquals(nuevoVehiculo.getClass(), otroVehiculo.getClass());
    }

}
