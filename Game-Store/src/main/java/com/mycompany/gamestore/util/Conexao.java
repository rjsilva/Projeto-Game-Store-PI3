/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gamestore.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author rjs
 */
public class Conexao {
    /**
     *
     * @author rj
     * @return 
     * @throws java.sql.SQLException
     */
    public static Connection obterConexao() throws SQLException {
        try {
            // Passo 1: Registrar driver JDBC.
            Class.forName("org.apache.derby.jdbc.ClientDataSource");
            //System.out.println("conectado ao banco");
            // Passo 2: Abrir a conexÃ£o
            return DriverManager.getConnection(
                    "jdbc:derby://localhost:1527/gamebd;SecurityMechanism=3",
                    "rjs", // usuario
                    "123"); // senha
        }
        catch (ClassNotFoundException e) {
            throw new SQLException(e.getMessage());
        }
    }

}
