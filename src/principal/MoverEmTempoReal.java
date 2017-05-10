package principal;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MoverEmTempoReal extends JFrame {

    JLabel label = new JLabel();
    JButton botaoEsquerdo = new JButton("MOVER PARA ESQUERDA");
    JButton botaoBaixo = new JButton("MOVER PARA BAIXO");
    JButton botaoDireito = new JButton("MOVER PARA DIREITA");
    JButton botaoCima = new JButton("MOVER PARA CIMA");
    int posicaoX, posicaoY;
    boolean pressionado = false;
    //JFRAME
    int xTela = 1000;
    int yTela = 600;
    //OBJETO
    int tamanhoX = 200;
    int tamanhoY = 200;

    public MoverEmTempoReal() {
        new Mover().start();
        setSize(xTela, yTela);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        
        label.setIcon(new ImageIcon("vermelho.png"));
        label.setBounds(0, 0, tamanhoX, tamanhoY);
        add(label);
        botaoEsquerdo.setBounds(230, 480, 180, 20);
        add(botaoEsquerdo);
        botaoBaixo.setBounds(410, 500, 180, 20);
        add(botaoBaixo);
        botaoDireito.setBounds(590, 480, 180, 20);
        add(botaoDireito);
        botaoCima.setBounds(410, 460, 180, 20);
        add(botaoCima);
        botaoDireito.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                posicaoX += 10;
                if (posicaoX < xTela - tamanhoX) {
                    label.setBounds(posicaoX, posicaoY, tamanhoX, tamanhoY);
                }
            }
        });
        botaoBaixo.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                posicaoY += 10;
                if (posicaoY < yTela - tamanhoY) {
                    label.setBounds(posicaoX, posicaoY, tamanhoX, tamanhoY);
                }
            }
        });
        botaoEsquerdo.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                posicaoX -= 10;
                if (posicaoX > 0) {
                    label.setBounds(posicaoX, posicaoY, tamanhoX, tamanhoY);
                }
            }
        });
        botaoCima.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                posicaoY -= 10;
                if (posicaoY > 0) {
                    label.setBounds(posicaoX, posicaoY, tamanhoX, tamanhoY);
                }
            }
        });
        label.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                pressionado = true;
            }

            public void mouseReleased(MouseEvent e) {
                pressionado = false;
            }
        });
    }

    public class Mover extends Thread {

        public void run() {
            while (true) {
                try {
                    sleep(10);
                    if (pressionado) {
                        Point ponto = getMousePosition();
                        posicaoX = ponto.x - (tamanhoX / 2) - 30;
                        posicaoY = ponto.y - (tamanhoY / 2) - 30;
                        label.setBounds(posicaoX, posicaoY, tamanhoX, tamanhoY);
                    }
                } catch (InterruptedException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
    }

    public static void main(String[] args) {
        new MoverEmTempoReal();
    }

}
