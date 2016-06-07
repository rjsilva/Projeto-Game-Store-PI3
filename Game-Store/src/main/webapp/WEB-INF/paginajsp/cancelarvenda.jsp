<%-- 
    Document   : venda
    Created on : 03/05/2016, 16:47:15
    Author     : rjs
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="css/estiloformulario.css"/>
        <script type="text/javascript" src="js/validacao.js"></script>  
        <title>Cancelar Venda</title>
        <style type="text/css">
            input[type=submit]{

                margin: 0px 0px;
            }
            table,tr{
                margin: 50px;
                margin-right:350px;
            }
        </style>
        <script type="text/javascript">
            function exclusao(id) {

                if (window.confirm('tem certeza que deseja excluir a venda?')) {

                    location.href = "VendaServlet?acao=excluir&id=" + id;
                }
            }
        </script>
    </head>
    <body>
        <jsp:include page="../template/layout.jsp"/>
        <div class="conteudo">
            <h3>Cancelar Venda</h3>
            <table border="1" style="width:90%" class="table">
                <tr>
                    <th>CÓDIGO VENDA</th>
                    <th>PRODUTO</th>
                    <th>VENDEDOR</th>
                    <th>FILIAL</th>
                    <th>DATA VENDA</th>
                    <th>PRECO</th>
                    <th>QUANTIDADE</th>
                    <th>TOTAL VENDA</th>
                    <th>EXCLUIR VENDA</th>
                </tr>
                <c:forEach items="${listavenda}" var="venda">
                    <tr>
                        <td>${venda.id}</td>
                        <td>${venda.acessorio.nome}</td>
                        <td>${venda.usuario.nome}</td>
                        <td>${venda.filial.razao_social}</td>
                        <td>${venda.dtvenda}</td>
                        <td>${venda.acessorio.preco}</td>
                        <td>${venda.quantidade}</td>
                        <td></td>
                        <td><a href="javascript:exclusao(${venda.id})" class="btn btn-danger">Excluir</a></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
