<%-- 
    Document   : teste
    Created on : 31/05/2016, 22:26:44
    Author     : rjs
--%>

<%@page import="br.com.gamestore.modelo.Acessorio"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="disp" uri="http://displaytag.sf.net" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="css/estiloformulario.css"/>
        <title>JSP Page</title>
    </head>
    <body>
    <body style="background-color: buttonface">
        <jsp:include page="../template/layout.jsp"/>
        <div class="conteudo">
            <%
                List<Acessorio> lista = (List<Acessorio>) request.getAttribute("lista");
 
            %>
            <disp:table name="sessionScope.lista" pagesize="3">
                <disp:column property="Nome"></disp:column>
                <disp:column property="Email"></disp:column>
            </disp:table>
            
        </div>
    </body>
</html>
