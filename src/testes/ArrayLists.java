package testes;

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ArrayLists extends JFrame {

    public ArrayLists() {
        setSize(700,500);
        setLocationRelativeTo(null);
        CriandoArrays();
    }

    public void CriandoArrays() {

        int quantidade_de_cartas = 3;
        int n = quantidade_de_cartas * 2;
        ArrayList< JLabel> agenda = new ArrayList<>();

        for (int j = 1; j < n; j++) {
            JLabel j1 = new JLabel("Número: " + j);
            agenda.add(j1);
        }

        //agenda.get(n).setText("Novo texto");
        for (int i = 0; i < agenda.size(); i++) {
            System.out.println(agenda.get(i));
        }
    }

    public static void main(String[] args) {
        new ArrayLists().setVisible(false);
    }
}
