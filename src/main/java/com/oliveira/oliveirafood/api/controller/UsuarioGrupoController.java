package com.oliveira.oliveirafood.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.oliveira.oliveirafood.api.assembler.GrupoModelAssembler;
import com.oliveira.oliveirafood.api.model.GrupoModel;
import com.oliveira.oliveirafood.domain.model.Usuario;
import com.oliveira.oliveirafood.domain.service.CadastroUsuarioService;

@RestController
@RequestMapping(value = "/usuarios/{usuarioId}/grupos")
public class UsuarioGrupoController {

    @Autowired
    private CadastroUsuarioService cadastroUsuarioService;
    
    @Autowired
    private GrupoModelAssembler grupoModelAssembler;
    
    @GetMapping
    public List<GrupoModel> listar(@PathVariable Long usuarioId) {
        Usuario usuario = cadastroUsuarioService.buscarOuFalhar(usuarioId);
        
        return grupoModelAssembler.toCollectionModel(usuario.getGrupos());
    }
    
    @DeleteMapping("/{grupoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void desassociar(@PathVariable Long usuarioId, @PathVariable Long grupoId) {
    	cadastroUsuarioService.desassociarGrupo(usuarioId, grupoId);
    }
    
    @PutMapping("/{grupoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void associar(@PathVariable Long usuarioId, @PathVariable Long grupoId) {
    	cadastroUsuarioService.associarGrupo(usuarioId, grupoId);
    }        
}      
