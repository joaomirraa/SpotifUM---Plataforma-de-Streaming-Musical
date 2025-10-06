package Desenvolvedor;

import java.util.List;

import Album.Album;
import Musicas.Genero;
import Musicas.Musica;
import Musicas.MusicaExplicita;
import Utilizador.Utilizador;

public class Desenvolvedor extends Utilizador {

    public Desenvolvedor(String nome, String email, String morada) {
        super(nome, email, morada);
    }

    @Override
    public void reproduzirMusica(Musica musica) {
        musica.reproduzir();
        this.musicasOuvidas++;
        // desenvolvedor não ganha pontos — ou personaliza aqui
    }

    public Album criarAlbum(String titulo, String artista) {
        return new Album(titulo, artista);
    }

    public Musica criarMusica(String nome, String interprete, String editora, String letra, List<String> texto, Genero genero, int duracao) {
        return new Musica(nome, interprete, editora, letra, texto, genero, duracao);
    }

    public MusicaExplicita criarMusicaExplicita(String nome, String interprete, String editora, String letra, List<String> texto, Genero genero, int duracao) {
        return new MusicaExplicita(nome, interprete, editora, letra, texto, genero, duracao);
    }

    @Override
    public String toString() {
        return super.toString() + " [Desenvolvedor]";
    }
}

