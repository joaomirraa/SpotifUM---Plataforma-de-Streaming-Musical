package Playlist;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import Musicas.Musica;
import Utilizador.Utilizador;
import Utilizador.UtilizadorFree;

public abstract class Playlist implements Serializable {
    protected String nome;
    protected List<Musica> musicas;
    protected boolean modoAleatorio;
    private boolean publica;

    public Playlist(String nome, boolean publica) {
        this.nome = nome;
        this.musicas = new ArrayList<>();
        this.modoAleatorio = false;
        this.publica = publica;
    }

    public String getNome() {
        return nome;
    }

    public boolean isPublica() {
        return publica;
    }

    
    public void adicionarMusica(Musica musica) {
        if (!musicas.contains(musica)) {
            musicas.add(musica);
        }
    }

    public void removerMusica(Musica musica) {
        musicas.remove(musica);
    }

    public List<Musica> getMusicas() {
        return Collections.unmodifiableList(musicas);
    }

    public void setModoAleatorio(boolean modoAleatorio) {
        this.modoAleatorio = modoAleatorio;
    }

    public void reproduzir() {
        List<Musica> ordem = new ArrayList<>(musicas);
        if (modoAleatorio) {
            Collections.shuffle(ordem);
        }

        System.out.println("🎧 Reproduzindo playlist: " + nome);
        for (Musica m : ordem) {
            m.reproduzir();
        }
    }

    public Thread reproduzirComControlo(Utilizador utilizador) {
        List<Musica> ordem = new ArrayList<>(musicas);
        if (modoAleatorio) Collections.shuffle(ordem);

        System.out.println("🎧 Reproduzindo playlist com controlo: " + nome);

        final int[] indiceAtual = {0}; // índice mutável
        final boolean[] encerrar = {false};

        Thread player = new Thread(() -> {
            while (indiceAtual[0] < ordem.size() && !encerrar[0]) {
                Musica m = ordem.get(indiceAtual[0]);
                utilizador.reproduzirMusica(m);
                System.out.println("▶ Tocando: " + m.getNome() + " [" + m.getDuracao() + "s]");

                String letra = m.getLetra();
                String[] palavras = letra.split("\\s+");
                long tempoPorPalavra = (m.getDuracao() * 10L) / Math.max(1, palavras.length);

                System.out.print("📄 Letra: ");
                for (String palavra : palavras) {
                    System.out.print(palavra + " ");
                    try {
                        Thread.sleep(tempoPorPalavra);
                    } catch (InterruptedException e) {
                        System.out.println("\n⏭ Música interrompida!");
                        continue;
                    }
                }
                System.out.println();

                long tempoRestante = m.getDuracao() * 25;
                while (tempoRestante > 0 && !Thread.currentThread().isInterrupted()) {
                    try {
                        Thread.sleep(500);
                        tempoRestante -= 500;
                    } catch (InterruptedException e) {
                        break;
                    }
                }

                indiceAtual[0]++;
            }

            if (!encerrar[0]) {
                System.out.println("✅ Playlist terminada.");
            }
        });

        player.start();

        if (!(utilizador instanceof UtilizadorFree)) {
            new Thread(() -> {
                Scanner sc = new Scanner(System.in);
                while (player.isAlive()) {
                    String comando = sc.nextLine().toLowerCase();
                    switch (comando) {
                        case "next" -> {
                            indiceAtual[0]++;
                            player.interrupt();
                        }
                        case "prev" -> {
                            if (indiceAtual[0] > 0) {
                                indiceAtual[0]--;
                                player.interrupt();
                            } else {
                                System.out.println("⚠️ Já estás na primeira música.");
                            }
                        }
                        case "stop" -> {
                            encerrar[0] = true;
                            player.interrupt();
                            System.out.println("⏹ Reprodução terminada.");
                        }
                        default -> System.out.println("Comando inválido. Usa 'next', 'prev' ou 'stop'.");
                    }
                }
            }).start();
        } else {
            System.out.println("⚠️ Utilizadores Free não podem controlar a reprodução.");
        }

    return player;
}

    

    @Override
    public String toString() {
        return nome + " | Nº de músicas: " + musicas.size() + (modoAleatorio ? " (Aleatória)" : "");
    }
}

