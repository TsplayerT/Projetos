package testes;

import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MouseEmCimaMostrarTexto extends JFrame {

    JLabel label = new JLabel("CLASSE");

    public MouseEmCimaMostrarTexto() {
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);

        label.setBounds(200, 200, 150, 40);
        label.setFont(new Font("Arial", 1, 20));
        label.setToolTipText("Seu Texto");
        this.add(label);
    }

    public static void main(String[] args) {
        new MouseEmCimaMostrarTexto().setVisible(true);
    }
    
}
