/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author bachl
 */
public class tecnico extends usuario {

    
    private departamento departamentoAsignado;

    public tecnico(String nombre, String apellido, String correo, String usuario, String contrasena, departamento depto) {
        super(nombre, apellido, correo, usuario, contrasena, "Técnico");
        this.departamentoAsignado = depto;
    }

    public departamento getDepartamentoAsignado() {
        return departamentoAsignado;
    }

    public void setDepartamentoAsignado(departamento departamentoAsignado) {
        this.departamentoAsignado = departamentoAsignado;
    }

    void setDepartamento(departamento aThis) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    Object getDepartamento() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
