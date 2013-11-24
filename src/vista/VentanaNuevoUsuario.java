package vista;





import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class VentanaNuevoUsuario extends VentanaGeneral{

	private JLabel lblUno;
	private JTextField txtUno;
	
	public VentanaNuevoUsuario(){
		super("Bienvenido");
		this.setLayout(new FlowLayout());
			
		lblUno = new JLabel("Por favor introduzca su nombre");
		getContentPane().add(lblUno);
		txtUno = new JTextField(10);
		getContentPane().add(txtUno);
		
		agregarBtnAceptar();
		setVisible(true);
	}
	

	public void agregarBtnAceptar(){
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
		this.getContentPane().add(nuevoBtn);
	}
	
	
	
	 public static void main(String[] arguments) {
	        VentanaNuevoUsuario ventana = new VentanaNuevoUsuario();
	    }

}

