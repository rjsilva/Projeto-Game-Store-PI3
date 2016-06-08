/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gamestore.Servlet;

import br.com.gamestore.dao.FilialDao;
import br.com.gamestore.modelo.Filial;
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
@WebServlet(name = "FilialServlet", urlPatterns = {"/FilialServlet"})
public class FilialServlet extends HttpServlet {

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
            out.println("<title>Servlet FilialServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet FilialServlet at " + request.getContextPath() + "</h1>");
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
        String getCidade = request.getParameter("getCidades");

        FilialDao filialDao = new FilialDao();
        Filial filial = new Filial();

        /**
         * SE A AÇÃO FOR CADASTRAR FILIAL, ELE RETORNARÁ A PAGINA DE CADASTRO DE FILIAL
         */
        if (acao.equals("mostrartela")) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/paginajsp/cadastrofilial.jsp");
            dispatcher.forward(request, response);
         /**
          * SE AÇÃO FOR EXCLUIR, ELE EXCLUIRÁ FILIAL DE ACORDO COM O ID
          */
        } else if (acao.equals("excluir")) {
            String id = request.getParameter("id");
            filial.setId(Integer.parseInt(id));
            if (id != null) {
                filialDao.excluir(filial);
                response.sendRedirect("FilialServlet?acao=listar");
            }
            /**
             * SE AÇÃO FOR LISTAR, LISTARÁ AS INFORMAÇÕES DA FILIAL
             */
        } else if (acao.equals("listar")) {
            try {
                List<Filial> listafilial = filialDao.listarTodasFiliais();
                request.setAttribute("listafilial", listafilial);

                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/paginajsp/listafilial.jsp");
                dispatcher.forward(request, response);

            } catch (PersistenceException | SQLException ex) {
                Logger.getLogger(AcessorioServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            /**
             * SE AÇÃO FOR ATULIZAR, LEVA OS DADOS A TELA DE CADASTRO FILIAL DE ACORDO COM O ID
             */
        } else if (acao.equals("atualizar")) {
            String id = request.getParameter("id");
            filial = filialDao.buscarPorId(Integer.parseInt(id));
            request.setAttribute("filial", filial);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/paginajsp/cadastrofilial.jsp");
            dispatcher.forward(request, response);

            /**
             * SETA OS OBJETOS EM BRANCO, APÓS CADASTRO FILIAL
             */
        } else if (acao.equals("cadastro")) {

            filial.setRazao_social("");
            filial.setCnpj("");
            filial.setTelefone("");
            request.setAttribute("filial", filial);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/paginajsp/cadastrofilial.jsp");
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
         * RECEBE A INFORMAÇÃO DO ID
         */
        String id = request.getParameter("id");
        Filial filial = new Filial();
        FilialDao filialDao = new FilialDao();

        /**
         * CASO O ID, SEJA NULO, SERÁ CADASTRADO A FILIAL
         */
        if (id.equals("null") || id.isEmpty()) {

            String logradouro = request.getParameter("rua");
            String bairro = request.getParameter("bairro");
            String cidade = request.getParameter("cidade");
            String estado = request.getParameter("uf");
            String cep = request.getParameter("cep");

            String razaosocial = request.getParameter("razaosocial");
            String cnpj = request.getParameter("cnpj");
            String telefone = request.getParameter("telefone");

            filial.setRazao_social(razaosocial);
            filial.setCnpj(cnpj);
            filial.setTelefone(telefone);
            filial.getEndereco().setLogradouro(logradouro);
            filial.getEndereco().setBairro(bairro);
            filial.getEndereco().setCep(cep);
            filial.getEndereco().setEstado(estado);
            filial.getEndereco().setCidade(cidade);

            filialDao.cadastrar(filial);
            response.sendRedirect("FilialServlet?acao=mostrartela");

            /**
             * SE O ID FOR DIFERENTE DE NULO, SERÁ ATUALIZADO AS INFORMAÇÕES DA FILIAL
             * DE ACORDO COM O ID
             */
        } else {

            filial.setId(Integer.parseInt(id));
            String logradouro = request.getParameter("rua");
            String bairro = request.getParameter("bairro");
            String cidade = request.getParameter("cidade");
            String uf = request.getParameter("uf");
            String cep = request.getParameter("cep");

            String razaosocial = request.getParameter("razaosocial");
            String cnpj = request.getParameter("cnpj");
            String telefone = request.getParameter("telefone");

            filial.setRazao_social(razaosocial);
            filial.setCnpj(cnpj);
            filial.setTelefone(telefone);
            filial.getEndereco().setLogradouro(logradouro);
            filial.getEndereco().setBairro(bairro);
            filial.getEndereco().setCep(cep);
            filial.getEndereco().setEstado(uf);
            filial.getEndereco().setCidade(cidade);

            filialDao.atualizar(filial);
            response.sendRedirect("FilialServlet?acao=listar");
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
