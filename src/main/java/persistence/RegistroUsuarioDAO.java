package persistence;

import model.RegistroUsuario;
import java.sql.*;
import javax.swing.JOptionPane;

public class RegistroUsuarioDAO {

    public void guardarDatosPersonales(RegistroUsuario usuario) {
        String sql = "INSERT INTO tbl_persona (Nombre, App, Apm, Fecha_Nacimiento, Idioma, Pais_Origen, Estado, Municipio, Codigo_Postal, Colonia, Calle, Numero_Exterior, Numero_Interior, Correo, Telefono_Local, Telefono_Movil, Parentesco, Autorizacion_Fisica, Foto) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getApellidoPaterno());
            ps.setString(3, usuario.getApellidoMaterno());
            ps.setDate(4, java.sql.Date.valueOf(usuario.getFechaNacimiento()));
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
            ps.setInt(18, usuario.getAutorizacionFisicaId());
            ps.setBytes(19, usuario.getFoto());

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Datos guardados correctamente.");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al insertar los datos: " + ex.getMessage());
        }
    }
}
