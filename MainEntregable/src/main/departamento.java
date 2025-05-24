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
public class departamento {
    private String nombre;
    private String descripcion;
    private List<tecnico> tecnicos;
    private colaAtencion colaAtencion; // Cola automática

    public departamento(String nombre, String descripcion) throws parametrosInvalidosException {
        setNombre(nombre);
        this.descripcion = descripcion;
        this.tecnicos = new ArrayList<>();
        this.colaAtencion = new colaAtencion(); // Se crea automáticamente
    }

    public String getNombre() { return nombre; }

    public void setNombre(String nombre) throws parametrosInvalidosException {
        this.colaAtencion = new colaAtencion();
        if (nombre == null || nombre.length() < 3 || nombre.length() > 50) {
            throw new parametrosInvalidosException("El nombre del departamento debe tener entre 3 y 50 caracteres.");
        }
        this.nombre = nombre;
    }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public List<tecnico> getTecnicos() { return tecnicos; }

    public void asignarTecnico(tecnico tecnico) {
        if (!tecnicos.contains(tecnico)) {
            tecnicos.add(tecnico);
            tecnico.setDepartamento(this);
        }
    }

    public void eliminarTecnico(tecnico tecnico) {
        tecnicos.remove(tecnico);
        tecnico.setDepartamento(null);
    }

    public colaAtencion getColaAtencion() {
        this.colaAtencion = new colaAtencion();

        return colaAtencion;
    }

    @Override
    public String toString() {
        return "Departamento: " + nombre + ", Técnicos: " + tecnicos.size();
    }
}
