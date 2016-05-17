<%-- 
    Document   : estoqueProdutos
    Created on : 20/04/2016, 13:52:26
    Author     : rjs
--%>

<%@page import="java.util.List"%>
<%@page import="br.com.gamestore.modelo.Acessorio"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="css/estiloformulario.css"/>
        <title>Produtos Lançadado no Sistema</title>
        <script type="text/javascript">
            function exclusao(id) {

                if (window.confirm('tem certeza que deseja excluir?')) {

                    location.href = "AcessorioServlet?acao=excluir&id=" + id;
                }
            }
        </script>
    </head>
    <body style="background-color: buttonface">
        <jsp:include page="../template/cabecalho.jsp"/>
        <jsp:include page="../template/menuesquerda.jsp"/>
        <div class="conteudo">
            <h3>Produtos Lançadado no Sistema</h3>
            <div class="table-responsive">  
                <%
                    List<Acessorio> lista = (List<Acessorio>) request.getAttribute("lista");

                %>
                <table border="1" style="width:100%" class="table">
                    <tr>
                        <th>CÓDIGO</th>
                        <th>ACESSÓRIO</th>
                        <th>MARCA</th>
                        <th>PREÇO</th>
                        <th>TIPO</th>
                        <th>QUANTIDADE</th>
                        <th>NOTA FISCAL</th>
                        <th>Excluir</th>
                        <th>Atualizar</th>
                    </tr>
                    <%                    for (Acessorio ace : lista) {
                    %>
                    <tr>
                        <td><%=ace.getId()%></td>
                        <td><%=ace.getNome()%></td>
                        <td><%=ace.getMarca()%></td>
                        <td><%=ace.getPreco()%></td>
                        <td><%=ace.getTipo()%></td>
                        <td><%=ace.getQuantidade()%></td>
                        <td><%=ace.getNota_fiscal()%></td>
                        <td><a href="javascript:exclusao(<%=ace.getId()%>)" class="btn btn-primary">Excluir</a></td>
                        <td><a href="AcessorioServlet?acao=atualizar&id=<%=ace.getId()%>" class="btn btn-primary">Atualizar</a></td>
                    </tr>
                    <%
                        }
                    %>
                </table>
            </div>
        </div>
    </body>
</html>
