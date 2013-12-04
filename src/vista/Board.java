package vista;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;


import modelo.Juego;
import modelo.Tablero;
import control.MyKeyListener;

public class Board extends JPanel implements ActionListener {

    Image star;
    Timer timer;
    int x, y, enX, enY, contador;

    public Board() {
        setBackground(Color.BLACK);
        KeyListener listener = new MyKeyListener(this);
        addKeyListener(listener);
        ImageIcon ii = new ImageIcon(this.getClass().getResource("dibujo_moto.png"));
        star = ii.getImage();   
        setDoubleBuffered(true);
        setFocusable(true);

        x = y = 10;
        timer = new Timer(25, this);
        timer.start();
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(star, x, y, this);
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }

    public void actionPerformed(ActionEvent e) {
        if (contador < 30) {
            x = x + enX;
            y = y + enY;
        }
        contador = contador + 1;
        // x += 1;
        // y += 1;
        if (y > 1000) {
            y = -45;
            x = -45;
        }
        repaint();
    }

    public void dibujarTablero(){
    	Tablero tablero = Juego.getInstance().getPartida().getTablero();
		int constanteFila=0;
		int constanteColumna=1;
		int posicionX=0;
		int posicionY=0;
		int largoManzana = calcularLargoManzana();
		int anchoManzana = calcularAnchoManzana();
		
		for (int i=0;i<tablero.getCantidadDeColumnas();i++){
			for(int j=0; j< tablero.getCantidadDeFilas(); j++){
				posicionY= largoManzana *(j+constanteFila);
				JLabel manzana = crearUnaManzana(posicionX,posicionY,anchoManzana,largoManzana);
				this.add(manzana);
				constanteFila++;
			}
			constanteColumna++;
			posicionX=anchoManzana *(i+constanteColumna);
			posicionY=0;
			constanteFila=0;
		}	
    }
    
	public JLabel crearUnaManzana(int posX,int posY,int ancho,int alto){
		JLabel manzana = new JLabel("");
		ImageIcon icono = new ImageIcon("src/vista/imagenes/manzana.png");
		manzana.setIcon(icono);
		manzana.setBounds(posX, posY, ancho, alto);
		return manzana;	
	}
	
	int calcularLargoManzana(){
		Tablero tablero = Juego.getInstance().getPartida().getTablero();
		return 750/(tablero.getCantidadDeFilas()*2);
	}
	
	public int calcularAnchoManzana(){
		Tablero tablero = Juego.getInstance().getPartida().getTablero();
		return 750/(tablero.getCantidadDeColumnas()*2);
	}

    public void nuevaPosicion(int x, int y) {
        enX = x;
        enY = y;
        contador = 0;
    }

}
