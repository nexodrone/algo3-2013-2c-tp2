package niveles;

import modelo.Direccion;
import modelo.Nivel;
import modelo.ObstaculoControlPolicial;
import modelo.ObstaculoPiquete;
import modelo.ObstaculoPozo;
import modelo.Posicion;
import modelo.SorpresaCambioDeVehiculo;
import modelo.SorpresaDesfavorable;
import modelo.SorpresaFavorable;
import modelo.Tablero;

public class EditorDeNiveles {
	
	
	
	public static void crearNivelFacil() throws Exception{
		Direccion norte = new Direccion(0, 1);
        Direccion sur = new Direccion(0, -1);
        Direccion este = new Direccion(1, 0);
        Direccion oeste = new Direccion(-1, 0);
		
		Nivel nivel = new Nivel();
		nivel.tablero =  new Tablero(5,10);
		nivel.movimientosDisponibles = 35;
		
		nivel.tablero.getBocacalleEnPosicion(new Posicion(0,0)).getCalleEnDireccion(norte).setSorpresa(new SorpresaFavorable());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(2,0)).getCalleEnDireccion(sur).setObstaculo(new ObstaculoPozo());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(3,0)).getCalleEnDireccion(norte).setObstaculo(new ObstaculoPozo());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(2,1)).getCalleEnDireccion(norte).setObstaculo(new ObstaculoPozo());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(1,2)).getCalleEnDireccion(norte).setObstaculo(new ObstaculoPiquete());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(1,3)).getCalleEnDireccion(este).setSorpresa(new SorpresaCambioDeVehiculo());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(3,3)).getCalleEnDireccion(norte).setSorpresa(new SorpresaFavorable());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(0,3)).getCalleEnDireccion(norte).setObstaculo(new ObstaculoControlPolicial());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(1,4)).getCalleEnDireccion(oeste).setSorpresa(new SorpresaFavorable());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(2,4)).getCalleEnDireccion(norte).setSorpresa(new SorpresaCambioDeVehiculo());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(2,4)).getCalleEnDireccion(norte).setObstaculo(new ObstaculoPozo());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(4,4)).getCalleEnDireccion(norte).setSorpresa(new SorpresaFavorable());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(0,5)).getCalleEnDireccion(norte).setSorpresa(new SorpresaFavorable());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(1,6)).getCalleEnDireccion(norte).setSorpresa(new SorpresaFavorable());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(1,6)).getCalleEnDireccion(norte).setObstaculo(new ObstaculoControlPolicial());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(4,6)).getCalleEnDireccion(norte).setObstaculo(new ObstaculoControlPolicial());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(3,7)).getCalleEnDireccion(este).setObstaculo(new ObstaculoControlPolicial());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(2,7)).getCalleEnDireccion(norte).setObstaculo(new ObstaculoControlPolicial());
				
		nivel.dificultad = 1;
		nivel.guardarNivel("src/niveles/NivelFacil.xml");
	}
	
	public static void crearNivelIntermedio() throws Exception{
		Direccion norte = new Direccion(0, 1);
        Direccion este = new Direccion(1, 0);
        Direccion oeste = new Direccion(-1, 0);
        
        Nivel nivel = new Nivel();
		nivel.tablero =  new Tablero(14,12);
		nivel.movimientosDisponibles = 35;
		
		nivel.tablero.getBocacalleEnPosicion(new Posicion(3,0)).getCalleEnDireccion(oeste).setObstaculo(new ObstaculoPozo());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(0,1)).getCalleEnDireccion(oeste).setObstaculo(new ObstaculoPozo());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(5,1)).getCalleEnDireccion(este).setObstaculo(new ObstaculoPozo());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(7,1)).getCalleEnDireccion(norte).setObstaculo(new ObstaculoControlPolicial());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(9,1)).getCalleEnDireccion(norte).setSorpresa(new SorpresaDesfavorable());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(13,1)).getCalleEnDireccion(norte).setObstaculo(new ObstaculoPozo());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(11,2)).getCalleEnDireccion(norte).setObstaculo(new ObstaculoPiquete());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(3,2)).getCalleEnDireccion(norte).setSorpresa(new SorpresaFavorable());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(0,3)).getCalleEnDireccion(oeste).setObstaculo(new ObstaculoPozo());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(4,3)).getCalleEnDireccion(este).setObstaculo(new ObstaculoPozo());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(7,3)).getCalleEnDireccion(norte).setSorpresa(new SorpresaCambioDeVehiculo());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(9,3)).getCalleEnDireccion(norte).setObstaculo(new ObstaculoPiquete());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(1,4)).getCalleEnDireccion(oeste).setObstaculo(new ObstaculoControlPolicial());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(11,4)).getCalleEnDireccion(oeste).setSorpresa(new SorpresaFavorable());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(11,4)).getCalleEnDireccion(oeste).setSorpresa(new SorpresaFavorable());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(3,4)).getCalleEnDireccion(norte).setSorpresa(new SorpresaDesfavorable());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(2,5)).getCalleEnDireccion(oeste).setSorpresa(new SorpresaFavorable());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(5,5)).getCalleEnDireccion(este).setSorpresa(new SorpresaCambioDeVehiculo());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(12,5)).getCalleEnDireccion(este).setObstaculo(new ObstaculoPozo());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(4,6)).getCalleEnDireccion(oeste).setSorpresa(new SorpresaDesfavorable());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(7,6)).getCalleEnDireccion(este).setSorpresa(new SorpresaDesfavorable());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(10,6)).getCalleEnDireccion(este).setSorpresa(new SorpresaFavorable());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(2,7)).getCalleEnDireccion(oeste).setObstaculo(new ObstaculoPiquete());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(5,7)).getCalleEnDireccion(este).setObstaculo(new ObstaculoControlPolicial());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(7,7)).getCalleEnDireccion(norte).setObstaculo(new ObstaculoPiquete());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(11,8)).getCalleEnDireccion(este).setObstaculo(new ObstaculoPiquete());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(0,9)).getCalleEnDireccion(este).setSorpresa(new SorpresaCambioDeVehiculo());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(3,9)).getCalleEnDireccion(este).setObstaculo(new ObstaculoPiquete());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(10,9)).getCalleEnDireccion(este).setObstaculo(new ObstaculoControlPolicial());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(0,10)).getCalleEnDireccion(este).setSorpresa(new SorpresaFavorable());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(7,10)).getCalleEnDireccion(este).setSorpresa(new SorpresaCambioDeVehiculo());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(3,11)).getCalleEnDireccion(este).setSorpresa(new SorpresaDesfavorable());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(9,11)).getCalleEnDireccion(este).setSorpresa(new SorpresaFavorable());
		
		nivel.dificultad = 2;
		nivel.guardarNivel("src/niveles/NivelIntermedio.xml");
	}
	
	
	public static void crearNivelDificil() throws Exception{
		Direccion norte = new Direccion(0, 1);
        Direccion sur = new Direccion(0, -1);
        Direccion este = new Direccion(1, 0);
        Direccion oeste = new Direccion(-1, 0);
        
        Nivel nivel = new Nivel();
		nivel.tablero =  new Tablero(21,14);
		nivel.movimientosDisponibles = 100;
		
		nivel.tablero.getBocacalleEnPosicion(new Posicion(0,0)).getCalleEnDireccion(sur).setObstaculo(new ObstaculoPozo());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(1,0)).getCalleEnDireccion(este).setSorpresa(new SorpresaDesfavorable());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(3,0)).getCalleEnDireccion(oeste).setObstaculo(new ObstaculoControlPolicial());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(4,0)).getCalleEnDireccion(norte).setSorpresa(new SorpresaCambioDeVehiculo());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(5,0)).getCalleEnDireccion(oeste).setObstaculo(new ObstaculoPozo());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(9,0)).getCalleEnDireccion(oeste).setSorpresa(new SorpresaFavorable());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(11,0)).getCalleEnDireccion(este).setObstaculo(new ObstaculoPiquete());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(15,0)).getCalleEnDireccion(oeste).setSorpresa(new SorpresaFavorable());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(19,0)).getCalleEnDireccion(oeste).setSorpresa(new SorpresaDesfavorable());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(5,1)).getCalleEnDireccion(oeste).setObstaculo(new ObstaculoPiquete());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(8,1)).getCalleEnDireccion(sur).setSorpresa(new SorpresaCambioDeVehiculo());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(8,1)).getCalleEnDireccion(oeste).setObstaculo(new ObstaculoControlPolicial());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(10,1)).getCalleEnDireccion(este).setSorpresa(new SorpresaFavorable());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(15,1)).getCalleEnDireccion(norte).setObstaculo(new ObstaculoPozo());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(14,1)).getCalleEnDireccion(oeste).setObstaculo(new ObstaculoControlPolicial());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(17,1)).getCalleEnDireccion(este).setObstaculo(new ObstaculoPozo());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(19,1)).getCalleEnDireccion(oeste).setObstaculo(new ObstaculoPozo());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(3,2)).getCalleEnDireccion(oeste).setObstaculo(new ObstaculoPozo());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(0,3)).getCalleEnDireccion(oeste).setObstaculo(new ObstaculoPozo());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(2,1)).getCalleEnDireccion(este).setObstaculo(new ObstaculoPozo());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(18,2)).getCalleEnDireccion(norte).setObstaculo(new ObstaculoControlPolicial());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(6,2)).getCalleEnDireccion(norte).setSorpresa(new SorpresaDesfavorable());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(9,2)).getCalleEnDireccion(norte).setObstaculo(new ObstaculoPozo());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(11,2)).getCalleEnDireccion(norte).setObstaculo(new ObstaculoPiquete());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(14,2)).getCalleEnDireccion(oeste).setSorpresa(new SorpresaFavorable());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(2,3)).getCalleEnDireccion(oeste).setObstaculo(new ObstaculoPozo());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(4,3)).getCalleEnDireccion(este).setObstaculo(new ObstaculoPozo());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(7,3)).getCalleEnDireccion(norte).setSorpresa(new SorpresaCambioDeVehiculo());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(9,3)).getCalleEnDireccion(norte).setObstaculo(new ObstaculoPiquete());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(14,3)).getCalleEnDireccion(oeste).setObstaculo(new ObstaculoControlPolicial());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(16,3)).getCalleEnDireccion(oeste).setSorpresa(new SorpresaFavorable());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(11,4)).getCalleEnDireccion(oeste).setSorpresa(new SorpresaFavorable());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(17,4)).getCalleEnDireccion(norte).setSorpresa(new SorpresaDesfavorable());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(4,4)).getCalleEnDireccion(oeste).setSorpresa(new SorpresaFavorable());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(5,5)).getCalleEnDireccion(este).setSorpresa(new SorpresaCambioDeVehiculo());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(12,5)).getCalleEnDireccion(este).setObstaculo(new ObstaculoPozo());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(4,5)).getCalleEnDireccion(oeste).setSorpresa(new SorpresaDesfavorable());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(17,5)).getCalleEnDireccion(este).setSorpresa(new SorpresaDesfavorable());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(10,5)).getCalleEnDireccion(este).setSorpresa(new SorpresaFavorable());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(8,5)).getCalleEnDireccion(oeste).setObstaculo(new ObstaculoPiquete());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(14,5)).getCalleEnDireccion(este).setObstaculo(new ObstaculoControlPolicial());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(12,4)).getCalleEnDireccion(norte).setObstaculo(new ObstaculoPiquete());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(15,4)).getCalleEnDireccion(este).setObstaculo(new ObstaculoPiquete());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(20,4)).getCalleEnDireccion(sur).setObstaculo(new ObstaculoPiquete());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(1,5)).getCalleEnDireccion(este).setSorpresa(new SorpresaCambioDeVehiculo());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(3,6)).getCalleEnDireccion(este).setObstaculo(new ObstaculoPiquete());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(10,6)).getCalleEnDireccion(este).setObstaculo(new ObstaculoControlPolicial());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(0,6)).getCalleEnDireccion(este).setSorpresa(new SorpresaFavorable());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(7,6)).getCalleEnDireccion(este).setSorpresa(new SorpresaCambioDeVehiculo());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(15,6)).getCalleEnDireccion(este).setSorpresa(new SorpresaDesfavorable());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(13,6)).getCalleEnDireccion(este).setSorpresa(new SorpresaFavorable());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(5,7)).getCalleEnDireccion(norte).setObstaculo(new ObstaculoPiquete());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(20,7)).getCalleEnDireccion(oeste).setObstaculo(new ObstaculoControlPolicial());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(15,7)).getCalleEnDireccion(oeste).setSorpresa(new SorpresaFavorable());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(2,7)).getCalleEnDireccion(oeste).setSorpresa(new SorpresaFavorable());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(10,7)).getCalleEnDireccion(norte).setSorpresa(new SorpresaDesfavorable());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(7,7)).getCalleEnDireccion(oeste).setSorpresa(new SorpresaFavorable());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(19,8)).getCalleEnDireccion(este).setSorpresa(new SorpresaCambioDeVehiculo());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(12,8)).getCalleEnDireccion(este).setObstaculo(new ObstaculoPozo());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(4,8)).getCalleEnDireccion(oeste).setSorpresa(new SorpresaDesfavorable());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(2,8)).getCalleEnDireccion(este).setSorpresa(new SorpresaDesfavorable());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(16,8)).getCalleEnDireccion(este).setSorpresa(new SorpresaFavorable());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(2,9)).getCalleEnDireccion(oeste).setObstaculo(new ObstaculoPiquete());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(8,9)).getCalleEnDireccion(este).setObstaculo(new ObstaculoControlPolicial());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(18,9)).getCalleEnDireccion(norte).setObstaculo(new ObstaculoPiquete());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(11,9)).getCalleEnDireccion(este).setObstaculo(new ObstaculoPiquete());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(0,9)).getCalleEnDireccion(este).setSorpresa(new SorpresaCambioDeVehiculo());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(20,9)).getCalleEnDireccion(oeste).setObstaculo(new ObstaculoControlPolicial());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(20,10)).getCalleEnDireccion(norte).setObstaculo(new ObstaculoPozo());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(19,10)).getCalleEnDireccion(oeste).setSorpresa(new SorpresaDesfavorable());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(15,10)).getCalleEnDireccion(oeste).setObstaculo(new ObstaculoPiquete());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(8,10)).getCalleEnDireccion(sur).setSorpresa(new SorpresaCambioDeVehiculo());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(4,10)).getCalleEnDireccion(oeste).setObstaculo(new ObstaculoControlPolicial());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(10,10)).getCalleEnDireccion(este).setSorpresa(new SorpresaFavorable());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(5,10)).getCalleEnDireccion(norte).setObstaculo(new ObstaculoPozo());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(20,11)).getCalleEnDireccion(oeste).setObstaculo(new ObstaculoControlPolicial());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(17,11)).getCalleEnDireccion(este).setObstaculo(new ObstaculoPozo());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(4,11)).getCalleEnDireccion(oeste).setObstaculo(new ObstaculoPozo());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(9,11)).getCalleEnDireccion(oeste).setObstaculo(new ObstaculoPozo());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(7,9)).getCalleEnDireccion(oeste).setObstaculo(new ObstaculoPozo());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(2,12)).getCalleEnDireccion(este).setObstaculo(new ObstaculoPozo());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(18,12)).getCalleEnDireccion(norte).setObstaculo(new ObstaculoControlPolicial());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(6,12)).getCalleEnDireccion(norte).setSorpresa(new SorpresaDesfavorable());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(9,12)).getCalleEnDireccion(norte).setObstaculo(new ObstaculoPozo());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(8,12)).getCalleEnDireccion(oeste).setObstaculo(new ObstaculoPiquete());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(14,13)).getCalleEnDireccion(oeste).setSorpresa(new SorpresaFavorable());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(2,13)).getCalleEnDireccion(oeste).setObstaculo(new ObstaculoPozo());
		nivel.tablero.getBocacalleEnPosicion(new Posicion(4,13)).getCalleEnDireccion(este).setObstaculo(new ObstaculoPozo());	
		
		nivel.dificultad = 3;
		nivel.guardarNivel("src/niveles/NivelDificil.xml");
	}
	
	public static void main(String args[]) throws Exception {
		crearNivelFacil();
		crearNivelIntermedio();
		crearNivelDificil();
	}
}
