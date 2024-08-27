package com.codegroup.desafio.service;

import com.codegroup.desafio.exception.ResourceNotFoundException;
import com.codegroup.desafio.model.Pessoa;

import java.util.List;


public interface PessoaService {

    public List<Pessoa> findAll();

    public Pessoa findById(Long pessoaId) throws ResourceNotFoundException;

    public Pessoa savePessoa(Pessoa pessoa);
}
