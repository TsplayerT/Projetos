package testes;

//import static com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;
import java.awt.*;

public class TesteTeclaTeclado extends JFrame implements KeyListener {

    JLabel j1 = new JLabel("");
    JLabel j2 = new JLabel("");
    
    public TesteTeclaTeclado(){
        add(j1,BorderLayout.NORTH);
        add(j2,BorderLayout.SOUTH);
        addKeyListener(this);
    }
    
    public static void main(String[] args) {
        TesteTeclaTeclado ttt = new TesteTeclaTeclado();
        ttt.setDefaultCloseOperation(EXIT_ON_CLOSE);
        ttt.setSize(300, 150);
        ttt.setVisible(true);
    }

     private boolean ctrl = false;  
  
    public void keyPressed(KeyEvent arg0) {  
        // aperta o ctrl  
        if (arg0.getKeyCode() == KeyEvent.VK_CONTROL) {  
            this.ctrl = true;  
        }else{
            j1.setText("Voce clicou: "+arg0.getKeyChar());
            j2.setText("Valor Numerico: "+arg0.getKeyCode());
        }
    }  
  
    public void keyReleased(KeyEvent arg0) {  
        // solta o ctrl  
        if (arg0.getKeyCode() == KeyEvent.VK_CONTROL) {  
            this.ctrl = false;  
        }  
    }  
  
    public void keyTyped(KeyEvent arg0) {  
        if ((arg0.getKeyCode() == KeyEvent.VK_Z) && this.ctrl==true) {  
            j1.setText("Voce clicou: Ctrl + Z"); 
            j2.setText("");
        }  
    }  
//ke.isControlDown()

}
