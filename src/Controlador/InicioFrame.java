/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vistas.AcercadeDialog;
import Vistas.PersonaFrame;
import Vistas.PersonasListadoFrm;

/**
 *
 * @author Usuario
 */
public class InicioFrame extends javax.swing.JFrame {

    /**
     * Creates new form InicioFrame
     */
    public InicioFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu4 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jMenu8 = new javax.swing.JMenu();
        jMenu9 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu11 = new javax.swing.JMenu();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu16 = new javax.swing.JMenu();
        jMenu17 = new javax.swing.JMenu();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        SalirMnIt = new javax.swing.JMenuItem();
        AcercadeMnIt = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        creaClientesMnIt = new javax.swing.JMenuItem();
        listClienteMnIt = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu13 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu10 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenu12 = new javax.swing.JMenu();
        jMenu14 = new javax.swing.JMenu();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenu15 = new javax.swing.JMenu();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();

        jMenu4.setText("jMenu4");

        jMenu6.setText("jMenu6");

        jMenu8.setText("jMenu8");

        jMenu9.setText("jMenu9");

        jMenuItem2.setText("jMenuItem2");

        jMenu5.setText("jMenu5");

        jMenu3.setText("jMenu3");

        jMenu11.setText("jMenu11");

        jMenu16.setText("File");
        jMenuBar2.add(jMenu16);

        jMenu17.setText("Edit");
        jMenuBar2.add(jMenu17);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel1.setText("Version 1.0");

        jLabel2.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel2.setText("Gestión de Cuentas");

        jMenu1.setText("Archivo");

        SalirMnIt.setText("Salir");
        SalirMnIt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirMnItActionPerformed(evt);
            }
        });
        jMenu1.add(SalirMnIt);

        AcercadeMnIt.setText("Acerca de ..");
        AcercadeMnIt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AcercadeMnItActionPerformed(evt);
            }
        });
        jMenu1.add(AcercadeMnIt);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Clientes");

        creaClientesMnIt.setText("Crear");
        creaClientesMnIt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                creaClientesMnItActionPerformed(evt);
            }
        });
        jMenu2.add(creaClientesMnIt);

        listClienteMnIt.setText("Listar");
        listClienteMnIt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listClienteMnItActionPerformed(evt);
            }
        });
        jMenu2.add(listClienteMnIt);

        jMenuBar1.add(jMenu2);

        jMenu7.setText("Cuentas");

        jMenuItem4.setText("Crear");
        jMenu7.add(jMenuItem4);

        jMenuItem5.setText("Listar");
        jMenu7.add(jMenuItem5);

        jMenuBar1.add(jMenu7);

        jMenu13.setText("Conceptos");
        jMenu13.setToolTipText("");

        jMenuItem6.setText("Crear");
        jMenu13.add(jMenuItem6);

        jMenuItem7.setText("Listar");
        jMenu13.add(jMenuItem7);

        jMenuBar1.add(jMenu13);

        jMenu10.setText("Transacciones");

        jMenuItem8.setText("Crear");
        jMenu10.add(jMenuItem8);

        jMenuItem9.setText("Listar");
        jMenu10.add(jMenuItem9);

        jMenuBar1.add(jMenu10);

        jMenu12.setText("Reportes");

        jMenu14.setText("Clientes");

        jMenuItem10.setText("Listado");
        jMenu14.add(jMenuItem10);

        jMenu12.add(jMenu14);

        jMenu15.setText("Cuentas");

        jMenuItem11.setText("Extracto");
        jMenu15.add(jMenuItem11);

        jMenuItem12.setText("Transacciones");
        jMenu15.add(jMenuItem12);

        jMenu12.add(jMenu15);

        jMenuBar1.add(jMenu12);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(153, 153, 153)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(164, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(104, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(87, 87, 87)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(145, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(98, 98, 98))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(86, 86, 86)
                    .addComponent(jLabel2)
                    .addContainerGap(157, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SalirMnItActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirMnItActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_SalirMnItActionPerformed

    private void AcercadeMnItActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AcercadeMnItActionPerformed
        // TODO add your handling code here:
        AcercadeDialog acercade = new AcercadeDialog (this, rootPaneCheckingEnabled);
        acercade.setVisible(true);
        
    }//GEN-LAST:event_AcercadeMnItActionPerformed

    private void listClienteMnItActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listClienteMnItActionPerformed
        // TODO add your handling code here:
        PersonasListadoFrm personasListado = new PersonasListadoFrm ();
        personasListado.setVisible(true);
    }//GEN-LAST:event_listClienteMnItActionPerformed

    private void creaClientesMnItActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_creaClientesMnItActionPerformed
        // TODO add your handling code here:
        PersonaFrame personafrm = new PersonaFrame();
        personafrm.setVisible(true);
        
    }//GEN-LAST:event_creaClientesMnItActionPerformed

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
            java.util.logging.Logger.getLogger(InicioFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InicioFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InicioFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InicioFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InicioFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AcercadeMnIt;
    private javax.swing.JMenuItem SalirMnIt;
    private javax.swing.JMenuItem creaClientesMnIt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu11;
    private javax.swing.JMenu jMenu12;
    private javax.swing.JMenu jMenu13;
    private javax.swing.JMenu jMenu14;
    private javax.swing.JMenu jMenu15;
    private javax.swing.JMenu jMenu16;
    private javax.swing.JMenu jMenu17;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JMenuItem listClienteMnIt;
    // End of variables declaration//GEN-END:variables
}