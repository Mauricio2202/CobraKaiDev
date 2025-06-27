
package test;

import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import persistence.Conexion;

/**
 *
 * @author 52551
 */
public class TestConexion {
    public static void main(String[] args) throws SQLException {
        Connection conn = Conexion.getConexion();
        if (conn != null) {
            System.out.println("¡Conexión establecida correctamente desde el test!");
            JOptionPane.showMessageDialog(null," 🚀 Conexión Exitosa a la base de datos Cobrakai");
        } else {
            System.out.println(" No se pudo establecer la conexión.");
            JOptionPane.showMessageDialog(null," ⚠ Conexión Fallida a la base de datos CobraKai");
        }
    }
}
