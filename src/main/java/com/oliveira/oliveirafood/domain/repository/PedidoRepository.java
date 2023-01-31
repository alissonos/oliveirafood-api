package com.oliveira.oliveirafood.domain.repository;

import org.springframework.stereotype.Repository;

import com.oliveira.oliveirafood.domain.model.Pedido;

@Repository
public interface PedidoRepository extends CustomJpaRepository<Pedido, Long> {

}