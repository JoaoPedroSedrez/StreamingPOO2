package com.streaming.videos;

import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class TestDataInitializer implements CommandLineRunner {

    private final UsuarioRepository usuarioRepository;
    private final PerfilRepository perfilRepository;
    private final CategoriaRepository categoriaRepository;
    private final VideoRepository videoRepository;
    private final VisualizacaoRepository visualizacaoRepository;
    private final AvaliacaoRepository avaliacaoRepository;

    public TestDataInitializer(
            UsuarioRepository usuarioRepository,
            PerfilRepository perfilRepository,
            CategoriaRepository categoriaRepository,
            VideoRepository videoRepository,
            VisualizacaoRepository visualizacaoRepository,
            AvaliacaoRepository avaliacaoRepository) {
        this.usuarioRepository = usuarioRepository;
        this.perfilRepository = perfilRepository;
        this.categoriaRepository = categoriaRepository;
        this.videoRepository = videoRepository;
        this.visualizacaoRepository = visualizacaoRepository;
        this.avaliacaoRepository = avaliacaoRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("\n==========================================================");
        System.out.println("--- 🚀 INICIALIZANDO DADOS DE TESTE E VALIDANDO CONSULTAS 🚀 ---");
        System.out.println("==========================================================");

        avaliacaoRepository.deleteAll();
        visualizacaoRepository.deleteAll();
        perfilRepository.deleteAll();
        videoRepository.deleteAll();
        categoriaRepository.deleteAll();
        usuarioRepository.deleteAll();

        Usuario user1 = criarUsuario("Carlos Silva", "carlos@mail.com");
        Perfil p1_maratonista = criarPerfil(user1, "Carlos Pro");
        Perfil p2_infantil = criarPerfil(user1, "Carlos Kids");

        Usuario user2 = criarUsuario("Ana Souza", "ana@mail.com");
        Perfil p3_critica = criarPerfil(user2, "Ana Oficial");

        Usuario user3 = criarUsuario("José Pereira", "jose@mail.com");
        Perfil p4_neutro = criarPerfil(user3, "Zé");

        Usuario user4 = criarUsuario("Mariana Costa", "mariana@mail.com");
        Usuario user5 = criarUsuario("Rafael Almeida", "rafael@mail.com");
        Usuario user6 = criarUsuario("Lúcia Mendes", "lucia@mail.com");
        Usuario user7 = criarUsuario("Pedro Rocha", "pedro@mail.com");
        Usuario user8 = criarUsuario("Sofia Alves", "sofia@mail.com");
        Usuario user9 = criarUsuario("Guilherme Santos", "gui@mail.com");
        Usuario user10 = criarUsuario("Beatriz Lima", "bea@mail.com");


        Perfil p5 = criarPerfil(user4, "Mari TV");
        Perfil p6 = criarPerfil(user4, "Mari Games");
        Perfil p7 = criarPerfil(user5, "Rafa Principal");
        Perfil p8 = criarPerfil(user5, "Rafa Backup");
        Perfil p9 = criarPerfil(user6, "Lu Master");
        Perfil p10 = criarPerfil(user6, "Lu Júnior");
        Perfil p11 = criarPerfil(user6, "Lu Pet");
        Perfil p12 = criarPerfil(user7, "Pedro 1");
        Perfil p13 = criarPerfil(user7, "Pedro 2");
        Perfil p14 = criarPerfil(user8, "Sofi");
        Perfil p15 = criarPerfil(user8, "Sofi Filmes");
        Perfil p16 = criarPerfil(user8, "Sofi Séries");
        Perfil p17 = criarPerfil(user9, "Gui");
        Perfil p18 = criarPerfil(user10, "Bia Principal");
        Perfil p19 = criarPerfil(user10, "Bia Amigos");
        Perfil p20 = criarPerfil(user10, "Bia Documentários");

        Categoria catAcao = criarCategoria("Ação");
        Categoria catSciFi = criarCategoria("Ficção Científica");
        Categoria catDocs = criarCategoria("Documentário");
        Categoria catComedia = criarCategoria("Comédia");
        Categoria catDrama = criarCategoria("Drama");
        Categoria catTerror = criarCategoria("Terror");
        Categoria catAventura = criarCategoria("Aventura");
        Categoria catRomance = criarCategoria("Romance");
        Categoria catFantasia = criarCategoria("Fantasia");
        Categoria catAnimacao = criarCategoria("Animação");
        Categoria catEsporte = criarCategoria("Esporte");
        Categoria catGuerra = criarCategoria("Guerra");

        Video v1 = criarVideo(catAcao, "Missão Impossível 1", 120);
        Video v2 = criarVideo(catAcao, "Missão Perdida no Espaço", 90);
        Video v3 = criarVideo(catSciFi, "O Planeta dos Robôs", 150);
        Video v4 = criarVideo(catDocs, "Vida Marinha", 45);
        Video v5 = criarVideo(catComedia, "A Turma do Barulho 2", 100);
        Video v6 = criarVideo(catDrama, "O Testemunho Final", 135);
        Video v7 = criarVideo(catTerror, "A Casa Abandonada", 95);
        Video v8 = criarVideo(catAventura, "Caçadores do Tesouro", 140);
        Video v9 = criarVideo(catRomance, "Nosso Último Verão", 110);
        Video v10 = criarVideo(catFantasia, "O Reino de Gelo", 160);
        Video v11 = criarVideo(catAnimacao, "A Ovelha Inteligente", 85);
        Video v12 = criarVideo(catEsporte, "A Lenda da Quadra", 105);
        Video v13 = criarVideo(catGuerra, "A Batalha de Kursk", 170);
        Video v14 = criarVideo(catSciFi, "Viajantes do Tempo 5", 115);

        criarVisualizacao(p1_maratonista, v1, 100);
        criarVisualizacao(p2_infantil, v1, 100);
        criarVisualizacao(p3_critica, v1, 100);
        criarVisualizacao(p4_neutro, v1, 100);

        criarVisualizacao(p1_maratonista, v3, 100);
        criarVisualizacao(p1_maratonista, v3, 100);
        criarVisualizacao(p2_infantil, v3, 100); 
        criarVisualizacao(p3_critica, v3, 100);
        criarVisualizacao(p3_critica, v3, 100);

        criarVisualizacao(p4_neutro, v4, 100);

        for (int i = 0; i < 10; i++) {
            criarVisualizacao(p7, v12, 100);
        }

        criarAvaliacao(p1_maratonista, v1, 5, "Excelente!");
        criarAvaliacao(p3_critica, v1, 5, "Muito bom!");

        criarAvaliacao(p3_critica, v3, 4, "Interessante.");

        criarAvaliacao(p4_neutro, v4, 2, "Mais ou menos.");

        criarAvaliacao(p1_maratonista, v2, 1, "Péssimo.");
        criarAvaliacao(p3_critica, v2, 1, "Não gostei.");

        criarAvaliacao(p5, v5, 5, "Comédia hilária!");

        criarAvaliacao(p7, v12, 5, "Muito bom o jogo!");
        criarAvaliacao(p9, v12, 1, "Esperava mais.");
        criarAvaliacao(p10, v12, 3, "Nota média.");

        System.out.println("\n====================== RESULTADOS DAS QUERYS =======================");

        System.out.println("\n--- 1. BUSCA POR TÍTULO ('Missão'), Ordenado por Duração ---");
        List<Video> videosMissao = videoRepository.findByTituloContainingIgnoreCase("Missão", Sort.by("duracao").ascending());
        videosMissao.forEach(v ->
                System.out.printf("  [Filme] %s (Duração: %d min)\n", v.getTitulo(), v.getDuracao())
        );
        System.out.println("--------------------------------------------------------------------");

        System.out.println("\n--- 2. TODOS OS VÍDEOS DA CATEGORIA 'Ação' (Ordenado por Título) ---");
        List<Video> videosAcao = videoRepository.findByCategoriaNomeOrderByTituloAsc("Ação");
        videosAcao.forEach(v ->
                System.out.printf("  [Filme] %s (Categoria: %s)\n", v.getTitulo(), v.getCategoria().getNome())
        );
        System.out.println("--------------------------------------------------------------------");


        System.out.println("\n--- 3. TOP 10 VÍDEOS MAIS BEM AVALIADOS (Por Média de Nota) ---");
        Pageable topTen = PageRequest.of(0, 10);
        List<Video> topAvaliacao = videoRepository.findTop10ByMediaAvaliacao(topTen);
        topAvaliacao.forEach(v ->
                System.out.printf("  [Filme] %s\n", v.getTitulo())
        );
        System.out.println("--------------------------------------------------------------------");


        System.out.println("\n--- 4. TOP 10 VÍDEOS MAIS ASSISTIDOS (Por Contagem de Views) ---");
        List<Video> topAssistidos = videoRepository.findTop10ByMaisAssistidos(topTen);
        topAssistidos.forEach(v ->
                System.out.printf("  [Filme] %s\n", v.getTitulo())
        );
        System.out.println("--------------------------------------------------------------------");


        System.out.println("\n--- 5. USUÁRIO COM MAIS VISUALIZAÇÕES NO TOTAL ---");
        List<Usuario> topUsers = usuarioRepository.findTopUsuarioByMaisVisualizacoes(PageRequest.of(0, 1));

        if (!topUsers.isEmpty()) {
            Usuario u = topUsers.get(0);
            System.out.printf("  🏆 Usuário Vencedor: %s (Email: %s)\n", u.getNome(), u.getEmail());
        } else {
            System.out.println("  Nenhum usuário encontrado.");
        }
        System.out.println("--------------------------------------------------------------------");


        System.out.println("\n--- 🏁 FIM DA INICIALIZAÇÃO E TESTES 🏁 ---");
    }

    private Usuario criarUsuario(String nome, String email) {
        Usuario u = new Usuario();
        u.setNome(nome);
        u.setEmail(email);
        u.setSenha("123456");
        u.setDataCadastro(LocalDateTime.now());
        return usuarioRepository.save(u);
    }

    private Perfil criarPerfil(Usuario usuario, String nomePerfil) {
        Perfil p = new Perfil();
        p.setNomePerfil(nomePerfil);
        p.setUsuario(usuario);
        return perfilRepository.save(p);
    }

    private Categoria criarCategoria(String nome) {
        Categoria c = new Categoria();
        c.setNome(nome);
        return categoriaRepository.save(c);
    }

    private Video criarVideo(Categoria categoria, String titulo, Integer duracao) {
        Video v = new Video();
        v.setCategoria(categoria);
        v.setTitulo(titulo);
        v.setDescricao("Descrição padrão para " + titulo);
        v.setDuracao(duracao);
        return videoRepository.save(v);
    }

    private Visualizacao criarVisualizacao(Perfil perfil, Video video, Integer progresso) {
        Visualizacao viz = new Visualizacao();
        viz.setPerfil(perfil);
        viz.setVideo(video);
        viz.setDataHora(LocalDateTime.now());
        viz.setProgresso(progresso);
        return visualizacaoRepository.save(viz);
    }

    private Avaliacao criarAvaliacao(Perfil perfil, Video video, Integer nota, String comentario) {
        Avaliacao ava = new Avaliacao();
        ava.setPerfil(perfil);
        ava.setVideo(video);
        ava.setNota(nota);
        ava.setComentario(comentario);
        return avaliacaoRepository.save(ava);
    }
}