package vista;


import javax.swing.*;

import java.awt.*;
import java.awt.event.*;


public class VentanaNuevoUsuario extends VentanaGeneral{

	private JLabel jlbNombre;			private JTextField jtfNombre;
	private Box boxVCamposVentana;
	private JPanel panelBotones;
	
	 public VentanaNuevoUsuario(){
	    super("Bienvenido"); 
		 //Box vertical por que los botones van a estar abajo
        Box boxVContenidoVerticalVentana = Box.createVerticalBox();
        crearCamposVentana();
        agregarBtnAceptar();
        
      //Espacio del borde superior de la ventana al primer Campo
        boxVContenidoVerticalVentana.add(Box.createVerticalStrut(70));
        boxVContenidoVerticalVentana.add(boxVCamposVentana);
        
        //Espacio entre el ultimo campo y el boton
        boxVContenidoVerticalVentana.add(Box.createVerticalStrut(70));
        boxVContenidoVerticalVentana.add(panelBotones);
			
        add(boxVContenidoVerticalVentana);
        this.setVisible(true);
	}
	

	private void crearCamposVentana() {
		Box boxHNombre =  Box.createHorizontalBox();
        jlbNombre = new JLabel("Por favor introduzca su nombre ");  
        jtfNombre = new JTextField(10);
        boxHNombre.add(Box.createHorizontalStrut(10));
        boxHNombre.add(jlbNombre);
        boxHNombre.add(Box.createHorizontalStrut(40));
        boxHNombre.add(jtfNombre);
        JPanel panNombre =  new JPanel(new FlowLayout(FlowLayout.CENTER) );
        panNombre.add(boxHNombre);
        boxVCamposVentana = Box.createVerticalBox();
        boxVCamposVentana.add(panNombre);
        boxVCamposVentana.add(Box.createVerticalStrut(10));
	}


	public void agregarBtnAceptar(){
		Box boxHBotones = Box.createHorizontalBox();
		String direccion = "src/vista/imagenes/btnAceptar.png";
		Boton nuevoBtn = new Boton(218,54,direccion);
		nuevoBtn.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				//acepta
			}
		});
		getContentPane().add(nuevoBtn);
		boxHBotones.add(nuevoBtn);
		boxHBotones.add(Box.createHorizontalStrut(5));
		panelBotones =  new JPanel( );
        panelBotones.add(boxHBotones);
		
	}
	
	 public static void main(String[] arguments) {
	        VentanaNuevoUsuario ventana = new VentanaNuevoUsuario();
	 }
}

