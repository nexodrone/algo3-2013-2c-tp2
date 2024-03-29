package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Juego;
import modelo.excepciones.ErrorArchivoJugadoresException;
import modelo.excepciones.NoHayUsuariosCreadosException;
import vista.PanelBienvenido;
import vista.Ventana;

public class ControladorBienvenido extends Controlador {

    private PanelBienvenido panelBienvenido;

    public ControladorBienvenido() {
        juego = Juego.getInstance();
        juego.setPathJugadores("src/jugadores/jugadores.xml");
        ventana = new Ventana();
        this.agregarPanelLocal();
        ventana.pack();
        ventana.repaint();
    }

    public ControladorBienvenido(String volver){
    	juego = Juego.getInstance();
        juego.setPathJugadores("src/jugadores/jugadores.xml");
        this.agregarPanelLocal();
        ventana.pack();
        ventana.repaint();
    }
    
    private void agregarPanelLocal() {
        this.panelBienvenido = new PanelBienvenido();
        this.panelBienvenido.agregarEscuchaNuevoUsuario(new EscuchaNuevoUsuario());
        this.panelBienvenido.agregarEscuchaUsuarioRegistrado(new EscuchaUsuarioRegistrado());
        this.panelBienvenido.agregarEscuchaSalir(new EscuchaSalir());
        ventana.add(panelBienvenido);
    }

    public class EscuchaNuevoUsuario implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ventana.remove(panelBienvenido);
            ControladorUsuarioNuevo contolador = new ControladorUsuarioNuevo();
        }
    }

    public class EscuchaUsuarioRegistrado implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        	boolean completo = true;            
            try{
            	juego.getPuntajesOrdenados();
            }catch( ErrorArchivoJugadoresException e1 ){
            	panelBienvenido.mostrarMensajeErrorArchivoJugadores();
            	completo = false;
            }catch( NoHayUsuariosCreadosException e2 ){
            	panelBienvenido.mostrarMensajeNoHayUsuariosCreados();
            	completo = false;
            }
            if (completo){
            	ventana.remove(panelBienvenido);
            	ControladorUsuarioRegistrado contolador = new ControladorUsuarioRegistrado();
            }
        }
    }

    public class EscuchaSalir implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ventana.setVisible(false);
            ventana.dispose();
        }
    }
    
    

}
