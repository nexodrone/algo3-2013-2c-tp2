package control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import vista.PanelZonaDeJuego;

public class MyKeyListener implements KeyListener {
    PanelZonaDeJuego panel;

    public MyKeyListener(PanelZonaDeJuego unPanel) {
        panel = unPanel;
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
        System.out.println("keyPressed=" + KeyEvent.getKeyText(e.getKeyCode()));
        if (KeyEvent.getKeyText(e.getKeyCode()) == "Derecha") {
            panel.girarHacia("Derecha");
            panel.nuevaPosicion(1, 0);
        }
        if (KeyEvent.getKeyText(e.getKeyCode()) == "Izquierda") {
            panel.girarHacia("Izquierda");
            panel.nuevaPosicion(-1, 0);
        }
        if (KeyEvent.getKeyText(e.getKeyCode()) == "Arriba") {
            panel.girarHacia("Arriba");
            panel.nuevaPosicion(0, -1);
        }
        if (KeyEvent.getKeyText(e.getKeyCode()) == "Abajo") {
            panel.girarHacia("Abajo");
            panel.nuevaPosicion(0, 1);
        }

    }

    public void keyReleased(KeyEvent e) {
        // System.out.println("keyReleased=" + KeyEvent.getKeyText(e.getKeyCode()));
    }
}
