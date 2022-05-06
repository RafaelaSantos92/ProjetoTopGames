package com.topgames.topgames.model.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.topgames.topgames.model.produto;
import com.topgames.topgames.repository.categoriaRepository;
import com.topgames.topgames.repository.produtoRepository;

@RestController
@RequestMapping("/produto")
@CrossOrigin("*")
public class produtoController {
	
	
	@Autowired
	private produtoRepository produtoRepository;
	
	@Autowired
	private categoriaRepository topGamesRep;
	
	@GetMapping
	public ResponseEntity<List<produto>> getAll(){
		return ResponseEntity.ok(produtoRepository.findAll());
		}
	
	@GetMapping("/{id}")
	public ResponseEntity<produto> getById(@PathVariable Long id){
		return produtoRepository.findById(id)
				.map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
		}
	
	@GetMapping("/nome/{nome}") //localhost8080/produto/nome/{nome do produto}
	public ResponseEntity<List<produto>> getByNome(@PathVariable String nome){
		return ResponseEntity.ok(produtoRepository.findAllByNomeContainingIgnoreCase(nome));
		}
	
	@PostMapping
	public ResponseEntity<produto> post (@Valid @RequestBody produto produto){
		if(topGamesRep.existsById(produto.getCategoria().getId()))
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(produtoRepository.save(produto));
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	
	@PutMapping
	public ResponseEntity<produto> putProduto(@Valid @RequestBody produto produto){
		if(produtoRepository.existsById(produto.getId())) {
			if(topGamesRep.existsById(produto.getCategoria().getId()))
		return ResponseEntity.status(HttpStatus.OK).body(produtoRepository.save(produto));
	return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}	else
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		
		produtoRepository.deleteById(id);
	
		}
	
	}
