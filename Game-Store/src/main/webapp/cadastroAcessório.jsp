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
        <link rel="stylesheet" href="css/estiloformulario.css"/>
    </head>
    <body>
        <jsp:include page="WEB-INF/template/cabecalho.jsp"/>
        <jsp:include page="WEB-INF/template/menuesquerda.jsp"/>
        <div class="conteudo">
            <fieldset id="fieldset_form">
                <legend>Cadastro Acessório</legend>
                <form action="AcessorioServlet" method="post" id="formulario">
                    <table border="0" cellspacing="0" cellpadding="0" align="center">
                        <tr>
                            <td>Acessório:</td>
                            <td>
                                <select name="acessorio">
                                    <option value="selecao">---Selecione um Acessório---</option>
                                    <option value="jogo">Jogo</option>
                                    <option value="console">Console</option>
                                    <option vaue="cabo">Cabo USB</option>
                                    <option value="kinect">Kinect</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Preço:</td>
                            <td><input type="text" name="txtpreco"/></td>
                        </tr>
                        <tr>
                            <td>Marca:</td>
                            <td><input type="text" name="txtmarca"/></td>
                        </tr>
                        <tr>
                            <td>Quantidade:</td>
                            <td><input type="text" name="txtquantidade"/></td>
                        </tr>
                        <tr>
                            <td>
                                <input type="submit" value="Cadastrar"/>
                            </td>
                        </tr>
                    </table>
                </form>
            </fieldset>
        </div>
        <jsp:include page="WEB-INF/template/rodape.jsp"/>
    </body>
</html>
