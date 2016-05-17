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
public class Funcionario implements Serializable {

    private Integer id;

    private String nome;

    private String cpf;

    private Date dt_nascimento;

    private String telefone;

    private Endereco endereco;

    private String cargo;
    
    private String local_trabalho;
    
    private Chamado chamado;
    
    private Filial filial;
    
    public Funcionario(){
     
        this.endereco = new Endereco();
        this.filial = new Filial();
        
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
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the dt_nascimento
     */
    public Date getDt_nascimento() {
        return dt_nascimento;
    }

    /**
     * @param dt_nascimento the dt_nascimento to set
     */
    public void setDt_nascimento(Date dt_nascimento) {
        this.dt_nascimento = dt_nascimento;
    }

    /**
     * @return the endereco
     */
    public Endereco getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    /**
     * @return the cargo
     */
    public String getCargo() {
        return cargo;
    }

    /**
     * @param cargo the cargo to set
     */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    /**
     * @return the local_trabalho
     */
    public String getLocal_trabalho() {
        return local_trabalho;
    }

    /**
     * @param local_trabalho the local_trabalho to set
     */
    public void setLocal_trabalho(String local_trabalho) {
        this.local_trabalho = local_trabalho;
    }

    /**
     * @return the chamado
     */
    public Chamado getChamado() {
        return chamado;
    }

    /**
     * @param chamado the chamado to set
     */
    public void setChamado(Chamado chamado) {
        this.chamado = chamado;
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

}
