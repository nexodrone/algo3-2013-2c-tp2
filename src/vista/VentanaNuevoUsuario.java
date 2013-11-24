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
		setBounds(0,0,500,500);
		setLocationRelativeTo(null);
		
		lblUno = new JLabel("Por favor introduzca su nombre");
		getContentPane().add(lblUno);
		
		txtUno = new JTextField(10);
		getContentPane().add(txtUno);
		
		btnUno = new JButton("Cerrar");
		getContentPane().add(btnUno);
		
		btnUno.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
		});
		
		setVisible(true);
		setResizable(false);
		}
	
	 public static void main(String[] arguments) {
	        VentanaNuevoUsuario ventana = new VentanaNuevoUsuario();
	    }

}

