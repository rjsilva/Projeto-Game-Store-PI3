<%-- 
    Document   : cadastro filial
    Created on : 21/04/2016, 13:07:49
    Author     : rjs
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/estiloformulario.css"/>
        <title>Cadastro Filial</title>
    </head>
    <body>
        <jsp:include page="WEB-INF/template/cabecalho.jsp"/>
        <jsp:include page="WEB-INF/template/menuesquerda.jsp"/>
        <div class="conteudo">
            <form action="AcessorioServlet" method="post" class="formulariocadastro">
                <h3>Cadastro</h3>
                <fieldset class="field_cadastro">
                    <legend>Cadastro Filial</legend>
                    <table>
                        <tr>
                            <td><label for="filial">Filial:</label></td>
                            <td><input type="text" id="filial" name="filial" placeholder="digite a filial"/></td>
                        </tr>
                        <tr>
                            <td><label for="cnpj">CNPJ:</label></td>
                            <td><input type="text" id="cnpj" name="cnpj" placeholder="digite o cnpj"/></td>
                        </tr>
                        <tr>
                            <td><label for="telefone">Telefone:</label></td>
                            <td><input type="tel" id="telefone" name="telefone" placeholder="digite o telefone" onkeypress="return formatar_moeda(this, ',', '.', event);"/></td>
                        </tr>
                        <tr>
                            <td><label for="endereco">Endereço:</label></td>
                            <td><input type="text" id="endereco" name="endereco" placeholder="digite a rua"/></td>
                            <td><label for="bairro">Bairro:</label></td>
                            <td><input type="text" id="bairro" name="bairro" placeholder="digite bairro"/></td>
                        </tr>
                        <tr>
                            <td><label for="cidade">Cidade:</label></td>
                            <td><input type="text" id="cidade" name="cidade" placeholder="digite a cidade"/></td>
                            <td><label for="uf">Uf:</label></td>
                            <td><input type="text" id="uf" name="uf" placeholder="digite a estado"/></td>
                        </tr>
                        <tr>
                            <td><label for="cep">Cep:</label></td>
                            <td><input type="text" id="uf" name="cep" placeholder="digite a cep"/></td>
                        </tr>
                    </table>
                    <input type="submit" value="Cadastrar"/>
                </fieldset>
            </form>
        </div>
        <jsp:include page="WEB-INF/template/rodape.jsp"/>
    </body>
</html>
