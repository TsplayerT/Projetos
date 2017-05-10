package interacaoentreclasses.teste;

import javax.swing.JFrame;

public class Criador {
    
    public Criador(int x, int y, JFrame frame) {
        frame.setSize(x, y);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
