<%-- 
    Document   : cadastrofuncionario
    Created on : 19/04/2016, 20:10:18
    Author     : rjs
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/estiloformulario.css"/>
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <title>Cadastro Funcinário</title>
    </head>
    <body>
        <jsp:include page="WEB-INF/template/cabecalho.jsp"/>
        <jsp:include page="WEB-INF/template/menuesquerda.jsp"/>
        <div class="conteudo">
            <form class="form-horizontal">
                <div class="form-groupo">
                    <label for="nome" class="col-sm-2 control-label">Nome Funcionário:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="nome" />
                    </div>
                </div>
                <div class="form-groupo">
                    <label for="cpf" class="col-sm-2 control-label">CPF:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="cpf" />
                    </div>
                </div>
                <div class="form-groupo">
                    <label for="cargo" class="col-sm-2 control-label">Cargo:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="cargo" />
                    </div>
                </div>
            </form>
        </div>
        <jsp:include page="WEB-INF/template/rodape.jsp"/>
    </body>
</html>
