package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import control.ControladorBienvenido.EscuchaNuevoUsuario;

public class PanelBienvenido extends JPanel {

	private Boton botonNuevoUsuario = new Boton("Nuevo Usuario");
	private Boton botonUsuarioRegistrado = new Boton("Usuario Registrado");
	private Boton botonSalir = new Boton("Salir");
	
	public PanelBienvenido() {
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.setPreferredSize(new Dimension(300,400));
		this.setBackground(new Color(255,255,255,200));

		JLabel bienvenido = new JLabel("BIENVENIDO A");
		bienvenido.setAlignmentX(CENTER_ALIGNMENT);
		JLabel logo = new JLabel();
		logo.setPreferredSize(new Dimension(250,30));
		logo.setAlignmentX(CENTER_ALIGNMENT);
        ImageIcon logoIcono = new ImageIcon("src/vista/imagenes/logo.png");
        logo.setIcon(logoIcono);
		
		this.add(Box.createVerticalStrut(15));
		this.add(bienvenido);
		this.add(Box.createVerticalStrut(20));
		this.add(logo);
		this.add(Box.createVerticalStrut(20));
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
		JOptionPane.showMessageDialog(this, "El archivo con jugadores registrados no se encontro o esta roto :(\nCree un nuevo usuario para poder jugar.", "Archivo con jugadores roto", JOptionPane.ERROR_MESSAGE);
	}
	
	public void mostrarMensajeNoHayUsuariosCreados() {
		JOptionPane.showMessageDialog(this, "No hay usuarios creados.\nCree un nuevo usuario para poder jugar.", "Lista de usuarios vacia", JOptionPane.WARNING_MESSAGE);
	}
	
}
