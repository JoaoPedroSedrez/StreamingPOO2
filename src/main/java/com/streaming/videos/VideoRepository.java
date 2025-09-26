package com.streaming.videos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoRepository extends JpaRepository<Video, Integer> {

    /**
     * Consulta 1: Buscar vídeos pelo título com ordenação. Exemplo: "Missão".
     * Query Method: findBy + Titulo + Containing + IgnoreCase.
     * O parâmetro Sort permite flexibilidade na ordenação.
     */
    List<Video> findByTituloContainingIgnoreCase(String titulo, Sort sort);

    /**
     * Consulta 2: Todos os vídeos de uma categoria ordenado pelo título.
     * Query Method: findBy + CategoriaNome + OrderBy + TituloAsc.
     * Spring entende que deve buscar pelo atributo 'nome' da entidade 'com.streaming.videos.Categoria'.
     */
    List<Video> findByCategoriaNomeOrderByTituloAsc(String nomeCategoria);

    /**
     * Consulta 3: Os top 10 vídeos mais bem avaliados (por média de nota).
     * JPQL: Calcula a média das notas (AVG(a.nota)) para cada vídeo e ordena.
     * O Pageable (com PageRequest.of(0, 10)) aplica o LIMIT 10.
     */
    @Query("SELECT v FROM Video v JOIN v.avaliacoes a GROUP BY v.id ORDER BY AVG(a.nota) DESC")
    List<Video> findTop10ByMediaAvaliacao(Pageable pageable);

    /**
     * Consulta 4: Os top 10 vídeos mais assistidos (por contagem de visualizações).
     * JPQL: Conta as visualizações (COUNT(vz.id)) para cada vídeo e ordena.
     * O Pageable (com PageRequest.of(0, 10)) aplica o LIMIT 10.
     */
    @Query("SELECT v FROM Video v JOIN v.visualizacoes vz GROUP BY v.id ORDER BY COUNT(vz.id) DESC")
    List<Video> findTop10ByMaisAssistidos(Pageable pageable);
}