/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Scanner;

/**
 *
 * @author bachl
 */

public class Main {


     public static void main(String[] args) {
         
          ejecutarSistemaTickets();
        probarConexionYConsulta(); // Método para probar conexión con BD PostgreSQL
    }

    public static void ejecutarSistemaTickets() {
        try {
            parametrosSistema parametros = new parametrosSistema(
                    "MiEmpresa SAC", "logo.png", "Español", "GMT-5", 30,
                    List.of("Alta", "Media", "Baja")
            );

            estado pendiente = new estado("Pendiente", "Ticket recién creado", false);
            estado enProceso = new estado("En Proceso", "Técnico trabajando", false);
            estado cerrado = new estado("Cerrado", "Finalizado", true);

            departamento soporte = new departamento("Soporte", "Departamento de soporte técnico");

            administrador admin = new administrador("Laura", "Admin", "laura@correo.com", "lauraA", "Admin123!");
            usuarioFinal usuario = new usuarioFinal("Juan", "Usuario", "juan@correo.com", "juanU", "Clave123!");
            tecnico tecnico = new tecnico("Carlos", "Técnico", "carlos@correo.com", "carlosT", "Clave123!", soporte);

            gestorUsuarios gestorUsuarios = new gestorUsuarios();
            gestorUsuarios.registrarUsuario(admin);
            gestorUsuarios.registrarUsuario(usuario);
            gestorUsuarios.registrarUsuario(tecnico);

            ticket nuevoTicket = new ticket(
                    "Problema de red", "No tengo conexión a internet", "Alta", soporte, usuario, pendiente
            );

            System.out.println("Tickets en cola: " + soporte.getColaAtencion().cantidadTickets());

            ticket ticketAtendido = soporte.getColaAtencion().obtenerSiguienteTicket();

            if (ticketAtendido != null) {
                System.out.println("Técnico atiende: " + ticketAtendido.getTitulo());
                ticketAtendido.cambiarEstado(enProceso, "Revisando conexión");
                ticketAtendido.agregarNota(new nota(tecnico, "Se reinició el router"));
                ticketAtendido.cambiarEstado(cerrado, "Problema solucionado");
                System.out.println("Ticket finalizado: " + ticketAtendido.getEstadoActual().getNombre());
            } else {
                System.out.println("No hay tickets disponibles en la cola.");
            }

        } catch (Exception e) {
            System.err.println("❌ Error en la ejecución del sistema: " + e.getMessage());
        }
    }

    public static void probarConexionYConsulta() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConexionPostgreSQL.conectar();
            if (conn != null) {
                System.out.println("✅ Conexión exitosa a la base de datos.");

                String sql = "SELECT id_usuario, nombre, apellido, correo FROM usuarios";
                stmt = (Statement) conn.createStatement();
                rs = stmt.executeQuery(sql);

                System.out.println("📋 Usuarios registrados:");
                while (rs.next()) {
                    int id = rs.getInt("id_usuario");
                    String nombre = rs.getString("nombre");
                    String apellido = rs.getString("apellido");
                    String correo = rs.getString("correo");

                    System.out.println("ID: " + id + ", Nombre: " + nombre + " " + apellido + ", Correo: " + correo);
                }
            }
        } catch (SQLException e) {
            System.err.println("❌ Error al conectar o consultar: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                System.err.println("⚠️ Error cerrando conexión: " + e.getMessage());
            }
        }
        
        
        
    }
    
   
    
    public static void insertarUsuarioDesdeConsola(Scanner scanner) {
    System.out.print("Nombre: ");
    String nombre = scanner.nextLine();
    System.out.print("Apellido: ");
    String apellido = scanner.nextLine();
    System.out.print("Correo: ");
    String correo = scanner.nextLine();
    System.out.print("Usuario: ");
    String usuario = scanner.nextLine();
    System.out.print("Contraseña: ");
    String contrasena = scanner.nextLine();
    System.out.print("Rol: ");
    String rol = scanner.nextLine();

    InsertarUsuario.insertarUsuario(nombre, apellido, correo, usuario, contrasena, rol);
}

public static void actualizarUsuarioDesdeConsola(Scanner scanner) {
    System.out.print("ID del usuario a actualizar: ");
    int id = scanner.nextInt(); scanner.nextLine();
    System.out.print("Nuevo nombre: ");
    String nombre = scanner.nextLine();
    System.out.print("Nuevo apellido: ");
    String apellido = scanner.nextLine();
    System.out.print("Nuevo correo: ");
    String correo = scanner.nextLine();
    System.out.print("Nuevo usuario: ");
    String user = scanner.nextLine();
    System.out.print("Nueva contraseña: ");
    String pass = scanner.nextLine();
    System.out.print("Nuevo rol: ");
    String rol = scanner.nextLine();

    GestorUsuariosBD.actualizarUsuario(id, nombre, apellido, correo, user, pass, rol);
}

public static void eliminarUsuarioDesdeConsola(Scanner scanner) {
    System.out.print("ID del usuario a eliminar: ");
    int id = scanner.nextInt();
    GestorUsuariosBD.eliminarUsuario(id);
}

public static void insertarTicketDesdeConsola(Scanner scanner) {
    System.out.print("Título del ticket: ");
    String titulo = scanner.nextLine();
    System.out.print("Descripción: ");
    String descripcion = scanner.nextLine();
    System.out.print("Prioridad (Alta, Media, Baja): ");
    String prioridad = scanner.nextLine();
    System.out.print("ID departamento: ");
    int idDepto = scanner.nextInt();
    System.out.print("ID usuario creador: ");
    int idUsuario = scanner.nextInt();
    System.out.print("ID técnico asignado: ");
    int idTecnico = scanner.nextInt();
    System.out.print("ID estado inicial: ");
    int idEstado = scanner.nextInt();

    GestorTicketsBD.insertarTicket(titulo, descripcion, prioridad, idDepto, idUsuario, idTecnico, idEstado);
}

public static void consultarTicketsPorUsuario(Scanner scanner) {
    System.out.print("ID del usuario: ");
    int id = scanner.nextInt();
    GestorTicketsBD.consultarTicketsPorUsuario(id);
}

public static void cambiarEstadoTicket(Scanner scanner) {
    System.out.print("ID del ticket: ");
    int id = scanner.nextInt();
    System.out.print("Nuevo ID de estado: ");
    int estado = scanner.nextInt();
    GestorTicketsBD.actualizarEstadoTicket(id, estado);
}

public static void agregarNotaATicket(Scanner scanner) {
    System.out.print("ID del ticket: ");
    int idTicket = scanner.nextInt();
    System.out.print("ID del usuario que escribe la nota: ");
    int idUsuario = scanner.nextInt();
    scanner.nextLine(); // limpiar buffer
    System.out.print("Contenido de la nota: ");
    String contenido = scanner.nextLine();

    GestorTicketsBD.agregarNotaATicket(idTicket, idUsuario, contenido);
}

public static void buscarTicketsPorPrioridad(Scanner scanner) {
    System.out.print("Prioridad (Alta, Media, Baja): ");
    String prioridad = scanner.nextLine();
    FiltrosTicketsBD.buscarTicketsPorPrioridad(prioridad);
}

public static void buscarTicketsPorEstado(Scanner scanner) {
    System.out.print("ID del estado: ");
    int estado = scanner.nextInt();
    FiltrosTicketsBD.buscarTicketsPorEstado(estado);
}

public static void listarTicketsPorDepartamento(Scanner scanner) {
    System.out.print("ID del departamento: ");
    int id = scanner.nextInt();
    FiltrosTicketsBD.listarTicketsPorDepartamento(id);
}

    
    
         
     }
        
    


