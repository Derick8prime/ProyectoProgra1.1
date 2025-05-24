/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.util.ArrayList;
import java.util.List;
import main.usuario;

/**
 *
 * @author bachl
 */
public class gestorUsuarios {
    
    
    private List<usuario> usuarios;

    public gestorUsuarios() {
        usuarios = new ArrayList<>();
    }

    public void registrarUsuario(usuario usuario) throws parametrosInvalidosException {
        // Validaciones como las actuales...
        usuarios.add(usuario);
    }

    public usuario buscarPorUsuario(String nombreUsuario) {
        for (usuario u : usuarios) {
            if (u.getNombreUsuario().equals(nombreUsuario)) {
                return u;
            }
        }
        return null;
    }

    public usuario buscarPorEmail(String email) {
        for (usuario u : usuarios) {
            if (u.getCorreo().equalsIgnoreCase(email)) {
                return u;
            }
        }
        return null;
    }

}