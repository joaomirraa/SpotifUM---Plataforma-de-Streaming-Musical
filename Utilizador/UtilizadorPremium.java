package Utilizador;

import Musicas.Musica;
import Plano.PlanoSubscricao;
import Plano.PremiumTop;

public class UtilizadorPremium extends Utilizador {
    private PlanoSubscricao plano;

    public UtilizadorPremium(String nome, String email, String morada, PlanoSubscricao plano) {
        super(nome, email, morada);
        this.plano = plano;
            if (plano instanceof PremiumTop) {
                this.pontos = 100;
            }
        
    }
    
    @Override
    public void reproduzirMusica(Musica musica) {
        musica.reproduzir();
        pontos = plano.calcularPontos(pontos);
        this.musicasOuvidas++;
    }

    public boolean podeCriarPlaylists() {
        return plano.podeCriarPlaylists();
    }

    public boolean podeVerFavoritos() {
        return plano.podeTerFavoritos();
    }

    public PlanoSubscricao getPlano() {
        return plano;
    }

    @Override
    public String toString() {
        return super.toString() + " [Premium]";
    }
}

