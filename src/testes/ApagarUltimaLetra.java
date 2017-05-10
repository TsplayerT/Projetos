package testes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import javax.swing.JOptionPane;

public class ApagarUltimaLetra {

    public void projetoApagar() {

        
        /*try (BufferedWriter wr = new BufferedWriter(new FileWriter(new File("ArquivoXYZ.txt"), true))) {
        //wr.write("Apagou");
        try {
        BufferedReader lerArq = new BufferedReader(new FileReader("ArquivoXYZ.txt"));
        String line = "Apagou";
        while ((line = lerArq.readLine()) != null) {
        
        line = line.substring(0, line.length() - 1);
        System.out.printf("%s\n", line);
        wr.write(line);
        }
        } catch (IOException e) {
        JOptionPane.showMessageDialog(null, e.getMessage());
        }
        wr.flush();
        wr.close();
        } catch (IOException erro) {
        JOptionPane.showMessageDialog(null, erro.getMessage());
        }*/
        
         File file = new File("ArquivoXYZ.txt");
        try {
        BufferedReader in4 = new BufferedReader(new StringReader("ABCD"));
        PrintWriter out1 = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
        String s = null;
        while ((s = in4.readLine()) != null) {
        out1.println(s = s.substring(0, s.length() - 1));
        }
        out1.close();
        
        } catch (IOException erro) {
        JOptionPane.showMessageDialog(null, erro.getMessage());
        }
    }

    public static void main(String[] args) {
        ApagarUltimaLetra aut = new ApagarUltimaLetra();
        aut.projetoApagar();
    }
}
