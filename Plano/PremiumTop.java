package Plano;

import java.io.Serializable;

public class PremiumTop implements PlanoSubscricao, Serializable {

    @Override
    public int calcularPontos(int pontosAtuais) {
        return pontosAtuais + (int)(pontosAtuais * 0.025); // +2.5%
    }

    @Override
    public boolean podeCriarPlaylists() {
        return true;
    }

    @Override
    public boolean podeTerFavoritos() {
        return true;
    }
}

