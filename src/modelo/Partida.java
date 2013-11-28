package modelo;

import java.io.File;

import modelo.excepciones.PartidaInexistente;

import org.simpleframework.xml.*;
import org.simpleframework.xml.core.Persister;

@Root(name = "Partida")
public class Partida {

	@Element ( name = "Tablero")
	private Tablero tablero;
	@Element ( name ="Vehiculo")
	private Vehiculo vehiculo;
	@Element ( name = "PosicionGanadora")
	private Posicion posicionGanadora;
	@Attribute ( name = "CantidadDeMovimientosDisponibles")
	private int movimientosDisponibles;
	
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
		return (posicionGanadora.equals(vehiculo.posicion));
	}
	
	public boolean esPerdida() {
		return (movimientosDisponibles-vehiculo.cantidadDeMovimientos < 1);
	}
	
	public void guardar(String path) throws Exception {
		Serializer serializador = new Persister();
		serializador.write(this,  new File(path));
	}

	public static Partida recuperar(String path) throws PartidaInexistente {
		Serializer deserializador = new Persister();
		try {
			return deserializador.read(Partida.class, new File(path));
		}catch(Exception e){
			throw new PartidaInexistente();
		}
	}

}