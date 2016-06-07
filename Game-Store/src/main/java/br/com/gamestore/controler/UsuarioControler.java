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
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

/**
 *
 * @author rjs
 */
public class UsuarioControler{

    public boolean validarUsuario(HttpServletRequest request) throws ControleException {

        boolean valido = true;

        try {

            String usuario = request.getParameter("login");
            String senha = request.getParameter("senha");

            Usuario user = new Usuario();
            user.setLogin(usuario);
            user.setSenha(senha);

            UsuarioDao userDao = new UsuarioDao();
            valido = userDao.validarUsuario(user);

        } catch (PersistenciaException e) {
            e.printStackTrace();
            throw new ControleException(e);
        }

        return valido;
    }

    public void enviarEmail(String senha, String emailusuario) throws EmailException {

        
                //String emailusuario = request.getParameter("email");
                SimpleEmail email = new SimpleEmail();
                email.setHostName("smtp.gmail.com");
                email.setSmtpPort(465);
                email.setAuthentication("rkfsystem@gmail.com", "rkfsystemgamestore");
                email.setSSLOnConnect(true);
                email.setFrom("rkfsystem@gmail.com");
                email.setSubject("senha de acesso ao sistema");
                email.setMsg("Senha: " + senha.replaceAll("-","").substring(0,5));
                email.addTo(emailusuario);
                email.send();
        
    }
}
