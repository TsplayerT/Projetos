package principal;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class PrintScreen {

    public static void main(String[] args) {
        Dimension tk = Toolkit.getDefaultToolkit().getScreenSize();
        while (true) {
            try {
                Robot r = new Robot();
                BufferedImage bf = r.createScreenCapture(new Rectangle(0, 0, (int) tk.getWidth(), (int) tk.getHeight()));
                Thread.sleep(5000);
                ImageIO.write(bf, "JPEG", new File("E:/Segurança/" + System.currentTimeMillis() + ".JPEG"));
            } catch (AWTException | IOException ex) {
                System.out.println(ex.getMessage());
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

}
