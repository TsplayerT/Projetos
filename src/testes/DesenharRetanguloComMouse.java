package testes;

import java.awt.Graphics;  
import java.awt.event.MouseEvent;  
import java.awt.event.MouseListener;  
import java.awt.event.MouseMotionListener;  
import javax.swing.JFrame;  

public class DesenharRetanguloComMouse extends JFrame implements MouseListener, MouseMotionListener{

     public DesenharRetanguloComMouse(){//Construtor  
        this.addMouseListener(this);//adicona o ouvinte do mouse ... ao frame, isso sempre é necessário, pra pegar as coordenadas  
        this.addMouseMotionListener(this);  
        this.setVisible(true);//muda o frame pra visivel  
        this.setSize(400,350);//Muda o tamanho do frame  
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }  
          
    private int x0, y0, xf, yf;  
          
    public void mouseClicked(MouseEvent arg0) {  
        x0 = arg0.getX();//Pegam o X e Y inicial do mouse  
        y0 = arg0.getY();  
    }  
  
    public void mouseEntered(MouseEvent arg0) {  
    }  
  
    public void mouseExited(MouseEvent arg0) {  
    }  
  
    public void mousePressed(MouseEvent arg0) {  
    }  
  
    public void mouseReleased(MouseEvent arg0) {  
    }  
  
    public void mouseDragged(MouseEvent arg0) {  
        // ao arrasstar o mouse, ele fica redesenhando   
        xf = arg0.getX();  
        yf = arg0.getY();  
        repaint(); //conforme vai arrastando.... ele fica repintando   
    }  
  
    public void mouseMoved(MouseEvent arg0) {  
    }  
      
    public void paint (Graphics g){  
        g.clearRect(0, 0, this.getWidth(),this.getHeight());//Limpa o frame, pra num ficar uma forma por cima da outra....  
        g.drawRect(x0,y0,xf,yf);  
    }  
  
public static void main(String args[]){  
    DesenharRetanguloComMouse frame = new DesenharRetanguloComMouse();  
}  
}
