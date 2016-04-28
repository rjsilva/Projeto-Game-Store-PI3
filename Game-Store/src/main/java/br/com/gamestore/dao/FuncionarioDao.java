/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gamestore.dao;

import br.com.gamestore.modelo.Endereco;
import br.com.gamestore.modelo.Funcionario;
import com.mycompany.gamestore.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rjs
 */
public class FuncionarioDao implements GenericDao<Funcionario> {

    @Override
    public void cadastrar(Funcionario funcionario) {

        Endereco endereco = new Endereco();
        try {
            Connection conexao = Conexao.obterConexao();
            String sql = "INSERT INTO TB_FUNCIONARIO(NOME_FUNCIONARIO, CPF, TELEFONE, DT_NASCIMENTO) VALUES(?,?,?,?)"
                    + "INSER INTO TB_ENDERECO(RUA, BAIRRO, CEP) VALUES(?,?,?)";

            PreparedStatement stm = conexao.prepareStatement(sql);
            stm.setString(1, funcionario.getNome());
            stm.setString(2, funcionario.getCpf());
            stm.setString(3, funcionario.getTelefone());
            stm.setDate(4, funcionario.getDt_nascimento());
            stm.setString(5, endereco.getRua());
            stm.setString(6, endereco.getBairro());
            stm.setString(7, endereco.getCep());
            stm.execute();
            stm.close();

        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void excluir(Funcionario Obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizar(Funcionario obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Funcionario buscarPorId(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
