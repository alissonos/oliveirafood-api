package com.oliveira.oliveirafood.core.jackson;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.module.SimpleModule;
import com.oliveira.oliveirafood.api.model.mixin.RestauranteMixin;
import com.oliveira.oliveirafood.domain.model.Restaurante;

@Component
public class JacksonMixinModule extends SimpleModule{

	private static final long serialVersionUID = 1L;
	
	public JacksonMixinModule() {
		setMixInAnnotation(Restaurante.class, RestauranteMixin.class);
	}

}
