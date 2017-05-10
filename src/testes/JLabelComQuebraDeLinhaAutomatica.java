package testes;

import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class JLabelComQuebraDeLinhaAutomatica extends JFrame {

    //JTextPane
    //JTextField
    JTextArea textArea = new JTextArea();
    //JPopupMenu
    //JSplitPane
    //JToolBar
    //JToolTip
    //JViewport

    public JLabelComQuebraDeLinhaAutomatica() {
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);

        textArea.setText("DROUGRAS DROUGRAS DROUGRAS DROUGRAS DROUGRAS DROUGRAS ");
        textArea.setOpaque(false);
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setFont(new Font("Arial", 1, 20));
        textArea.setBounds(200, 200, 150, 40);
        this.add(textArea);
    }

    public static void main(String[] args) {
        new JLabelComQuebraDeLinhaAutomatica().setVisible(true);
    }
}
