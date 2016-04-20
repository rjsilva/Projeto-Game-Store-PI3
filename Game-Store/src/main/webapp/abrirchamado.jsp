<%-- 
    Document   : abrirchamado
    Created on : 20/04/2016, 02:01:48
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
        <title>Abrir Chamado - Suporte Técnico</title>
    </head>
    <body>
        <jsp:include page="WEB-INF/template/cabecalho.jsp"/>
        <jsp:include page="WEB-INF/template/menuesquerda.jsp"/>
        <div class="conteudo">
            <form class="form-horizontal">
                <div class="form-groupo">
                    <label for="nome" class="col-sm-2 control-label">Nome:</label>
                    <div class="col-sm-5">
                        <input type="text" class=" form-control" id="nome" placeholder="digite seu nome" name="nome"/>
                    </div>
                </div>
                <div class="form-groupo">
                    <label for="email" class="col-sm-2 control-label">Email:</label>
                    <div class="col-sm-5">
                        <input type="text" class=" form-control" id="email" placeholder="digite seu email" name="email"/>
                    </div>
                </div>
                <div class="form-groupo">
                    <label for="assunto" class="col-sm-2 control-label">Assunto:</label>
                    <div class="col-sm-5">
                        <input type="text" class=" form-control" id="assunto" placeholder="digite a assunto" name="assunto"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="comentario" class="col-sm-2 control-label">Comentário:</label>
                    <div class="col-sm-3">
                        <textarea class="form-control" rows="3" id="comment"></textarea>
                    </div>
                </div>
                <div class="form-groupo">
                    <div class="col-sm-5">
                        <button type="submit" class="btn btn-primary">Enviar</button>
                    </div>
                </div>
            </form>
        </div>
        <jsp:include page="WEB-INF/template/rodape.jsp"/>
    </body>
</html>
