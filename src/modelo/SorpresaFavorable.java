package modelo;

public class SorpresaFavorable extends Sorpresa {

	public void interactuarCon(Vehiculo vehiculo) {
		vehiculo.aplicarPorcentajeAMovimientos(-20);
	}
}
