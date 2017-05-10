package tratamentodeimagem;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DesenhoRetas extends JPanel {

    private int x1, y1, x2, y2, tamanhoParede;

    public DesenhoRetas() {
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                x1 = (int) e.getX();
                y1 = (int) e.getY();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                x2 = (int) e.getX();
                y2 = (int) e.getY();
                Graphics g = getGraphics();
                paint(g, x1, y1, x2, y2);
            }
        });
    }

    public void paint(Graphics g, int x1, int y1, int x2, int y2) {
        g.drawLine(x1, y1, x2, y2);
        g.setColor(Color.BLACK);
    }

    public static void main(String args[]) {
        JFrame frame = new JFrame();
        frame.setSize(500, 500);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(new DesenhoRetas());
    }
}
