package modelo;

import java.util.Comparator;

public class PorPuntaje2 implements Comparator<Jugador>{
	
	public int compare(Jugador e1, Jugador e2) {
		return e2.getPuntaje() - e1.getPuntaje();
	}
}
