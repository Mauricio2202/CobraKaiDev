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

public class EspaciosFisicosDAO {
    
   public Map<String, String> obtenerClasesPlanificadas() {
    Map<String, String> clases = new HashMap<>();
    String sql = "SELECT DISTINCT nombre_clase FROM planificacion_clases";
    
    try (Connection con = Conexion.getConexion();
         PreparedStatement ps = con.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {
        
        while (rs.next()) {
            clases.put(rs.getString("nombre_clase"), "Por el momento no hay reporte que se tenga que enviar");
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, 
            "Error al cargar clases: " + e.getMessage(),
            "Error", 
            JOptionPane.ERROR_MESSAGE);
    }
    return clases;
}
    
    public void guardarEspacio(model.EspaciosFisicosThis espacio) {
        String sql = "INSERT INTO espacios_fisicos (tipo_espacio, capacidad, caracteristicas) VALUES (?, ?, ?)";
        
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, espacio.getTipoEspacio());
            ps.setInt(2, espacio.getCapacidadPersonas());
            ps.setString(3, espacio.getCaracteristicasEspacio());
            
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(null, 
                "Espacio físico guardado correctamente",
                "Éxito", 
                JOptionPane.INFORMATION_MESSAGE);
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, 
                "Error al guardar espacio: " + e.getMessage(),
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        }
    }
}