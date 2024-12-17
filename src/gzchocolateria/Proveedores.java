/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gzchocolateria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author jesuz
 */
public class Proveedores extends javax.swing.JFrame {

    /**
     * Creates new form Proveedores
     */
    public Proveedores() {
        initComponents();
    }
    private void guardarProvedor(){
        String Id_proveedor =txtIdProveedor.getText();
        String nombre_proveedor =txtNombreProveedor.getText();
        String categoria  =txtCategoria.getText();
        String direccion_proveedor =txtDireccion.getText();
        String descripcion =txtDescripcionP.getText();
     
        if (nombre_proveedor.isEmpty() || categoria.isEmpty() || direccion_proveedor.isEmpty() || descripcion.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Por favor, completa todos los campos obligatorios.");
        return;
    }
        try (Connection conn = dbConnection.getConnection()) {
            String sql = "INSERT INTO proveedor (Id_proveedor, nombre_proveedor, categoria, direccion_proveedoor, descripcion_proveedor) "
               + "VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement as = conn.prepareStatement(sql)) {
        as.setString(1, Id_proveedor);
        as.setString(2, nombre_proveedor);
        as.setString(3, categoria);
        as.setString(4, direccion_proveedor);
        as.setString(5, descripcion); 
          int rowsAffected = as.executeUpdate();
        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(this, "Producto registrado exitosamente.");
        } else {
            JOptionPane.showMessageDialog(this, "Error al registrar producto.");
        }
    }
} catch (SQLException e) {
    JOptionPane.showMessageDialog(this, "Error de conexión a la base de datos: " + e.getMessage());

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

        jPanel1 = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lblNombreP = new javax.swing.JLabel();
        lblCantidad = new javax.swing.JLabel();
        lblDescripcionP = new javax.swing.JLabel();
        lblPrecioU1 = new javax.swing.JLabel();
        lblIdP = new javax.swing.JLabel();
        txtCategoria = new javax.swing.JTextField();
        lblTitulo = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        txtDescripcionP = new javax.swing.JTextField();
        txtNombreProveedor = new javax.swing.JTextField();
        btnMenuE = new javax.swing.JButton();
        txtIdProveedor = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(153, 255, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 200, -1, -1));

        jPanel2.setBackground(new java.awt.Color(51, 102, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNombreP.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblNombreP.setText("Nombre");
        jPanel2.add(lblNombreP, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 60, -1));

        lblCantidad.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCantidad.setText("Categoria");
        jPanel2.add(lblCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        lblDescripcionP.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblDescripcionP.setText("Descripcion");
        jPanel2.add(lblDescripcionP, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));

        lblPrecioU1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblPrecioU1.setText("Direccion");
        jPanel2.add(lblPrecioU1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        lblIdP.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblIdP.setText("Id_proveedor");
        jPanel2.add(lblIdP, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, 230));
        jPanel1.add(txtCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 270, -1));

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTitulo.setText("Creacion de proveedor");
        jPanel1.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, -1, -1));
        jPanel1.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 270, -1));

        txtDescripcionP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescripcionPActionPerformed(evt);
            }
        });
        jPanel1.add(txtDescripcionP, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, 270, 20));
        jPanel1.add(txtNombreProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 270, -1));

        btnMenuE.setText("Menu");
        btnMenuE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuEActionPerformed(evt);
            }
        });
        jPanel1.add(btnMenuE, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, -1, -1));

        txtIdProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdProveedorActionPerformed(evt);
            }
        });
        jPanel1.add(txtIdProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 270, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 394, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        guardarProvedor();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtDescripcionPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescripcionPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescripcionPActionPerformed

    private void btnMenuEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuEActionPerformed
        // TODO add your handling code here:
        dispose();
        MenuEncargado menuEncargado = new MenuEncargado();
        menuEncargado.setVisible(true);
        menuEncargado.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnMenuEActionPerformed

    private void txtIdProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdProveedorActionPerformed

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
            java.util.logging.Logger.getLogger(Proveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Proveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Proveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Proveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Proveedores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnMenuE;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblCantidad;
    private javax.swing.JLabel lblDescripcionP;
    private javax.swing.JLabel lblIdP;
    private javax.swing.JLabel lblNombreP;
    private javax.swing.JLabel lblPrecioU1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtCategoria;
    private javax.swing.JTextField txtDescripcionP;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtIdProveedor;
    private javax.swing.JTextField txtNombreProveedor;
    // End of variables declaration//GEN-END:variables
}