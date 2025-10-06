package Playlist;

import java.util.List;

import Musicas.Musica;

public class PlaylistFavoritos extends Playlist {

    public PlaylistFavoritos(String nome, boolean publica, List<Musica> favoritas) {
        super(nome, publica);
        this.musicas.addAll(favoritas);
    }

    @Override
    public String toString() {
        return super.toString() + " | Gerada automaticamente (Favoritos)";
    }
}

