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
import java.sql.DriverManager;
import java.sql.SQLException;



public class ConexionPostgreSQL {
    
    private static final String URL = "jdbc:postgresql://dpg-d0ohis6mcj7s73d6f4m0-a.oregon-postgres.render.com:5432/sistema_tickets_y0he";
    private static final String USER = "sistema_tickets_y0he_user";
    private static final String PASSWORD = "luotjieB9Qd09qzSrCQEXlaVeftw73PW";

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void main(String[] args) {
        try (Connection conn = conectar()) {
            if (conn != null) {
                System.out.println("Conexión exitosa a la base de datos en la nube.");
            }
        } catch (SQLException e) {
            System.err.println("Error de conexión: " + e.getMessage());
        }
    }
    
    
}
