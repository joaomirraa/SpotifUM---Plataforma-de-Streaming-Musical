package Musicas;

import java.io.Serializable;
import java.util.List;

public class Musica implements Serializable {
    private String nome;
    private String interprete;
    private String editora;
    private String letra;
    private List<String> musicaTexto; // representação textual das notas/música
    private Genero genero;
    private int duracao; // em segundos
    private int contadorReproducao;

    public Musica(String nome, String interprete, String editora, String letra, List<String> musicaTexto, Genero genero, int duracao) {
        this.nome = nome;
        this.interprete = interprete;
        this.editora = editora;
        this.letra = letra;
        this.musicaTexto = musicaTexto;
        this.genero = genero;
        this.duracao = duracao;
        this.contadorReproducao = 0;
    }

    public void reproduzir() {
        if (isExplicita()) {
            System.out.println("⚠️ AVISO: Esta música contém conteúdo explícito!");
        }

        System.out.println("Reproduzindo: " + nome + " por " + interprete);

        String[] palavras = letra.split("\\s+");
        long tempoPorPalavra = (duracao * 10L) / Math.max(1, palavras.length);

        System.out.print("📄 Letra: ");
        for (String palavra : palavras) {
            System.out.print(palavra + " ");
            try {
                Thread.sleep(tempoPorPalavra);
            } catch (InterruptedException e) {
                System.out.println("\n⏭ Música interrompida!");
                break;
            }
        }
        System.out.println();

        for (String linha : musicaTexto) {
            System.out.println(linha);
        }

        contadorReproducao++;
    }


    public int getContadorReproducao() {
        return contadorReproducao;
    }

    public String getNome() {
        return nome;
    }

    public String getInterprete() {
        return interprete;
    }

    public Genero getGenero() {
        return genero;
    }

    public int getDuracao() {
        return duracao;
    }

    public String getLetra() {
        return letra;
    }

    public boolean isExplicita() {
        return false;
    }

    public boolean isMultimedia() {
        return false;
    }

    @Override
    public String toString() {
        return nome + " - " + interprete + " [" + genero.name() + "] (" + duracao + "s)";
    }
}
