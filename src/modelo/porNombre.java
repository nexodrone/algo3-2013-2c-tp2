package modelo;

import java.util.Comparator;
import java.util.Map.Entry;

public class porNombre implements Comparator<Entry<String,Integer>>{
	
	public int compare(Entry<String, Integer> e1, Entry<String, Integer> e2) {
		return e2.getValue() - e1.getValue();
	}
}
