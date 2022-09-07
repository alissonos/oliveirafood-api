package com.oliveira.oliveirafood.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

//@ResponseStatus(value = HttpStatus.NOT_FOUND) //, reason = "Entidade não encontrada")
public class EntidadeNaoEncontradaException extends ResponseStatusException {

	private static final long serialVersionUID = 1L;

	public EntidadeNaoEncontradaException(HttpStatusCode status, String mensagem) {
		super(status, mensagem);
	}

	public EntidadeNaoEncontradaException(String mensagem) {
		this(HttpStatus.CONFLICT, mensagem);
	}
	
}
