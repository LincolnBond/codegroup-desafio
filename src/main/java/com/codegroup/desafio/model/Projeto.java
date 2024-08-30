package com.codegroup.desafio.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
@Entity
@Table(name = "projeto")
public class Projeto {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome",nullable = false)
    private String nome;

    @Column(name = "data_inicio",nullable = false)
    @JsonFormat(pattern="dd/MM/yyyy")
    private LocalDate dataInicio;

    @Column(name = "data_previsao_fim",nullable = false)
    @JsonFormat(pattern="dd/MM/yyyy")
    private LocalDate dataPrevisaoFim;

    @Column(name = "data_fim",nullable = false)
    @JsonFormat(pattern="dd/MM/yyyy")
    private LocalDate dataFim;

    @Column(name = "descricao",nullable = false)
    private String descricao;

    @Column(name = "status",nullable = false)
    private String status;

    @Column(name = "orcamento",nullable = false)
    private Double orcamento;

    @Column(name = "risco",nullable = false)
    private String risco;

    @OneToOne
    @JoinColumn(name = "idgerente", referencedColumnName = "id")
    private Pessoa gerente;

    public Pessoa getGerente() {
        if(gerente == null)
            return new Pessoa();
        return gerente;
    }

    public void setGerente(Pessoa gerente) {
        this.gerente = gerente;
    }

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

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataPrevisaoFim() {
        return dataPrevisaoFim;
    }

    public void setDataPrevisaoFim(LocalDate dataPrevisaoFim) {
        this.dataPrevisaoFim = dataPrevisaoFim;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(Double orcamento) {
        this.orcamento = orcamento;
    }

    public String getRisco() {
        return risco;
    }

    public void setRisco(String risco) {
        this.risco = risco;
    }
}
