/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gamestore.dao;

import br.com.gamestore.modelo.Chamado;
import com.mycompany.gamestore.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author rjs
 */
public class ChamadoDao implements GenericDao<Chamado> {

    @Override
    public void cadastrar(Chamado cha) {
        try {
            Connection conexao = Conexao.obterConexao();
            String sql = "INSERT INTO TB_CHAMADO(NOME_FUNCIONARIO,EMAIL, ASSUNTO, COMENTARIO,TELEFONE)"
                    + "values(?,?,?,?,?)";
            PreparedStatement stm = conexao.prepareStatement(sql);
            stm.setString(1, cha.getFuncionario().getNome());
            stm.setString(2, cha.getEmail());
            stm.setString(3, cha.getAssunto());
            stm.setString(4, cha.getComentario());
            stm.setString(5, cha.getTelefone());
            stm.execute();
            stm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void excluir(Chamado Obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizar(Chamado obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Chamado buscarPorId(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
