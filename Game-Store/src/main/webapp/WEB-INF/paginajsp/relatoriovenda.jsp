<%-- 
    Document   : relatoriovenda
    Created on : 09/05/2016, 14:58:12
    Author     : rjs
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="css/estiloformulario.css"/>
        <title>Relatório de Estoque</title>
    </head>
    <body>
        <jsp:include page="../template/cabecalho.jsp"/>
        <jsp:include page="../template/menuesquerda.jsp"/>
        <div class="conteudo">
            <h3>Relatório de Venda</h3>
            <table border="1" style="width:100%" class="table">
                <tr>
                    <th>NOME FUNCIONÁRIO</th>
                    <th>NOME PRODUTO</th>
                    <th>FILIAL</th>
                    <th>DATA VENDA</th>
                    <th>QUANTIDADE</th>
                    <th>PREÇO UNITÁRIO</th>
                </tr>
                <c:forEach items="${listavenda}" var="venda">
                    <tr>
                        <td>${venda.usuario.nome}</td>
                        <td>${venda.acessorio.nome}</td>
                        <td>${venda.filial.razao_social}</td>
                        <td>${venda.dtvenda}</td>
                        <td>${venda.quantidade}</td>
                        <td>${venda.acessorio.preco}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
