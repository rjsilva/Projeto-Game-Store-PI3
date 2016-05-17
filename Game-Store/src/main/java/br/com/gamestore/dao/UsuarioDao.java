/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gamestore.dao;

import br.com.gamestore.exception.PersistenciaException;
import br.com.gamestore.modelo.Usuario;
import com.mycompany.gamestore.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author rjs
 */
public class UsuarioDao implements GenericDao<Usuario> {

    public boolean validarUsuario(Usuario user) throws PersistenciaException {
        try {
            Connection conexao = Conexao.obterConexao();

            StringBuilder sql = new StringBuilder();
            sql.append("SELECT USUARIO, SENHA FROM TB_USUARIO");
            sql.append(" WHERE USUARIO = ? AND SENHA = ?");
            PreparedStatement stm = conexao.prepareStatement(sql.toString());
            stm.setString(1, user.getUsuario());
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
            String sql = "INSERT INTO TB_USUARIO(USUARIO, SENHA, PERFIL)"
                    + "values(?,?,?)";
            PreparedStatement stm = conexao.prepareStatement(sql.toString());
            stm.setString(1, user.getUsuario());
            stm.setString(2, user.getSenha());
            stm.setString(3, user.getPerfil());
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
    
    public void enviarEmail(){
        
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
