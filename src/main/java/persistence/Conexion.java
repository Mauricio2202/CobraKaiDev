
package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author 52551
 */
public class Conexion {
    private static final String URL = "jdbc:mysql://localhost:3306/db_cobrakai";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    
    public static Connection getConexion() throws SQLException {
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("✅ Conexión exitosa a la base de datos.");
            return conn;
        } catch (SQLException e) {
            System.out.println("❌ Error al conectar con la base de datos.");
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al conectar a la base de datos.\n" + e.getMessage(),
                    "Error de conexión", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
}
