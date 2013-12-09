package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ActionMap;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.InputMap;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import modelo.Juego;
import modelo.Posicion;
import modelo.Tablero;

public class PanelPartida extends JPanel {

    private Boton botonGuardar = new Boton("Guardar");
    private Boton botonVolver = new Boton("Volver");
    private JLabel nombreUsuario;
    private JLabel dificultad;
    private JLabel vehiculoActual;
    private PanelZonaDeJuego panelZonaDelJuego;
    private JPanel panelInfo = new JPanel();
    private int anchoZonaDelJuego = 870; //ideal = 860
    private int largoZonaDelJuego = 610; //ideal = 580
    String nivelSeleccionado;

    public PanelPartida(String nombre, String dificultad, String vehiculo, Tablero tablero, Posicion posicionVehiculo, Posicion posicionLlegada) {
        this.setLayout(new FlowLayout());
        this.setPreferredSize(new Dimension(1180, 680));
        this.setBackground(new Color(255, 255, 255, 200));
        this.nivelSeleccionado = dificultad;
        
        this.panelInfo.setPreferredSize(new Dimension(250,610));
        this.panelInfo.setLayout(new BoxLayout(panelInfo, BoxLayout.PAGE_AXIS));
        this.panelInfo.setBackground(new Color(0,0,0,0));
        this.nombreUsuario = new JLabel("Jugador:   " + nombre);
        this.nombreUsuario.setAlignmentX(CENTER_ALIGNMENT);
        this.dificultad = new JLabel("Dificultad:   " + dificultad);
        this.dificultad.setAlignmentX(CENTER_ALIGNMENT);
        this.vehiculoActual = new JLabel("Vehiculo:   " + vehiculo);
        this.vehiculoActual.setAlignmentX(CENTER_ALIGNMENT);
        
        this.panelZonaDelJuego = new PanelZonaDeJuego(tablero, vehiculo, posicionVehiculo, posicionLlegada);
        this.panelZonaDelJuego.setPreferredSize(new Dimension(anchoZonaDelJuego,largoZonaDelJuego));

        this.botonGuardar.setAlignmentX(CENTER_ALIGNMENT);
        this.botonVolver.setAlignmentX(CENTER_ALIGNMENT);

        this.panelInfo.add(Box.createVerticalStrut(10));
        this.panelInfo.add(this.nombreUsuario);
        this.panelInfo.add(Box.createVerticalStrut(10));
        this.panelInfo.add(this.dificultad);
        this.panelInfo.add(Box.createVerticalStrut(10));
        this.panelInfo.add(this.vehiculoActual);
        this.panelInfo.add(Box.createVerticalStrut(50));
        this.panelInfo.add(botonGuardar);
        this.panelInfo.add(Box.createVerticalStrut(20));
        this.panelInfo.add(botonVolver);

        
        this.add(panelInfo);
        this.add(Box.createHorizontalStrut(20));
        this.add(panelZonaDelJuego);
    }

    public void inicializarZonaDelJuego() {
        this.panelZonaDelJuego.setLayout(null);
        this.panelZonaDelJuego.setBounds(300, 50, anchoZonaDelJuego, largoZonaDelJuego);
        this.panelZonaDelJuego.setBackground(Color.black);
    }

    public void agregarEscuchaGuardar(ActionListener escuchaGuardar) {
        this.botonGuardar.addActionListener(escuchaGuardar);
    }

    public void agregarEscuchaVolver(ActionListener escuchaVolver) {
        this.botonVolver.addActionListener(escuchaVolver);
    }

    public PanelZonaDeJuego getPanelZonaDeJuego() {
        return this.panelZonaDelJuego;
    }

    public void agregarEscuchaFlechas(KeyListener escuchaFlechas) {
        InputMap mapaDeEntrada = this.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW);
        ActionMap mapaDeAcciones = this.getActionMap();

        mapaDeEntrada.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), "FlechaArriba");
        mapaDeEntrada.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), "FlechaAbajo");
        mapaDeEntrada.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "FlechaIzquierda");
        mapaDeEntrada.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "FlechaDerecha");

        this.addKeyListener(escuchaFlechas);
    }

    public void mostrarMensajePartidaGuardada() {
        JOptionPane.showMessageDialog(this, "Su partida es guardada exitosamente.", "Partida guardada", JOptionPane.INFORMATION_MESSAGE);
    }

    public void mostrarMensajeError() {
        JOptionPane.showMessageDialog(this, "Se ocurrio error!", "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void mostrarMensajeMovimientoInvalido() {
        JOptionPane.showMessageDialog(this, "Imposible escapar de la ciudad.", "A donde van?", JOptionPane.ERROR_MESSAGE);
    }

    public void mostrarMensajePartidaGanada() {
        String nombre = Juego.getInstance().getJugadorActual().getNickName();
        JOptionPane.showMessageDialog(this, "�Felicitaciones " + nombre + ", has ganado el nivel. Eres el puto amo!", "�Bien ahi Papote!", JOptionPane.INFORMATION_MESSAGE);
    }

    public void mostrarMensajePartidaPerdida() {
        String nombre = Juego.getInstance().getJugadorActual().getNickName();
        JOptionPane.showMessageDialog(this, nombre + ", te has quedado sin movimientos. Volve a intertarlo muerto!", "�JA fracasado!", JOptionPane.INFORMATION_MESSAGE);
    }

    public void mostrarMensajeUsuarioInexistente() {
        String nombre = Juego.getInstance().getJugadorActual().getNickName();
        JOptionPane.showMessageDialog(this, "El usuario '" + nombre + "' no existe. No se guardara el puntaje.", "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void mostrarMensajeNoPodesMoverte() {
        JOptionPane.showMessageDialog(this, "Hay piquete", "Aaaaa", JOptionPane.ERROR_MESSAGE);

    }

}