package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import modelo.Jugador;
import modelo.excepciones.NoHayUsuariosCreadosException;
import modelo.excepciones.UsuarioExistenteException;
import vista.PanelUsuarioNuevo;

public class ControladorUsuarioNuevo extends Controlador {

    private PanelUsuarioNuevo panelUsuarioNuevo;

    public ControladorUsuarioNuevo() {
        this.agregarPanelLocal();
        ventana.pack();
        ventana.repaint();
    }

    private void agregarPanelLocal() {
        this.panelUsuarioNuevo = new PanelUsuarioNuevo();
        this.panelUsuarioNuevo.agregarEscuchaVolver(new EscuchaVolver());
        this.panelUsuarioNuevo.agregarEscuchaGuardar(new EscuchaGuardar());
        this.panelUsuarioNuevo.agregarEscuchaEnter(new EscuchaEnter());
        ventana.add(panelUsuarioNuevo);
    }

    public class EscuchaVolver implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ventana.remove(panelUsuarioNuevo);
            ControladorBienvenido contolador = new ControladorBienvenido("volver");
        }
    }

    public class EscuchaGuardar implements ActionListener {
    	
    	boolean completo;
    	
        @Override
        public void actionPerformed(ActionEvent e) {
        	completo = true;
        	String nombre = panelUsuarioNuevo.getNombreDelCampo().trim();
            if (nombre.isEmpty()) {
                panelUsuarioNuevo.mostrarMensajeCampoVacio();
            } else {
                juego.setJugadorActual(new Jugador(nombre));
                try {
					juego.crearUsuario(nombre);
				} catch (UsuarioExistenteException e1) {
					System.out.print("Usuario existente.");
					panelUsuarioNuevo.mostrarMensajeNombreNoDisponible();
					completo = false;
				} catch (NoHayUsuariosCreadosException e1) {
					System.out.print("No existe archivo de puntajes.");
					panelUsuarioNuevo.mostrarMensajeNoExisteArchivoDePuntajes();
					juego.inicializarPuntajesCon(nombre);
				}
                
                if ( completo ) {
                	ventana.remove(panelUsuarioNuevo);
                	ControladorMenuPrincipal contolador = new ControladorMenuPrincipal();
                }
            };
        }
    }

    public class EscuchaEnter implements KeyListener {
    	
    	boolean completo;
    	
        @Override
        public void keyPressed(KeyEvent e) {
        }

        @Override
        public void keyReleased(KeyEvent e) {
        	completo = true;
            if (e.getKeyChar() == KeyEvent.VK_ENTER) {
            	String nombre = panelUsuarioNuevo.getNombreDelCampo().trim();
                if (nombre.isEmpty()) {
                    panelUsuarioNuevo.mostrarMensajeCampoVacio();
                } else {
                    juego.setJugadorActual(new Jugador(nombre));
                    try {
    					juego.crearUsuario(nombre);
    				} catch (UsuarioExistenteException e1) {
    					//System.out.print("Usuario existente.\n");
    					panelUsuarioNuevo.mostrarMensajeNombreNoDisponible();
    					completo = false;
    				} catch (NoHayUsuariosCreadosException e1) {
    					//System.out.print("No existe archivo de puntajes.\n");
    					juego.inicializarPuntajes();
    					panelUsuarioNuevo.mostrarMensajeNoExisteArchivoDePuntajes();
    					completo = false;
    				}
                    
                    if ( completo ) {
                    	ventana.remove(panelUsuarioNuevo);
                    	ControladorMenuPrincipal contolador = new ControladorMenuPrincipal();
                    }
                };
            }
        }

        @Override
        public void keyTyped(KeyEvent e) {
        }
    }

}
