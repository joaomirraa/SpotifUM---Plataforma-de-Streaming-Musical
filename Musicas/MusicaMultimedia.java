package Musicas;

import java.util.List;

public class MusicaMultimedia extends Musica {
    private String urlVideo;

    public MusicaMultimedia(String nome, String interprete, String editora, String letra, List<String> musicaTexto, Genero genero, int duracao, String urlVideo) {
        super(nome, interprete, editora, letra, musicaTexto, genero, duracao);
        this.urlVideo = urlVideo;
    }

    public String getUrlVideo() {
        return urlVideo;
    }

    @Override
    public boolean isMultimedia() {
        return true;
    }

    @Override
    public String toString() {
        return super.toString() + " [🎬 vídeo disponível]";
    }
}

