package com.getgames.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.getgames.repository.jogoRepository;
import com.getgames.model.Jogos;

@RestController
@RequestMapping("/jogos")

public class JogoResource {
	@Autowired
	private jogoRepository jogos;
	
	@PostMapping
	public Jogos adicionar(@Valid @RequestBody Jogos jogo) {
		return jogos.save(jogo);
	}
	@GetMapping
	public List<Jogos> listar(){
		return jogos.findAll();
		
	}
	@GetMapping("/{id}")
	public ResponseEntity<Jogos> buscar(@PathVariable Long id){
		Jogos jogo = jogos.findOne(id);
		if(jogo==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(jogo);
		
	}
	@PutMapping("/{id")
	public ResponseEntity<Jogos> atualizar (@PathVariable Long id, @Valid @RequestBody Jogos jogo){
		Jogos existente = jogos.findOne(id);
		if(existente == null) {
			return ResponseEntity.notFound().build();
		}
		BeanUtils.copyProperties(jogo, existente,"id");
		existente = jogos.save(existente);
		return ResponseEntity.ok(existente);
	}
	
	@DeleteMapping("/{id})")
	public ResponseEntity<Void> remover(@PathVariable Long id){
		Jogos jogo = jogos.findOne(id);
		
		if(jogo == null) {
			return ResponseEntity.notFound().build();
		}
		jogos.delete(jogo);
		return ResponseEntity.noContent().build();
	}
	
}
