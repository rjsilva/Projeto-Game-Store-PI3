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
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="css/estiloformulario.css"/>
        <script type="text/javascript" src="js/validacao.js"></script>
        <title>Criar Usuario</title>
    </head>
    <body onload="desabilitaTelaUsuario()">
        <jsp:include page="../template/cabecalho.jsp"/>
        <jsp:include page="../template/menuesquerda.jsp"/>
        <div class="conteudo">
            <h3>Criar Usuário</h3>
            <form action="PerfilServlet?acao=criar" method="post" >
                <table>
                    <tr>
                        <td></td>
                        <td class="col-sm-2">
                            <input class="form-control" type="hidden" id="user" value="${sessionScope.user.usuario.toUpperCase()}"/>
                        </td>
                    </tr>
                    <tr>
                        <td><label for="login">Login:</label></td>
                        <td class="col-sm-2">
                            <input class="form-control" type="text" id="usuario" name="usuario" placeholder="digite o login"/>
                        </td>
                        <td><label for="acessorio">Código:</label></td>
                        <td class="col-sm-2">
                            <input class="form-control" type="text" readonly="readonly" id="id" name="id" value="${ac.id}"/>
                        </td>
                    </tr>
                    <tr>
                        <td><label for="senha">Senha:</label></td>
                        <td class="col-sm-2">
                            <input class="form-control" type="password" id="senha" name="senha" placeholder="digite a senha"/>
                        </td>
                    </tr>
                    <tr>
                        <td><label for="perfil">Perfil:</label></td>
                        <td class="col-sm-2">
                            <input class="form-control" type="text" id="perfil" name="perfil" placeholder="digite seu perfil"/>
                        </td>
                    </tr>
                </table>
                <div class="col-sm-5">
                    <input class="btn btn-primary" id="btncriarusuario" type="submit" value="Criar"/>
                </div>
            </form>
        </div>
        <jsp:include page="../template/rodape.jsp"/>
    </body>
</html>
