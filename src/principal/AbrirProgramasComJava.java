package principal;

import java.io.File;
import java.io.IOException;

public class AbrirProgramasComJava {

    public static void main(String[] args) {
        //Runtime.getRuntime().exec("calc");
        try {
            String comando = "C:\\Windows\\System32\\calc.exe";
            
            Process processo = Runtime.getRuntime().exec(comando);
            java.awt.Desktop.getDesktop().open(new File(comando));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
