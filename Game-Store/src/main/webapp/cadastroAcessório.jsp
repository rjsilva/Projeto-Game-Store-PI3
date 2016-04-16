<%-- 
    Document   : cadastroAcessório
    Created on : 15/04/2016, 13:30:37
    Author     : rjs
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro Acessório</title>
        <link rel="stylesheet" href="css/estilo.css"/>
    </head>
    <body>
        <jsp:include page="WEB-INF/template/cabecalho.jsp"/>
        <jsp:include page="WEB-INF/template/menuesquerda.jsp"/>
        <div class="conteudo">
            <fieldset id="fieldset_form">
                <legend>Cadastro Acessório</legend>
                <form action="AcessorioServlet" method="post" id="formulario">
                    <div>
                        <label>Nome:</label>
                        <input type="text" name="nome"/><br>
                    </div>
                    <div>
                        <label>Preço:</label>
                        <input type="text" name="preco"/><br>
                    </div>
                    <div>
                        <label>Descrição:</label>
                        <input type="text" name="descricao"/><br>
                    </div>
                    <div>
                        <label>Marca:</label>
                        <input type="text" name="marca"/><br>
                    </div>
                    <div>
                        <input type="submit" value="Cadastrar"/>
                    </div>
                </form>
            </fieldset>
        </div>
        <jsp:include page="WEB-INF/template/rodape.jsp"/>
    </body>
</html>
