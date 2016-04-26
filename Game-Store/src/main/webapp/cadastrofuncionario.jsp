<%-- 
    Document   : cadastrofuncionario
    Created on : 19/04/2016, 20:10:18
    Author     : rjs
--%>

<%@page import="br.com.gamestore.modelo.Uf"%>
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
        <jsp:include page="WEB-INF/template/cabecalho.jsp"/>
        <jsp:include page="WEB-INF/template/menuesquerda.jsp"/>
        <div class="conteudo">
            <form action="Teste?acao=cadastrofuncionario" method="post">
                <h3>Cadastro</h3>
                <fieldset class="field_cadastro">
                    <legend>Cadastro Funcionário</legend>
                    <table>
                        <tr>
                            <td><label for="funcionario">Funcionário:</label></td>
                            <td><input type="text" id="filial" name="funcionario" placeholder="digite seu nome"/></td>
                            <td></td>
                            <td> <input id="user" type="hidden" value="${sessionScope.user.usuario.toUpperCase()}"/></td>
                        </tr>
                        <tr>
                            <td><label for="cpf">CPF:</label></td>
                            <td><input type="text" id="cpf" name="cpf" placeholder="digite o cpf"/></td>
                        </tr>
                        <tr>
                            <td><label for="telefone">Telefone:</label></td>
                            <td><input type="tel" id="telefone" name="telefone" placeholder="digite o telefone" onkeypress="return formatar_moeda(this, ',', '.', event);"/></td>
                        </tr>
                        <tr>
                            <td><label for="dtnascimento">Data Nascimento:</label></td>
                            <td><input type="date" id="dtnascimento" name="dtnascimento" placeholder="digite data dascimento" onkeypress="return formatar_moeda(this, ',', '.', event);"/></td>
                        </tr>
                        <tr>
                            <td><label for="endereco">Endereço:</label></td>
                            <td><input type="text" id="endereco" name="endereco" placeholder="digite a rua"/></td>
                        </tr>
                        <tr>
                            <td><label for="cidade">Cidade:</label></td>
                            <td><input type="text" id="cidade" name="cidade" placeholder="digite a cidade"/></td>
                            <td><label for="uf">Uf:</label></td>
                            <td>
                                <select name="uf" id="uf">
                                    <option</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td><label for="cep">Cep:</label></td>
                            <td><input type="text" id="cep" name="cep" placeholder="digite a cep"/></td>
                        </tr>
                    </table>
                    <input type="submit" value="Cadastrar" id="btncadastrar"/>
                </fieldset>
            </form>
        </div>
        <jsp:include page="WEB-INF/template/rodape.jsp"/>
    </body>
</html>
