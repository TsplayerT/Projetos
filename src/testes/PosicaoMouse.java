package testes;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class PosicaoMouse {

    public void test1() {
        Point p = new Point();
        p = MouseInfo.getPointerInfo().getLocation();
        System.out.println(p);
    }

    public void test2() {
        try {
            Robot r = new Robot();
            r.mousePress(InputEvent.BUTTON1_MASK);
        } catch (AWTException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void test3() {
        Dimension tk = Toolkit.getDefaultToolkit().getScreenSize();
        try {
            Robot r = new Robot();
            Thread.sleep(2000);
            r.mouseMove(tk.width, tk.height);
            r.mousePress(InputEvent.BUTTON1_MASK);
            r.mouseRelease(InputEvent.BUTTON1_MASK);
            r.mouseMove(200, 0);
            r.mousePress(InputEvent.BUTTON1_MASK);
            r.mouseMove(tk.width - 100, tk.height - 100);
            Thread.sleep(100);
            r.keyPress(KeyEvent.VK_DELETE);
            Thread.sleep(100);
            r.keyRelease(KeyEvent.VK_DELETE);
        } catch (AWTException ex) {
            System.out.println(ex.getMessage());
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] args) {
        new PosicaoMouse().test3();
    }

}
