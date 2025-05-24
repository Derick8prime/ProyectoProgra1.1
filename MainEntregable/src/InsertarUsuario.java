/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import main.ConexionPostgreSQL;
 
public class InsertarUsuario {
    
    
    public static void main(String[] args) {
        insertarUsuario("Juan", "Lopez", "juan69@yahoo.com", "juancho", "Motomami1234", "Tecnico");
    }

    public static void insertarUsuario(String nombre, String apellido, String correo,
                                       String usuario, String contrasena, String rol) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        String sql = "INSERT INTO usuarios (nombre, apellido, correo, usuario, contrasena, rol) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            conn = ConexionPostgreSQL.conectar();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, nombre);
            pstmt.setString(2, apellido);
            pstmt.setString(3, correo);
            pstmt.setString(4, usuario);
            pstmt.setString(5, contrasena);
            pstmt.setString(6, rol);

            int filasInsertadas = pstmt.executeUpdate();
            if (filasInsertadas > 0) {
                System.out.println("✅ Usuario insertado correctamente.");
            }

        } catch (Exception e) {
            System.err.println("❌ Error al insertar usuario: " + e.getMessage());
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                System.err.println("⚠️ Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
    
    
    
}
