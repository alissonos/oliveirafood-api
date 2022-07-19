package com.oliveira.oliveirafood.infrastructure.repository;

import java.util.List;

import org.springframework.stereotype.Component;

import com.oliveira.oliveirafood.domain.model.FormaDePagamento;
import com.oliveira.oliveirafood.domain.repository.FormaDePagamentoRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Component
public class FormaDePagamentoRepositoryImpl implements FormaDePagamentoRepository{

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<FormaDePagamento> listar() {
		return manager.createQuery("from FormaDePagamento", FormaDePagamento.class).getResultList();
	}
	
	@Override
	public FormaDePagamento buscar(Long id) {
		return manager.find(FormaDePagamento.class, id);
	}
	
	@Transactional
	@Override
	public FormaDePagamento salvar(FormaDePagamento pagamento) {
		return manager.merge(pagamento);
	}
	
	@Transactional
	@Override
	public void remover(FormaDePagamento pagamento) {
		pagamento = buscar(pagamento.getId());
		manager.remove(pagamento);
	}

}
