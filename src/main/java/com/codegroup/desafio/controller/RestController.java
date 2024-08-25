package com.codegroup.desafio.controller;


import com.codegroup.desafio.exception.ExclusionNotAllowedException;
import com.codegroup.desafio.exception.ResourceNotFoundException;
import com.codegroup.desafio.model.Projeto;
import com.codegroup.desafio.service.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 *
 *
 * Classe responsável por expor os métodos via Rest API
 */
@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api/v1")
public class RestController {

    @Autowired
    ProjetoService projetoService;

    /**
     *
     * @return
     */
    @GetMapping("/projetos")
    @ResponseStatus(HttpStatus.OK)
    public List<Projeto> findAll() {

        return this.projetoService.findAll();
    }

    /**
     *
     * @param projetoId
     * @return
     * @throws ResourceNotFoundException
     */
    @GetMapping("/projetos/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Projeto> findById(@PathVariable(value = "id") Long projetoId)
            throws ResourceNotFoundException {

        Projeto projeto = this.projetoService.findById(projetoId);

        return ResponseEntity.ok().body(projeto);
    }

    /**
     *
     * @param projeto
     * @return
     */
    @PostMapping("/projetos")
    @ResponseStatus(HttpStatus.CREATED)
    public Projeto createProjeto(@RequestBody Projeto projeto) {
        return this.projetoService.saveProjeto(projeto);

    }

    /**
     *
     * @param projetoId
     * @param projeto
     * @return
     * @throws ResourceNotFoundException
     */
    @PutMapping("/projetos/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Projeto> updateProjeto(@PathVariable(value = "id") Long projetoId, @RequestBody Projeto projeto) throws ResourceNotFoundException {
        return ResponseEntity.ok(this.projetoService.updateProjeto(projetoId, projeto));

    }

    /**
     *
     * @param projetoId
     * @return
     * @throws ResourceNotFoundException
     * @throws ExclusionNotAllowedException
     */
    @DeleteMapping("/projetos/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Boolean> deleteProjeto(@PathVariable(value = "id") Long projetoId) throws ResourceNotFoundException, ExclusionNotAllowedException {
        return this.projetoService.deleteProjeto(projetoId);
    }
}
