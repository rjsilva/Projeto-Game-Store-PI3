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
public class Acessorio implements Serializable{
    
    private Integer id;
    
    private String nome;
    
    private String marca;
    
    private double preco;
    
    private String tipo;
    
    private int quantidade;
    
    private int nota_fiscal;
    
    
    public Acessorio(){
        
       
    }
    /**
     * @return the id
     */
    public Integer getid() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setID_Acessorio(Integer id) {
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
     * @return the marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * @return the preco
     */
    public double getPreco() {
        return preco;
    }

    /**
     * @param preco the preco to set
     */
    public void setPreco(double preco) {
        this.preco = preco;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the quantidade
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * @return the nota_fiscal
     */
    public int getNota_fiscal() {
        return nota_fiscal;
    }

    /**
     * @param nota_fiscal the nota_fiscal to set
     */
    public void setNota_fiscal(int nota_fiscal) {
        this.nota_fiscal = nota_fiscal;
    }

    
}
