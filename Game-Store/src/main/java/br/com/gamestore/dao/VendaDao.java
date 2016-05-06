/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gamestore.dao;

import br.com.gamestore.modelo.Venda;
import com.mycompany.gamestore.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.PersistenceException;

/**
 *
 * @author rjs
 */
public class VendaDao {

    public void registrarVenda(Venda venda) throws SQLException {

        try {

            Connection conexao = Conexao.obterConexao();

            String sqlvenda = "INSERT INTO TB_VENDA(ID_ACESSORIO, ID_FUNCIONARIO, NOME_ACESSORIO, NOME_FILIAL, DATA_VENDA, QUANTIDADE_VENDA)"
                    + " VALUES(?,?,?,?,?,?)";

            int id = 1;
            PreparedStatement stm = conexao.prepareStatement(sqlvenda);

            stm.setInt(1, id);
            stm.setInt(2, venda.getFuncionario().getId_funcionario());
            stm.setString(3, venda.getAcessorio().getNome());
            stm.setString(4, venda.getFilial().getNome());
            stm.setDate(5, new java.sql.Date(venda.getDtvenda().getTime()));
            stm.setInt(6, venda.getQuantidade());
            stm.execute();
            stm.close();

        } catch (Exception ex) {

            Logger.getLogger(FuncionarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
