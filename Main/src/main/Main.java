/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bachl
 */
@SuppressWarnings("empty-statement")
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    try {
            // Crear un administrador
            administrador admin = new administrador("Laura Admin", "laura@correo.com", "lauraA", "Admin123!");

            // Crear un departamento
            departamento soporte = null;
        try {
            soporte = new departamento("Soporte", "Departamento de soporte técnico");
        } catch (parametrosInvalidosException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

            // Crear un técnico
            tecnico tecnico = new tecnico("Carlos Técnico", "carlos@correo.com", "carlosT", "Clave123!", soporte);
            soporte.asignarTecnico(tecnico);

            // Crear un usuario final
            usuarioFinal usuario = new usuarioFinal("Juan Usuario", "juan@correo.com", "juanU", "Clave123!");

            // Crear estados y flujo de trabajo
            estado pendiente = null;
        try {
            pendiente = new estado("Pendiente", "Ticket recién creado", false);
        } catch (parametrosInvalidosException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
            estado enProceso = null;
        try {
            enProceso = new estado("En Proceso", "Técnico trabajando", false);
        } catch (parametrosInvalidosException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
            estado cerrado = null;
        try {
            cerrado = new estado("Cerrado", "Finalizado", true);
        } catch (parametrosInvalidosException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

            flujoTrabajo flujo = null;
        try {
            flujo = new flujoTrabajo("Flujo Estándar");
        } catch (parametrosInvalidosException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
            flujo.agregarEstado(pendiente);
            flujo.agregarEstado(enProceso);
            flujo.agregarEstado(cerrado);
            flujo.definirTransicion(pendiente, enProceso);
            flujo.definirTransicion(enProceso, cerrado);

            // Crear un ticket
            ticket ticket = null;
        try {
            ticket = new ticket("Error en impresora", "No imprime documentos", "Alta", soporte, usuario, pendiente);
        } catch (parametrosInvalidosException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

            System.out.println("Ticket creado:");
            System.out.println(ticket);

        } 
        catch (parametrosInvalidosException e); {
            System.out.println("Error: " + e.getMessage());
            
        }
    }


