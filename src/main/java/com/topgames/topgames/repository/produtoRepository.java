package com.topgames.topgames.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.topgames.topgames.model.produto;

@Repository
public interface produtoRepository extends JpaRepository<produto, Long> {
	public List<produto>findAllByNomeContainingIgnoreCase(String nome);

}
