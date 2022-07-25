package com.oliveira.oliveirafood.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oliveira.oliveirafood.domain.model.Cozinha;
import com.oliveira.oliveirafood.domain.repository.CozinhaRepository;

@RestController
@RequestMapping(value = "/cozinhas") //, produces = MediaType.APPLICATION_JSON_VALUE)
public class CozinhaController {
	
	@Autowired
	private CozinhaRepository cozinhaRepository;
	
	@GetMapping
	public List<Cozinha> listar() {
		return cozinhaRepository.listar();
	}
	
//	@GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
//	public List<Cozinha> listar2() {
//		return cozinhaRepository.listar();
//	}
	
	@GetMapping("/{cozinhaId}")
	public Cozinha buscar(@PathVariable Long cozinhaId) {
		 return cozinhaRepository.buscar(cozinhaId);
	}
	
}




















