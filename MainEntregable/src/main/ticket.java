/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bachl
 */
public class ticket {
     private static int contador = 1;

    private int numero;
    private String titulo;
    private String descripcion;
    private String prioridad;
    private departamento departamentoAsignado;
    private estado estadoActual;
    private usuarioFinal creador;
    private tecnico tecnicoAsignado;
    private LocalDateTime fechaCreacion;
    private List<nota> notas;

    public ticket(String titulo, String descripcion, String prioridad,
                  departamento departamentoAsignado, usuarioFinal creador, estado estadoInicial)
            throws parametrosInvalidosException {

        setTitulo(titulo);
        setDescripcion(descripcion);
        setPrioridad(prioridad);

        this.numero = contador++;
        this.departamentoAsignado = departamentoAsignado;
        this.creador = creador;
        this.estadoActual = estadoInicial;
        this.fechaCreacion = LocalDateTime.now();
        this.notas = new ArrayList<>();

        if (departamentoAsignado != null && departamentoAsignado.getColaAtencion() != null) {
            departamentoAsignado.getColaAtencion().agregarTicket(this);
            System.out.println("Ticket creado y agregado a la cola: " + this.titulo);
        } else {
            System.err.println("Error: departamento o cola es null al crear el ticket.");
        }
    }

    public int getNumero() { return numero; }

    public String getTitulo() { return titulo; }

    public void setTitulo(String titulo) throws parametrosInvalidosException {
        if (titulo == null || titulo.length() < 3 || titulo.length() > 100) {
            throw new parametrosInvalidosException("El título debe tener entre 3 y 100 caracteres.");
        }
        this.titulo = titulo;
    }

    public String getDescripcion() { return descripcion; }

    public void setDescripcion(String descripcion) throws parametrosInvalidosException {
        if (descripcion == null || descripcion.isEmpty()) {
            throw new parametrosInvalidosException("La descripción no puede estar vacía.");
        }
        this.descripcion = descripcion;
    }

    public String getPrioridad() { return prioridad; }

    public void setPrioridad(String prioridad) throws parametrosInvalidosException {
        if (prioridad == null || prioridad.isEmpty()) {
            throw new parametrosInvalidosException("La prioridad no puede estar vacía.");
        }
        this.prioridad = prioridad;
    }

    public estado getEstadoActual() {
        return estadoActual;
    }

    public void cambiarEstado(estado nuevoEstado, String comentario) throws parametrosInvalidosException {
        if (nuevoEstado == null) {
            throw new parametrosInvalidosException("El estado no puede ser nulo.");
        }
        if (comentario == null || comentario.isEmpty()) {
            throw new parametrosInvalidosException("Debe ingresar un comentario para el cambio de estado.");
        }

        this.estadoActual = nuevoEstado;
        this.agregarNota(new nota(creador, "Cambio de estado a '" + nuevoEstado.getNombre() + "': " + comentario));
    }

    public void agregarNota(nota nuevaNota) {
        this.notas.add(nuevaNota);
    }
}
