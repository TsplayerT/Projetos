package testes;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

public class FileWriterr {

    public static void main(String[] args) {

        int code = 999623;
        try {
            File raiz = new File("catta.txt");
            FileWriter arq = new FileWriter(raiz, false);

            PrintWriter gravarArq = new PrintWriter(arq);
            gravarArq.println(code);
            gravarArq.close();

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
}
