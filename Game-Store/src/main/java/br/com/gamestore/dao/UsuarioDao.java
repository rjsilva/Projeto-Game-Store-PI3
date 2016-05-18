/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gamestore.dao;

import br.com.gamestore.Servlet.UsuarioServlet;
import br.com.gamestore.exception.PersistenciaException;
import br.com.gamestore.modelo.Usuario;
import com.mycompany.gamestore.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rjs
 */
public class UsuarioDao implements GenericDao<Usuario> {

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

            Connection conexao = Conexao.obterConexao();
            String sql = "INSERT INTO TB_USUARIO(LOGIN, SENHA, PERFIL, NOME_USUARIO)"
                    + "values(?,?,?,?)";
            PreparedStatement stm = conexao.prepareStatement(sql.toString());
            stm.setString(1, user.getLogin());
            stm.setString(2, user.getSenha());
            stm.setString(3, user.getPerfil());
            stm.setString(4, user.getNome());

            stm.execute();
            stm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void excluir(Usuario Obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizar(Usuario obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario buscarPorId(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Usuario buscarUsuarioPorNome(String nome) {

        try {

            Connection conexao = Conexao.obterConexao();
            String sql = "SELECT ID_USUARIO , LOGIN,  PERFIL, NOME_USUARIO FROM TB_USUARIO WHERE LOGIN = ?";
            PreparedStatement stm = conexao.prepareStatement(sql);

            stm.setString(1, nome);
            ResultSet resultados = stm.executeQuery();
            while (resultados.next()) {
                Usuario user = new Usuario();

                user.setId(resultados.getInt(1));
                user.setLogin(resultados.getString(2));
                user.setPerfil(resultados.getString(3));
                user.setNome(resultados.getString(4));

                return user;

            }

        } catch (Exception ex) {

            Logger.getLogger(UsuarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public void enviarEmail() {

        String email = "";
        String senha = "";

        Properties pro = new Properties();
        pro.put("mail.smtp.auth", "true");
        pro.put("mail.smtp.starttls.anable", "true");
        pro.put("mail.smtp.host", "amtp.gmail.com");
        pro.put("mail.stmp.port", "587");

        // Session sessao = Session.getInstance(prop new javax.mail.Authenticator);
    }
}
