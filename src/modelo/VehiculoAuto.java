package modelo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.simpleframework.xml.*;
import org.simpleframework.xml.core.Persister;

import modelo.excepciones.PasajeBloqueadoPorPiqueteExcepcion;

@Root(name="Auto", strict = false)
public class VehiculoAuto extends Vehiculo {

    public VehiculoAuto(@Element(name="posicionActual") Posicion posicionInicial) {
        super(posicionInicial);
        /* esta porcion de codigo esta tanto en vehiculo4x4 y vehiculoMoto */
    }

    public void aplicarEvento(Sorpresa sorpresa) {
        sorpresa.interactuarCon(this);
    }
    
    public void pasarPorCalle(Calle calleAPasar) throws PasajeBloqueadoPorPiqueteExcepcion {
        Obstaculo obstaculo = calleAPasar.getObstaculo();
        if (obstaculo != null) { obstaculo.interactuarCon(this); };
        Sorpresa sorpresa = calleAPasar.getSorpresa(); /* si llego hasta aca entonces no hay problema con obstaculo */
        if (sorpresa != null) { sorpresa.interactuarCon(this);
								calleAPasar.setSorpresa(null); };
        this.cantidadDeMovimientos++;
     }

    public static Vehiculo nuevoVehiculo(Vehiculo vehiculo) {
        Vehiculo nuevoAuto = new VehiculoAuto(vehiculo.getPosicion());
        nuevoAuto.setCantidadDeMovimientos(vehiculo.getCantidadDeMovimientos());
        return nuevoAuto;
    }
    
    public static VehiculoAuto recuperar(String path) throws Exception{
    Serializer deserializador = new Persister();
    InputStream src = new FileInputStream(path);
    return deserializador.read(VehiculoAuto.class, src);
    }
}