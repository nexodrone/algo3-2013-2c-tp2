package modeloTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import modelo.Calle;
import modelo.Juego;
import modelo.ObstaculoPiquete;
import modelo.Sorpresa;
import modelo.SorpresaCambioDeVehiculo;
import modelo.SorpresaDesfavorable;
import modelo.SorpresaFavorable;
import modelo.Posicion;
import modelo.Vehiculo;
import modelo.Vehiculo4x4;
import modelo.VehiculoAuto;
import modelo.VehiculoMoto;
import modelo.excepciones.PasajeBloqueadoPorPiqueteExcepcion;

import org.junit.Test;


public class VehiculoAutoTest {

    @Test(expected = PasajeBloqueadoPorPiqueteExcepcion.class)
    public void testAtraparExcepcionPorPiquete() throws PasajeBloqueadoPorPiqueteExcepcion {
        VehiculoAuto auto = new VehiculoAuto(new Posicion(2, 2));
        auto.setCantidadDeMovimientos(0);
        Calle calleATransitar = new Calle(new ObstaculoPiquete(), null);
        auto.pasarPorCalle(calleATransitar);
    }

    // TESTS DE METODOS

    @Test
    public void testParaComprobarQueDosVehiculosTieneElMismoEstadoFuncionaCorrectamente() {
        Posicion posicion = new Posicion(1, 2);
        int cantidad = 100;
        Vehiculo unVehiculo = new VehiculoAuto(posicion);
        unVehiculo.setCantidadDeMovimientos(cantidad);
        Vehiculo otroVehiculo = new VehiculoAuto(posicion);
        otroVehiculo.setCantidadDeMovimientos(cantidad);
        assertTrue(unVehiculo.tienenElMismoEstado(otroVehiculo));
    }

    @Test
    public void testParaComprobarQueElMismoVehiculoTieneElMismoEstado() {
        Posicion posicion = new Posicion(1, 2);
        int cantidad = 100;
        VehiculoAuto unVehiculo = new VehiculoAuto(posicion);
        unVehiculo.setCantidadDeMovimientos(cantidad);
        assertTrue(unVehiculo.tienenElMismoEstado(unVehiculo));
    }

    @Test
    public void testParaComprobarQueCuandoTieneDistintosEstados() {
        // Si tienen distintas cantidad de movimientos, son distintos estados
        Posicion posicion = new Posicion(1, 2);
        int cantidad = 100;
        int otraCantidad = 120;
        VehiculoAuto unVehiculo = new VehiculoAuto(posicion);
        unVehiculo.setCantidadDeMovimientos(cantidad);
        VehiculoAuto otroVehiculo = new VehiculoAuto(posicion);
        otroVehiculo.setCantidadDeMovimientos(otraCantidad);
        assertFalse(unVehiculo.tienenElMismoEstado(otroVehiculo));
    }

    @Test
    public void testParaComprobarQueDevuelveUnaInstanciaConElMismoEstadoDeLaMoto() {
        Posicion posicion = new Posicion(1, 2);
        int cantidad = 100;
        Vehiculo unVehiculo = new VehiculoMoto(posicion);
        unVehiculo.setCantidadDeMovimientos(cantidad);
        Vehiculo otroVehiculo = VehiculoAuto.nuevoVehiculo(unVehiculo);
        assertTrue(unVehiculo.tienenElMismoEstado(otroVehiculo));
    }

    @Test
    public void testParaComprobarQueDevuelveUnaInstanciaConElMismoEstadoDelAuto() {
        Posicion posicion = new Posicion(1, 2);
        int cantidad = 100;
        Vehiculo unVehiculo = new Vehiculo4x4(posicion);
        unVehiculo.setCantidadDeMovimientos(cantidad);
        Vehiculo otroVehiculo = VehiculoAuto.nuevoVehiculo(unVehiculo);
        assertTrue(unVehiculo.tienenElMismoEstado(otroVehiculo));
    }

    @Test
    public void testParaComprobarQueDevuelveUnaInstanciaConElMismoEstadoDel4x4() {
        Posicion posicion = new Posicion(1, 2);
        int cantidad = 100;
        Vehiculo unVehiculo = new Vehiculo4x4(posicion);
        unVehiculo.setCantidadDeMovimientos(cantidad);
        Vehiculo otroVehiculo = VehiculoAuto.nuevoVehiculo(unVehiculo);
        assertTrue(unVehiculo.tienenElMismoEstado(otroVehiculo));
    }

    // TESTS DE COMPORTAMIENTO SORPRESA-VEHICULO4X4

    @Test
    public void testParaComprobarQueCuandoSeLePasaUnaSorpresaFavorableTieneMenosMovimientos() {
        int cantidadDeMovimientos = 100;
        VehiculoAuto vehiculo = new VehiculoAuto(null);
        vehiculo.setCantidadDeMovimientos(cantidadDeMovimientos);
        Sorpresa sorpresa = new SorpresaFavorable();
        vehiculo.aplicarEvento(sorpresa);
        // se resta el 20%
        int nuevaCantidad = (int) (cantidadDeMovimientos - ((0.2) * cantidadDeMovimientos));
        assertEquals(vehiculo.getCantidadDeMovimientos(), nuevaCantidad);
    }

    @Test
    public void testParaComprobarQueCuandoSeLePasaUnaSorpresaDesfavorableTieneMasMovimientos() {
        int cantidadDeMovimientos = 100;
        VehiculoAuto vehiculo = new VehiculoAuto(null);
        vehiculo.setCantidadDeMovimientos(cantidadDeMovimientos);
        Sorpresa sorpresa = new SorpresaDesfavorable();
        vehiculo.aplicarEvento(sorpresa);

        // Aumenta en un 25%
        int nuevaCantidad = (int) (cantidadDeMovimientos + (0.25) * cantidadDeMovimientos);
        assertEquals(vehiculo.getCantidadDeMovimientos(), nuevaCantidad);
    }

    @Test
    public void testParaComprobarQueCuandoCambiaDeVehiculoNoEsElMismoObjeto() {
        int cantidadDeMovimientos = 0;
        VehiculoAuto vehiculo = new VehiculoAuto(null);
        vehiculo.setCantidadDeMovimientos(cantidadDeMovimientos);
        Sorpresa sorpresa = new SorpresaCambioDeVehiculo();
        Juego juego = new Juego(null, vehiculo, null);
        vehiculo.setJuegoActual(juego);
        vehiculo.aplicarEvento(sorpresa);

        Vehiculo nuevoVehiculo = juego.getVehiculo();

        assertFalse(nuevoVehiculo == vehiculo);

    }

    @Test
    public void testParaComprobarQueCuandoDeVehiculoElMismoTieneElMismoEstadoQueElOtroVehiculo() {
        int cantidadDeMovimientos = 0;
        Posicion posicion = new Posicion(1, 2);
        VehiculoAuto vehiculo = new VehiculoAuto(posicion);
        vehiculo.setCantidadDeMovimientos(cantidadDeMovimientos);
        Sorpresa sorpresa = new SorpresaCambioDeVehiculo();
        Juego juego = new Juego(null, vehiculo, null);
        vehiculo.setJuegoActual(juego);
        vehiculo.aplicarEvento(sorpresa);
        Vehiculo nuevoVehiculo = juego.getVehiculo();
        assertTrue(vehiculo.tienenElMismoEstado(nuevoVehiculo));
    }

    @Test
    public void testParaComprobarQueElNuevoVehiculoEsUnaMoto() {
        int cantidadDeMovimientos = 0;
        Vehiculo4x4 vehiculo = new Vehiculo4x4(null);
        vehiculo.setCantidadDeMovimientos(cantidadDeMovimientos);
        Sorpresa sorpresa = new SorpresaCambioDeVehiculo();
        Juego juego = new Juego(null, vehiculo, null);
        vehiculo.setJuegoActual(juego);
        vehiculo.aplicarEvento(sorpresa);
        Vehiculo nuevoVehiculo = juego.getVehiculo();
        Vehiculo otroVehiculo = new VehiculoMoto(null);
        assertEquals(nuevoVehiculo.getClass(), otroVehiculo.getClass());
    }

}
