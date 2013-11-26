package modelo;

import modelo.Bocacalle;

import java.util.ArrayList;

public class ColumnaDeBocacalles {
	private ArrayList<Bocacalle> columna;
	
	public ColumnaDeBocacalles() {
		this.columna = new ArrayList<Bocacalle>();
	}
	
	public void add(Bocacalle nuevaBocacalle){
		columna.add(nuevaBocacalle);
	}
	
	public Bocacalle get(int index) {
		return columna.get(index);
	}
}