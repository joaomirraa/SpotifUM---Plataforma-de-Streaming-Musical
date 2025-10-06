package Playlist;

public class PlaylistPublica extends Playlist {
    private String autor; 

    public PlaylistPublica(String nome, String autor) {
        super(nome, true);
        this.autor = autor;
    }

    public String getAutor() {
        return autor;
    }

    @Override
    public String toString() {
        return super.toString() + " | Pública por: " + autor;
    }
}
