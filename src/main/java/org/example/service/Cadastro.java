package org.example.service;

import org.example.model.Usuario;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cadastro {

    Set<Usuario> usuarios = new HashSet<>();

    public void cadastrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public Set<Usuario> getUsuarios() {
        return usuarios;
    }
}
