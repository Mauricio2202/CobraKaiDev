package persistence;

import igu.ControlDisciplinario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import model.ControlDisciplinarioThis;

public class ControlDisciplinarioDAO {
    public final Connection conn;

    public ControlDisciplinarioDAO(Connection conn) {
        this.conn = conn;
    }

    // Obtener estudiantes (excluyendo instructores)
    public Map<Integer, String> obtenerEstudiantes() {
    Map<Integer, String> estudiantes = new HashMap<>();
    String sql = "SELECT id, CONCAT(Nombre, ' ', App, ' ', Apm) as nombre_completo "
               + "FROM tbl_persona "
               + "WHERE Nombre NOT LIKE 'Instructor%' "
               + "AND Nombre IS NOT NULL "
               + "AND Nombre != '' "
               + "AND App IS NOT NULL "
               + "AND Apm IS NOT NULL";
    
    try (PreparedStatement ps = conn.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {
        
        while (rs.next()) {
            estudiantes.put(rs.getInt("id"), rs.getString("nombre_completo"));
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, 
            "Error al cargar estudiantes: " + e.getMessage(),
            "Error", 
            JOptionPane.ERROR_MESSAGE);
    }
    return estudiantes;
}

    // Obtener instructores
    public Map<Integer, String> obtenerInstructores() {
        Map<Integer, String> instructores = new HashMap<>();
        String sql = "SELECT id, Nombre FROM tbl_persona WHERE Nombre LIKE 'Instructor%'";
        
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                instructores.put(rs.getInt("id"), rs.getString("Nombre"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, 
                "Error al cargar instructores: " + e.getMessage(),
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        }
        return instructores;
    }

    // Obtener tipos de falta
    public Map<Integer, String> obtenerTiposFalta() {
        Map<Integer, String> tipos = new HashMap<>();
        String sql = "SELECT id, descripcion FROM tipos_falta";
        
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                tipos.put(rs.getInt("id"), rs.getString("descripcion"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, 
                "Error al cargar tipos de falta: " + e.getMessage(),
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        }
        return tipos;
    }

    // Obtener sanciones
    public Map<Integer, String> obtenerSanciones() {
        Map<Integer, String> sanciones = new HashMap<>();
        String sql = "SELECT id, descripcion FROM sanciones";
        
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                sanciones.put(rs.getInt("id"), rs.getString("descripcion"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, 
                "Error al cargar sanciones: " + e.getMessage(),
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        }
        return sanciones;
    }

    // Obtener faltas acumuladas de un estudiante
    public int obtenerFaltasAcumuladas(int idEstudiante) {
        String sql = "SELECT COUNT(*) as total FROM controles_disciplinarios WHERE id_estudiante = ?";
        
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idEstudiante);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                return rs.getInt("total");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, 
                "Error al obtener faltas acumuladas: " + e.getMessage(),
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        }
        return 0;
    }

    public boolean guardar(ControlDisciplinarioThis cd) {
        String sql = "INSERT INTO controles_disciplinarios (id_estudiante, fecha, id_responsable, "
                   + "id_tipo_falta, id_sancion, faltas_acumuladas, observaciones) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, cd.getIdEstudiante());
            ps.setDate(2, new java.sql.Date(cd.getFecha().getTime()));
            ps.setInt(3, cd.getIdResponsable());
            ps.setInt(4, cd.getIdTipoFalta());
            ps.setInt(5, cd.getIdSancion());
            ps.setInt(6, cd.getFaltasAcumuladas());
            ps.setString(7, cd.getObservaciones());
            
            int filas = ps.executeUpdate();
            
            if (filas > 0) {
                JOptionPane.showMessageDialog(null, 
                    "Registro disciplinario guardado correctamente",
                    "Éxito", 
                    JOptionPane.INFORMATION_MESSAGE);
                return true;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, 
                "Error al guardar registro: " + e.getMessage(),
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
}