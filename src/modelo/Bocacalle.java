package modelo;

import modelo.Calle;

public class Bocacalle {
	
	private Calle calleNorte;
	private Calle calleSur;
	private Calle calleEste;
	private Calle calleOeste;
	
	public Bocacalle(){
		this.calleNorte = new Calle();
		this.calleSur = new Calle();
		this.calleEste = new Calle();
		this.calleOeste = new Calle();
	}

	void setCalleNorte(Calle calleNorte) {	// visibilidad en paquete
		this.calleNorte = calleNorte;
	}
	
	void setCalleOeste(Calle calleOeste) {	// visibilidad en paquete
		this.calleOeste = calleOeste;
	}

	public Calle obtenerCalleEnDireccion(char direccion) {
		Calle calleDevolver = new Calle();
		switch (direccion) {
        case 'N': calleDevolver = this.calleNorte;
                 break;
        case 'S': calleDevolver = this.calleSur;
                 break;
        case 'E': calleDevolver = this.calleEste;
                 break;
        case 'O': calleDevolver = this.calleOeste;
                 break;	
         }
		return calleDevolver;
	}
}
