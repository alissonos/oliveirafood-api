package com.oliveira.oliveirafood.jpa;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.oliveira.oliveirafood.OliveirafoodApiApplication;
import com.oliveira.oliveirafood.domain.model.FormaDePagamento;
import com.oliveira.oliveirafood.domain.repository.FormaDePagamentoRepository;

public class InclusaoFormaDePagamentoMain {
	
	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new SpringApplicationBuilder(OliveirafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		FormaDePagamentoRepository pagamentoRepository = applicationContext.getBean(FormaDePagamentoRepository.class);
		
		FormaDePagamento pagamento1 = new FormaDePagamento();
		pagamento1.setDescricao("Crédito");
		
		FormaDePagamento pagamento2 = new FormaDePagamento();
		pagamento2.setDescricao("Débito");
		
		pagamento1 = pagamentoRepository.salvar(pagamento1);
		pagamento2 = pagamentoRepository.salvar(pagamento2);
		
		System.out.printf("%d - %s\n", pagamento1.getId(), pagamento1.getDescricao());
		System.out.printf("%d - %s\n", pagamento2.getId(), pagamento2.getDescricao());
	}
}
