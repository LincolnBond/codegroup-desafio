package com.codegroup.desafio.model;

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
    private LocalDate dataInicio;

    @Column(name = "cpf",nullable = false)
    private String cpf;

    @Column(name = "funcionario",nullable = false)
    private Boolean funcionario;

    @Column(name = "gerente",nullable = false)
    private Boolean gerente;


}
