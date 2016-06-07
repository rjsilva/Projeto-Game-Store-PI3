<%-- 
    Document   : relatorioestoque
    Created on : 13/05/2016, 20:40:05
    Author     : rjs
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="disp" uri="http://displaytag.sf.net" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="css/estiloformulario.css"/>
        <title>Relatório de Estoque</title>
        <style type="text/css">
            .btnimprimir{
                margin: 10px 500px;
            }
        </style>
    </head>
    <body>
        <jsp:include page="../template/layout.jsp"/>
        <div class="conteudo">
            <h3>Relatório de Estoque</h3>
            <table border="1" style="width:100%" class="table">
                <tr>
                    <th>CÓDIGO</th>
                    <th>ACESSÓRIO</th>
                    <th>MARCA</th>
                    <th>PREÇO</th>
                    <th>TIPO</th>
                    <th>NOTA FISCAL</th>
                    <th>QUANTIDADE</th>
                </tr>
                <c:forEach items="${lista}" var="ac">
                    <tr>
                        <td>${ac.id}</td>
                        <td>${ac.nome}</td>
                        <td>${ac.marca}</td>
                        <td>${ac.preco}</td>
                        <td>${ac.tipo}</td>
                        <td>${ac.nota_fiscal}</td>
                        <td>${ac.quantidade}</td>
                    </tr>
                </c:forEach>
            </table>
            <a href="RelatorioServlet?acao=estoque" class="btn btn-primary btnimprimir">Imprimir</a>
        </div>
    </body>
</html>
