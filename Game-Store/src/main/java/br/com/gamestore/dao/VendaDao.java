/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gamestore.dao;

import br.com.gamestore.Servlet.VendaServlet;
import br.com.gamestore.modelo.Acessorio;
import br.com.gamestore.modelo.Venda;
import br.com.gamestore.util.Conexao;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.PersistenceException;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author rjs
 */
public class VendaDao {

    private AcessorioDao acdao = new AcessorioDao();

    public void registrarVenda(Venda venda) throws SQLException {

        Connection conexao = Conexao.obterConexao();

        try {

            /**
             * PEGA O NOME DO FUNCIONARIO NA SESSÃO E BUSCA A FILIAL NO QUAL O
             * MESMO TRABALHA
             */
            String nomeUsuario = null;
            String nomeFilial = null;
            Double preco = null;
            String nomeProduto = null;
            String sqlusuariofilial = "SELECT NOME_USUARIO, RAZAO_SOCIAL FROM TB_USUARIO\n"
                    + "INNER JOIN TB_FILIAL ON TB_USUARIO.ID_FILIAL = TB_FILIAL.ID_FILIAL\n"
                    + "WHERE ID_USUARIO = " + venda.getUsuario().getId();

            PreparedStatement stmfuncionariofilial = conexao.prepareStatement(sqlusuariofilial);
            ResultSet resultfuncionariofilial = stmfuncionariofilial.executeQuery();
            resultfuncionariofilial.next();
            nomeUsuario = resultfuncionariofilial.getString("NOME_USUARIO");
            nomeFilial = resultfuncionariofilial.getString("RAZAO_SOCIAL");

            /**
             * PEGA O PREÇO E O PRODUTO NA TABELA DE PRODUTOS
             */
            String sqlprecoproduto = "SELECT NOME_ACESSORIO, PRECO FROM TB_ACESSORIOS\n"
                    + "WHERE ID_ACESSORIO = " + venda.getAcessorio().getNome();
            PreparedStatement stmprecoproduto = conexao.prepareStatement(sqlprecoproduto);
            ResultSet resultprecoproduto = stmprecoproduto.executeQuery();
            resultprecoproduto.next();
            preco = resultprecoproduto.getDouble("PRECO");
            nomeProduto = resultprecoproduto.getString("NOME_ACESSORIO");

            /**
             * FAZ O INSERT NA TABELA DE VENDA DE PRODUTO
             */
            String sqlvenda = "INSERT INTO TB_VENDA(NOME_PRODUTO,NOME_FUNCIONARIO, NOME_FILIAL,DATA_VENDA, QUANTIDADE_VENDA, PRECOUNITARIO)"
                    + " VALUES(?,?,?,?,?,?)";
            PreparedStatement stm = conexao.prepareStatement(sqlvenda);
            stm.setString(1, nomeProduto);
            stm.setString(2, nomeUsuario);
            stm.setString(3, nomeFilial);
            stm.setDate(4, new java.sql.Date(System.currentTimeMillis()));
            stm.setInt(5, venda.getQuantidade());
            stm.setDouble(6, preco);

            stm.execute();
            Acessorio ac = new Acessorio();
            int quant = 0, resul = 0;
            String sqlproduto = "SELECT * FROM TB_ACESSORIOS WHERE ID_ACESSORIO = " + venda.getAcessorio().getNome();
            stm = conexao.prepareStatement(sqlproduto);
            ResultSet result = stm.executeQuery();
            result.next();
            quant = result.getInt("QUANTIDADE");
            resul = quant - venda.getQuantidade();
            String sql2 = "UPDATE TB_ACESSORIOS SET QUANTIDADE=? WHERE ID_ACESSORIO= " + venda.getAcessorio().getNome();
            stm = conexao.prepareStatement(sql2);
            stm.setInt(1, resul);
            stm.execute();
            stm.close();

        } catch (Exception ex) {

            Logger.getLogger(VendaServlet.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    public List<Venda> listarTodos() throws PersistenceException, SQLException {

        Statement stmt = null;
        Connection conn = null;

        String sql = "SELECT * FROM TB_VENDA";
        List<Venda> listavenda = new ArrayList<>();

        try {
            Connection conexao = Conexao.obterConexao();
            PreparedStatement stm = conexao.prepareStatement(sql);
            ResultSet resultados = stm.executeQuery();
            while (resultados.next()) {
                Venda venda = new Venda();
                venda.setId(resultados.getLong(1));
                venda.getAcessorio().setNome(resultados.getString(2));
                venda.getUsuario().setNome(resultados.getString(3));
                venda.getFilial().setRazao_social(resultados.getString(4));
                venda.setDtvenda(resultados.getDate(5));
                venda.setQuantidade(resultados.getInt(6));
                venda.getAcessorio().setPreco(resultados.getDouble(7));

                listavenda.add(venda);
            }

        } catch (PersistenceException e) {
            e.printStackTrace();
        }
        return listavenda;
    }

    public void imprimirRelatorioVenda(String caminho) throws SQLException, JRException {

        Map<String, Object> parametro = new HashMap<>();
        Connection conexao = Conexao.obterConexao();
        JasperPrint relatorio = JasperFillManager.fillReport(caminho, parametro, conexao);
        JasperPrintManager.printReport(relatorio, true);
        //JasperViewer.viewReport(relatorio);
    }
}
