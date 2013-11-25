package vista;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class VentanaBienvenido extends Ventana {
	
	private JButton botonNuevoUsuario = new JButton("Nuevo Usuario");
	private JButton botonUsuarioRegistrado = new JButton("Usuario Registrado");
	
	public VentanaBienvenido() {
		
		super("GPS Challenge: Bienvenido");
		JPanel panelBienvenido = new JPanel();
		panelBienvenido.setLayout(null);
		
		this.botonNuevoUsuario.setBounds(200,100,200,30);
		this.botonUsuarioRegistrado.setBounds(200,150,200,30);
		
		panelBienvenido.add(botonNuevoUsuario);
		panelBienvenido.add(botonUsuarioRegistrado);

		this.add(panelBienvenido);
	}

	public void agregarEscuchaNuevoUsuario(ActionListener escuchaNuevoUsuario) {
		botonNuevoUsuario.addActionListener(escuchaNuevoUsuario);
	}

	public void agregarEscuchaUsuarioRegistrado(ActionListener escuchaUsuarioRegistrado) {
		botonUsuarioRegistrado.addActionListener(escuchaUsuarioRegistrado);
	}

}
