package org.example.service;

import org.example.model.Playlist;
import org.example.model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class GerenciarPlaylists {

    private List<Playlist> playlists = new ArrayList<>();

    public void criarPlaylist( String titulo, Usuario usuario) {
        Playlist playlist = new Playlist(titulo, usuario);
        playlists.add(playlist);
        System.out.println("A playlist '" + titulo + "' foi criada com sucesso!");
    }

    public List<Playlist> buscarPlaylistsPorUsuario(Usuario usuario) {

        List<Playlist> playlistsUsuario = new ArrayList<>();

        for (Playlist playlist : playlists) {
            if (playlist.getUsuario().equals(usuario)) {
                playlistsUsuario.add(playlist);
            }
        }

        return playlistsUsuario;
    }

    public void removerPlaylist(Playlist playlist) {

        if (playlist != null) {
            playlists.remove(playlist);
            System.out.println("Playlist '" + playlist.getTitulo() + "' removida com sucesso.");
        } else {
            System.out.println("Playlist não encontrada.");
        }
    }

}
