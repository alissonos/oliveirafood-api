package com.oliveira.oliveirafood.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.oliveira.oliveirafood.api.model.input.RestauranteInput;
import com.oliveira.oliveirafood.domain.model.Restaurante;

@Component
public class RestauranteInputDisassembler {
	
	@Autowired 
	private ModelMapper modelMapper;
	
    public Restaurante toDomainObject(RestauranteInput restauranteInput) {
       
    	return modelMapper.map(restauranteInput, Restaurante.class);
    }
    
}
