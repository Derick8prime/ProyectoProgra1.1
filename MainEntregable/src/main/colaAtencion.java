/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author bachl
 */
public class colaAtencion {
     private Queue<ticket> tickets;

    public colaAtencion() {
        tickets = new LinkedList<>();
    }

    public void agregarTicket(ticket ticket) {
         ticket nuevoTicket = null;
        tickets.add(nuevoTicket);
    }

    
    public Queue<ticket> getTickets() {
    return new LinkedList<>(tickets); // Devuelve una copia para evitar modificar la cola real
}
    
    public ticket obtenerSiguienteTicket() {
    return tickets.poll(); // Devuelve null si está vacía
}


    public boolean estaVacia() {
        return tickets.isEmpty();
    }

    public int cantidadTickets() {
    return tickets.size();
}

    public void mostrarTickets() {
        System.out.println("Tickets en cola: " + tickets.size());
        for (ticket t : tickets) {
            System.out.println("- " + t.getTitulo());
        }
    }
}
