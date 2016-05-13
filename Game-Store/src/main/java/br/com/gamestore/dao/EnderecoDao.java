/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gamestore.dao;

import br.com.gamestore.Servlet.FuncionarioServlet;
import br.com.gamestore.modelo.Cidade;
import br.com.gamestore.modelo.Uf;
import com.mycompany.gamestore.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rjs
 */
public class EnderecoDao {

    public List<Uf> listarUfs() throws SQLException {

        List<Uf> listaUf = new ArrayList<>();
        try {
            Connection conexao = Conexao.obterConexao();
            String sql = "SELECT * FROM TB_ESTADO";
            PreparedStatement stm = conexao.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Uf uf = new Uf();
                uf.setId(rs.getInt(1));
                uf.setNome(rs.getString(3));

                listaUf.add(uf);
            }
        } catch (Exception ex) {

              Logger.getLogger(FuncionarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaUf;

    }

     public List<Cidade> listarCidades(Integer idEstado) throws SQLException {

        List<Cidade> listaCidades = new ArrayList<>();
        try {
            Connection conexao = Conexao.obterConexao();
            String sql = "SELECT * FROM TB_CIDADE WHERE CODIGO_ESTADO = ?";
            PreparedStatement stm = conexao.prepareStatement(sql);
            stm.setInt(1, idEstado);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Cidade cidade = new Cidade();
                cidade.setId(rs.getInt(1));
                cidade.setNome(rs.getString(2));
                cidade.getUf().setId(3);
                listaCidades.add(cidade);
            }
        } catch (Exception ex) {

              Logger.getLogger(FuncionarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaCidades;

    }
}
