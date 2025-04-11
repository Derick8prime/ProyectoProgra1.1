/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author bachl
 */
public class nota {
    private usuario autor;
    private String contenido;

    public nota(usuario autor, String contenido) throws parametrosInvalidosException {
        if (contenido == null || contenido.isEmpty()) {
            throw new parametrosInvalidosException("La nota no puede estar vacía.");
        }
        this.autor = autor;
        this.contenido = contenido;
    }

    public usuario getAutor() { return autor; }
    public String getContenido() { return contenido; }

    @Override
    public String toString() {
        return autor.getNombreCompleto() + ": " + contenido;
    }
}
