package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.InputMap;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.KeyStroke;

import control.Logger;
import modelo.Juego;
import modelo.Partida;

public class PanelPartida extends JPanel {

    private Boton botonGuardar = new Boton("Guardar");
    private Boton botonVolver = new Boton("Volver");

    private JLabel vehiculoActual = new JLabel();
    private int movimientosLimites;
    private JLabel movimientosLimitesLabel;
    private JLabel movimientosActualesLabel;
    private JLabel puntajeLabel;

    private PanelZonaDeJuego panelZonaDelJuego;
    private JPanel panelDeControl = new JPanel();
    private LogPartida logPartida = new LogPartida();
    private JScrollPane scroll;

    private int anchoZonaDelJuego = 870; //ideal = 860
    private int largoZonaDelJuego = 610; //ideal = 580

    public PanelPartida(String nombre, Partida partida) {
        this.setLayout(new FlowLayout());
        this.setPreferredSize(new Dimension(1180, 680));
        this.setBackground(new Color(255, 255, 255, 200));
        
        JLabel nombreUsuario = new JLabel("Jugador:  " + nombre);
        nombreUsuario.setAlignmentX(CENTER_ALIGNMENT);
        
        JLabel dificultad = new JLabel("Dificultad:  " + recuperarStringDeDificultad(partida.dificultad));
        dificultad.setAlignmentX(CENTER_ALIGNMENT);

        this.vehiculoActual = new JLabel("Vehiculo:  " + partida.getVehiculo().asString());
        this.vehiculoActual.setAlignmentX(CENTER_ALIGNMENT);
        
        this.movimientosLimites = partida.getCantidadDeMovimientosDisponibles();
        this.movimientosLimitesLabel = new JLabel("Movimientos limites:  " + movimientosLimites);
        this.movimientosLimitesLabel.setAlignmentX(CENTER_ALIGNMENT);
        
        this.movimientosActualesLabel = new JLabel();
        this.movimientosActualesLabel.setAlignmentX(CENTER_ALIGNMENT);
        this.puntajeLabel = new JLabel();
        this.puntajeLabel.setAlignmentX(CENTER_ALIGNMENT);
        this.actualizarMovimientosDelPanel(partida.getVehiculo().getCantidadDeMovimientos(), partida.dificultad);
        
        this.panelDeControl.setPreferredSize(new Dimension(250,610));
        this.panelDeControl.setLayout(new BoxLayout(panelDeControl, BoxLayout.PAGE_AXIS));
        this.panelDeControl.setBackground(new Color(0,0,0,0));
        
        JPanel panelInfo = new JPanel();
        panelInfo.setMaximumSize(new Dimension(250,500));
        panelInfo.setLayout(new BoxLayout(panelInfo, BoxLayout.PAGE_AXIS));
        panelInfo.setBackground(Color.WHITE);
        
		this.panelZonaDelJuego = new PanelZonaDeJuego(partida);
        this.inicializarZonaDelJuego();
        
        Logger.instance.addListener(logPartida);
        this.scroll = new JScrollPane(logPartida);
        this.scroll.setPreferredSize(new Dimension(240,200));
        this.scroll.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.scroll.setAlignmentX(CENTER_ALIGNMENT);
        
        panelInfo.add(Box.createVerticalStrut(10));
        panelInfo.add(nombreUsuario);
        panelInfo.add(Box.createVerticalStrut(10));
        panelInfo.add(dificultad);
        panelInfo.add(Box.createVerticalStrut(10));
        panelInfo.add(this.vehiculoActual);
        panelInfo.add(Box.createVerticalStrut(10));
        panelInfo.add(this.movimientosLimitesLabel);
        panelInfo.add(Box.createVerticalStrut(10));
        panelInfo.add(this.movimientosActualesLabel);
        panelInfo.add(Box.createVerticalStrut(10));
        panelInfo.add(this.puntajeLabel);
        panelInfo.add(Box.createVerticalStrut(20));
        panelInfo.add(scroll);
        
        this.panelDeControl.add(panelInfo);
        this.panelDeControl.add(Box.createVerticalStrut(20));
        this.panelDeControl.add(botonGuardar);
        this.panelDeControl.add(Box.createVerticalStrut(20));
        this.panelDeControl.add(botonVolver);

        this.add(panelDeControl);
        this.add(Box.createHorizontalStrut(20));
        this.add(panelZonaDelJuego);
    }

    public void inicializarZonaDelJuego() {
        this.panelZonaDelJuego.setLayout(null);
        this.panelZonaDelJuego.setPreferredSize(new Dimension(anchoZonaDelJuego,largoZonaDelJuego));
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

        mapaDeEntrada.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), "FlechaArriba");
        mapaDeEntrada.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), "FlechaAbajo");
        mapaDeEntrada.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "FlechaIzquierda");
        mapaDeEntrada.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "FlechaDerecha");

        this.addKeyListener(escuchaFlechas);
    }
    
    public void actualizarMovimientosDelPanel(int movimientosRealizados, int dificultad) {
    	this.movimientosActualesLabel.setText("Movimientos actuales:  " + movimientosRealizados);
    	int puntaje = (this.movimientosLimites - movimientosRealizados) * dificultad;
    	this.puntajeLabel.setText("Puntaje:  " + puntaje);
    }
    
	public void actualizarLabelVechiulo(String vehiculoDespuesDeMover) {
		vehiculoActual.setText("Vehiculo:   " + vehiculoDespuesDeMover);
		vehiculoActual.validate();
	}
    
    private String recuperarStringDeDificultad(int dificultad) {
    	switch (dificultad) {
    	case 1:	return "Facil";
    	case 2: return "Intermedio";
    	default: return "Dificil";
    	}
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
        JOptionPane.showMessageDialog(this, "Felicitaciones " + nombre + ", ganaste el nivel!", "Partida ganada", JOptionPane.INFORMATION_MESSAGE);
    }

    public void mostrarMensajePartidaPerdida() {
        String nombre = Juego.getInstance().getJugadorActual().getNickName();
        JOptionPane.showMessageDialog(this, nombre + ", te has quedado sin movimientos.", "Partida perdida", JOptionPane.INFORMATION_MESSAGE);
    }

    public void mostrarMensajeUsuarioInexistente() {
        String nombre = Juego.getInstance().getJugadorActual().getNickName();
        JOptionPane.showMessageDialog(this, "El usuario '" + nombre + "' no existe. No se guardara el puntaje.", "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void mostrarMensajeNoPodesMoverte() {
        JOptionPane.showMessageDialog(this, "Hay piquete", "Aaaaa", JOptionPane.ERROR_MESSAGE);

    }
}