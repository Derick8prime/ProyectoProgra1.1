/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author bachl
 */
public class flujoTrabajo {
    private String nombre;
    private List<estado> estados;
    private Map<estado, List<estado>> transiciones; // De qué estado a cuáles puede ir
    private Map<String, String> reglasTransicion;   // Opcional
    private Map<String, String> accionesAutomaticas; // Opcional

    public flujoTrabajo(String nombre) throws parametrosInvalidosException {
        setNombre(nombre);
        this.estados = new ArrayList<>();
        this.transiciones = new HashMap<>();
        this.reglasTransicion = new HashMap<>();
        this.accionesAutomaticas = new HashMap<>();
    }

    public String getNombre() { return nombre; }

    public void setNombre(String nombre) throws parametrosInvalidosException {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new parametrosInvalidosException("El nombre del flujo de trabajo no puede estar vacío.");
        }
        this.nombre = nombre;
    }

    public void agregarEstado(estado estado) {
        if (!estados.contains(estado)) {
            estados.add(estado);
            transiciones.put(estado, new ArrayList<>());
        }
    }

    public void definirTransicion(estado desde, estado hacia) {
        if (!estados.contains(desde) || !estados.contains(hacia)) return;

        if (!transiciones.get(desde).contains(hacia)) {
            transiciones.get(desde).add(hacia);
        }
    }

    public boolean esTransicionValida(estado desde, estado hacia) {
        return transiciones.containsKey(desde) && transiciones.get(desde).contains(hacia);
    }

    public void agregarRegla(String descripcion, String condicion) {
        reglasTransicion.put(descripcion, condicion);
    }

    public void agregarAccionAutomatica(String evento, String accion) {
        accionesAutomaticas.put(evento, accion);
    }

    public void mostrarFlujo() {
        System.out.println("Flujo de Trabajo: " + nombre);
        for (estado estado : estados) {
            System.out.println("Estado: " + estado);
            for (estado siguiente : transiciones.get(estado)) {
                System.out.println("  → Puede ir a: " + siguiente);
            }
        }
    }
}
