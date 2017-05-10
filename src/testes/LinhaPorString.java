package testes;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LinhaPorString {

    String itens, data;
    String[] nomes;
    String um, dois, tres;

    public void teste() throws FileNotFoundException, IOException {
        FileReader fileReader = new FileReader("Alfa Teste.txt");
        BufferedReader reader = new BufferedReader(fileReader);
        while ((data = reader.readLine()) != null) {
            if (!"".equals(itens)) {
                itens += ",";
            }
            itens += data;
        }
        nomes = itens.split(",");
        um = nomes[0];
        dois = nomes[4];
        System.out.println(um);
        System.out.println(dois);
    }

    public static void main(String[] args) {
        try {
            new LinhaPorString().teste();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
