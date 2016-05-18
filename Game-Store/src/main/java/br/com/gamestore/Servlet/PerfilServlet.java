/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gamestore.Servlet;

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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import static sun.security.jgss.GSSUtil.login;

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
                String usuario = request.getParameter("login");
                UUID uuid = UUID.randomUUID();
                String senha = uuid.toString();
                String perfil = request.getParameter("perfil");

                user.setNome(nome);
                user.getFilial().setId(Integer.parseInt(filial));
                user.setLogin(usuario);
                user.setSenha(senha.replaceAll("-", "").substring(0, 5));
                user.setPerfil(perfil);
                userDao.cadastrar(user);

                String emailusuario = request.getParameter("email");
                SimpleEmail email = new SimpleEmail();
                email.setHostName("smtp.gmail.com");
                email.setSmtpPort(465);
                email.setAuthentication("rkfsystem@gmail.com", "rkfsystemgamestore");
                email.setSSLOnConnect(true);
                email.setFrom("rkfsystem@gmail.com");
                email.setSubject("usuario e senha de acesso ao sistema");
                email.setMsg("Usuario" + usuario + "\n" + "Senha" + senha.replaceAll("-","").substring(0,5));
                email.addTo(emailusuario);
                email.send();

                response.sendRedirect("AcessorioServlet?acao=criarusuario");

            } catch (Exception ex) {

                Logger.getLogger(PerfilServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        // request.getRequestDispatcher("criarusuario.jsp").forward(request, response);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/paginajsp/criarusuario.jsp");
//        dispatcher.forward(request, response);
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
