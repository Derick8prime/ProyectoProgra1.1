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
import java.sql.Statement;
public class GestorTicketsBD {
    
   public static void insertarTicket(String titulo, String descripcion, String prioridad,
                                      int idDepartamento, int idUsuario, int idTecnico, int idEstado) {
        String sql = "INSERT INTO tickets (titulo, descripcion, prioridad, id_departamento, id_usuario, id_tecnico, id_estado) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConexionPostgreSQL.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, titulo);
            pstmt.setString(2, descripcion);
            pstmt.setString(3, prioridad);
            pstmt.setInt(4, idDepartamento);
            pstmt.setInt(5, idUsuario);
            pstmt.setInt(6, idTecnico);
            pstmt.setInt(7, idEstado);

            int filas = pstmt.executeUpdate();
            if (filas > 0) {
                System.out.println("✅ Ticket insertado correctamente.");
            }

        } catch (Exception e) {
            System.err.println("❌ Error al insertar ticket: " + e.getMessage());
        }
    }

    public static void consultarTodosLosTickets() {
        String sql = "SELECT * FROM tickets";
        try (Connection conn = ConexionPostgreSQL.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println("Ticket #" + rs.getInt("id_ticket") + ": " +
                        rs.getString("titulo") + " - " +
                        rs.getString("descripcion") + " (" +
                        rs.getString("prioridad") + ")");
            }

        } catch (Exception e) {
            System.err.println("❌ Error al consultar tickets: " + e.getMessage());
        }
    }

    public static void consultarTicketsPorUsuario(int idUsuario) {
        String sql = "SELECT * FROM tickets WHERE id_usuario=?";
        try (Connection conn = ConexionPostgreSQL.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idUsuario);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                System.out.println("Ticket #" + rs.getInt("id_ticket") + ": " +
                        rs.getString("titulo") + " - " +
                        rs.getString("descripcion"));
            }

        } catch (Exception e) {
            System.err.println("❌ Error al consultar tickets por usuario: " + e.getMessage());
        }
    }

    public static void actualizarEstadoTicket(int idTicket, int idNuevoEstado) {
        String sql = "UPDATE tickets SET id_estado=? WHERE id_ticket=?";
        try (Connection conn = ConexionPostgreSQL.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idNuevoEstado);
            pstmt.setInt(2, idTicket);

            int filas = pstmt.executeUpdate();
            if (filas > 0) {
                System.out.println("✅ Estado del ticket actualizado.");
            } else {
                System.out.println("⚠️ Ticket no encontrado.");
            }

        } catch (Exception e) {
            System.err.println("❌ Error al actualizar estado del ticket: " + e.getMessage());
        }
    }

    public static void agregarNotaATicket(int idTicket, int idUsuario, String contenido) {
        String sql = "INSERT INTO notas (contenido, id_ticket, id_usuario) VALUES (?, ?, ?)";
        try (Connection conn = ConexionPostgreSQL.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, contenido);
            pstmt.setInt(2, idTicket);
            pstmt.setInt(3, idUsuario);

            int filas = pstmt.executeUpdate();
            if (filas > 0) {
                System.out.println("📝 Nota agregada correctamente al ticket.");
            }

        } catch (Exception e) {
            System.err.println("❌ Error al agregar nota al ticket: " + e.getMessage());
        }
    }  
    
   
   
  
}
