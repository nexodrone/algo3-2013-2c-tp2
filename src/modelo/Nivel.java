package modelo;

import java.io.File;

import org.simpleframework.xml.*;
import org.simpleframework.xml.core.Persister;

@Root (name = "Nivel")
public class Nivel {
	
	@Attribute
	public int movimientosDisponibles;
	@Attribute
	public int dificultad;
	@Element
	public Tablero tablero;
	
	public Nivel() {
			Direccion norte = new Direccion(0, 1);
	        Direccion este = new Direccion(1, 0);
	        Direccion oeste = new Direccion(-1, 0);
	        
			tablero =  new Tablero(14,12);
			movimientosDisponibles = 35;
			
			tablero.getBocacalleEnPosicion(new Posicion(3,0)).getCalleEnDireccion(oeste).setObstaculo(new ObstaculoPozo());
			tablero.getBocacalleEnPosicion(new Posicion(0,1)).getCalleEnDireccion(oeste).setObstaculo(new ObstaculoPozo());
			tablero.getBocacalleEnPosicion(new Posicion(5,1)).getCalleEnDireccion(este).setObstaculo(new ObstaculoPozo());
			tablero.getBocacalleEnPosicion(new Posicion(7,1)).getCalleEnDireccion(norte).setObstaculo(new ObstaculoControlPolicial());
			tablero.getBocacalleEnPosicion(new Posicion(9,1)).getCalleEnDireccion(norte).setSorpresa(new SorpresaDesfavorable());
			tablero.getBocacalleEnPosicion(new Posicion(13,1)).getCalleEnDireccion(norte).setObstaculo(new ObstaculoPozo());
			tablero.getBocacalleEnPosicion(new Posicion(11,2)).getCalleEnDireccion(norte).setObstaculo(new ObstaculoPiquete());
			tablero.getBocacalleEnPosicion(new Posicion(3,2)).getCalleEnDireccion(norte).setSorpresa(new SorpresaFavorable());
			tablero.getBocacalleEnPosicion(new Posicion(0,3)).getCalleEnDireccion(oeste).setObstaculo(new ObstaculoPozo());
			tablero.getBocacalleEnPosicion(new Posicion(4,3)).getCalleEnDireccion(este).setObstaculo(new ObstaculoPozo());
			tablero.getBocacalleEnPosicion(new Posicion(7,3)).getCalleEnDireccion(norte).setSorpresa(new SorpresaCambioDeVehiculo());
			tablero.getBocacalleEnPosicion(new Posicion(9,3)).getCalleEnDireccion(norte).setObstaculo(new ObstaculoPiquete());
			tablero.getBocacalleEnPosicion(new Posicion(1,4)).getCalleEnDireccion(oeste).setObstaculo(new ObstaculoControlPolicial());
			tablero.getBocacalleEnPosicion(new Posicion(11,4)).getCalleEnDireccion(oeste).setSorpresa(new SorpresaFavorable());
			tablero.getBocacalleEnPosicion(new Posicion(11,4)).getCalleEnDireccion(oeste).setSorpresa(new SorpresaFavorable());
			tablero.getBocacalleEnPosicion(new Posicion(3,4)).getCalleEnDireccion(norte).setSorpresa(new SorpresaDesfavorable());
			tablero.getBocacalleEnPosicion(new Posicion(2,5)).getCalleEnDireccion(oeste).setSorpresa(new SorpresaFavorable());
			tablero.getBocacalleEnPosicion(new Posicion(5,5)).getCalleEnDireccion(este).setSorpresa(new SorpresaCambioDeVehiculo());
			tablero.getBocacalleEnPosicion(new Posicion(12,5)).getCalleEnDireccion(este).setObstaculo(new ObstaculoPozo());
			tablero.getBocacalleEnPosicion(new Posicion(4,6)).getCalleEnDireccion(oeste).setSorpresa(new SorpresaDesfavorable());
			tablero.getBocacalleEnPosicion(new Posicion(7,6)).getCalleEnDireccion(este).setSorpresa(new SorpresaDesfavorable());
			tablero.getBocacalleEnPosicion(new Posicion(10,6)).getCalleEnDireccion(este).setSorpresa(new SorpresaFavorable());
			tablero.getBocacalleEnPosicion(new Posicion(2,7)).getCalleEnDireccion(oeste).setObstaculo(new ObstaculoPiquete());
			tablero.getBocacalleEnPosicion(new Posicion(5,7)).getCalleEnDireccion(este).setObstaculo(new ObstaculoControlPolicial());
			tablero.getBocacalleEnPosicion(new Posicion(7,7)).getCalleEnDireccion(norte).setObstaculo(new ObstaculoPiquete());
			tablero.getBocacalleEnPosicion(new Posicion(11,8)).getCalleEnDireccion(este).setObstaculo(new ObstaculoPiquete());
			tablero.getBocacalleEnPosicion(new Posicion(0,9)).getCalleEnDireccion(este).setSorpresa(new SorpresaCambioDeVehiculo());
			tablero.getBocacalleEnPosicion(new Posicion(3,9)).getCalleEnDireccion(este).setObstaculo(new ObstaculoPiquete());
			tablero.getBocacalleEnPosicion(new Posicion(10,9)).getCalleEnDireccion(este).setObstaculo(new ObstaculoControlPolicial());
			tablero.getBocacalleEnPosicion(new Posicion(0,10)).getCalleEnDireccion(este).setSorpresa(new SorpresaFavorable());
			tablero.getBocacalleEnPosicion(new Posicion(7,10)).getCalleEnDireccion(este).setSorpresa(new SorpresaCambioDeVehiculo());
			tablero.getBocacalleEnPosicion(new Posicion(3,11)).getCalleEnDireccion(este).setSorpresa(new SorpresaDesfavorable());
			tablero.getBocacalleEnPosicion(new Posicion(9,11)).getCalleEnDireccion(este).setSorpresa(new SorpresaFavorable());
			
			dificultad = 2;
			
	}

	
	public void guardarNivel(String path) throws Exception {
		Serializer serializador = new Persister();
		File archivoXML = new File(path);
		serializador.write(this, archivoXML);
	}
	
	public static Nivel cargarNivel(String path) throws Exception {
		Serializer deserializador = new Persister();
		File archivoXML = new File(path);
		return deserializador.read(Nivel.class, archivoXML);
	}	
	
	public Tablero getTablero(){
		return this.tablero;
	}
}
