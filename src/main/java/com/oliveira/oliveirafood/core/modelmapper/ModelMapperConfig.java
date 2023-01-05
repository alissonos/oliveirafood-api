package com.oliveira.oliveirafood.core.modelmapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.oliveira.oliveirafood.api.model.EnderecoModel;
import com.oliveira.oliveirafood.domain.model.Endereco;

import lombok.experimental.var;

@Configuration
public class ModelMapperConfig {
	
	@Bean
	public ModelMapper modelMapper() {
		var modelMapper = new ModelMapper();
		
//		modelMapper.createTypeMap(Restaurante.class, RestauranteModel.class)
//			.addMapping(Restaurante::getTaxaFrete, RestauranteModel::setPrecoFrete);
		
		var enderecoToEnderecoModelTypeMap = modelMapper.createTypeMap
				(Endereco.class, EnderecoModel.class);
		
		enderecoToEnderecoModelTypeMap.<String>addMapping(
				enderecoSrc -> enderecoSrc.getCidade().getEstado().getNome(),
				(endereoModelDest, value) -> endereoModelDest.getCidade().setEstado(value));
		
		return modelMapper;
	}
}
