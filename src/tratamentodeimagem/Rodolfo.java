package tratamentodeimagem;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Line2D;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Rodolfo extends JPanel {

    private Line2D line2d;
    private Point point1, point2;
    private boolean mouseReleased = false;
    private double x1 = 0.0, y1 = 0.0;
    private double x2 = 0.0, y2 = 0.0;

    public Rodolfo() {
        super(true);
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                point1 = e.getPoint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                Timer timer = new Timer();
                timer.scheduleAtFixedRate(new TimerTask() {
                    @Override
                    public void run() {
                        boolean xOk = false;
                        boolean yOk = false;
                        if (line2d != null) {
                            if (line2d.getX1() < line2d.getX2() && !xOk) {
                                x1 = line2d.getX1() + 1;
                                x2 = line2d.getX2();
                            } else if (line2d.getX1() > line2d.getX2() && !xOk) {
                                x1 = line2d.getX1() - 1;
                                x2 = line2d.getX2();
                            } else {
                                xOk = true;
                            }
                            if (line2d.getY1() < line2d.getY2() && !yOk) {
                                y1 = line2d.getY1() + 1;
                                y2 = line2d.getY2();
                            } else if (line2d.getY1() > line2d.getY2() && !yOk) {
                                y1 = line2d.getY1() - 1;
                                y2 = line2d.getY2();
                            } else {
                                yOk = true;
                            }
                            if (xOk && yOk) {
                                timer.cancel();
                            }
                            line2d.setLine(x1, y1, x2, y2);
                            repaint();
                        }
                    }
                }, 10, 10);
            }
        });
        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                point2 = e.getPoint();
                line2d = new Line2D.Double(point1, point2);
                repaint();
            }
        });
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        if ((point1 != null && point2 != null) || mouseReleased) {
            g2d.setPaint(Color.BLUE);
            g2d.setStroke(new BasicStroke(5.5f));
            g2d.draw(line2d);
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                int altura = 800, largura = 600;
                JFrame frame = new JFrame();

                frame.setSize(altura, largura);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.setLocationRelativeTo(null);
                frame.setResizable(false);
                frame.setVisible(true);
                frame.getContentPane().add(new Rodolfo());
            }
        });
    }
}
