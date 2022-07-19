package com.oliveira.oliveirafood.jpa;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.oliveira.oliveirafood.OliveirafoodApiApplication;
import com.oliveira.oliveirafood.domain.model.Restaurante;
import com.oliveira.oliveirafood.domain.repository.RestauranteRepository;

public class ExclusaoRestauranteMain {
	
	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new SpringApplicationBuilder(OliveirafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		RestauranteRepository restaurantes = applicationContext.getBean(RestauranteRepository.class);
		
		Restaurante restaurante1 = new Restaurante();
		restaurante1.setId(1L);
		
		Restaurante restaurante2 = new Restaurante();
		restaurante2.setId(2L);
		
		
		
		restaurantes.remover(restaurante1);
		restaurantes.remover(restaurante2);
	}
}
