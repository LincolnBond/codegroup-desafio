package com.codegroup.desafio.service;

import com.codegroup.desafio.exception.ExclusionNotAllowedException;
import com.codegroup.desafio.exception.ResourceNotFoundException;
import com.codegroup.desafio.model.Projeto;

import java.util.List;
import java.util.Map;


public interface ProjetoService {

    public List<Projeto> findAll();

    public Projeto findById(Long projetoId) throws ResourceNotFoundException;

    public Projeto saveProjeto(Projeto projeto);

    public Projeto updateProjeto(Long projetoId, Projeto projeto) throws ResourceNotFoundException;

    public Map<String, Boolean> deleteProjeto(Long projetoId) throws ResourceNotFoundException, ExclusionNotAllowedException;
}
