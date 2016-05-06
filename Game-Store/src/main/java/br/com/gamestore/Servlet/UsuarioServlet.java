/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gamestore.Servlet;

import br.com.gamestore.controler.UsuarioControler;
import br.com.gamestore.dao.EnderecoDao;
import br.com.gamestore.dao.UsuarioDao;
import br.com.gamestore.exception.ControleException;
import br.com.gamestore.modelo.Usuario;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
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
        String acao = request.getParameter("acao");
        String proxima = null;
        Usuario user = new Usuario();

        String login = request.getParameter("login");
        user.setUsuario(login);

        if ("sair".equals(acao)) {
            proxima = "login1.jsp";
        } else if ("login1".equals(acao)) {
            try {
                proxima = "index.jsp";
                if (!new UsuarioControler().validarUsuario(request)) {
                    request.setAttribute("msgErro", "***Login/Senha Inválidos");
                    proxima = "login1.jsp";
                }
            } catch (ControleException e) {
                request.setAttribute("msgErro", e.getMessage());
                proxima = "login1.jsp";
            }
        }
        request.getSession().setAttribute("user", user);
        request.getRequestDispatcher(proxima).forward(request, response);
    }


//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//        String acao = request.getParameter("acao");
//        String id = request.getParameter("id");
//        Usuario user = new Usuario();
//        UsuarioDao userDao = new UsuarioDao();
//
//        if (id.equals("null") || id.isEmpty()) {
//
//            String usuario = request.getParameter("usuario");
//            String senha = request.getParameter("senha");
//            String perfil = request.getParameter("perfil");
//
//            user.setUsuario(usuario);
//            user.setSenha(senha);
//            user.setPerfil(perfil);
//
//            userDao.cadastrar(user);
//            response.sendRedirect("AcessorioServlet?acao=cadastro");
//        }
//    }

}
