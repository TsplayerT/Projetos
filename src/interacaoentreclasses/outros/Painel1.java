package interacaoentreclasses.outros;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Painel1 {

    JPanel painel = new JPanel();
    JLabel l2 = new JLabel();

    public Painel1(Container container) {
//        painel.setBounds(0, 0, 800, 600);
        painel.setLayout(null);
        container.add(painel);

        l2.setIcon(new ImageIcon(getClass().getResource("bg1.jpg")));
        l2.setBounds(10, 10, 413, 413);
        painel.add(l2);

        retornarPainel();
    }

    public JPanel retornarPainel() {
        return painel;
    }

//    public JPanel CriarPainel2(JPanel painel, Container container) {
//        painel.setBounds(0, 0, 800, 600);
//        painel.setLayout(null);
//        container.add(painel);
//
//        JLabel l1 = new JLabel("euaheahue");
//        l1.setBounds(10, 60, 150, 30);
//        painel.add(l1);
//        JLabel l2 = new JLabel();
//        l2.setIcon(new ImageIcon(getClass().getResource("bg1.jpg")));
//        l2.setBounds(100, 10, 413, 413);
//        painel.add(l2);
//        return painel;
//    }
}
