/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gamestore.dao;

import br.com.gamestore.Servlet.FilialServlet;
import br.com.gamestore.Servlet.FuncionarioServlet;
import br.com.gamestore.modelo.Filial;
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
public class FilialDao implements GenericDao<Filial> {

    @Override
    public void cadastrar(Filial filial) {
        try {
            Connection conexao = Conexao.obterConexao();

            Integer codeEndereco = null;

            String sqlendereco = "INSERT INTO TB_ENDERECO(RUA, BAIRRO, CEP, ESTADO, CIDADE)"
                    + " VALUES(?,?,?,?,?)";
            PreparedStatement stmendereco = conexao.prepareStatement(sqlendereco, Statement.RETURN_GENERATED_KEYS);

            stmendereco.setString(1, filial.getEndereco().getLogradouro());
            stmendereco.setString(2, filial.getEndereco().getBairro());
            stmendereco.setString(3, filial.getEndereco().getCep());
            stmendereco.setString(4, filial.getEndereco().getEstado());
            stmendereco.setString(5, filial.getEndereco().getCidade());

            stmendereco.executeUpdate();

            ResultSet rs = stmendereco.getGeneratedKeys();
            if (rs.next()) {

                codeEndereco = rs.getInt(1);
            }

            String sqlfilial = "INSERT INTO TB_FILIAL(ID_ENDERECO, RAZAO_SOCIAL,CNPJ, TELEFONE)"
                    + "values(?,?,?,?)";
            PreparedStatement stmfilial = conexao.prepareStatement(sqlfilial, Statement.RETURN_GENERATED_KEYS);

            stmfilial.setInt(1, codeEndereco);
            stmfilial.setString(2, filial.getRazao_social());
            stmfilial.setString(3, filial.getCnpj());
            stmfilial.setString(4, filial.getTelefone());
            stmfilial.execute();

        } catch (SQLException ex) {

            Logger.getLogger(FuncionarioServlet.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    @Override
    public void excluir(Filial filial) {

        String sql = "DELETE FROM TB_FILIAL WHERE ID_FILIAL=?";

        try {

            Connection conexao = Conexao.obterConexao();

            PreparedStatement stm = conexao.prepareStatement(sql);
            stm.setLong(1, filial.getId());
            stm.execute();
        } catch (SQLException ex) {

            Logger.getLogger(FuncionarioServlet.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    @Override
    public void atualizar(Filial filial) {

        PreparedStatement stm = null;

        String sql = "UPDATE TB_FILIAL SET RAZAO_SOCIAL=? , CNPJ=? ,TELEFONE=?"
                + " WHERE ID_FILIAL=?";
        try {

            Connection conexao = Conexao.obterConexao();
            stm = conexao.prepareStatement(sql);
            stm.setString(1, filial.getRazao_social());
            stm.setString(2, filial.getCnpj());
            stm.setString(3, filial.getTelefone());
            stm.setInt(4, filial.getId());

            stm.execute();

            String sqlendereco = "UPDATE TB_ENDERECO SET RUA=? , BAIRRO=? ,CEP=?,ESTADO=?,CIDADE=?";
            stm = conexao.prepareStatement(sqlendereco);
            stm.setString(1, filial.getEndereco().getLogradouro());
            stm.setString(2, filial.getEndereco().getBairro());
            stm.setString(3, filial.getEndereco().getCep());
            stm.setString(4, filial.getEndereco().getEstado());
            stm.setString(5, filial.getEndereco().getCidade());
            stm.execute();

            stm.close();
        } catch (SQLException ex) {

            Logger.getLogger(FuncionarioServlet.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    @Override
    public Filial buscarPorId(Integer id) {

        String sql = "SELECT RUA, BAIRRO,CEP,ESTADO,CIDADE,ID_FILIAL, RAZAO_SOCIAL,CNPJ,TELEFONE FROM TB_FILIAL\n"
                + "INNER JOIN TB_ENDERECO ON TB_FILIAL.ID_ENDERECO = TB_ENDERECO.ID_ENDERECO WHERE ID_FILIAL = ?";

        try {

            Connection conexao = Conexao.obterConexao();
            PreparedStatement stm = conexao.prepareStatement(sql);

            stm.setInt(1, id);
            ResultSet resultados = stm.executeQuery();
            while (resultados.next()) {
                Filial filial = new Filial();
                filial.getEndereco().setLogradouro(resultados.getString("RUA"));
                filial.getEndereco().setBairro(resultados.getString("BAIRRO"));
                filial.getEndereco().setCep(resultados.getString("CEP"));
                filial.getEndereco().setEstado(resultados.getString("ESTADO"));
                filial.getEndereco().setCidade(resultados.getString("CIDADE"));
                filial.setId(resultados.getInt("ID_FILIAL"));
                filial.setRazao_social(resultados.getString("RAZAO_SOCIAL"));
                filial.setCnpj(resultados.getString("CNPJ"));
                filial.setTelefone(resultados.getString("TELEFONE"));

                return filial;
            }

        } catch (Exception ex) {

            Logger.getLogger(FilialServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Filial buscarPorNome(String nome) {

        String sql = "SELECT * FROM TB_FILIAL WHERE RAZAO_SOCIAL = ?";

        try {

            Connection conexao = Conexao.obterConexao();
            PreparedStatement stm = conexao.prepareStatement(sql);

            stm.setString(1, nome);

            ResultSet resultados = stm.executeQuery();
            while (resultados.next()) {
                Filial filial = new Filial();
                filial.setRazao_social(resultados.getString("RAZAO_SOCIAL"));
                filial.setCnpj(resultados.getString("CNPJ"));
                filial.setTelefone(resultados.getString("TELEFONE"));

                return filial;
            }

        } catch (Exception ex) {

            Logger.getLogger(FuncionarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public List<Filial> listarTodos() throws PersistenceException, SQLException {

        Statement stmt = null;
        Connection conn = null;

        String sql = "SELECT * FROM TB_FILIAL";
        List<Filial> listafilial = new ArrayList<>();

        try {
            Connection conexao = Conexao.obterConexao();
            PreparedStatement stm = conexao.prepareStatement(sql);
            ResultSet resultados = stm.executeQuery();
            while (resultados.next()) {
                Filial filial = new Filial();
                filial.setId(resultados.getInt("ID_FILIAL"));
                filial.setRazao_social(resultados.getString("RAZAO_SOCIAL"));
                filial.setCnpj(resultados.getString("CNPJ"));
                filial.setTelefone(resultados.getString("TELEFONE"));

                listafilial.add(filial);
            }

        } catch (PersistenceException e) {
            e.printStackTrace();
        }
        return listafilial;
    }

}
