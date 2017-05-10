package interacaoentreclasses.teste;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Painel2 {

    private JPanel panel = new JPanel();

    JLabel imagem = new JLabel();
    JButton jbtVoltar = new JButton("Ir para o painel de voltar");


    public Painel2(CardLayout card, JFrame frame) {
        panel.setLayout(null);
        frame.add(panel);

        jbtVoltar.setBounds(10, 60, 200, 30);
        panel.add(jbtVoltar);

        imagem.setIcon(new ImageIcon(getClass().getResource("/interacaoentreclasses/outros/bg1.jpg")));
        imagem.setBounds(0, 0, 300, 300);
        panel.add(imagem);

        jbtVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                card.show(frame.getContentPane(), "1");
                System.out.println("eahaeygaegyaegyaeyg");
            }
        });
    }

    public JPanel getPanel() {
        return panel;
    }
}
