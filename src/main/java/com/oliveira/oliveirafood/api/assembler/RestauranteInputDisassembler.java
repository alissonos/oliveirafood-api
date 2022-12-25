package com.oliveira.oliveirafood.api.assembler;

import org.springframework.stereotype.Component;

import com.oliveira.oliveirafood.api.model.input.RestauranteInput;
import com.oliveira.oliveirafood.domain.model.Cozinha;
import com.oliveira.oliveirafood.domain.model.Restaurante;

@Component
public class RestauranteInputDisassembler {

    public Restaurante toDomainObject(RestauranteInput restauranteInput) {
        Restaurante restaurante = new Restaurante();
        restaurante.setNome(restauranteInput.getNome());
        restaurante.setTaxaFrete(restauranteInput.getTaxaFrete());
        
        Cozinha cozinha = new Cozinha();
        cozinha.setId(restauranteInput.getCozinha().getId());
        
        restaurante.setCozinha(cozinha);
        
        return restaurante;
    }
    
}
