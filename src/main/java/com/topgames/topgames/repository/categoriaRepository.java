package com.topgames.topgames.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.topgames.topgames.model.categoria;

@Repository
public interface categoriaRepository extends JpaRepository <categoria, Long>{
	public List<categoria>findAllByDescricaoContainingIgnoreCase(String descricao);

}
