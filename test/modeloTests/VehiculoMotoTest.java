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

import org.junit.Test;

public class VehiculoMotoTest {

    @Test
    public void testDeberiaCrearseCon0Movimientos() {
        VehiculoMoto moto = new VehiculoMoto(new Posicion(2, 2));
        assertEquals(moto.getCantidadDeMovimientos(), 0);
    }

    @Test
    public void testDeberiaPerderDosMovimientosPorPiquete() {
        VehiculoMoto moto = new VehiculoMoto(new Posicion(2, 2));
        moto.setCantidadDeMovimientos(0);
        Calle calleATransitar = new Calle(new ObstaculoPiquete(), null);
        moto.pasarPorCalle(calleATransitar);
        assertEquals(3, moto.getCantidadDeMovimientos());
    }

    // TEST DE METODOS //

    @Test
    public void testParaComprobarQueGuardarCorrectamenteElJuego() {
        VehiculoMoto vehiculo = new VehiculoMoto();
        Juego juego = new Juego();

        vehiculo.setJuegoActual(juego);

        assertEquals(vehiculo.getJuego(), juego);
    }

    @Test
    public void testParaComprobarQueSeaCreaConLaPosicionIndicada() {
        Posicion posicion = new Posicion(1, 1);
        VehiculoMoto vehiculo = new VehiculoMoto(posicion);

        assertEquals(vehiculo.getPosicion(), posicion);
    }

    @Test
    public void testParaComprobarQueCambiarCorrectamenteLaPosicion() {
        Posicion posicion = new Posicion(2, 1);
        Posicion nuevaPosicion = new Posicion(3, 1);
        VehiculoMoto vehiculo = new VehiculoMoto(posicion);

        vehiculo.setPosicion(nuevaPosicion);

        assertEquals(vehiculo.getPosicion(), nuevaPosicion);
    }

    @Test
    public void testParaComprobarQueDosVehiculosTieneElMismoEstadoFuncionaCorrectamente() {
        Posicion posicion = new Posicion(1, 2);
        int cantidad = 100;
        VehiculoMoto unVehiculo = new VehiculoMoto(posicion);
        unVehiculo.setCantidadDeMovimientos(cantidad);
        VehiculoMoto otroVehiculo = new VehiculoMoto(posicion);
        otroVehiculo.setCantidadDeMovimientos(cantidad);
        assertTrue(unVehiculo.tienenElMismoEstado(otroVehiculo));
    }

    @Test
    public void testParaComprobarQueElMismoVehiculoTieneElMismoEstado() {
        Posicion posicion = new Posicion(1, 2);
        int cantidad = 100;
        VehiculoMoto unVehiculo = new VehiculoMoto(posicion);
        unVehiculo.setCantidadDeMovimientos(cantidad);
        assertTrue(unVehiculo.tienenElMismoEstado(unVehiculo));
    }

    @Test
    public void testParaComprobarQueCuandoTieneDistintosEstados() {
        /* Si tienen distintas cantidad de movimientos, son distintos estados */
        Posicion posicion = new Posicion(1, 2);
        int cantidad = 100;
        int otraCantidad = 120;
        VehiculoMoto unVehiculo = new VehiculoMoto(posicion);
        unVehiculo.setCantidadDeMovimientos(cantidad);
        Vehiculo otroVehiculo = new VehiculoMoto(posicion);
        otroVehiculo.setCantidadDeMovimientos(otraCantidad);
        assertFalse(unVehiculo.tienenElMismoEstado(otroVehiculo));
    }

    @Test
    public void testParaComprobarQueDevuelveUnaInstanciaConElMismoEstadoDeLaMoto() {
        Posicion posicion = new Posicion(1, 2);
        int cantidad = 100;
        Vehiculo unVehiculo = new VehiculoMoto(posicion);
        unVehiculo.setCantidadDeMovimientos(cantidad);
        Vehiculo otroVehiculo = VehiculoMoto.nuevoVehiculo(unVehiculo);
        assertTrue(unVehiculo.tienenElMismoEstado(otroVehiculo));
    }

    @Test
    public void testParaComprobarQueDevuelveUnaInstanciaConElMismoEstadoDelAuto() {
        Posicion posicion = new Posicion(1, 2);
        int cantidad = 100;
        Vehiculo unVehiculo = new VehiculoAuto(posicion);
        unVehiculo.setCantidadDeMovimientos(cantidad);
        Vehiculo otroVehiculo = VehiculoMoto.nuevoVehiculo(unVehiculo);
        assertTrue(unVehiculo.tienenElMismoEstado(otroVehiculo));
    }

    @Test
    public void testParaComprobarQueDevuelveUnaInstanciaConElMismoEstadoDel4x4() {
        Posicion posicion = new Posicion(1, 2);
        int cantidad = 100;
        Vehiculo unVehiculo = new Vehiculo4x4(posicion);
        unVehiculo.setCantidadDeMovimientos(cantidad);
        Vehiculo otroVehiculo = VehiculoMoto.nuevoVehiculo(unVehiculo);
        assertTrue(unVehiculo.tienenElMismoEstado(otroVehiculo));
    }

    /* Tests de comportamiento Sorpresa-VehiculoMoto */
    @Test
    public void testParaComprobarQueCuandoSeLePasaUnaSorpresaFavorableTieneMenosMovimientos() {
        int cantidadDeMovimientos = 100;
        VehiculoMoto vehiculo = new VehiculoMoto(null);
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
        VehiculoMoto vehiculo = new VehiculoMoto(null);
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
        VehiculoMoto vehiculo = new VehiculoMoto(null);
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
    public void testParaComprobarQueCuandoDeVehiculoElMismoTieneElMismoEstadoQueElOtroVehiculo() {
        int cantidadDeMovimientos = 0;
        Posicion posicion = new Posicion(1, 2);
        Direccion unaDireccion = new Direccion(1, 0);
        Calle calle = new Calle();

        VehiculoMoto vehiculo = new VehiculoMoto(posicion);
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
    public void testParaComprobarQueElNuevoVehiculoEsUnAuto() {
        int cantidadDeMovimientos = 0;
        Posicion posicion = new Posicion(2, 3);
        VehiculoMoto vehiculo = new VehiculoMoto(posicion);
        vehiculo.setCantidadDeMovimientos(cantidadDeMovimientos);
        Sorpresa sorpresa = new SorpresaCambioDeVehiculo();

        Partida unaPartida = new Partida(null, vehiculo, null, 100);
        Juego juego = new Juego();
        juego.setPartida(unaPartida);

        vehiculo.setJuegoActual(juego);
        vehiculo.aplicarEvento(sorpresa);
        Vehiculo nuevoVehiculo = juego.getPartida().getVehiculo();
        Vehiculo otroVehiculo = new VehiculoAuto(null);

        assertEquals(nuevoVehiculo.getClass(), otroVehiculo.getClass());
    }

}
