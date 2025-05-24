/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;
import java.sql.Connection;

/**
 *
 * @author bachl
 */
public class TestConexion {
    
    public static void main(String[] args) {
        try {
            Connection conn = ConexionPostgreSQL.conectar();
            if (conn != null) {
                System.out.println("✅ Conexión exitosa con PostgreSQL en la nube.");
                conn.close();
            }
        } catch (Exception e) {
            System.err.println("❌ Error al conectar: " + e.getMessage());
        }
    }
    
    
    
}
