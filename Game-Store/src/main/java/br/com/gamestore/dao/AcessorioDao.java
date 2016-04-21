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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.PersistenceException;

/**
 *
 * @author rjs
 */
public class AcessorioDao implements GenericDao<Acessorio> {

    @Override
    public void cadastrar(Acessorio ac) {

        try {
            Connection conexao = Conexao.obterConexao();
            String sql = "insert into TB_ACESSORIOS(NOME_ACESSORIO,MARCA, PRECO, TIPO, QUANTIDADE)"
                    + "values(?,?,?,?,?)";
            PreparedStatement stm = conexao.prepareStatement(sql.toString());
            stm.setString(1, ac.getNome());
            stm.setString(2, ac.getMarca());
            stm.setDouble(3, ac.getPreco());
            stm.setString(4, ac.getTipo());
            stm.setInt(5, ac.getQuantidade());
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

    
    public List<Acessorio> listarTodos() throws PersistenceException, SQLException {

        String sql = "SELECT * TB_ACESSORIOS";
        List<Acessorio> lista = new ArrayList<Acessorio>();
        Acessorio ac = new Acessorio();
        try {
            Connection conexao = Conexao.obterConexao();
            PreparedStatement stm = conexao.prepareStatement(sql);
            ResultSet resultados = stm.executeQuery();
            while (resultados.next()) {
                ac.setID_Acessorio(resultados.getInt(1));
                ac.setNome(resultados.getString(2));
                ac.setMarca(resultados.getString(3));
                ac.setPreco(resultados.getDouble(4));
                ac.setTipo(resultados.getString(5));
                ac.setQuantidade(resultados.getInt(6));
                lista.add(ac);
            }

        } catch (PersistenceException e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public Acessorio buscarPorId(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
