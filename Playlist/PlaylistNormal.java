package Playlist;

import java.util.List;
import Musicas.Musica;

public class PlaylistNormal extends Playlist {

    private String autor;

    public PlaylistNormal(String nome, String autor) {
        super(nome, false);
        this.autor = autor;
    }

    public String getAutor() {
        return autor;
    }

    @Override
    public String toString() {
        return super.toString() + (isPublica() ? " [Pública por: " + autor + "]" : " [Privada]");
    }
}

