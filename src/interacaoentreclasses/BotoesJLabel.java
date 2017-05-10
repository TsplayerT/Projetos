package interacaoentreclasses;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class BotoesJLabel {

    JFrame frame = new JFrame();

    String image_botao0 = "/interacaoentreclasses/botao_menu0.png";
    String image_botao1 = "/interacaoentreclasses/botao_menu1.png";

    public BotoesJLabel() {
        frame.setSize(600, 600);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        criarBotao(50, 50, "botao", new JLabel(), new JLabel(), frame);

        Toolkit tk = Toolkit.getDefaultToolkit();
        Image cursorImage = tk.getImage(getClass().getResource("/interacaoentreclasses/cursor.png"));
        Cursor cursor = tk.createCustomCursor(cursorImage, new Point(0, 0), "Custom Cursor");
        frame.setCursor(cursor);

    }

    public void criarBotao(int x, int y, String texto, JLabel label_texto, JLabel label_botao, Container container) {
        label_texto.setText(texto);
        label_texto.setBounds(x, y, 160, 40);
        label_texto.setFont(new Font("Arial", 1, 14));
        label_texto.setForeground(Color.LIGHT_GRAY);
        label_texto.setHorizontalAlignment(SwingConstants.CENTER);
        container.add(label_texto);

        label_botao.setBounds(x, y, 160, 40);
        label_botao.setIcon(new ImageIcon(getClass().getResource(image_botao0)));
        container.add(label_botao);
        label_botao.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                container.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                Toolkit tk = Toolkit.getDefaultToolkit();
                Image cursorImage = tk.getImage(getClass().getResource("/interacaoentreclasses/cursor.png"));
                Cursor cursor = tk.createCustomCursor(cursorImage, new Point(0, 0), "Custom Cursor");
                container.setCursor(cursor);
            }

            public void mousePressed(MouseEvent e) {
                label_botao.setIcon(new ImageIcon(getClass().getResource(image_botao1)));
            }

            public void mouseReleased(MouseEvent e) {
                label_botao.setIcon(new ImageIcon(getClass().getResource(image_botao0)));
            }

            public void mouseClicked(MouseEvent e) {
                System.out.println("click");
            }
        });

    }

    public static void main(String[] args) {
        new BotoesJLabel().frame.setVisible(true);
    }
}
