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
        <script type="text/javascript" src="js/validacao.js"></script>
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    </head>
    <body>
        <jsp:include page="WEB-INF/template/cabecalho.jsp"/>
        <jsp:include page="WEB-INF/template/menuesquerda.jsp"/>
        <div class="conteudo">
            <form action="AcessorioServlet" method="post" id="formulario" class="form-horizontal">
                <div class="msg">
                    ${msg}
                </div>
                <div class="imagem">
                </div>
                <div class="form-groupo">
                    <label for="nome" class="col-sm-2 control-label">Acessório:</label>
                    <div class="col-sm-3">
                        <select class="form-control" name="nomeacessorio" id="selecaoacessorio" onchange="validaAcessorio()">
                            <option value="selecao">--Selecione--</option>
                            <option value="jogo">Jogo</option>
                            <option value="console">Console</option>
                            <option value="cabo">Cabo USB</option>
                            <option value="kinect">Kinect</option>
                        </select>
                    </div>
                </div>
                <div class="form-groupo">
                    <label for="marca" class="col-sm-2 control-label">Marca:</label>
                    <div class="col-sm-5">
                        <input type="text" class=" form-control" id="marca" placeholder="digite a marca do produto" name="marca"/>
                    </div>
                </div>
                <div class="form-groupo">
                    <label for="preco" class="col-sm-2 control-label">Preço(R$):</label>
                    <div class="col-sm-5">
                        <input type="text" class=" form-control" id="preco" placeholder="digite o preço do produto" name="preco" onkeypress="return formatar_moeda(this, ',', '.', event);"/>
                    </div>
                </div>
                <div class="form-groupo">
                    <label for="tipo" class="col-sm-2 control-label">Tipo:</label>
                    <div class="col-sm-3">
                        <select class="form-control" name="tipo" id="tipo">
                            <option value="selecao">--Selecione--</option>
                            <option value="aventura">Aventura</option>
                            <option value="tiro">Tiro</option>
                        </select>
                    </div>
                </div>
                <div class="form-groupo">
                    <label for="quantidade" class="col-sm-2 control-label">Quantidade:</label>
                    <div class="col-sm-5">
                        <input type="text" class=" form-control" id="quantidade" placeholder="digite a quantidade" name="quantidade" maxlength="5" onkeypress="return SomenteNumero(event);"/>
                    </div>
                </div>
                <div class="form-groupo">
                    <div class="col-sm-5">
                        <button type="submit" class="btn btn-primary">Cadastrar</button>
                    </div>
                </div>
            </form>
        </div>
        <jsp:include page="WEB-INF/template/rodape.jsp"/>
    </body>
</html>
