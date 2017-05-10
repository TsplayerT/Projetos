package testes;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class MoverImagemComMouse extends javax.swing.JFrame {

    ImageIcon splayer = new ImageIcon(getClass().getResource("splayer.png"));
    JLabel label= new JLabel(splayer);
    
    public MoverImagemComMouse() {
        initComponents();
        add(label);
        label.setBounds(200, 200, 250, 249);
        new Mover().start();
        label.addMouseListener(new MouseListener(){
            public void mouseReleased(MouseEvent e){
                mousePressionado = false;
            }
            public void mousePressed(MouseEvent  e){
                mousePressionado = true;
            }
            public void mouseExited(MouseEvent  e){
            }
            public void mouseEntered(MouseEvent  e){
            }
            public void mouseClicked(MouseEvent  e){
            }
        });
        }
    
    boolean mousePressionado = false;
    
    public class Mover extends Thread{
        public void run(){
            while(true){
               try{
                   sleep(10);
               }catch(Exception error){  
               }
               if(mousePressionado){
                    Point ponto =  getMousePosition();
                    label.setBounds(ponto.x-125, ponto.y-125, 250, 250);
               }
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(616, 639));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MoverImagemComMouse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MoverImagemComMouse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MoverImagemComMouse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MoverImagemComMouse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MoverImagemComMouse().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
