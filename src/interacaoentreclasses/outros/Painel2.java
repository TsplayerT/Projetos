package interacaoentreclasses.outros;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Painel2 extends Panel {

    JButton button = new JButton("248487429387");

//    public Painel2() {
//        super();
//    }

    public Painel2(CardLayout card) {
        this.setBounds(0, 0, 800, 600);
        this.setBackground(Color.RED);
//        this.setLayout(JanelaPrincipal.card);
        this.setLayout(card);
//        this.setVisible(true);
        card.addLayoutComponent(this, "a");

        button.setBounds(300, 200, 100, 30);
        this.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "UHHUAEHUAEHUAE");
            }
        });
    }
}
