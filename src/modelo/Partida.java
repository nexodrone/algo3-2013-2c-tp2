package modelo;

import java.io.File;

import modelo.excepciones.PartidaInexistente;

import org.simpleframework.xml.*;
import org.simpleframework.xml.core.Persister;

@Root (name = "Partida")
public class Partida {

	@Element (name = "Tablero")
	private Tablero tablero;
	@Element (name ="Vehiculo")
	private Vehiculo vehiculo;
	@Element (name = "PosicionGanadora")
	private Posicion posicionGanadora;
	@Attribute (name = "CantidadDeMovimientosDisponibles")
	private int movimientosDisponibles;
	@Attribute (name = "Dificultad")
	public int dificultad;
	
	public Partida() {}

	public Partida(Tablero tablero, Vehiculo vehiculo, Posicion posicionGanadora, int movimientosDisponibles) {
		this.tablero = tablero;
		this.vehiculo = vehiculo;
		this.movimientosDisponibles = movimientosDisponibles;
		this.posicionGanadora = posicionGanadora;
	}

	public Tablero getTablero() {
		return this.tablero;
	}

	public Vehiculo getVehiculo() {
		return this.vehiculo;
	}
	
	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}
	
    public Posicion getPosicionGanadora() {
        return this.posicionGanadora;
    }

	public Posicion posicionDelVehiculo() {
		return vehiculo.getPosicion();
	}

	public int getCantidadDeMovimientosDisponibles() {
		return movimientosDisponibles;
	}

	public boolean esGanada() {
		int movRest = this.movimientosDisponibles - vehiculo.getCantidadDeMovimientos();
		return ((movRest >= 0) && (posicionGanadora.equals(vehiculo.getPosicion())));
	}
	
	public boolean esPerdida() {
		int movRest = this.movimientosDisponibles - vehiculo.getCantidadDeMovimientos();
		return ( ((movRest == 0) && (!posicionGanadora.equals(vehiculo.getPosicion()))) || (movRest < 0)  );
	}
	
	public void guardarPartida(String path) throws Exception {
		Serializer serializador = new Persister();
		File archivoXML = new File(path);
		serializador.write(this, archivoXML);
	}

	public static Partida cargarPartida(String path) throws PartidaInexistente {
		Serializer deserializador = new Persister();
		try {
			return deserializador.read(Partida.class, new File(path));
		}catch(Exception e){
			throw new PartidaInexistente();
		}
	}

}