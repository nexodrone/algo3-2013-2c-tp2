package modelo;

public class Jugador {

	private String nickName;
	private int cantidadDeMovimientos;

	public Jugador(String nombre) {
		nickName = nombre;
		cantidadDeMovimientos = 0;
	}

	public String getNickName() {
		return this.nickName;
	}

	public int getCantidadDeMovimientos() {
		return this.cantidadDeMovimientos;
	}

	public void sumarMovimientos(int cantidad) {
		this.cantidadDeMovimientos = this.cantidadDeMovimientos + cantidad;		
	}

}
