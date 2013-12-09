package vista;

public class Manzana extends VistaEventoColicion {
    static int longitud = 20;
    static String direccion = "src/vista/imagenes/manzana.png";

    public Manzana(int posX, int posY) {
        super(direccion, posX, posY, longitud, longitud);

    }

}
