package persistence;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CatalogosDAO {

    public List<String> obtenerPaises() {
        List<String> lista = new ArrayList<>();
        String sql = "SELECT nombre FROM PAISES";
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                lista.add(rs.getString("nombre"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public List<String> obtenerIdiomas() {
        List<String> lista = new ArrayList<>();
        String sql = "SELECT nombre FROM idiomas";
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                lista.add(rs.getString("nombre"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
    
    
    public List<String> obtenerEstados() {
    List<String> lista = new ArrayList<>();
    String sql = "SELECT nombre FROM estados ORDER BY nombre"; 
    try (Connection con = Conexion.getConexion();
         PreparedStatement ps = con.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {
        while (rs.next()) {
            lista.add(rs.getString("nombre"));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return lista;
}

public List<String> obtenerMunicipios() {
    List<String> lista = new ArrayList<>();
    String sql = "SELECT nombre FROM municipios"; 
    try (Connection con = Conexion.getConexion();
         PreparedStatement ps = con.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {
        while (rs.next()) {
            lista.add(rs.getString("nombre"));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return lista;
}

public List<String> obtenerCodigosPostales() {
    List<String> lista = new ArrayList<>();
    String sql = "SELECT codigo FROM codigos_postales";
    try (Connection con = Conexion.getConexion();
         PreparedStatement ps = con.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {
        while (rs.next()) {
            lista.add(rs.getString("codigo"));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return lista;
}

public List<String> obtenerParentescos() {
    List<String> lista = new ArrayList<>();
    String sql = "SELECT nombre FROM parentescos";
    try (Connection con = Conexion.getConexion();
         PreparedStatement ps = con.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {
        while (rs.next()) {
            lista.add(rs.getString("nombre"));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return lista;
}

public List<String> obtenerAutorizaciones() {
        List<String> lista = new ArrayList<>();
        String sql = "SELECT descripcion FROM autorizaciones_fisicas";
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                lista.add(rs.getString("descripcion"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }


}
