<%-- 
    Document   : criarusuario
    Created on : 25/04/2016, 14:03:31
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
        <title>Criar Usuario</title>
        <style type="text/css">
            #btncriarusuario{

                margin: 20px 120px;
            }
        </style>
    </head>
    <body onload="desabilitaTelaUsuario()">
        <jsp:include page="../template/layout.jsp"/>
        <div class="conteudo">
            <h3>Criar Usuário</h3>
            <form name="form" action="PerfilServlet?acao=criar" method="post"  onsubmit="validarTelaCriarUsuario(this);
                    return false;">
                <table>
                    <tr>
                        <td></td>
                        <td class="col-sm-2">
                            <input class="form-control" type="hidden" id="user" value="${sessionScope.user.login.toUpperCase()}"/>
                        </td>
                    </tr>
                    <tr>
                        <td><label for="acessorio">Funcionário:</label></td>
                        <td class="col-sm-2">
                            <select class="form-control" name="funcionario" id="funcionario">
                                <option value="0">Selecione um Acessório</option>
                                <c:forEach items="${listafuncionario}" var="funcionario">
                                    <option value="${funcionario.id}">${funcionario.nome}</option>
                                </c:forEach>
                            </select>
                        </td>
                        <td><label for="acessorio">Código:</label></td>
                        <td class="col-sm-2">
                            <input class="form-control" type="text" readonly="readonly" id="id" name="id" value="${ac.id}"/>
                        </td>
                    <tr>
                        <td><label for="acessorio">Filial:</label></td>
                        <td class="col-sm-2">
                            <select class="form-control" name="filial" id="filial">
                                <option value="0">Selecione Filial</option>
                                <c:forEach items="${listafilial}" var="filial">
                                    <option value="${filial.id}">${filial.razao_social}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    </tr>
                    <tr>
                        <td><label for="login">Login:</label></td>
                        <td class="col-sm-2">
                            <input class="form-control" type="text" name="cpf" id="cpf" onblur="javascript: validarCPF(this.value);" onkeypress="javascript: mascara(this, cpf_mask);"  maxlength="14" placeholder="digite o cpf"/>
                        </td>
                    </tr>
                    <tr>
                        <td><label for="perfil">Perfil:</label></td>
                        <td class="col-sm-2">
                            <select class="form-control" name="perfil" id="perfil">
                                <option selected>Gerente</option>
                                <option selected>Suporte</option>
                                <option selected>BackOffice</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td><label for="email">Email:</label></td>
                        <td class="col-sm-2">
                            <input class="form-control" type="text" name="email" id="email" onblur="validarEmail(form.email)"  maxlength="60" size='65' placeholder="digite o email">
                        </td>
                    </tr>
                </table>
                <div class="col-sm-5">
                    <input class="btn btn-primary" id="btncriarusuario" type="submit" value="Enviar"/>
                </div>
            </form>
        </div>
    </body>
</html>
