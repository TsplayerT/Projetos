package testes;

import javax.swing.JOptionPane;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseListener;

public class CaptureMouse implements NativeMouseListener {
        public void nativeMouseClicked(NativeMouseEvent e) {
                System.out.println("Mosue Clicked: " + e.getClickCount());
        }

        public void nativeMousePressed(NativeMouseEvent e) {
                System.out.println("Mosue Pressed: " + e.getButton());
        }

        public void nativeMouseReleased(NativeMouseEvent e) {
                System.out.println("Mosue Released: " + e.getButton());
        }


        public static void main(String[] args) {
                try {
                        GlobalScreen.registerNativeHook();
                }
                catch (NativeHookException ex) {
                        System.err.println("There was a problem registering the native hook.");
                        System.err.println(ex.getMessage());

                        System.exit(1);
                }
                GlobalScreen.addNativeMouseListener(new CaptureMouse());
        }
}