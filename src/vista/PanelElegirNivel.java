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

public class PanelElegirNivel extends JPanel {

	private JButton botonAceptar = new JButton("Aceptar");
	private JButton botonVolver = new JButton("Volver");
	private JLabel etiqueta = new JLabel("Por favor seleccione dificultad");
	private JRadioButton botonFacil = new JRadioButton("Facil");
	private JRadioButton botonIntermedio = new JRadioButton("Intermedio");
	private JRadioButton botonDificil = new JRadioButton("Dificil");
	private ButtonGroup bgroup = new ButtonGroup();
	private JLabel tableroFacil;
	private JLabel tableroIntermedio;
	private JLabel tableroDificil;

	public PanelElegirNivel() {
		this.setLayout(null);
		
		this.setPreferredSize(new Dimension(1000,600));
		this.setBackground(new Color(255,255,255,150));
		
		this.etiqueta.setBounds(470, 60, 220, 10);
		this.tableroFacil=obtenerImagenTablero(100,100,"src/vista/imagenes/nivelFacil.png");
		this.tableroIntermedio=obtenerImagenTablero(390,100,"src/vista/imagenes/nivelIntermedio.png");
		this.tableroDificil=obtenerImagenTablero(680,100,"src/vista/imagenes/nivelDificil.png");
	
		this.botonFacil.setBounds(200,370,80,30);
		this.botonIntermedio.setBounds(490,370, 100, 30);
		this.botonDificil.setBounds(760,370,80,30);
		
		this.botonFacil.setOpaque(false);
		this.botonIntermedio.setOpaque(false);
		this.botonDificil.setOpaque(false);
		
		this.botonAceptar.setBounds(400,430,200,30);
		this.botonVolver.setBounds(400,480,200, 30);
		this.bgroup.add(botonFacil);
		this.bgroup.add(botonIntermedio);
		this.bgroup.add(botonDificil);
		
		this.add(etiqueta);
		this.add(tableroFacil);
		this.add(tableroIntermedio);
		this.add(tableroDificil);
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
		
	public JLabel obtenerImagenTablero(int posX,int posY,String direccion){
		JLabel imagen = new JLabel("");
		ImageIcon icono = new ImageIcon(direccion);
		imagen.setIcon(icono);
		imagen.setBounds(posX, posY, 250, 250);
		return imagen;
	}

	public String obtenerNivelSeleccionado(){
		if (botonFacil.isSelected()){
			return "Facil";
		}else if(botonDificil.isSelected()){
			return "Dificil";
		}else{
			return "Intermedio";
		}
	}
	
	public boolean ningunCampoSeleccionado(){
		if (botonFacil.isSelected() == false && 
			botonDificil.isSelected() == false && 
			botonIntermedio.isSelected()==false){
			return true;
		} else return false;
	}
	
	public void mostrarMensajeCampoVacio() {
		JOptionPane.showMessageDialog(this, "Por favor seleccione un nivel.", "Nivel no seleccionado", JOptionPane.WARNING_MESSAGE);
	}
	
	public void agregarEscuchaEnter(KeyListener escuchaEnter) {
		this.botonFacil.addKeyListener(escuchaEnter);
		this.botonIntermedio.addKeyListener(escuchaEnter);
		this.botonDificil.addKeyListener(escuchaEnter);
	}
	
}
