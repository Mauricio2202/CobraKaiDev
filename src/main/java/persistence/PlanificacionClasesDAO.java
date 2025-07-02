package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import model.PlanificacionClasesThis;

public class PlanificacionClasesDAO {
    
    public Map<Integer, String> obtenerInstructores() {
        Map<Integer, String> instructores = new HashMap<>();
        String sql = "SELECT id, Nombre FROM tbl_persona WHERE Nombre LIKE 'Instructor %'";
        
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql);
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
    
    public Map<Integer, String> obtenerNivelesTecnicos() {
        Map<Integer, String> niveles = new HashMap<>();
        String sql = "SELECT id, nombre FROM niveles_tecnicos";
        
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                niveles.put(rs.getInt("id"), rs.getString("nombre"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, 
                "Error al cargar niveles técnicos: " + e.getMessage(),
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        }
        return niveles;
    }
    
    public Map<Integer, String> obtenerModalidades() {
        Map<Integer, String> modalidades = new HashMap<>();
        String sql = "SELECT id, nombre FROM modalidades";
        
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                modalidades.put(rs.getInt("id"), rs.getString("nombre"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, 
                "Error al cargar modalidades: " + e.getMessage(),
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        }
        return modalidades;
    }
    
    public List<String> obtenerEstados() {
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
                "Error al cargar estados: " + e.getMessage(),
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        }
        return estados;
    }
    
    public void guardarPlanificacion(PlanificacionClasesThis planificacion) {
        String sql = "INSERT INTO planificacion_clases (nombre_clase, id_instructor, id_nivel_tecnico, "
                   + "id_modalidad, fecha_clase, estado, capacidad, reporte_actividades) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            // Obtener ID del instructor por su nombre
            int idInstructor = obtenerIdInstructor(planificacion.getInstructorPresente());
            
            ps.setString(1, planificacion.getNombreClase());
            ps.setInt(2, idInstructor);
            ps.setInt(3, obtenerIdNivelTecnico(planificacion.getNivelTecnico()));
            ps.setInt(4, obtenerIdModalidad(planificacion.getModalidad()));
            ps.setDate(5, java.sql.Date.valueOf(planificacion.getFechaClase()));
            ps.setString(6, planificacion.getEstado());
            ps.setInt(7, planificacion.getCantidadMaxPersonas());
            ps.setString(8, planificacion.getReporteActividades());
            
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(null, 
                "Planificación guardada correctamente",
                "Éxito", 
                JOptionPane.INFORMATION_MESSAGE);
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, 
                "Error al guardar planificación: " + e.getMessage(),
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private int obtenerIdInstructor(String nombreInstructor) throws SQLException {
        String sql = "SELECT id FROM tbl_persona WHERE Nombre = ?";
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, nombreInstructor);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("id");
            }
        }
        throw new SQLException("Instructor no encontrado");
    }
    
    private int obtenerIdNivelTecnico(String nombreNivel) throws SQLException {
        String sql = "SELECT id FROM niveles_tecnicos WHERE nombre = ?";
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, nombreNivel);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("id");
            }
        }
        throw new SQLException("Nivel técnico no encontrado");
    }
    
    private int obtenerIdModalidad(String nombreModalidad) throws SQLException {
        String sql = "SELECT id FROM modalidades WHERE nombre = ?";
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, nombreModalidad);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("id");
            }
        }
        throw new SQLException("Modalidad no encontrada");
    }
}