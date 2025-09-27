package com.streaming.videos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisualizacaoRepository extends JpaRepository<Visualizacao, Integer> {}