package Musicas;
import java.util.List;

public class MusicaExplicita extends Musica {

    public MusicaExplicita(String nome, String interprete, String editora, String letra, List<String> musicaTexto, Genero genero, int duracao) {
        super(nome, interprete, editora, letra, musicaTexto, genero, duracao);
    }

    @Override
    public boolean isExplicita() {
        return true;
    }

    @Override
    public String toString() {
        return super.toString() + " [EXP]";
    }
}

