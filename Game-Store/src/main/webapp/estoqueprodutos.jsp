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
        <link rel="stylesheet" href="css/estiloformulario.css"/>
        <title>Tabela de Produtos</title>
        <script type="text/javascript">
            function exclusao(id) {

                if (window.confirm('tem certeza que deseja excluir?')) {

                    location.href = "AcessorioServlet?acao=excluir&id=" + id;
                }
            }
        </script>
    </head>
    <body>
        <div class="table-responsive">  
            <%
                List<Acessorio> lista = (List<Acessorio>) request.getAttribute("lista");
            %>
            <table border="1" style="width:100%">
                <tr>
                    <th>CÓDIGO</th>
                    <th>ACESSÓRIO</th>
                    <th>MARCA</th>
                    <th>PREÇO</th>
                    <th>TIPO</th>
                    <th>QUANTIDADE</th>
                    <th>Atualizar</th>
                    <th>Excluir</th>
                </tr>
                <%
                    for (Acessorio ace : lista) {
                %>
                <tr>
                    <td name="ID_Acessorio"><%=ace.getID_Acessorio()%></td>
                    <td><%=ace.getNome()%></td>
                    <td><%=ace.getMarca()%></td>
                    <td><%=ace.getPreco()%></td>
                    <td><%=ace.getTipo()%></td>
                    <td><%=ace.getQuantidade()%></td>
                    <td><a href="javascript:exclusao(<%=ace.getID_Acessorio() %>)">Excluir</a></td>
                    <td><a href="AcessorioServlet?acao=atualizar&id=<%=ace.getID_Acessorio()%>">Atualizar</a></td>
                </tr>
                <%
                    }
                %>
            </table>
            <a id="linkvoltar" href="index.jsp">Voltar</a>
        </div>
    </body>
</html>
