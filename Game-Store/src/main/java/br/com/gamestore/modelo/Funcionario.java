/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gamestore.modelo;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author rjs
 */
public class Funcionario implements Serializable{
    
    private Integer Id_funcionario;
    
    private String nome;
    
    private String email;
    
    private String cpf;
    
    private Date dt_nascimento;
    
    private String telefone;
    
    private Endereco endereco;

    /**
     * @return the Id_funcionario
     */
    public Integer getId_funcionario() {
        return Id_funcionario;
    }

    /**
     * @param Id_funcionario the Id_funcionario to set
     */
    public void setId_funcionario(Integer Id_funcionario) {
        this.Id_funcionario = Id_funcionario;
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
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
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
   
    
}
