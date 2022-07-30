package com.oliveira.oliveirafood.domain.repository;

import java.util.List;

import com.oliveira.oliveirafood.domain.model.Estado;

public interface EstadoRepository {
	
	List<Estado> listar();
	Estado buscar(Long id);
	Estado salvar(Estado estado);
	void remover(Long estadoId);
}
