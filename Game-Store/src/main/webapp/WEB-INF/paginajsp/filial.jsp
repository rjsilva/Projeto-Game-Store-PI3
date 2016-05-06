<%-- 
    Document   : filial
    Created on : 05/05/2016, 16:21:46
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
        <title>Cadastro Filial</title>
    </head>
    <body>
        <jsp:include page="../template/cabecalho.jsp"/>
        <jsp:include page="../template/menuesquerda.jsp"/>
        <div class="conteudo">
            <form action="FilialServlet?acao=cadastrofilial" method="post">
                <h3>Cadastro</h3>
                <fieldset class="field_cadastro">
                    <legend>Cadastro Filial</legend>
                    <table>
                        <tr>
                            <td><label for="razaosocila">Razão Social:</label></td>
                            <td><input type="text" id="razaosocial" name="razaosocial" placeholder="digite a razão social"/></td>
                        </tr>
                        <tr>
                            <td><label for="cnpj">CNPJ:</label></td>
                            <td><input type="text" id="cnpj" name="cnpj" placeholder="digite o cnpj"/></td>
                        </tr>
                        <tr>
                            <td><label for="telefone">Telefone:</label></td>
                            <td><input type="tel" id="telefone" name="telefone" placeholder="digite o telefone" onkeypress="return SomenteNumero(event)"/></td>
                        </tr>
                        <tr>
                            <td><label for="endereco">Logradouro:</label></td>
                            <td><input type="text" id="endereco" name="endereco" placeholder="digite a rua"/></td>
                            <td><label for="cep">Cep:</label></td>
                            <td><input type="text" id="cep" name="cep" placeholder="digite a cep" maxlength="9"/></td>
                        </tr>
                        <tr>
                            <td><label for="cidade">Cidade:</label></td>
                            <td><input type="text" id="cidade" name="cidade" placeholder="digite a cidade"/></td>
                            <td><label for="uf">Uf:</label></td>
                            <td>
                                <select name="uf" id="uf">
                                    <option value="estado">Selecione um Estado</option>
                                    <c:forEach items="${listauf}" var="uf">
                                        <option value="${uf.nome}">${uf.nome}</option>
                                    </c:forEach>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td><label for="bairro">Bairro:</label></td>
                            <td><input type="text" id="bairro" name="bairro" placeholder="digite o bairro"/></td>
                        </tr>
                    </table>
                    <div class="divbotao">
                        <input type="submit" value="Cadastrar" id="btncadastrar"/>
                    </div>
                </fieldset>
            </form>
        </div>
        <jsp:include page="../template/rodape.jsp"/>
    </body>
</html>
