package persistence;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Archivo;

public class ArchivoDAO {
    private Connection conn;

    public ArchivoDAO(Connection conexion) throws SQLException {
        this.conn = Conexion.getConexion(); 
    }

    public boolean subirArchivo(Archivo archivo) {
        String sql = "INSERT INTO archivos (nombre_archivo, ruta_archivo, tipo_archivo) VALUES (?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, archivo.getNombreArchivo());
            ps.setString(2, archivo.getRutaArchivo());
            ps.setString(3, archivo.getTipoArchivo().toString());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al subir archivo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public boolean revocarArchivo(int idArchivo) {
        String sql = "UPDATE archivos SET estado = 'Revocado' WHERE id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idArchivo);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al revocar archivo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public List<Archivo> listarArchivos(String tipo) {
        List<Archivo> archivos = new ArrayList<>();
        String sql = "SELECT * FROM archivos WHERE tipo_archivo = ? AND estado = 'Activo'";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, tipo);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Archivo archivo = new Archivo();
                archivo.setId(rs.getInt("id"));
                archivo.setNombreArchivo(rs.getString("nombre_archivo"));
                archivo.setRutaArchivo(rs.getString("ruta_archivo"));
                archivo.setTipoArchivo(Archivo.TipoArchivo.valueOf(rs.getString("tipo_archivo")));
                archivos.add(archivo);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al listar archivos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return archivos;
    }
}