<%-- 
    Document   : cadastrofuncionario2
    Created on : 21/04/2016, 11:50:45
    Author     : rjs
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/estiloformulario.css"/>
        <script type="text/javascript" src="js/validacao.js"></script>
        <title>Cadastro Acessório</title>
    </head>
    <body>
        <jsp:include page="WEB-INF/template/cabecalho.jsp"/>
        <jsp:include page="WEB-INF/template/menuesquerda.jsp"/>
        <div class="conteudo">
            <form action="AcessorioServlet" method="post" class="formulariocadastro">
                <h3>Cadastro</h3>
                <fieldset class="field_cadastro">
                    <legend>Cadastro Acessório</legend>
                    <table>
                        <tr>
                            <td><label for="acessorio">Acessório:</label></td>
                            <td>
                                <select id="selecaoacessorio" name="acessorio" onchange="validaAcessorio()">
                                    <option value="selecao">--Selecione--</option>
                                    <option value="jogo" name="jogo">Jogo</option>
                                    <option valeu="cabo">Cabo USB</option>
                                    <option value="console">Console</option>
                                    <option value="kinect">Kinect</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td><label for="marca">Marca:</label></td>
                            <td><input type="text" id="marca" name="marca" placeholder="digite a marca do produto"/></td>
                        </tr>
                        <tr>
                            <td><label for="preco">Preço:</label></td>
                            <td><input type="text" id="preco" name="preco" placeholder="digite o preço" onkeypress="return formatar_moeda(this, ',', '.', event);"/></td>
                        </tr>
                        <tr>
                            <td><label for="tipo">Tipo:</label></td>
                            <td>
                                <select id="tipo" name="tipo">
                                    <option>--Selecione--</option>
                                    <option>Aventura</option>
                                    <option>Tiro</option>
                                    <option>Corrida</option>
                                    <option>Futebol</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td><label for="quantidade">Quantidade:</label></td>
                            <td><input type="text" id="quantidade" name="quantidade" placeholder="digite a quantidade" onkeypress="return SomenteNumero(event)"/></td>
                        </tr>
                    </table>
                    <input type="submit" value="Cadastrar"/>
                </fieldset>
            </form>
        </div>
        <jsp:include page="WEB-INF/template/rodape.jsp"/>
    </body>
</html>
