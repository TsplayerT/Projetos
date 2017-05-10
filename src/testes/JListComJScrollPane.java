package testes;

import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class JListComJScrollPane extends JFrame {

    JLabel label0 = new JLabel("arraylist");
    JLabel label1 = new JLabel("vetor simples");

    //COM ARRAYLIST
    ArrayList<Integer> vetor0 = new ArrayList<>();
    DefaultListModel modelo = new DefaultListModel();
    JList list0 = new JList(modelo);
    JScrollPane scrollpane0 = new JScrollPane(list0);

    //COM VETOR SIMPLES
    String[] vetor1 = new String[9];
    JList list1 = new JList(vetor1);
    JScrollPane scrollpane1 = new JScrollPane(list1);

    public JListComJScrollPane() {
        this.setSize(400, 300);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        label0.setBounds(60, 20, 150, 30);
        this.add(label0);
        label1.setBounds(250, 20, 150, 30);
        this.add(label1);

        //ARRAYLIST
        for (int x = 0; x < 9; x++) {
            modelo.addElement(x + 1);
        }
        scrollpane0.setBounds(40, 50, 100, 150);
        this.add(scrollpane0);

        //VETOR SIMPLES
        for (int x = 0; x < 9; x++) {
            vetor1[x] = Integer.toString(x + 1);
        }
        scrollpane1.setBounds(240, 50, 100, 150);
        this.add(scrollpane1);
    }

    public static void main(String[] args) {
        new JListComJScrollPane().setVisible(true);
    }

}
