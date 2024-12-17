/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gzchocolateria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author jesuz
 */
public class VentaT extends javax.swing.JFrame {

    /**
     * Creates new form VentaT
     */
    public VentaT() {
        initComponents();
        cargarProductos();
    }
    private void registrarVentaEnBD(String idProducto, int cantidad, double total) {
    try (Connection conn = dbConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(
             "INSERT INTO ventas (id_producto, cantidad, total) VALUES (?, ?, ?)")) {
        stmt.setString(1, idProducto);
        stmt.setInt(2, cantidad);
        stmt.setDouble(3, total);
        stmt.executeUpdate();
        JOptionPane.showMessageDialog(this, "Venta registrada con éxito en la base de datos.");
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error al registrar la venta: " + e.getMessage());
    }
}
//------------------------------------------------------------------------------------------------------
    private void btnAgregarCarritoActionPerformed(java.awt.event.ActionEvent evt) 
    {                                               
    // Capturar el producto seleccionado del ComboBox
    String productoSeleccionado = (String) cmbProducto.getSelectedItem();
    if (productoSeleccionado == null || productoSeleccionado.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Por favor, selecciona un producto.");
        return;
    }

    // Definir cantidad y precio unitario para el ejemplo
    int cantidad = 1; // Puedes añadir un campo para modificar esta cantidad
    double precioUnitario = obtenerPrecioProducto(productoSeleccionado); // Método para obtener el precio
    double total = cantidad * precioUnitario;

    // Añadir los datos a la tabla
    DefaultTableModel model = (DefaultTableModel) TablaVenta.getModel();
    model.addRow(new Object[]{productoSeleccionado, cantidad, precioUnitario, total});
}
//-----------------------------------------------------------------------------------------------------    
    private void procesarVentaCompleta() {
    DefaultTableModel model = (DefaultTableModel) TablaVenta.getModel();
    int rows = model.getRowCount();

    try (Connection conn = dbConnection.getConnection()) {
        String cadenaCantidad = txtCantidad.getText();
        for (int i = 0; i < rows; i++) {
            String idventa=model.getValueAt(i, 1).toString();
            String idProducto = model.getValueAt(i, 2).toString();
            int cantidad = (int) Double.parseDouble(cadenaCantidad);       

            double Total = Double.parseDouble(model.getValueAt(i, 4).toString());
            
            PreparedStatement stmt = conn.prepareStatement(
                "INSERT INTO detalle_venta (Id_producto, cantidad, total) VALUES (?, ?, ?)");
            stmt.setString(1, idventa);
            stmt.setString(2, idProducto);
            stmt.setInt(3, cantidad);
            stmt.setDouble(4, Total);
            stmt.executeUpdate();
        }
        JOptionPane.showMessageDialog(this, "Venta procesada con éxito.");
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error al procesar la venta: " + e.getMessage());
    }
}
    
// Método para obtener el precio del producto desde la base de datos
private double obtenerPrecioProducto(String nombreProducto) {
    double precio = 0.0;
    try (Connection conn = dbConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement("SELECT precio FROM inventario WHERE nombre_producto = ?")) {
        stmt.setString(1, nombreProducto);
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                precio = rs.getDouble("precio");
            }
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error al obtener el precio del producto: " + e.getMessage());
    }
    return precio;
}


    private void cargarProductos() {
    try (Connection conn = dbConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement("SELECT nombre_producto FROM inventario");
         ResultSet rs = stmt.executeQuery()) {

        cmbProducto.removeAllItems(); // Limpiar ComboBox
        while (rs.next()) {
            cmbProducto.addItem(rs.getString("nombre_producto")); // Agregar cada producto al ComboBox
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error al cargar productos: " + e.getMessage());
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

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmbProducto = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaVenta = new javax.swing.JTable();
        BtnAgregarCarrito = new javax.swing.JButton();
        HorarioF = new com.toedter.calendar.JDateChooser();
        btnSalir = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        BtnRegistrar = new javax.swing.JButton();
        lblCantidad = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 153, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Chocolateria");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("\"La Guelaguetza\"");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addContainerGap(871, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1050, -1));

        jPanel2.add(cmbProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, 90, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Producto");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 90, 20));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Realizar venta");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, 14));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Venta");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 90, 170, 20));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Dia");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 30, 14));

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 6, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 356, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, 10, 360));

        TablaVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id_venta", "Id_producto", "cantidad", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TablaVenta);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, 580, 240));

        BtnAgregarCarrito.setText("Agregar");
        BtnAgregarCarrito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAgregarCarritoActionPerformed(evt);
            }
        });
        jPanel2.add(BtnAgregarCarrito, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, -1, -1));
        jPanel2.add(HorarioF, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 100, -1));

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel2.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 380, -1, -1));

        jButton2.setText("Regresar");
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 380, -1, -1));

        BtnRegistrar.setText("Registrar");
        BtnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRegistrarActionPerformed(evt);
            }
        });
        jPanel2.add(BtnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 380, -1, -1));

        lblCantidad.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCantidad.setText("Cantidad");
        jPanel2.add(lblCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));
        jPanel2.add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 210, 90, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void BtnAgregarCarritoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAgregarCarritoActionPerformed
        // TODO add your handling code here:
        // Recupera el producto seleccionado
    String productoSeleccionado = (String) cmbProducto.getSelectedItem();

    // Cantidad y precio ficticios (puedes modificarlos para incluir campos de entrada)
    int cantidad = 1; // Puedes agregar un JTextField para ingresar cantidad
    double precioUnitario = obtenerPrecioProducto(productoSeleccionado); // Implementa esta función
    double total = cantidad * precioUnitario;

    // Obtén el modelo de la tabla
    DefaultTableModel model = (DefaultTableModel) TablaVenta.getModel();

    // Agrega una nueva fila a la tabla
    model.addRow(new Object[] {null, productoSeleccionado, cantidad, total});
    }//GEN-LAST:event_BtnAgregarCarritoActionPerformed

    private void BtnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRegistrarActionPerformed
        // TODO add your handling code here: 
         procesarVentaCompleta();

    }//GEN-LAST:event_BtnRegistrarActionPerformed

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
            java.util.logging.Logger.getLogger(VentaT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentaT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentaT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentaT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentaT().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAgregarCarrito;
    private javax.swing.JButton BtnRegistrar;
    private com.toedter.calendar.JDateChooser HorarioF;
    private javax.swing.JTable TablaVenta;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cmbProducto;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCantidad;
    private javax.swing.JTextField txtCantidad;
    // End of variables declaration//GEN-END:variables
}
