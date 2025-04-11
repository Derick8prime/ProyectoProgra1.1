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
public class gestorUsuarios {
    private List<Usuario> usuarios;

    public gestorUsuarios() {
        usuarios = new ArrayList<>();
    }

    public void registrarUsuario(usuario usuario) throws parametrosInvalidosException {
        // Validaciones básicas
        if (usuario.getNombreCompleto().length() < 3 || usuario.getNombreCompleto().length() > 100) {
            throw new parametrosInvalidosException("Nombre completo inválido.");
        }

        if (!ValidadorUsuario.correoValido(usuario.getEmail())) {
            throw new parametrosInvalidosException("Correo electrónico no válido.");
        }

        if (buscarPorEmail(usuario.getEmail()) != null) {
            throw new parametrosInvalidosException("El correo ya está registrado.");
        }

        if (usuario.getNombreUsuario().length() < 5 || usuario.getNombreUsuario().length() > 30) {
            throw new parametrosInvalidosException("El nombre de usuario debe tener entre 5 y 30 caracteres.");
        }

        if (buscarPorUsuario(usuario.getNombreUsuario()) != null) {
            throw new parametrosInvalidosException("El nombre de usuario ya existe.");
        }

        if (!ValidadorUsuario.contrasenaSegura(usuario.getContrasena())) {
            throw new parametrosInvalidosException("La contraseña no cumple con los requisitos de seguridad.");
        }

        usuarios.add(usuario);
        System.out.println("Usuario registrado correctamente: " + usuario.getNombreUsuario());
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
            if (u.getEmail().equals(email)) {
                return u;
            }
        }
        return null;
    }

    public List<usuario> getUsuarios() {
        return usuarios;
    }
}
