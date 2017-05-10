package testes;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MostrarTextoComMouseEmCima extends JFrame {

    JButton botao = new JButton("BOTAO");
    JLabel label = new JLabel();

    public MostrarTextoComMouseEmCima() {
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);

        botao.setBounds(200, 400, 100, 30);
        this.add(botao);

        label.setBounds(200, 300, 100, 30);
        this.add(label);
        botao.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                label.setText("BOTAO");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                label.setText("");
            }
        });
    }

    public static void main(String[] args) {
        new MostrarTextoComMouseEmCima().setVisible(true);
    }
}
