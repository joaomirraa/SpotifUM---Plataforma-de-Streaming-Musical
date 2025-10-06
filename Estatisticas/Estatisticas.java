package Estatisticas;

import java.io.Serializable;
import java.util.*;

import Musicas.Genero;
import Musicas.Musica;
import Playlist.Playlist;
import Playlist.PlaylistPublica;
import Utilizador.Utilizador;

public class Estatisticas implements Serializable {

    private List<Utilizador> utilizadores;
    private List<Musica> musicas;
    private List<Playlist> playlists;

    public Estatisticas(List<Utilizador> utilizadores, List<Musica> musicas, List<Playlist> playlists) {
        this.utilizadores = utilizadores;
        this.musicas = musicas;
        this.playlists = playlists;
    }

    public Musica musicaMaisReproduzida() {
        return musicas.stream()
                .max(Comparator.comparingInt(Musica::getContadorReproducao))
                .orElse(null);
    }

    public String interpreteMaisEscutado() {
        Map<String, Integer> contagem = new HashMap<>();

        for (Musica m : musicas) {
            contagem.put(m.getInterprete(), contagem.getOrDefault(m.getInterprete(), 0) + m.getContadorReproducao());
        }

        return contagem.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    public Utilizador utilizadorMaisAtivo() {
        return utilizadores.stream()
                .max(Comparator.comparingInt(u -> u.getPlaylists().stream()
                        .mapToInt(p -> p.getMusicas().stream().mapToInt(Musica::getContadorReproducao).sum()).sum()))
                .orElse(null);
    }

    public Utilizador utilizadorComMaisPontos() {
        return utilizadores.stream()
                .max(Comparator.comparingInt(Utilizador::getPontos))
                .orElse(null);
    }

    // Método para encontrar o género mais popular
    public Genero generoMaisPopular() {
        // Mapa para contar as reproduções por género
        Map<Genero, Integer> contagem = new HashMap<>();

        // Percorrer todas as músicas e somar as reproduções por género
        for (Musica m : musicas) {
            Genero genero = m.getGenero();
            int reproducoesAtuais = contagem.getOrDefault(genero, 0);
            contagem.put(genero, reproducoesAtuais + m.getContadorReproducao());
        }

        // Encontrar o género com mais reproduções
        Genero maisPopular = null;
        int maxReproducoes = -1;

        for (Map.Entry<Genero, Integer> entry : contagem.entrySet()) {
            if (entry.getValue() > maxReproducoes) {
                maxReproducoes = entry.getValue();
                maisPopular = entry.getKey();
            }
        }

        return maisPopular;
    }

    public long numeroPlaylistsPublicas() {
        return playlists.stream()
                .filter(p -> p instanceof PlaylistPublica)
                .count();
    }

    public Utilizador utilizadorComMaisPlaylists() {
        return utilizadores.stream()
                .max(Comparator.comparingInt(u -> u.getPlaylists().size()))
                .orElse(null);
    }

    public Utilizador utilizadorQueMaisOuviu() {
        return utilizadores.stream()
            .max(Comparator.comparingInt(Utilizador::getMusicasOuvidas))
            .orElse(null);
    }
    
    
}
