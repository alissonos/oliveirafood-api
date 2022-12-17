package com.oliveira.oliveirafood.api.model.mixin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.oliveira.oliveirafood.domain.model.Estado;

public abstract class CidadeMixin {
	
	@JsonIgnoreProperties(value = "nome", allowGetters = true)
    private Estado estado;
}
