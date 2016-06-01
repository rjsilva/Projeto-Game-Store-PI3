/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gamestore.Servlet;

import br.com.gamestore.dao.ChamadoDao;
import br.com.gamestore.modelo.Chamado;
import br.com.gamestore.modelo.Funcionario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
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
@WebServlet(name = "ChamadoServlet", urlPatterns = {"/ChamadoServlet"})
public class ChamadoServlet extends HttpServlet {

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
            out.println("<title>Servlet ChamadoServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ChamadoServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String acao = request.getParameter("acao");
        String id = request.getParameter("id");
        ChamadoDao chamadoDao = new ChamadoDao();

        if (acao.equals("tela")) {

            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/paginajsp/abrirchamado.jsp");
            dispatcher.forward(request, response);
        } else if (acao.equals("listar")) {

            try {
                List<Chamado> listachamado = chamadoDao.listarTodosChamados();
                request.setAttribute("listachamado", listachamado);

                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/paginajsp/listachamado.jsp");
                dispatcher.forward(request, response);

            } catch (SQLException ex) {
                Logger.getLogger(ChamadoServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acao = request.getParameter("acao");
        Chamado chamado = new Chamado();
        Funcionario funcionario = new Funcionario();
        ChamadoDao cdao = new ChamadoDao();

        if (acao.equals("cadastrar")) {

            try {

                String nomefuncionario = request.getParameter("nomefuncionario");
                String email = request.getParameter("email");
                String telefone = request.getParameter("telefone");
                String assunto = request.getParameter("assunto");
                String comentario = request.getParameter("comentario");

                chamado.getFuncionario().setNome(nomefuncionario);
                chamado.setEmail(email);
                chamado.setTelefone(telefone);
                chamado.setAssunto(assunto);
                chamado.setComentario(comentario);
                chamado.setStatus("EM ANDAMENTO");

                cdao.cadastrar(chamado);
                response.sendRedirect("ChamadoServlet?acao=tela");

            } catch (Exception ex) {

                Logger.getLogger(ChamadoServlet.class.getName()).log(Level.SEVERE, null, ex);

            }

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
