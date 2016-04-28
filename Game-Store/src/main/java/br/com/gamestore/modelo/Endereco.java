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
public class Endereco implements Serializable{
    
    private Integer Id_endereco;
    
    private String rua;
    
    private String bairro;
    
    private String cep;
    

    /**
     * @return the Id_endereco
     */
    public Integer getId_endereco() {
        return Id_endereco;
    }

    /**
     * @param Id_endereco the Id_endereco to set
     */
    public void setId_endereco(Integer Id_endereco) {
        this.Id_endereco = Id_endereco;
    }

    /**
     * @return the rua
     */
    public String getRua() {
        return rua;
    }

    /**
     * @param rua the rua to set
     */
    public void setRua(String rua) {
        this.rua = rua;
    }

    /**
     * @return the bairro
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * @param bairro the bairro to set
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }


    /**
     * @return the cep
     */
    public String getCep() {
        return cep;
    }

    /**
     * @param cep the cep to set
     */
    public void setCep(String cep) {
        this.cep = cep;
    }

}
