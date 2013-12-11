package modelo;

import org.simpleframework.xml.*;

@Root (name = "Bocacalle")
public class Bocacalle {

	@Element
    private Calle calleNorte, calleSur, calleEste, calleOeste;
	
    public Bocacalle() {
        this.calleNorte = new Calle();
        this.calleSur = new Calle();
        this.calleEste = new Calle();
        this.calleOeste = new Calle();
    }
    
    public void setCalleSur(Calle calleSur) {
        this.calleSur = calleSur;
    }

    public void setCalleOeste(Calle calleOeste) {
        this.calleOeste = calleOeste;
    }

    public Calle getCalleEnDireccion(Direccion direccion) {
        if (direccion.x() == 1)
            return calleEste;
        if (direccion.x() == -1)
            return calleOeste;
        if (direccion.y() == 1)
            return calleNorte;
        return calleSur;
    }

}
