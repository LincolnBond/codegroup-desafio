package com.codegroup.desafio.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "pessoa")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome",nullable = false)
    private String nome;

    @Column(name = "datanascimento",nullable = false)
    @JsonFormat(pattern="dd/MM/yyyy")
    private LocalDate dataNascimento;

    @Column(name = "cpf",nullable = false)
    private String cpf;

    @Column(name = "funcionario",nullable = false)
    private Boolean isFuncionario;

    @Column(name = "gerente",nullable = false)
    private Boolean isGerente;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Boolean getFuncionario() {
        return isFuncionario;
    }

    public void setFuncionario(Boolean funcionario) {
        isFuncionario = funcionario;
    }

    public Boolean getGerente() {
        return isGerente;
    }

    public void setGerente(Boolean gerente) {
        isGerente = gerente;
    }

}
