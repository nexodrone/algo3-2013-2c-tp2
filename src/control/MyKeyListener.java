package control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import vista.Board;

public class MyKeyListener implements KeyListener {
    Board panel;

    public MyKeyListener(Board unPanel) {
        panel = unPanel;
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
        System.out.println("keyPressed=" + KeyEvent.getKeyText(e.getKeyCode()));
        if (KeyEvent.getKeyText(e.getKeyCode()) == "Derecha") {
            panel.nuevaPosicion(1, 0);
        }
        if (KeyEvent.getKeyText(e.getKeyCode()) == "Izquierda") {
            panel.nuevaPosicion(-1, 0);
        }
        if (KeyEvent.getKeyText(e.getKeyCode()) == "Arriba") {
            panel.nuevaPosicion(0, -1);
        }
        if (KeyEvent.getKeyText(e.getKeyCode()) == "Abajo") {
            panel.nuevaPosicion(0, 1);
        }

    }

    public void keyReleased(KeyEvent e) {
        // System.out.println("keyReleased=" + KeyEvent.getKeyText(e.getKeyCode()));
    }
}
