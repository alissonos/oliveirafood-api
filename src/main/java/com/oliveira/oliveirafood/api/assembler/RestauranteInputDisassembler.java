package com.oliveira.oliveirafood.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.oliveira.oliveirafood.api.model.input.RestauranteInput;
import com.oliveira.oliveirafood.domain.model.Cozinha;
import com.oliveira.oliveirafood.domain.model.Restaurante;

@Component
public class RestauranteInputDisassembler {
	
	@Autowired 
	private ModelMapper modelMapper;
	
    public Restaurante toDomainObject(RestauranteInput restauranteInput) {
       
    	return modelMapper.map(restauranteInput, Restaurante.class);
    }
    
    public void copyToDomainObject(RestauranteInput restauranteInput, Restaurante restaurante) {
// Para evitar org.hibernate.HibernateException: identifier of an instance of 
//    	com.oliveira.oliveirafood.domain.model.Cozinha was altered from 1 to 2

    	restaurante.setCozinha(new Cozinha());
    	
    	modelMapper.map(restauranteInput, restaurante);
    }
}