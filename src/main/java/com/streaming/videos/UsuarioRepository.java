package com.streaming.videos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    /**
     * Consulta 5: O usuário que mais assistiu vídeos.
     * ALTERADO: O retorno deve ser List<Usuario> porque o método aceita Pageable.
     */
    @Query("SELECT u FROM Usuario u JOIN u.perfis p JOIN p.visualizacoes v GROUP BY u.id ORDER BY COUNT(v.id) DESC")
    List<Usuario> findTopUsuarioByMaisVisualizacoes(Pageable pageable);
}