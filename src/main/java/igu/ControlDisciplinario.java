
package igu;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.ControlDisciplinarioThis;
import persistence.Conexion;
import persistence.ControlDisciplinarioDAO;

/**
 *
 * @author 52551
 */
public class ControlDisciplinario extends javax.swing.JFrame {

    private final ControlDisciplinarioDAO dao;
    private Map<Integer, String> estudiantesMap;
    private Map<Integer, String> instructoresMap;
    private Map<Integer, String> tiposFaltaMap;
    private Map<Integer, String> sancionesMap;
    
    public ControlDisciplinario() throws SQLException {
        initComponents();
        this.setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        dao = new ControlDisciplinarioDAO(Conexion.getConexion());
        cargarCombos();
    }

    private void cargarCombos() {
        estudiantesMap = dao.obtenerEstudiantes();
        DefaultComboBoxModel<String> modeloEstudiantes = new DefaultComboBoxModel<>();
        estudiantesMap.values().forEach(modeloEstudiantes::addElement);
        cmbEstudianteEspacio.setModel(modeloEstudiantes);

        instructoresMap = dao.obtenerInstructores();
        DefaultComboBoxModel<String> modeloInstructores = new DefaultComboBoxModel<>();
        instructoresMap.values().forEach(modeloInstructores::addElement);
        cmbResponsableEspacio.setModel(modeloInstructores);

        tiposFaltaMap = dao.obtenerTiposFalta();
        DefaultComboBoxModel<String> modeloFaltas = new DefaultComboBoxModel<>();
        tiposFaltaMap.values().forEach(modeloFaltas::addElement);
        cmbTipoFalta.setModel(modeloFaltas);

        sancionesMap = dao.obtenerSanciones();
        DefaultComboBoxModel<String> modeloSanciones = new DefaultComboBoxModel<>();
        sancionesMap.values().forEach(modeloSanciones::addElement);
        cmbSancion.setModel(modeloSanciones);
    }

    private void cmbEstudianteEspacioActionPerformed(java.awt.event.ActionEvent evt) {                                                     
        if (cmbEstudianteEspacio.getSelectedItem() != null) {
            String nombreEstudiante = (String) cmbEstudianteEspacio.getSelectedItem();
            int idEstudiante = obtenerIdPorNombre(estudiantesMap, nombreEstudiante);
            
            int faltas = dao.obtenerFaltasAcumuladas(idEstudiante);
            txtFaltasAcum.setText(String.valueOf(faltas));
        }
    }                                                    

    private int obtenerIdPorNombre(Map<Integer, String> mapa, String nombre) {
        for (Map.Entry<Integer, String> entry : mapa.entrySet()) {
            if (entry.getValue().equals(nombre)) {
                return entry.getKey();
            }
        }
        return -1;
    }

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {                                          
        if (cmbEstudianteEspacio.getSelectedItem() == null ||
            cmbResponsableEspacio.getSelectedItem() == null ||
            cmbTipoFalta.getSelectedItem() == null ||
            cmbSancion.getSelectedItem() == null ||
            dteFechaEspacio.getDate() == null) {
            
            JOptionPane.showMessageDialog(this, 
                "Complete todos los campos obligatorios", 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
            return;
        }

        ControlDisciplinarioThis control = new ControlDisciplinarioThis();
        control.setIdEstudiante(obtenerIdPorNombre(estudiantesMap, (String) cmbEstudianteEspacio.getSelectedItem()));
        control.setFecha(dteFechaEspacio.getDate());
        control.setIdResponsable(obtenerIdPorNombre(instructoresMap, (String) cmbResponsableEspacio.getSelectedItem()));
        control.setIdTipoFalta(obtenerIdPorNombre(tiposFaltaMap, (String) cmbTipoFalta.getSelectedItem()));
        control.setIdSancion(obtenerIdPorNombre(sancionesMap, (String) cmbSancion.getSelectedItem()));
        control.setFaltasAcumuladas(Integer.parseInt(txtFaltasAcum.getText()));
        control.setObservaciones(txtObservacionesEspacios.getText());

        if (dao.guardar(control)) {
            limpiarFormulario();
        }
    }                                         

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {                                           
        this.dispose();
    }                                          

    private void limpiarFormulario() {
        cmbEstudianteEspacio.setSelectedIndex(-1);
        cmbResponsableEspacio.setSelectedIndex(-1);
        cmbTipoFalta.setSelectedIndex(-1);
        cmbSancion.setSelectedIndex(-1);
        txtFaltasAcum.setText("0");
        txtObservacionesEspacios.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        cmbEstudianteEspacio = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        dteFechaEspacio = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        cmbResponsableEspacio = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        cmbTipoFalta = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        cmbSancion = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        txtFaltasAcum = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtObservacionesEspacios = new javax.swing.JTextArea();
        btnCancelarGestion = new javax.swing.JButton();
        btnGuardarGestion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(201, 162, 39));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("STXihei", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(73, 80, 87));
        jLabel1.setText("Control Disciplinario");

        jPanel2.setBackground(new java.awt.Color(201, 162, 39));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del estudiante"));

        jLabel5.setFont(new java.awt.Font("STXihei", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(73, 80, 87));
        jLabel5.setText("Fecha");

        cmbEstudianteEspacio.setFont(new java.awt.Font("STXihei", 0, 12)); // NOI18N

        jLabel6.setFont(new java.awt.Font("STXihei", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(73, 80, 87));
        jLabel6.setText("Estudiante");

        jLabel7.setFont(new java.awt.Font("STXihei", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(73, 80, 87));
        jLabel7.setText("Responsable");

        cmbResponsableEspacio.setFont(new java.awt.Font("STXihei", 0, 12)); // NOI18N

        jLabel8.setFont(new java.awt.Font("STXihei", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(73, 80, 87));
        jLabel8.setText("Tipo de falta");

        cmbTipoFalta.setFont(new java.awt.Font("STXihei", 0, 12)); // NOI18N

        jLabel9.setFont(new java.awt.Font("STXihei", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(73, 80, 87));
        jLabel9.setText("Sanción aplicada");

        cmbSancion.setFont(new java.awt.Font("STXihei", 0, 12)); // NOI18N

        jLabel10.setFont(new java.awt.Font("STXihei", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(73, 80, 87));
        jLabel10.setText("Núm de faltas acumuladas");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(76, 76, 76)
                        .addComponent(jLabel10))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(cmbSancion, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtFaltasAcum, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(cmbEstudianteEspacio, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(47, 47, 47)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(dteFechaEspacio, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(61, 61, 61)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(cmbResponsableEspacio, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(cmbTipoFalta, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cmbEstudianteEspacio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dteFechaEspacio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbSancion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFaltasAcum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbResponsableEspacio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbTipoFalta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("STXihei", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(73, 80, 87));
        jLabel2.setText("Observaciones");

        txtObservacionesEspacios.setColumns(20);
        txtObservacionesEspacios.setFont(new java.awt.Font("STXihei", 0, 24)); // NOI18N
        txtObservacionesEspacios.setRows(5);
        jScrollPane1.setViewportView(txtObservacionesEspacios);

        btnCancelarGestion.setBackground(new java.awt.Color(255, 10, 84));
        btnCancelarGestion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCancelarGestion.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelarGestion.setText("Cancelar");
        btnCancelarGestion.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCancelarGestion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelarGestion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelarGestionMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCancelarGestionMouseEntered(evt);
            }
        });
        btnCancelarGestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarGestionActionPerformed(evt);
            }
        });

        btnGuardarGestion.setBackground(new java.awt.Color(72, 202, 228));
        btnGuardarGestion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnGuardarGestion.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardarGestion.setText("Guardar");
        btnGuardarGestion.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnGuardarGestion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardarGestion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGuardarGestionMouseClicked(evt);
            }
        });
        btnGuardarGestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarGestionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(342, 342, 342)
                        .addComponent(jLabel2)))
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnCancelarGestion, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnGuardarGestion, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(190, 190, 190))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 589, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(135, 135, 135))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(308, 308, 308))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelarGestion, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardarGestion, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
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

    private void btnCancelarGestionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarGestionMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarGestionMouseClicked

    private void btnCancelarGestionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarGestionMouseEntered
        
    }//GEN-LAST:event_btnCancelarGestionMouseEntered

    private void btnCancelarGestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarGestionActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarGestionActionPerformed

    private void btnGuardarGestionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarGestionMouseClicked
        
    }//GEN-LAST:event_btnGuardarGestionMouseClicked

    private void btnGuardarGestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarGestionActionPerformed
        if (cmbEstudianteEspacio.getSelectedItem() == null ||
        cmbResponsableEspacio.getSelectedItem() == null ||
        cmbTipoFalta.getSelectedItem() == null ||
        cmbSancion.getSelectedItem() == null ||
        dteFechaEspacio.getDate() == null) {
        
        JOptionPane.showMessageDialog(this, 
            "Complete todos los campos obligatorios", 
            "Error", 
            JOptionPane.ERROR_MESSAGE);
        return;
    }

    try {
        ControlDisciplinarioThis control = new ControlDisciplinarioThis();
        
        String nombreEstudiante = (String) cmbEstudianteEspacio.getSelectedItem();
        int idEstudiante = obtenerIdPorNombre(estudiantesMap, nombreEstudiante);
        control.setIdEstudiante(idEstudiante);
        
        control.setFecha(dteFechaEspacio.getDate());
        
        String nombreResponsable = (String) cmbResponsableEspacio.getSelectedItem();
        int idResponsable = obtenerIdPorNombre(instructoresMap, nombreResponsable);
        control.setIdResponsable(idResponsable);
        
        String tipoFalta = (String) cmbTipoFalta.getSelectedItem();
        int idTipoFalta = obtenerIdPorNombre(tiposFaltaMap, tipoFalta);
        control.setIdTipoFalta(idTipoFalta);
        
        String sancion = (String) cmbSancion.getSelectedItem();
        int idSancion = obtenerIdPorNombre(sancionesMap, sancion);
        control.setIdSancion(idSancion);
        
        control.setFaltasAcumuladas(Integer.parseInt(txtFaltasAcum.getText()));
        
        control.setObservaciones(txtObservacionesEspacios.getText());
        
        boolean guardado = dao.guardar(control);
        
        if (guardado) {
            JOptionPane.showMessageDialog(this, 
                "Registro guardado correctamente", 
                "Éxito", 
                JOptionPane.INFORMATION_MESSAGE);
            limpiarFormulario();
        } else {
            JOptionPane.showMessageDialog(this, 
                "Error al guardar el registro", 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, 
            "Error inesperado: " + e.getMessage(), 
            "Error", 
            JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnGuardarGestionActionPerformed

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
            java.util.logging.Logger.getLogger(ControlDisciplinario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ControlDisciplinario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ControlDisciplinario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ControlDisciplinario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ControlDisciplinario().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(ControlDisciplinario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelarGestion;
    private javax.swing.JButton btnGuardarGestion;
    private javax.swing.JComboBox<String> cmbEstudianteEspacio;
    private javax.swing.JComboBox<String> cmbResponsableEspacio;
    private javax.swing.JComboBox<String> cmbSancion;
    private javax.swing.JComboBox<String> cmbTipoFalta;
    private com.toedter.calendar.JDateChooser dteFechaEspacio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtFaltasAcum;
    private javax.swing.JTextArea txtObservacionesEspacios;
    // End of variables declaration//GEN-END:variables
}
