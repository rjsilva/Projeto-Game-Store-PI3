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

/**
 *
 * @author rjs
 */
public class VendaDao {

    public void registrarVenda(Venda venda) throws SQLException {

        try {

            Connection conexao = Conexao.obterConexao();
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
             * PEGA A QUANTIDADE DO PRODUTO NA TABELA DE ESTOQUE
             */
            Acessorio ac = new Acessorio();
            int quant, resul, codproduto = 0;
            double totalProduto = 0;
            PreparedStatement stm = null;
            String sqlproduto = "SELECT * FROM TB_ESTOQUE WHERE ID_ACESSORIO = " + venda.getAcessorio().getNome();
            stm = conexao.prepareStatement(sqlproduto);
            ResultSet result = stm.executeQuery();
            result.next();
            codproduto = result.getInt("ID_ACESSORIO");
            quant = result.getInt("QUANTIDADE");
            resul = quant - venda.getQuantidade();

            totalProduto = venda.getQuantidade() * preco;
            /**
             * FAZ O INSERT NA TABELA DE VENDA DE PRODUTO
             */
            String sqlvenda = "INSERT INTO TB_VENDA(ID_ACESSORIO,NOME_PRODUTO,NOME_FUNCIONARIO, NOME_FILIAL,DATA_VENDA, QUANTIDADE_VENDA, PRECOUNITARIO,TOTALVENDA)"
                    + " VALUES(?,?,?,?,?,?,?,?)";
            stm = conexao.prepareStatement(sqlvenda);
            stm.setInt(1, codproduto);
            stm.setString(2, nomeProduto);
            stm.setString(3, nomeUsuario);
            stm.setString(4, nomeFilial);
            stm.setDate(5, new java.sql.Date(System.currentTimeMillis()));
            stm.setInt(6, venda.getQuantidade());
            stm.setDouble(7, preco);
            stm.setDouble(8, totalProduto);
            stm.execute();

            String sql2 = "UPDATE TB_ESTOQUE SET QUANTIDADE=? WHERE ID_ACESSORIO= " + venda.getAcessorio().getNome();
            stm = conexao.prepareStatement(sql2);
            stm.setInt(1, resul);
            stm.execute();
            stm.close();

        } catch (Exception ex) {

            Logger.getLogger(VendaServlet.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    public List<Venda> listarVendas() throws PersistenceException, SQLException {

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
                venda.getAcessorio().setId(resultados.getInt(2));
                venda.getAcessorio().setNome(resultados.getString(3));
                venda.getUsuario().setNome(resultados.getString(4));
                venda.getFilial().setRazao_social(resultados.getString(5));
                venda.setDtvenda(resultados.getDate(6));
                venda.setQuantidade(resultados.getInt(7));
                venda.getAcessorio().setPreco(resultados.getLong(8));
                venda.setTotalvenda(resultados.getDouble(9));

                listavenda.add(venda);
            }

        } catch (PersistenceException ex) {

            Logger.getLogger(VendaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listavenda;
    }

    public void CancelarVenda(Venda venda) {

        PreparedStatement stm = null;

        try {

            ResultSet result = null;
            Connection conexao = Conexao.obterConexao();

            int quant, soma, idacessorio, quantVenda = 0;

            String sqlvenda = "SELECT ID_ACESSORIO,QUANTIDADE_VENDA FROM TB_VENDA WHERE ID_VENDA = " + venda.getId();
            stm = conexao.prepareStatement(sqlvenda);
            result = stm.executeQuery();
            result.next();
            idacessorio = result.getInt("ID_ACESSORIO");
            quantVenda = result.getInt("QUANTIDADE_VENDA");

            String sqlestoque = "SELECT QUANTIDADE FROM TB_ESTOQUE WHERE ID_ACESSORIO = " + idacessorio;
            stm = conexao.prepareStatement(sqlestoque);
            result = stm.executeQuery();
            result.next();
            quant = result.getInt("QUANTIDADE");
            soma = quant + quantVenda;

            String sql = "DELETE FROM TB_VENDA WHERE ID_VENDA=?";

            stm = conexao.prepareStatement(sql);
            stm.setLong(1, venda.getId());
            stm.execute();

            String sql2 = "UPDATE TB_ESTOQUE SET QUANTIDADE=? WHERE ID_ACESSORIO= " + idacessorio;
            stm = conexao.prepareStatement(sql2);
            stm.setInt(1, soma);
            stm.execute();

            stm.close();

        } catch (SQLException ex) {

            Logger.getLogger(VendaServlet.class.getName()).log(Level.SEVERE, null, ex);

        }

    }
    
    public void imprimirRelatorioVenda(String caminho) throws SQLException, JRException {

        Map<String, Object> parametro = new HashMap<>();
        Connection conexao = Conexao.obterConexao();
        JasperPrint relatorio = JasperFillManager.fillReport(caminho, parametro, conexao);
        JasperPrintManager.printReport(relatorio, true);
    }
}
