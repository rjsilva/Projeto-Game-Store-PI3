/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gamestore.Servlet;

import com.mycompany.gamestore.util.Conexao;
import java.io.IOException;
import java.security.Provider;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

/**
 *
 * @author rjs
 */
@WebServlet("/relatorio")
public class RelatorioServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String acao = req.getParameter("acao");
        String sql = "SELECT * FROM TB_ACESSORIOS";
        try {
            Connection con = Conexao.obterConexao();
            PreparedStatement stm = con.prepareStatement(sql);
            ResultSet resultados = stm.executeQuery();
            JRResultSetDataSource jrRS = new JRResultSetDataSource(resultados);
            String caminho = getServletContext().getRealPath("WEB-INF/Relatorios/") + "\\";
            JasperPrint jpprint = JasperFillManager.fillReport(caminho + "relatorioestoque.jasper", new HashMap(), jrRS);
            JasperExportManager.exportReportToPdfStream(jpprint, resp.getOutputStream());
        } catch (SQLException | JRException ex) {
            Logger.getLogger(RelatorioServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
