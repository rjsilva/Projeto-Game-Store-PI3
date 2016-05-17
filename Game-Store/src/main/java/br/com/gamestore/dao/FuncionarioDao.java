/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gamestore.dao;

import br.com.gamestore.Servlet.FuncionarioServlet;
import br.com.gamestore.modelo.Funcionario;
import com.mycompany.gamestore.util.Conexao;
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
public class FuncionarioDao implements GenericDao<Funcionario> {

    @Override
    public void cadastrar(Funcionario funcionario) {

        try {

            Connection conexao = Conexao.obterConexao();

            Integer codEndereco = null;

            String sqlendereco = "INSERT INTO TB_ENDERECO(RUA, BAIRRO, CEP)"
                    + " VALUES(?,?,?)";
            PreparedStatement stm = conexao.prepareStatement(sqlendereco, Statement.RETURN_GENERATED_KEYS);

            stm.setString(1, funcionario.getEndereco().getLogradouro());
            stm.setString(2, funcionario.getEndereco().getBairro());
            stm.setString(3, funcionario.getEndereco().getCep());

            stm.executeUpdate();

            ResultSet rs = stm.getGeneratedKeys();
            if (rs.next()) {

                codEndereco = rs.getInt(1);
            }

            String sql1 = "INSERT INTO TB_FUNCIONARIO(ID_ENDERECO,NOME_FUNCIONARIO, CPF, TELEFONE, DT_NASCIMENTO, CARGO,LOCAL_TRABALHO) VALUES(?,?,?,?,?,?,?)";
            PreparedStatement stm1 = conexao.prepareStatement(sql1, Statement.RETURN_GENERATED_KEYS);

            stm1.setInt(1, codEndereco);
            stm1.setString(2, funcionario.getNome());
            stm1.setString(3, funcionario.getCpf());
            stm1.setString(4, funcionario.getTelefone());
            stm1.setDate(5, new java.sql.Date(funcionario.getDt_nascimento().getTime()));
            stm1.setString(6, funcionario.getCargo());
            stm1.setString(7, funcionario.getLocal_trabalho());

            stm1.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void excluir(Funcionario func) {
        String sql = "DELETE FROM TB_FUNCIONARIO WHERE ID_FUNCIONARIO =?";

        try {

            Connection conexao = Conexao.obterConexao();

            PreparedStatement stm = conexao.prepareStatement(sql);
            stm.setInt(1, func.getId_funcionario());
            stm.execute();
        } catch (SQLException ex) {

            Logger.getLogger(FuncionarioDao.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    @Override
    public void atualizar(Funcionario obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Funcionario buscarPorId(Integer id) {

        String sql = "SELECT RUA, BAIRRO, CEP,NOME_FUNCIONARIO,CPF,TELEFONE,DT_NASCIMENTO,CARGO,LOCAL_TRABALHO  FROM TB_ENDERECO\n"
                + "INNER JOIN TB_FUNCIONARIO\n"
                + "ON TB_ENDERECO.ID_ENDERECO = TB_FUNCIONARIO.ID_ENDERECO WHERE TB_FUNCIONARIO.ID_FUNCIONARIO = ?";

        try {

            Connection conexao = Conexao.obterConexao();
            PreparedStatement stm = conexao.prepareStatement(sql);

            stm.setInt(1, id);
            ResultSet resultados = stm.executeQuery();
            while (resultados.next()) {
                Funcionario func = new Funcionario();

                func.setId_funcionario(resultados.getInt(1));
                func.getEndereco().setLogradouro(resultados.getString(2));
                func.getEndereco().setBairro(resultados.getString(3));
                func.getEndereco().setCep(resultados.getString(4));
                func.setNome(resultados.getString(5));
                func.setCpf(resultados.getString(6));
                func.setTelefone(resultados.getString(7));
                func.setDt_nascimento(resultados.getDate("DT_NASCIMENTO"));
                func.setCargo(resultados.getString(9));
                func.setLocal_trabalho(resultados.getString(10));

                return func;
            }

        } catch (Exception ex) {

            Logger.getLogger(FuncionarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Funcionario> listarTodosFuncionario() throws SQLException {
        Statement stmt = null;
        Connection conn = null;

        String sql = "SELECT ID_FUNCIONARIO, NOME_FUNCIONARIO, CARGO, LOCAL_TRABALHO FROM TB_FUNCIONARIO";
        List<Funcionario> lista = new ArrayList<Funcionario>();

        try {
            Connection conexao = Conexao.obterConexao();
            PreparedStatement stm = conexao.prepareStatement(sql);
            ResultSet resultados = stm.executeQuery();
            while (resultados.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setId_funcionario(resultados.getInt(1));
                funcionario.setNome(resultados.getString(2));
                funcionario.setCargo(resultados.getString(3));
                funcionario.setLocal_trabalho(resultados.getString(4));
                lista.add(funcionario);
            }

        } catch (PersistenceException ex) {
            Logger.getLogger(FuncionarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public List<Funcionario> buscarPorNome() {

        String sql = "SELECT NOME_FUNCIONARIO FROM TB_FUNCIONARIO";

        List<Funcionario> listaFuncioario = new ArrayList<>();

        try {

            Connection conexao = Conexao.obterConexao();
            PreparedStatement stm = conexao.prepareStatement(sql);
            ResultSet resultados = stm.executeQuery();
            while (resultados.next()) {
                Funcionario func = new Funcionario();
                func.setNome(resultados.getString("NOME_FUNCIONARIO"));
                listaFuncioario.add(func);
            }

        } catch (Exception ex) {

            Logger.getLogger(FuncionarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaFuncioario;
    }
}
