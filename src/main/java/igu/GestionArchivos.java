
package igu;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import model.Archivo;
import persistence.ArchivoDAO;
import persistence.Conexion;
import persistence.ControlDisciplinarioDAO;

/**
 *
 * @author 52551
 */
public class GestionArchivos extends javax.swing.JFrame {

    public GestionArchivos() {
        initComponents();
        this.setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tabbeds = new javax.swing.JTabbedPane();
        panelCertificados = new javax.swing.JTabbedPane();
        panelEventos = new javax.swing.JTabbedPane();
        panelOtros = new javax.swing.JTabbedPane();
        btnSubirArchivo = new javax.swing.JButton();
        btnRevocarArchivos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(201, 162, 39));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("STXihei", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 249, 255));
        jLabel1.setText("Gestión de Archivos");

        tabbeds.setBackground(new java.awt.Color(255, 255, 255));
        tabbeds.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        panelCertificados.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tabbeds.addTab("Certificados", panelCertificados);

        panelEventos.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tabbeds.addTab("Eventos", panelEventos);

        panelOtros.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tabbeds.addTab("Otros", panelOtros);

        btnSubirArchivo.setBackground(new java.awt.Color(113, 97, 239));
        btnSubirArchivo.setFont(new java.awt.Font("STXihei", 1, 18)); // NOI18N
        btnSubirArchivo.setForeground(new java.awt.Color(221, 221, 221));
        btnSubirArchivo.setText("Subir archivo");
        btnSubirArchivo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSubirArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubirArchivoActionPerformed(evt);
            }
        });

        btnRevocarArchivos.setBackground(new java.awt.Color(239, 35, 60));
        btnRevocarArchivos.setFont(new java.awt.Font("STXihei", 1, 18)); // NOI18N
        btnRevocarArchivos.setForeground(new java.awt.Color(0, 0, 17));
        btnRevocarArchivos.setText("Revocar archivo");
        btnRevocarArchivos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRevocarArchivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRevocarArchivosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(312, 312, 312)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(tabbeds, javax.swing.GroupLayout.PREFERRED_SIZE, 664, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(316, 316, 316)
                        .addComponent(btnSubirArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(146, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnRevocarArchivos, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(341, 341, 341))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(90, 90, 90)
                .addComponent(tabbeds, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSubirArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRevocarArchivos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSubirArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubirArchivoActionPerformed
        JFileChooser fileChooser = new JFileChooser();
    fileChooser.setFileFilter(new FileNameExtensionFilter("Archivos PDF", "pdf"));

    int resultado = fileChooser.showOpenDialog(this);
    if (resultado == JFileChooser.APPROVE_OPTION) {
        File archivoSeleccionado = fileChooser.getSelectedFile();
        String tipoArchivo = (String) JOptionPane.showInputDialog(
            this,
            "Seleccione el tipo de archivo:",
            "Tipo de Archivo",
            JOptionPane.QUESTION_MESSAGE,
            null,
            new String[]{"Certificados", "Eventos", "Otros"},
            "Certificados"
        );

        if (tipoArchivo != null) {
            try {
                Archivo archivo = new Archivo();
                archivo.setNombreArchivo(archivoSeleccionado.getName());
                archivo.setRutaArchivo(archivoSeleccionado.getAbsolutePath());
                archivo.setTipoArchivo(Archivo.TipoArchivo.valueOf(tipoArchivo));

                ArchivoDAO archivoDAO = new ArchivoDAO(Conexion.getConexion());
                if (archivoDAO.subirArchivo(archivo)) {
                    JLabel label = new JLabel(archivo.getNombreArchivo());

                    switch (archivo.getTipoArchivo()) {
                        case Certificados -> panelCertificados.add(label);
                        case Eventos -> panelEventos.add(label);
                        case Otros -> panelOtros.add(label);
                    }
                    panelCertificados.revalidate();
                    panelEventos.revalidate();
                    panelOtros.revalidate();

                    JOptionPane.showMessageDialog(this, "Archivo subido correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Error al subir archivo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        }
    }//GEN-LAST:event_btnSubirArchivoActionPerformed

    private void btnRevocarArchivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRevocarArchivosActionPerformed
        try {
        ArchivoDAO archivoDAO = new ArchivoDAO(Conexion.getConexion());
        String tipoSeleccionado = "Certificados";
        List<Archivo> archivos = archivoDAO.listarArchivos(tipoSeleccionado);

        if (archivos.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No existen archivos activos en: " + tipoSeleccionado, "Información", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        String[] opciones = archivos.stream().map(Archivo::getNombreArchivo).toArray(String[]::new);
        String archivoSeleccionado = (String) JOptionPane.showInputDialog(
            this,
            "Seleccione el archivo a revocar:",
            "Revocar Archivo - " + tipoSeleccionado,
            JOptionPane.QUESTION_MESSAGE,
            null,
            opciones,
            opciones[0]
        );

        if (archivoSeleccionado != null) {
            archivos.stream()
                .filter(a -> a.getNombreArchivo().equals(archivoSeleccionado))
                .findFirst()
                .ifPresent(archivo -> {
                    if (archivoDAO.revocarArchivo(archivo.getId())) {
                        JOptionPane.showMessageDialog(this, "Archivo '" + archivoSeleccionado + "' revocado", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(this, "Error al revocar el archivo", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                });
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error en el proceso: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
    }
    }//GEN-LAST:event_btnRevocarArchivosActionPerformed

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
            java.util.logging.Logger.getLogger(GestionArchivos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionArchivos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionArchivos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionArchivos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionArchivos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRevocarArchivos;
    private javax.swing.JButton btnSubirArchivo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTabbedPane panelCertificados;
    private javax.swing.JTabbedPane panelEventos;
    private javax.swing.JTabbedPane panelOtros;
    private javax.swing.JTabbedPane tabbeds;
    // End of variables declaration//GEN-END:variables
}
