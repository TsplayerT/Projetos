package tratamentodeimagem;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;

public class teste extends JFrame {

    int x0, y0, x1, y1;

    public teste() {
        this.setLayout(null);
        this.setSize(200, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                x0 = (int) e.getX();
                y0 = (int) e.getY();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                x1 = (int) e.getX();
                y1 = (int) e.getY();
                Graphics g = getGraphics();
                paint(g, x0, y0, x1, y1);
            }
        });
    }

    public void paint(Graphics g, int x0, int y0, int x1, int y1) {
        g.drawLine(x0, y0, x1, y1);
    }

    public static void main(String[] args) {
        new teste().setVisible(true);
    }
}
