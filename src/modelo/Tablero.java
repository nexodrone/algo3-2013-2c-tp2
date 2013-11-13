package modelo;

import java.util.ArrayList;

public class Tablero {

    private ArrayList<ArrayList<Bocacalle>> bocacalles;
    private int cantidadDeFilas;
    private int cantidadDeColumnas;

    public Tablero(int filas, int columnas) {
        this.cantidadDeFilas = filas;
        this.cantidadDeColumnas = columnas;
        this.bocacalles = new ArrayList<ArrayList<Bocacalle>>();
        for (int i = 0; i < filas+1; i++) {
            ArrayList<Bocacalle> unArray = new ArrayList<Bocacalle>();
            for (int j = 0; j < columnas+1; j++) {
                unArray.add(new Bocacalle());
            }
            this.bocacalles.add(unArray);
        }
        unificarCalles();
    }

    private void unificarCalles() {
        Vector este = new Vector(1, 0);
        for (int i = 0; i < cantidadDeFilas; i++) {
            for (int j = 1; j < cantidadDeColumnas; j++) { // unificar calles horizontales
                this.bocacalles.get(i).get(j).setCalleOeste(this.bocacalles.get(i).get(j - 1).obtenerCalleEnDireccion(este));
            }
        }
        for (int i = 1; i < cantidadDeFilas; i++) {
            Vector sur = new Vector(0, -1);
            for (int j = 0; j < cantidadDeColumnas; j++) { // unificar calles verticales
                this.bocacalles.get(i).get(j).setCalleNorte(this.bocacalles.get(i - 1).get(j).obtenerCalleEnDireccion(sur));
            }
        }
    }

    public Bocacalle getBocacalleEnPosicion(Posicion posicion) {
        return bocacalles.get(posicion.getFila()).get(posicion.getColumna());
    }

    public int getCantidadDeFilas() {
        return cantidadDeFilas;
    }

    public int getCantidadDeColumnas() {
        return cantidadDeColumnas;
    }

    public boolean posicionValida(Posicion posicion) {
        if (filaValida(posicion.getFila()) == false || columnaValida(posicion.getColumna()) == false) {
            return false;
        }
        return true;
    }

    private boolean filaValida(int filaPosicion) {
        if (filaPosicion < 0 || filaPosicion > cantidadDeFilas)
            return false;
        return true;
    }

    private boolean columnaValida(int columnaPosicion) {
    	if (columnaPosicion < 0 || columnaPosicion > cantidadDeColumnas)
            return false;
        return true;
    }
}
