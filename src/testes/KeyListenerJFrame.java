package testes;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class KeyListenerJFrame extends JFrame implements KeyListener {

    JLabel j1 = new JLabel("Codigo: ");
    JLabel j2 = new JLabel("Tecla: ");

    public KeyListenerJFrame(){
        add(j1,BorderLayout.NORTH);
        add(j2, BorderLayout.SOUTH);
        addKeyListener(this);
    }
    
    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        j1.setText("Codigo: "+Integer.toString(e.getKeyCode()));
        j2.setText("Tecla: "+Character.toString(e.getKeyChar()));
    }

    @Override
    public void keyReleased(KeyEvent e) { }

    public static void main(String[] args) {
        KeyListenerJFrame nc4 = new KeyListenerJFrame();
        nc4.setDefaultCloseOperation(EXIT_ON_CLOSE);
        nc4.setSize(300, 150);
        nc4.setVisible(true);
        nc4.setLocationRelativeTo(null);
    }
}
