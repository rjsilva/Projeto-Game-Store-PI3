/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gamestore.dao;

import br.com.gamestore.Servlet.VendaServlet;
import br.com.gamestore.modelo.Acessorio;
import br.com.gamestore.modelo.Venda;
import com.mycompany.gamestore.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
             * PEGA O NOME DO FUNCIONARIO NA SESSÃO E BUSCA A FILIAL NO QUAL O MESMO TRABALHA
             */
            String nomeFuncionario = null;
            String nomeFilial = null;
            Double preco = null;
            String sqlfuncionariofilial = "SELECT NOME_FUNCIONARIO, RAZAO_SOCIAL FROM TB_FUNCIONARIO\n"
                    + "INNER JOIN TB_FILIAL ON TB_FUNCIONARIO.ID_FILIAL = TB_FUNCIONARIO.ID_FILIAL\n"
                    + "WHERE NOME_FUNCIONARIO = " + venda.getFuncionario().getNome();

            PreparedStatement stmfuncionariofilial = conexao.prepareStatement(sqlfuncionariofilial);
            ResultSet resultfuncionariofilial = stmfuncionariofilial.executeQuery();
            resultfuncionariofilial.next();
            nomeFuncionario = resultfuncionariofilial.getString("NOME_FUNCIONARIO");
            nomeFilial = resultfuncionariofilial.getString("RAZAO_SOCIAL");

            /**
             * PEGA O PREÇO DO PRODUTO NA TABELA DE PRODUTOS
             */
            String sqlprecoproduto = "SELECT PRECO FROM TB_ACESSORIOS\n"
                    + "WHERE ID_ACESSORIO = " + venda.getAcessorio().getNome();
            PreparedStatement stmprecoproduto = conexao.prepareStatement(sqlprecoproduto);
            ResultSet resultprecoproduto = stmprecoproduto.executeQuery();
            resultprecoproduto.next();
            preco = resultprecoproduto.getDouble("PRECO");
            
            /**
             * FAZ O INSERT NA TABELA DE VENDA DE PRODUTO
             */

            String sqlvenda = "INSERT INTO TB_VENDA(NOME_PRODUTO,NOME_FUNCIONARIO, NOME_FILIAL,DATA_VENDA, QUANTIDADE_VENDA, PRECO)"
                    + " VALUES(?,?,?,?,?,?)";
            PreparedStatement stm = conexao.prepareStatement(sqlvenda);
            stm.setString(1, venda.getAcessorio().getNome());
            stm.setString(2, nomeFuncionario);
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

}
