package vista;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import control.ControladorBienvenido.EscuchaNuevoUsuario;

public class PanelBienvenido extends JPanel {

	private JButton botonNuevoUsuario = new JButton("Nuevo Usuario");
	private JButton botonUsuarioRegistrado = new JButton("Usuario Registrado");
	
	public PanelBienvenido() {
		this.setLayout(null);
		this.botonNuevoUsuario.setBounds(200,100,200,30);
		this.botonUsuarioRegistrado.setBounds(200,150,200,30);
		
		this.add(botonNuevoUsuario);
		this.add(botonUsuarioRegistrado);
	}

	public void agregarEscuchaNuevoUsuario(EscuchaNuevoUsuario escuchaNuevoUsuario) {
		this.botonNuevoUsuario.addActionListener(escuchaNuevoUsuario);
	}
	
	public void agregarEscuchaUsuarioRegistrado(ActionListener escuchaUsuarioRegistrado) {
		this.botonUsuarioRegistrado.addActionListener(escuchaUsuarioRegistrado);
	}
	
}
