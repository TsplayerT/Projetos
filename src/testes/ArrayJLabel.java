package testes;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ArrayJLabel extends JFrame {

    public ArrayJLabel() {
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //setIconImage(image);
        //setLayout(manager);
        setLocationRelativeTo(null);
        //setOpacity(1.0f);
        setResizable(false);
        setTitle("TESTE");
        setVisible(true);
    }

    public void t1() {
        JLabel j1 = null;
        JLabel j2 = null;
        JLabel j3 = null;
        JLabel[] labeis = {j1, j2, j3};

        for (int n = 0; n < labeis.length; n++) {
            labeis[n].setText("" + n);
        }
    }

    public void showGUI() {
        JLabel[] labels = new JLabel[5];
        Image image = null;
        try {
            BufferedImage BI = ImageIO.read(new File("vermelho.png"));
            image = BI.getSubimage(0, 0, 100, 100);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        for (int i = 0; i < labels.length; i++) {
            labels[i].setIcon(new ImageIcon(image));
            add(labels[i]);
        }
    }

    public static void main(String[] args) {
        new ArrayJLabel().showGUI();
    }
}
