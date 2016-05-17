/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gamestore.Servlet;

import br.com.gamestore.dao.AcessorioDao;
import br.com.gamestore.dao.FilialDao;
import br.com.gamestore.dao.VendaDao;
import br.com.gamestore.modelo.Acessorio;
import br.com.gamestore.modelo.Venda;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
@WebServlet(name = "VendaServlet", urlPatterns = {"/VendaServlet"})
public class VendaServlet extends HttpServlet {

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
            out.println("<title>Servlet VendaServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet VendaServlet at " + request.getContextPath() + "</h1>");
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
        String getProduto = request.getParameter("getproduto");

        if (acao.equals("venda")) {

            AcessorioDao acdao = new AcessorioDao();
            FilialDao filialDao = new FilialDao();
            Acessorio ac = new Acessorio();
            if (getProduto != null && !"".equals(getProduto)) {

                String idproduto = request.getParameter("idProduto");
                int id = Integer.parseInt(idproduto);
                ac = acdao.buscarPorId(id);
                request.setAttribute("ac", ac);
            } else {

                try {
                    request.getSession().setAttribute("listaproduto", acdao.listarTodos());
                } catch (PersistenceException | SQLException ex) {
                    Logger.getLogger(VendaServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            //request.setAttribute("listafilial", filialDao.buscarPorNome());
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/paginajsp/venda.jsp");
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

        Venda venda = new Venda();
        VendaDao vdao = new VendaDao();
        String acao = request.getParameter("acao");

        if (acao.equals("registrarvenda")) {
            String nomeproduto = request.getParameter("nomeproduto");
            String codigofuncionario = request.getParameter("codigofuncionario");
            String datavenda = request.getParameter("dtvenda");
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            Date data = null;
            try {
                data = formato.parse(datavenda);

            } catch (ParseException ex) {
                Logger.getLogger(VendaServlet.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
            String filial = request.getParameter("filial");
            String qtvenda = request.getParameter("quantvenda");

            venda.getAcessorio().setNome(nomeproduto);
            venda.getFuncionario().setId(Integer.parseInt(codigofuncionario));
            venda.setDtvenda(data);
            venda.getFilial().setRazao_social(filial);
            venda.setQuantidade(Integer.parseInt(qtvenda));

            try {
                vdao.registrarVenda(venda);
                response.sendRedirect("VendaServlet?acao=venda");

            } catch (SQLException ex) {
                Logger.getLogger(VendaServlet.class
                        .getName()).log(Level.SEVERE, null, ex);
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
