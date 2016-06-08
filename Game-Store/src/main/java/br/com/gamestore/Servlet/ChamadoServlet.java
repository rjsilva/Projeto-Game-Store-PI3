/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gamestore.Servlet;

import br.com.gamestore.controler.ChamadoControler;
import br.com.gamestore.dao.ChamadoDao;
import br.com.gamestore.modelo.Chamado;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.PersistenceException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.mail.EmailException;

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
        
        /**
         * RECEBE A AÇÃO DO USUÁRIO
         */
        String acao = request.getParameter("acao");
        Chamado chamado = new Chamado();
        ChamadoDao chamadoDao = new ChamadoDao();

        /**
         * SE A AÇÃO SEJA ABRIRCHAMADO, ELE RETORNARÁ A TELA DE CHAMADO
         */
        if (acao.equals("abrirchamado")) {

            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/paginajsp/abrirchamado.jsp");
            dispatcher.forward(request, response);
            
            /**
             * SE A AÇÃO SEJA LISTARCHAMADO, ELE RETORNA A LISTA DE CHAMADOS
             */
        } else if (acao.equals("listarchamado")) {

            try {
                List<Chamado> listachamado = chamadoDao.listarTodosChamados();
                request.setAttribute("listachamado", listachamado);

                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/paginajsp/listachamado.jsp");
                dispatcher.forward(request, response);

            } catch (SQLException ex) {
                Logger.getLogger(ChamadoServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            /**
             * SE A AÇÃO SEJA ATENDER CHAMADO, OS DADOS DO CHAMADO SÃO LEVADO, PARA A TELA
             * ATENDER CHAMADO
            */
        } else if (acao.equals("atenderchamado")) {

            try {

                List<Chamado> listachamado;
                listachamado = chamadoDao.listarTodosChamados();
                request.setAttribute("listachamado", listachamado);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/paginajsp/atenderchamado.jsp");
                dispatcher.forward(request, response);
            } catch (PersistenceException | SQLException ex) {
                Logger.getLogger(ChamadoServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            /**
             * SE A AÇÃO EXCLUIR, ELE EXCLUIR O CHAMADO 
             */
        } else if (acao.equals("excluir")) {
            String id = request.getParameter("id");
            chamado.setId(Integer.parseInt(id));
            if (id != null) {
                chamadoDao.excluir(chamado);

                response.sendRedirect("ChamadoServlet?acao=atenderchamado");
            }
            /**
             * SE A AÇÃO ATUALIZAR, ELE ATUALIZARÁ AS INFORMAÇÕES DO CHAMADO
             */
        } else if (acao.equals("atualizarchamado")) {
            String id = request.getParameter("id");
            chamado = chamadoDao.buscarPorId(Integer.parseInt(id));
            request.setAttribute("chamado", chamado);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/paginajsp/abrirchamado.jsp");
            dispatcher.forward(request, response);

            /**
             * SETA OS OBJETOS EM BRANCO NA TELA DE CHAMADO, ASSIM QUE O MESMO FOR ABERTO
             */
        } else if (acao.equals("cadastro")) {

            chamado.setEmail("");
            chamado.setTelefone("");
            chamado.setAssunto("");
            chamado.setComentario("");

            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/paginajsp/abrirchamado.jsp");
            dispatcher.forward(request, response);

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
        
        /**
         * RECEBE A AÇÃO E O ID, CASO O ID SEJA NULO SERÁ CADASTRADO, CASO SEJA DIFERENTE DE NULO,
         * SERÁ ATUALIZADO AS INFORMAÇÕES
         */
        String acao = request.getParameter("acao");
        String id = request.getParameter("id");
        Chamado chamado = new Chamado();
        ChamadoDao cdao = new ChamadoDao();

        /**
         * CADASTRA O CHAMADO NA BASE, SE O ID FOR NULO
         */
        if (id == null || id.equals("")) {

            String nomefuncionario = request.getParameter("nomefuncionario");
            String email = request.getParameter("email");
            String telefone = request.getParameter("telefone");
            String assunto = request.getParameter("assunto");
            String comentario = request.getParameter("comentario");
            String status = request.getParameter("status");

            chamado.getFuncionario().setNome(nomefuncionario);
            chamado.setEmail(email);
            chamado.setTelefone(telefone);
            chamado.setAssunto(assunto);
            chamado.setComentario(comentario);
            if (status != null && !status.equals("")) {
                chamado.setStatus(status);
            } else {

                chamado.setStatus("EM ANDAMENTO");

            }

            cdao.cadastrar(chamado);
            response.sendRedirect("ChamadoServlet?acao=abrirchamado");
            /**
             * ATUALIZA AS INFORMAÇÕES DO CHAMADO CASO O ID SEJA DIFERENTE DE NULO
             */
        } else {

            try {
                chamado.setId(Integer.parseInt(id));
                String nomefuncionario = request.getParameter("nomefuncionario");
                String email = request.getParameter("email");
                String telefone = request.getParameter("telefone");
                String assunto = request.getParameter("assunto");
                String comentario = request.getParameter("comentario");
                String status = request.getParameter("status");
                
                chamado.getFuncionario().setNome(nomefuncionario);
                chamado.setEmail(email);
                chamado.setTelefone(telefone);
                chamado.setAssunto(assunto);
                chamado.setComentario(comentario);
                if (status != null && !status.equals("")) {
                    chamado.setStatus(status);
                } else {

                    chamado.setStatus("EM ANDAMENTO");

                }

                cdao.atualizar(chamado);
                ChamadoControler chamadoControler = new ChamadoControler();
                chamadoControler.enviarEmailChamdo(email, comentario);
                response.sendRedirect("ChamadoServlet?acao=abrirchamado");
            } catch (NumberFormatException | EmailException | IOException ex) {

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
