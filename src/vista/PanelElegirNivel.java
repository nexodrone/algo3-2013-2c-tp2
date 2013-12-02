package vista;

import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class PanelElegirNivel extends JPanel {

	private JButton botonAceptar = new JButton("Aceptar");
	private JButton botonVolver = new JButton("Volver");
	private JLabel etiqueta = new JLabel("Por favor seleccione dificultad");
	private JLabel etiquetaFacil = new JLabel("Facil");
	private JLabel etiquetaIntermedio = new JLabel("Intermedio");
	private JLabel etiquetaDificil = new JLabel("Dificil");
	private JRadioButton botonFacil = new JRadioButton();
	private JRadioButton botonIntermedio = new JRadioButton();
	private JRadioButton botonDificil = new JRadioButton();
	private ButtonGroup bgroup = new ButtonGroup();
	


	public PanelElegirNivel() {
		this.setLayout(null);
		
		this.etiqueta.setBounds(530, 80, 220, 10);
		
		this.etiquetaFacil.setBounds(300, 350, 80, 30);
		this.etiquetaIntermedio.setBounds(590, 350, 80, 30);
		this.etiquetaDificil.setBounds(860, 350, 80, 30);
		
		this.botonFacil.setBounds(300,370,30,30);
		this.botonIntermedio.setBounds(590,370, 30, 30);
		this.botonDificil.setBounds(860,370,30,30);
		
		this.botonAceptar.setBounds(500,430,200,30);
		this.botonVolver.setBounds(500,480,200, 30);
		
		this.bgroup.add(botonFacil);
		this.bgroup.add(botonIntermedio);
		this.bgroup.add(botonDificil);
		
		this.add(etiqueta);
		this.add(etiquetaFacil);
		this.add(etiquetaIntermedio);
		this.add(etiquetaDificil);
		this.add(botonFacil);
		this.add(botonIntermedio);
		this.add(botonDificil);
		this.add(botonAceptar);
		this.add(botonVolver);
	}
	
	public void agregarEscuchaAceptar(ActionListener escuchaAceptar){
		this.botonAceptar.addActionListener(escuchaAceptar);
	}
		
	public void agregarEscuchaVolver(ActionListener escuchaVolver){
		this.botonVolver.addActionListener(escuchaVolver);
	}
	
	public void mostrarMensajeError() {
		JOptionPane.showMessageDialog(this, "Error! Se cargara nivel por defecto.", "Error", JOptionPane.ERROR_MESSAGE);
	}
}
