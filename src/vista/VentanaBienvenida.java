package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaBienvenida extends VentanaGeneral {

    private static final long serialVersionUID = 1L;

    public VentanaBienvenida() {
        super("Bienvenido a GPS CHALLENGE");
        this.agregarBtnNuevoUsuario();
        this.agregarBtnUsuarioRegistrado();

    }

    private void agregarBtnNuevoUsuario() {
        String direccion = "src/vista/imagenes/btnNuevoUsuario.png";
        Boton btnNuevoUsuario = new Boton(250, 0, direccion, "nombre");
        btnNuevoUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                // registrar usuario
            }
        });
        this.getContentPane().add(btnNuevoUsuario);
    }

    private void agregarBtnUsuarioRegistrado() {
        String direccion = "src/vista/imagenes/btnUsuarioRegistrado.png";
        Boton btnUsuarioRegistrado = new Boton(250, 100, direccion, "usuario");
        btnUsuarioRegistrado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                // registrar usuario
            }
        });
        this.getContentPane().add(btnUsuarioRegistrado);

    }

    public static void main(String[] arguments) {
        VentanaBienvenida ventana = new VentanaBienvenida();

    }
}
