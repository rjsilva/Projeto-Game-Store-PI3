/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gamestore.Servlet;

import br.com.gamestore.command.Comando;
import br.com.gamestore.command.ComandoLogin;
import br.com.gamestore.controler.AcessorioControler;
import br.com.gamestore.dao.AcessorioDao;
import br.com.gamestore.modelo.Acessorio;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

    private Map<String, Comando> comandos = new HashMap<String, Comando>();

    @Override
    public void init() throws ServletException {
        comandos.put("login", new ComandoLogin());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String acao = request.getParameter("acao");
        String proxima = null;
        try {
            Comando com = verificarComando(acao);
            proxima = com.execute(request);
            for (String key : comandos.keySet()) {
                if (key.equalsIgnoreCase(acao)) {

                    com = comandos.get(key);
                }
            }
        } catch (Exception e) {
            request.setAttribute("msgErro", e.getMessage());
            proxima = "login.jsp";
        }

        request.getRequestDispatcher(proxima).forward(request, response);
    }

    private Comando verificarComando(String acao) {
        Comando com = null;
        for (String key : comandos.keySet()) {
            if (key.equalsIgnoreCase(acao)) {

                com = comandos.get(key);
            }
        }

        return com;
    }
}
