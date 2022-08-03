package com.oliveira.oliveirafood.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oliveira.oliveirafood.domain.model.FormaPagamento;

public interface FormaPagamentoRepository extends JpaRepository<FormaPagamento, Long>{
	
}
