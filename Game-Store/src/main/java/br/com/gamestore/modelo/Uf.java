/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gamestore.modelo;

import java.io.Serializable;

/**
 *
 * @author rjs
 */
public class Uf implements  Serializable{
    
    private Integer Id_estado;
    private String sigla;
    private String nome;

    /**
     * @return the Id_estado
     */
    public Integer getId_estado() {
        return Id_estado;
    }

    /**
     * @param Id_estado the Id_estado to set
     */
    public void setId_estado(Integer Id_estado) {
        this.Id_estado = Id_estado;
    }

    /**
     * @return the sigla
     */
    public String getSigla() {
        return sigla;
    }

    /**
     * @param sigla the sigla to set
     */
    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
