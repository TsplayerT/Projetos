package principal;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class ApagandoArquivosTEMP {

    private Robot robot;

    public ApagandoArquivosTEMP() {
        try {
            this.robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ApagandoArquivosTEMP PC = new ApagandoArquivosTEMP();
        PC.robot.keyPress(KeyEvent.VK_WINDOWS);
        PC.robot.delay(100);
        PC.robot.keyPress(KeyEvent.VK_R);
        PC.robot.delay(100);
        PC.robot.keyRelease(KeyEvent.VK_R);
        PC.robot.delay(100);
        PC.robot.keyRelease(KeyEvent.VK_WINDOWS);
        PC.robot.delay(1000);
        PC.robot.keyPress(KeyEvent.VK_SHIFT);
        PC.robot.delay(100);
        PC.robot.keyPress(KeyEvent.VK_5);
        PC.robot.delay(100);
        PC.robot.keyRelease(KeyEvent.VK_5);
        PC.robot.delay(100);
        PC.robot.keyRelease(KeyEvent.VK_SHIFT);
        PC.robot.delay(100);
        PC.robot.keyPress(KeyEvent.VK_T);
        PC.robot.delay(100);
        PC.robot.keyRelease(KeyEvent.VK_T);
        PC.robot.delay(100);
        PC.robot.keyPress(KeyEvent.VK_E);
        PC.robot.delay(100);
        PC.robot.keyRelease(KeyEvent.VK_E);
        PC.robot.delay(100);
        PC.robot.keyPress(KeyEvent.VK_M);
        PC.robot.delay(100);
        PC.robot.keyRelease(KeyEvent.VK_M);
        PC.robot.delay(100);
        PC.robot.keyPress(KeyEvent.VK_P);
        PC.robot.delay(100);
        PC.robot.keyRelease(KeyEvent.VK_P);
        PC.robot.delay(100);
        PC.robot.keyPress(KeyEvent.VK_SHIFT);
        PC.robot.delay(100);
        PC.robot.keyPress(KeyEvent.VK_5);
        PC.robot.delay(100);
        PC.robot.keyRelease(KeyEvent.VK_5);
        PC.robot.delay(100);
        PC.robot.keyRelease(KeyEvent.VK_SHIFT);
        PC.robot.delay(1000);
        PC.robot.keyPress(KeyEvent.VK_ENTER);
        PC.robot.delay(100);
        PC.robot.keyRelease(KeyEvent.VK_ENTER);
        PC.robot.delay(2000);
        PC.robot.keyPress(KeyEvent.VK_CONTROL);
        PC.robot.delay(100);
        PC.robot.keyPress(KeyEvent.VK_A);
        PC.robot.delay(100);
        PC.robot.keyRelease(KeyEvent.VK_A);
        PC.robot.delay(100);
        PC.robot.keyRelease(KeyEvent.VK_CONTROL);
        PC.robot.delay(100);
        PC.robot.keyPress(KeyEvent.VK_SHIFT);
        PC.robot.delay(100);
        PC.robot.keyPress(KeyEvent.VK_DELETE);
        PC.robot.delay(100);
        PC.robot.keyRelease(KeyEvent.VK_DELETE);
        PC.robot.delay(100);
        PC.robot.keyRelease(KeyEvent.VK_SHIFT);
        PC.robot.delay(100);
        PC.robot.keyPress(KeyEvent.VK_ENTER);
        PC.robot.delay(100);
        PC.robot.keyRelease(KeyEvent.VK_ENTER);
        PC.robot.delay(5000);
        PC.robot.keyPress(KeyEvent.VK_ESCAPE);
        PC.robot.delay(100);
        PC.robot.keyRelease(KeyEvent.VK_ESCAPE);
    }
}
