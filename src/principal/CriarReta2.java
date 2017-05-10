package principal;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JFrame;

public class CriarReta2 extends JFrame {

    int mouseX, mouseY;
    int jogadorX = 300, jogadorY = 300;

    public CriarReta2() {
        this.setSize(600, 600);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                mouseX = e.getX();
                mouseY = e.getY();
                Graphics g = getGraphics();
                g.drawLine(jogadorX, jogadorY, mouseX, mouseY);
                repaint();
            }
        });
        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                mouseX = e.getX();
                mouseY = e.getY();
                repaint();
            }
        });
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g.create();
//        Graphics g2d = getGraphics();
//        g.setColor(Color.RED);
//        g2d.setStroke(new BasicStroke(3.0f));  //ENGROSSAR RETA
        g2d.drawLine(jogadorX, jogadorY, mouseX, mouseY);
    }

    public static void main(String[] args) {
        new CriarReta2().setVisible(true);
    }
}
