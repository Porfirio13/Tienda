/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gzchocolateria;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import javax.swing.JOptionPane;
/**
 *
 * @author jesuz
 */
public class DesempeñoT extends javax.swing.JFrame {

   
  
    /**
     * Creates new form DesempeñoT
     */
    public DesempeñoT() {
        initComponents();    
        cargarTrabajadores();
    }
    private void cargarTrabajadores() {
        String query = "SELECT Nombre FROM datos_trabajador";
        Connection connection = null;
       try (Connection conn = dbConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(query);
         ResultSet rs = stmt.executeQuery()) {
          

            while (rs.next()) {
                CmbTrabajador.addItem(rs.getString("Nombre")); // Añadir los nombres al ComboBox
            }
        } catch (Exception ex) {
            System.err.println("Error al cargar los trabajadores: " + ex.getMessage());
        }
    }
    private void guardarComoPDF() {
        try {
            String empleado = (String) CmbTrabajador.getSelectedItem(); // Obtener el nombre del empleado
            String observaciones = txtObservaciones.getText(); // Obtener las observaciones
            int estrellas = calestrella1.getRating(); // Obtener el rating (debe estar implementado en tu componente)
            int calificacion = estrellas * 2; // Calcular la calificación (2 puntos por estrella)

            // Crear el PDF
            Document document = new Document();
            String filename = "Evaluacion_" + empleado + ".pdf";
            PdfWriter.getInstance(document, new FileOutputStream(filename));
            document.open();
            document.add(new Paragraph("Evaluación de Desempeño"));
            document.add(new Paragraph("Empleado: " + empleado));
            document.add(new Paragraph("Observaciones: " + observaciones));
            document.add(new Paragraph("Calificación: " + calificacion + "/10"));
            document.close();

            JOptionPane.showMessageDialog(this, "PDF guardado exitosamente: " + filename);
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al guardar el PDF.");
        }
    }
    private void enviarPDF() {
        // Configuración del servidor SMTP
        String host = "smtp.gmail.com";
        String correoRemitente = "jesuz.cl@gmail.com";
        String clave = "130901"; // Sustituye por tu clave de aplicación de Gmail
        String correoDestinatario = "yoas4099@gmail.com"; // Cambia al correo del destinatario

        // Configurar las propiedades del servidor
        Properties properties = System.getProperties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "587"); // Puerto TLS
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true"); // Habilitar STARTTLS

        // Crear sesión con autenticación
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(correoRemitente, clave);
            }
        });

        try {
            // Crear el mensaje
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(correoRemitente));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(correoDestinatario));
            message.setSubject("Evaluación de Desempeño");
            message.setText("Adjunto se encuentra el PDF de la evaluación de desempeño.");

            // Adjuntar archivo
            String filename = "Evaluacion_Empleado.pdf"; // Cambia por el nombre de tu archivo PDF
            MimeBodyPart attachmentPart = new MimeBodyPart();
            attachmentPart.setDataHandler(new DataHandler(new FileDataSource(filename)));
            attachmentPart.setFileName(filename);

            MimeMultipart multipart = new MimeMultipart();
            multipart.addBodyPart(attachmentPart);
            message.setContent(multipart);

            // Enviar el correo
            Transport.send(message);
            System.out.println("Correo enviado exitosamente.");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        
    }};
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        calestrella1 = new CalEstrellaopaque.Calestrella();
        CmbTrabajador = new javax.swing.JComboBox<>();
        lblTrabajador = new javax.swing.JLabel();
        btnGuardarPDF = new javax.swing.JButton();
        btnEnviarPDF = new javax.swing.JButton();
        txtObservaciones = new javax.swing.JTextField();
        lblObservacion = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(calestrella1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 155, -1));

        jPanel1.add(CmbTrabajador, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 110, 30));

        lblTrabajador.setText("Trabajador");
        jPanel1.add(lblTrabajador, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 70, 30));

        btnGuardarPDF.setText("Guardar PDF");
        btnGuardarPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarPDFActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardarPDF, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, -1, -1));

        btnEnviarPDF.setText("Enviar PDF");
        btnEnviarPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarPDFActionPerformed(evt);
            }
        });
        jPanel1.add(btnEnviarPDF, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 220, -1, -1));
        jPanel1.add(txtObservaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 150, -1));

        lblObservacion.setText("Observacion");
        jPanel1.add(lblObservacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        jPanel2.setBackground(new java.awt.Color(102, 153, 255));

        jLabel1.setText("DesempeñoT");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(117, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 320, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEnviarPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarPDFActionPerformed
    }//GEN-LAST:event_btnEnviarPDFActionPerformed

    private void btnGuardarPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarPDFActionPerformed
    }//GEN-LAST:event_btnGuardarPDFActionPerformed
public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new DesempeñoT().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CmbTrabajador;
    private javax.swing.JButton btnEnviarPDF;
    private javax.swing.JButton btnGuardarPDF;
    private CalEstrellaopaque.Calestrella calestrella1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblObservacion;
    private javax.swing.JLabel lblTrabajador;
    private javax.swing.JTextField txtObservaciones;
    // End of variables declaration//GEN-END:variables
}
