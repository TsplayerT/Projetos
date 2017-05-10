package interacaoentreclasses.outros;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Painel {

    JPanel painel = new JPanel();

    public Painel(Container container) {
//        painel.setBounds(0, 0, 800, 600);
        painel.setLayout(null);
        container.add(painel);

        JLabel l1 = new JLabel("euaheahue");
        l1.setBounds(10, 10, 150, 30);
        painel.add(l1);
        JLabel l2 = new JLabel();
        l2.setIcon(new ImageIcon(getClass().getResource("bg.jpg")));
        l2.setBounds(100, 10, 413, 413);
        painel.add(l2);
        JButton bb = new JButton("irhauea");
        bb.setBounds(50, 50, 150, 30);
        painel.add(bb);
        bb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new JanelaPrincipal().pane2();
            }
        });

        retornarPainel();
    }

    public JPanel retornarPainel() {
        return painel;
    }

    public JPanel CriarPainel2(JPanel painel, Container container) {
//        painel.setBounds(0, 0, 800, 600);
        painel.setLayout(null);
        container.add(painel);

        JLabel l1 = new JLabel("euaheahue");
        l1.setBounds(10, 60, 150, 30);
        painel.add(l1);
        JLabel l2 = new JLabel();
        l2.setIcon(new ImageIcon(getClass().getResource("bg1.jpg")));
        l2.setBounds(100, 10, 413, 413);
        painel.add(l2);
        return painel;
    }
}
