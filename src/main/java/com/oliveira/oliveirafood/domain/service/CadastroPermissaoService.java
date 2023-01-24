package com.oliveira.oliveirafood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oliveira.oliveirafood.domain.exception.PermissaoNaoEncontradaException;
import com.oliveira.oliveirafood.domain.model.Permissao;
import com.oliveira.oliveirafood.domain.repository.PermissaoRepository;

@Service
public class CadastroPermissaoService {

    @Autowired
    private PermissaoRepository permissaoRepository;
    
    public Permissao buscarOuFalhar(Long permissaoId) {
        return permissaoRepository.findById(permissaoId)
            .orElseThrow(() -> new PermissaoNaoEncontradaException(permissaoId));
    }
}
