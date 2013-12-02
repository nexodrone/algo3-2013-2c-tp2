package modelo;

import org.simpleframework.xml.Root;

@Root(name = "4x4")
public class Vehiculo4x4 extends Vehiculo {

    public Vehiculo4x4(Posicion posicionInicial) {
        super(posicionInicial);
        /* esta porcion de codigo esta tanto en VehiculoMoto y VehiculoAuto */
    }

    public Vehiculo4x4() {
    }
    
    public void aplicarEvento(EventoColicion evento) {
        evento.interactuarCon(this);
    }

    public static Vehiculo nuevoVehiculo(Vehiculo vehiculo) {
        Vehiculo nuevo4x4 = new Vehiculo4x4(vehiculo.getPosicion());
        nuevo4x4.setCantidadDeMovimientos(vehiculo.getCantidadDeMovimientos());
        return nuevo4x4;
    }

	@Override
	public String asString() {
		return "4x4";
	}

}
