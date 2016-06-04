/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gamestore.controler;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

/**
 *
 * @author rjs
 */
public class ChamadoControler {

    public void enviarEmailChamdo(String email, String comentario) throws EmailException {

        //String emailusuario = request.getParameter("email");
        SimpleEmail simpleemail = new SimpleEmail();
        simpleemail.setHostName("smtp.gmail.com");
        simpleemail.setSmtpPort(465);
        simpleemail.setAuthentication("rkfsystem@gmail.com", "rkfsystemgamestore");
        simpleemail.setSSLOnConnect(true);
        simpleemail.setFrom("rkfsystem@gmail.com");
        simpleemail.setSubject("usuario e senha de acesso ao sistema");
        simpleemail.setMsg(comentario);
        simpleemail.addTo(email);
        simpleemail.send();

    }

}
