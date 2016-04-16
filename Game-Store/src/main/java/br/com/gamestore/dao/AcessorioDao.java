/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gamestore.dao;

import br.com.gamestore.modelo.Acessorio;
import com.mycompany.gamestore.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author rjs
 */
public class AcessorioDao implements GenericDao<Acessorio> {

    @Override
    public void cadastrar(Acessorio ac) {

        try {
            Connection conexao = Conexao.obterConexao();
            String sql = "insert into TB_ACESSORIO(NOME_ACESSORIO, PRECO)"
                    + "values(?,?)";
            PreparedStatement stm = conexao.prepareStatement(sql.toString());
            stm.setString(1, ac.getNome());
            stm.setDouble(2, ac.getPreco());
            stm.execute();
            stm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void excluir(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizar(Acessorio obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Acessorio> listarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Acessorio buscarPorId(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
