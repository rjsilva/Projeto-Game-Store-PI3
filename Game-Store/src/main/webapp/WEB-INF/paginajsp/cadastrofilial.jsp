<%-- 
    Document   : filial
    Created on : 05/05/2016, 16:21:46
    Author     : rjs
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <title>Cadastro Filial</title>
    </head>
    <body onload="desabilitaBotao()">
        <jsp:include page="../template/cabecalho.jsp"/>
        <jsp:include page="../template/menuesquerda.jsp"/>
        <div class="conteudo">
            <form action="FilialServlet?acao=cadastrofilial" method="post" name="form" onsubmit="validarCamposFilial(this); return false;">
                <h3>Cadastro Filial</h3>
                <table>
                    <tr>
                        <td><label for="razaosocila">Razão Social:</label></td>
                        <td class="col-sm-2">
                            <input class="form-control" type="text" id="razaosocial" name="razaosocial" placeholder="digite a razão social" value="${filial.razao_social}"/>
                        </td>
                        <td><label for="acessorio">Código:</label></td>
                        <td class="col-sm-2">
                            <input class="form-control" type="text" readonly="readonly" id="id" name="id" value="${filial.id}"/>
                        </td>
                    </tr>
                    <tr>
                        <td><label for="cnpj">CNPJ:</label></td>
                        <td class="col-sm-2">
                            <input class="form-control" type="text" name="cnpj" id="cnpj" maxlength="18" onkeyup="FormataCnpj(this,event)" onBlur="ValidarCNPJ(form.cnpj);" placeholder="digite o cnpj" value="${filial.cnpj}">
                        </td>
                    </tr>
                    <tr>
                        <td><label for="fone">Telefone:</label></td>
                        <td class="col-sm-2">
                            <input class="form-control" type="text" name="telefone" id="telefone" maxlength="14" placeholder="digite o telefone" onkeyup="mascara( this, mtel );" value="${filial.telefone}">
                        </td>
                    </tr>
                    <tr>
                        <td><label for="cep">Cep:</label></td>
                        <td class="col-sm-2">
                            <input class="form-control" type="text" id="cep" name="cep" maxlength="9" placeholder="digite o cep"  onblur="pesquisacep(this.value);" value="${filial.endereco.cep}"/>
                        </td>
                    </tr>
                    <tr>
                        <td><label for="endereco">Logradouro:</label></td>
                        <td class="col-sm-2">
                            <input class="form-control" type="text" id="rua" name="rua" readonly="readonly" value="${filial.endereco.logradouro}"/>
                        </td>
                        <td><label for="bairro">Bairro:</label></td>
                        <td class="col-sm-2">
                            <input class="form-control" type="text" id="bairro" name="bairro" readonly="readonly" value="${filial.endereco.bairro}"/>
                        </td>
                    </tr>
                    <tr>
                        <td><label for="uf">Uf:</label></td>
                        <td class="col-sm-2">
                            <input class="form-control" name="uf" type="text" id="uf" maxlength="2" readonly="readonly" value="${filial.endereco.estado}"/>
                        </td>
                        <td><label for="cidade">Cidade:</label></td>
                        <td class="col-sm-2">
                            <input class="form-control" name="cidade" type="text" id="cidade" maxlength="2" readonly="readonly" value="${filial.endereco.cidade}"/>
                        </td>
                    </tr>
                </table>
                <div class="col-sm-5">
                    <input class="btn btn-primary" id="btncadastrar" type="submit" value="Cadastrar"/>
                    <input class="btn btn-primary" id="btnatualizar" type="submit" value="Atualizar"/>
                    <a class="btn btn-primary" href="FilialServlet?acao=listar" id="btncancelar">Voltar</a>
                </div>
            </form>
        </div>
        <jsp:include page="../template/rodape.jsp"/>
    </body>
</html>
