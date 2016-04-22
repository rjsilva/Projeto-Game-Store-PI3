/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gamestore.Servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rjs
 */
@WebServlet("/Teste")
public class teste extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String acao = request.getParameter("acao");
        String proxima = null;
//        try {
//            Comando com = verificarComando(acao);
//            proxima = com.execute(request);
//            for (String key : comandos.keySet()) {
//                if (key.equalsIgnoreCase(acao)) {
//
//                    com = comandos.get(key);
//                }
//            }
//        } catch (Exception e) {
//            request.setAttribute("msgErro", e.getMessage());
//            proxima = "login.jsp";
//        }

        request.getRequestDispatcher(proxima).forward(request, response);
    }

}
