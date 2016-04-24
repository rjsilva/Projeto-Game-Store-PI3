<%-- 
    Document   : cadastrofuncionario2
    Created on : 21/04/2016, 11:50:45
    Author     : rjs
--%>

<%@page import="br.com.gamestore.modelo.Acessorio"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/estiloformulario.css"/>
        <script type="text/javascript" src="js/validacao.js"></script>
        <title>Cadastro Acessório</title>
    </head>
    <body>

        <%
            Acessorio ac = (Acessorio) request.getAttribute("ac");
        %>
        <jsp:include page="WEB-INF/template/cabecalho.jsp"/>
        <jsp:include page="WEB-INF/template/menuesquerda.jsp"/>
        <div class="conteudo">
            <form action="AcessorioServlet" method="post" class="formulariocadastro">
                <h3>Cadastro</h3>
                <fieldset class="field_cadastro">
                    <legend>Cadastro Acessório</legend>
                    <table>
                        <tr>
                            <td><label for="acessorio">Nome Produto:</label></td>
                            <td>
                                <input type="text" id="acessorio" name="acessorio" placeholder="digite o nome do produto" value="<%=ac.getNome()%>" onmouseover="validarCampo()"/>
                            </td>
                            <td><label for="acessorio">Código:</label></td>
                            <td>
                                <input type="text" readonly="readonly" id="id" name="id" value="<%=ac.getID_Acessorio()%>"/>
                            </td>
                        </tr>
                        <tr>
                            <td><label for="marca">Marca:</label></td>
                            <td><input type="text" id="marca" name="marca" placeholder="digite a marca do produto" value="<%=ac.getMarca()%>"/></td>
                        </tr>
                        <tr>
                            <td><label for="preco">Preço(R$):</label></td>
                            <td><input type="text" id="preco" name="preco" placeholder="digite o preço" onkeypress="return formatar_moeda(this, ',', '.', event);" value="<%=ac.getPreco()%>"/></td>
                        </tr>
                        <tr>
                            <td><label for="tipo">Tipo:</label></td>
                            <td>
                                <input type="text" id="tipo" name="tipo" placeholder="digite o tipo de jogo" value="<%=ac.getTipo()%>"/>
                            </td>
                        </tr>
                        <tr>
                            <td><label for="quantidade">Quantidade:</label></td>
                            <td><input type="text" id="quantidade" name="quantidade" placeholder="digite a quantidade" onkeypress="return SomenteNumero(event)" value="<%=ac.getQuantidade()%>" /></td>
                        </tr>
                        <tr>
                            <td><label for="nf">Nota Fiscal:</label></td>
                            <td><input type="text" id="nf" name="nf" placeholder="digite o número da Nota Fiscal" onkeypress="return SomenteNumero(event)" value="<%=ac.getQuantidade()%>" /></td>
                        </tr>
                    </table>
                    <input type="submit" value="Salvar" onclick="validarCampo()"/>
                </fieldset>
            </form>
        </div>
        <jsp:include page="WEB-INF/template/rodape.jsp"/>
    </body>
</html>
