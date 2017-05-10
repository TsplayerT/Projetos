package interacaoentreclasses.outros;

import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.SystemColor;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CardLayoutDemo extends Frame implements ActionListener {

    Panel cards = new Panel();
    Panel p1 = new Panel();
    Panel p2 = new Panel();

    Button bPrim = new Button("Primerio");
    Button bAnt = new Button("Anterior");
    Button bProx = new Button("Próximo");
    Button bUlt = new Button("Ultímo");

    public CardLayoutDemo() {
        super("CardLayoutDemo");
        this.setSize(300, 200);

        p1.setBackground(SystemColor.control);
        p2.setBackground(SystemColor.control);
        p2.setLayout(new GridLayout(4, 1, 5, 5));
        p2.add(bPrim);
        bPrim.addActionListener(this);
        p2.add(bAnt);
        bAnt.addActionListener(this);
        p2.add(bProx);
        bProx.addActionListener(this);
        p2.add(bUlt);
        bUlt.addActionListener(this);
        p1.add(p2);
        this.add("East", p1);
        cards.setLayout(new CardLayout());
        cards.add(new Label("Primeiro Painel"), "C1");
        //cards.add(new Picture("cupHJbutton.gif"), "C2");
        cards.add(new TextArea(), "C3");
        p2 = new Panel();
        p2.setBackground(SystemColor.control);
        p2.add(new Label("Quarto Painel"));
        //p2.add(new Picture("cupHJbutton.gif", 32, 32));
        cards.add(p2, "C4");
        p2 = new Panel();
        p2.setBackground(Color.lightGray);
        cards.add(p2, "C5");
        this.add("Center", cards);
    }

    public void actionPerformed(ActionEvent e) {
        CardLayout c1 = ((CardLayout) cards.getLayout());
        if (e.getSource() == bPrim) {
            c1.first(cards);
        } else if (e.getSource() == bAnt) {
            c1.previous(cards);
        } else if (e.getSource() == bProx) {
            c1.next(cards);
        } else {
            c1.last(cards);
        }
    }

    public static void main(String args[]) {
        new CardLayoutDemo().setVisible(true);
    }
}
