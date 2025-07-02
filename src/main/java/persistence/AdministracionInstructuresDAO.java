
package persistence;

import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author 52551
 */
public class AdministracionInstructuresDAO {
    
    public List<Object[]> buscarInstructores(String nombre) {
    List<Object[]> resultados = new ArrayList<>();
    
    String sql = "SELECT id, Nombre, App, Apm, " +
                "DATE_FORMAT(Fecha_Nacimiento, '%Y-%m-%d') as Nacimiento, " +
                "DATE_FORMAT(fecha_ingreso, '%Y-%m-%d') as Ingreso, " +
                "Estado, Foto " +
                "FROM tbl_persona " +
                "WHERE Nombre = ? AND Nombre LIKE 'Instructor %'";
    
    try (Connection con = Conexion.getConexion();
         PreparedStatement ps = con.prepareStatement(sql)) {
        
        ps.setString(1, nombre);
        
        ResultSet rs = ps.executeQuery();
        
        if (!rs.isBeforeFirst()) {
            JOptionPane.showMessageDialog(null, 
                "No existe o no cumple el formato 'Instructor [nombre]'", 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        } else {
            while (rs.next()) {
                resultados.add(new Object[]{
                    rs.getInt("id"),
                    rs.getString("Nombre"),
                    rs.getString("App"),
                    rs.getString("Apm"),
                    rs.getString("Nacimiento"),
                    rs.getString("Ingreso"),
                    "", // Contrato
                    "", // Rol
                    rs.getString("Estado"),
                    rs.getBytes("Foto")
                });
            }
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, 
            "Error en la búsqueda", 
            "Error", 
            JOptionPane.ERROR_MESSAGE);
    }
    return resultados;
}
    
    private ImageIcon procesarFotoInstructor(byte[] fotoBytes) {
        if (fotoBytes == null) {
            return null;
        }
        try {
            ImageIcon icon = new ImageIcon(fotoBytes);
            Image img = icon.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
            return new ImageIcon(img);
        } catch (Exception e) {
            return null;
        }
    }
    
    public void guardarAdminInstructores() {
        JOptionPane.showMessageDialog(null, "Administración guardada correctamente");
    }
    
    
    public List<String> obtenerEstadosActivos() {
        List<String> estados = new ArrayList<>();
        String sql = "SELECT descripcion FROM estado_sino";
    
        try (Connection con = Conexion.getConexion();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()) {
        
        while (rs.next()) {
            estados.add(rs.getString("descripcion"));
        }
        } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, 
            "Error al obtener estados: " + e.getMessage(),
            "Error", 
            JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
    }
    return estados;
}
    
    
}
