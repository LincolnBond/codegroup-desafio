<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<head>
    <title>Projetos</title>

    <link rel="stylesheet"
        	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css">
        <script
        	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script
        	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <script
            src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js"></script>

    <style>
        a{
            color: white;
        }
        a:hover {
            color: white;
            text-decoration: none;
        }
    </style>

</head>
<body>

    <div class="container">

        <h1 class="p-3"> Lista de projetos</h1>

        <form:form>

            <table class="table table-bordered">
            	<tr>
            		<th>Id</th>
            		<th>Nome</th>
            		<th>Descição</th>
            		<th>Risco</th>
            		<th>Data início</th>
            		<th>Data fim</th>
            		<th>Data previsão fim</th>
            		<th>Orçamento</th>
            		<th>Status</th>
            		<th>Gerente</th>
            		<th>Editar</th>
            		<th>Excluir</th>
            	</tr>

            	<c:forEach var="projeto" items="${projetos}">
                    <tr>
                		<td>${projeto.id}</td>
                		<td>${projeto.nome}</td>
                		<td>${projeto.descricao}</td>
                		<td>${projeto.risco}</td>
                		<td>${projeto.dataInicio}</td>
                		<td>${projeto.dataFim}</td>
                		<td>${projeto.dataPrevisaoFim}</td>
                		<td>${projeto.orcamento}</td>
                		<td>${projeto.status}</td>
                		<td>${projeto.gerente.nome}</td>
                		<td><button type="button" class="btn btn-primary">
                                <a href="/editarProjeto/${projeto.id}">Editar</a>
                		</button></td>
                		<td><button type="button" class="btn btn-danger">
                			<a href="/deleteProjeto/${projeto.id}">Excluir</a>
                		</button></td>
                	</tr>

            	</c:forEach>

            </table>

        </form:form>

        <button type="button" class="btn btn-primary btn-block">
        	<a href="/createProjeto">Criar novo Projeto</a>
        </button>

    </div>

    <script th:inline="javascript">
                window.onload = function() {

                    var mensagem = "${mensagem}";
                    var status = "${status}";
                    if (status == "SUCESSO") {
                        Command: toastr["success"](mensagem)
                    } else if (status == "ERRO") {
                        Command: toastr["error"](mensagem)
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
                        }
        	    }
            </script>

</body>

</html>