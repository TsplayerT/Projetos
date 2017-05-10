package testes;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class MetodoParaLabel extends JFrame {

    String a;
    JTextArea jl = new JTextArea();

    public MetodoParaLabel() {
        setSize(800, 600);
        setLayout(new FlowLayout());
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
//        jl.setHorizontalAlignment(SwingConstants.LEFT);
//        jl.setVerticalAlignment(SwingConstants.TOP);
       jl.setLineWrap(true);
        add(jl);
    }

    public void publicar() {
        a = "HAHAHAHAHAHAHAHAHAHAHAHAHAHAHAHAHAHAHAHAHAHAHAHAHAHAHAHAHAHAHAHAHAHAHAHAHAHAHAHAHAHAHAHAHAHAHAHAHAHAHAHAHAHAHAHAHAHAHAHAHAHAHAHAHAHAHAHAHAHAHAHAHAHAHAHAHAHAHAHAHAHAHAHAHAHAHAl";
        jl.setText(a);
    }

    public static void main(String[] args) {
        MetodoParaLabel mpl = new MetodoParaLabel();
        mpl.publicar();
    }
}
