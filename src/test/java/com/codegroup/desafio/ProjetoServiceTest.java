package com.codegroup.desafio;

import com.codegroup.desafio.exception.ExclusionNotAllowedException;
import com.codegroup.desafio.exception.ResourceNotFoundException;
import com.codegroup.desafio.model.Pessoa;
import com.codegroup.desafio.model.Projeto;
import com.codegroup.desafio.repository.ProjetoRepository;
import com.codegroup.desafio.service.ProjetoServiceImpl;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProjetoServiceTest {

    @Mock
    private ProjetoRepository projetoRepository;

    @InjectMocks
    private ProjetoServiceImpl projetoService;

    private Projeto projeto;

    @BeforeEach
    public void setup(){

        Pessoa pessoa = new Pessoa();
        pessoa.setId(22l);

        projeto = new Projeto();
        projeto.setId(1l);
        projeto.setGerente(pessoa);
        projeto.setStatus("ANDAMENTO");
        projeto.setDescricao("Projeto");
        projeto.setRisco("BAIXO");
        projeto.setOrcamento(1.0);
        projeto.setDataInicio(LocalDate.now());
        projeto.setDataPrevisaoFim(LocalDate.now());
        projeto.setDataFim(LocalDate.now());

    }   

    @Test
    @Order(1)
    public void saveProjetoTest(){
        // precondition
        given(projetoRepository.save(projeto)).willReturn(projeto);

        //action
        Projeto savedProjeto = projetoService.saveProjeto(projeto);

        // verify the output
        System.out.println(savedProjeto);
        assertThat(savedProjeto).isNotNull();
    }


    @Test
    @Order(2)
    public void getProjetoById() throws ResourceNotFoundException {
        // precondition
        given(projetoRepository.findById(1L)).willReturn(Optional.of(projeto));

        // action
        Projeto existingProjeto = projetoService.findById(projeto.getId());

        // verify
        System.out.println(existingProjeto);
        assertThat(existingProjeto).isNotNull();

    }


    @Test
    @Order(3)
    public void getAllProjeto(){


        Pessoa pessoa = new Pessoa();
        pessoa.setId(1l);

        Projeto projeto1 = new Projeto();
        projeto1.setId(1l);
        projeto1.setGerente(pessoa);
        projeto1.setStatus("ANDAMENTO");
        projeto1.setDescricao("Projeto 1");
        projeto1.setRisco("BAIXO");
        projeto1.setOrcamento(1.0);
        projeto1.setDataInicio(LocalDate.now());
        projeto1.setDataPrevisaoFim(LocalDate.now());
        projeto1.setDataFim(LocalDate.now());

        // precondition
        given(projetoRepository.findAll()).willReturn(List.of(projeto,projeto1));

        // action
        List<Projeto> projetoList = projetoService.findAll();

        // verify
        System.out.println(projetoList);
        assertThat(projetoList).isNotNull();
        assertThat(projetoList.size()).isGreaterThan(1);
    }

    @Test
    @Order(4)
    public void updateProjeto() throws ResourceNotFoundException {

        // precondition
        given(projetoRepository.findById(projeto.getId())).willReturn(Optional.of(projeto));
        projeto.setStatus("CANCELADO");
        projeto.setDescricao("Projeto Inicial");
        projeto.setRisco("ALTO");
        given(projetoRepository.save(projeto)).willReturn(projeto);

        // action
        Projeto updatedProjeto = projetoService.updateProjeto(projeto.getId(),projeto);

        // verify
        System.out.println(updatedProjeto);
        assertThat(updatedProjeto.getStatus()).isEqualTo("CANCELADO");
        assertThat(updatedProjeto.getDescricao()).isEqualTo("Projeto Inicial");
        assertThat(updatedProjeto.getRisco()).isEqualTo("ALTO");
    }

    @Test
    @Order(5)
    public void deleteProjeto() throws ExclusionNotAllowedException, ResourceNotFoundException {

        given(projetoRepository.findById(projeto.getId())).willReturn(Optional.of(projeto));
        projeto.setStatus("CANCELADO");
        // action
        projetoService.deleteProjeto(projeto.getId());

    }

}
