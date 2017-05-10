package testes;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class Existe {

    Date data = new Date();
    SimpleDateFormat fd = new SimpleDateFormat("dd-MM-yyyy");
    String fdd = fd.format(data);
    Date hora = new Date();
    SimpleDateFormat fh = new SimpleDateFormat("[--HH:mm:ss--]");
    String fhh = fh.format(hora);

    boolean criado;
    File file = new File(fdd + ".txt");

    public void existente() {
        if (!file.exists()) {
            criado = true;
        }
        try (PrintWriter gravarArq = new PrintWriter(new FileWriter(file, true))) {
            if (criado == true) {
                gravarArq.printf(fhh);
                gravarArq.println("\n");
                criado = false;
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public static void main(String[] args) {
        Existe Existe = new Existe();
        Existe.existente();
    }
}
