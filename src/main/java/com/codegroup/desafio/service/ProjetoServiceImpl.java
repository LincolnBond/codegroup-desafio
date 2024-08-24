package com.codegroup.desafio.service;

import com.codegroup.desafio.StatusProjeto;
import com.codegroup.desafio.exception.ExclusionNotAllowedException;
import com.codegroup.desafio.exception.ResourceNotFoundException;
import com.codegroup.desafio.model.Projeto;
import com.codegroup.desafio.repository.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProjetoServiceImpl implements ProjetoService{

    @Autowired
    ProjetoRepository projetoRepository;

    /**
     * Método responável por buscar todos os projetos
     * @return
     */
    public List<Projeto> findAll(){
        return this.projetoRepository.findAll();
    }

    /**
     * Método responável por buscar um projeto por Id especifico
     * @param projetoId
     * @return
     * @throws ResourceNotFoundException
     */
    public Projeto findById(Long projetoId) throws ResourceNotFoundException {

        Projeto projeto = this.projetoRepository.findById(projetoId).orElseThrow(() -> new ResourceNotFoundException("Projeto não encontrado para o ID: " + projetoId));

        return projeto;
    }

    /**
     * Método responável por criar um projeto
     * @param projeto
     * @return
     */
    public Projeto createProjeto(Projeto projeto) {

        return this.projetoRepository.save(projeto);
    }


    /**
     * Método responável por alterar um projeto
     * @param projetoId
     * @param projeto
     * @return
     * @throws ResourceNotFoundException
     */
    public Projeto updateProjeto( Long projetoId, Projeto projeto) throws ResourceNotFoundException {

        Projeto projetoDB = projetoRepository.findById(projetoId).orElseThrow(() -> new ResourceNotFoundException("Projeto não encontrado para o ID :: " + projetoId));
        projetoDB.setNome(projeto.getNome());
        projetoDB.setDataInicio(projeto.getDataInicio());
        projetoDB.setDataFim(projeto.getDataFim());
        projetoDB.setDataPrevisaoFim(projeto.getDataPrevisaoFim());
        projetoDB.setDescricao(projeto.getDescricao());
        projetoDB.setRisco(projeto.getRisco());
        projetoDB.setStatus(projeto.getStatus());
        projetoDB.setRisco(projeto.getRisco());

        return this.projetoRepository.save(projetoDB);

    }

    /**
     * Método responável por excluir um projeto
     * @param projetoId
     * @return
     * @throws ResourceNotFoundException
     * @throws ExclusionNotAllowedException
     */
    public Map<String, Boolean> deleteProjeto(Long projetoId) throws ResourceNotFoundException, ExclusionNotAllowedException {

        Projeto projeto = projetoRepository.findById(projetoId).orElseThrow(() -> new ResourceNotFoundException("Projeto não encontrado para o ID: " + projetoId));

        validaStatus(projetoId, projeto);

        this.projetoRepository.delete(projeto);
        Map<String, Boolean> resposta = new HashMap<>();
        resposta.put("Projeto excluído!", Boolean.TRUE);
        return resposta;
    }

    /**
     * Se um projeto foi mudado o status para INICIADO, ANDAMENTO ou ENCERRADO não pode mais ser excluído
     * Clean code: Funções / métodos curtos que tenham um único propósito especifico.
     * @param projetoId
     * @param projeto
     * @throws ExclusionNotAllowedException
     */
    private static void validaStatus(Long projetoId, Projeto projeto) throws ExclusionNotAllowedException {

        //Clean code: Evitar códigos Hard-Coded (Usar Constantes e ENUM)
        if(projeto.getStatus().equals(StatusProjeto.INICIADO.getStatus()) || projeto.getStatus().equals(StatusProjeto.ANDAMENTO.getStatus()) || projeto.getStatus().equals(StatusProjeto.ENCERRADO.getStatus())){
            throw new ExclusionNotAllowedException("Projeto está com o status de INICIADO, ANDAMENTO ou ENCERRADO. ProjetoID: " + projetoId);
        }
    }
}
