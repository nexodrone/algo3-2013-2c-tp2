package modelo;

public class Bocacalle {

    private Calle calleNorte, calleSur, calleEste, calleOeste;

    public Bocacalle() {
        this.calleNorte = new Calle();
        this.calleSur = new Calle();
        this.calleEste = new Calle();
        this.calleOeste = new Calle();
    }

    void setCalleNorte(Calle calleNorte) { /* visibilidad en paquete */
        this.calleNorte = calleNorte;
    }

    void setCalleOeste(Calle calleOeste) { /* visibilidad en paquete */
        this.calleOeste = calleOeste;
    }

    public Calle obtenerCalleNorte() {
        return this.calleNorte;
    }

    public Calle obtenerCalleSur() {
        return this.calleSur;
    }

    public Calle obtenerCalleEste() {
        return this.calleEste;
    }

    public Calle obtenerCalleOeste() {
        return this.calleOeste;
    }

    public Calle obtenerCalleEnDireccion(Vector direccion) {
        // Creo que esto tendriamos que cambiarlo en un futuro
        if (direccion.x() == 1)
            return obtenerCalleEste();
        if (direccion.x() == -1)
            return obtenerCalleOeste();
        if (direccion.y() == 1)
            return obtenerCalleNorte();
        return obtenerCalleSur();
    }
}
