package principal;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Mapa extends JFrame {

    public ArrayList<JLabel> posicao = new ArrayList();

    public Mapa() {
        this.setSize(607, 629);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
    }

    public void criarPosicoes(int x, int y, int tamanhoPosicao) {
        int quantidadePosicao = 0;
        int quantidadePosicoesX = x / tamanhoPosicao;
        int quantidadePosicoesY = y / tamanhoPosicao;

        for (int posicaoX = 0; posicaoX < quantidadePosicoesX; posicaoX++) {
            for (int posicaoY = 0; posicaoY < quantidadePosicoesY; posicaoY++) {
                //posicao.add(new JLabel("Posição: " + (quantidadePosicao + 1)));
                posicao.add(new JLabel(""));
                posicao.get(quantidadePosicao).setBorder(BorderFactory.createEtchedBorder());
                posicao.get(quantidadePosicao).setBounds(1 + (tamanhoPosicao * posicaoX), 1 + (tamanhoPosicao * posicaoY), tamanhoPosicao, tamanhoPosicao);
                this.add(posicao.get(quantidadePosicao));
                quantidadePosicao++;
            }
        }
        for (JLabel label : posicao) {
            label.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                }

                @Override
                public void mousePressed(MouseEvent e) {
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    label.setFont(new Font("Arial", 1, 16));
                    label.setBackground(Color.BLUE);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    label.setFont(new Font("Arial", 1, 12));
                    label.setBackground(null);
                }
            });
        }
    }

    public void colocarBackground(int x, int y, int h, int w, String diretorio) {
        JLabel background = new JLabel();
        background.setIcon(new ImageIcon(getClass().getResource(diretorio)));
        background.setBounds(x, y, h, w);
        this.add(background);
    }

    public int[] contaSemSobrar(int tamanhoX, int tamanhoY, int tamanhoPosicao, boolean aumentarTamanhoPosicaoCasoSobre) {
        int conta = (tamanhoX * tamanhoY / 100) % tamanhoPosicao;
        int auxiliador = 0;
        if (conta != 0) {
            while (conta != 0) {
                auxiliador++;
                if (aumentarTamanhoPosicaoCasoSobre) {
                    conta = (tamanhoX * tamanhoY / 100) % (tamanhoPosicao + auxiliador);
                } else {
                    conta = (tamanhoX * tamanhoY / 100) % (tamanhoPosicao - auxiliador);
                }
            }
        }
        System.out.println("O Auxiliador alterou em " + auxiliador + " unidades do valor inicial!");
        int[] valores = {tamanhoX, tamanhoY, (tamanhoPosicao - auxiliador)};
        return valores;
    }

    public static void main(String[] args) {
        Mapa mapa = new Mapa();
        int[] valores = mapa.contaSemSobrar(600, 600, 40, true);
        mapa.criarPosicoes(valores[0], valores[1], valores[2]);
        mapa.colocarBackground(0, -5, valores[0], valores[1], "mapa.jpg");
        mapa.setVisible(true);
    }
}
