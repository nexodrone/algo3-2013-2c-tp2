package modelo;

public class DireccionDeMovimiento {
	private char direccionNorte;
	private char direccionSur;
	private char direccionOeste;
	private char direccionEste;
	
	public DireccionDeMovimiento(char direccion){
		switch (direccion) {
    	case 'N': this.direccionNorte = 'N';
             break;
    	case 'S': this.direccionSur = 'S';
             break;
    	case 'E': this.direccionEste = 'E';
             break;
    	case 'O': this.direccionOeste = 'O';
             break;	
        }
	}
	
	public char asChar(){
		if(this.direccionNorte == 'N')
			return this.direccionNorte;
		
		else if(this.direccionSur == 'S')
			return this.direccionSur;
		
		else if(this.direccionEste == 'E')
			return this.direccionEste;
		
		else return this.direccionOeste;				
	}
}
