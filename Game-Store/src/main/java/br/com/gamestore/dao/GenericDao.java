/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gamestore.dao;

import java.util.List;

/**
 *
 * @author rjs
 */
public interface GenericDao<T>{
    
     void cadastrar(T obj);
     void excluir(T Obj);
     void atualizar(T obj);
     //List<T> listarTodos(T obj);
     T buscarPorId(Integer id);
    
}
