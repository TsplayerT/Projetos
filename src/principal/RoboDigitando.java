package principal;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class RoboDigitando {

    private Robot robot;

    public RoboDigitando() {
        try {
            this.robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            String comando = "C:\\Windows\\System32\\notepad.exe";
            Process processo = Runtime.getRuntime().exec(comando);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        
        RoboDigitando PC = new RoboDigitando();
        PC.robot.delay(1000);
        PC.robot.keyPress(KeyEvent.VK_C);
        PC.robot.keyRelease(KeyEvent.VK_C);
        PC.robot.delay(300);
        PC.robot.keyPress(KeyEvent.VK_A);
        PC.robot.keyRelease(KeyEvent.VK_A);
        PC.robot.delay(300);
        PC.robot.keyPress(KeyEvent.VK_C);
        PC.robot.keyRelease(KeyEvent.VK_C);
        PC.robot.delay(300);
        PC.robot.keyPress(KeyEvent.VK_H);
        PC.robot.keyRelease(KeyEvent.VK_H);
        PC.robot.delay(300);
        PC.robot.keyPress(KeyEvent.VK_O);
        PC.robot.keyRelease(KeyEvent.VK_O);
        PC.robot.delay(300);
        PC.robot.keyPress(KeyEvent.VK_T);
        PC.robot.keyRelease(KeyEvent.VK_T);
        PC.robot.delay(700);
        PC.robot.keyPress(KeyEvent.VK_BACK_SPACE);
        PC.robot.keyRelease(KeyEvent.VK_BACK_SPACE);
        PC.robot.delay(300);
        PC.robot.keyPress(KeyEvent.VK_R);
        PC.robot.keyRelease(KeyEvent.VK_R);
        PC.robot.delay(300);
        PC.robot.keyPress(KeyEvent.VK_R);
        PC.robot.keyRelease(KeyEvent.VK_R);
        PC.robot.delay(300);
        PC.robot.keyPress(KeyEvent.VK_O);
        PC.robot.keyRelease(KeyEvent.VK_O);
        PC.robot.delay(1000);
        PC.robot.keyPress(KeyEvent.VK_CONTROL);
        PC.robot.delay(300);
        PC.robot.keyPress(KeyEvent.VK_A);
        PC.robot.delay(300);
        PC.robot.keyRelease(KeyEvent.VK_A);
        PC.robot.delay(300);
        PC.robot.keyRelease(KeyEvent.VK_CONTROL);
        PC.robot.delay(300);
        PC.robot.keyPress(KeyEvent.VK_BACK_SPACE);
        PC.robot.delay(300);
        PC.robot.keyRelease(KeyEvent.VK_BACK_SPACE);
        
    }
}
