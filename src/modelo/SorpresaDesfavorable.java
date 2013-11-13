package modelo;

public class SorpresaDesfavorable extends Sorpresa {

	public void interactuarCon(Vehiculo vehiculo) {
		vehiculo.aplicarPorcentajeAMovimientos(25);
	}
	
}
