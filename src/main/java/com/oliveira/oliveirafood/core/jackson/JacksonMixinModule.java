package com.oliveira.oliveirafood.core.jackson;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.module.SimpleModule;
import com.oliveira.oliveirafood.api.model.mixin.CidadeMixin;
import com.oliveira.oliveirafood.api.model.mixin.CozinhaMixin;
import com.oliveira.oliveirafood.domain.model.Cidade;
import com.oliveira.oliveirafood.domain.model.Cozinha;

@Component
public class JacksonMixinModule extends SimpleModule{

	private static final long serialVersionUID = 1L;
	
	public JacksonMixinModule() {
		setMixInAnnotation(Cozinha.class, CozinhaMixin.class);
		setMixInAnnotation(Cidade.class, CidadeMixin.class);
	}
}
