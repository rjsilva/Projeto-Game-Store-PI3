/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gamestore.controler;

import br.com.gamestore.dao.AcessorioDao;
import br.com.gamestore.dao.GenericDao;
import br.com.gamestore.exception.ControleException;
import br.com.gamestore.modelo.Acessorio;
import com.mycompany.gamestore.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author rjs
 */
public class AcessorioControler implements GenericDao<HttpServletRequest> {

    @Override
    public void cadastrar(HttpServletRequest request) {

        Acessorio ace = new Acessorio();
        AcessorioDao aceDao = new AcessorioDao();
       // String sql = "SELECT ID_ACESSORIO, NOME_ACESSORIO, MARCA, PRECO, TIPO, QUANTIDADE FROM TB_ACESSORIOS";
        try {
//            Connection conexao = Conexao.obterConexao();
//            PreparedStatement stm = conexao.prepareStatement(sql);
//            ResultSet resultados = stm.executeQuery();
//            while () {
//                String nome = request.getParameter("nomeacessorio");
//                String marca = request.getParameter("marca");
//                String preco = request.getParameter("preco");
//                Double preco2 = Double.parseDouble(preco);
//                String tipo = request.getParameter("tipo");
//                String quantidade = request.getParameter("quantidade");
//                Integer quant = Integer.parseInt(quantidade);
//            }

        } catch (PersistenceException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void excluir(HttpServletRequest request) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizar(HttpServletRequest obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Acessorio> listarTodos(HttpServletRequest request) {
        Acessorio ace = new Acessorio();
        AcessorioDao aceDao = new AcessorioDao();

        List<Acessorio> lista = new ArrayList<>();
        try {
            String nome = request.getParameter("acessorio");
            String marca = request.getParameter("marca");
            String preco = request.getParameter("preco");
            Double preco2 = Double.parseDouble(preco);
            String tipo = request.getParameter("tipo");
            String quantidade = request.getParameter("quantidade");
            Integer quant = Integer.parseInt(quantidade);

            ace.setNome(nome);
            ace.setMarca(marca);
            ace.setPreco(preco2);
            ace.setTipo(tipo);
            ace.setQuantidade(quant);
           // aceDao.cadastrar(ace);

        } catch (PersistenceException e) {
            e.printStackTrace();
        }

        return lista;
    }

    @Override
    public HttpServletRequest buscarPorId(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
