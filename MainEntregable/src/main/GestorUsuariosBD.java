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

public class GestorUsuariosBD {
    
    public static void actualizarUsuario(int idUsuario, String nombre, String apellido, String correo, String usuario, String contrasena, String rol) {
        String sql = "UPDATE usuarios SET nombre=?, apellido=?, correo=?, usuario=?, contrasena=?, rol=? WHERE id_usuario=?";
        try (Connection conn = ConexionPostgreSQL.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nombre);
            pstmt.setString(2, apellido);
            pstmt.setString(3, correo);
            pstmt.setString(4, usuario);
            pstmt.setString(5, contrasena);
            pstmt.setString(6, rol);
            pstmt.setInt(7, idUsuario);

            int filas = pstmt.executeUpdate();
            if (filas > 0) {
                System.out.println("✅ Usuario actualizado correctamente.");
            } else {
                System.out.println("⚠️ No se encontró el usuario con ID: " + idUsuario);
            }

        } catch (Exception e) {
            System.err.println("❌ Error al actualizar usuario: " + e.getMessage());
        }
    }

    public static void eliminarUsuario(int idUsuario) {
        String sql = "DELETE FROM usuarios WHERE id_usuario=?";
        try (Connection conn = ConexionPostgreSQL.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idUsuario);
            int filas = pstmt.executeUpdate();
            if (filas > 0) {
                System.out.println("🗑️ Usuario eliminado correctamente.");
            } else {
                System.out.println("⚠️ No se encontró el usuario con ID: " + idUsuario);
            }

        } catch (Exception e) {
            System.err.println("❌ Error al eliminar usuario: " + e.getMessage());
        }
    }
    
    
}
