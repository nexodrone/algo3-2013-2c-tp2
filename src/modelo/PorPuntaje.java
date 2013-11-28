package modelo;

import java.util.Comparator;

public class PorPuntaje implements Comparator<Puntaje>{
	
	public int compare(Puntaje e1, Puntaje e2) {
		return e2.getPuntaje() - e1.getPuntaje();
	}
}
