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

        departamentoAsignado.getColaAtencion().agregarTicket(this); // va a la cola
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
        if (!prioridad.equals("Alta") && !prioridad.equals("Media") && !prioridad.equals("Baja")) {
            throw new parametrosInvalidosException("Prioridad inválida. Debe ser Alta, Media o Baja.");
        }
        this.prioridad = prioridad;
    }

    public departamento getDepartamentoAsignado() { return departamentoAsignado; }
    public usuarioFinal getCreador() { return creador; }

    public tecnico getTecnicoAsignado() { return tecnicoAsignado; }

    public void asignarTecnico(tecnico tecnico) {
        this.tecnicoAsignado = tecnico;
    }

    public estado getEstadoActual() { return estadoActual; }

    public void cambiarEstado(estado nuevoEstado, flujoTrabajo flujo) throws parametrosInvalidosException {
        if (!flujo.esTransicionValida(this.estadoActual, nuevoEstado)) {
            throw new parametrosInvalidosException("No se puede cambiar al estado '" + nuevoEstado.getNombre() + "'. Transición no válida.");
        }
        this.estadoActual = nuevoEstado;
    }

    public LocalDateTime getFechaCreacion() { return fechaCreacion; }

    public void agregarNota(nota nota) {
        notas.add(nota);
    }

    public List<nota> getNotas() {
        return notas;
    }

    @Override
    public String toString() {
        return "[#" + numero + "] " + titulo + " (" + prioridad + ") - Estado: " + estadoActual;
    }
}
