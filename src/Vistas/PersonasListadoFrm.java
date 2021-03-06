package Vistas;

import Modelo.Persona;
import ModeloDAO.PersonaDAO;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Usuario
 */
public class PersonasListadoFrm extends javax.swing.JFrame {

    /**
     * Creates new form PersonasListadoFrm
     */
    //Objeto que se va a enviar la forma de edición
    public static Persona perEditar;
    //Variable para indicar a la forma de Personas que es para Edicion
    public static boolean edicion=false;
    
    public PersonasListadoFrm() {
        initComponents();
         //Para que la forma salga en el centro
        this.setLocationRelativeTo(null);
        DefaultTableModel modelo=(DefaultTableModel) clientesTbl.getModel();
        modelo.setRowCount(0);
        PersonaDAO perDAO = new PersonaDAO();
        List<Persona> list = perDAO.listarPersonas();
        Collections.sort(list);
        Iterator<Persona> iter = list.iterator();
        Persona per = null;
        while (iter.hasNext()) {
            per = iter.next();
            Object filaNueva[] = {per.getId(),per.getTipoid(),per.getNombre(),per.getEmail()};
            modelo.addRow(filaNueva);
            
        }
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        clientesTbl = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        generaClBtn = new javax.swing.JButton();
        salirBtn = new javax.swing.JButton();
        EditClienteBtn = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        clientesTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Identificación", "Tipo ID", "Nombre", "Email"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        clientesTbl.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        clientesTbl.setColumnSelectionAllowed(true);
        clientesTbl.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(clientesTbl);
        clientesTbl.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Listado de Clientes");

        generaClBtn.setText("Generar");
        generaClBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generaClBtnActionPerformed(evt);
            }
        });

        salirBtn.setText("Cerrar");
        salirBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirBtnActionPerformed(evt);
            }
        });

        EditClienteBtn.setText("Editar");
        EditClienteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditClienteBtnActionPerformed(evt);
            }
        });

        jButton2.setText("Eliminar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(generaClBtn)
                .addGap(63, 63, 63)
                .addComponent(EditClienteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(salirBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(199, 199, 199)
                        .addComponent(jLabel1)))
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(generaClBtn)
                    .addComponent(salirBtn)
                    .addComponent(EditClienteBtn)
                    .addComponent(jButton2))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void generaClBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generaClBtnActionPerformed
        // TODO add your handling code here:
        DefaultTableModel modelo=(DefaultTableModel) clientesTbl.getModel();
        modelo.setRowCount(0);
        PersonaDAO perDAO = new PersonaDAO();
        List<Persona> list = perDAO.listarPersonas();
        Collections.sort(list);
        Iterator<Persona> iter = list.iterator();
        Persona per = null;
        while (iter.hasNext()) {
            per = iter.next();
            Object filaNueva[] = {per.getId(),per.getTipoid(),per.getNombre(),per.getEmail()};
            modelo.addRow(filaNueva);
            
        }
               
    }//GEN-LAST:event_generaClBtnActionPerformed

    private void salirBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirBtnActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_salirBtnActionPerformed

    private void EditClienteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditClienteBtnActionPerformed
        // TODO add your handling code here:
        DefaultTableModel modelo=(DefaultTableModel) clientesTbl.getModel();
        int fila = clientesTbl.getSelectedRow();
        int id=(int) modelo.getValueAt(fila,0);
        String tipoId=(String) modelo.getValueAt(fila,1);
        String nombre=(String) modelo.getValueAt(fila,2);
        String email=(String) modelo.getValueAt(fila,3);
        perEditar=new Persona(id,tipoId,nombre,email);
        edicion=true;
        PersonaFrame personaEdFrm= new PersonaFrame();
        personaEdFrm.setVisible(true);
        this.setVisible(false);       
        //System.out.println(perEditar.toString());
    }//GEN-LAST:event_EditClienteBtnActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(PersonasListadoFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PersonasListadoFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PersonasListadoFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PersonasListadoFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PersonasListadoFrm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton EditClienteBtn;
    private javax.swing.JTable clientesTbl;
    private javax.swing.JButton generaClBtn;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton salirBtn;
    // End of variables declaration//GEN-END:variables
}
