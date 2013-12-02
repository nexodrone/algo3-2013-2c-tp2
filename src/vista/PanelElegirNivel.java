package vista;

import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
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
		
		this.etiqueta.setBounds(530, 60, 220, 10);
		this.tableroFacil=obtenerImagenTablero(200,100,"src/vista/imagenes/nivelFacil.png");
		this.tableroIntermedio=obtenerImagenTablero(490,100,"src/vista/imagenes/nivelIntermedio.png");
		this.tableroDificil=obtenerImagenTablero(780,100,"src/vista/imagenes/nivelDificil.png");
	
		this.botonFacil.setBounds(300,370,80,30);
		this.botonIntermedio.setBounds(590,370, 100, 30);
		this.botonDificil.setBounds(860,370,80,30);
		
		this.botonAceptar.setBounds(500,430,200,30);
		this.botonVolver.setBounds(500,480,200, 30);
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
	
}
