package Playlist;

import java.util.List;

import Musicas.Musica;

public class PlaylistPorDuracao extends Playlist {

    public PlaylistPorDuracao(String nome, boolean publica, List<Musica> musicasFiltradas) {
        super(nome, publica);
        this.musicas.addAll(musicasFiltradas);
    }

    @Override
    public String toString() {
        return super.toString() + " | Por duração de música";
    }
}
