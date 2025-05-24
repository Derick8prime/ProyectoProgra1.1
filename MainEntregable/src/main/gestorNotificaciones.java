/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bachl
 */
public class gestorNotificaciones {
    private List<notificacion> notificaciones;

    public gestorNotificaciones() {
        notificaciones = new ArrayList<>();
    }

    public void enviarNotificacion(notificacion notificacion) {
        notificaciones.add(notificacion);
        // Aquí podrías integrar el envío por email o mostrarlo en la interfaz
        System.out.println("Enviando notificación: " + notificacion);
    }

    public List<notificacion> obtenerNotificaciones(usuario usuario) {
        // Filtra notificaciones por usuario receptor
        List<notificacion> resultado = new ArrayList<>();
        for (notificacion n : notificaciones) {
            if (n.getReceptor().equals(usuario)) {
                resultado.add(n);
            }
        }
        return resultado;
    }
}
