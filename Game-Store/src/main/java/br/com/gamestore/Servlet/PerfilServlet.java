/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gamestore.Servlet;

import br.com.gamestore.controler.UsuarioControler;
import br.com.gamestore.dao.FilialDao;
import br.com.gamestore.dao.FuncionarioDao;
import br.com.gamestore.dao.UsuarioDao;
import br.com.gamestore.modelo.Filial;
import br.com.gamestore.modelo.Funcionario;
import br.com.gamestore.modelo.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.PersistenceException;
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
@WebServlet(name = "PerfilServlet", urlPatterns = {"/PerfilServlet"})
public class PerfilServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PerfilServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PerfilServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String acao = request.getParameter("acao");
        FuncionarioDao funcDao = new FuncionarioDao();
        FilialDao filialDao = new FilialDao();

        if (acao.equals("mostrartelausuario")) {

            try {
                List<Funcionario> listafuncionario = funcDao.listarTodosFuncionario();
                List<Filial> listafilial = filialDao.listarTodos();
                request.getSession().setAttribute("listafuncionario", listafuncionario);
                request.getSession().setAttribute("listafilial", listafilial);
            } catch (SQLException ex) {
                Logger.getLogger(PerfilServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/paginajsp/criarusuario.jsp");
            dispatcher.forward(request, response);
        } else if (acao.equals("listarusuarios")) {
            UsuarioDao userDao = new UsuarioDao();
            try {
                List<Usuario> listausuario = userDao.listarUsuarios();
                request.setAttribute("listausuario", listausuario);

                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/paginajsp/listausuario.jsp");
                dispatcher.forward(request, response);

            } catch (PersistenceException ex) {
                Logger.getLogger(AcessorioServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(PerfilServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("id");
        Usuario user = new Usuario();
        UsuarioDao userDao = new UsuarioDao();

        if (id.equals("null") || id.isEmpty()) {

            try {

                String nome = request.getParameter("funcionario");
                String filial = request.getParameter("filial");
                String login = request.getParameter("cpf");
                UUID uuid = UUID.randomUUID();
                String senha = uuid.toString();
                String perfil = request.getParameter("perfil").toUpperCase();
                int nivelacesso = 0;
                if (perfil.equals("BACKOFFICE")) {

                    nivelacesso = 2;
                } else if (perfil.equals("GERENTE")) {

                    nivelacesso = 3;
                } else if(perfil.equals("SUPORTE")) {
                    nivelacesso = 4;
                }
                String emailusuario = request.getParameter("email");

                user.setNome(nome);
                user.getFilial().setId(Integer.parseInt(filial));
                user.setLogin(login.replace(".", "").replace("-", ""));
                user.setSenha(senha.replace("-", "").substring(0,5));
                user.setNivelacesso(nivelacesso);
                userDao.cadastrar(user);

                if (user != null) {

                    UsuarioControler userControler = new UsuarioControler();
                    userControler.enviarEmail(senha, emailusuario);
                }

            } catch (Exception ex) {

                Logger.getLogger(PerfilServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

            response.sendRedirect("PerfilServlet?acao=mostrartelausuario");
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
