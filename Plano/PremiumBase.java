package Plano;

import java.io.Serializable;

public class PremiumBase implements PlanoSubscricao, Serializable {

    @Override
    public int calcularPontos(int pontosAtuais) {
        return pontosAtuais + 10;
    }

    @Override
    public boolean podeCriarPlaylists() {
        return true;
    }

    @Override
    public boolean podeTerFavoritos() {
        return false;
    }
}

