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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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
            String sql = "INSERT INTO TB_ACESSORIOS(NOME_ACESSORIO,MARCA, PRECO, TIPO, QUANTIDADE)"
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

        Statement stmt = null;
        Connection conn = null;

        String sql = "SELECT * FROM TB_ACESSORIOS";
        List<Acessorio> lista = new ArrayList<Acessorio>();
        Acessorio ac = new Acessorio();
        try {
            Connection conexao = Conexao.obterConexao();
            PreparedStatement stm = conexao.prepareStatement(sql);
            ResultSet resultados = stm.executeQuery();
            while (resultados.next()) {
                ac.setID_Acessorio(resultados.getInt("ID_ACESSORIO"));
                ac.setNome(resultados.getString("NOME_ACESSORIO"));
                ac.setMarca(resultados.getString("MARCA"));
                ac.setPreco(resultados.getDouble("PRECO"));
                ac.setTipo(resultados.getString("TIPO"));
                ac.setQuantidade(resultados.getInt("QUANTIDADE"));
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
