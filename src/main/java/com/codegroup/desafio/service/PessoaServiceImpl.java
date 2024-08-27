package com.codegroup.desafio.service;

import com.codegroup.desafio.exception.ResourceNotFoundException;
import com.codegroup.desafio.model.Pessoa;
import com.codegroup.desafio.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PessoaServiceImpl implements PessoaService{

    @Autowired
    PessoaRepository pessoaRepository;

    /**
     * Método responável por buscar todos os Pessoas
     * @return
     */
    public List<Pessoa> findAll(){
        return this.pessoaRepository.findAll();
    }

    /**
     * Método responável por buscar um Pessoa por Id especifico
     * @param pessoaId
     * @return
     * @throws ResourceNotFoundException
     */
    public Pessoa findById(Long pessoaId) throws ResourceNotFoundException {

        Pessoa pessoa = this.pessoaRepository.findById(pessoaId).orElseThrow(() -> new ResourceNotFoundException("Pessoa não encontrada"));


        return pessoa;
    }

    /**
     * Método responável por criar uma Pessoa
     * @param Pessoa
     * @return
     */
    public Pessoa savePessoa(Pessoa Pessoa) {

        return this.pessoaRepository.save(Pessoa);
    }
    
}
