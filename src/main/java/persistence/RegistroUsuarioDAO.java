package persistence;

import model.RegistroUsuario;
import java.sql.*;

public class RegistroUsuarioDAO {
    public boolean guardarDatosPersonales(RegistroUsuario usuario) {
        String sql = "INSERT INTO tbl_persona (Nombre, App, Apm, Fecha_Nacimiento, Idioma, Pais_Origen, Estado, Municipio, Codigo_Postal, Colonia, Calle, Numero_Exterior, Numero_Interior, Correo, Telefono_Local, Telefono_Movil, Parentesco, Autorizacion_Fisica, Foto) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getApellidoPaterno());
            ps.setString(3, usuario.getApellidoMaterno());
            ps.setDate(4, Date.valueOf(usuario.getFechaNacimiento()));
            ps.setInt(5, usuario.getIdioma());
            ps.setInt(6, usuario.getPaisOrigen());
            ps.setString(7, usuario.getEstado());
            ps.setString(8, usuario.getMunicipio());
            ps.setString(9, usuario.getCodigoPostal());
            ps.setString(10, usuario.getColonia());
            ps.setString(11, usuario.getCalle());
            ps.setString(12, usuario.getNumeroExterior());
            ps.setString(13, usuario.getNumeroInterior());
            ps.setString(14, usuario.getCorreo());
            ps.setString(15, usuario.getTelefonoLocal());
            ps.setString(16, usuario.getTelefonoMovil());
            ps.setString(17, usuario.getParentesco());
            ps.setInt(18, usuario.getAutorizacionFisica());
            ps.setBytes(19, usuario.getFoto());

            int filasAfectadas = ps.executeUpdate();
            
            if (filasAfectadas > 0) {
                try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        usuario.setId(generatedKeys.getInt(1));
                    }
                }
                return true;
            }
            return false;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}