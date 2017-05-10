package interacaoentreclasses.teste;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Painel1 {

    private JPanel panel = new JPanel();

    JLabel imagem = new JLabel();
    JButton jbtIr = new JButton("Ir para o painel de trás");

    public Painel1(CardLayout card, JFrame frame) {
        panel.setLayout(null);
        frame.add(panel);

        jbtIr.setBounds(10, 10, 200, 30);
        panel.add(jbtIr);

        imagem.setIcon(new ImageIcon(getClass().getResource("/interacaoentreclasses/outros/bg.jpg")));
        imagem.setBounds(0, 0, 300, 300);
        panel.add(imagem);

        jbtIr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                card.show(frame.getContentPane(), "2");
                System.out.println("hehauhe");
            }
        });
    }

    public JPanel getPanel() {
        return panel;
    }
}
