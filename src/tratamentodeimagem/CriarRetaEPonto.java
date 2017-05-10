package tratamentodeimagem;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class CriarRetaEPonto extends JPanel {

    int inicioX, inicioY;
    int finalX, finalY;
    BufferedImage bufferedImage;
    BufferedImage bufferedReta;

    public CriarRetaEPonto(int altura, int largura) {
        bufferedImage = new BufferedImage(altura, largura, BufferedImage.TYPE_INT_RGB);
        bufferedReta = new BufferedImage(altura, largura, BufferedImage.TYPE_INT_RGB);

        Graphics2D gi = bufferedImage.createGraphics();
        gi.fillRect(0, 0, bufferedImage.getWidth(), bufferedImage.getHeight());

        Graphics gr = bufferedReta.createGraphics();
        gr.fillRect(0, 0, bufferedReta.getWidth(), bufferedReta.getHeight());
        gr.drawImage(bufferedImage, 0, 0, null);

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                inicioX = e.getX();
                inicioY = e.getY();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                Timer(30, new Point(inicioX, inicioY), new Point(e.getX(), e.getY())).start();
            }
        });
        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                pintarLinha(inicioX, inicioY, e.getX(), e.getY());
            }
        });
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bufferedReta, 0, 0, null);
    }

    public void pintarLinha(int iX, int iY, int fX, int fY) {
        Graphics gDaReta = bufferedReta.createGraphics();
        gDaReta.drawImage(bufferedImage, 0, 0, null);
        gDaReta.setColor(Color.BLACK);
        gDaReta.drawLine(iX, iY, fX, fY);
        repaint();
    }

    public Timer Timer(int tempo, Point componenteA, Point componenteB) {
        Timer timer = new Timer(tempo, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int x = (int) Math.abs(componenteB.getX() - componenteA.getX());
                int y = (int) Math.abs(componenteB.getY() - componenteA.getY());
                if (componenteB.getLocation() != componenteA.getLocation()) {
                    if (componenteB.getX() > componenteA.getX() && componenteB.getY() > componenteA.getY()) {
                        componenteA.setLocation(componenteA.getX() + (x / y), componenteA.getY() + 1);
                    } else if (componenteB.getX() > componenteA.getX() && componenteB.getY() < componenteA.getY()) {
                        componenteA.setLocation(componenteA.getX() + (x / y), componenteA.getY() - 1);
                    } else if (componenteB.getX() < componenteA.getX() && componenteB.getY() > componenteA.getY()) {
                        componenteA.setLocation(componenteA.getX() - (x / y), componenteA.getY() + 1);
                    } else if (componenteB.getX() < componenteA.getX() && componenteB.getY() < componenteA.getY()) {
                        componenteA.setLocation(componenteA.getX() - (x / y), componenteA.getY() - 1);
                    } else if (componenteB.getX() == componenteA.getX() && componenteB.getY() < componenteA.getY()) {
                        componenteA.setLocation(componenteA.getX(), componenteA.getY() - 1);
                    } else if (componenteB.getX() == componenteA.getX() && componenteB.getY() > componenteA.getY()) {
                        componenteA.setLocation(componenteA.getX(), componenteA.getY() + 1);
                    } else if (componenteB.getX() < componenteA.getX() && componenteB.getY() == componenteA.getY()) {
                        componenteA.setLocation(componenteA.getX() - 1, componenteA.getY());
                    } else if (componenteB.getX() > componenteA.getX() && componenteB.getY() == componenteA.getY()) {
                        componenteA.setLocation(componenteA.getX() + 1, componenteA.getY());
                    }
                    pintarLinha((int) componenteA.getX(), (int) componenteA.getY(), (int) componenteB.getX(), (int) componenteB.getY());
                }
            }
        });
        return timer;
    }

    public static void main(String[] args) {
        int altura = 500, largura = 400;
        JFrame frame = new JFrame();
        frame.setSize(altura, largura);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.add(new CriarRetaEPonto(altura, largura));
    }
}
