<%-- 
    Document   : newjsp
    Created on : 19/04/2016, 18:56:26
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
        <script type="text/javascript" src="js/validacao.js"></script>
        <link rel="stylesheet" href="css/estilologin1.css"/>
        <title>Login - Game Store</title>
    </head>
    <body onload="zerarCampo()">
        <h3>GAME STORE</h3>
        <div class="msgErro">
            ${msgErro != null ? msgErro : '' }
        </div>
        <div class="loginBox">
            <form action="UsuarioServlet?acao=login1" class="form-horizontal" role="form" method="post">
                <div class="form-group">
                    <label class="col-sm-2 control-label">Login:</label>
                    <div class="col-sm-2">
                        <input class="form-control" id="login" type="text" name="login" placeholder="Digite seu login">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Senha:</label>
                    <div class="col-sm-2">
                        <input class="form-control" id="senha" type="password" name="senha" placeholder="digite sua senha">
                    </div>
                </div>
                <div class="col-sm-5">
                    <input type="submit" class="btn btn-primary" value="Entrar" onclick="validarCampo()"/>
                </div>
            </form>
        </div>
    </body>
</html>
