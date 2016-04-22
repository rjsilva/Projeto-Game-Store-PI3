/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gamestore.dao;

import br.com.gamestore.modelo.Uf;
import com.mycompany.gamestore.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.PersistenceException;

/**
 *
 * @author rjs
 */
public class CadastroDao {

    public List<Uf> listarTodos() throws PersistenceException, SQLException {

        List<Uf> lista = new ArrayList<>();
        try {

            Connection conexao = Conexao.obterConexao();

            String sql = "SELECT * TB_ESTADO";

            PreparedStatement stm = conexao.prepareStatement(sql);
            ResultSet resultados = stm.executeQuery();
            
            while (resultados.next()) {
                Uf uf = new Uf();
                uf.setId_estado(resultados.getInt(1));
                uf.setSigla(resultados.getString(2));
                uf.setNome(resultados.getString(3));
                lista.add(uf);
            }

        } catch (PersistenceException e) {
            e.printStackTrace();
        }
        return lista;
    }

}
