package principal;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class DuasTeclas implements KeyListener {

    static boolean click = false;

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == e.VK_LEFT) {
            System.out.println("click");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    public static void main(String[] args) {
        new DuasTeclas();
        new Runnable().start();
    }
}

class Runnable extends Thread {

    public void run() {
        new Thread();
        while (true) {
            try {
                Thread.sleep(1000);
                System.out.println(DuasTeclas.click);
            } catch (InterruptedException ex) {
            }
        }
    }
}
