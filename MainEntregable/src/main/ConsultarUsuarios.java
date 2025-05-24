/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author bachl
 */


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConsultarUsuarios {
    
     public static void main(String[] args) {
        consultarUsuarios();
    }

    public static void consultarUsuarios() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConexionPostgreSQL.conectar();
            stmt = conn.createStatement();

            String sql = "SELECT id_usuario, nombre, apellido, correo, usuario, rol FROM usuarios";
            rs = stmt.executeQuery(sql);

            System.out.println("📋 Usuarios registrados:");
            while (rs.next()) {
                int id = rs.getInt("id_usuario");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String correo = rs.getString("correo");
                String usuario = rs.getString("usuario");
                String rol = rs.getString("rol");

                System.out.println("ID: " + id +
                        ", Nombre: " + nombre + " " + apellido +
                        ", Correo: " + correo +
                        ", Usuario: " + usuario +
                        ", Rol: " + rol);
            }

        } catch (Exception e) {
            System.err.println("❌ Error al consultar usuarios: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                System.err.println("⚠️ Error al cerrar conexión: " + e.getMessage());
            }
        }
    }
    
    
    
}
