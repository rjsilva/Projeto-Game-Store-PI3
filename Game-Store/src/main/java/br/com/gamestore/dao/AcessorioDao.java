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
            String sql = "INSERT INTO TB_ACESSORIOS(NOME_ACESSORIO,MARCA, PRECO, TIPO, QUANTIDADE, NOTA_FISCAL)"
                    + "values(?,?,?,?,?,?)";
            PreparedStatement stm = conexao.prepareStatement(sql.toString());
            stm.setString(1, ac.getNome());
            stm.setString(2, ac.getMarca());
            stm.setDouble(3, ac.getPreco());
            stm.setString(4, ac.getTipo());
            stm.setInt(5, ac.getQuantidade());
            stm.setInt(6, ac.getNota_fiscal());
            stm.execute();
            stm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void excluir(Acessorio ac) {

        String sql = "DELETE FROM TB_ACESSORIOS WHERE ID_ACESSORIO=?";

        try {

            Connection conexao = Conexao.obterConexao();

            PreparedStatement stm = conexao.prepareStatement(sql);
            stm.setInt(1, ac.getID_Acessorio());
            stm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void atualizar(Acessorio ac) {

        String sql = "UPDATE TB_ACESSORIOS SET NOME_ACESSORIO=? , MARCA=? , PRECO=? , TIPO=? , QUANTIDADE=? , NOTA_FISCAL=?"
                + " WHERE ID_ACESSORIO=?";

        try {

            Connection conexao = Conexao.obterConexao();
            PreparedStatement stm = conexao.prepareStatement(sql);

            stm.setString(1, ac.getNome());
            stm.setString(2, ac.getMarca());
            stm.setDouble(3, ac.getPreco());
            stm.setString(4, ac.getTipo());
            stm.setInt(5, ac.getQuantidade());
            stm.setInt(6, ac.getNota_fiscal());
            stm.setInt(7, ac.getID_Acessorio());

            stm.execute();
            stm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<Acessorio> listarTodos() throws PersistenceException, SQLException {

        Statement stmt = null;
        Connection conn = null;

        String sql = "SELECT ID_ACESSORIO, NOME_ACESSORIO, MARCA, PRECO, TIPO, QUANTIDADE, NOTA_FISCAL"
                + " FROM TB_ACESSORIOS";
        List<Acessorio> lista = new ArrayList<Acessorio>();

        try {
            Connection conexao = Conexao.obterConexao();
            PreparedStatement stm = conexao.prepareStatement(sql);
            ResultSet resultados = stm.executeQuery();
            while (resultados.next()) {
                Acessorio ac = new Acessorio();
                ac.setID_Acessorio(resultados.getInt(1));
                ac.setNome(resultados.getString(2));
                ac.setMarca(resultados.getString(3));
                ac.setPreco(resultados.getDouble(4));
                ac.setTipo(resultados.getString(5));
                ac.setQuantidade(resultados.getInt(6));
                ac.setNota_fiscal(resultados.getInt(7));
                
                lista.add(ac);
            }

        } catch (PersistenceException e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public Acessorio buscarPorId(Integer id) {

        String sql = "SELECT * FROM TB_ACESSORIOS WHERE ID_ACESSORIO=?";

        try {

            Connection conexao = Conexao.obterConexao();
            PreparedStatement stm = conexao.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet resultados = stm.executeQuery();
            if (resultados.next()) {
                Acessorio ac = new Acessorio();
                ac.setID_Acessorio(resultados.getInt("ID_ACESSORIO"));
                ac.setNome(resultados.getString("NOME_ACESSORIO"));
                ac.setMarca(resultados.getString("MARCA"));
                ac.setPreco(resultados.getDouble("PRECO"));
                ac.setTipo(resultados.getString("TIPO"));
                ac.setQuantidade(resultados.getInt("QUANTIDADE"));
                ac.setNota_fiscal(resultados.getInt("NOTA_FISCAL"));
                
                return ac;
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return null;
    }

}
