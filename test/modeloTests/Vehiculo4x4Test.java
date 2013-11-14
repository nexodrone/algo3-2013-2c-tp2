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
import modelo.Vector;
import modelo.Vehiculo;
import modelo.Vehiculo4x4;
import modelo.VehiculoAuto;
import modelo.VehiculoMoto;

import org.junit.Test;

import excepciones.ImposiblePasarPorCalleException;
import excepciones.MovimientoNoRealizadoException;

public class Vehiculo4x4Test {

    @Test(expected = ImposiblePasarPorCalleException.class)
    public void testAtraparExcepcionPorPiquete() throws ImposiblePasarPorCalleException {
        Vehiculo4x4 auto = new Vehiculo4x4(new Vector(2, 2));
        Calle calleATransitar = new Calle(new ObstaculoPiquete(), null);
        auto.pasarPorCalle(calleATransitar);
    }

    @Test(expected = MovimientoNoRealizadoException.class)
    public void testAtraparExcepcionYQuedarseEnElLugarYSinSumarUnMovimiento() throws MovimientoNoRealizadoException {
        Vector vectorInicial = new Vector(2, 3);
        Vehiculo4x4 unVehiculo = new Vehiculo4x4(vectorInicial);
        Calle calleSur = new Calle(new ObstaculoPiquete(), null);
        Vector sur = new Vector(0, -1);
        try {
            unVehiculo.moverEnDireccion(sur, calleSur);
        } catch (MovimientoNoRealizadoException e) {
            Vector vectorFinal = unVehiculo.getPosicion();
            assertEquals(0, unVehiculo.getCantidadDeMovimientos());
            assertEquals(vectorInicial.asString(), vectorFinal.asString());
            throw new MovimientoNoRealizadoException();
        }
    }

    // TESTS DE METODOS
    @Test
    public void testParaComprobarQueDosVehiculosTieneElMismoEstadoFuncionaCorrectamente() {
        Vector posicion = new Vector(1, 2);
        int cantidad = 100;
        Vehiculo4x4 unVehiculo = new Vehiculo4x4(posicion);
        unVehiculo.setCantidadDeMovimientos(cantidad);
        Vehiculo4x4 otroVehiculo = new Vehiculo4x4(posicion);
        otroVehiculo.setCantidadDeMovimientos(cantidad);
        assertTrue(unVehiculo.tienenElMismoEstado(otroVehiculo));
    }

    @Test
    public void testParaComprobarQueElMismoVehiculoTieneElMismoEstado() {
        Vector posicion = new Vector(1, 2);
        int cantidad = 100;
        Vehiculo4x4 unVehiculo = new Vehiculo4x4(posicion);
        unVehiculo.setCantidadDeMovimientos(cantidad);
        assertTrue(unVehiculo.tienenElMismoEstado(unVehiculo));
    }

    @Test
    public void testParaComprobarQueCuandoTieneDistintosEstados() {
        // Si tienen distintas cantidad de movimientos, son distintos estados
        Vector posicion = new Vector(1, 2);
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
        Vector posicion = new Vector(1, 2);
        int cantidad = 100;
        Vehiculo unVehiculo = new VehiculoMoto(posicion);
        unVehiculo.setCantidadDeMovimientos(cantidad);
        Vehiculo otroVehiculo = Vehiculo4x4.nuevoVehiculo(unVehiculo);

        assertTrue(unVehiculo.tienenElMismoEstado(otroVehiculo));
    }

    @Test
    public void testParaComprobarQueDevuelveUnaInstanciaConElMismoEstadoDelAuto() {
        Vector posicion = new Vector(1, 2);
        int cantidad = 100;
        Vehiculo unVehiculo = new VehiculoAuto(posicion);
        unVehiculo.setCantidadDeMovimientos(cantidad);
        Vehiculo otroVehiculo = Vehiculo4x4.nuevoVehiculo(unVehiculo);

        assertTrue(unVehiculo.tienenElMismoEstado(otroVehiculo));
    }

    @Test
    public void testParaComprobarQueDevuelveUnaInstanciaConElMismoEstadoDel4x4() {
        Vector posicion = new Vector(1, 2);
        int cantidad = 100;
        Vehiculo unVehiculo = new Vehiculo4x4(posicion);
        unVehiculo.setCantidadDeMovimientos(cantidad);
        Vehiculo otroVehiculo = Vehiculo4x4.nuevoVehiculo(unVehiculo);

        assertTrue(unVehiculo.tienenElMismoEstado(otroVehiculo));
    }

    // TESTS DE COMPORTAMIENTO SORPRESA-VEHICULO4X4

    @Test
    public void testParaComprobarQueCuandoSeLePasaUnaSorpresaFavorableTieneMenosMovimientos() {
        int cantidadDeMovimientos = 100;
        Vehiculo4x4 vehiculo = new Vehiculo4x4(null);
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
        Vehiculo4x4 vehiculo = new Vehiculo4x4(null);
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
        Vehiculo4x4 vehiculo = new Vehiculo4x4(null);
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
        Vector posicion = new Vector(1, 2);
        Vehiculo4x4 vehiculo = new Vehiculo4x4(posicion);
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
        otroVehiculo.setCantidadDeMovimientos(0);

        assertEquals(nuevoVehiculo.getClass(), otroVehiculo.getClass());
    }

}
