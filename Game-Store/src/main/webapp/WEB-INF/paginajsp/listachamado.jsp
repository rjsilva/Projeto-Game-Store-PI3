<%-- 
    Document   : listachamado
    Created on : 19/05/2016, 18:25:25
    Author     : rjs
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="js/validacao.js"></script>
        <link rel="stylesheet" href="css/estiloformulario.css"/>
        <title>Lista Chamado</title>
        <style type="text/css">
            #btnchamado{
                
                margin: 0px 500px;
            }
        </style>
    </head>
    <body onload="validarPermissaoAcesso()">
        <jsp:include page="../template/layout.jsp"/>
        <div class="conteudo">
            <h3>Lista de Chamado</h3>
            <input id="user" type="hidden" value="${user.login.toUpperCase()}"/>
            <table border="1" style="width:100%" class="table">
                <tr>
                    <th>FUNCIONÁRIO</th>
                    <th>TELEFONE</th>
                    <th>ASSUNTO</th>
                    <th>EMAIL</th>
                    <th>STATUS</th>
                    <th>DATA_CHAMADO</th>
                </tr>
                <c:forEach items="${listachamado}" var="chamado">
                    <tr>
                        <td>${chamado.funcionario.nome}</td>
                        <td>${chamado.telefone}</td>
                        <td>${chamado.assunto}</td>
                        <td>${chamado.email}</td>
                        <td>${chamado.status}</td>
                        <td>${chamado.data}</td>
                    </tr>
                </c:forEach>
            </table>
            <a href="ChamadoServlet?acao=atualizar&id=${chamado.id}" class="btn btn-primary" id="btnchamado">Atender Chamado</a>
        </div>
    </body>
</html>
