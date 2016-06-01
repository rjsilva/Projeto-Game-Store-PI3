/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gamestore.dao;

import br.com.gamestore.Servlet.FuncionarioServlet;
import br.com.gamestore.modelo.Funcionario;
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
public class FuncionarioDao implements GenericDao<Funcionario> {

    @Override
    public void cadastrar(Funcionario funcionario) {

        try {
            Connection conexao = Conexao.obterConexao();

            Integer codeEndereco = null;

            String sqlendereco = "INSERT INTO TB_ENDERECO(RUA, BAIRRO, CEP, ESTADO, CIDADE)"
                    + " VALUES(?,?,?,?,?)";
            PreparedStatement stmendereco = conexao.prepareStatement(sqlendereco, Statement.RETURN_GENERATED_KEYS);

            stmendereco.setString(1, funcionario.getEndereco().getLogradouro());
            stmendereco.setString(2, funcionario.getEndereco().getBairro());
            stmendereco.setString(3, funcionario.getEndereco().getCep());
            stmendereco.setString(4, funcionario.getEndereco().getEstado());
            stmendereco.setString(5, funcionario.getEndereco().getCidade());

            stmendereco.execute();

            ResultSet rs = stmendereco.getGeneratedKeys();
            if (rs.next()) {

                codeEndereco = rs.getInt(1);
            }
            String razaosocial = null;
            String sqlproduto = "SELECT * FROM TB_FILIAL WHERE ID_FILIAL = " + funcionario.getLocal_trabalho();
            PreparedStatement stm = conexao.prepareStatement(sqlproduto);
            ResultSet result = stm.executeQuery();
            result.next();
            razaosocial = result.getString("RAZAO_SOCIAL");

            String sqlfuncionario = "INSERT INTO TB_FUNCIONARIO(ID_ENDERECO,ID_FILIAL,NOME_FUNCIONARIO, CPF, TELEFONE, DT_NASCIMENTO, CARGO,LOCAL_TRABALHO)"
                    + " VALUES(?,?,?,?,?,?,?,?)";
            PreparedStatement stmfuncionario = conexao.prepareStatement(sqlfuncionario, Statement.RETURN_GENERATED_KEYS);

            stmfuncionario.setInt(1, codeEndereco);
            stmfuncionario.setString(2, funcionario.getLocal_trabalho());
            stmfuncionario.setString(3, funcionario.getNome());
            stmfuncionario.setString(4, funcionario.getCpf());
            stmfuncionario.setString(5, funcionario.getTelefone());
            stmfuncionario.setDate(6, new java.sql.Date(funcionario.getDt_nascimento().getTime()));
            stmfuncionario.setString(7, funcionario.getCargo());
            stmfuncionario.setString(8, razaosocial);

            stmfuncionario.executeUpdate();

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
            stm.setInt(1, func.getId());
            stm.execute();
        } catch (SQLException ex) {

            Logger.getLogger(FuncionarioDao.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    @Override
    public void atualizar(Funcionario funcionario) {

        try {
            PreparedStatement stm = null;
            Connection conexao = Conexao.obterConexao();

            String nomefilial = null;
            String sql = "UPDATE TB_FUNCIONARIO SET NOME_FUNCIONARIO=? , CPF=? ,TELEFONE=?, DT_NASCIMENTO=?, CARGO=?,LOCAL_TRABALHO=?"
                    + " WHERE ID_FUNCIONARIO=?";
            String sqlfilial = "SELECT RAZAO_SOCIAL FROM TB_FILIAL WHERE ID_FILIAL =" + funcionario.getLocal_trabalho();
            PreparedStatement stmfuncionariofilial = conexao.prepareStatement(sqlfilial);
            ResultSet resultfilial = stmfuncionariofilial.executeQuery();
            resultfilial.next();
            nomefilial = resultfilial.getString("RAZAO_SOCIAL");

            stm = conexao.prepareStatement(sql);
            stm.setString(1, funcionario.getNome());
            stm.setString(2, funcionario.getCpf());
            stm.setString(3, funcionario.getTelefone());
            stm.setDate(4, new java.sql.Date(funcionario.getDt_nascimento().getTime()));
            stm.setString(5, funcionario.getCargo());
            stm.setString(6, nomefilial);
            stm.setInt(7,funcionario.getId());

            stm.execute();

            String sqlendereco = "UPDATE TB_ENDERECO SET RUA=? , BAIRRO=? ,CEP=?,ESTADO=?,CIDADE=?";
            stm = conexao.prepareStatement(sqlendereco);
            stm.setString(1, funcionario.getEndereco().getLogradouro());
            stm.setString(2, funcionario.getEndereco().getBairro());
            stm.setString(3, funcionario.getEndereco().getCep());
            stm.setString(4, funcionario.getEndereco().getEstado());
            stm.setString(5, funcionario.getEndereco().getCidade());
            stm.execute();

            stm.close();
        } catch (SQLException ex) {

            Logger.getLogger(FuncionarioServlet.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    @Override
    public Funcionario buscarPorId(Integer id) {

        String sql = "SELECT RUA, BAIRRO, CEP,ESTADO,CIDADE,ID_FUNCIONARIO,NOME_FUNCIONARIO,CPF,TELEFONE,DT_NASCIMENTO,CARGO,LOCAL_TRABALHO  FROM TB_FUNCIONARIO\n"
                + "INNER JOIN TB_ENDERECO\n"
                + "ON TB_FUNCIONARIO.ID_ENDERECO = TB_ENDERECO.ID_ENDERECO WHERE ID_FUNCIONARIO = ?";

        try {

            Connection conexao = Conexao.obterConexao();
            PreparedStatement stm = conexao.prepareStatement(sql);

            stm.setInt(1, id);
            ResultSet resultados = stm.executeQuery();
            while (resultados.next()) {
                Funcionario funcionario = new Funcionario();

                funcionario.getEndereco().setLogradouro(resultados.getString("RUA"));
                funcionario.getEndereco().setBairro(resultados.getString("BAIRRO"));
                funcionario.getEndereco().setCep(resultados.getString("CEP"));
                funcionario.getEndereco().setEstado(resultados.getString("ESTADO"));
                funcionario.getEndereco().setCidade(resultados.getString("CIDADE"));
                funcionario.setId(resultados.getInt("ID_FUNCIONARIO"));
                funcionario.setNome(resultados.getString("NOME_FUNCIONARIO"));
                funcionario.setCpf(resultados.getString("CPF"));
                funcionario.setTelefone(resultados.getString("TELEFONE"));
                funcionario.setDt_nascimento(resultados.getDate("DT_NASCIMENTO"));
                funcionario.setCargo(resultados.getString("CARGO"));
                funcionario.setLocal_trabalho(resultados.getString("LOCAL_TRABALHO"));

                return funcionario;
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
                funcionario.setId(resultados.getInt(1));
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
