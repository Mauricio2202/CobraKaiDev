
package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author 52551
 */
public class EvolucionEstudianteDAO {
    
    public List<String> obtenerEstadoActivo() {
    List<String> lista = new ArrayList<>();
    String sql = "SELECT descripcion FROM ESTADO_SINO"; 
    try (Connection con = Conexion.getConexion();
         PreparedStatement ps = con.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {
        while (rs.next()) {
            lista.add(rs.getString("descripcion"));  
        }
    } catch (SQLException e) {
        e.printStackTrace();
        // Mejor manejo de errores
        JOptionPane.showMessageDialog(null, 
            "Error al obtener estados: " + e.getMessage(),
            "Error de base de datos",
            JOptionPane.ERROR_MESSAGE);
    }
    return lista;
}
    
    public void guardarEvolucionEstudiante() {
        JOptionPane.showMessageDialog(null, "Evolución de estudiante guardada");
    }
    
    public List<Object[]> buscarEstudiantes(String busqueda) {
    List<Object[]> resultados = new ArrayList<>();
    String sql = "SELECT p.id, p.Nombre, p.App, p.Apm, " +
                "p.Fecha_Nacimiento, p.fecha_ingreso, " +
                "r.nombre as Rango, e.nombre as Estado, p.Foto " +
                "FROM tbl_persona p " +
                "LEFT JOIN rangos_cobrakai r ON p.rango_actual = r.id " +
                "LEFT JOIN estados e ON p.estado = e.id " +
                "WHERE CONCAT(p.Nombre, ' ', p.App, ' ', p.Apm) LIKE ? " +
                "ORDER BY p.Nombre";
    
    try (Connection con = Conexion.getConexion();
         PreparedStatement ps = con.prepareStatement(sql)) {
        
        ps.setString(1, "%" + busqueda + "%");
        
        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Object[] fila = new Object[9];
                fila[0] = rs.getInt("id");
                fila[1] = rs.getString("Nombre");
                fila[2] = rs.getString("App");
                fila[3] = rs.getString("Apm");
                fila[4] = rs.getDate("Fecha_Nacimiento");
                fila[5] = rs.getDate("fecha_ingreso");
                fila[6] = rs.getString("Rango");
                fila[7] = rs.getString("Estado");
                fila[8] = rs.getBytes("Foto");
                resultados.add(fila);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
        throw new RuntimeException("Error al buscar estudiantes: " + e.getMessage());
    }
    return resultados;
}
    
    
    
}
