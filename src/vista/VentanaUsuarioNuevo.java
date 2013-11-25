package vista;

import java.awt.event.ActionListener;
import javax.swing.*;

public class VentanaUsuarioNuevo extends JFrame {
	
	private JButton botonVolver = new JButton("Volver");
	private JTextField nombre = new JTextField();
	
	public VentanaUsuarioNuevo() {
		
		JPanel panelUsuarioNuevo = new JPanel();
		panelUsuarioNuevo.setLayout(null);
		
		this.nombre.setBounds(200, 60, 200, 20);
		this.botonVolver.setBounds(200,100,200,30);
		
		panelUsuarioNuevo.add(nombre);
		panelUsuarioNuevo.add(botonVolver);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 400);
		this.add(panelUsuarioNuevo);
	}

	public void agregarEscuchaVolver(ActionListener escuchaVolver) {
		botonVolver.addActionListener(escuchaVolver);
	}

}