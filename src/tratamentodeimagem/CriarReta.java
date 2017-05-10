package tratamentodeimagem;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CriarReta extends JPanel {

    BufferedImage bufferedImage;
    BufferedImage bufferedReta;

//    BufferedImage fundo;
//    File arquivo = new File("D:\\Downloads\\photo.png");
    int inicioX;
    int inicioY;

    public CriarReta(int altura, int largura) {
        bufferedImage = new BufferedImage(altura, largura, BufferedImage.TYPE_INT_RGB);// cria um buffer com o tamanho
        bufferedReta = new BufferedImage(altura, largura, BufferedImage.TYPE_INT_RGB); // auxiliar para reta

        Graphics2D gi = bufferedImage.createGraphics();
        gi.fillRect(0, 0, bufferedImage.getWidth(), bufferedImage.getHeight());//pinta tudo com a cor selecionada

        Graphics gr = bufferedReta.createGraphics();
        gr.fillRect(0, 0, bufferedReta.getWidth(), bufferedReta.getHeight());//pinta tudo com a cor selecionada
        gr.drawImage(bufferedImage, 0, 0, null);

//        try {
//            fundo = ImageIO.read(arquivo); //carrega a imagem no buffer
//            AffineTransform at = AffineTransform.getScaleInstance((double) 800 / fundo.getWidth(), (double) 600 / fundo.getHeight());//cria a transformacao
//            gi.drawRenderedImage(fundo, at);//pinta e transforma a imagem real no bufferedImage
//        } catch (IOException ex) {
//            JOptionPane.showMessageDialog(null, "Erro ao carregar a imagem");
//        }
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                inicioX = e.getX();
                inicioY = e.getY();
            }
        });
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                pintarLinha(e.getX(), e.getY());
            }
        });
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bufferedReta, 0, 0, null);//pinta com a reta
    }

    public void pintarLinha(int finalX, int finalY) {
        Graphics gDaReta = bufferedReta.createGraphics();
        gDaReta.drawImage(bufferedImage, 0, 0, null); //desenha a imagem gravada
        gDaReta.setColor(Color.BLACK);//seta a cor da reta
        gDaReta.drawLine(inicioX, inicioY, finalX, finalY);
        repaint();
    }

    public static void main(String[] args) {
        int altura = 800, largura = 600;
        JFrame frame = new JFrame();
        frame.setSize(altura, largura);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.add(new CriarReta(altura, largura));
    }
}
