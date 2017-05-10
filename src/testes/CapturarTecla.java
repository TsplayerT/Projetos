package testes;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

public class CapturarTecla extends JFrame implements KeyListener {

    public CapturarTecla(){
        addKeyListener(this);
    }
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CapturarTecla();
            }
        });
    }

    public void keyTyped(KeyEvent e) {
        System.out.println("keyTyped: "+e);
    }

    public void keyPressed(KeyEvent e) {
        System.out.println("keyPressed: "+e);
    }

    public void keyReleased(KeyEvent e) {
        System.out.println("keyReleased: "+e);
    }
}
