/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package computerlabsystem;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author araos
 */
public class MainFrame extends javax.swing.JFrame {

    public MainFrame() {
        initComponents();
        Transparent();
        LoginPanel login = new LoginPanel();
        SignUpPanel signUp = new SignUpPanel();
        mainSlide.setAnimate(20);
        mainSlide.init(login, signUp);
        login.addEventRegister(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                //  Show register form
                mainSlide.show(1);
            }
        });
        signUp.addEventBackLogin(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                mainSlide.show(0);
            }
        });
    }

    public void closeMain() {
        dispose();
    }

    public void Transparent(){
    mainBorder.setBackground(new Color(255,255,255,200));
    mainSlide.setBackground(new Color(255,255,255,200));
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelGradient1 = new computerlabsystem.Design.PanelGradient();
        mainBorder = new computerlabsystem.Design.PanelBorder();
        mainSlide = new computerlabsystem.Design.PanelSlide();
        logo = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelGradient1.setColorPrimary(new java.awt.Color(109, 113, 249));
        panelGradient1.setColorSecondary(new java.awt.Color(244, 193, 109));

        mainBorder.setBackground(new java.awt.Color(204, 255, 204));

        mainSlide.setBackground(new java.awt.Color(255, 255, 255));
        mainSlide.setOpaque(false);

        javax.swing.GroupLayout mainSlideLayout = new javax.swing.GroupLayout(mainSlide);
        mainSlide.setLayout(mainSlideLayout);
        mainSlideLayout.setHorizontalGroup(
            mainSlideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
        );
        mainSlideLayout.setVerticalGroup(
            mainSlideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 544, Short.MAX_VALUE)
        );

        mainBorder.setLayer(mainSlide, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout mainBorderLayout = new javax.swing.GroupLayout(mainBorder);
        mainBorder.setLayout(mainBorderLayout);
        mainBorderLayout.setHorizontalGroup(
            mainBorderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainSlide, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        mainBorderLayout.setVerticalGroup(
            mainBorderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainBorderLayout.createSequentialGroup()
                .addComponent(mainSlide, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelGradient1.add(mainBorder);
        mainBorder.setBounds(180, 70, 480, 550);

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logo.png"))); // NOI18N
        panelGradient1.add(logo);
        logo.setBounds(640, -20, 210, 210);

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/bgImage.jpg"))); // NOI18N
        panelGradient1.add(background);
        background.setBounds(-300, 0, 1180, 700);

        getContentPane().add(panelGradient1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 856, 684));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JLabel logo;
    private computerlabsystem.Design.PanelBorder mainBorder;
    private computerlabsystem.Design.PanelSlide mainSlide;
    private computerlabsystem.Design.PanelGradient panelGradient1;
    // End of variables declaration//GEN-END:variables
}
