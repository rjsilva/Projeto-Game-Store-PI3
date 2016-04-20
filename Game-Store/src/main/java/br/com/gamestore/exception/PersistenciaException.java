/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gamestore.exception;

/**
 *
 * @author rjs
 */
public class PersistenciaException extends Exception {

    public PersistenciaException(String erro) {
        super(erro);
    }

    public PersistenciaException(Exception e) {

        super(e);
    }

    public PersistenciaException(String erro, Exception e) {

        super(erro, e);
    }
}
