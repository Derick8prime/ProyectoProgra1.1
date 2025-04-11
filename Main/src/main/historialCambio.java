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
public class historialCambio {
    
    private String cambio;
    private usuario usuario;
    private LocalDateTime fechaHora;
    private String descripcion;
    private String adjunto;

    public historialCambio(String cambio, usuario usuario, String descripcion, String adjunto) {
        this.cambio = cambio;
        this.usuario = usuario;
        this.fechaHora = LocalDateTime.now();
        this.descripcion = descripcion;
        this.adjunto = adjunto;
    }

    public String getCambio() { return cambio; }
    public usuario getUsuario() { return usuario; }
    public LocalDateTime getFechaHora() { return fechaHora; }
    public String getDescripcion() { return descripcion; }
    public String getAdjunto() { return adjunto; }

    @Override
    public String toString() {
        return "Cambio: " + cambio + " | Usuario: " + usuario.getNombreCompleto() + " | Fecha: " + fechaHora
                + " | Descripción: " + descripcion + (adjunto != null ? " | Adjunto: " + adjunto : "");
    }
}
