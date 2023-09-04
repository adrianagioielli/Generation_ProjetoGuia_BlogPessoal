package com.generation.blogPessoal.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.generation.blogPessoal.Model.Tema;

public interface TemaRepository extends JpaRepository<Tema,Long>{
	
	public List<Tema> findAllByDescricaoContainigIgnoreCase(@Param("descricao")String descricao);
	
}
