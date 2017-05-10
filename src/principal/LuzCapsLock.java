package principal;

import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

public class LuzCapsLock {

    public static void main(String[] args) {
        Toolkit tk = Toolkit.getDefaultToolkit();

        // Liga a tecla Caps Lock
        tk.setLockingKeyState(KeyEvent.VK_CAPS_LOCK, true);

        // Para desligar basta usar:
        // tk.setLockingKeyState(KeyEvent.VK_CAPS_LOCK, false);  
        JOptionPane.showMessageDialog(null,"Olhe a luz do Caps Lock!");
        System.exit(0);
    }
}
