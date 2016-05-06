<%-- 
    Document   : tabelafuncionario
    Created on : 30/04/2016, 19:07:58
    Author     : rjs
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/estiloformulario.css"/>
        <title>Tabela de Funcionários</title>
    </head>
    <body style="background-color: buttonface">
        <h3>Lista de Funcionários</h3>
        <table border="1" style="width:100%" id="tabelaproduto">
            <tr>
                <th>Código Funcionário</th>
                <th>Nome Funcionário</th>
                <th>Cargo</th>
                <th>Local de Trabalho</th>
            </tr>
            <c:forEach items="${listafuncionario}" var="fun">
                <tr>
                    <td></td>
                    <td>${fun.nome}</td>
                    <td>${fun.cargo}</td>
                    <td>${fun.local_trabalho}</td>
                </tr>
            </c:forEach>
        </table>
        <a id="linkvoltar" href="index.jsp">Voltar</a>
    </body>
</html>
