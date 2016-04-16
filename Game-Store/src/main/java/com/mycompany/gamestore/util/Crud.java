/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gamestore.util;

import br.com.gamestore.modelo.Acessorio;
import static com.mycompany.gamestore.util.Conexao.obterConexao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rjs
 */
public class Crud {
    
    private Connection conexao;


    public void addPessoa(Acessorio ac) throws SQLException, ClassNotFoundException {

        //seta os parametros de entrada na instrução sql
        String sql = "insert into TB_ACESSORIO(NOME_ACESSORIO, PRECO)"
                + "values(?,?)";
        PreparedStatement stm = conexao.prepareStatement(sql);
        stm.setString(1, ac.getNome());
        stm.setDouble(2, ac.getPreco());
        stm.setDate(5, new java.sql.Date(System.currentTimeMillis()));
        stm.execute();
        stm.close();
        System.out.println("salvo com sucesso!");
    }

    public void listarPessoas() throws SQLException, ClassNotFoundException {
        Statement stmt = null;
        Connection conn = null;

        String sql = "SELECT ID_CONTATO, NM_CONTATO, DT_NASCIMENTO, VL_TELEFONE, VL_EMAIL, DT_CADASTRO FROM TB_CONTATO";
        try {
            conn = obterConexao();
            stmt = conn.createStatement();
            ResultSet resultados = stmt.executeQuery(sql);

            DateFormat formatadorData = new SimpleDateFormat("dd/MM/yyyy");

            while (resultados.next()) {
                Long id = resultados.getLong("ID_CONTATO");
                String nome = resultados.getString("NM_CONTATO");
                Date dataNasc = resultados.getDate("DT_NASCIMENTO");
                String email = resultados.getString("VL_EMAIL");
                String telefone = resultados.getString("VL_TELEFONE");
                String dataCadastro = resultados.getString("DT_CADASTRO");
                System.out.println("Id: " + String.valueOf(id) + "\n" + "Nome:" + nome + "\n" + "Data Nascimento:" + formatadorData.format(dataNasc) + "\n" + "Email:" + email + "\n" + "Telefone:" + telefone
                        + "\n" + "Data do Cadastro:" + dataCadastro);
                System.out.println("------------------------------------------");
            }

        }
        catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            if (stmt != null) {
                try {
                    stmt.close();
                }
                catch (SQLException ex) {
                    Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                }
                catch (SQLException ex) {
                    Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void atualizar(Acessorio ac) throws SQLException, ClassNotFoundException {

        String sql = "update TB_CONTATO set NM_CONTATO=?, DT_NASCIMENTO=?, VL_TELEFONE=?"
                + ", VL_EMAIL=?  where ID_CONTATO=? ";
        PreparedStatement stm = conexao.prepareStatement(sql);
        stm.setString(1, ac.getNome());
        stm.setDouble(2, ac.getPreco());
        stm.execute();
        System.out.println("atualizado com sucesso!");
        stm.close();
    }

    public void excluir(Acessorio ac) throws SQLException, ClassNotFoundException {
        String sql = "delete from TB_CONTATO where ID_CONTATO=?";
        PreparedStatement stm = conexao.prepareStatement(sql);
        stm.setString(1, ac.getNome());
        stm.setDouble(2, ac.getPreco());
        stm.execute();
        stm.close();
        System.out.println("contato excluído com sucesso");
    }
    
}
