package Utilizador;

import Musicas.Musica;

public class UtilizadorFree extends Utilizador {

    public UtilizadorFree(String nome, String email, String morada) {
        super(nome, email, morada);
    }

    @Override
    public void reproduzirMusica(Musica musica) {
        musica.reproduzir();
        this.musicasOuvidas++;
        pontos += 5;
    }
}

