package com.ricardolima.site.services;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

import com.ricardolima.site.models.Email;
import com.ricardolima.site.models.Retorno;

@Service
public class EmailService {

	public Retorno sendEmail(Email email) {

		Retorno retorno = new Retorno("");
		Properties props = new Properties();

		/** Parâmetros de conexão com servidor Gmail */
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props,
				new javax.mail.Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication()
			{
				return new PasswordAuthentication("efa3b1@gmail.com", "33632886");
			}
		});

		/** Ativa Debug para sessão */
		session.setDebug(true);

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(email.getEmail())); //Remetente

			Address[] toUser = InternetAddress //Destinatário(s)
					.parse("ricardoccofg@gmail.com");

			message.setRecipients(Message.RecipientType.TO, toUser);
			message.setSubject(email.getSubject());//Assunto
			message.setText("Nome: " + email.getName() + "\n" +  "Mensagem: " + email.getMessage());

			/**Método para enviar a mensagem criada*/
			Transport.send(message);

			retorno = new Retorno("OK");

		} catch (MessagingException e) {
			retorno = new Retorno(e.getMessage());
		}

		return retorno;
	}
}
