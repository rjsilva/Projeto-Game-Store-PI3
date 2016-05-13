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

            String sqlvenda = "INSERT INTO TB_VENDA(ID_FUNCIONARIO, NOME_ACESSORIO, NOME_FILIAL, DATA_VENDA, QUANTIDADE_VENDA)"
                    + " VALUES(?,?,?,?,?)";
            PreparedStatement stm = conexao.prepareStatement(sqlvenda);
            stm.setInt(1, venda.getFuncionario().getId_funcionario());
            stm.setString(2, venda.getAcessorio().getNome());
            stm.setString(3, venda.getFilial().getRazao_social());
            stm.setDate(4, new java.sql.Date(venda.getDtvenda().getTime()));
            stm.setInt(5, venda.getQuantidade());
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
