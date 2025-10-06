package Main;

import java.io.IOException;
import java.util.*;

import Album.Album;
import Desenvolvedor.Desenvolvedor;
import Estatisticas.Estatisticas;
import Musicas.BuscadorDeMusicas;
import Musicas.Genero;
import Musicas.Musica;
import Plano.PremiumBase;
import Plano.PremiumTop;
import Playlist.Playlist;
import Playlist.PlaylistExplicita;
import Playlist.PlaylistFavoritos;
import Playlist.PlaylistPorDuracao;
import Playlist.PlaylistPublica;
import SpotifUM.SpotifUM;
import Utilizador.Utilizador;
import Utilizador.UtilizadorFree;
import Utilizador.UtilizadorPremium;

public class MenuSpotifUM {

    private static final Scanner scanner = new Scanner(System.in);
    private SpotifUM app;
    private Utilizador utilizadorAtual = null;

    public MenuSpotifUM() {
        try {
            this.app = SpotifUM.carregarEstado("spotifum.txt");
            System.out.println("Estado carregado com sucesso!");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Não foi possível carregar o estado. Iniciando sistema vazio.");
            this.app = new SpotifUM();
        }
    }

    public void iniciar() {
        menuPrincipal();
    }

    private void menuPrincipal() {
        boolean sair = false;
        while (!sair) {
            System.out.println("\n🎵 SpotifUM - Menu Principal 🎵");
            System.out.println("1. Criar Utilizador");
            System.out.println("2. Login Utilizador");
            System.out.println("3. Guardar Estado");
            System.out.println("4. Carregar Estado");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // limpar buffer

            switch (opcao) {
                case 1 -> criarUtilizador();
                case 2 -> login();
                case 3 -> guardarEstado();
                case 4 -> carregarEstado();
                case 0 -> sair = true;
                default -> System.out.println("Opção inválida.");
            }
        }
        System.out.println("Até à próxima! 🎧");
    }

    private void menuUtilizador() {
        boolean sair = false;
        while (!sair) {
            System.out.println("\n🎶 Menu Utilizador 🎶");
            System.out.println("1. Reproduzir Música");
            System.out.println("2. Reproduzir Playlist");
            System.out.println("3. Reproduzir Álbum");
            System.out.println("4. Ver Estatísticas");
            if (utilizadorAtual instanceof UtilizadorPremium premium && premium.podeCriarPlaylists() || utilizadorAtual instanceof Desenvolvedor) {
                    System.out.println("5. Gerar Playlist com Filtros");
                    System.out.println("6. Criar Playlist");
            }
            System.out.println("7. Ver a minha Biblioteca");
            if (utilizadorAtual instanceof Desenvolvedor) {
                System.out.println("8. Adicionar Música / Álbum");
            }
            System.out.println("0. Logout");
            System.out.print("Escolha: ");
    
            int opcao = scanner.nextInt();
            scanner.nextLine();
    
            switch (opcao) {
                case 1 -> reproduzirMusica();
                case 2 -> {
                    System.out.println("Qual o nome da playlist?");
                    String nomePlaylist = scanner.nextLine();

                    Playlist playlistEscolhida = app.getPlaylists().stream()
                        .filter(p -> p.getNome().equalsIgnoreCase(nomePlaylist))
                        .findFirst()
                        .orElse(null);

                    if (playlistEscolhida != null) {
                        boolean podeReproduzir = playlistEscolhida.isPublica();

                        // Verifica se é pública ou se o utilizador atual é o autor (no caso de PlaylistPublica)
                        if (!podeReproduzir && playlistEscolhida instanceof PlaylistPublica pp) {
                            podeReproduzir = pp.getAutor().equalsIgnoreCase(utilizadorAtual.getNome());
                        }

                        if (podeReproduzir) {
                            Thread t = playlistEscolhida.reproduzirComControlo(utilizadorAtual);
                            try {
                                t.join(); // Espera a reprodução terminar
                            } catch (InterruptedException e) {
                                System.out.println("❌ Reprodução interrompida.");
                            }
                        } else {
                            System.out.println("❌ Não tens permissão para reproduzir esta playlist privada.");
                        }
                    } else {
                        System.out.println("❌ Playlist não encontrada.");
                    }
                    break;
                }
                case 3 -> {
                    List<Album> albuns = utilizadorAtual.getBiblioteca().getAlbuns();
                    if (albuns.isEmpty()) {
                        System.out.println("A tua biblioteca não tem álbuns.");
                        break;
                    }

                    System.out.println("🎼 Álbuns disponíveis:");
                    for (int i = 0; i < albuns.size(); i++) {
                        System.out.println((i + 1) + ". " + albuns.get(i).getTitulo());
                    }

                    System.out.print("Escolhe o número do álbum para reproduzir: ");
                    int escolha = scanner.nextInt();
                    scanner.nextLine();

                    if (escolha < 1 || escolha > albuns.size()) {
                        System.out.println("Escolha inválida.");
                        break;
                    }

                    Album album = albuns.get(escolha - 1);
                    List<Musica> musicas = album.getMusicas();

                    if (musicas.isEmpty()) {
                        System.out.println("Este álbum não tem músicas.");
                        break;
                    }

                    // Criar uma "playlist temporária" para aproveitar reproduzirComControlo()
                    Playlist playlistDoAlbum = new Playlist(album.getTitulo(), false) {};

                    for (Musica m : musicas) {
                        playlistDoAlbum.adicionarMusica(m);
                    }

                    playlistDoAlbum.setModoAleatorio(false); // se quiseres modo aleatório, podes perguntar ao utilizador
                    Thread t = playlistDoAlbum.reproduzirComControlo(utilizadorAtual);
                    try {
                        t.join();
                    } catch (InterruptedException e) {
                        System.out.println("❌ Reprodução interrompida.");
                    }
                    break;
                }
                case 4 -> mostrarEstatisticas();
                case 5 -> {
                    if (utilizadorAtual instanceof UtilizadorPremium premium && premium.podeCriarPlaylists() || utilizadorAtual instanceof Desenvolvedor)
                        gerarPlaylistComFiltros();
                    else
                        System.out.println("Opção inválida.");
                }
                case 6 -> {
                    if (utilizadorAtual instanceof UtilizadorPremium premium && premium.podeCriarPlaylists() || utilizadorAtual instanceof Desenvolvedor)
                        criarPlaylist();
                    else
                        System.out.println("Opção inválida.");
                }
                case 7 -> menuBiblioteca();
                case 8 -> adicionarMusicaOuAlbum();
                case 0 -> sair = true;
                default -> System.out.println("Opção inválida.");
            }
        }
        utilizadorAtual = null;
    }    

    private void criarUtilizador() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Morada: ");
        String morada = scanner.nextLine();

        System.out.println("Tipo de utilizador:");
        System.out.println("1. Free");
        System.out.println("2. PremiumBase");
        System.out.println("3. PremiumTop");
        System.out.println("4. Desenvolvedor");
        int tipo = scanner.nextInt();
        scanner.nextLine();

        Utilizador u;
        switch (tipo) {
            case 1 -> u = new UtilizadorFree(nome, email, morada);
            case 2 -> u = new UtilizadorPremium(nome, email, morada, new PremiumBase());
            case 3 -> u = new UtilizadorPremium(nome, email, morada, new PremiumTop());
            case 4 -> u = new Desenvolvedor(nome, email, morada);
            default -> {
                System.out.println("Tipo inválido.");
                return;
            }
        }
        app.adicionarUtilizador(u);
        System.out.println("Utilizador criado com sucesso!");
    }

    private void login() {
        System.out.print("Nome de utilizador: ");
        String nome = scanner.nextLine();
        Utilizador u = app.procurarUtilizador(nome);
        if (u != null) {
            utilizadorAtual = u;
            System.out.println("Login feito como: " + utilizadorAtual.toString());
            // Verifica se o utilizador é desenvolvedor ou não e chama o menu apropriado
            menuUtilizador();
        } else {
            System.out.println("Utilizador não encontrado.");
            menuPrincipal();
        }
    }

    private void adicionarMusicaOuAlbum() {
        if (!(utilizadorAtual instanceof Desenvolvedor dev)) {
            System.out.println("Apenas desenvolvedores podem adicionar conteúdo.");
            return;
        }

        System.out.println("1. Criar Álbum");
        System.out.println("2. Adicionar Música ao Álbum");
        int op = scanner.nextInt();
        scanner.nextLine();

        if (op == 1) {
            System.out.print("Título do álbum: ");
            String titulo = scanner.nextLine();
            System.out.print("Artista: ");
            String artista = scanner.nextLine();
            Album a = dev.criarAlbum(titulo, artista);
            app.adicionarAlbum(a);
            System.out.println("Álbum criado.");
        } else if (op == 2) {
            System.out.print("Título do álbum: ");
            String titulo = scanner.nextLine();
            Album a = app.procurarAlbum(titulo);
            if (a == null) {
                System.out.println("Álbum não encontrado.");
                return;
            }

            System.out.print("Nome da música: ");
            String nome = scanner.nextLine();
            System.out.print("Intérprete: ");
            String interprete = scanner.nextLine();
            System.out.print("Editora: ");
            String editora = scanner.nextLine();
            System.out.print("Letra: ");
            String letra = scanner.nextLine();
            System.out.print("Género: ");
            String generoInput = scanner.nextLine();
            Genero genero = null;
            try {
                genero = Genero.valueOf(generoInput);
            } catch (IllegalArgumentException e) {
                System.out.println("⚠️ Género inválido. Música não adicionada.");
                return;
            }
            System.out.print("Duração (segundos): ");
            int duracao = scanner.nextInt();
            scanner.nextLine();

            System.out.print("É explícita? (s/n): ");
            String resp = scanner.nextLine();
            List<String> musicaTexto = new ArrayList<>();
            musicaTexto.add("[exemplo de notas]");

            Musica m = resp.equalsIgnoreCase("s") ?
                    dev.criarMusicaExplicita(nome, interprete, editora, letra, musicaTexto, genero, duracao) :
                    dev.criarMusica(nome, interprete, editora, letra, musicaTexto, genero, duracao);

            app.adicionarMusica(m);
            a.adicionarMusica(m);
            System.out.println("Música adicionada ao álbum.");
        }
    }

    private void criarPlaylist() {
        System.out.print("Nome da nova playlist: ");
        String nome = scanner.nextLine();

        System.out.print("A playlist será pública? (sim/nao): ");
        boolean publica = scanner.nextLine().equalsIgnoreCase("sim");

    
        System.out.println("Escolha as músicas para a playlist (digite o nome da música ou 'fim' para terminar):");
        List<Musica> musicasSelecionadas = new ArrayList<>();
        while (true) {
            System.out.print("Nome da música: ");
            String nomeMusica = scanner.nextLine();
            if (nomeMusica.equalsIgnoreCase("fim")) {
                break;
            }
    
            Musica musica = app.procurarMusica(nomeMusica);
            if (musica == null) {
                System.out.println("Música não encontrada.");
            } else {
                musicasSelecionadas.add(musica);
            }
        }
    
        if (musicasSelecionadas.isEmpty()) {
            System.out.println("Nenhuma música foi selecionada para a playlist.");
            return;
        }
    
        // Agora, instanciamos a PlaylistExplicita (ou a classe concreta de sua escolha)
        Playlist novaPlaylist = new PlaylistExplicita(nome, publica, musicasSelecionadas);
        
        app.adicionarPlaylist(novaPlaylist);
        utilizadorAtual.adicionarPlaylist(novaPlaylist);
        System.out.println("🎧 Playlist \"" + nome + "\" criada.");
    }

    private void reproduzirMusica() {
        if (utilizadorAtual == null) {
            System.out.println("Tens de fazer login primeiro.");
            return;
        }

        System.out.print("Nome da música: ");
        String nome = scanner.nextLine();
        Musica m = app.procurarMusica(nome);
        if (m == null) {
            System.out.println("Música não encontrada.");
            return;
        }

        utilizadorAtual.reproduzirMusica(m);
        System.out.println("Música reproduzida.");
    }

    private void mostrarEstatisticas() {
        Estatisticas e = app.gerarEstatisticas();
        System.out.println("\n📊 Estatísticas:");
        System.out.println("Música mais reproduzida: " + e.musicaMaisReproduzida());
        System.out.println("Intérprete mais escutado: " + e.interpreteMaisEscutado());
        System.out.println("Utilizador com mais pontos: " + e.utilizadorComMaisPontos());
        System.out.println("Género mais popular: " + e.generoMaisPopular());
        System.out.println("Nº de playlists públicas: " + e.numeroPlaylistsPublicas());
        System.out.println("Utilizador com mais playlists: " + e.utilizadorComMaisPlaylists());
        System.out.println("🎧Utilizador que mais músicas ouviu: " + e.utilizadorQueMaisOuviu() + " com " + e.utilizadorQueMaisOuviu().getMusicasOuvidas() + " músicas ouvidas.");
    }

    private void gerarPlaylistComFiltros() {
        
        BuscadorDeMusicas buscador = new BuscadorDeMusicas(app.getMusicas());

        System.out.print("Nome da nova playlist: ");
        String nome = scanner.nextLine();

        System.out.print("A playlist será pública? (sim/nao): ");
        boolean publica = scanner.nextLine().equalsIgnoreCase("sim");

        System.out.print("Filtrar por género? (deixe vazio para ignorar): ");
        String generoInput = scanner.nextLine();
        Genero genero = null;
        if (!generoInput.isBlank()) {
            try {
                genero = Genero.valueOf(generoInput);
            } catch (IllegalArgumentException e) {
                System.out.println("⚠️ Género inválido. Será ignorado.");
            }
        }

        System.out.print("Filtrar por duração máxima (segundos)? (0 para ignorar): ");
        int duracao = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Incluir apenas músicas explícitas? (s/n): ");
        boolean explicita = scanner.nextLine().equalsIgnoreCase("s");

        List<Musica> resultado = buscador.buscarPorMultiplosFiltros(genero, duracao, explicita);

        if (resultado.isEmpty()) {
            System.out.println("Nenhuma música encontrada com os critérios dados.");
            return;
        }

        System.out.print("Número máximo de músicas na playlist: ");
        int limite = scanner.nextInt();
        scanner.nextLine(); // limpar o buffer
        
        if (limite < resultado.size()) {
            Collections.shuffle(resultado); // embaralha a lista
            resultado = resultado.subList(0, limite); // seleciona apenas 'limite' músicas
        }

        Playlist novaPlaylist;

        if (explicita) {
            novaPlaylist = new PlaylistExplicita(nome, publica, resultado);
        } else if (duracao > 0) {
            novaPlaylist = new PlaylistPorDuracao(nome, publica, resultado);
        } else {
            novaPlaylist = new PlaylistFavoritos(nome, publica, resultado); // default
        }

        app.adicionarPlaylist(novaPlaylist);
        utilizadorAtual.adicionarPlaylist(novaPlaylist);
        System.out.println("🎧 Playlist \"" + nome + "\" criada com " + novaPlaylist.getMusicas().size() + " música(s)!");
    }
    
    private void menuBiblioteca() {
        boolean voltar = false;
        while (!voltar) {
            System.out.println("\n📚 Menu Biblioteca 📚");
            System.out.println("1. Ver álbuns da biblioteca");
            System.out.println("2. Adicionar álbum à biblioteca");
            System.out.println("3. Ver playlists da biblioteca");
            System.out.println("4. Adicionar playlist de outro utilizador");
            System.out.println("0. Voltar");
            System.out.print("Escolha: ");
    
            int opcao = scanner.nextInt();
            scanner.nextLine(); // limpar buffer
    
            switch (opcao) {
                case 1 -> {
                    List<Album> albuns = utilizadorAtual.getBiblioteca().getAlbuns();
                    if (albuns.isEmpty()) {
                        System.out.println("A tua biblioteca não tem álbuns.");
                    } else {
                        System.out.println("🎼 Álbuns na tua biblioteca:");
                        for (int i = 0; i < albuns.size(); i++) {
                            System.out.println((i + 1) + ". " + albuns.get(i).getTitulo());
                        }
    
                        System.out.print("\nDigite o número do álbum para ver as músicas (ou 0 para voltar): ");
                        int escolhaAlbum = scanner.nextInt();
                        scanner.nextLine(); // limpar buffer
    
                        if (escolhaAlbum > 0 && escolhaAlbum <= albuns.size()) {
                            Album albumSelecionado = albuns.get(escolhaAlbum - 1);
                            List<Musica> musicas = albumSelecionado.getMusicas();
    
                            System.out.println("\n🎵 Músicas no álbum \"" + albumSelecionado.getTitulo() + "\":");
                            if (musicas.isEmpty()) {
                                System.out.println("⚠️ Este álbum está vazio.");
                            } else {
                                for (int i = 0; i < musicas.size(); i++) {
                                    System.out.println((i + 1) + ". " + musicas.get(i));
                                }
                            }
                        } else {
                            System.out.println("Voltando ao menu...");
                        }
                    }
                }
                case 2 -> {
                    System.out.print("Título do álbum a adicionar: ");
                    String titulo = scanner.nextLine();
                    Album a = app.procurarAlbum(titulo);
                    if (a != null) {
                        utilizadorAtual.getBiblioteca().adicionarAlbum(a);
                        System.out.println("Álbum adicionado à biblioteca.");
                    } else {
                        System.out.println("Álbum não encontrado.");
                    }
                }
                case 3 -> {
                    List<Playlist> playlists = utilizadorAtual.getBiblioteca().getPlaylists();
                    if (playlists.isEmpty()) {
                        System.out.println("Ainda não tens playlists na biblioteca.");
                    } else {
                        System.out.println("🎧 Playlists na tua biblioteca:");
                        for (int i = 0; i < playlists.size(); i++) {
                            System.out.println((i + 1) + ". " + playlists.get(i).toString());
                        }
    
                        System.out.print("\nDigite o número da playlist para ver as músicas (ou 0 para voltar): ");
                        int escolhaPlaylist = scanner.nextInt();
                        scanner.nextLine(); // limpar buffer
    
                        if (escolhaPlaylist > 0 && escolhaPlaylist <= playlists.size()) {
                            Playlist selecionada = playlists.get(escolhaPlaylist - 1);
                            List<Musica> musicas = selecionada.getMusicas();
    
                            System.out.println("\n🎵 Músicas na playlist \"" + selecionada.getNome() + "\":");
                            if (musicas.isEmpty()) {
                                System.out.println("⚠️ Esta playlist está vazia.");
                            } else {
                                for (int i = 0; i < musicas.size(); i++) {
                                    System.out.println((i + 1) + ". " + musicas.get(i));
                                }
                            }
                        } else {
                            System.out.println("Voltando ao menu...");
                        }
                    }
                }
                case 4 -> {
                    System.out.print("Nome da playlist: ");
                    String nomePlaylist = scanner.nextLine();
                    System.out.print("Nome do utilizador que a criou: ");
                    String nomeUser = scanner.nextLine();
    
                    Utilizador outroUser = app.procurarUtilizador(nomeUser);
                    if (outroUser != null) {
                        Playlist p = outroUser.getPlaylists().stream()
                            .filter(pl -> pl.getNome().equalsIgnoreCase(nomePlaylist))
                            .findFirst()
                            .orElse(null);
    
                        if (p != null) {
                            if (p instanceof PlaylistPublica) {
                                utilizadorAtual.getBiblioteca().adicionarPlaylist(p);
                                System.out.println("Playlist adicionada à tua biblioteca.");
                            } 
                            else {
                                System.out.println("❌ Apenas playlists públicas podem ser adicionadas à biblioteca.");
                            }
                        }
                        else {
                            System.out.println("Playlist não encontrada no utilizador.");
                        }
                    } else {
                        System.out.println("Utilizador não encontrado.");
                    }
                }
                case 0 -> voltar = true;
                default -> System.out.println("Opção inválida.");
            }
        }
    }
    
    private void guardarEstado() {
        try {
            app.guardarEstado("spotifum.txt");
            System.out.println("Estado guardado com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao guardar estado: " + e.getMessage());
        }
    }

    private void carregarEstado() {
        try {
            app = SpotifUM.carregarEstado("spotifum.txt");
            System.out.println("Estado carregado com sucesso.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar estado: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new MenuSpotifUM().iniciar();
    }
}