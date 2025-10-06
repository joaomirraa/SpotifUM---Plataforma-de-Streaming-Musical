package Playlist;

import java.util.List;

import Musicas.Musica;

public class PlaylistExplicita extends Playlist {

    public PlaylistExplicita(String nome, boolean publica, List<Musica> candidatas) {
        super(nome, publica);
        for (Musica m : candidatas) {
            if (m.isExplicita()) {
                musicas.add(m);
            }
        }
    }

    @Override
    public String toString() {
        return super.toString() + " | Apenas músicas explícitas";
    }
}

