<%-- 
    Document   : menulateral
    Created on : 19/05/2016, 03:07:26
    Author     : rjs
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/menu.css"/>
        <script type="text/javascript" src="js/menu.js"></script>
    </head>
    <body>
        <nav id="menu-esquerda">
            <ul id="menu-v">
                <li><a href="IndexServlet?acao=mostrartelaindex">Home</a></li>
                <li><a href="#">Cadastro</a>
                    <ul class="sub">
                        <li><a href="AcessorioServlet?acao=cadastro">Produto</a></li>
                        <li><a href="FilialServlet?acao=mostrartela">Filial</a></li>
                        <li><a href="FuncionarioServlet?acao=funcionario">Funcionário</a></li>
                    </ul>
                </li>
                <li><a href="VendaServlet?acao=venda">Registrar Venda</a></li>
                <li><a href="ChamadoServlet?acao=tela">Abrir Chamado</a></li>
                <li><a href="PerfilServlet?acao=mostrartelausuario">Criar Usuário</a></li>
                <li><a href="#">Consultas</a>
                    <ul class="sub">
                        <li><a href="AcessorioServlet?acao=listar">Produto</a></li>
                        <li><a href="FuncionarioServlet?acao=listar">Funcionário</a></li>
                        <li><a href="FilialServlet?acao=listar">Filial</a></li>
                        <li><a href="ChamadoServlet?acao=listar">Chamado</a></li>
                        <li><a href="PerfilServlet?acao=listarusuarios">Usuários</a></li>
                    </ul>
                </li>
                <li><a href="#">Relatório</a>
                    <ul class="sub">
                        <li><a href="VendaServlet?acao=relatoriovenda">Venda</a></li>
                        <li><a href="AcessorioServlet?acao=relatorio">Estoque</a>
                        </li>
                    </ul>
                </li>
                <li><a href="login1.jsp">Sair</a>
            </ul>
        </nav>
    </body>
</html>
