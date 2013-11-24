package vista;





import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class VentanaNuevoUsuario extends JFrame{

	private JLabel lblUno;
	private JTextField txtUno;
	private JButton btnUno;
	
	public VentanaNuevoUsuario(){
		setLayout(new FlowLayout());
		setBounds(0,0,800,481);
		setLocationRelativeTo(null);
		setTitle("Bienvenido");
		
		
		lblUno = new JLabel("Por favor introduzca su nombre");
		getContentPane().add(lblUno);
		
		txtUno = new JTextField(10);
		getContentPane().add(txtUno);
		
		agregarBtnCerrar();
		agregarBtnAceptar();
		
		
		setVisible(true);
		setResizable(false);
		}
	
	public void agregarBtnCerrar(){
		btnUno = new JButton("Cerrar");
		getContentPane().add(btnUno);
		
		btnUno.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
		});
	}
	
	public void agregarBtnAceptar(){
		String direccion = "src/vista/imagenes/btnAceptar.png";
		Boton nuevoBtn = new Boton(218,54,direccion);
				
		nuevoBtn.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
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

