package modelo;

import java.util.ArrayList;

public class Tablero {

    private ArrayList<ArrayList<Bocacalle>> bocacalles;
    private int cantidadDeColumnas;
    private int cantidadDeFilas;

    public Tablero(int columnas, int filas) {
        this.cantidadDeColumnas = columnas;
        this.cantidadDeFilas = filas;
        this.bocacalles = new ArrayList<ArrayList<Bocacalle>>();
        for (int i = 0; i < columnas; i++) {
            ArrayList<Bocacalle> unArray = new ArrayList<Bocacalle>();
            for (int j = 0; j < filas; j++) {
                unArray.add(new Bocacalle());
            }
            this.bocacalles.add(unArray);
        }
        unificarCalles();
    }

    private void unificarCalles() {
        Vector este = new Vector(1,0);
        Vector norte = new Vector(0,1);
        for (int i=1; i<cantidadDeColumnas; i++) {
            for (int j=0; j<cantidadDeFilas; j++) { // unificar calles horizontales
                this.bocacalles.get(i).get(j).setCalleOeste(this.bocacalles.get(i-1).get(j).obtenerCalleEnDireccion(este));
            }
        }
        for (int i=0; i<cantidadDeColumnas; i++) {
            for (int j=1; j<cantidadDeFilas; j++) { // unificar calles verticales
                this.bocacalles.get(i).get(j).setCalleSur(this.bocacalles.get(i).get(j-1).obtenerCalleEnDireccion(norte));
            }
        }
    }

    public Bocacalle getBocacalleEnPosicion(Vector posicion) {
        return bocacalles.get(posicion.x()).get(posicion.y());
    }

    public int getCantidadDeFilas() {
        return cantidadDeFilas;
    }

    public int getCantidadDeColumnas() {
        return cantidadDeColumnas;
    }

    public boolean posicionValida(Vector posicion) {
        if ( (posicion.x() < 0) ||
        	 (posicion.x() >= cantidadDeColumnas) ||
        	 (posicion.y() < 0) ||
        	 (posicion.y() >= cantidadDeFilas) )
            return false;
        return true;
    }

}
