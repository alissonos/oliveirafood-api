package com.oliveira.oliveirafood.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.oliveira.oliveirafood.api.assembler.PedidoInputDisassembler;
import com.oliveira.oliveirafood.api.assembler.PedidoModelAssembler;
import com.oliveira.oliveirafood.api.assembler.PedidoResumoModelAssembler;
import com.oliveira.oliveirafood.api.model.PedidoModel;
import com.oliveira.oliveirafood.api.model.PedidoResumoModel;
import com.oliveira.oliveirafood.api.model.input.PedidoInput;
import com.oliveira.oliveirafood.domain.exception.EntidadeNaoEncontradaException;
import com.oliveira.oliveirafood.domain.exception.NegocioException;
import com.oliveira.oliveirafood.domain.model.Pedido;
import com.oliveira.oliveirafood.domain.model.Usuario;
import com.oliveira.oliveirafood.domain.repository.PedidoRepository;
import com.oliveira.oliveirafood.domain.repository.filter.PedidoFilter;
import com.oliveira.oliveirafood.domain.service.EmissaoPedidoService;
import com.oliveira.oliveirafood.infraestructure.repository.spec.PedidoSpecs;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoController {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private EmissaoPedidoService emissaoPedido;
	
	@Autowired
	private PedidoModelAssembler pedidoModelAssembler;
	
	@Autowired
	private PedidoResumoModelAssembler pedidoResumoModelAssembler;
	
	@Autowired
	private PedidoInputDisassembler pedidoInputDisassembler;
	
	@GetMapping
	public List<PedidoResumoModel> pesquisar(PedidoFilter filtro) {
		List<Pedido> todosPedidos = pedidoRepository.findAll(PedidoSpecs.usandoFiltro(filtro));
		
		return pedidoResumoModelAssembler.toCollectionModel(todosPedidos);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public PedidoModel adicionar(@Valid @RequestBody PedidoInput pedidoInput) {
		try {
			Pedido novoPedido = pedidoInputDisassembler.toDomainObject(pedidoInput);

			// TODO pegar usuário autenticado
			novoPedido.setCliente(new Usuario());
			novoPedido.getCliente().setId(1L);

			novoPedido = emissaoPedido.emitir(novoPedido);

			return pedidoModelAssembler.toModel(novoPedido);
		} catch (EntidadeNaoEncontradaException e) {
			throw new NegocioException(e.getMessage(), e);
		}
	}
	
	@GetMapping("/{codigoPedido}")
	public PedidoModel buscar(@PathVariable String codigoPedido) {
		Pedido pedido = emissaoPedido.buscarOuFalhar(codigoPedido);
		
		return pedidoModelAssembler.toModel(pedido);
	}
	
}
