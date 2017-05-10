package tratamentodeimagem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TrajetoPersonagem extends JPanel {

    Point ponto_inicio = new Point(250, 200);
    Point ponto_final = new Point();
    BufferedImage bufferedImage;
    BufferedImage bufferedReta;

    public TrajetoPersonagem(int altura, int largura) {
        super(true);
        bufferedImage = new BufferedImage(altura, largura, BufferedImage.TYPE_INT_RGB);
        bufferedReta = new BufferedImage(altura, largura, BufferedImage.TYPE_INT_RGB);

        Graphics2D gi = bufferedImage.createGraphics();
        gi.fillRect(0, 0, bufferedImage.getWidth(), bufferedImage.getHeight());

        Graphics gr = bufferedReta.createGraphics();
        gr.fillRect(0, 0, bufferedReta.getWidth(), bufferedReta.getHeight());
        gr.drawImage(bufferedImage, 0, 0, null);

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                ponto_final.setLocation(e.getPoint());
                Time(20, ponto_inicio, ponto_final, true).start();
            }
        });
        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                pintarLinha(ponto_inicio, e.getPoint());
            }
        });
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bufferedReta, 0, 0, null);
    }

    public void pintarLinha(Point i, Point f) {
        Graphics g = bufferedReta.createGraphics();
        g.drawImage(bufferedImage, 0, 0, null);
        g.setColor(Color.BLACK);
        g.drawLine(i.x, i.y, f.x, f.y);
        this.repaint();
    }

    public Thread Time(int tempo, Point componenteA, Point componenteB, boolean continuar) {
        Thread tread = new Thread() {
            @Override
            public void run() {
                while (continuar) {
                    try {
                        Thread.sleep(tempo);
                        double x = Math.abs(componenteB.getX() - componenteA.getX());
                        double y = Math.abs(componenteB.getY() - componenteA.getY());
//                        double x = (componenteB.getY() - componenteA.getY());
//                        double y = (componenteB.getX() - componenteA.getX());
                        double fim = (x / y);
//                        double fim = (Math.tan(x / y));

                        if (componenteB.getLocation() != componenteA.getLocation()) {
                            if (componenteB.getX() > componenteA.getX() && componenteB.getY() > componenteA.getY()) {
                                componenteA.setLocation(componenteA.getX() + fim, componenteA.getY() + 1);
                            } else if (componenteB.getX() > componenteA.getX() && componenteB.getY() < componenteA.getY()) {
                                componenteA.setLocation(componenteA.getX() + fim, componenteA.getY() - 1);
                            } else if (componenteB.getX() < componenteA.getX() && componenteB.getY() > componenteA.getY()) {
                                componenteA.setLocation(componenteA.getX() - fim, componenteA.getY() + 1);
                            } else if (componenteB.getX() < componenteA.getX() && componenteB.getY() < componenteA.getY()) {
                                componenteA.setLocation(componenteA.getX() - fim, componenteA.getY() - 1);
                            } else if (componenteB.getX() == componenteA.getX() && componenteB.getY() < componenteA.getY()) {
                                componenteA.setLocation(componenteA.getX(), componenteA.getY() - 1);
                            } else if (componenteB.getX() == componenteA.getX() && componenteB.getY() > componenteA.getY()) {
                                componenteA.setLocation(componenteA.getX(), componenteA.getY() + 1);
                            } else if (componenteB.getX() < componenteA.getX() && componenteB.getY() == componenteA.getY()) {
                                componenteA.setLocation(componenteA.getX() - 1, componenteA.getY());
                            } else if (componenteB.getX() > componenteA.getX() && componenteB.getY() == componenteA.getY()) {
                                componenteA.setLocation(componenteA.getX() + 1, componenteA.getY());
                            }
                            pintarLinha(componenteA, componenteB);
                        }
                    } catch (InterruptedException ex) {
                        System.out.println(ex.getMessage());
                    }

                }
            }
        };
        return tread;
    }

    public static void main(String[] args) {
        int altura = 500, largura = 400;
        JFrame frame = new JFrame();
        
        frame.setSize(altura, largura);
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.getContentPane().add(new TrajetoPersonagem(altura, largura));
        //frame.pack();
    }
}
