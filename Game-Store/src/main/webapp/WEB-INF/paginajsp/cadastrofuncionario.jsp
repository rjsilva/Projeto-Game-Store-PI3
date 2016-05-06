<%-- 
    Document   : cadastrofuncionario
    Created on : 19/04/2016, 20:10:18
    Author     : rjs
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/estiloformulario.css"/>
        <script type="text/javascript" src="js/validacao.js"></script>
        <title>Cadastro Funcionário</title>
    </head>
    <body onload="desabilitaTelaFuncionario()">
        <jsp:include page="../template/cabecalho.jsp"/>
        <jsp:include page="../template/menuesquerda.jsp"/>
        <div class="conteudo">
            <form action="FuncionarioServlet?acao=cadastrofuncionario" method="post">
                <h3>Cadastro</h3>
                <fieldset class="field_cadastro">
                    <legend>Cadastro Funcionário</legend>
                    <table>
                        <tr>
                            <td><label for="funcionario">Funcionário:</label></td>
                            <td><input type="text" id="nomefuncionario" name="nomefuncionario" placeholder="digite seu nome"/></td>
                            <td></td>
                            <td> <input id="user" type="hidden" value="${sessionScope.user.usuario.toUpperCase()}"/></td>
                        </tr>
                        <tr>
                            <td><label for="cpf">CPF:</label></td>
                            <td><input type="text" id="cpf" name="cpf" placeholder="digite o cpf"/></td>
                        </tr>
                        <tr>
                            <td><label for="telefone">Telefone:</label></td>
                            <td><input type="tel" id="telefone" name="telefone" placeholder="digite o telefone" onkeypress="return SomenteNumero(event)"/></td>
                        </tr>
                        <tr>
                            <td><label for="dtnascimento">Data Nascimento:</label></td>
                            <td><input type="date" id="dtnascimento" name="dtnascimento" placeholder="digite data dascimento"/></td>
                        </tr>
                        <tr>
                            <td><label for="cargo">Cargo:</label></td>
                            <td><input type="text" id="cargo" name="cargo" placeholder="digite data dascimento"/></td>
                            <td><label for="local_trabalho">Filial:</label></td>
                            <td><input type="text" id="local_trabalho" name="local_trabalho" placeholder="digite o local de trabalho"/></td>
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
