<%-- 
    Document   : tabelafuncionario
    Created on : 30/04/2016, 19:07:58
    Author     : rjs
--%>

<%@page import="br.com.gamestore.modelo.Funcionario"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="css/estiloformulario.css"/>
        <title>Tabela de Funcionários</title>
        <script type="text/javascript">
            function exclusao(id) {

                if (window.confirm('tem certeza que deseja excluir?')) {

                    location.href = "FuncionarioServlet?acao=excluir&id=" + id;
                }
            }
        </script>
    </head>
    <body style="background-color: buttonface">
        <jsp:include page="../template/layout.jsp"/>
        <div class="conteudo">
            <h3>Lista de Funcionários</h3>
            <table border="1" style="width:100%" class="table">
                <tr>
                    <th>Código Funcionário</th>
                    <th>Nome Funcionário</th>
                    <th>Cargo</th>
                    <th>Local de Trabalho</th>
                    <th>Excluir</th>
                    <th>Atualizar</th>
                </tr>
                <%
                    Funcionario func = new Funcionario();
                %>
                <c:forEach items="${listafuncionario}" var="fun">
                    <tr>
                        <td>${fun.id}</td>
                        <td>${fun.nome}</td>
                        <td>${fun.cargo}</td>
                        <td>${fun.local_trabalho}</td>
                        <td><a href="javascript:exclusao(${fun.id})" class="btn btn-primary">Excluir</a></td>
                        <td><a href="FuncionarioServlet?acao=atualizar&id=${fun.id}" class="btn btn-primary">Atualizar</a></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
