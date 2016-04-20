<%-- 
    Document   : login
    Created on : 14/04/2016, 15:22:37
    Author     : rjs
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login - Game Store</title>
        <link rel="stylesheet" type="text/css" href="css/estilologin.css"/>
        <script src="js/validacao.js"></script>
    </head>
    <body onload="zerarCampo()">
        <form action="UsuarioServlet?acao=login" method="post" id="login_form">
            <div class="msgErro">
                ${msgErro != null ? msgErro :'' }
            </div>
            <fieldset id="fieldset_login">
                <legend>Login Game Store</legend>
                <div class="campo">
                    <label for="login">Login:</label>
                    <input type="text" id="login" name="login" maxlength="15"/>
                </div>
                <div class="campo">
                    <label for="senha">Senha:</label>
                    <input type="password" id="senha" maxlength="15" name="senha"/>
                </div>
                <div class="campo">
                    <input type="submit" value="Logar"/>
                </div>
            </fieldset>
        </form>
    </body>
</html>
