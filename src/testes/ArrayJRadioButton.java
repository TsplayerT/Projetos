package testes;



import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

public class ArrayJRadioButton extends JFrame {

    ArrayList<JRadioButton> jbuttons = new ArrayList<>();
    String[] nome = {"Guerreiro", "Mago", "Assasino", "Druida", "Clerigo", "Arqueiro"};
    ButtonGroup grupo = new ButtonGroup();
    JButton iniciar = new JButton("iniciar");
    JButton limpar = new JButton("limpar");

    public ArrayJRadioButton() {
        this.setSize(400, 500);
        this.setLayout(null);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        for (int j = 0; j < 6; j++) {
            jbuttons.add(criarJRadioButton(190, 50 + (50 * j), new JRadioButton(nome[j]), this));
            grupo.add(jbuttons.get(j));
        }

        iniciar.setBounds(90, 350, 100, 30);
        this.add(iniciar);
        iniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                int botao_selecionado = 0;
//                for (JRadioButton jb : jbuttons) {
//                    if (jb.isSelected()) {
//                        break;
//                    }
//                    botao_selecionado++;
//                }
//                botao_selecionado++;
//                System.out.println(grupo.getSelection().getActionCommand());
            }
        });

        limpar.setBounds(200, 350, 100, 30);
        this.add(limpar);
        limpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                for (JRadioButton jb : jbuttons) {
//                    jb.setSelected(false);
//                }
//                for (int b = 0; b < jbuttons.length; b++) {
//                    jbuttons[b].setSelected(false);
//                }
                grupo.clearSelection();
            }
        });
    }

    public JRadioButton criarJRadioButton(int x, int y, JRadioButton botao, Container container) {
        botao.setBounds(x, y, 100, 15);
        botao.setOpaque(false);
        container.add(botao);
        return botao;
    }

    public static void main(String[] args) {
        new ArrayJRadioButton().setVisible(true);
    }
}
