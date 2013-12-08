package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import control.ControladorBienvenido.EscuchaNuevoUsuario;

public class PanelBienvenido extends JPanel {

	private JLabel bienvenido = new JLabel("BIENVENIDO A GPS CHALLENGE");
	private Boton botonNuevoUsuario = new Boton("Nuevo Usuario");
	private Boton botonUsuarioRegistrado = new Boton("Usuario Registrado");
	private Boton botonSalir = new Boton("Salir");
	
	public PanelBienvenido() {
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.setPreferredSize(new Dimension(300,400));
		this.setBackground(new Color(255,255,255,150));

		this.bienvenido.setAlignmentX(CENTER_ALIGNMENT);
		this.botonNuevoUsuario.setAlignmentX(CENTER_ALIGNMENT);
		this.botonUsuarioRegistrado.setAlignmentX(CENTER_ALIGNMENT);
		this.botonSalir.setAlignmentX(CENTER_ALIGNMENT);

		this.add(Box.createVerticalStrut(15));
		this.add(bienvenido);
		this.add(Box.createVerticalStrut(70));
		this.add(botonNuevoUsuario);
		this.add(Box.createVerticalStrut(20));
		this.add(botonUsuarioRegistrado);
		this.add(Box.createVerticalStrut(20));
		this.add(botonSalir);
	}

	public void agregarEscuchaNuevoUsuario(EscuchaNuevoUsuario escuchaNuevoUsuario) {
		this.botonNuevoUsuario.addActionListener(escuchaNuevoUsuario);
	}
	
	public void agregarEscuchaUsuarioRegistrado(ActionListener escuchaUsuarioRegistrado) {
		this.botonUsuarioRegistrado.addActionListener(escuchaUsuarioRegistrado);
	}
	
	public void agregarEscuchaSalir(ActionListener escuchaSalir) {
		this.botonSalir.addActionListener(escuchaSalir);
	}
	
	public void mostrarMensajeErrorArchivoJugadores() {
		JOptionPane.showMessageDialog(this, "No se encontro el archivo de jugadores, cree un nuevo usuario para poder jugar.", "Error: Archivo de Jugadores", JOptionPane.ERROR_MESSAGE);
	}
	
	public void mostrarMensajeNoHayUsuariosCreados() {
		JOptionPane.showMessageDialog(this, "No hay usuarios creados, cree un nuevo usuario para poder jugar.", "Lista de usuarios vacia", JOptionPane.WARNING_MESSAGE);
	}
	
}
