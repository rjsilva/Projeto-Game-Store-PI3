/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gamestore.controler;

import br.com.gamestore.dao.UsuarioDao;
import br.com.gamestore.modelo.Usuario;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author rjs
 */
public class UsuarioControler {

    public boolean validarUsuario(HttpServletRequest request) {

        boolean valido = true;
        Usuario user = new Usuario();
        UsuarioDao userDao = new UsuarioDao();
        try {
            String usuario = request.getParameter("usuario");
            String senha = request.getParameter("senha");
            
            user.setUsuario(usuario);
            user.setSenha(senha);
            
            userDao.validarUsuario(user);

        } catch (Exception e) {

            e.printStackTrace();
        }

        return valido;
    }

}
