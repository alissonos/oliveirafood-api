package com.oliveira.oliveirafood.jpa;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.oliveira.oliveirafood.OliveirafoodApiApplication;
import com.oliveira.oliveirafood.domain.model.Restaurante;
import com.oliveira.oliveirafood.domain.repository.RestauranteRepository;

public class InclusaoRestauranteMain {
	
	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new SpringApplicationBuilder(OliveirafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		RestauranteRepository restauranteRepository = applicationContext.getBean(RestauranteRepository.class);
		
		Restaurante restaurante1 = new Restaurante();
		restaurante1.setNome("Madero");
		
		Restaurante restaurante2 = new Restaurante();
		restaurante2.setNome("Girafas");
		
		restaurante1 = restauranteRepository.salvar(restaurante1);
		restaurante2 = restauranteRepository.salvar(restaurante2);
		
		System.out.printf("%d - %s\n", restaurante1.getId(), restaurante1.getNome());
		System.out.printf("%d - %s\n", restaurante2.getId(), restaurante2.getNome());
	}
}
