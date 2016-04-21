/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gamestore.command;

import javax.persistence.PersistenceException;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author rjs
 */
public class ComandoLogin implements Comando{
    
    public String execute(HttpServletRequest request) throws PersistenceException{
        
        return null;
    }
}
