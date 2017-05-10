
package testes;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URLDecoder;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class NovoClass extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    
    private JTextArea textArea;
    
    public NovoClass() throws Exception {
        JButton button = new JButton("Gravar no Arquivo");
        button.addActionListener(this);
        
        textArea = new JTextArea(5, 5);
        
        getContentPane().add(button, BorderLayout.NORTH);
        getContentPane().add(textArea, BorderLayout.CENTER);
        
        setTitle("Gravador de texto em arquivo");
        setSize(340, 160);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) throws Exception {
        new NovoClass();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String path = System.getProperty("user.dir") + File.separator + "output.txt";//MainApp.class.getProtectionDomain().getCodeSource().getLocation().getPath() + File.separator + "output.txt";
            String decodedPath = URLDecoder.decode(path, "UTF-8");
            FileWriter fw = new FileWriter(decodedPath, false);
            fw.write(textArea.getText());
            fw.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
    
}