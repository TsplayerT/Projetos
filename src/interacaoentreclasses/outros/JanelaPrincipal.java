package interacaoentreclasses.outros;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JanelaPrincipal extends JFrame {

    public static CardLayout card = new CardLayout();
    JPanel panel = new JPanel();
//    Painel2 painel = new Painel2();
    Painel2 paine = new Painel2(card);
    JPanel pa = new JPanel();
    JPanel pa1 = new JPanel();
    JButton button = new JButton("botao");
//    Painel Painel = new Painel();

    public JanelaPrincipal() {
        this.setSize(800, 600);
        this.setLayout(card);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//        panel.setSize(800, 600);
//        panel.setBackground(Color.red);
//        panel.setLayout(card);
//        this.add(panel);
//        this.add(Painel.CriarPainel(new JPanel(), this));
//        card.addLayoutComponent(new Painel(getContentPane()).retornarPainel(), "a");
//        JanelaPrincipal.card.addLayoutComponent(new Painel1(getContentPane()).retornarPainel(), "c");

//        card.addLayoutComponent(Painel.CriarPainel2(pa1, getContentPane()), "b");
//        card.show(getContentPane(), Painel.CriarPainel2(new JPanel(), this).getName());
//        card.show(getContentPane(), Painel.CriarPainel(new JPanel(), this).getName());
        card.addLayoutComponent(new Painel(this).painel, "z");
        card.show(getContentPane(), "z");

//        card.addLayoutComponent(new Painel2(card), "a");
//        card.show(panel, "a");
//        card.next(new Painel2(card));
//        card.addLayoutComponent(new Painel1(), "a");
//        card.addLayoutComponent(new Painel2(), "b");
//        card.next(painel);
//        card.first(painel);
//        pa.setSize(800, 600);
//        pa.setBackground(Color.red);
//        pa.setLayout(null);
//        panel.add(pa);
//        card.addLayoutComponent(painel, "b");
//        new Painel2();
//        new Painel2(card);
//        button.setBounds(300, 200, 100, 30);
//        panel.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                card.addLayoutComponent(new Painel2(), "a");
//                card.addLayoutComponent(painel, "a");
//                card.addLayoutComponent(paine, "a");
//                card.addLayoutComponent(new Painel2(card), "a");

//                card.invalidateLayout(panel);
//                card.preferredLayoutSize(new Painel2());
//                card.preferredLayoutSize(new Painel2(card));
//                card.removeLayoutComponent(panel);
//                panel.disable();
//                panel.setVisible(false);
//                card.layoutContainer(paine);
//                card.layoutContainer(painel);
//                card.layoutContainer(new Painel2());
//                card.layoutContainer(new Painel2(card));
//                card.show(getContentPane(), "a");
//                card.show(panel, "a");
//                card.first(paine);
//                card.first(painel);
//                card.first(new Painel2(card));
//                card.next(new Painel2(card));
//                new Painel2(card).show(true);
//                new Painel2(card).setVisible(true);
//                new Painel2();
//                new Painel2().setVisible(true);
//                new Painel2().show(true);
//                card.show(painel, "b");
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\neuhaeuuaeuheauh");
//                CardLayout cards = ((CardLayout) card.getLayout());
//                card = ((CardLayout) panel.getLayout());
//                if (e.getSource().equals(button)) {
//                    c1.first(new Painel1());
//                    System.out.println("uuaeuhea");
//                    card.addLayoutComponent(painel, "a");
//                    card.show(panel, "a");
//                } else {
//                    c1.last(new Painel2());
//                    card.next(painel);
//                    System.out.println("aehuaeuhae");
//                }
            }
        });
//        card.addLayoutComponent(new Painel1(), "1");
//        card.addLayoutComponent(new Painel2(), "2");
//        card.first(new Painel2());
    }

    public void pane2() {
        System.out.println("euhauheaue");
        card.addLayoutComponent(new Painel1(getContentPane()).painel, "x");
        card.show(getContentPane(), "x");
    }

    public static void main(String[] args) {
        new JanelaPrincipal().setVisible(true);
    }

}
