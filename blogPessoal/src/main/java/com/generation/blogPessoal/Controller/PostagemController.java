package com.generation.blogPessoal.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.blogPessoal.Model.Postagem;
import com.generation.blogPessoal.Repository.PostagemRepository;

@RestController
@RequestMapping("/postagens")
@CrossOrigin(origins="*",allowedHeaders="*")
public class PostagemController {
	
	@Autowired
	private PostagemRepository postagemRepository;
	
	//listar todas as postagens
	@GetMapping
	public ResponseEntity<List <Postagem>> getAll(){
		return ResponseEntity.ok(postagemRepository.findAll());
	}

}
