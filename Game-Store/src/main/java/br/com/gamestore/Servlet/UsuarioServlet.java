/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gamestore.Servlet;

import br.com.gamestore.controler.UsuarioControler;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 *
 * @author rjs
 */
public class UsuarioServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String acao = req.getParameter("acao");
        String proxima = null;
        if ("sair".equals(acao)) {
            proxima = "logout.jsp";
        } else if ("login".equals(acao)) {
            try {
                proxima = "index.jsp";
                if (!new UsuarioControler().validarUsuario(req)) {
                    JOptionPane.showInputDialog("login/senha inválidos");
                    proxima = "login.jsp";
                }
            } catch (Exception e) {
                JOptionPane.showInputDialog(e.getMessage());
                proxima = "login.jsp";
            }
        }
        req.getRequestDispatcher(proxima).forward(req, resp);
    }

}
