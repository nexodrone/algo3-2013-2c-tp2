package modeloTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;

import modelo.Bocacalle;
import modelo.Calle;
import modelo.Direccion;
import modelo.Juego;
import modelo.ObstaculoPozo;
import modelo.Posicion;
import modelo.SorpresaDesfavorable;
import modelo.Tablero;
import modelo.Vehiculo;
import modelo.VehiculoAuto;
import modelo.VehiculoMoto;
import modelo.excepciones.PasajeBloqueadoPorPiqueteExcepcion;

import org.junit.Test;
//import org.simpleframework.xml.strategy.*;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;


public class VehiculoTest {

    @Test
    public void testDeberiaCrearVehiculo() {
        Vehiculo vehiculo = new VehiculoAuto(new Posicion(2, 2));
        //estaba en cero
        assertNotNull(vehiculo);
    }

    @Test
    public void testVehiculoDeberiaQuedarseEnPosicionIndicada() {
        Vehiculo unVehiculo = new VehiculoAuto(new Posicion(2, 3));
        //estaba en cero
        assertEquals(unVehiculo.getPosicion().asString(), "2,3");
    }

    @Test
    public void testPoderMoverseEnTodasDireccionesPosibles() throws PasajeBloqueadoPorPiqueteExcepcion {
        Vehiculo unVehiculo = new VehiculoAuto(new Posicion(2, 3));
        unVehiculo.setCantidadDeMovimientos(0);
        Bocacalle bocacalleNeutral = new Bocacalle();
        Direccion norte = new Direccion(0, 1);
        Direccion sur = new Direccion(0, -1);
        Direccion este = new Direccion(1, 0);
        Direccion oeste = new Direccion(-1, 0);
        try {
            unVehiculo.moverEnDireccion(sur, bocacalleNeutral.getCalleEnDireccion(sur));
        } catch (PasajeBloqueadoPorPiqueteExcepcion e) {};
        try {
            unVehiculo.moverEnDireccion(este, bocacalleNeutral.getCalleEnDireccion(este));
        } catch (PasajeBloqueadoPorPiqueteExcepcion e) {};
        try {
            unVehiculo.moverEnDireccion(sur, bocacalleNeutral.getCalleEnDireccion(sur));
        } catch (PasajeBloqueadoPorPiqueteExcepcion e) {};
        try {
            unVehiculo.moverEnDireccion(oeste, bocacalleNeutral.getCalleEnDireccion(oeste));
        } catch (PasajeBloqueadoPorPiqueteExcepcion e) {};
        try {
            unVehiculo.moverEnDireccion(oeste, bocacalleNeutral.getCalleEnDireccion(oeste));
        } catch (PasajeBloqueadoPorPiqueteExcepcion e) {};
        try {
            unVehiculo.moverEnDireccion(norte, bocacalleNeutral.getCalleEnDireccion(norte));
        } catch (PasajeBloqueadoPorPiqueteExcepcion e) {};
        assertEquals(unVehiculo.getPosicion().asString(), "1,2");
        assertEquals(unVehiculo.getCantidadDeMovimientos(), 6);
    }

    @Test
    public void testDeberiaCalcularBienElPuntajeAlPasarPorCalleConPozoYSorpresa() {
        VehiculoMoto moto = new VehiculoMoto(new Posicion(0, 0));
        moto.setCantidadDeMovimientos(60);
        Calle calle = new Calle();
        calle.setObstaculo(new ObstaculoPozo());
        calle.setSorpresa(new SorpresaDesfavorable());
        moto.pasarPorCalle(calle);
        assertEquals(moto.getCantidadDeMovimientos(),80);
    }
}