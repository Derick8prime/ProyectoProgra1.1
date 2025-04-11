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
public class rol {
    private String nombre;
    private String descripcion;
    private List<permiso> permisos;

    public rol(String nombre) throws parametrosInvalidosException {
        this(nombre, "");
    }

    public rol(String nombre, String descripcion) throws parametrosInvalidosException {
        setNombre(nombre);
        this.descripcion = descripcion;
        this.permisos = new ArrayList<>();
    }

    public String getNombre() { return nombre; }

    public void setNombre(String nombre) throws parametrosInvalidosException {
        if (nombre == null || nombre.length() < 3 || nombre.length() > 50) {
            throw new parametrosInvalidosException("El nombre del rol debe tener entre 3 y 50 caracteres.");
        }
        this.nombre = nombre;
    }

    public String getDescripcion() { return descripcion; }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<permiso> getPermisos() {
        return permisos;
    }

    public void asignarPermiso(permiso permiso) {
        if (!permisos.contains(permiso)) {
            permisos.add(permiso);
        }
    }

    public void eliminarPermiso(permiso permiso) {
        permisos.remove(permiso);
    }

    @Override
    public String toString() {
        return "Rol: " + nombre + " (" + descripcion + ") - Permisos: " + permisos.size();
    }
}
