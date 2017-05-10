package testes;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Slider extends JFrame {

    JSlider jslider = new JSlider();
    JLabel label = new JLabel("LAAABELLL");

    public Slider() {
        setSize(800, 600);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        
        //label.setBounds(10,200,100,100);
        //add(label);
        
        jslider.setMaximum(4);
        jslider.setMinimum(1);
        jslider.setOrientation(JSlider.VERTICAL);
        jslider.setPaintTicks(true);
        jslider.setPaintLabels(true);
        jslider.setBounds(10,10,50,500);
        add(jslider);
        jslider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider source = (JSlider) e.getSource();
                if (!source.getValueIsAdjusting()) {
                    System.out.println(source.getValue());
                }
            }
        });
    }

    public static void main(String[] args) {
        new Slider();
    }

}
