/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gamestore.dao;

import br.com.gamestore.Servlet.AcessorioServlet;
import br.com.gamestore.modelo.Chamado;
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

/**
 *
 * @author rjs
 */
public class ChamadoDao implements GenericDao<Chamado> {

    @Override
    public void cadastrar(Chamado cha) {
        try {
            Connection conexao = Conexao.obterConexao();
            String sql = "INSERT INTO TB_CHAMADO(NOME_PESSOA,EMAIL, ASSUNTO,COMENTARIO,TELEFONE,STATUS, DATA_CHAMADO)"
                    + "values(?,?,?,?,?,?,?)";
            PreparedStatement stm = conexao.prepareStatement(sql);
            stm.setString(1, cha.getFuncionario().getNome());
            stm.setString(2, cha.getEmail());
            stm.setString(3, cha.getAssunto());
            stm.setString(4, cha.getComentario());
            stm.setString(5, cha.getTelefone());
            stm.setString(6, cha.getStatus());
            stm.setDate(7, new java.sql.Date(System.currentTimeMillis()));
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

    public List<Chamado> listarTodosChamados() throws PersistenceException, SQLException {

        Statement stmt = null;
        Connection conn = null;

        String sql = "SELECT * FROM TB_CHAMADO";
        List<Chamado> listaChamado = new ArrayList<>();

        try {
            Connection conexao = Conexao.obterConexao();
            PreparedStatement stm = conexao.prepareStatement(sql);
            ResultSet resultados = stm.executeQuery();
            while (resultados.next()) {
                Chamado chamado = new Chamado();
                chamado.getFuncionario().setNome(resultados.getString("NOME_PESSOA"));
                chamado.setTelefone(resultados.getString("TELEFONE"));
                chamado.setAssunto(resultados.getString("ASSUNTO"));
                chamado.setEmail(resultados.getString("EMAIL"));
                chamado.setStatus(resultados.getString("STATUS"));
                chamado.setData(resultados.getDate("DATA_CHAMADO"));

                listaChamado.add(chamado);
            }

        } catch (PersistenceException ex) {
            Logger.getLogger(AcessorioServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaChamado;
    }

}
