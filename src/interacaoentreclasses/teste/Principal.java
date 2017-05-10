package interacaoentreclasses.teste;

import java.awt.CardLayout;
import javax.swing.JFrame;

public class Principal extends Criador {

    private static JFrame frame = new JFrame("TITULO");
    private CardLayout card = new CardLayout();

    public Principal() {
        super(300, 300, frame);
        frame.setLayout(card);

        card.addLayoutComponent(new Painel1(card, frame).getPanel(), "1");
        card.addLayoutComponent(new Painel2(card, frame).getPanel(), "2");
        card.show(frame.getContentPane(), "1");
    }

    public static void main(String[] args) {
        new Principal().frame.setVisible(true);
    }
}
