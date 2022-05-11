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
import org.springframework.web.bind.annotation.RestController;

import com.topgames.topgames.model.categoria;
import com.topgames.topgames.repository.categoriaRepository;

@RestController 
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/categoria")
public class categoriaController {
	
	
	
	@Autowired
	private categoriaRepository topGamesRep;

	
	@GetMapping
	public ResponseEntity<List<categoria>> getAll(){
		return ResponseEntity.ok(topGamesRep.findAll());
		}
	@GetMapping("/{id}")
	public ResponseEntity<categoria> getAllId(@PathVariable Long id){
		return topGamesRep.findById(id).map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.notFound().build());
		}
	@GetMapping("/descricao/{descricao}")
	public ResponseEntity<List<categoria>> getByDescricao(@PathVariable String descricao){
		return ResponseEntity.ok(topGamesRep.findAllByDescricaoContainingIgnoreCase(descricao));
		}
	
	@PostMapping
	public ResponseEntity<categoria> postCategoria (@Valid @RequestBody categoria categoria){
		return ResponseEntity.status(HttpStatus.CREATED).body(topGamesRep.save(categoria));
	}
	
	@PutMapping
	public ResponseEntity<categoria> putCategoria (@Valid @RequestBody categoria categoria){
		return topGamesRep.findById(categoria.getId()).map(resposta -> {
			return ResponseEntity.ok().body(topGamesRep.save(categoria));
			
		})
				.orElse(ResponseEntity.notFound().build());
	}	
	
	
	@DeleteMapping("/{id}")
	public void delete (@PathVariable Long id) {
		topGamesRep.deleteById(id);
	}
	
	
	
}
