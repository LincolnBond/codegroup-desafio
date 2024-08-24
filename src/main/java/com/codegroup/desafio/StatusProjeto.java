package com.codegroup.desafio;

public enum StatusProjeto {

    ANALISE("ANALISE"),
    ANALISE_REALIZADA("ANALISE_REALIZADA"),
    ANALISE_APROVADA("ANALISE_APROVADA"),
    INICIADO("INICIADO"),
    PLANEJADO("PLANEJADO"),
    ANDAMENTO("ANDAMENTO"),
    ENCERRADO("ENCERRADO"),
    CANCELADO("CANCELADO");

    private StatusProjeto(String status){
        this.status = status;
    }

    private String status;

    public String getStatus() {
        return status;
    }
}
