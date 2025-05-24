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
public class ticketConHistorial {
    private List<historialCambio> historial;

    public ticketConHistorial(String titulo, String descripcion, String prioridad, departamento departamentoAsignado,
                              usuarioFinal creador, estado estadoInicial) throws parametrosInvalidosException {
        super(titulo, descripcion, prioridad, departamentoAsignado, creador, estadoInicial);
        historial = new ArrayList<>();
    }

    public void agregarHistorial(String cambio, usuario usuario, String descripcion, String adjunto) {
        historial.add(new historialCambio(cambio, usuario, descripcion, adjunto));
    }

    public List<historialCambio> getHistorial() {
        return historial;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("\nHistorial de Cambios:");
        for (historialCambio h : historial) {
            sb.append("\n- ").append(h);
        }
        return sb.toString();
    }
}
