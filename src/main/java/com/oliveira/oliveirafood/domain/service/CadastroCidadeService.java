package com.oliveira.oliveirafood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.oliveira.oliveirafood.domain.exception.EntidadeEmUsoException;
import com.oliveira.oliveirafood.domain.exception.EntidadeNaoEncontradaException;
import com.oliveira.oliveirafood.domain.model.Cidade;
import com.oliveira.oliveirafood.domain.repository.CidadeRepository;

@Service
public class CadastroCidadeService {
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	public Cidade salvar (Cidade cidade) {
		return cidadeRepository.salvar(cidade);
	}
	
	public void excluir (Long cidadeId) {
		try {
			cidadeRepository.remover(cidadeId);
			
		} catch (EmptyResultDataAccessException e) {			
			throw new EntidadeNaoEncontradaException(
					String.format("Não existe cadastro de Cidade com o código", cidadeId));
		
		} catch (DataIntegrityViolationException e) {			
			throw new EntidadeEmUsoException(
					String.format("Cidade do código %d não pode ser removido", cidadeId));
		}
	}
}






