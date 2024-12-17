/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gzchocolateria;

/**
 *
 * @author jesuz
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/guelaguetza";
    private static final String USER = "root";
    private static final String PASSWORD = "12345678";
    private static Connection connection = null;

    // Método para obtener la conexión (solo una vez)
    public static Connection getConnection() throws SQLException {
        // Si la conexión aún no está establecida, se crea una nueva
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        }
        return connection;
    }

    // Método para cerrar la conexión (si es necesario)
    public static void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
            connection = null;
        }
    }

    // Método para verificar la conexión
    public static boolean isConnected() {
        try {
            return connection != null && !connection.isClosed();
        } catch (SQLException e) {
            return false;
        }
    }

    // Método main para probar la conexión
   public static void main(String[] args) {
        try {
            // Intentamos obtener la conexión
            Connection conn = dbConnection.getConnection();
            if (conn != null) {
                System.out.println("Conexión exitosa a la base de datos.");
            } else {
                System.out.println("No se pudo conectar a la base de datos.");
            }
        } catch (SQLException e) {
            System.out.println("Error de conexión: " + e.getMessage());
        }
    }
 // Método para obtener la conexión (solo una vez)
    public static Connection getConexion() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        }
        return connection;
    }

}

