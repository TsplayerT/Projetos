package testes;

public class SomarCinco extends javax.swing.JFrame {

    public SomarCinco() {
        initComponents();
    }

//    public void Comandar(){
//        boolean turno = true;
//        for(int i=3;i>6;i++){
//        int chance = (int) (Math.random()* 10);
//        if(chance > 5){
//            turno = false;
//            System.out.println(chance);
//        }
//        }
//    }
    int vJME = 1;//V1 TINHA 1, V2 TINHA 0, V3
    int vJMD = 2;//V1 TINHA 2, V2 TINHA 2, V3
    int vMME = 1;
    int vMMD = 1;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MaquinaMaoEsquerda = new javax.swing.JButton();
        MaquinaMaoDireita = new javax.swing.JButton();
        JogadorMaoEsquerda = new javax.swing.JButton();
        JogadorMaoDireita = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        MaquinaMaoEsquerda.setText(Integer.toString(vMME));
        MaquinaMaoEsquerda.setEnabled(false);
        MaquinaMaoEsquerda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MaquinaMaoEsquerdaActionPerformed(evt);
            }
        });

        MaquinaMaoDireita.setText(Integer.toString(vMMD));
        MaquinaMaoDireita.setEnabled(false);
        MaquinaMaoDireita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MaquinaMaoDireitaActionPerformed(evt);
            }
        });

        JogadorMaoEsquerda.setText(Integer.toString(vJME));
        JogadorMaoEsquerda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JogadorMaoEsquerdaActionPerformed(evt);
            }
        });

        JogadorMaoDireita.setText(Integer.toString(vJMD));
        JogadorMaoDireita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JogadorMaoDireitaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MaquinaMaoEsquerda)
                    .addComponent(JogadorMaoEsquerda))
                .addGap(75, 75, 75)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JogadorMaoDireita)
                    .addComponent(MaquinaMaoDireita))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MaquinaMaoEsquerda)
                    .addComponent(MaquinaMaoDireita))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 194, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JogadorMaoDireita)
                    .addComponent(JogadorMaoEsquerda))
                .addGap(30, 30, 30))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void JogadorMaoEsquerdaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JogadorMaoEsquerdaActionPerformed

        if (vJMD == 2 && vJME == 0) {
            JogadorMaoEsquerda.setEnabled(true);
            JogadorMaoDireita.setEnabled(true);
            MaquinaMaoEsquerda.setEnabled(false);
            MaquinaMaoDireita.setEnabled(false);
            vJME = 1;
            vJMD = 1;
            JogadorMaoEsquerda.setText(Integer.toString(vJME));
            JogadorMaoDireita.setText(Integer.toString(vJMD));
        } else if (vJMD == 4 && vJME == 0) {
            JogadorMaoEsquerda.setEnabled(true);
            JogadorMaoDireita.setEnabled(true);
            MaquinaMaoEsquerda.setEnabled(false);
            MaquinaMaoDireita.setEnabled(false);
            vJME = 2;
            vJMD = 2;
            JogadorMaoEsquerda.setText(Integer.toString(vJME));
            JogadorMaoDireita.setText(Integer.toString(vJMD));
        } else if (JogadorMaoDireita.isEnabled() == true) {
            JogadorMaoDireita.setEnabled(false);
            if (vMME != 0 && vMME <= 4) {
                MaquinaMaoEsquerda.setEnabled(true);
            } else {
                MaquinaMaoEsquerda.setEnabled(false);
            }
            if (vMMD != 0 && vMMD <= 4) {
                MaquinaMaoDireita.setEnabled(true);
            } else {
                MaquinaMaoDireita.setEnabled(false);
            }
        } else {
            JogadorMaoDireita.setEnabled(true);
            MaquinaMaoEsquerda.setEnabled(false);
            MaquinaMaoDireita.setEnabled(false);
        }
    }//GEN-LAST:event_JogadorMaoEsquerdaActionPerformed

    private void JogadorMaoDireitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JogadorMaoDireitaActionPerformed

        if (vJME == 2 && vJMD == 0) {
            JogadorMaoDireita.setEnabled(true);
            JogadorMaoDireita.setEnabled(true);
            MaquinaMaoEsquerda.setEnabled(false);
            MaquinaMaoDireita.setEnabled(false);
            vJME = 1;
            vJMD = 1;
            JogadorMaoEsquerda.setText(Integer.toString(vJME));
            JogadorMaoDireita.setText(Integer.toString(vJMD));
        } else if (vJME == 4 && vJMD == 0) {
            JogadorMaoDireita.setEnabled(true);
            JogadorMaoDireita.setEnabled(true);
            MaquinaMaoEsquerda.setEnabled(false);
            MaquinaMaoDireita.setEnabled(false);
            vJME = 2;
            vJMD = 2;
            JogadorMaoEsquerda.setText(Integer.toString(vJME));
            JogadorMaoDireita.setText(Integer.toString(vJMD));
        } else if (JogadorMaoEsquerda.isEnabled() == true) {
            JogadorMaoEsquerda.setEnabled(false);
            if (vMME != 0 && vMME <= 4) {
                MaquinaMaoEsquerda.setEnabled(true);
            } else {
                MaquinaMaoEsquerda.setEnabled(false);
            }
            if (vMMD != 0 && vMMD <= 4) {
                MaquinaMaoDireita.setEnabled(true);
            } else {
                MaquinaMaoDireita.setEnabled(false);
            }
        } else {
            JogadorMaoEsquerda.setEnabled(true);
            MaquinaMaoEsquerda.setEnabled(false);
            MaquinaMaoDireita.setEnabled(false);
        }

    }//GEN-LAST:event_JogadorMaoDireitaActionPerformed

    private void MaquinaMaoEsquerdaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MaquinaMaoEsquerdaActionPerformed

        if (vMME != 0) {
            if (vMME <= 4) {
                MaquinaMaoEsquerda.setEnabled(true);
                if (JogadorMaoEsquerda.isEnabled() == true) {
                    vMME = vJME + vMME;
                    MaquinaMaoEsquerda.setText(Integer.toString(vMME));
                    MaquinaMaoEsquerda.setEnabled(false);
                    MaquinaMaoDireita.setEnabled(false);
                    JogadorMaoDireita.setEnabled(true);
                    if (vMME == 5) {
                        vMME = 0;
                        MaquinaMaoEsquerda.setText(Integer.toString(vMME));
                    }
                    if (vMME > 5) {
                        vMME = vMME - 5;
                        MaquinaMaoEsquerda.setText(Integer.toString(vMME));
                    }
                } else {
                    vMME = vJMD + vMME;
                    MaquinaMaoEsquerda.setText(Integer.toString(vMME));
                    MaquinaMaoEsquerda.setEnabled(false);
                    MaquinaMaoDireita.setEnabled(false);
                    JogadorMaoEsquerda.setEnabled(true);
                    if (vMME == 5) {
                        vMME = 0;
                        MaquinaMaoEsquerda.setText(Integer.toString(vMME));
                    }
                    if (vMME > 5) {
                        vMME = vMME - 5;
                        MaquinaMaoEsquerda.setText(Integer.toString(vMME));
                    }
                }
            } else {
                vMME = vMME - 5;
                MaquinaMaoEsquerda.setText(Integer.toString(vMME));
                MaquinaMaoEsquerda.setEnabled(false);
            }
        } else {
            vMME = 0;
            MaquinaMaoEsquerda.setText(Integer.toString(vMME));
            MaquinaMaoEsquerda.setEnabled(false);
        }

    }//GEN-LAST:event_MaquinaMaoEsquerdaActionPerformed

    private void MaquinaMaoDireitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MaquinaMaoDireitaActionPerformed

        if (vMMD != 0) {
            if (vMMD <= 4) {
                MaquinaMaoDireita.setEnabled(true);
                if (JogadorMaoEsquerda.isEnabled() == true) {
                    vMMD = vJME + vMMD;
                    MaquinaMaoDireita.setText(Integer.toString(vMMD));
                    MaquinaMaoEsquerda.setEnabled(false);
                    MaquinaMaoDireita.setEnabled(false);
                    JogadorMaoDireita.setEnabled(true);
                    if (vMMD == 5) {
                        vMMD = 0;
                        MaquinaMaoDireita.setText(Integer.toString(vMMD));
                    }
                    if (vMMD > 5) {
                        vMMD = vMMD - 5;
                        MaquinaMaoDireita.setText(Integer.toString(vMMD));
                    }
                } else {
                    vMMD = vJMD + vMMD;
                    MaquinaMaoDireita.setText(Integer.toString(vMMD));
                    MaquinaMaoEsquerda.setEnabled(false);
                    MaquinaMaoDireita.setEnabled(false);
                    JogadorMaoEsquerda.setEnabled(true);
                    if (vMMD == 5) {
                        vMMD = 0;
                        MaquinaMaoDireita.setText(Integer.toString(vMMD));
                    }
                    if (vMMD > 5) {
                        vMMD = vMMD - 5;
                        MaquinaMaoDireita.setText(Integer.toString(vMMD));
                    }
                }
            } else {
                vMMD = vMMD - 5;
                MaquinaMaoDireita.setText(Integer.toString(vMMD));
                MaquinaMaoDireita.setEnabled(false);
            }
        } else {
            vMMD = 0;
            MaquinaMaoDireita.setText(Integer.toString(vMMD));
            MaquinaMaoDireita.setEnabled(false);
        }
    }//GEN-LAST:event_MaquinaMaoDireitaActionPerformed

    public static void main(String args[]) {
        new SomarCinco().setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JogadorMaoDireita;
    private javax.swing.JButton JogadorMaoEsquerda;
    private javax.swing.JButton MaquinaMaoDireita;
    private javax.swing.JButton MaquinaMaoEsquerda;
    // End of variables declaration//GEN-END:variables

}
