package Utilizador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import Album.Album;
import Biblioteca.Biblioteca;
import Musicas.Musica;
import Playlist.Playlist;

public abstract class Utilizador implements Serializable {
    protected String nome;
    protected String email;
    protected String morada;
    protected int pontos;
    protected int musicasOuvidas;
    protected Biblioteca biblioteca = new Biblioteca();

    public Utilizador(String nome, String email, String morada) {
        this.nome = nome;
        this.email = email;
        this.morada = morada;
        this.pontos = 0;
        this.musicasOuvidas = 0;
    }

    public void adicionarAlbum(Album album) {
        biblioteca.adicionarAlbum(album);
    }

    public void adicionarPlaylist(Playlist playlist) {
        biblioteca.adicionarPlaylist(playlist);
    }

    public abstract void reproduzirMusica(Musica musica);

    public int getPontos() {
        return pontos;
    }

    public String getNome() {
        return nome;
    }

    public List<Playlist> getPlaylists() {
        return biblioteca.getPlaylists();
    }

    public List<Album> getAlbuns() {
        return biblioteca.getAlbuns();
    }

    public Biblioteca getBiblioteca() {
        return biblioteca;
    }

    public int getMusicasOuvidas() {
        return musicasOuvidas;
    }

    @Override
    public String toString() {
        return nome + " (" + email + ") - " + pontos + " pontos";
    }
}

