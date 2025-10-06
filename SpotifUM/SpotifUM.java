package SpotifUM;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import Album.Album;
import Estatisticas.Estatisticas;
import Musicas.Musica;
import Playlist.Playlist;
import Utilizador.Utilizador;

public class SpotifUM implements Serializable {

    private List<Utilizador> utilizadores;
    private List<Musica> musicas;
    private List<Album> albuns;
    private List<Playlist> playlists;

    public SpotifUM() {
        utilizadores = new ArrayList<>();
        musicas = new ArrayList<>();
        albuns = new ArrayList<>();
        playlists = new ArrayList<>();
    }

    // ---------------------
    // Gestão de Utilizadores
    // ---------------------
    public void adicionarUtilizador(Utilizador u) {
        utilizadores.add(u);
    }

    public Utilizador procurarUtilizador(String nome) {
        return utilizadores.stream()
                .filter(u -> u.getNome().equalsIgnoreCase(nome))
                .findFirst()
                .orElse(null);
    }

    public List<Utilizador> getUtilizadores() {
        return utilizadores;
    }

    // ---------------------
    // Gestão de Músicas
    // ---------------------
    public void adicionarMusica(Musica m) {
        musicas.add(m);
    }

    public Musica procurarMusica(String nome) {
        return musicas.stream()
                .filter(m -> m.getNome().equalsIgnoreCase(nome))
                .findFirst()
                .orElse(null);
    }

    public List<Musica> getMusicas() {
        return musicas;
    }

    // ---------------------
    // Gestão de Álbuns
    // ---------------------
    public void adicionarAlbum(Album album) {
        albuns.add(album);
    }

    public Album procurarAlbum(String titulo) {
        return albuns.stream()
                .filter(a -> a.getTitulo().equalsIgnoreCase(titulo))
                .findFirst()
                .orElse(null);
    }

    public List<Album> getAlbuns() {
        return albuns;
    }

    // ---------------------
    // Gestão de Playlists
    // ---------------------
    public void adicionarPlaylist(Playlist p) {
        playlists.add(p);
    }

    public Playlist procurarPlaylist(String nome) {
        return playlists.stream()
                .filter(p -> p.getNome().equalsIgnoreCase(nome))
                .findFirst()
                .orElse(null);
    }

    public List<Playlist> getPlaylists() {
        return playlists;
    }

    // ---------------------
    // Estatísticas
    // ---------------------
    public Estatisticas gerarEstatisticas() {
        return new Estatisticas(utilizadores, musicas, playlists);
    }

    // ---------------------
    // Serialização
    // ---------------------
    public void guardarEstado(String ficheiro) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ficheiro))) {
            oos.writeObject(this);
        }
    }

    public static SpotifUM carregarEstado(String ficheiro) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ficheiro))) {
            return (SpotifUM) ois.readObject();
        }
    }
}

