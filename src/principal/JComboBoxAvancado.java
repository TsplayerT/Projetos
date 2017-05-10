package principal;

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class JComboBoxAvancado extends JFrame {

    ArrayList<JLabel> JComboBoxAvancado = new ArrayList<>();

    public JComboBoxAvancado() {
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);

        for (int q = 0; q > 3; q++) {
            JComboBoxAvancado.add(new JLabel());
        }
    }
}
