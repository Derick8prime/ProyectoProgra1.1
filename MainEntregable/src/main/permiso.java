/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author bachl
 */
public class permiso {
    private String nombre;
    private String descripcion;

    public permiso(String nombre, String descripcion) throws parametrosInvalidosException {
        setNombre(nombre);
        setDescripcion(descripcion);
    }

    public String getNombre() { return nombre; }

    public void setNombre(String nombre) throws parametrosInvalidosException {
        if (nombre == null || nombre.length() < 3 || nombre.length() > 50) {
            throw new parametrosInvalidosException("El nombre del permiso debe tener entre 3 y 50 caracteres.");
        }
        this.nombre = nombre;
    }

    public String getDescripcion() { return descripcion; }

    public void setDescripcion(String descripcion) throws parametrosInvalidosException {
        if (descripcion == null || descripcion.isEmpty()) {
            throw new parametrosInvalidosException("La descripción del permiso no puede estar vacía.");
        }
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return nombre + " - " + descripcion;
    }
}
