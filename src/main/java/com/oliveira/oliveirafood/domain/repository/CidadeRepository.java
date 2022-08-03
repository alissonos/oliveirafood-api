package com.oliveira.oliveirafood.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oliveira.oliveirafood.domain.model.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long>{
	
}
