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
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CriarTrajetoPersonagem extends JPanel {

    private Line2D line2d;
    private Point ponto_inicio, ponto_final;
    private boolean mouseReleased = false;
    private double x1 = 0.0, y1 = 0.0;
    private double x2 = 0.0, y2 = 0.0;

    public CriarTrajetoPersonagem() {
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                ponto_inicio = e.getPoint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                new Thread() {
                    @Override
                    public void run() {
                        while (true) {
                            try {
                                Thread.sleep(10);
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
                                        this.interrupt();
                                        //tread.interrupt();
                                    }
                                    line2d.setLine(x1, y1, x2, y2);
                                    repaint();
                                }
                            } catch (InterruptedException ex) {
                                break;
                                //System.out.println(ex.getMessage());
                            }
                        }
                    }
                }.start();
            }
        });
        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                ponto_final = e.getPoint();
                line2d = new Line2D.Double(ponto_inicio, ponto_final);
                repaint();
            }
        });
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        if ((ponto_inicio != null && ponto_final != null) || mouseReleased) {
            g2d.setPaint(Color.BLACK);
            g2d.setStroke(new BasicStroke(3.5f));
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
                frame.getContentPane().add(new CriarTrajetoPersonagem());
            }
        });
    }
}
