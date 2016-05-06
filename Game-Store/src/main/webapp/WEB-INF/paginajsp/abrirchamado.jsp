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
        <script type="text/javascript" src="js/validacao.js"></script>
        <title>Abrir Chamado - Suporte Técnico</title>
    </head>
    <body>
        <jsp:include page="../template/cabecalho.jsp"/>
        <jsp:include page="../template/menuesquerda.jsp"/>
        <div class="conteudo">
            <h3>Suporte Técnico</h3>
            <form action="ChamadoServlet?acao=cadastrar" method="post" class="formulariocadastro">
                <fieldset class="field_cadastro">
                    <legend>Abrir Chamado</legend>
                    <table>
                        <tr>
                            <td><label for="nome">Nome:</label></td>
                            <td><input type="text" id="nomefuncionario" name="nomefuncionario" placeholder="digite seu nome"/></td>
                        </tr>
                        <tr>
                            <td><label for="email">Email:</label></td>
                            <td><input type="email" id="email" name="email" placeholder="digite seu email"/></td>
                        </tr>
                        <tr>
                            <td><label for="telefone">Telefone:</label></td>
                            <td><input type="telefone" id="telefone" name="telefone" placeholder="digite seu telefone"/></td>
                        </tr>
                        <tr>
                            <td><label for="assunto">Assunto:</label></td>
                            <td><input type="text" id="assunto" name="assunto" placeholder="digite o assunto"/></td>
                        </tr>
                        <tr>
                            <td><label for="assunto">Comentário:</label></td>
                            <td><textarea rows="5" id="comentario" name="comentario"></textarea></td>
                        </tr>
                    </table>
                    <input id="btnenviar" type="submit" value="Enviar"/>
                </fieldset>
            </form>
        </div>
        <jsp:include page="../template/rodape.jsp"/>
    </body>
</html>
