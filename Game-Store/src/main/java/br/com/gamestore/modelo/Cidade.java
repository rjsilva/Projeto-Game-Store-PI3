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
public class Cidade implements Serializable{
    
    private Integer id;
    
    private String nome;
    
    private Uf uf;
    
    public  Cidade(){
        
        this.uf = new Uf();
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
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

    /**
     * @return the uf
     */
    public Uf getUf() {
        return uf;
    }

    /**
     * @param uf the uf to set
     */
    public void setUf(Uf uf) {
        this.uf = uf;
    }
    
}
