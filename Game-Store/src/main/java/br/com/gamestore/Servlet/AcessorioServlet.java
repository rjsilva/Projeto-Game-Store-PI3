/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gamestore.Servlet;

import br.com.gamestore.dao.AcessorioDao;
import br.com.gamestore.dao.FuncionarioDao;
import br.com.gamestore.modelo.Acessorio;
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

/**
 *
 * @author rjs
 */
@WebServlet(name = "AcessorioServlet", urlPatterns = {"/AcessorioServlet"})
public class AcessorioServlet extends HttpServlet {

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
            out.println("<title>Servlet NewServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NewServlet at " + request.getContextPath() + "</h1>");
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

        AcessorioDao acdao = new AcessorioDao();
        Acessorio ac = new Acessorio();
        String acao = request.getParameter("acao");

        if (acao.equals("cadastro")) {

            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/paginajsp/acessoriocadastro.jsp");
            dispatcher.forward(request, response);

        } else if (acao.equals("excluir")) {
            String id = request.getParameter("id");
            ac.setId(Integer.parseInt(id));
            if (id != null) {
                acdao.excluir(ac);

                response.sendRedirect("AcessorioServlet?acao=listar");
            }
        } else if (acao.equals("listar")) {
            try {
                List<Acessorio> lista = acdao.listarTodos();
                request.setAttribute("lista", lista);

                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/paginajsp/estoqueprodutos.jsp");
                dispatcher.forward(request, response);

            } catch (PersistenceException | SQLException ex) {
                Logger.getLogger(AcessorioServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            //leva os dados 
        } else if (acao.equals("atualizar")) {
            String id = request.getParameter("id");
            request.setAttribute("lista", acdao.buscarPorNome());
            ac = acdao.buscarPorId(Integer.parseInt(id));
            request.setAttribute("ac", ac);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/paginajsp/acessoriocadastro.jsp");
            dispatcher.forward(request, response);

            //seta objeto em branco
        } else if (acao.equals("cadastro")) {

            Acessorio ace = new Acessorio();

            ace.setNome("");
            ace.setMarca("");
            ace.setPreco(0);
            ace.setTipo("");
            ace.setQuantidade(0);
            ace.setNota_fiscal(0);

            request.setAttribute("ace", ac);
            request.setAttribute("lista", acdao.buscarPorNome());
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/paginajsp/acessoriocadastro.jsp");
            dispatcher.forward(request, response);

        } else if (acao.equals("relatorio")) {

            try {
                List<Acessorio> lista = acdao.listarTodos();
                request.setAttribute("lista", lista);

                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/paginajsp/relatorioestoque.jsp");
                dispatcher.forward(request, response);

            } catch (PersistenceException | SQLException ex) {
                Logger.getLogger(AcessorioServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /**
         * válida a ação e se o id for nulo ou vazio cadastra funcionário
         */
        String id = request.getParameter("id");
        Acessorio ace = new Acessorio();
        AcessorioDao aceDao = new AcessorioDao();

        if (id.equals("null") || id.isEmpty()) {

            try {
                String nome = request.getParameter("acessorio");
                String marca = request.getParameter("marca");
                String preco = request.getParameter("preco");
                String tipo = request.getParameter("tipo");
                String quantidade = request.getParameter("quantidade");
                String nf_fiscal = request.getParameter("nf");

                ace.setNome(nome);
                ace.setMarca(marca);
                ace.setPreco(Double.parseDouble(preco));
                ace.setTipo(tipo);
                ace.setQuantidade(Integer.parseInt(quantidade));
                ace.setNota_fiscal(Integer.parseInt(nf_fiscal));
                aceDao.cadastrar(ace);

                request.setAttribute("msg", "cadastrado com sucesso");
                response.sendRedirect("AcessorioServlet?acao=cadastro");

            } catch (PersistenceException ex) {

                Logger.getLogger(FuncionarioDao.class.getName()).log(Level.SEVERE, null, ex);
            }

            /**
             * se id da ação acima não for vazio, ele já está cadastrado e agora
             * ele atualiza a ação
             */
        } else {

            ace.setId(Integer.parseInt(id));
            String nome = request.getParameter("acessorio");
            String marca = request.getParameter("marca");
            String preco = request.getParameter("preco");
            String tipo = request.getParameter("tipo");
            String quantidade = request.getParameter("quantidade");
            String nf_fisCaL = request.getParameter("nf");

            ace.setNome(nome);
            ace.setMarca(marca);
            ace.setPreco(Double.parseDouble(preco));
            ace.setTipo(tipo);
            ace.setQuantidade(Integer.parseInt(quantidade));
            ace.setNota_fiscal(Integer.parseInt(nf_fisCaL));
            aceDao.atualizar(ace);

            response.sendRedirect("AcessorioServlet?acao=listar");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
