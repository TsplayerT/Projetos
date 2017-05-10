package principal;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class CalculandoDistanciaEmPontosNoJFrame extends JFrame {

    JLabel background = new JLabel();
    JLabel jogador = new JLabel(".");
    int mouseX = 100, mouseY = 100;
    int jogadorX = 500, jogadorY = 250, velocidadeBase = 1;

    public CalculandoDistanciaEmPontosNoJFrame() {
        this.setSize(600, 600);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);

        jogador.setBounds(jogadorX, jogadorY, 60, 60);
        jogador.setForeground(Color.BLUE);
        jogador.setFont(new Font("Arial", 1, 60));

        this.add(jogador);
        background.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                mouseX = e.getX();
                mouseY = e.getY();
                //g.clearRect(0, 0, 600, 600);
                Graphics g = getGraphics();
                g.drawLine(jogadorX, jogadorY, mouseX, mouseY);
                int distancia = (int) Math.sqrt(Math.pow(jogadorX - e.getX(), 2) + Math.pow(jogadorY - e.getY(), 2));
                int tempo = distancia / velocidadeBase;
                System.out.println("Destino em X: " + e.getX() + ", Y: " + e.getY() + "| Tempo: " + tempo + " segundos");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }
        });

        colocarBackground(0, -3, 550, 550, background, "mapa.jpg");

    }

    public void colocarBackground(int x, int y, int h, int w, JLabel label, String diretorio) {
        label.setIcon(new ImageIcon(getClass().getResource(diretorio)));
        label.setBounds(x, y, h, w);
        this.add(label);
    }

    public static void main(String[] args) {
        new CalculandoDistanciaEmPontosNoJFrame().setVisible(true);

    }

}
