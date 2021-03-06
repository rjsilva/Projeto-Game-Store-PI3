/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gamestore.Servlet;

import br.com.gamestore.controler.UsuarioControler;
import br.com.gamestore.dao.UsuarioDao;
import br.com.gamestore.exception.ControleException;
import br.com.gamestore.modelo.Usuario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rjs
 */
@WebServlet("/UsuarioServlet")
public class UsuarioServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        /**
         * RECEBE A AÇÃO DO USUÁRIO DO SISTEMA
         */
        String acao = request.getParameter("acao");
        String proxima = null;
        Usuario user = new Usuario();
        UsuarioDao usedao = new UsuarioDao();

        String login = request.getParameter("login");
        user.setLogin(login);

        /**
         * SE A AÇÃO FOR SAIR, O SISTEMA RETORNARÁ A PÁGINA DE LOGIN
         */
        if ("sair".equals(acao)) {
            proxima = "login1.jsp";
            /**
             * SE A AÇÃO FOR LOGAR NO SISTEMA, SERÁ AUTENTICADO O LOGIN E A SENHA, CASO 
             * AMBOS SEJAM VÁLIDADOS SERÁ RETORNADO A TELE INICIAL DO SISTEMA
             */
        } else if ("login1".equals(acao)) {
            try {
                proxima = "/WEB-INF/paginajsp/index.jsp";
                if (!new UsuarioControler().validarUsuario(request)) {
                    request.setAttribute("msgErro", "***Login/Senha Inválidos");
                    proxima = "login1.jsp";
                }
            } catch (ControleException e) {
                request.setAttribute("msgErro", e.getMessage());
                proxima = "login1.jsp";
            }
        }
        user = usedao.buscarUsuarioPorNome(login);
        request.getSession().setAttribute("user", user);
        request.getRequestDispatcher(proxima).forward(request, response);
    }

}
