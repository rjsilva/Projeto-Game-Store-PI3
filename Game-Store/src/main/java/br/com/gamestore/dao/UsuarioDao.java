/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gamestore.dao;

import br.com.gamestore.Servlet.UsuarioServlet;
import br.com.gamestore.exception.PersistenciaException;
import br.com.gamestore.modelo.Usuario;
import br.com.gamestore.util.Conexao;
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
public class UsuarioDao implements GenericDao<Usuario> {

    private Connection conexao = null;

    public boolean validarUsuario(Usuario user) throws PersistenciaException {
        try {
            Connection conexao = Conexao.obterConexao();

            StringBuilder sql = new StringBuilder();
            sql.append("SELECT LOGIN, SENHA FROM TB_USUARIO");
            sql.append(" WHERE LOGIN = ? AND SENHA = ?");
            PreparedStatement stm = conexao.prepareStatement(sql.toString());
            stm.setString(1, user.getLogin());
            stm.setString(2, user.getSenha());

            ResultSet resultado = stm.executeQuery();
            return resultado.next();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new PersistenciaException(e);
        }
    }

    @Override
    public void cadastrar(Usuario user) {

        try {

            conexao = Conexao.obterConexao();

            String nomefuncionario;
            int codfuncionario;
            String sqlproduto = "SELECT ID_FUNCIONARIO, NOME_FUNCIONARIO FROM TB_FUNCIONARIO"
                    + " WHERE ID_FUNCIONARIO = " + user.getNome();
            PreparedStatement stmfuncionario = conexao.prepareStatement(sqlproduto);
            ResultSet result = stmfuncionario.executeQuery();
            result.next();
            nomefuncionario = result.getString("NOME_FUNCIONARIO");
            codfuncionario = result.getInt("ID_FUNCIONARIO");

            String sql = "INSERT INTO TB_USUARIO(ID_FILIAL,ID_FUNCIONARIO, LOGIN, SENHA,NOME_USUARIO,NIVEL)"
                    + "values(?,?,?,?,?,?)";
            PreparedStatement stm = conexao.prepareStatement(sql);
            stm.setInt(1, user.getFilial().getId());
            stm.setInt(2, codfuncionario);
            stm.setString(3, user.getLogin());
            stm.setString(4, user.getSenha());
            stm.setString(5, nomefuncionario);
            stm.setInt(6, user.getNivelacesso());

            stm.execute();
            stm.close();
        } catch (SQLException ex) {

            Logger.getLogger(UsuarioServlet.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    @Override
    public void excluir(Usuario user) {

        try {
            conexao = Conexao.obterConexao();

            String sql = "DELETE * FROM WHERE ID_USUARIO =" + user.getId();

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void atualizar(Usuario obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario buscarPorId(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Usuario> listarUsuarios() throws PersistenceException, SQLException {

        String sql = "SELECT LOGIN, NOME_USUARIO,NIVEL, RAZAO_SOCIAL FROM TB_USUARIO\n"
                + "INNER JOIN TB_FILIAL ON TB_USUARIO.ID_FILIAL = TB_FILIAL.ID_FILIAL";
        List<Usuario> listaUsuario = new ArrayList<>();

        try {
            Connection conexao = Conexao.obterConexao();
            PreparedStatement stm = conexao.prepareStatement(sql);
            ResultSet resultados = stm.executeQuery();
            while (resultados.next()) {
                Usuario user = new Usuario();
                user.setLogin(resultados.getString("LOGIN"));
                user.setNome(resultados.getString("NOME_USUARIO"));
                user.setNivelacesso(resultados.getInt("NIVEL"));
                user.getFilial().setRazao_social(resultados.getString("RAZAO_SOCIAL"));

                listaUsuario.add(user);
            }

        } catch (PersistenceException ex) {
            Logger.getLogger(UsuarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaUsuario;
    }

    public Usuario buscarUsuarioPorNome(String nome) {

        try {

            Connection conexao = Conexao.obterConexao();
            String sql = "SELECT ID_USUARIO , LOGIN, NOME_USUARIO, NIVEL FROM TB_USUARIO WHERE LOGIN = ?";
            PreparedStatement stm = conexao.prepareStatement(sql);

            stm.setString(1, nome);
            ResultSet resultados = stm.executeQuery();
            while (resultados.next()) {
                Usuario user = new Usuario();

                user.setId(resultados.getInt(1));
                user.setLogin(resultados.getString(2));
                user.setNome(resultados.getString(3));
                user.setNivelacesso(resultados.getInt(4));

                return user;

            }

        } catch (Exception ex) {

            Logger.getLogger(UsuarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
}
