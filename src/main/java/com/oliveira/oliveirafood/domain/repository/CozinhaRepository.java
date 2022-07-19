package com.oliveira.oliveirafood.domain.repository;

import java.util.List;

import com.oliveira.oliveirafood.domain.model.Cozinha;

public interface CozinhaRepository {
	
	List<Cozinha> listar();
	Cozinha porId(Long id);
	Cozinha adicionar(Cozinha cozinha);
	void remover(Cozinha cozinha);
}
