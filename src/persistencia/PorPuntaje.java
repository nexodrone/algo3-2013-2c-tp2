package persistencia;

import java.util.Comparator;
import modelo.Puntaje;

public class PorPuntaje implements Comparator<Puntaje>{
	
	public int compare(Puntaje e1, Puntaje e2) {
		return e2.getPuntaje() - e1.getPuntaje();
	}
}
