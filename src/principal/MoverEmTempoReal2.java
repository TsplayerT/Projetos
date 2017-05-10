package principal;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MoverEmTempoReal2 extends JFrame {

    boolean pressionado = false;
    int posicaoX, posicaoY;
    JButton botaoCima = new JButton("MOVER PARA CIMA");
    JButton botaoBaixo = new JButton("MOVER PARA BAIXO");
    JButton botaoDireito = new JButton("MOVER PARA DIREITA");
    JButton botaoEsquerdo = new JButton("MOVER PARA ESQUERDA");
    //JFRAME
    int xTela = 1000;
    int yTela = 600;
    //OBJETO
    JLabel imagem = new JLabel();
    int tamanhoX = 200;
    int tamanhoY = 200;

    public MoverEmTempoReal2() {
        this.setSize(xTela, yTela);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        imagem.setIcon(new ImageIcon("vermelho.png"));
        imagem.setBounds(0, 0, tamanhoX, tamanhoY);
        this.add(imagem);

        botaoEsquerdo.setBounds(230, 480, 180, 20);
        this.add(botaoEsquerdo);
        botaoBaixo.setBounds(410, 500, 180, 20);
        this.add(botaoBaixo);
        botaoDireito.setBounds(590, 480, 180, 20);
        this.add(botaoDireito);
        botaoCima.setBounds(410, 460, 180, 20);
        this.add(botaoCima);
        botaoDireito.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                posicaoX += 10;
                if (posicaoX < xTela - tamanhoX) {
                    imagem.setBounds(posicaoX, posicaoY, tamanhoX, tamanhoY);
                }
            }
        });
        botaoBaixo.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                posicaoY += 10;
                if (posicaoY < yTela - tamanhoY) {
                    imagem.setBounds(posicaoX, posicaoY, tamanhoX, tamanhoY);
                }
            }
        });
        botaoEsquerdo.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                posicaoX -= 10;
                if (posicaoX > 0) {
                    imagem.setBounds(posicaoX, posicaoY, tamanhoX, tamanhoY);
                }
            }
        });
        botaoCima.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                posicaoY -= 10;
                if (posicaoY > 0) {
                    imagem.setBounds(posicaoX, posicaoY, tamanhoX, tamanhoY);
                }
            }
        });
        imagem.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                pressionado = true;
            }

            public void mouseReleased(MouseEvent e) {
                pressionado = false;
            }
        });

        tread.start();
    }

    Thread tread = new Thread() {
        public void run() {
            while (pressionado) {
                Point ponto = getMousePosition();
                posicaoX = ponto.x - (tamanhoX / 2) - 30;
                posicaoY = ponto.y - (tamanhoY / 2) - 30;
                imagem.setBounds(posicaoX, posicaoY, tamanhoX, tamanhoY);
            }
        }
    };

    public static void main(String[] args) {
        new MoverEmTempoReal2().setVisible(true);
    }
}
