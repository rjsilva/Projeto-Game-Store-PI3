<%-- 
    Document   : criarusuario
    Created on : 25/04/2016, 14:03:31
    Author     : rjs
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/estiloformulario.css"/>
        <script type="text/javascript" src="js/validacao.js"></script>
        <title>Criar Usuario</title>
    </head>
    <body onload="desabilitaTelaUsuario()">
        <jsp:include page="WEB-INF/template/cabecalho.jsp"/>
        <jsp:include page="WEB-INF/template/menuesquerda.jsp"/>
        <div class="conteudo">
            <h3>Criação de Usuário</h3>
            <form action="PerfilServlet" method="post" class="formulariocadastro">
                <fieldset class="field_cadastro">
                    <legend>Criar Usuário</legend>
                    <table>
                        <tr>
                            <td><label for="login">Login:</label></td>
                            <td><input type="text" id="usuario" name="usuario" placeholder="digite o login"/></td>
                            <td></td>
                            <td>
                                <input type="hidden" readonly="readonly" id="id" name="id" value=""/>
                            </td>
                        </tr>
                        <tr>
                            <td><label for="senha">Senha:</label></td>
                            <td><input type="text" id="senha" name="senha" placeholder="digite a senha"/></td>
                            <td></td>
                            <td> <input id="user" type="hidden" value="${sessionScope.user.usuario.toUpperCase()}"/></td>
                        </tr>
                        <tr>
                            <td><label for="perfil">Perfil:</label></td>
                            <td><input type="perfil" id="perfil" name="perfil" placeholder="digite seu perfil"/></td>
                        </tr>
                    </table>
                    <input id="btnsalvar" type="submit" value="Salvar"/>
                </fieldset>
            </form>
        </div>
        <jsp:include page="WEB-INF/template/rodape.jsp"/>
    </body>
</html>
