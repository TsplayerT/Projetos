package tratamentodeimagem;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

public class NovoClass extends JFrame {

    JLabel pontoA = new JLabel(".");
    JLabel pontoB = new JLabel(".");

    public NovoClass() {
        this.setSize(600, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(false);

        pontoA.setBounds(50, 50, 50, 50);
        pontoA.setFont(new Font("Arial", 1, 40));
        pontoA.setForeground(Color.red);
        this.add(pontoA);

        pontoB.setBounds(500, 300, 50, 50);
        pontoB.setFont(new Font("Arial", 1, 40));
        this.add(pontoB);
        Timer(5, pontoA, pontoB).start();
    }

    public Timer Timer(int tempo, Component pontoA, Component pontoB) {
        Timer timer = new Timer(tempo, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (pontoA.getX() < pontoB.getX()) {
                    pontoB.setLocation(pontoB.getX() - 1, pontoB.getY());
                }
                if (pontoA.getY() < pontoB.getY()) {
                    pontoB.setLocation(pontoB.getX(), pontoB.getY() - 1);
                }
            }
        });
        return timer;
    }

    public static void main(String[] args) {
        new NovoClass().setVisible(true);
    }
}
