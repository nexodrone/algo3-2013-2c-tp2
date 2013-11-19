package modelo;

public abstract class Sorpresa {

	public Sorpresa() {}
	
    public abstract void interactuarCon(VehiculoAuto vehiculo);
    public abstract void interactuarCon(VehiculoMoto vehiculo);
    public abstract void interactuarCon(Vehiculo4x4 vehiculo);

}
