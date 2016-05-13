/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gamestore.Servlet;

import br.com.gamestore.dao.EnderecoDao;
import br.com.gamestore.dao.FilialDao;
import br.com.gamestore.dao.FuncionarioDao;
import br.com.gamestore.modelo.Filial;
import br.com.gamestore.modelo.Funcionario;
import java.io.IOException;
import java.io.PrintWriter;
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

        String acao = request.getParameter("acao");
        String getCidade = request.getParameter("getCidades");

        FuncionarioDao fdao = new FuncionarioDao();
        Funcionario func = new Funcionario();

        if (acao.equals("filial")) {
            try {
                EnderecoDao edao = new EnderecoDao();
                FilialDao filialDao = new FilialDao();
                if (getCidade != null && !"".equals(getCidade)) {

                    String idestado = request.getParameter("idEstado");
                    int id = Integer.parseInt(idestado);
                    request.setAttribute("listaEstado", edao.listarCidades(id));
                } else {
                    request.getSession().setAttribute("listauf", edao.listarUfs());
                }
                request.setAttribute("listafilial", filialDao.buscarPorNome());
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/paginajsp/cadastrofilial.jsp");
                dispatcher.forward(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(FuncionarioServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (acao.equals("mostrartela")) {

            try {
                EnderecoDao edao = new EnderecoDao();
                request.setAttribute("listauf", edao.listarUfs());
            } catch (SQLException ex) {
                Logger.getLogger(FilialServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
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

        String acao = request.getParameter("acao");
        Filial filial = new Filial();
        FilialDao filialDao = new FilialDao();
        // Endereco endereco = new Endereco();

        if (acao.equals("cadastrofilial")) {

            String logradouro = request.getParameter("endereco");
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
            filial.getEndereco().setRua(logradouro);
            filial.getEndereco().setBairro(bairro);
            filial.getEndereco().setCep(cep);

            filialDao.cadastrar(filial);
            response.sendRedirect("FilialServlet?acao=mostrartela");
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
