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
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="css/estiloformulario.css"/>
        <script type="text/javascript" src="js/validacao.js"></script>
        <title>Abrir Chamado - Suporte Técnico</title>
        <style type="text/css">
            #btncadastrar{
                margin: 20px 110px;
            }
        </style>
    </head>
    <body>
        <jsp:include page="../template/layout.jsp"/>
        <div class="conteudo">
            <h3>Abrir Chamado</h3>
            <form action="ChamadoServlet?acao=cadastrar" method="post" class="formulariocadastro">
                <table>
                    <tr>
                        <td><label for="nome">Nome:</label></td>
                        <td class="col-sm-2">
                            <input class="form-control" type="text" id="nomefuncionario" name="nomefuncionario" placeholder="digite seu nome"/>
                        </td>
                        <td><label for="acessorio">Código:</label></td>
                        <td class="col-sm-2">
                            <input class="form-control" type="text" readonly="readonly" id="id" name="id" value="${ac.id}"/>
                        </td>
                    </tr>
                    <tr>
                        <td><label for="email">Email:</label></td>
                        <td class="col-sm-2">
                            <input class="form-control" type="email" id="email" name="email" placeholder="digite seu email"/>
                        </td>
                    </tr>
                    <tr>
                        <td><label for="telefone">Telefone:</label></td>
                        <td class="col-sm-2">
                            <input class="form-control" type="telefone" id="telefone" name="telefone" placeholder="digite seu telefone"/>
                        </td>
                    </tr>
                    <tr>
                        <td><label for="assunto">Assunto:</label></td>
                        <td class="col-sm-2">
                            <input class="form-control" type="text" id="assunto" name="assunto" placeholder="digite o assunto"/>
                        </td>
                    </tr>
                    <tr>
                        <td><label for="assunto">Comentário:</label></td>
                        <td class="col-sm-2">
                            <textarea class="form-control" rows="5" id="comentario" name="comentario"></textarea>
                        </td>
                    </tr>
                </table>
                <div class="col-sm-5">
                    <input class="btn btn-primary" id="btncadastrar" type="submit" value="Enviar"/>
                </div>
            </form>
        </div>
    </body>
</html>
