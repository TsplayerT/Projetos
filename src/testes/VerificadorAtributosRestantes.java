package testes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
//import projetorpg.principal.ConexaoBD;

public class VerificadorAtributosRestantes extends JFrame {
//public class VerificadorAtributosRestantes extends Thread {
//
//    boolean loop;
//
//    public VerificadorAtributosRestantes(boolean loop) {
//        this.loop = loop;
//
//    }
//
//    @Override
//    public void run() {
//        while (loop) {
//
//        }
//    }

    boolean loop = true;
    static ArrayList<JSlider> sliders = new ArrayList<>();
    JButton botao = new JButton("botao");
    JLabel atributos_restantes = new JLabel();

    public VerificadorAtributosRestantes() {
        this.setSize(400, 500);
        this.setLayout(null);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        atributos_restantes.setBounds(150, 350, 20, 30);
        this.add(atributos_restantes);

        botao.setBounds(100, 400, 150, 30);
        this.add(botao);
        botao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int js = 0; js < sliders.size(); js++) {
                    sliders.get(js).setValue(0);
                    sliders.get(js).setEnabled(true);
                }
                tread.resume();
            }
        });
        tread.start();
    }

    Thread tread = new Thread(new Runnable() {
        public void run() {
            while (loop) {
                try {
                    Thread.sleep(100);
                    int atributos_atuais = 20;//Integer.parseInt(ConexaoBD.mostrarLinha("configuracao", "atributo_inicial", 1));
                    for (int c = 0; c < sliders.size(); c++) {
                        atributos_atuais -= sliders.get(c).getValue();
                    }
                    atributos_restantes.setText(Integer.toString(atributos_atuais));
                    if (atributos_atuais <= 0) {
                        for (int x = 0; x < sliders.size(); x++) {
                            sliders.get(x).setEnabled(false);
                        }
                    }
                    if (Integer.parseInt(atributos_restantes.getText()) <= 0) {
                        for (int c = 0; c < sliders.size(); c++) {
                            sliders.get(c).setEnabled(false);
                            sliders.get(c).setLabelTable(null);
                        }
                        tread.suspend();
                    }
                } catch (InterruptedException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
    });

    public void keep() {
        for (int js = 0; js < 5; js++) {
            sliders.add(new JSlider(SwingConstants.HORIZONTAL, 0, 5, 0));
            sliders.get(js).setBounds(10, 10 + (js * 50), 200, 30);
            sliders.get(js).setMinorTickSpacing(1);
            sliders.get(js).setPaintTicks(true);
            this.add(sliders.get(js));
        }
    }

    public static void main(String[] args) {
//        ConexaoBD.Conexao();
        VerificadorAtributosRestantes var = new VerificadorAtributosRestantes();
        var.keep();

    }

}
