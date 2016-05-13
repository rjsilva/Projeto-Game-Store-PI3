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
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="css/estiloformulario.css"/>
        <script type="text/javascript" src="js/validacao.js"></script>
        <title>Cadastro Funcionário</title>
        <script type="text/javascript">

            function inicial() {

                document.getElementById("uf").value = ${param.idEstado != null ? param.idEstado : '0'};
                
            }
            function SelecionaComboEstado(combo) {

                var idEstado = combo.options[combo.selectedIndex].value;
                location.href = "FuncionarioServlet?acao=funcionario&getCidades=true&idEstado=" + idEstado;
            }
        </script>
    </head>
    <body onload="desabilitaTelaFuncionario();
            inicial()">
        <jsp:include page="../template/cabecalho.jsp"/>
        <jsp:include page="../template/menuesquerda.jsp"/>
        <div class="conteudo">
            <form action="FuncionarioServlet?acao=cadastrofuncionario" method="post" name="form">
                <h3>Cadastro Funcionário</h3>
                <table>
                    <tr>
                        <td><label for="funcionario">Funcionário:</label></td>
                        <td class="col-sm-2">
                            <input class="form-control" type="text" id="nomefuncionario" name="nomefuncionario" placeholder="digite seu nome" value="${func.nome}"/>
                        </td>
                        <td></td>
                        <td class="col-sm-2">
                            <input class="form-control" id="user" type="hidden" value="${sessionScope.user.usuario.toUpperCase()}"/>
                        </td>
                    </tr>
                    <tr>
                        <td><label for="cpf">CPF:</label></td>
                        <td class="col-sm-2">
                            <input class="form-control" type="text" id="cpf" name="cpf" placeholder="digite o cpf" value${func.cpf} onblur="javascript: validarCPF(this.value);" onkeypress="javascript: mascara(this, cpf_mask);"  maxlength="14"/>
                        </td>
                    </tr>
                    <tr>
                        <td><label for="telefone">Telefone:</label></td>
                        <td class="col-sm-2">
                            <input class="form-control" type="tel" name="telefone" id="telefone" maxlength="15" placeholder="digite o telefone" value="${func.telefone}" onkeypress="mascara(this)"/>
                        </td>
                    </tr>
                    <tr>
                        <td><label for="dtnascimento">Data Nascimento:</label></td>
                        <td class="col-sm-2">
                            <input class="form-control" type="date" name="data" OnKeyUp="mascaraData(this);" maxlength="10" placeholder="digite data dascimento" value="${func.dt_nascimento}"/>
                        </td>
                    </tr>
                    <tr>
                        <td><label for="cargo">Cargo:</label></td>
                        <td class="col-sm-2">
                            <input class="form-control" type="text" id="cargo" name="cargo" placeholder="digite data dascimento" value="${func.cargo}"/>
                        </td>
                        <td><label for="acessorio">Filial:</label></td>
                        <td class="col-sm-2">
                            <select class="form-control" name="filial" id="filial">
                                <option value="0">Selecione filial</option>
                                <c:forEach items="${listafilial}" var="filial">
                                    <option value="${filial.id}">${filial.razao_social}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td><label for="endereco">Logradouro:</label></td>
                        <td class="col-sm-2">
                            <input class="form-control" type="text" id="endereco" name="endereco" placeholder="digite a rua" value="${func.endereco.logradouro}"/>
                        </td>
                        <td><label for="cep">Cep:</label></td>
                        <td class="col-sm-2">
                            <input class="form-control" type="text" id="cep" name="cep" placeholder="digite a cep" maxlength="9" value="${func.endereco.cep}"/>
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
                            <input class="form-control" type="text" id="bairro" name="bairro" placeholder="digite o bairro" value="${func.endereco.bairro}"/>
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
