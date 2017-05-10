package testes;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.jnativehook.GlobalScreen;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseListener;

public class MOUSE implements NativeKeyListener, NativeMouseListener {

    Date data = new Date();
    SimpleDateFormat fd = new SimpleDateFormat("dd-MM-yyyy");
    String fdd = fd.format(data);
    Date hora = new Date();
    SimpleDateFormat fh = new SimpleDateFormat("HH:mm:ss");
    String fhh = fh.format(hora);

    @Override
    public void nativeMouseClicked(NativeMouseEvent nme) {
        try {
            PrintWriter wr = new PrintWriter(new FileWriter(fdd + ".txt", true));
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

    @Override
    public void nativeKeyPressed(NativeKeyEvent nke) {
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent nke) {
    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent nke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public static void main(String[] args) {
        try {
            GlobalScreen.registerNativeHook();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        GlobalScreen.addNativeMouseListener(new MOUSE());
        GlobalScreen.addNativeKeyListener(new MOUSE());
    }
}
