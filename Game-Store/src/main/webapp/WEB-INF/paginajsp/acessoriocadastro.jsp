<%-- 
    Document   : cadastrofuncionario2
    Created on : 21/04/2016, 11:50:45
    Author     : rjs
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="br.com.gamestore.modelo.Usuario"%>
<%@page import="br.com.gamestore.modelo.Acessorio"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="css/estiloformulario.css"/>
        <script type="text/javascript" src="js/validacao.js"></script>
        <title>Cadastro Acessório</title>
    </head>
    <body onload="desabilitaBotao()">

        <%
            Acessorio ac = (Acessorio) request.getAttribute("ac");
        %>
        <jsp:include page="../template/layout.jsp"/>
        <div class="conteudo">
            <h3>Cadastro de Produto</h3>
            <form id="frmcadastro" method="post" onsubmit="validarCampos(this);
                    return false;" class="formulariocadastro">
                <table id="tabelacadastro">
                    <tr>
                        <td><label for="acessorio">Nome Produto:</label></td>
                        <td class="col-sm-2">
                            <input class="form-control" type="text" name="acessorio" id="acessorio" value="${ac.nome}" placeholder="digite o nome do produto"/>
                        </td>
                        <td><label for="acessorio">Código:</label></td>
                        <td class="col-sm-2">
                            <input class="form-control" type="text" readonly="readonly" id="id" name="id" value="${ac.id}"/>
                        </td>
                    </tr>
                    <tr>
                        <td><label for="marca">Marca:</label></td>
                        <td class="col-sm-2">
                            <input class="form-control" type="text" id="marca" name="marca" placeholder="digite a marca do produto" value="${ac.marca}"/>
                        </td>
                        <td></td>
                        <td> <input id="user" type="hidden" value="" onload="pegar()"/></td>
                    </tr>
                    <tr>
                        <td><label for="preco">Preço(R$):</label></td>
                        <td class="col-sm-2">
                            <input class="form-control" type="text" id="preco" name="preco" placeholder="digite o preço" onkeyup="moeda(this);" value="${ac.preco}"/>
                        </td>
                    </tr>
                    <tr>
                        <td><label for="tipo">Descrição:</label></td>
                        <td class="col-sm-2">
                            <input class="form-control" type="text" id="tipo" name="tipo" placeholder="digite a descrição produto" value="${ac.tipo}"/>
                        </td>
                    </tr>
                    <tr>
                        <td><label for="quantidade">Quantidade:</label></td>
                        <td class="col-sm-2">
                            <input class="form-control" type="text" id="quantidade" name="quantidade" placeholder="digite a quantidade" onkeypress="return SomenteNumero(event)" value="${ac.quantidade}" />
                        </td>
                    </tr>
                    <tr>
                        <td><label for="nf">Nota Fiscal:</label></td>
                        <td class="col-sm-2">
                            <input class="form-control" type="text" id="nf" name="nf" placeholder="digite a Nota Fiscal" onkeypress="return SomenteNumero(event)"  value="${ac.nota_fiscal}" />
                        </td>
                    </tr>
                </table>
                <div class="col-sm-5">
                    <input class="btn btn-primary" id="btncadastrar" type="submit" value="Cadastrar"/>
                    <input class="btn btn-primary" id="btnatualizar" type="submit" value="Atualizar"/>
                    <a class="btn btn-primary" id="btncancelar" href="AcessorioServlet?acao=listar">Cancelar</a>
                </div>
            </form>
        </div>
    </body>
</html>
