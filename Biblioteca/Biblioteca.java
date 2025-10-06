
package Biblioteca;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import Album.Album;
import Playlist.Playlist;

public class Biblioteca implements Serializable {
    private List<Album> albuns;
    private List<Playlist> playlists;

    public Biblioteca() {
        this.albuns = new ArrayList<>();
        this.playlists = new ArrayList<>();
    }

    public void adicionarAlbum(Album album) {
        if (!albuns.contains(album)) {
            albuns.add(album);
        }
    }

    public void adicionarPlaylist(Playlist playlist) {
        if (!playlists.contains(playlist)) {
            playlists.add(playlist);
        }
    }

    public List<Album> getAlbuns() {
        return albuns;
    }

    public List<Playlist> getPlaylists() {
        return playlists;
    }

    public Album procurarAlbum(String nome) {
        for (Album a : albuns) {
            if (a.getTitulo().equalsIgnoreCase(nome)) return a;
        }
        return null;
    }

    public Playlist procurarPlaylist(String nome) {
        for (Playlist p : playlists) {
            if (p.getNome().equalsIgnoreCase(nome)) return p;
        }
        return null;
    }
}
