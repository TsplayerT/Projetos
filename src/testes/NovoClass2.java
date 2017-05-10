package testes;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NovoClass2 {
     void colocandoTxt(String String) {
        File dir = new File("..\\cache-KL");
        boolean bol = dir.mkdirs();
        Date data = new Date();
        SimpleDateFormat formatas = new SimpleDateFormat("dd-MM-yyyy HH+mm+ss");
        String daa = formatas.format(data);
        File arquivo = new File(dir + "\\" + daa + ".txt");
        try (FileWriter fw = new FileWriter(arquivo)) {
            fw.write("funcional");
            fw.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
     public static void main(String[] args) {
        
    }
}
