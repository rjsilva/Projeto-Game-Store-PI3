/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gamestore.Servlet;

import br.com.gamestore.controler.UsuarioControler;
import br.com.gamestore.exception.ControleException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.PersistenceException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 *
 * @author rjs
 */
@WebServlet("/UsuarioServlet")
public class UsuarioServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String acao = request.getParameter("acao");
        String proxima = null;
        if("sair".equals(acao)){
            proxima = "login1.jsp";
        }else if ("login1".equals(acao)) {
            try {
                proxima = "index.jsp";
                if (!new UsuarioControler().validarUsuario(request)) {
                    request.setAttribute("msgErro", "Login/Senha Inválidos");
                    proxima = "login1.jsp";
                }
            } catch (ControleException e) {
                request.setAttribute("msgErro", e.getMessage());
                proxima = "login1.jsp";
            }
        }
        request.getRequestDispatcher(proxima).forward(request, response);
    }

}
