package com.oliveira.oliveirafood.domain.repository;

import java.util.List;

import com.oliveira.oliveirafood.domain.model.FormaDePagamento;

public interface FormaDePagamentoRepository {
	
	List<FormaDePagamento> listar();
	FormaDePagamento buscar(Long id);
	FormaDePagamento salvar(FormaDePagamento pagamento);
	void remover(FormaDePagamento pagamento);
}
