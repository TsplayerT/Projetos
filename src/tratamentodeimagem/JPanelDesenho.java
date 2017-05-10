package tratamentodeimagem;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JPanelDesenho extends JPanel {

    private BufferedImage bufferedImage;//buffer
    private BufferedImage bufferedReta;
    private int x; //usado para gravar a posiçao do clike
    private int y;

    public JPanelDesenho() {
        super(false);//bufferstrategy '2', acelera a atualizaçao da imagem
        int width = 800;
        int height = 600;
        bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);// cria um buffer com o tamanho
        bufferedReta = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB); // auxiliar para reta
        //inicializar com funddo branco
        Graphics gi = bufferedImage.createGraphics();
        gi.setColor(Color.WHITE); //seleciona cor de fundo
        gi.fillRect(0, 0, bufferedImage.getWidth(), bufferedImage.getHeight());//pinta tudo com a cor selecionada
        gi.dispose();
        Graphics gr = bufferedReta.createGraphics();
        gr.setColor(Color.WHITE); //seleciona cor de fundo
        gr.fillRect(0, 0, bufferedReta.getWidth(), bufferedReta.getHeight());//pinta tudo com a cor selecionada
        gr.dispose();
        addMouseListener(new AcaoMouse());//acao de clike
        addMouseMotionListener(new AcaoMouse());//acao de arrastar (drag)
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE); //seleciona cor de fundo
        g.fillRect(0, 0, bufferedImage.getWidth(), bufferedImage.getHeight());//pinta tudo com a cor selecionada
        g.drawImage(bufferedReta, 0, 0, null);//pinta com a reta
        g.dispose();
    }

    private class AcaoMouse implements MouseListener, MouseMotionListener {

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

        public void mouseEntered(MouseEvent e) {
        }

        public void mouseExited(MouseEvent e) {
        }

        public void mouseDragged(MouseEvent e) {
            pinta(e.getX(), e.getY());
            updateUI();
        }

        public void mouseMoved(MouseEvent e) {
        }

        private void pinta(int mx, int my) {
            Graphics gDaReta = bufferedReta.createGraphics();
            gDaReta.drawImage(bufferedImage, 0, 0, null); //desenha a imagem gravada
            gDaReta.setColor(Color.RED);//seta a cor da reta
            gDaReta.drawLine(x, y, mx, my);
            gDaReta.dispose();
        }
    }

    public static void main(String[] args) {
        //Teste
        JFrame jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanelDesenho desenho = new JPanelDesenho();
        desenho.setPreferredSize(new Dimension(800, 600));
        jFrame.getContentPane().add(desenho);
        jFrame.setResizable(false);
        jFrame.pack();
        jFrame.setVisible(true);
    }
}
