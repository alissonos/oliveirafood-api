package com.oliveira.oliveirafood.api.model.mixin;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.oliveira.oliveirafood.domain.model.Restaurante;

@JsonRootName("cozinha")
public abstract class CozinhaMixin {
	
	@JsonIgnore
	private List<Restaurante> restaurantes;
}
