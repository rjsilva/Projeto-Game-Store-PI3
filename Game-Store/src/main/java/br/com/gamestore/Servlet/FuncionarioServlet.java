/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gamestore.Servlet;

import br.com.gamestore.dao.FilialDao;
import br.com.gamestore.dao.FuncionarioDao;
import br.com.gamestore.modelo.Filial;
import br.com.gamestore.modelo.Funcionario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
@WebServlet(name = "FuncionarioServlet", urlPatterns = {"/FuncionarioServlet"})
public class FuncionarioServlet extends HttpServlet {

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
            out.println("<title>Servlet FuncionarioServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet FuncionarioServlet at " + request.getContextPath() + "</h1>");
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

        FuncionarioDao fdao = new FuncionarioDao();
        Funcionario func = new Funcionario();
        FilialDao filialDao = new FilialDao();

        if (acao.equals("funcionario")) {

            try {
                List<Filial> listaFilial = filialDao.listarTodos();
                request.getSession().setAttribute("listafilial", listaFilial);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/paginajsp/cadastrofuncionario.jsp");
                dispatcher.forward(request, response);

            } catch (PersistenceException | SQLException ex) {
                Logger.getLogger(FuncionarioServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (acao.equals("excluir")) {

            String id = request.getParameter("id");
            func.setId(Integer.parseInt(id));
            if (id != null) {
                fdao.excluir(func);

                response.sendRedirect("FuncionarioServlet?acao=listar");
            }

        } else if (acao.equals("listar")) {

            try {
                List<Funcionario> listafuncionario = fdao.listarTodosFuncionario();
                request.setAttribute("listafuncionario", listafuncionario);

                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/paginajsp/listafuncionario.jsp");
                dispatcher.forward(request, response);

            } catch (SQLException ex) {
                Logger.getLogger(FuncionarioServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (acao.equals("atualizar")) {

            String id = request.getParameter("id");
            //request.setAttribute("lista", fdao.buscarPorNome());
            func = fdao.buscarPorId(Integer.parseInt(id));
            request.setAttribute("func", func);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/paginajsp/cadastrofuncionario.jsp");
            dispatcher.forward(request, response);

        } else if (acao.equals("cadastro")) {

            func.setNome("");
            func.setCpf("");
            func.setTelefone("");
            func.setDt_nascimento(null);
            func.setCargo("");
            func.setLocal_trabalho("");
            func.getEndereco().setLogradouro("");
            func.getEndereco().setCep(null);
            func.getEndereco().setBairro("");
            func.getEndereco().setCidade("");
            func.getEndereco().setEstado("");

            request.setAttribute("func", func);
            request.setAttribute("lista", fdao.buscarPorNome());
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/paginajsp/cadastrofuncionario.jsp");
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
         * se o id for nulo ou vázio a ação cadastra o funcionário
         */
        String id = request.getParameter("id");
        Date data = null;
        Funcionario funcionario = new Funcionario();
        FuncionarioDao fdao = new FuncionarioDao();

        if (id == null || id.isEmpty()) {

            try {

                String logradouro = request.getParameter("rua");
                String bairro = request.getParameter("bairro");
                String cidade = request.getParameter("cidade");
                String uf = request.getParameter("uf");
                String cep = request.getParameter("cep");

                String nome = request.getParameter("nomefuncionario");
                String cpf = request.getParameter("cpf");
                String telefone = request.getParameter("telefone");
                String dt_nascimento = request.getParameter("data");
                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                data = formato.parse(dt_nascimento);
                String cargo = request.getParameter("cargo");
                String local_trabalho = request.getParameter("filial");

                funcionario.setNome(nome);
                funcionario.setCpf(cpf);
                funcionario.setTelefone(telefone);
                funcionario.setDt_nascimento(data);
                funcionario.setCargo(cargo);
                funcionario.setLocal_trabalho(local_trabalho);

                funcionario.getEndereco().setLogradouro(logradouro);
                funcionario.getEndereco().setBairro(bairro);
                funcionario.getEndereco().setCep(cep);
                funcionario.getEndereco().setEstado(uf);
                funcionario.getEndereco().setCidade(cidade);

                fdao.cadastrar(funcionario);

                response.sendRedirect("FuncionarioServlet?acao=funcionario");

            } catch (ParseException | IOException ex) {

                Logger.getLogger(FuncionarioServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

            //metodo de atualizar as informações
        } else {

            try {
                String nome = request.getParameter("nomefuncionario");
                String cpf = request.getParameter("cpf");
                String telefone = request.getParameter("telefone");
                String dt_nascimento = request.getParameter("data");
                SimpleDateFormat formato = new SimpleDateFormat("dd/mm/YYYY");
                data = formato.parse(dt_nascimento);
                String cargo = request.getParameter("cargo");
                String local_trabalho = request.getParameter("filial");
                
                String cep = request.getParameter("cep");
                String logradouro = request.getParameter("rua");
                String bairro = request.getParameter("bairro");
                String uf = request.getParameter("uf");
                String cidade = request.getParameter("cidade");
                
                funcionario.getEndereco().setCep(cep);
                funcionario.getEndereco().setLogradouro(logradouro);
                funcionario.getEndereco().setBairro(bairro);
                funcionario.getEndereco().setEstado(uf);
                funcionario.getEndereco().setCidade(cidade);
                
                funcionario.setNome(nome);
                funcionario.setCpf(cpf);
                funcionario.setTelefone(telefone);
                funcionario.setDt_nascimento(data);
                funcionario.setCargo(cargo);
                funcionario.setLocal_trabalho(local_trabalho);
                
                fdao.atualizar(funcionario);
                response.sendRedirect("FuncionarioServlet?acao=listar");
            } catch (ParseException ex) {
                Logger.getLogger(FuncionarioServlet.class.getName()).log(Level.SEVERE, null, ex);
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
