package modelo;

import java.util.ArrayList;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name = "Tablero")
public class Tablero {

    @ElementList(name = "Bocacalles")
    private ArrayList<ColumnaDeBocacalles> bocacalles;
    @Attribute
    private int cantidadDeColumnas;
    @Attribute
    private int cantidadDeFilas;

    public Tablero(int columnas, int filas) {
        this.cantidadDeColumnas = columnas;
        this.cantidadDeFilas = filas;
        this.bocacalles = new ArrayList<ColumnaDeBocacalles>();
        for (int i = 0; i < columnas; i++) {
            ColumnaDeBocacalles unaColumna = new ColumnaDeBocacalles();
            for (int j = 0; j < filas; j++) {
                unaColumna.add(new Bocacalle());
            }
            this.bocacalles.add(unaColumna);
        }
        unificarCalles();
    }

    public Tablero() {
        this.bocacalles = new ArrayList<ColumnaDeBocacalles>();
    };

    private void unificarCalles() {
        Direccion este = new Direccion(1, 0);
        Direccion norte = new Direccion(0, 1);
        for (int i = 1; i < cantidadDeColumnas; i++) {
            for (int j = 0; j < cantidadDeFilas; j++) { /* unificar calles horizontales */
                this.bocacalles.get(i).get(j).setCalleOeste(this.bocacalles.get(i - 1).get(j).getCalleEnDireccion(este));
            }
        }
        for (int i = 0; i < cantidadDeColumnas; i++) {
            for (int j = 1; j < cantidadDeFilas; j++) { /* unificar calles verticales */
                this.bocacalles.get(i).get(j).setCalleSur(this.bocacalles.get(i).get(j - 1).getCalleEnDireccion(norte));
            }
        }
    }

    public Bocacalle getBocacalleEnPosicion(Posicion posicion) {
        return bocacalles.get(posicion.x()).get(posicion.y());
    }

    public int getCantidadDeFilas() {
        return cantidadDeFilas;
    }

    public int getCantidadDeColumnas() {
        return cantidadDeColumnas;
    }

    public boolean posicionValida(Posicion posicion) {
        System.out.println("Posicion a Verificar:" + posicion.asString());
        if ((posicion.x() < 0) || (posicion.x() >= cantidadDeColumnas) || (posicion.y() < 0) || (posicion.y() >= cantidadDeFilas))
            return false;
        return true;
    }

}
