package tratamentodeimagem;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

public class PontoAoOutro extends JFrame {

    JLabel pontoA = new JLabel(".");
    JLabel pontoB = new JLabel(".");

    public PontoAoOutro() {
        this.setSize(600, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(false);

        pontoA.setBounds(200, 300, 50, 50);
        pontoA.setFont(new Font("Arial", 1, 40));
        pontoA.setForeground(Color.red);
        this.add(pontoA);

        pontoB.setBounds(50, 50, 50, 50);
        pontoB.setFont(new Font("Arial", 1, 40));
        this.add(pontoB);
        Timer(10, pontoA, pontoB).start();
    }

    public Timer Timer(int tempo, Component pontoA, Component pontoB) {
        Timer timer = new Timer(tempo, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int x = Math.abs(pontoB.getX() - pontoA.getX());
                int y = Math.abs(pontoB.getY() - pontoA.getY());
                if (pontoB.getX() > pontoA.getX() && pontoB.getY() > pontoA.getY()) {
                    pontoA.setLocation(pontoA.getX() + (x / y), pontoA.getY() + 1);
                    //System.out.println("+,+");
                } else if (pontoB.getX() > pontoA.getX() && pontoB.getY() < pontoA.getY()) {
                    pontoA.setLocation(pontoA.getX() + (x / y), pontoA.getY() - 1);
                    //System.out.println("+,-");
                } else if (pontoB.getX() < pontoA.getX() && pontoB.getY() > pontoA.getY()) {
                    pontoA.setLocation(pontoA.getX() - (x / y), pontoA.getY() + 1);
                    //System.out.println("-,+");
                } else if (pontoB.getX() < pontoA.getX() && pontoB.getY() < pontoA.getY()) {
                    pontoA.setLocation(pontoA.getX() - (x / y), pontoA.getY() - 1);
                    //System.out.println("-,-");
                } else if (pontoB.getX() == pontoA.getX() && pontoB.getY() < pontoA.getY()) {
                    pontoA.setLocation(pontoA.getX(), pontoA.getY() - 1);
                    //System.out.println("=,-");
                } else if (pontoB.getX() == pontoA.getX() && pontoB.getY() > pontoA.getY()) {
                    pontoA.setLocation(pontoA.getX(), pontoA.getY() + 1);
                    //System.out.println("=,+");
                } else if (pontoB.getX() < pontoA.getX() && pontoB.getY() == pontoA.getY()) {
                    pontoA.setLocation(pontoA.getX() - 1, pontoA.getY());
                    //System.out.println("-,=");
                } else if (pontoB.getX() > pontoA.getX() && pontoB.getY() == pontoA.getY()) {
                    pontoA.setLocation(pontoA.getX() + 1, pontoA.getY());
                    //System.out.println("+,=");
                }
            }
        });
        return timer;
    }

    public static void main(String[] args) {
        new PontoAoOutro().setVisible(true);
    }
}
