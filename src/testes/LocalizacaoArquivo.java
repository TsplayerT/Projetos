package testes;

import java.io.File;
import java.net.URISyntaxException;
import javax.swing.JOptionPane;

public class LocalizacaoArquivo {

    public String getFile1() throws URISyntaxException {
        return getClass().getResource("/testes/splayer.png").toURI().toString();
    }

    public File getFile2() {
        File dir = new File("src/testes/splayer.png").getAbsoluteFile();
        return dir;
    }

    public boolean getFile3() {
        File dir = new File("src/testes/splayer.png");
        return dir.exists();
    }

    public void getFile4() {
        File dir = new File("arquivos/splayer.png");
        JOptionPane.showMessageDialog(null, dir + " | " + dir.exists());
    }

    public static void main(String[] args) {
        LocalizacaoArquivo t = new LocalizacaoArquivo();
        JOptionPane.showMessageDialog(null, "Arquivo existe: " + t.getFile3());
    }
}
