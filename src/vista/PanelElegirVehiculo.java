package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class PanelElegirVehiculo extends JPanel {
	
	private JButton botonAceptar = new JButton("Aceptar");
	private JButton botonVolver = new JButton("Volver");
	private JLabel etiqueta = new JLabel("Por favor seleccione vehiculo");
	private JRadioButton botonAuto = new JRadioButton("Auto");
	private JRadioButton botonMoto = new JRadioButton("Moto");
	private JRadioButton boton4x4 = new JRadioButton("4x4");
	private ButtonGroup bgroup = new ButtonGroup();
	private JLabel vehiculoAuto;
	private JLabel vehiculoMoto;
	private JLabel vehiculo4x4;
	private String nivel;
	


	public PanelElegirVehiculo(String nivelSeleccionado) {
		this.setLayout(null);
		
		this.setPreferredSize(new Dimension(1000,600));
		this.setBackground(new Color(255,255,255,150));
		
		this.nivel= nivelSeleccionado;
		this.etiqueta.setBounds(430, 60, 220, 10);
		this.vehiculoAuto=obtenerImagenDeVehiculo(100,100,"src/vista/imagenes/vehiculoAuto.jpg");
		this.vehiculoMoto=obtenerImagenDeVehiculo(390,100,"src/vista/imagenes/vehiculoMoto.jpg");
		this.vehiculo4x4=obtenerImagenDeVehiculo(680,100,"src/vista/imagenes/vehiculo4x4.jpg");
	
		this.botonAuto.setBounds(200,370,80,30);
		this.botonMoto.setBounds(490,370, 100, 30);
		this.boton4x4.setBounds(760,370,80,30);
		
		this.botonAceptar.setBounds(400,430,200,30);
		this.botonVolver.setBounds(400,480,200, 30);
		this.bgroup.add(botonAuto);
		this.bgroup.add(botonMoto);
		this.bgroup.add(boton4x4);
		
		this.add(etiqueta);
		this.add(vehiculoAuto);
		this.add(vehiculoMoto);
		this.add(vehiculo4x4);
		this.add(botonAuto);
		this.add(botonMoto);
		this.add(boton4x4);
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
	
	public JLabel obtenerImagenDeVehiculo(int posX,int posY,String direccion){
		JLabel imagen = new JLabel("");
		ImageIcon icono = new ImageIcon(direccion);
		imagen.setIcon(icono);
		imagen.setBounds(posX, posY, 250, 250);
		return imagen;
	}

	public String obtenerVehiculoSeleccionado(){
		if (botonAuto.isSelected()){
			return "Auto";
		}else if (boton4x4.isSelected()){
			return "4x4";
		}else{
			return "Moto";
		}
	}
	
	public boolean ningunCampoSeleccionado(){
		if (botonAuto.isSelected() == false && 
			boton4x4.isSelected() == false && 
			botonMoto.isSelected()==false){
			return true;
		} else return false;
	}
	
	public void mostrarMensajeCampoVacio() {
		JOptionPane.showMessageDialog(this, "Por favor seleccione un vehiculo.", "Vehiculo no seleccionado", JOptionPane.WARNING_MESSAGE);
	}
	
	public String obtenerNivelSeleccionado(){
		return nivel;
	}
	
	public void agregarEscuchaEnter(KeyListener escuchaEnter) {
		this.botonAuto.addKeyListener(escuchaEnter);
		this.botonMoto.addKeyListener(escuchaEnter);
		this.boton4x4.addKeyListener(escuchaEnter);
	}
	
	
}

