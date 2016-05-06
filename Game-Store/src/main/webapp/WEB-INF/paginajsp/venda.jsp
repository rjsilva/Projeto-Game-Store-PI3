<%-- 
    Document   : venda
    Created on : 03/05/2016, 16:47:15
    Author     : rjs
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/estiloformulario.css"/>
        <script type="text/javascript" src="js/validacao.js"></script>  
        <title>Registro de Vendas</title>
    </head>
    <body>
        <jsp:include page="../template/cabecalho.jsp"/>
        <jsp:include page="../template/menuesquerda.jsp"/>
        <div class="conteudo">
            <form method="post">

                <h3>Venda</h3>
                <fieldset class="field_cadastro">
                    <legend>Registro de Venda</legend>
                    <table>
                        <tr>
                            <td><label for="acessorio">Produto:</label></td>
                            <td>
                                <select name="nomeproduto" id="nomeproduto">
                                    <option value="1">Selecione um Acessório</option>
                                    <c:forEach items="${listaproduto}" var="ac">
                                        <option value="${ac.id}">${ac.nome}</option>
                                    </c:forEach>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td><label for="funcionario">Código Funcionário:</label></td>
                            <td>
                                <input type="text" id="funcionario" name="funcionario" placeholder="digite o seu nome"/>
                            </td>
                        </tr>
                        <tr>
                            <td><label for="dtvenda">Data Venda:</label></td>
                            <td>
                                <input type="text" id="dtvenda" name="dtvenda" placeholder="data venda"/>
                            </td>
                        </tr>
                        <tr>
                            <td><label for="acessorio">Filial:</label></td>
                            <td>
                                <select name="filial" id="filial">
                                    <option value="1">Selecione um Acessório</option>
                                    <c:forEach items="${listafilial}" var="filial">
                                        <option value="${filial.id}">${filial.nome}</option>
                                    </c:forEach>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td><label for="quantidade">Quantidade:</label></td>
                            <td><input type="text" id="quantidade" name="quantvenda" placeholder="digite a quantidade" onkeypress="return SomenteNumero(event)"/></td>
                            <td><label for="qtdestoque">Estoque:</label></td>
                            <td><input type="text" id="qtdestoque" name="qtdestoque" readonly="readonly" value="${ac.quantidade}"/></td>
                        </tr>
                    </table>
                    <div class="divbotao">
                        <input type="submit" value="Registrar Venda" id="btnregistravenda"/>
                        <input type="reset" value="Cancelar" id="btncancelar"/>
                    </div>
                </fieldset>
            </form>
        </div>
        <jsp:include page="../template/rodape.jsp"/>
    </body>
</html>
