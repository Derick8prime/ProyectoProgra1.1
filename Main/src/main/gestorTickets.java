/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 *
 * @author bachl
 */
public class gestorTickets {
    private List<ticket> tickets;

    public gestorTickets() {
        tickets = new ArrayList<>();
    }

    public void agregarTicket(ticket ticket) {
        tickets.add(ticket);
    }

    public List<ticket> filtrarTicketsPorEstado(String estado, usuario usuario) {
        // Filtra tickets dependiendo del rol del usuario
        return tickets.stream()
                .filter(new Predicate<ticket>() {
            @Override
            public boolean test(ticket ticket) {
                if (!(usuario instanceof usuarioFinal)) if (usuario instanceof tecnico) {
                    return ((tecnico) usuario).getDepartamento().equals(ticket.getDepartamentoAsignado())
                            && ticket.getEstadoActual().getNombre().equals(estado);
                } else if (usuario instanceof administrador) {
                    return ticket.getEstadoActual().getNombre().equals(estado);
                } else {
                    return ticket.getCreador().equals(usuario) && ticket.getEstadoActual().getNombre().equals(estado);
                } else {
                }
                return false;
            }
        })
                .collect(Collectors.toList());
    }

    public List<ticket> filtrarTicketsPorPrioridad(String prioridad, usuario usuario) {
        // Filtra tickets por prioridad
        return tickets.stream()
                .filter(ticket -> ticket.getPrioridad().equals(prioridad))
                .collect(Collectors.toList());
    }

    public List<ticket> verTickets(Usuario usuario) {
        if (usuario instanceof usuarioFinal) {
            return tickets.stream()
                    .filter(ticket -> ticket.getCreador().equals(usuario))
                    .collect(Collectors.toList());
        } else if (usuario instanceof tecnico) {
            return tickets.stream()
                    .filter(ticket -> ticket.getDepartamentoAsignado().equals(((tecnico) usuario).getDepartamento()))
                    .collect(Collectors.toList());
        } else if (usuario instanceof administrador) {
            return tickets; // El administrador puede ver todos los tickets
        }
        return new ArrayList<>();
    }
}
