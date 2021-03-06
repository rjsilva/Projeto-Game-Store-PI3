/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gamestore.modelo;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author rjs
 */
public class Venda implements Serializable{
    
    private Long id;
    
    private Date dtvenda;
    
    private int quantidade;
    
    private double totalvenda;
    
    private Filial filial;
    
    private Funcionario funcionario;
    
    private Acessorio acessorio;
    
    private Usuario usuario;
    
    public Venda(){
        
        this.acessorio = new Acessorio();
        this.funcionario = new Funcionario();
        this.filial = new Filial();
        this.usuario = new Usuario();
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the dtvenda
     */
    public Date getDtvenda() {
        return dtvenda;
    }

    /**
     * @param dtvenda the dtvenda to set
     */
    public void setDtvenda(Date dtvenda) {
        this.dtvenda = dtvenda;
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
     * @return the filial
     */
    public Filial getFilial() {
        return filial;
    }

    /**
     * @param filial the filial to set
     */
    public void setFilial(Filial filial) {
        this.filial = filial;
    }

    /**
     * @return the funcionario
     */
    public Funcionario getFuncionario() {
        return funcionario;
    }

    /**
     * @param funcionario the funcionario to set
     */
    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    /**
     * @return the acessorio
     */
    public Acessorio getAcessorio() {
        return acessorio;
    }

    /**
     * @param acessorio the acessorio to set
     */
    public void setAcessorio(Acessorio acessorio) {
        this.acessorio = acessorio;
    }

    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the totalvenda
     */
    public double getTotalvenda() {
        return totalvenda;
    }

    /**
     * @param totalvenda the totalvenda to set
     */
    public void setTotalvenda(double totalvenda) {
        this.totalvenda = totalvenda;
    }
    
    
}
