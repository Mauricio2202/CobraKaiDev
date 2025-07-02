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

public int obtenerIdPorNombre(String tabla, String columnaId, String columnaNombre, String nombre) throws SQLException {
    String sql = "SELECT " + columnaId + " FROM " + tabla + " WHERE " + columnaNombre + " = ?";
    
    System.out.println("Ejecutando consulta: " + sql); 
    System.out.println("Buscando: " + nombre + " en tabla " + tabla); 
    
    try (Connection con = Conexion.getConexion();
         PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setString(1, nombre);
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                int id = rs.getInt(columnaId);
                System.out.println("Encontrado ID: " + id); 
                return id;
            } else {
                System.err.println("No se encontró '" + nombre + "' en la tabla " + tabla);
                System.err.println("Valores existentes en la tabla:");
                listarValoresTabla(tabla, columnaNombre); 
                throw new SQLException("No se encontró '" + nombre + "' en la tabla " + tabla);
            }
        }
    }
}

// Método adicional para debug
private void listarValoresTabla(String tabla, String columnaNombre) {
    String sql = "SELECT " + columnaNombre + " FROM " + tabla;
    try (Connection con = Conexion.getConexion();
         Statement stmt = con.createStatement();
         ResultSet rs = stmt.executeQuery(sql)) {
        System.err.println("Valores en " + tabla + ":");
        while (rs.next()) {
            System.err.println("- " + rs.getString(columnaNombre));
        }
    } catch (SQLException e) {
        System.err.println("Error al listar valores: " + e.getMessage());
    }
}
}
