package modelo;

import java.io.File;

import org.simpleframework.xml.*;
import org.simpleframework.xml.core.Persister;

@Root (name = "Bocacalle")
public class Bocacalle {

	@Element
    private Calle calleNorte;
	@Element
	private Calle calleSur;
	@Element
	private Calle calleEste;
	@Element
	private Calle calleOeste;

    public Bocacalle() {
        this.calleNorte = new Calle();
        this.calleSur = new Calle();
        this.calleEste = new Calle();
        this.calleOeste = new Calle();
    }
    
    public void setCalleSur(Calle calleSur) { /* visibilidad en paquete, necesario para constructor del tablero */
        this.calleSur = calleSur;
    }

    public void setCalleOeste(Calle calleOeste) { /* visibilidad en paquete, necesario para constructor del tablero */
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
   
//    public void guardar(String path) throws Exception{
//    	Serializer serializador = new Persister();
//    	File resultado = new File(path);
//    	serializador.write(this, resultado);
//    }
//
//    public static Bocacalle recuperar(String path) throws Exception{
//    Serializer deserializador = new Persister();
//    File src = new File(path);
//    return deserializador.read(Bocacalle.class, src);
//    }
}
