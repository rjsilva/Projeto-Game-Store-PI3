<%-- 
    Document   : listafilial
    Created on : 09/05/2016, 01:20:05
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
        <link rel="stylesheet" href="css/estiloformulario.css"/>
        <title>Lista de Filial</title>
        <script type="text/javascript">
            function exclusao(id) {

                if (window.confirm('tem certeza que deseja excluir?')) {

                    location.href = "FilialServlet?acao=excluir&id=" + id;
                }
            }
        </script>
    </head>
    <body>
        <jsp:include page="../template/cabecalho.jsp"/>
        <jsp:include page="../template/menuesquerda.jsp"/>
        <div class="conteudo">
            <h3>Lista de Filial</h3>
            <table border="1" style="width:100%" class="table">
                <tr>
                    <th>CÓDIGO FILIAL</th>
                    <th>RAZÃO SOCIAL</th>
                    <th>CNPJ</th>
                    <th>TELEFONE</th>
                    <th>Excluir</th>
                    <th>Atualizar</th>
                </tr>
                <c:forEach items="${listafilial}" var="filial">
                    <tr>
                        <td>${filial.id}</td>
                        <td>${filial.razao_social}</td>
                        <td>${filial.cnpj}</td>
                        <td>${filial.telefone}</td>
                        <td><a href="javascript:exclusao(${filial.id})" class="btn btn-primary">Excluir</a></td>
                        <td><a href="FilialServlet?acao=atualizar&id=${filial.id}" class="btn btn-primary">Atualizar</a></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
