package com.oliveira.oliveirafood.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oliveira.oliveirafood.domain.model.Estado;
import com.oliveira.oliveirafood.domain.repository.EstadoRepository;

@RestController
@RequestMapping("/estados")
public class EstadoController {
	
	private EstadoRepository estadoRepository;
	
	public List<Estado> listar() {
		return estadoRepository.listar();
	}
	
}
