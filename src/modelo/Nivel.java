package modelo;

public class Nivel {

	public int movimientosDisponibles;
	public int filasTablero;
	public int columnasTablero;
	public int cantidadDeSorpresas;
	public int cantidadDeObstaculos;
	
	public Nivel() {
		this.movimientosDisponibles = 30;
		this.filasTablero = 10;
		this.columnasTablero = 10;
		this.cantidadDeSorpresas = 5;
		this.cantidadDeObstaculos = 5;
	}
	
	public int getCantidadDeMovimientos(){
		return movimientosDisponibles;
	}
	
	public int getCantidadDeFilas(){
		return filasTablero;
	}
	
	public int getCantidadDeColumnas(){
		return columnasTablero;
	}
	
	public int getCantidadDeSorpresas(){
		return cantidadDeSorpresas;
	}
	
	public int getCantidadDeObstaculos(){
		return cantidadDeObstaculos;
	}
	
}
