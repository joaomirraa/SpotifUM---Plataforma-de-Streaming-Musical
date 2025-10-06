package Musicas;

import java.util.ArrayList;
import java.util.List;

public class BuscadorDeMusicas {

    private List<Musica> todasAsMusicas;

    public BuscadorDeMusicas(List<Musica> musicas) {
        this.todasAsMusicas = musicas;
    }

    public List<Musica> buscarPorGenero(Genero genero) {
        List<Musica> resultado = new ArrayList<>();
        for (Musica m : todasAsMusicas) {
            if (m.getGenero() == genero) {
                resultado.add(m);
            }
        }
        return resultado;
    }

    public List<Musica> buscarPorDuracaoMaxima(int segundos) {
        List<Musica> resultado = new ArrayList<>();
        for (Musica m : todasAsMusicas) {
            if (m.getDuracao() <= segundos) {
                resultado.add(m);
            }
        }
        return resultado;
    }

    public List<Musica> buscarExplicitas() {
        List<Musica> resultado = new ArrayList<>();
        for (Musica m : todasAsMusicas) {
            if (m.isExplicita()) {
                resultado.add(m);
            }
        }
        return resultado;
    }

    public List<Musica> buscarPorInterprete(String nome) {
        List<Musica> resultado = new ArrayList<>();
        for (Musica m : todasAsMusicas) {
            if (m.getInterprete().equalsIgnoreCase(nome)) {
                resultado.add(m);
            }
        }
        return resultado;
    }

    public List<Musica> buscarPorMultiplosFiltros(Genero genero, int duracaoMaxima, boolean explicita) {
        List<Musica> resultado = new ArrayList<>();
        for (Musica m : todasAsMusicas) {
            boolean passa = true;
            
            // Filtro por género (se não for null)
            if (genero != null && m.getGenero() != genero) {
                passa = false;
            }
            if (duracaoMaxima > 0 && m.getDuracao() > duracaoMaxima) {
                passa = false;
            }
            if (explicita && !m.isExplicita()) {
                passa = false;
            }
            if (passa) resultado.add(m);
        }
        return resultado;
    }
}

