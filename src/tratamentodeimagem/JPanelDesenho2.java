package tratamentodeimagem;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class JPanelDesenho2 extends JPanel {

    BufferedImage bufferedImage;//buffer
    BufferedImage bufferedReta;
    BufferedImage fundo;
    int x;
    int y;

    public JPanelDesenho2() {
        super(true);//bufferstrategy '2', acelera a atualizaçao da imagem
        int width = 800;
        int height = 600;
        bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);// cria um buffer com o tamanho
        bufferedReta = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB); // auxiliar para reta
        //inicializar com funddo branco caso de erro ao carregar o arquivo
        Graphics2D gi = bufferedImage.createGraphics();
        gi.setColor(Color.WHITE); //seleciona cor de fundo
        gi.fillRect(0, 0, bufferedImage.getWidth(), bufferedImage.getHeight());//pinta tudo com a cor selecionada
        //cria uma janela para carregar a imagem
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showOpenDialog(null);
        //pega o arquivo
        File arquivo = fileChooser.getSelectedFile();//arquivo, vc pode colocar "new File("c:/pasta/imagem.jpg");"
        try {
            fundo = ImageIO.read(arquivo); //carrega a imagem no buffer
            //compacta a imagem (opcional)
            AffineTransform at = AffineTransform.getScaleInstance((double) 800 / fundo.getWidth(), (double) 600 / fundo.getHeight());//cria a transformacao
            gi.drawRenderedImage(fundo, at);//pinta e transforma a imagem real no bufferedImage
            //vc pode substituir o codigo acima de transformacao pelo codigo abaixo
            //gi.drawImage(bufferedImage, 0, 0, null);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar a imagem");
        }
        gi.dispose();
        Graphics gr = bufferedReta.createGraphics();
        gr.setColor(Color.WHITE); //seleciona cor de fundo
        gr.fillRect(0, 0, bufferedReta.getWidth(), bufferedReta.getHeight());//pinta tudo com a cor selecionada
        gr.drawImage(bufferedImage, 0, 0, null);
        gr.dispose();
        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                x = e.getX();
                y = e.getY();
                pinta(e.getX(), e.getY());
                updateUI();//Atualiza a imagem do jpanel
            }

            public void mousePressed(MouseEvent e) {
                x = e.getX();
                y = e.getY();
                pinta(e.getX(), e.getY());
                updateUI();//Atualiza a imagem do jpanel
            }

            public void mouseReleased(MouseEvent e) {
                pinta(e.getX(), e.getY());
                Graphics gDaImagem = bufferedImage.createGraphics();//pega o g da imagem
                gDaImagem.drawImage(bufferedReta, 0, 0, null);//desenha a reta final na imagem
                gDaImagem.dispose();
                updateUI();
            }
        });//acao de clike
        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                pinta(e.getX(), e.getY());
                updateUI();
            }

        });//acao de arrastar (drag)
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE); //seleciona cor de fundo
        g.fillRect(0, 0, bufferedImage.getWidth(), bufferedImage.getHeight());//pinta tudo com a cor selecionada
        g.drawImage(bufferedReta, 0, 0, null);//pinta com a reta
        g.dispose();
    }

    private void pinta(int mx, int my) {
        Graphics gDaReta = bufferedReta.createGraphics();
        gDaReta.drawImage(bufferedImage, 0, 0, null); //desenha a imagem gravada
        gDaReta.setColor(Color.RED);//seta a cor da reta
        gDaReta.drawLine(x, y, mx, my);
        gDaReta.dispose();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.add(new JPanelDesenho2());
    }
}
