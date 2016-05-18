<%-- 
    Document   : venda
    Created on : 03/05/2016, 16:47:15
    Author     : rjs
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <title>Registro de Vendas</title>
        <script type="text/javascript">
            function inicial() {

                document.getElementById("nomeproduto").value = ${param.idProduto != null ? param.idProduto : '0'};
            }
            function BuscaQuantEstoque(produto) {

                var idProduto = produto.options[produto.selectedIndex].value;
                location.href = "VendaServlet?acao=venda&getproduto=true&idProduto=" + idProduto;
            }

        </script>
    </head>
    <body onload="inicial()">
        <jsp:include page="../template/cabecalho.jsp"/>
        <jsp:include page="../template/menuesquerda.jsp"/>
        <div class="conteudo">
            <h3>Registrar Venda</h3>
            <form action="VendaServlet?acao=registrarvenda" method="post" onsubmit="validarTelaVenda(this); return false;">
                <table>
                    <tr>
                        <td><label for="acessorio">Produto:</label></td>
                        <td class="col-sm-2">
                            <select class="form-control" name="nomeproduto" id="nomeproduto" onchange="BuscaQuantEstoque(this)">
                                <option value="0">Selecione um Acessório</option>
                                <c:forEach items="${listaproduto}" var="acessorio">
                                    <option value="${acessorio.id}">${acessorio.nome}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td><label for="funcionario">Funcionário:</label></td>
                        <td class="col-sm-2">
                            <input class="form-control" type="text" id="funcionario" name="funcionario" placeholder="digite o seu nome" value="${sessionScope.user.nome.toUpperCase()}"/>
                        </td>
                    </tr>
                    <tr>
                        <td><label for="quantidade">Quantidade:</label></td>
                        <td class="col-sm-2">
                            <input class="form-control" type="text" id="quantvenda" name="quantvenda" placeholder="digite a quantidade" onkeypress="return SomenteNumero(event)"/>
                        </td>
                        <td><label for="qtdestoque">Estoque:</label></td>
                        <td class="col-sm-2">
                            <input class="form-control" type="text" id="qtdestoque" name="qtdestoque" readonly="readonly" value="${ac.quantidade}"/>
                        </td>
                    </tr>
                </table>
                <div class="col-sm-5">
                    <input class="btn btn-primary" id="btncadastrar" type="submit" value="Cadastrar"/>
                    <input class="btn btn-primary" id="btnatualizar" type="submit" value="Atualizar"/>
                    <input class="btn btn-primary" id="btncancelar" type="button" value="Cancelar" onclick="BotaoCancelar()"/>
                </div>
            </form>
        </div>
        <jsp:include page="../template/rodape.jsp"/>
    </body>
</html>
