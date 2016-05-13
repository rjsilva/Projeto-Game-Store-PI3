/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gamestore.dao;

import br.com.gamestore.Servlet.FuncionarioServlet;
import br.com.gamestore.modelo.Filial;
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

/**
 *
 * @author rjs
 */
public class FilialDao implements GenericDao<Filial> {

    @Override
    public void cadastrar(Filial filial) {
        try {
            Connection conexao = Conexao.obterConexao();

            Integer codEndereco = null;

            String sqlendereco = "INSERT INTO TB_ENDERECO(RUA, BAIRRO, CEP)"
                    + " VALUES(?,?,?)";
            PreparedStatement stmendereco = conexao.prepareStatement(sqlendereco, Statement.RETURN_GENERATED_KEYS);

            stmendereco.setString(1, filial.getEndereco().getRua());
            stmendereco.setString(2, filial.getEndereco().getBairro());
            stmendereco.setString(3, filial.getEndereco().getCep());

            stmendereco.executeUpdate();

            ResultSet rs = stmendereco.getGeneratedKeys();
            if (rs.next()) {

                codEndereco = rs.getInt(1);
            }

            String sqlfilial = "INSERT INTO TB_FILIAL(ID_ENDERECO, RAZAO_SOCIAL,CNPJ, TELEFONE)"
                    + "values(?,?,?,?)";
            PreparedStatement stmfilial = conexao.prepareStatement(sqlfilial, Statement.RETURN_GENERATED_KEYS);
            stmfilial.setInt(1, codEndereco);
            stmfilial.setString(2, filial.getRazao_social());
            stmfilial.setString(3, filial.getCnpj());
            stmfilial.setString(4, filial.getTelefone());
            stmfilial.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void excluir(Filial Obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizar(Filial obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Filial buscarPorId(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public List<Filial> buscarPorNome() {

        String sql = "SELECT RAZAO_SOCIAL FROM TB_FILIAL";

        List<Filial> listaFilial = new ArrayList<>();

        try {

            Connection conexao = Conexao.obterConexao();
            PreparedStatement stm = conexao.prepareStatement(sql);
            ResultSet resultados = stm.executeQuery();
            while (resultados.next()) {
                Filial filial = new Filial();
                filial.setRazao_social(resultados.getString("RAZAO_SOCIAL"));
                listaFilial.add(filial);
            }

        } catch (Exception ex) {

            Logger.getLogger(FuncionarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaFilial;
    }

}
