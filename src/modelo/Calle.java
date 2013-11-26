package modelo;

import org.simpleframework.xml.*;

@Root ( name= "Calle")
public class Calle {
	
	@Element ( name = "Obstaculo", required = false)
	private Obstaculo obstaculo;
	@Element (name = "Sopresa", required = false)
	private Sorpresa sorpresa;
	
	public Calle() {}
	
	public Calle(Obstaculo obstaculo, Sorpresa sorpresa) {
		this.obstaculo = obstaculo;
		this.sorpresa = sorpresa;
	}
	
	public Obstaculo getObstaculo() {
		return this.obstaculo;
	}

	public Sorpresa getSorpresa() {
		return this.sorpresa;
	}

	public void setObstaculo(Obstaculo obstaculoAColocar){
		obstaculo = obstaculoAColocar;
	}
	
	public void setSorpresa(Sorpresa sorpresaAColocar){
		sorpresa = sorpresaAColocar;
	}
}