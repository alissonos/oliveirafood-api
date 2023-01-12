package com.oliveira.oliveirafood.domain.repository;

import org.springframework.stereotype.Repository;

import com.oliveira.oliveirafood.domain.model.Usuario;

@Repository
public interface UsuarioRepository extends CustomJpaRepository<Usuario, Long> {

}
