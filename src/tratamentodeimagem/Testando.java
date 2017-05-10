package tratamentodeimagem;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Label;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.VolatileImage;
import javax.swing.JFrame;

public class Testando extends JFrame {

    VolatileImage teste;
    Graphics2D graphic;
    Button teste_button, button;
    int inicioX, inicioY;
    int finalX, finalY;

    public Testando() {
        this.setBackground(new Color(153, 204, 255));
        this.setSize(500, 300);
        this.getContentPane().add(new Label("Segure o mouse e desenhe"), BorderLayout.SOUTH);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                graphic.drawOval(e.getX(), e.getY(), 4, 4);
                repaint();
            }
        });
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                inicioX = e.getX();
                inicioY = e.getY();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                finalX = e.getX();
                finalY = e.getY();
            }
        });
        show();
        teste = createVolatileImage(500, 500);
        graphic = teste.createGraphics();
    }

    public void paint(Graphics g) {
        g.drawImage(teste, 0, 0, this);
    }

    public static void main(String[] args) {
        new Testando().setVisible(true);
    }
}
