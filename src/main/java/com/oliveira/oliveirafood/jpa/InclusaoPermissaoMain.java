package com.oliveira.oliveirafood.jpa;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.oliveira.oliveirafood.OliveirafoodApiApplication;
import com.oliveira.oliveirafood.domain.model.Permissao;
import com.oliveira.oliveirafood.domain.repository.PermissaoRepository;

public class InclusaoPermissaoMain {
	
	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new SpringApplicationBuilder(OliveirafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		PermissaoRepository permissaoRepository = applicationContext.getBean(PermissaoRepository.class);
		
		Permissao permissao1 = new Permissao();
		permissao1.setNome("Álisson Silva");
		permissao1.setDescricao("Acesso total");
		
		permissao1 = permissaoRepository.salvar(permissao1);
		
//		System.out.printf("%d - %s - %s\n", permissao1.getId(), permissao1.getNome(), permissao1.getDescricao());
	}
}
