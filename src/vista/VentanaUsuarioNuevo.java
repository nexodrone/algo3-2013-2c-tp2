package vista;

import java.awt.event.ActionListener;
import javax.swing.*;

public class VentanaUsuarioNuevo extends Ventana {
	
	private JLabel etiqueta = new JLabel("Por favor introduzca su nombre");
	private JButton botonVolver = new JButton("Volver");
	private JButton botonGuardar = new JButton("Guardar");
	private JTextField nombre = new JTextField();
	
	public VentanaUsuarioNuevo() {
		
		super("GPS Challenge: Registro de usuario");
		JPanel panelUsuarioNuevo = new JPanel();
		panelUsuarioNuevo.setLayout(null);
		
		etiqueta.setBounds(210, 50, 200, 30);
		nombre.setBounds(200, 90, 200, 20);
		botonGuardar.setBounds(70,130,200,30);
		botonVolver.setBounds(320,130,200,30);
		
		panelUsuarioNuevo.add(etiqueta);
		panelUsuarioNuevo.add(nombre);
		panelUsuarioNuevo.add(botonGuardar);
		panelUsuarioNuevo.add(botonVolver);
		
		this.add(panelUsuarioNuevo);
	}

	public void agregarEscuchaVolver(ActionListener escuchaVolver) {
		botonVolver.addActionListener(escuchaVolver);
	}
	
	public void agregarEscuchaGuardar(ActionListener escuchaGuardar){
		botonGuardar.addActionListener(escuchaGuardar);
	}
}