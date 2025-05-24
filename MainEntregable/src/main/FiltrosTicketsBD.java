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
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class FiltrosTicketsBD {
    
    public static void buscarTicketsPorEstado(int idEstado) {
        String sql = "SELECT * FROM tickets WHERE id_estado=?";
        try (Connection conn = ConexionPostgreSQL.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idEstado);
            ResultSet rs = pstmt.executeQuery();

            System.out.println("🎯 Tickets con estado ID " + idEstado + ":");
            while (rs.next()) {
                System.out.println("Ticket #" + rs.getInt("id_ticket") + ": " + rs.getString("titulo"));
            }

        } catch (Exception e) {
            System.err.println("❌ Error al buscar tickets por estado: " + e.getMessage());
        }
    }

    public static void buscarTicketsPorPrioridad(String prioridad) {
        String sql = "SELECT * FROM tickets WHERE prioridad ILIKE ?";
        try (Connection conn = ConexionPostgreSQL.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, prioridad);
            ResultSet rs = pstmt.executeQuery();

            System.out.println("⚡ Tickets con prioridad '" + prioridad + "':");
            while (rs.next()) {
                System.out.println("Ticket #" + rs.getInt("id_ticket") + ": " + rs.getString("titulo"));
            }

        } catch (Exception e) {
            System.err.println("❌ Error al buscar tickets por prioridad: " + e.getMessage());
        }
    }

    public static void listarTicketsPorDepartamento(int idDepartamento) {
        String sql = "SELECT * FROM tickets WHERE id_departamento=?";
        try (Connection conn = ConexionPostgreSQL.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idDepartamento);
            ResultSet rs = pstmt.executeQuery();

            System.out.println("🏢 Tickets del departamento ID " + idDepartamento + ":");
            while (rs.next()) {
                System.out.println("Ticket #" + rs.getInt("id_ticket") + ": " + rs.getString("titulo"));
            }

        } catch (Exception e) {
            System.err.println("❌ Error al listar tickets por departamento: " + e.getMessage());
        }
    }
    
}
