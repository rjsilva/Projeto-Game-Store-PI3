<%-- 
    Document   : estoqueProdutos
    Created on : 20/04/2016, 13:52:26
    Author     : rjs
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <title>Tabela de Produtos</title>
    </head>
    <body>
        <div class="table-responsive">  
            <c:forEach items="${lista}" var="ace">
                <table class="table">
                    <thead>
                        <tr>
                            <th>ID ACESSORIO</th>
                            <th>ACESSÓRIO</th>
                            <th>MARCA</th>
                            <th>PREÇO</th>
                            <th>TIPO</th>
                            <th>QUANTIDADE</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>${ace.ID_Acessorio}</td>
                            <td>${ace.nome}</td>
                            <td>${ace.marca}</td>
                            <td>${ace.preco}</td>
                            <td>${ace.tipo}</</td>
                            <td>${ace.quantidade}</td>
                        </tr>
                    </tbody>
                </table>
            </c:forEach>
        </div>
    </body>
</html>
