package com.generation.blogPessoal.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.blogPessoal.Model.Postagem;

public interface PostagemRepository extends JpaRepository<Postagem,Long>{
	

}
