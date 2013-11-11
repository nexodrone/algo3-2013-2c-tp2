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
        for (int i = 0; i < filas; i++) {
            ArrayList<Bocacalle> unArray = new ArrayList<Bocacalle>();
            for (int j = 0; j < columnas; j++) {
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
        if (posicionValidaFila(posicion.getFila()) == false || posicionValidaColumna(posicion.getColumna()) == false) {
            return false;
        }
        return true;
    }

    private boolean posicionValidaFila(int filaPosicion) {
        if (filaPosicion < cantidadDeFilas || filaPosicion > cantidadDeFilas)
            return false;
        return true;
    }

    private boolean posicionValidaColumna(int columnaPosicion) {
        if (columnaPosicion < cantidadDeFilas || columnaPosicion > cantidadDeFilas)
            return false;
        return true;
    }
}
