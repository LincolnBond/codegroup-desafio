<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <title>Editar Projeto</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js"></script>
</head>

<body>
    <div class="container">
        <h1 class="p-3">Editar Projeto</h1>
        <form:form action="/updateProjeto" method="post" modelAttribute="projeto">
            <form:input path="id" type="hidden" />
            <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-3" for="nome">Nome</label>
                        <div class="col-md-6">
                            <form:input type="text" path="nome" id="nome"
                                class="form-control input-sm" required="required" />
                        </div>
                    </div>
                </div>
             <div class="row">
                     <div class="form-group col-md-12">
                         <label class="col-md-3" for="gerente">Gerente</label>
                         <div class="col-md-6">
                            <form:select  path="gerente" name="gerente" class="form-control input-sm" required="required" id="gerente">
                                <form:option value=""> --SELECT--</form:option>
                                <form:options items="${pessoas}" itemLabel="nome" itemValue="id"/>
                              </form:select>
                         </div>
                     </div>
                 </div>
            <div class="row">
                <div class="form-group col-md-12">
                    <label class="col-md-3" for="risco">Risco</label>
                    <div class="col-md-6">
                       <select class="form-select" name="risco" path="risco" id="risco">
                         <option value="BAIXO">BAIXO</option>
                         <option value="MEDIO">MEDIO</option>
                         <option value="ALTO">ALTO</option>
                       </select>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-md-12">
                    <label class="col-md-3" for="status">Status</label>
                    <div class="col-md-6">
                        <select class="form-select" name="status" path="status" id="status">
                         <option value="ANALISE">ANÁLISE</option>
                         <option value="ANALISE_REALIZADA">ANÁLISE REALIZADA</option>
                         <option value="ANALISE_APROVADA">ANÁLISE APROVADA</option>
                         <option value="INICIADO">INICIADO</option>
                         <option value="PLANEJADO">PLANEJADO</option>
                         <option value="ANDAMENTO">ANDAMENTO</option>
                         <option value="ENCERRADO">ENCERRADO</option>
                         <option value="CANCELADO">CANCELADO</option>
                       </select>
                    </div>
                </div>
            </div>


            <div class="row">
                <div class="form-group col-md-12">
                    <label class="col-md-3" for="descricao">Descrição</label>
                    <div class="col-md-6">
                        <form:input type="text" path="descricao" id="descricao"
                            class="form-control input-sm" required="required" />
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-md-12">
                    <label class="col-md-3" for="orcamento">Orçamento</label>
                    <div class="col-md-6">
                        <form:input type="number" path="orcamento" id="orcamento"
                            class="form-control input-sm" required="required" />
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="form-group col-md-12">
                    <label class="col-md-3" for="dataInicio">Data inicio</label>
                    <div class="col-md-6">
                        <form:input type="date" name="dataInicio" path="dataInicio" id="dataInicio"
                            class="form-control input-sm"  />
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-md-12">
                    <label class="col-md-3" for="dataFim">Data fim</label>
                    <div class="col-md-6">
                        <form:input type="date" name="dataFim" path="dataFim" id="dataFim"
                            class="form-control input-sm"  />
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-md-12">
                    <label class="col-md-3" for="dataPrevisaoFim">Data previsão de fim</label>
                    <div class="col-md-6">
                        <form:input type="date" name="dataPrevisaoFim" path="dataPrevisaoFim" id="dataPrevisaoFim"
                            class="form-control input-sm"/>
                    </div>
                </div>
            </div>

            <div class="row p-2">
                <div class="col-md-2">
                    <button type="submit" value="Register" class="btn btn-success">Salvar</button>
                </div>
            </div>
        </form:form>
    </div>

    <script th:inline="javascript">
        window.onload = function() {

            var mensagem = "${mensagem}";
            console.log(msg);
            if (status === "ERRO") {
                toastr["error"](mensagem);
            }

            toastr.options = {
                "closeButton": true,
                "debug": false,
                "newestOnTop": false,
                "progressBar": true,
                "positionClass": "toast-top-right",
                "preventDuplicates": false,
                "showDuration": "300",
                "hideDuration": "1000",
                "timeOut": "5000",
                "extendedTimeOut": "1000",
                "showEasing": "swing",
                "hideEasing": "linear",
                "showMethod": "fadeIn",
                "hideMethod": "fadeOut"
            };
        };
    </script>
</body>

</html>
