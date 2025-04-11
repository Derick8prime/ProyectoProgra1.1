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
public class estado {
    private String nombre;
    private String descripcion;
    private boolean esFinal;
    private List<estado> siguientes;

    public estado(String nombre, String descripcion, boolean esFinal) throws parametrosInvalidosException {
        setNombre(nombre);
        this.descripcion = descripcion;
        this.esFinal = esFinal;
        this.siguientes = new ArrayList<>();
    }

    public String getNombre() { return nombre; }

    public void setNombre(String nombre) throws parametrosInvalidosException {
        if (nombre == null || nombre.length() < 3 || nombre.length() > 50) {
            throw new parametrosInvalidosException("El nombre del estado debe tener entre 3 y 50 caracteres.");
        }
        this.nombre = nombre;
    }

    public String getDescripcion() { return descripcion; }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean esFinal() { return esFinal; }

    public void setEsFinal(boolean esFinal) {
        this.esFinal = esFinal;
    }

    public List<estado> getSiguientes() { return siguientes; }

    public void agregarTransicion(estado estado) {
        if (!siguientes.contains(estado) && estado != this) {
            siguientes.add(estado);
        }
    }

    public boolean puedeTransicionarA(estado destino) {
        return siguientes.contains(destino);
    }

    @Override
    public String toString() {
        return nombre + (esFinal ? " (Final)" : "");
    }
}
