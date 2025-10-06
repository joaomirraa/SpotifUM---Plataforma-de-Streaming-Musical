package Main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Album.Album;
import Desenvolvedor.Desenvolvedor;
import Musicas.Genero;
import Musicas.Musica;
import Plano.PremiumBase;
import Plano.PremiumTop;
import Playlist.PlaylistNormal;
import Playlist.PlaylistPublica;
import SpotifUM.SpotifUM;
import Utilizador.Utilizador;
import Utilizador.UtilizadorFree;
import Utilizador.UtilizadorPremium;

public class GerarDadosIniciais {

    public static void main(String[] args) {
        SpotifUM app = new SpotifUM();

        // Criar desenvolvedor
        Desenvolvedor dev = new Desenvolvedor("AdminDev", "dev@spotifum.com", "Servidor Central");
        app.adicionarUtilizador(dev);

        // Criar álbum
        Album rockAlbum = dev.criarAlbum("Rock Clássico", "The Sound Lords");
        Album popAlbum = dev.criarAlbum("Pop Power", "Nova Popstar");

        // Músicas (normais e explícitas)
        List<String> texto = List.of("♫♫♫", "♪♪♪");
        Musica m1 = dev.criarMusica("Liberdade", "The Sound Lords", "Label X", "Vamos cantar liberdade!", texto, Genero.Rock, 210);
        Musica m2 = dev.criarMusicaExplicita("Rebeldia Total", "The Sound Lords", "Label X", "Letra forte...", texto, Genero.Rock, 190);
        Musica m3 = dev.criarMusica("Dançar até cair", "Nova Popstar", "Label Y", "A noite é nossa!", texto, Genero.Pop, 180);
        Musica m4 = dev.criarMusica("Pop Love", "Nova Popstar", "Label Y", "Amor em cada nota.", texto, Genero.Pop, 200);

        // Adicionar músicas aos álbuns
        rockAlbum.adicionarMusica(m1);
        rockAlbum.adicionarMusica(m2);
        popAlbum.adicionarMusica(m3);
        popAlbum.adicionarMusica(m4);

        // Adicionar ao sistema
        app.adicionarAlbum(rockAlbum);
        app.adicionarAlbum(popAlbum);
        app.adicionarMusica(m1);
        app.adicionarMusica(m2);
        app.adicionarMusica(m3);
        app.adicionarMusica(m4);

        // Criar utilizadores
        Utilizador u1 = new UtilizadorFree("Ana Free", "ana@email.com", "Rua A");
        Utilizador u2 = new UtilizadorPremium("Bruno Premium", "bruno@email.com", "Rua B", new PremiumBase());
        Utilizador u3 = new UtilizadorPremium("Carla Top", "carla@email.com", "Rua C", new PremiumTop());

        app.adicionarUtilizador(u1);
        app.adicionarUtilizador(u2);
        app.adicionarUtilizador(u3);

        // Criar uma playlist pública para o Bruno
        PlaylistNormal playlist1 = new PlaylistNormal("Power Rock", u2.getNome());
        playlist1.adicionarMusica(m1);
        playlist1.adicionarMusica(m2);
        app.adicionarPlaylist(playlist1);
        u2.adicionarPlaylist(playlist1);

        // Guardar o estado
        try {
            app.guardarEstado("spotifum.ser");
            System.out.println("✔ Dados de teste criados com sucesso!");
        } catch (IOException e) {
            System.out.println("❌ Erro ao guardar ficheiro: " + e.getMessage());
        }
    }
}

