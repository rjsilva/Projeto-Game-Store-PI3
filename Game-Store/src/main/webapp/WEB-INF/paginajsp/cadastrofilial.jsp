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
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="css/estiloformulario.css"/>
        <script type="text/javascript" src="js/validacao.js"></script>
        <title>Cadastro Filial</title>
        <script type="text/javascript">

            function inicial() {

                document.getElementById("uf").value = ${param.idEstado != null ? param.idEstado : '0'};
            }
            function SelecionaComboEstado(combo) {

                var idEstado = combo.options[combo.selectedIndex].value;
                location.href = "FilialServlet?acao=filial&getCidades=true&idEstado=" + idEstado;
            }
        </script>
    </head>
    <body onload="inicial()">
        <jsp:include page="../template/cabecalho.jsp"/>
        <jsp:include page="../template/menuesquerda.jsp"/>
        <div class="conteudo">
            <form action="FilialServlet?acao=cadastrofilial" method="post" name="form" onsubmit="validarCamposFilial(this); return false;">
                <h3>Cadastro Filial</h3>
                <table>
                    <tr>
                        <td><label for="razaosocila">Razão Social:</label></td>
                        <td class="col-sm-2">
                            <input class="form-control" type="text" id="razaosocial" name="razaosocial" placeholder="digite a razão social"/>
                        </td>
                        <td><label for="acessorio">Código:</label></td>
                        <td class="col-sm-2">
                            <input class="form-control" type="text" readonly="readonly" id="id" name="id" value="${ac.id}"/>
                        </td>
                    </tr>
                    <tr>
                        <td><label for="cnpj">CNPJ:</label></td>
                        <td class="col-sm-2">
                            <input class="form-control" type="text" placeholder="digite o cnpj" id="cnpj" name="cpfcnpj" onkeypress='mascaraMutuario(this, cpfCnpj)' onblur='clearTimeout()' maxlength="18"/>
                        </td>
                    </tr>
                    <tr>
                        <td><label for="fone">Telefone:</label></td>
                        <td class="col-sm-2">
                            <input class="form-control" type="tel" name="telefone" id="telefone" maxlength="15" placeholder="digite o telefone" onkeypress="mascara(this)"/>
                        </td>
                    </tr>
                    <tr>
                        <td><label for="endereco">Logradouro:</label></td>
                        <td class="col-sm-2">
                            <input class="form-control" type="text" id="endereco" name="endereco" placeholder="digite a rua" onmouseover="fone()"/>
                        </td>
                    </tr>
                    <tr>
                        <td><label for="cep">Cep:</label></td>
                        <td class="col-sm-2">
                            <input class="form-control" type="text" id="cep" name="cep" OnKeyUp="mascaraCEP(this);"  maxlength="9" placeholder="digite o cep"/>
                        </td>
                    </tr>
                    <tr>
                        <td><label for="uf">Uf:</label></td>
                        <td class="col-sm-2">
                            <select class="form-control" name="uf" id="uf" onchange="SelecionaComboEstado(this)">
                                <option value="0">Selecione um Estado</option>
                                <c:forEach items="${listauf}" var="uf">
                                    <option value="${uf.id}">${uf.nome}</option>
                                </c:forEach>
                            </select>
                        </td>
                        <td><label for="cidade">Cidade:</label></td>
                        <td class="col-sm-2">
                            <select class="form-control" name="cidade" id="cidade">
                                <option value="0">Selecione uma cidade</option>
                                <c:forEach items="${listaEstado}" var="cidade">
                                    <option value="${cidade.id}">${cidade.nome}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td><label for="bairro">Bairro:</label></td>
                        <td class="col-sm-2">
                            <input class="form-control" type="text" id="bairro" name="bairro" placeholder="digite o bairro"/>
                        </td>
                    </tr>
                </table>
                <div class="col-sm-5">
                    <input class="btn btn-primary" id="btncadastrar" type="submit" value="Cadastrar"/>
                    <input class="btn btn-primary" id="btnatualizar" type="submit" value="Atualizar"/>
                    <input class="btn btn-primary" id="btncancelar" type="button" value="Cancelar" onclick="BotaoCancelar()"/>
                </div>
            </form>
        </div>
        <jsp:include page="../template/rodape.jsp"/>
    </body>
</html>
