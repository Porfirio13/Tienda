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

/**
 *
 * @author jesuz
 */
public class LoginEncargado extends javax.swing.JFrame {

    /**
     * Creates new form LoginEncargado
     */
    public LoginEncargado() {
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

        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtCorreoE = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtContraseñaE = new javax.swing.JPasswordField();
        BtnIniciarT = new javax.swing.JButton();
        BtnSalir = new javax.swing.JButton();
        BtnRegresarM = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(51, 153, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Chocolateria");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("\"La Guelaguetza\"");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addContainerGap(123, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 80));

        jLabel1.setText("Correo");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 60, -1));

        txtCorreoE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoEActionPerformed(evt);
            }
        });
        getContentPane().add(txtCorreoE, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 140, -1));

        jLabel2.setText("Contraseña");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 70, -1));

        txtContraseñaE.setText("jPasswordField1");
        getContentPane().add(txtContraseñaE, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, 140, -1));

        BtnIniciarT.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BtnIniciarT.setText("Iniciar Sesion");
        BtnIniciarT.setToolTipText("");
        BtnIniciarT.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(51, 153, 255), new java.awt.Color(102, 0, 204)));
        BtnIniciarT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnIniciarTActionPerformed(evt);
            }
        });
        getContentPane().add(BtnIniciarT, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, 90, 30));

        BtnSalir.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BtnSalir.setText("Salir");
        BtnSalir.setToolTipText("");
        BtnSalir.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(51, 153, 255), new java.awt.Color(102, 0, 204)));
        BtnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(BtnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 280, 90, 30));

        BtnRegresarM.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BtnRegresarM.setText("Regresar");
        BtnRegresarM.setToolTipText("");
        BtnRegresarM.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(51, 153, 255), new java.awt.Color(102, 0, 204)));
        BtnRegresarM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRegresarMActionPerformed(evt);
            }
        });
        getContentPane().add(BtnRegresarM, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 240, 90, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCorreoEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoEActionPerformed

    private void BtnIniciarTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnIniciarTActionPerformed
        String correoE=txtCorreoE.getText();
        String contraseñaE= new String(txtContraseñaE.getPassword());
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/guelaguetza", "root", "12345678")) {
            String sql="SELECT * FROM datos_encargado Where CorreoE=? AND ContrasenaE = ?";
            PreparedStatement ts = con.prepareStatement(sql);
            ts.setString(1,correoE);
            ts.setString(2,contraseñaE);
            ResultSet rs = ts.executeQuery();
            if (rs.next()) {
                // Si las credenciales son correctas, mostrar mensaje de bienvenida y redirigir al menú
                JOptionPane.showMessageDialog(this, "¡Bienvenido, " + rs.getString("nombre") + "!");
                MenuEncargado menuE = new MenuEncargado(); // Asegúrate de tener este JFrame creado
                menuE.setVisible(true);
                this.dispose(); // Cierra la ventana de login
            } else {
                // Mostrar mensaje de error si las credenciales son incorrectas
                JOptionPane.showMessageDialog(this, "correo o contraseña incorrectos");
            }
        } catch (SQLException ex) {
            // Manejo de errores en la conexión con la base de datos
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al conectar a la base de datos");
        }
    }//GEN-LAST:event_BtnIniciarTActionPerformed

    private void BtnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSalirActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_BtnSalirActionPerformed

    private void BtnRegresarMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRegresarMActionPerformed
        // TODO add your handling code here:
        MenuGeneral regresar=new MenuGeneral();
        regresar.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_BtnRegresarMActionPerformed

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
            java.util.logging.Logger.getLogger(LoginEncargado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginEncargado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginEncargado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginEncargado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginEncargado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnIniciarT;
    private javax.swing.JButton BtnRegresarM;
    private javax.swing.JButton BtnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField txtContraseñaE;
    private javax.swing.JTextField txtCorreoE;
    // End of variables declaration//GEN-END:variables
}
