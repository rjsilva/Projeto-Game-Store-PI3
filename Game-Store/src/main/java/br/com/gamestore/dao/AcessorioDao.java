/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gamestore.dao;

import br.com.gamestore.Servlet.AcessorioServlet;
import br.com.gamestore.modelo.Acessorio;
import br.com.gamestore.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.PersistenceException;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author rjs
 */
public class AcessorioDao implements GenericDao<Acessorio> {

    private HttpServletRequest request;

    @Override
    public void cadastrar(Acessorio ac) {
        PreparedStatement stm = null;
        Integer codproduto = null;
        
        try {
            Connection conexao = Conexao.obterConexao();
            String sqlproduto = "INSERT INTO TB_ACESSORIOS(NOME_ACESSORIO,MARCA, PRECO, TIPO, QUANTIDADE, NOTA_FISCAL)"
                    + "values(?,?,?,?,?,?)";
            stm = conexao.prepareStatement(sqlproduto, Statement.RETURN_GENERATED_KEYS);
            stm.setString(1, ac.getNome());
            stm.setString(2, ac.getMarca());
            stm.setLong(3, ac.getPreco());
            stm.setString(4, ac.getTipo());
            stm.setInt(5, ac.getQuantidade());
            stm.setInt(6, ac.getNota_fiscal());
            stm.execute();

            ResultSet rs = stm.getGeneratedKeys();
            if (rs.next()) {

                codproduto = rs.getInt(1);
            }

            String sqlestoque = "INSERT INTO TB_ESTOQUE(ID_ACESSORIO,NOME_ACESSORIO,MARCA, PRECO, TIPO, QUANTIDADE, NOTA_FISCAL)"
                    + "values(?,?,?,?,?,?,?)";
            stm = conexao.prepareStatement(sqlestoque, Statement.RETURN_GENERATED_KEYS);
            stm.setInt(1, codproduto);
            stm.setString(2, ac.getNome());
            stm.setString(3, ac.getMarca());
            stm.setLong(4, ac.getPreco());
            stm.setString(5, ac.getTipo());
            stm.setInt(6, ac.getQuantidade());
            stm.setInt(7, ac.getNota_fiscal());
            stm.execute();
            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(AcessorioServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void excluir(Acessorio ac) {

        String sql = "DELETE FROM TB_ACESSORIOS WHERE ID_ACESSORIO=?";

        try {

            Connection conexao = Conexao.obterConexao();

            PreparedStatement stm = conexao.prepareStatement(sql);
            stm.setLong(1, ac.getId());
            stm.execute();
        } catch (SQLException ex) {
            Logger.getLogger(AcessorioServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            stm.setLong(7, ac.getId());

            stm.execute();
            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(AcessorioServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List<Acessorio> listarTodos() throws PersistenceException, SQLException {

        Statement stmt = null;
        Connection conn = null;

        String sql = "SELECT ID_ACESSORIO, NOME_ACESSORIO, MARCA, PRECO, TIPO, QUANTIDADE, NOTA_FISCAL"
                + " FROM TB_ACESSORIOS";
        List<Acessorio> lista = new ArrayList<>();

        try {
            Connection conexao = Conexao.obterConexao();
            PreparedStatement stm = conexao.prepareStatement(sql);
            ResultSet resultados = stm.executeQuery();
            while (resultados.next()) {
                Acessorio ac = new Acessorio();
                ac.setId(resultados.getInt(1));
                ac.setNome(resultados.getString(2));
                ac.setMarca(resultados.getString(3));
                ac.setPreco(resultados.getLong(4));
                ac.setTipo(resultados.getString(5));
                ac.setQuantidade(resultados.getInt(6));
                ac.setNota_fiscal(resultados.getInt(7));

                lista.add(ac);
            }

        } catch (PersistenceException ex) {
            Logger.getLogger(AcessorioServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public List<Acessorio> buscarPorNome() {

        String sql = "SELECT * FROM TB_ACESSORIOS";

        List<Acessorio> listaAcessorio = new ArrayList<>();

        try {

            Connection conexao = Conexao.obterConexao();
            PreparedStatement stm = conexao.prepareStatement(sql);
            ResultSet resultados = stm.executeQuery();
            while (resultados.next()) {
                Acessorio ac = new Acessorio();
                ac.setId(resultados.getInt(1));
                ac.setNome(resultados.getString(2));
                listaAcessorio.add(ac);
            }

        } catch (Exception ex) {

            Logger.getLogger(AcessorioServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaAcessorio;
    }

    @Override
    public Acessorio buscarPorId(Integer id) {

        String sql = "SELECT * FROM TB_ACESSORIOS WHERE ID_ACESSORIO=?";

        try {

            Connection conexao = Conexao.obterConexao();
            PreparedStatement stm = conexao.prepareStatement(sql);

            stm.setInt(1, id);
            ResultSet resultados = stm.executeQuery();
            while (resultados.next()) {
                Acessorio ac = new Acessorio();
                ac.setId(resultados.getInt(1));
                ac.setNome(resultados.getString(2));
                ac.setMarca(resultados.getString(3));
                ac.setPreco(resultados.getLong(4));
                ac.setTipo(resultados.getString(5));
                ac.setQuantidade(resultados.getInt(6));
                ac.setNota_fiscal(resultados.getInt(7));

                return ac;
            }

        } catch (Exception ex) {

            Logger.getLogger(AcessorioServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Acessorio> listarEstoque() throws PersistenceException, SQLException {

        Statement stmt = null;
        Connection conn = null;

        String sql = "SELECT * FROM TB_ESTOQUE";
        List<Acessorio> lista = new ArrayList<>();

        try {
            Connection conexao = Conexao.obterConexao();
            PreparedStatement stm = conexao.prepareStatement(sql);
            ResultSet resultados = stm.executeQuery();
            while (resultados.next()) {
                Acessorio ac = new Acessorio();
                ac.setId(resultados.getInt(1));
                ac.setNome(resultados.getString(2));
                ac.setMarca(resultados.getString(3));
                ac.setPreco(resultados.getLong(4));
                ac.setTipo(resultados.getString(5));
                ac.setQuantidade(resultados.getInt(6));
                ac.setNota_fiscal(resultados.getInt(7));

                lista.add(ac);
            }

        } catch (PersistenceException ex) {
            Logger.getLogger(AcessorioServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
}
