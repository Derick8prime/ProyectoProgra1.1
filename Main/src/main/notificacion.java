/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.time.LocalDateTime;

/**
 *
 * @author bachl
 */
public class notificacion {
    private String mensaje;
    private LocalDateTime fechaHora;
    private usuario receptor;
    private String tipo;  // Email, Sistema, etc.

    public notificacion(String mensaje, usuario receptor, String tipo) {
        this.mensaje = mensaje;
        this.receptor = receptor;
        this.fechaHora = LocalDateTime.now();
        this.tipo = tipo;
    }

    public String getMensaje() { return mensaje; }
    public LocalDateTime getFechaHora() { return fechaHora; }
    public usuario getReceptor() { return receptor; }
    public String getTipo() { return tipo; }

    @Override
    public String toString() {
        return "Notificación para " + receptor.getNombreCompleto() + ": " + mensaje + " | Fecha: " + fechaHora;
    }
}
