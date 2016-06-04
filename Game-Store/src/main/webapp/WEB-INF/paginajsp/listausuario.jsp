<%-- 
    Document   : listausuario
    Created on : 09/05/2016, 01:19:38
    Author     : rjs
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="css/estiloformulario.css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="../template/layout.jsp"/>
        <div class="conteudo">
            <h3>Lista de Usuários</h3>
            <table border="1" style="width:100%" class="table">
                <tr>
                    <th>NOME USUÁRIO</th>
                    <th>NÍVEL DE ACESSO</th>
                    <th>LOGIN</th>
                    <th>FILIAL</th>
                </tr>
                <c:forEach items="${listausuario}" var="usuario">
                    <tr>
                        <td>${usuario.nome}</td>
                        <td>${usuario.nivelacesso}</td>
                        <td>${usuario.login}</td>
                        <td>${usuario.filial.razao_social}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
