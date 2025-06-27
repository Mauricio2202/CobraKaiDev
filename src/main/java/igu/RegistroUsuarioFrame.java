
package igu;
import model.RegistroUsuario;
import java.awt.Dimension;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.sql.SQLException;
import java.time.ZoneId;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import persistence.CatalogosDAO;
import persistence.RegistroUsuarioDAO;

public class RegistroUsuarioFrame extends javax.swing.JFrame {
    

    public RegistroUsuarioFrame() {
        initComponents();
        cargarCombos();
        

        JScrollPane scrollPane = new JScrollPane(pnlRegistroUsuario);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        setContentPane(scrollPane);
        revalidate();
        repaint();
        this.setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlRegistroUsuario = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnBuscarFoto = new javax.swing.JButton();
        lblFoto = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtApellidoPaterno = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtApellidoMaterno = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        dateChooser = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        cmbPaisOrigen = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        cmbIdioma = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        cmbDireccionEstado = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        cmbMunicipio = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        cmbCP = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        txtColonia = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtCalle = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtNumExterior = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtNumInterior = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtTelLocal = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtTelMovil = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        cmbParentesco = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        cmbAutorizacionActFisica = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        txtNombreFoto = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlRegistroUsuario.setBackground(new java.awt.Color(201, 162, 39));
        pnlRegistroUsuario.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setFont(new java.awt.Font("STXihei", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(242, 242, 242));
        jLabel1.setText("Registro de Usuario");

        btnBuscarFoto.setBackground(new java.awt.Color(247, 127, 0));
        btnBuscarFoto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnBuscarFoto.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscarFoto.setText("Foto");
        btnBuscarFoto.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnBuscarFoto.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
        btnBuscarFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarFotoActionPerformed(evt);
            }
        });

        lblFoto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnCancelar.setBackground(new java.awt.Color(255, 10, 84));
        btnCancelar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnGuardar.setBackground(new java.awt.Color(72, 202, 228));
        btnGuardar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setText("Guardar");
        btnGuardar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(201, 162, 39));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Personales"));

        jLabel2.setBackground(new java.awt.Color(204, 204, 204));
        jLabel2.setFont(new java.awt.Font("STXihei", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(242, 242, 242));
        jLabel2.setText("Nombre");

        txtNombre.setFont(new java.awt.Font("STXihei", 0, 12)); // NOI18N

        jLabel3.setBackground(new java.awt.Color(204, 204, 204));
        jLabel3.setFont(new java.awt.Font("STXihei", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(242, 242, 242));
        jLabel3.setText("Apellido Paterno");

        txtApellidoPaterno.setFont(new java.awt.Font("STXihei", 0, 12)); // NOI18N

        jLabel4.setBackground(new java.awt.Color(204, 204, 204));
        jLabel4.setFont(new java.awt.Font("STXihei", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(242, 242, 242));
        jLabel4.setText("Apellido Materno");

        txtApellidoMaterno.setFont(new java.awt.Font("STXihei", 0, 12)); // NOI18N

        jLabel5.setBackground(new java.awt.Color(204, 204, 204));
        jLabel5.setFont(new java.awt.Font("STXihei", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(242, 242, 242));
        jLabel5.setText("Fecha de Nacimiento");

        jLabel6.setBackground(new java.awt.Color(204, 204, 204));
        jLabel6.setFont(new java.awt.Font("STXihei", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(242, 242, 242));
        jLabel6.setText("País Origen");

        cmbPaisOrigen.setFont(new java.awt.Font("STXihei", 0, 12)); // NOI18N

        jLabel7.setBackground(new java.awt.Color(204, 204, 204));
        jLabel7.setFont(new java.awt.Font("STXihei", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(242, 242, 242));
        jLabel7.setText("Idioma");

        cmbIdioma.setFont(new java.awt.Font("STXihei", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(cmbPaisOrigen, javax.swing.GroupLayout.Alignment.LEADING, 0, 177, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cmbIdioma, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtApellidoPaterno, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(txtApellidoMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(dateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(65, 65, 65))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtApellidoPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtApellidoMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(dateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbPaisOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbIdioma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 12, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(201, 162, 39));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Dirección Personal"));

        jLabel8.setBackground(new java.awt.Color(204, 204, 204));
        jLabel8.setFont(new java.awt.Font("STXihei", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(242, 242, 242));
        jLabel8.setText("Estado");

        cmbDireccionEstado.setFont(new java.awt.Font("STXihei", 0, 12)); // NOI18N

        jLabel9.setBackground(new java.awt.Color(204, 204, 204));
        jLabel9.setFont(new java.awt.Font("STXihei", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(242, 242, 242));
        jLabel9.setText("Alcaldía o Municipio");

        cmbMunicipio.setFont(new java.awt.Font("STXihei", 0, 12)); // NOI18N

        jLabel10.setBackground(new java.awt.Color(204, 204, 204));
        jLabel10.setFont(new java.awt.Font("STXihei", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(242, 242, 242));
        jLabel10.setText("Código Postal");

        cmbCP.setFont(new java.awt.Font("STXihei", 0, 12)); // NOI18N

        jLabel11.setBackground(new java.awt.Color(204, 204, 204));
        jLabel11.setFont(new java.awt.Font("STXihei", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(242, 242, 242));
        jLabel11.setText("Colonia");

        txtColonia.setFont(new java.awt.Font("STXihei", 0, 12)); // NOI18N

        jLabel12.setBackground(new java.awt.Color(204, 204, 204));
        jLabel12.setFont(new java.awt.Font("STXihei", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(242, 242, 242));
        jLabel12.setText("Calle");

        txtCalle.setFont(new java.awt.Font("STXihei", 0, 12)); // NOI18N

        jLabel13.setBackground(new java.awt.Color(204, 204, 204));
        jLabel13.setFont(new java.awt.Font("STXihei", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(242, 242, 242));
        jLabel13.setText("Número Exterior");

        txtNumExterior.setFont(new java.awt.Font("STXihei", 0, 12)); // NOI18N

        jLabel14.setBackground(new java.awt.Color(204, 204, 204));
        jLabel14.setFont(new java.awt.Font("STXihei", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(242, 242, 242));
        jLabel14.setText("Número Interior");

        txtNumInterior.setFont(new java.awt.Font("STXihei", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtCalle, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(cmbDireccionEstado, javax.swing.GroupLayout.Alignment.LEADING, 0, 177, Short.MAX_VALUE))
                    .addComponent(jLabel12))
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(61, 61, 61)
                        .addComponent(jLabel10))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)
                            .addComponent(txtNumExterior, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(cmbCP, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNumInterior, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(31, 31, 31)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtColonia, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbDireccionEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbCP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtColonia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumExterior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumInterior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(201, 162, 39));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Información de Contacto"));

        jLabel15.setBackground(new java.awt.Color(204, 204, 204));
        jLabel15.setFont(new java.awt.Font("STXihei", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(242, 242, 242));
        jLabel15.setText("Correo");

        txtCorreo.setFont(new java.awt.Font("STXihei", 0, 12)); // NOI18N
        txtCorreo.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtCorreoCaretUpdate(evt);
            }
        });

        jLabel16.setBackground(new java.awt.Color(204, 204, 204));
        jLabel16.setFont(new java.awt.Font("STXihei", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(242, 242, 242));
        jLabel16.setText("Teléfono Móvil");

        txtTelLocal.setFont(new java.awt.Font("STXihei", 0, 12)); // NOI18N
        txtTelLocal.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTelLocalCaretUpdate(evt);
            }
        });

        jLabel17.setBackground(new java.awt.Color(204, 204, 204));
        jLabel17.setFont(new java.awt.Font("STXihei", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(242, 242, 242));
        jLabel17.setText("Teléfono Local");

        txtTelMovil.setFont(new java.awt.Font("STXihei", 0, 12)); // NOI18N
        txtTelMovil.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTelMovilCaretUpdate(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 352, Short.MAX_VALUE)
                        .addComponent(jLabel17)
                        .addGap(145, 145, 145))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(166, 166, 166)
                        .addComponent(txtTelLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(txtTelMovil, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelLocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelMovil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(201, 162, 39));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Nota Importante"));

        jLabel18.setBackground(new java.awt.Color(204, 204, 204));
        jLabel18.setFont(new java.awt.Font("STXihei", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(242, 242, 242));
        jLabel18.setText("En caso de ser menor de edad, el tutor o representante legal deberá ingresar lo siguiente");

        jLabel19.setBackground(new java.awt.Color(204, 204, 204));
        jLabel19.setFont(new java.awt.Font("STXihei", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(242, 242, 242));
        jLabel19.setText("Autorización para actividades físicas intensas");

        cmbParentesco.setFont(new java.awt.Font("STXihei", 0, 12)); // NOI18N

        jLabel20.setBackground(new java.awt.Color(204, 204, 204));
        jLabel20.setFont(new java.awt.Font("STXihei", 1, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(242, 242, 242));
        jLabel20.setText("Parentesco");

        cmbAutorizacionActFisica.setFont(new java.awt.Font("STXihei", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addComponent(cmbParentesco, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cmbAutorizacionActFisica, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(156, 156, 156))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbParentesco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbAutorizacionActFisica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 31, Short.MAX_VALUE))
        );

        jLabel21.setBackground(new java.awt.Color(204, 204, 204));
        jLabel21.setFont(new java.awt.Font("STXihei", 1, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(242, 242, 242));
        jLabel21.setText("Foto");

        txtNombreFoto.setBackground(new java.awt.Color(255, 255, 255));
        txtNombreFoto.setFont(new java.awt.Font("STXihei", 1, 12)); // NOI18N
        txtNombreFoto.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout pnlRegistroUsuarioLayout = new javax.swing.GroupLayout(pnlRegistroUsuario);
        pnlRegistroUsuario.setLayout(pnlRegistroUsuarioLayout);
        pnlRegistroUsuarioLayout.setHorizontalGroup(
            pnlRegistroUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRegistroUsuarioLayout.createSequentialGroup()
                .addGroup(pnlRegistroUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlRegistroUsuarioLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlRegistroUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(pnlRegistroUsuarioLayout.createSequentialGroup()
                                .addGap(269, 269, 269)
                                .addComponent(jLabel1))
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(pnlRegistroUsuarioLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(pnlRegistroUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21)
                            .addGroup(pnlRegistroUsuarioLayout.createSequentialGroup()
                                .addComponent(txtNombreFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(btnBuscarFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)))
                .addContainerGap())
        );
        pnlRegistroUsuarioLayout.setVerticalGroup(
            pnlRegistroUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRegistroUsuarioLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGroup(pnlRegistroUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlRegistroUsuarioLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addGroup(pnlRegistroUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnBuscarFoto)
                            .addGroup(pnlRegistroUsuarioLayout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNombreFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(48, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlRegistroUsuarioLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlRegistroUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCancelar)
                            .addComponent(btnGuardar))
                        .addGap(67, 67, 67))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlRegistroUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlRegistroUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
         if (txtNombre.getText().isEmpty() || txtApellidoPaterno.getText().isEmpty() || 
        dateChooser.getDate() == null || cmbPaisOrigen.getSelectedIndex() == -1 || 
        cmbIdioma.getSelectedIndex() == -1) {
        JOptionPane.showMessageDialog(this, "Por favor complete todos los campos obligatorios.");
        return;
    }

    CatalogosDAO catalogosDAO = new CatalogosDAO();
    
    byte[] fotoBytes = null;
    try {
        File imgFile = new File(txtNombreFoto.getText());
        FileInputStream fis = new FileInputStream(imgFile);
        fotoBytes = fis.readAllBytes();
        fis.close();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al leer la foto.");
        return;
    }

    model.RegistroUsuario usuario = new model.RegistroUsuario();

    usuario.setNombre(txtNombre.getText());
    usuario.setApellidoPaterno(txtApellidoPaterno.getText());
    usuario.setApellidoMaterno(txtApellidoMaterno.getText());
    usuario.setFechaNacimiento(dateChooser.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
    usuario.setPaisOrigen(cmbPaisOrigen.getSelectedIndex());
    usuario.setIdioma(cmbIdioma.getSelectedIndex());
    usuario.setEstado(cmbDireccionEstado.getSelectedItem().toString());
    usuario.setMunicipio(cmbMunicipio.getSelectedItem().toString());
    usuario.setCodigoPostal(cmbCP.getSelectedItem().toString());
    usuario.setColonia(txtColonia.getText());
    usuario.setCalle(txtCalle.getText());
    usuario.setNumeroExterior(txtNumExterior.getText());
    usuario.setNumeroInterior(txtNumInterior.getText());
    usuario.setCorreo(txtCorreo.getText());
    usuario.setTelefonoLocal(txtTelLocal.getText());
    usuario.setTelefonoMovil(txtTelMovil.getText());
    usuario.setParentesco(cmbParentesco.getSelectedItem().toString());
    usuario.setFoto(fotoBytes);

    // Guardar
    RegistroUsuarioDAO dao = new RegistroUsuarioDAO();
    dao.guardarDatosPersonales(usuario);
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnBuscarFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarFotoActionPerformed
        JFileChooser fileChooser = new JFileChooser();
    fileChooser.setDialogTitle("Selecciona una imagen");

    FileNameExtensionFilter filtro = new FileNameExtensionFilter(
        "Imágenes (jpg, png, jpeg)", "jpg", "png", "jpeg");
    fileChooser.setFileFilter(filtro);

    int seleccion = fileChooser.showOpenDialog(this);

    if (seleccion == JFileChooser.APPROVE_OPTION) {
        File archivoSeleccionado = fileChooser.getSelectedFile();
        String ruta = archivoSeleccionado.getAbsolutePath();

        txtNombreFoto.setText(ruta);

        ImageIcon imagen = new ImageIcon(ruta);
        Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(
            lblFoto.getWidth(), lblFoto.getHeight(), Image.SCALE_SMOOTH));
        lblFoto.setIcon(icono);

        System.out.println("Ruta seleccionada: " + ruta);
        }
    }//GEN-LAST:event_btnBuscarFotoActionPerformed

    private void txtTelMovilCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTelMovilCaretUpdate
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelMovilCaretUpdate

    private void txtTelLocalCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTelLocalCaretUpdate
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelLocalCaretUpdate

    private void txtCorreoCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtCorreoCaretUpdate
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoCaretUpdate

    private void cargarCombos() {
        
    CatalogosDAO dao = new CatalogosDAO();

    for (String estado : dao.obtenerEstados()) {
        cmbDireccionEstado.addItem(estado);
    }

    for (String municipio : dao.obtenerMunicipios()) {
        cmbMunicipio.addItem(municipio);
    }

    for (String idioma : dao.obtenerIdiomas()) {
        cmbIdioma.addItem(idioma);
    }

    for (String pais : dao.obtenerPaises()) {   
        cmbPaisOrigen.addItem(pais);
    }

    for (String cp : dao.obtenerCodigosPostales()) {
        cmbCP.addItem(cp);
    }

    for (String p : dao.obtenerParentescos()) {
        cmbParentesco.addItem(p);
    }

    for (String aut : dao.obtenerAutorizaciones()) {
        cmbAutorizacionActFisica.addItem(aut);
    }
}

    
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
            java.util.logging.Logger.getLogger(RegistroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistroUsuarioFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarFoto;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cmbAutorizacionActFisica;
    private javax.swing.JComboBox<String> cmbCP;
    private javax.swing.JComboBox<String> cmbDireccionEstado;
    private javax.swing.JComboBox<String> cmbIdioma;
    private javax.swing.JComboBox<String> cmbMunicipio;
    private javax.swing.JComboBox<String> cmbPaisOrigen;
    private javax.swing.JComboBox<String> cmbParentesco;
    private com.toedter.calendar.JDateChooser dateChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JPanel pnlRegistroUsuario;
    private javax.swing.JTextField txtApellidoMaterno;
    private javax.swing.JTextField txtApellidoPaterno;
    private javax.swing.JTextField txtCalle;
    private javax.swing.JTextField txtColonia;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JLabel txtNombreFoto;
    private javax.swing.JTextField txtNumExterior;
    private javax.swing.JTextField txtNumInterior;
    private javax.swing.JTextField txtTelLocal;
    private javax.swing.JTextField txtTelMovil;
    // End of variables declaration//GEN-END:variables
}
