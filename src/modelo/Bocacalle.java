package modelo;

public class Bocacalle {

    private Calle calleNorte, calleSur, calleEste, calleOeste;

    public Bocacalle() {
        this.calleNorte = new Calle();
        this.calleSur = new Calle();
        this.calleEste = new Calle();
        this.calleOeste = new Calle();
    }

    void setCalleSur(Calle calleSur) { /* visibilidad en paquete */
        this.calleSur = calleSur;
    }

    void setCalleOeste(Calle calleOeste) { /* visibilidad en paquete */
        this.calleOeste = calleOeste;
    }

    public Calle obtenerCalleEnDireccion(Vector direccion) {
        if (direccion.x() == 1)
            return calleEste;
        if (direccion.x() == -1)
            return calleOeste;
        if (direccion.y() == 1)
            return calleNorte;
        return calleSur;
    }

}
