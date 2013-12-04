package vista;

import javax.swing.JFrame;

public class Auto2 extends JFrame {

	Board board;
	public Auto2() {

    	board= new Board();
  
    	this.setBounds(0, 0, 500,500);
    	this.add(board);
       

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setTitle("Star");
        setResizable(false);
        setVisible(true);

    }

    public static void main(String[] args) {
        new Auto2();
    }

}