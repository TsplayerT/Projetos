package testes;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class UmAUm {

    int quantidade = 5;
    int numero_inicial = 0;
    int numero_final = 100;

    Frame frame = new Frame();
    JLabel label = new JLabel();

    public void janela() {
        frame.setBackground(new Color(90, 90, 255));
        frame.setLayout(null);
        frame.add(label);
        frame.show();
        executando();
    }

    public void executando() {
        for (int i = 1; i < 1 + quantidade; i++) {
            int multiplicador = i;
            label.setHorizontalAlignment(SwingConstants.CENTER);
            label.setBounds(80 * multiplicador, 50 * multiplicador, 100 * multiplicador, 40 * multiplicador);
            label.setFont(new Font("Arial", 1, 40 * multiplicador));
            frame.setSize(200 * multiplicador, 100 * multiplicador);
            frame.setLocationRelativeTo(null);
            for (int numero_atual = numero_inicial; numero_atual < numero_final; numero_atual++) {
                try {
                    new Thread().sleep(20);
                    label.setText(Integer.toString(numero_atual));
                } catch (InterruptedException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
        System.exit(0);
    }

    public static void main(String[] args) {
        new UmAUm().janela();
    }

}
