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
import Playlist.Playlist;
import Playlist.PlaylistNormal;
import Playlist.PlaylistPublica;
import SpotifUM.SpotifUM;
import Utilizador.Utilizador;
import Utilizador.UtilizadorFree;
import Utilizador.UtilizadorPremium;

public class GerarDadosMeusIniciais {

    public static void main(String[] args) {
        SpotifUM app = new SpotifUM();

        // Criar desenvolvedor
        Desenvolvedor dev = new Desenvolvedor("AdminDev", "dev@spotifum.com", "Servidor Central");
        Desenvolvedor ceo = new Desenvolvedor("AdminCeo", "ceo@spotifum.com", "Servidor Central");
        app.adicionarUtilizador(dev);
        app.adicionarUtilizador(ceo);

        // Criar álbum
        Album OProprio = dev.criarAlbum("O Proprio", "Dillaz");
        Album CartaDeAlforria = dev.criarAlbum("Carta De Alforria", "Plutónio");
        Album FromZero = ceo.criarAlbum("From Zero", "Linkin Park");
        Album Sour = dev.criarAlbum("Sour", "Olivia Rodrigo");
        Album AltaCostura = dev.criarAlbum("Alta Costura", "Van Zee");
        Album EntreNos = ceo.criarAlbum("Entre Nos", "Bispo");

        // Músicas (normais e explícitas)
        List<String> texto = List.of("DO RE MI FA", "SO LA SI DO");
        Musica dm1 = dev.criarMusica("Gangta", "Dillaz", "Sony Music Entertainment", "Gangsta, 'tou no sítio do costume", texto, Genero.Hiphop, 216);
        Musica dm2 = dev.criarMusica("Agiota", "Dillaz", "Sony Music Entertainment", "o seu filho anda a ver se se queima", texto, Genero.Hiphop, 165);
        Musica dm3 = dev.criarMusica("O Proprio", "Dillaz", "Sony Music Entertainment", "Ow, ow, yah", texto, Genero.Hiphop, 191);
        Musica dm4 = dev.criarMusica("Vivo", "Dillaz", "Sony Music Entertainment", "É, não adianta dares o papo", texto, Genero.Hiphop, 191);
        Musica dm5 = dev.criarMusica("Colas", "Dillaz", "Sony Music Entertainment", "E p'ra quê querer aquilo que não volta?", texto, Genero.Hiphop, 194);
        Musica dm6 = dev.criarMusica("Nota 100", "Dillaz", "Sony Music Entertainment", "Ela é uma obra-prima, não sei quem a fez", texto, Genero.Hiphop, 168);
        Musica dm7 = dev.criarMusica("Cantona", "Dillaz", "Sony Music Entertainment", "How to create space and then weave past a couple defenders", texto, Genero.Hiphop, 144);
        Musica dm8 = dev.criarMusica("Cinha", "Dillaz", "Sony Music Entertainment", "Eles ganhavam vinte mas um era meu", texto, Genero.Hiphop, 165);
        Musica dm9 = dev.criarMusica("Quarta-Feira", "Dillaz", "Sony Music Entertainment", "Eu tenho cabeça na mira, boy", texto, Genero.Hiphop, 127);
        Musica dm10 = dev.criarMusica("Pe no Mar", "Dillaz", "Sony Music Entertainment", "Não tenho a vida toda pra fazer", texto, Genero.Hiphop, 230);
        Musica dm11 = dev.criarMusica("Alo", "Dillaz", "Sony Music Entertainment", "Neste momento não é possível estabelecer a sua chamada", texto, Genero.Hiphop, 212);
        Musica dm12 = dev.criarMusica("No Fumo No Trabajo", "Dillaz", "Sony Music Entertainment", "Yo no fumo, no trabajo", texto, Genero.Hiphop, 69);
        Musica dm13 = dev.criarMusica("Habibi", "Dillaz", "Sony Music Entertainment", "Habibi, welcome to Morocco", texto, Genero.Hiphop, 205);
        Musica dm14 = dev.criarMusica("Hello", "Dillaz", "Sony Music Entertainment", "Hello, hello", texto, Genero.Hiphop, 146);
        Musica dm15 = dev.criarMusica("Hennessy", "Dillaz", "Sony Music Entertainment", "Duas da manhã e eu com o meu hennessy na mão", texto, Genero.Hiphop, 325);
        Musica dm16 = dev.criarMusica("Direcao Paris", "Dillaz", "Sony Music Entertainment", "Mesdames et messieurs, votre attention, s'il vous plaît", texto, Genero.Hiphop, 243);

        Musica pm1 = dev.criarMusica("Pais das Maravilhas", "Plutónio", "Bridgetown", "Ya, certas coisas na life", texto, Genero.Hiphop, 246);
        Musica pm2 = dev.criarMusica("Casa Melhor", "Plutónio", "Bridgetown", "Huh, hm-hm", texto, Genero.Hiphop, 180);
        Musica pm3 = dev.criarMusica("Interestelar", "Plutónio", "Bridgetown", "Plu-Plu-Plu-Plu-Plutónio (uh, huh)", texto, Genero.Hiphop, 189);
        Musica pm4 = dev.criarMusica("Sala de Audiências", "Plutónio", "Bridgetown", "Yeah ... ... Yeah", texto, Genero.Hiphop, 230);
        Musica pm5 = dev.criarMusica("Como 1 Rei", "Plutónio", "Bridgetown", "Toda a minha vida eu sempre trabalhei como ninguém", texto, Genero.Hiphop, 192);
        Musica pm6 = dev.criarMusica("6am Em Paris", "Plutónio", "Bridgetown", "sozinho em Paris e já são seis da manhã", texto, Genero.Hiphop, 144);
        Musica pm7 = dev.criarMusica("Perguntam Como", "Plutónio", "Bridgetown", "Malandro que é malandro não promete", texto, Genero.Hiphop, 168);
        Musica pm8 = dev.criarMusica("1000 Bocados", "Plutónio", "Bridgetown", "DJ Dadda", texto, Genero.Hiphop, 171);
        Musica pm9 = dev.criarMusica("Montanha", "Plutónio", "Bridgetown", "Hoje acordei, dei graças a Deus, depois levantei", texto, Genero.Hiphop, 189);
        Musica pm10 = dev.criarMusica("Deja Vu", "Plutónio", "Bridgetown", "Moça que eu", texto, Genero.Hiphop, 204);
        Musica pm11 = dev.criarMusica("Deserto", "Plutónio", "Bridgetown", "Pra dar desculpas eu não quero", texto, Genero.Hiphop, 185);
        Musica pm12 = dev.criarMusica("Mapa Cor de Rosa", "Plutónio", "Bridgetown", "Nos finais do século XIX o continente africano", texto, Genero.Hiphop, 207);
        Musica pm13 = dev.criarMusica("Ouro Sobre Azul", "Plutónio", "Bridgetown", "Ouro sobre azul mas não caiu do céu", texto, Genero.Hiphop, 145);
        Musica pm14 = dev.criarMusica("Sessenta e Nove", "Plutónio", "Bridgetown", "Começou por um +351", texto, Genero.Hiphop, 180);
        Musica pm15 = dev.criarMusica("Multiplica", "Plutónio", "Bridgetown", "Uh-lu-lu, uh-lu-lu", texto, Genero.Hiphop, 189);
        Musica pm16 = dev.criarMusica("FDP", "Plutónio", "Bridgetown", "Nem sei se vale a pena", texto, Genero.Hiphop, 183);
        Musica pm17 = dev.criarMusica("Tal e Qual", "Plutónio", "Bridgetown", "O amor é uma luz num mundo de ilusão", texto, Genero.Hiphop, 180);
        Musica pm18 = dev.criarMusica("Menos 1 Nite", "Plutónio", "Bridgetown", "É so mais uma noite, menos 1 Nite", texto, Genero.Hiphop, 205);
        Musica pm19 = dev.criarMusica("Luxemburgo", "Plutónio", "Bridgetown", "Uh-huh", texto, Genero.Hiphop, 212);
        Musica pm20 = dev.criarMusica("Salomao", "Plutónio", "Bridgetown", "Sem concorrência até a próxima life", texto, Genero.Hiphop, 207);
        Musica pm21 = dev.criarMusica("Dissabores", "Plutónio", "Bridgetown", "Não há palavras sem ter sílabas", texto, Genero.Hiphop, 214);
        Musica pm22 = dev.criarMusica("Carta de Alforria", "Plutónio", "Bridgetown", "Como é que é, mano? Tens aí o brinde", texto, Genero.Hiphop, 321);

        Musica vm1 = dev.criarMusica("Bravos", "Van Zee", "Virgin Music Portugal", "Bravos", texto, Genero.Hiphop, 165);
        Musica vm2 = dev.criarMusica("Nessa Chama", "Van Zee", "Virgin Music Portugal", "Nessa Chama", texto, Genero.Hiphop, 178);
        Musica vm3 = dev.criarMusica("Quem Es Tu?", "Van Zee", "Virgin Music Portugal", "Quem És Tu?", texto, Genero.Hiphop, 161);
        Musica vm4 = dev.criarMusica("Atitude", "Van Zee", "Virgin Music Portugal", "Atitude", texto, Genero.Hiphop, 197);
        Musica vm5 = dev.criarMusica("O Amor E mm Assim, Mas...", "Van Zee", "Virgin Music Portugal", "O Amor É mm Assim, Mas...", texto, Genero.Hiphop, 201);
        Musica vm6 = dev.criarMusica("Ainda Prende O Cabelo", "Van Zee", "Virgin Music Portugal", "Ainda Prende O Cabelo", texto, Genero.Hiphop, 210);
        Musica vm7 = dev.criarMusica("Insular", "Van Zee", "Virgin Music Portugal", "Insular", texto, Genero.Hiphop, 143);
        Musica vm8 = dev.criarMusica("Tragico", "Van Zee", "Virgin Music Portugal", "Trágico", texto, Genero.Hiphop, 184);
        Musica vm9 = dev.criarMusica("Como Seria?/Amor Sobrio", "Van Zee", "Virgin Music Portugal", "Como Seria?/Amor Sóbrio", texto, Genero.Hiphop, 184);
        Musica vm10 = dev.criarMusica("Fica So.", "Van Zee", "Virgin Music Portugal", "Fica Só.", texto, Genero.Hiphop, 197);

        Musica lm1 = ceo.criarMusica("From Zero", "Linkin Park", "Warner Records", "From Zero", texto, Genero.Metal, 22);
        Musica lm2 = ceo.criarMusica("The Emptiness Machine", "Linkin Park", "Warner Records", "The Emptiness Machine", texto, Genero.Metal, 190);
        Musica lm3 = ceo.criarMusica("Cut the Bridge", "Linkin Park", "Warner Records", "Cut the Bridge", texto, Genero.Metal, 228);
        Musica lm4 = ceo.criarMusica("Heavy is the Crown", "Linkin Park", "Warner Records", "Heavy Is the Crown", texto, Genero.Metal, 167);
        Musica lm5 = ceo.criarMusica("Over Each Other", "Linkin Park", "Warner Records", "Over Each Other", texto, Genero.Metal, 170);
        Musica lm6 = ceo.criarMusica("Casualty", "Linkin Park", "Warner Records", "Casualty", texto, Genero.Metal, 140);
        Musica lm7 = ceo.criarMusica("OverFlow", "Linkin Park", "Warner Records", "Overflow", texto, Genero.Metal, 211);
        Musica lm8 = ceo.criarMusica("Two Faced", "Linkin Park", "Warner Records", "Two Faced", texto, Genero.Metal, 183);
        Musica lm9 = ceo.criarMusica("Stained", "Linkin Park", "Warner Records", "Stained", texto, Genero.Metal, 185);
        Musica lm10 = ceo.criarMusica("IGYEIH", "Linkin Park", "Warner Records", "IGYEIN", texto, Genero.Metal, 209);
        Musica lm11 = ceo.criarMusica("Good Things Go", "Linkin Park", "Warner Records", "Good Things Go", texto, Genero.Metal, 209);

        Musica om1 = dev.criarMusica("Brutal", "Olivia Rodrigo", "Polydor", "Brutal", texto, Genero.Pop, 143);
        Musica om2 = dev.criarMusica("Traitor", "Olivia Rodrigo", "Polydor", "Traitor", texto, Genero.Pop, 229);
        Musica om3 = dev.criarMusica("Drivers License", "Olivia Rodrigo", "Polydor", "Drivers License", texto, Genero.Pop, 242);
        Musica om4 = dev.criarMusica("1 Step Forward, 3 Steps Back", "Olivia Rodrigo", "Polydor", "1 Step Forward, 1 Step Back", texto, Genero.Pop, 163);
        Musica om5 = dev.criarMusica("Deja Vu", "Olivia Rodrigo", "Polydor", "Deja Vu", texto, Genero.Pop, 215);
        Musica om6 = dev.criarMusica("Good 4 U", "Olivia Rodrigo", "Polydor", "Good 4 U", texto, Genero.Pop, 178);
        Musica om7 = dev.criarMusica("Enough For You", "Olivia Rodrigo", "Polydor", "Enough For You", texto, Genero.Pop, 202);
        Musica om8 = dev.criarMusica("Happier", "Olivia Rodrigo", "Polydor", "Happier", texto, Genero.Pop, 175);
        Musica om9 = dev.criarMusica("Jealousy, Jealousy", "Olivia Rodrigo", "Polydor", "Jealousy, Jealousy", texto, Genero.Pop, 173);
        Musica om10 = dev.criarMusica("Favorite Crime", "Olivia Rodrigo", "Polydor", "Favorite Crime", texto, Genero.Pop, 152);
        Musica om11 = dev.criarMusica("Hope Ur Ok", "Olivia Rodrigo", "Polydor", "Hope Ur Ok", texto, Genero.Pop, 209);

        Musica bm1 = ceo.criarMusica("Espinhos", "Bispo", "Virgin Music Portugal", "Espinhos", texto, Genero.Hiphop, 138);
        Musica bm2 = ceo.criarMusica("Ultimo beijo", "Bispo", "Virgin Music Portugal", "Ultimo beijo", texto, Genero.Hiphop, 196);
        Musica bm3 = ceo.criarMusica("Check-in", "Bispo", "Virgin Music Portugal", "Check-in", texto, Genero.Hiphop, 194);
        Musica bm4 = ceo.criarMusica("Passageiro", "Bispo", "Virgin Music Portugal", "Passageiro", texto, Genero.Hiphop, 166);
        Musica bm5 = ceo.criarMusica("Sem pressa", "Bispo", "Virgin Music Portugal", "Sem pressa", texto, Genero.Hiphop, 224);
        Musica bm6 = ceo.criarMusica("Obrigado", "Bispo", "Virgin Music Portugal", "Obrigado", texto, Genero.Hiphop, 205);
        Musica bm7 = ceo.criarMusica("O teu cheiro", "Bispo", "Virgin Music Portugal", "O teu cheiro", texto, Genero.Hiphop, 170);
        Musica bm8 = ceo.criarMusica("Ultima petala", "Bispo", "Virgin Music Portugal", "Ultima petala", texto, Genero.Hiphop, 59);
        Musica bm9 = ceo.criarMusica("Onde e que tas agr?", "Bispo", "Virgin Music Portugal", "Onde e que tas agr?", texto, Genero.Hiphop, 132);
        Musica bm10 = ceo.criarMusica("Varias perguntas", "Bispo", "Virgin Music Portugal", "Varias perguntas", texto, Genero.Hiphop, 184);
        Musica bm11 = ceo.criarMusica("Pode resultar", "Bispo", "Virgin Music Portugal", "Pode resultar", texto, Genero.Hiphop, 197);
        Musica bm12 = ceo.criarMusica("Nao da para parar", "Bispo", "Virgin Music Portugal", "Nao da pa parar", texto, Genero.Hiphop, 193);
        Musica bm13 = ceo.criarMusica("Vou continuar", "Bispo", "Virgin Music Portugal", "Vou continuar", texto, Genero.Hiphop, 219);
        Musica bm14 = ceo.criarMusica("Dimeu", "Bispo", "Virgin Music Portugal", "Dimeu", texto, Genero.Hiphop, 280);
        Musica bm15 = ceo.criarMusica("Ser comum", "Bispo", "Virgin Music Portugal", "Ser comum", texto, Genero.Hiphop, 194);
        Musica bm16 = ceo.criarMusica("Light", "Bispo", "Virgin Music Portugal", "Light", texto, Genero.Hiphop, 182);
        // Adicionar músicas aos álbuns
        OProprio.adicionarMusica(dm1);
        OProprio.adicionarMusica(dm2);
        OProprio.adicionarMusica(dm3);
        OProprio.adicionarMusica(dm4);
        OProprio.adicionarMusica(dm5);
        OProprio.adicionarMusica(dm6);
        OProprio.adicionarMusica(dm7);
        OProprio.adicionarMusica(dm8);
        OProprio.adicionarMusica(dm9);
        OProprio.adicionarMusica(dm10);
        OProprio.adicionarMusica(dm11);
        OProprio.adicionarMusica(dm12);
        OProprio.adicionarMusica(dm13);
        OProprio.adicionarMusica(dm14);
        OProprio.adicionarMusica(dm15);
        OProprio.adicionarMusica(dm16);

        CartaDeAlforria.adicionarMusica(pm1);
        CartaDeAlforria.adicionarMusica(pm2);
        CartaDeAlforria.adicionarMusica(pm3);
        CartaDeAlforria.adicionarMusica(pm4);
        CartaDeAlforria.adicionarMusica(pm5);
        CartaDeAlforria.adicionarMusica(pm6);
        CartaDeAlforria.adicionarMusica(pm7);
        CartaDeAlforria.adicionarMusica(pm8);
        CartaDeAlforria.adicionarMusica(pm9);
        CartaDeAlforria.adicionarMusica(pm10);
        CartaDeAlforria.adicionarMusica(pm11);
        CartaDeAlforria.adicionarMusica(pm12);
        CartaDeAlforria.adicionarMusica(pm13);
        CartaDeAlforria.adicionarMusica(pm14);
        CartaDeAlforria.adicionarMusica(pm15);
        CartaDeAlforria.adicionarMusica(pm16);
        CartaDeAlforria.adicionarMusica(pm17);
        CartaDeAlforria.adicionarMusica(pm18);
        CartaDeAlforria.adicionarMusica(pm19);
        CartaDeAlforria.adicionarMusica(pm20);
        CartaDeAlforria.adicionarMusica(pm21);
        CartaDeAlforria.adicionarMusica(pm22);

        AltaCostura.adicionarMusica(vm1);
        AltaCostura.adicionarMusica(vm2);
        AltaCostura.adicionarMusica(vm3);
        AltaCostura.adicionarMusica(vm4);
        AltaCostura.adicionarMusica(vm5);
        AltaCostura.adicionarMusica(vm6);
        AltaCostura.adicionarMusica(vm7);
        AltaCostura.adicionarMusica(vm8);
        AltaCostura.adicionarMusica(vm9);
        AltaCostura.adicionarMusica(vm10);
        
        FromZero.adicionarMusica(lm1);
        FromZero.adicionarMusica(lm2);
        FromZero.adicionarMusica(lm3);
        FromZero.adicionarMusica(lm4);
        FromZero.adicionarMusica(lm5);
        FromZero.adicionarMusica(lm6);
        FromZero.adicionarMusica(lm7);
        FromZero.adicionarMusica(lm8);
        FromZero.adicionarMusica(lm9);
        FromZero.adicionarMusica(lm10);
        FromZero.adicionarMusica(lm11);

        Sour.adicionarMusica(om1);
        Sour.adicionarMusica(om2);
        Sour.adicionarMusica(om3);
        Sour.adicionarMusica(om4);
        Sour.adicionarMusica(om5);
        Sour.adicionarMusica(om6);
        Sour.adicionarMusica(om7);
        Sour.adicionarMusica(om8);
        Sour.adicionarMusica(om9);
        Sour.adicionarMusica(om10);
        Sour.adicionarMusica(om11);

        EntreNos.adicionarMusica(bm1);
        EntreNos.adicionarMusica(bm2);
        EntreNos.adicionarMusica(bm3);
        EntreNos.adicionarMusica(bm4);
        EntreNos.adicionarMusica(bm5);
        EntreNos.adicionarMusica(bm6);
        EntreNos.adicionarMusica(bm7);
        EntreNos.adicionarMusica(bm8);
        EntreNos.adicionarMusica(bm9);
        EntreNos.adicionarMusica(bm10);
        EntreNos.adicionarMusica(bm11);
        EntreNos.adicionarMusica(bm12);
        EntreNos.adicionarMusica(bm13);
        EntreNos.adicionarMusica(bm14);
        EntreNos.adicionarMusica(bm15);
        EntreNos.adicionarMusica(bm16);

        // Adicionar álbuns ao sistema
        app.adicionarAlbum(OProprio);
        app.adicionarAlbum(FromZero);
        app.adicionarAlbum(CartaDeAlforria);
        app.adicionarAlbum(Sour);
        app.adicionarAlbum(AltaCostura);
        app.adicionarAlbum(EntreNos);

        // Adicionar Músicas ao sistema
        app.adicionarMusica(dm1);
        app.adicionarMusica(dm2);
        app.adicionarMusica(dm3);
        app.adicionarMusica(dm4);
        app.adicionarMusica(dm5);
        app.adicionarMusica(dm6);
        app.adicionarMusica(dm7);
        app.adicionarMusica(dm8);
        app.adicionarMusica(dm9);
        app.adicionarMusica(dm10);
        app.adicionarMusica(dm11);
        app.adicionarMusica(dm12);
        app.adicionarMusica(dm13);
        app.adicionarMusica(dm14);
        app.adicionarMusica(dm15);
        app.adicionarMusica(dm16);

        app.adicionarMusica(pm1);
        app.adicionarMusica(pm2);
        app.adicionarMusica(pm3);
        app.adicionarMusica(pm4);
        app.adicionarMusica(pm5);
        app.adicionarMusica(pm6);
        app.adicionarMusica(pm7);
        app.adicionarMusica(pm8);
        app.adicionarMusica(pm9);
        app.adicionarMusica(pm10);
        app.adicionarMusica(pm11);
        app.adicionarMusica(pm12);
        app.adicionarMusica(pm13);
        app.adicionarMusica(pm14);
        app.adicionarMusica(pm15);
        app.adicionarMusica(pm16);
        app.adicionarMusica(pm17);
        app.adicionarMusica(pm18);
        app.adicionarMusica(pm19);
        app.adicionarMusica(pm20);
        app.adicionarMusica(pm21);
        app.adicionarMusica(pm22);

        app.adicionarMusica(vm1);
        app.adicionarMusica(vm2);
        app.adicionarMusica(vm3);
        app.adicionarMusica(vm4);
        app.adicionarMusica(vm5);
        app.adicionarMusica(vm6);
        app.adicionarMusica(vm7);
        app.adicionarMusica(vm8);
        app.adicionarMusica(vm9);
        app.adicionarMusica(vm10);

        app.adicionarMusica(lm1);
        app.adicionarMusica(lm2);
        app.adicionarMusica(lm3);
        app.adicionarMusica(lm4);
        app.adicionarMusica(lm5);
        app.adicionarMusica(lm6);
        app.adicionarMusica(lm7);
        app.adicionarMusica(lm8);
        app.adicionarMusica(lm9);
        app.adicionarMusica(lm10);
        app.adicionarMusica(lm11);

        app.adicionarMusica(om1);
        app.adicionarMusica(om2);
        app.adicionarMusica(om3);
        app.adicionarMusica(om4);
        app.adicionarMusica(om5);
        app.adicionarMusica(om6);
        app.adicionarMusica(om7);
        app.adicionarMusica(om8);
        app.adicionarMusica(om9);
        app.adicionarMusica(om10);
        app.adicionarMusica(om11);

        app.adicionarMusica(bm1);
        app.adicionarMusica(bm2);
        app.adicionarMusica(bm3);
        app.adicionarMusica(bm4);
        app.adicionarMusica(bm5);
        app.adicionarMusica(bm6);
        app.adicionarMusica(bm7);
        app.adicionarMusica(bm8);
        app.adicionarMusica(bm9);
        app.adicionarMusica(bm10);
        app.adicionarMusica(bm11);
        app.adicionarMusica(bm12);
        app.adicionarMusica(bm13);
        app.adicionarMusica(bm14);
        app.adicionarMusica(bm15);
        app.adicionarMusica(bm16);

        // Criar utilizadores
        Utilizador u1 = new UtilizadorFree("Edu", "edu@gmail.com", "Rua A");
        Utilizador u2 = new UtilizadorFree("Diana", "diana@gmail.com", "Rua B");
        Utilizador u3 = new UtilizadorFree("Fabio", "fabio@gmail.com", "Rua C");
        Utilizador u4 = new UtilizadorPremium("Dinis", "dinis@gmail.com", "Rua D", new PremiumBase());
        Utilizador u5 = new UtilizadorPremium("Joao", "joao@gmail.com", "Rua E", new PremiumBase());
        Utilizador u6 = new UtilizadorPremium("Leonor", "leonor@gmail.com", "Rua F", new PremiumBase());
        Utilizador u7 = new UtilizadorPremium("Guga", "guga@gmail.com", "Rua G", new PremiumTop());
        Utilizador u8 = new UtilizadorPremium("Maria", "maria@gmail.com", "Rua H", new PremiumTop());
        Utilizador u9 = new UtilizadorPremium("Lara", "lara@gmail.com", "Rua I" , new PremiumTop());

        app.adicionarUtilizador(u1);
        app.adicionarUtilizador(u2);
        app.adicionarUtilizador(u3);
        app.adicionarUtilizador(u4);
        app.adicionarUtilizador(u5);
        app.adicionarUtilizador(u6);
        app.adicionarUtilizador(u7);
        app.adicionarUtilizador(u8);
        app.adicionarUtilizador(u9);

        // Criar uma playlist pública para o Dinis
        PlaylistNormal playlistDinis1 = new PlaylistNormal("Random Dinis", u4.getNome());
        playlistDinis1.adicionarMusica(dm1);
        playlistDinis1.adicionarMusica(dm3);
        playlistDinis1.adicionarMusica(dm5);
        playlistDinis1.adicionarMusica(lm7);
        playlistDinis1.adicionarMusica(lm9);
        playlistDinis1.adicionarMusica(om11);
        playlistDinis1.adicionarMusica(pm13);
        playlistDinis1.adicionarMusica(pm15);
        playlistDinis1.adicionarMusica(pm17);

        PlaylistPublica playlistGuga1 = new PlaylistPublica("Random Guga", u7.getNome());
        playlistGuga1.adicionarMusica(dm2);
        playlistGuga1.adicionarMusica(dm4);
        playlistGuga1.adicionarMusica(dm6);
        playlistGuga1.adicionarMusica(vm8);
        playlistGuga1.adicionarMusica(vm10);
        playlistGuga1.adicionarMusica(pm12);
        playlistGuga1.adicionarMusica(pm14);
        playlistGuga1.adicionarMusica(pm16);
        playlistGuga1.adicionarMusica(pm18);


        app.adicionarPlaylist(playlistDinis1);
        u4.adicionarPlaylist(playlistDinis1);

        app.adicionarPlaylist(playlistGuga1);
        u7.adicionarPlaylist(playlistGuga1);

        // Guardar o estado
        try {
            app.guardarEstado("spotifum.txt");
            System.out.println("✔ Dados de teste criados com sucesso!");
        } catch (IOException e) {
            System.out.println("❌ Erro ao guardar ficheiro: " + e.getMessage());
        }
    }
}
