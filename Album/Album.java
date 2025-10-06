package Album;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import Musicas.Musica;

public class Album implements Serializable {
    private String titulo;
    private String artista;
    private List<Musica> musicas;

    public Album(String titulo, String artista) {
        this.titulo = titulo;
        this.artista = artista;
        this.musicas = new ArrayList<>();
    }

    public String getTitulo() {
        return titulo;
    }

    public String getArtista() {
        return artista;
    }

    public List<Musica> getMusicas() {
        return Collections.unmodifiableList(musicas); // protege a lista original
    }

    public void adicionarMusica(Musica musica) {
        if (!musicas.contains(musica)) {
            musicas.add(musica);
        }
    }

    public void removerMusica(Musica musica) {
        musicas.remove(musica);
    }

    public Musica getMusicaPorNome(String nome) {
        for (Musica m : musicas) {
            if (m.getNome().equalsIgnoreCase(nome)) {
                return m;
            }
        }
        return null;
    }

    public int getDuracaoTotal() {
        int total = 0;
        for (Musica m : musicas) {
            total += m.getDuracao();
        }
        return total;
    }

    @Override
    public String toString() {
        return "Álbum: " + titulo + " | Artista: " + artista + " | Nº de Músicas: " + musicas.size();
    }
}

