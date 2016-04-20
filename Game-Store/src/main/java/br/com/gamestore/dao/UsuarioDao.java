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

/**
 *
 * @author rjs
 */
public class UsuarioDao {

    public boolean validarUsuario(Usuario user) throws PersistenciaException {
        try {
            Connection conexao = Conexao.obterConexao();

            StringBuilder sql = new StringBuilder();
            sql.append("SELECT * FROM TB_USUARIO");
            sql.append(" WHERE USUARIO = ? AND SENHA = ?");
            PreparedStatement stm = conexao.prepareStatement(sql.toString());
            stm.setString(1, user.getUsuario());
            stm.setString(2, user.getSenha());

            ResultSet resultado = stm.executeQuery();
            return  resultado.next();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new PersistenciaException(e);
        }
    }
}
