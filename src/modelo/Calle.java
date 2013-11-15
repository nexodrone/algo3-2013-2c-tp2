package modelo;

public class Calle {
	
	private Obstaculo obstaculo;
	private Sorpresa sorpresa;
	
	public Calle() {
		obstaculo = null;
		sorpresa = null;
	}
	
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