package com.oliveira.oliveirafood.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oliveira.oliveirafood.domain.model.Restaurante;

public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {
		
}
