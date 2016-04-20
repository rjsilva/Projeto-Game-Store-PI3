/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gamestore.controler;

import br.com.gamestore.dao.UsuarioDao;
import br.com.gamestore.exception.ControleException;
import br.com.gamestore.exception.PersistenciaException;
import br.com.gamestore.modelo.Usuario;
import javax.servlet.http.HttpServletRequest;
import javax.swing.JOptionPane;

/**
 *
 * @author rjs
 */
public class UsuarioControler {

    public boolean validarUsuario(HttpServletRequest request) throws ControleException {

        boolean valido = true;

        try {

            String usuario = request.getParameter("login");
            String senha = request.getParameter("senha");

            Usuario user = new Usuario();
            user.setUsuario(usuario);
            user.setSenha(senha);

            UsuarioDao userDao = new UsuarioDao();
            valido = userDao.validarUsuario(user);

        } catch (PersistenciaException e) {
            e.printStackTrace();
            throw new ControleException(e);
        }

        return valido;
    }

}
