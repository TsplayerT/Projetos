package testes;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;

public class TratandoImagens {

    public void t1() {
        try {
            BufferedImage image = ImageIO.read(new File("E:/Outros/Netbeans/PROJETOS/Truco/Baralho.JPEG"));
//            int x1 = getX1();
//            int x2 = getX2();
//            int y1 = getY1();
//            int y2 = getY2();
            int x1 = 0;
            int x2 = 0;
            int y1 = 0;
            int y2 = 0;
            int w = image.getWidth();
            int h = image.getHeight();
            BufferedImage new_img = new BufferedImage(w, h, image.getType());
            Graphics2D g = new_img.createGraphics();
            g.drawImage(image, x1, y2, w, h, null);
            ImageIO.write(new_img, "JPG", new File("/home/pasta/img.jpg"));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void t2() {
        try {
            BufferedImage imagem = ImageIO.read(new File("E:/Outros/Imagens/elephant.gif"));
            // fazer algo com a imagem...
            ImageIO.write(imagem, "png", new File("elefante.png"));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void t3() {
        try {
            BufferedImage imagem = ImageIO.read(new File("E:/Outros/Imagens/negao.png"));
            int w = imagem.getWidth();
            int h = imagem.getHeight();
            int[] pixels = imagem.getRGB(0, 0, w, h, null, 0, w);
            Random r = new Random();
            for (int col = 0; col < w; col++) {
                for (int lin = 0; lin < h; lin++) {
                    pixels[w * lin + col] = new Color(r.nextInt(255), col % 255, lin % 255).getRGB();
                }
            }
            imagem.setRGB(0, 0, w, h, pixels, 0, w);
            ImageIO.write(imagem, "PNG", new File("arteabstrata.png"));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void t4() {
        try {
            InputStream is = getClass().getResourceAsStream("E:\\Outros\\Netbeans\\PROJETOS\\Truco\\Baralho.png");
            BufferedImage res = ImageIO.read(is);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void t5() {
        try {
            BufferedImage BI = ImageIO.read(new File("vermelho.PNG"));
            Image image = BI.getSubimage(0, 0, 200, 200);
            JLabel jLabel1 = new JLabel();
            jLabel1.setIcon(new ImageIcon(image));
            JFrame frame = new JFrame("Teste");
            frame.add(jLabel1);
            frame.show();
        } catch (Exception erro) {
            System.err.println("Erro: " + erro.getMessage());
        }
    }

    private void t6() {
        JLabel[] labels = new JLabel[3];
        JFrame frame = new JFrame("Teste");
        try {
            BufferedImage BI = ImageIO.read(new File("vermelho.PNG"));
            Image image = BI.getSubimage(0, 0, 200, 200);
            for (int i = 0; i < labels.length; i++) {
                labels[i].setIcon(new ImageIcon(image));
                labels[i].setBounds(0, 0, 200, 200);
                frame.add(labels[i]);
            }
            frame.show();
        } catch (Exception erro) {
            System.err.println("Erro: " + erro.getMessage());
        }
    }

    public void t7() {
        JFrame frame = new JFrame("Teste");
        frame.setSize(1000, 600);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        JLabel j10 = new JLabel(new ImageIcon("vermelho.png"));
        j10.setBounds(10, 10, 200, 200);
        frame.add(j10);
        JLabel j11 = new JLabel(new ImageIcon("vermelho.png"));
        j11.setBounds(50, 50, 200, 200);
        frame.add(j11);
        frame.show();
    }

    public void t8() {
        JFrame frame = new JFrame("Teste");
        frame.setSize(1000, 600);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        JLabel[] labels = new JLabel[3];
        for (int i = 0; i < labels.length; i++) {
            labels[i] = new JLabel(new ImageIcon("vermelho.png"));
            labels[i].setBounds((i * 210) + 10, 10, 200, 200);
            frame.add(labels[i]);
        }
        frame.show();
    }

    //NAO ACONTECE NADA
    public void t9() {
        Image image = null;
        JLabel j1 = new JLabel();
        //FRAME
        JFrame frame = new JFrame("Teste");
        frame.setSize(1000, 600);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        try {
            BufferedImage BI = ImageIO.read(new File("Baralho.png"));
            image = BI.getSubimage(9, 12, 75, 106);
            //image = BI.getSubimage(info[0][0], info[0][1], info[0][2], info[0][3]);
            j1.setIcon(new ImageIcon(image));
            j1.setBounds(9, 12, 75, 106);
            frame.add(j1);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        frame.show();
    }

    public static void main(String[] args) {
        new TratandoImagens().t9();
    }
}
